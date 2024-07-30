import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Compte {
    private Personne proprietaire;
    private final long numero; // Immutable
    private double solde;
    private static long compteur;
    private List<Transaction> historique = new ArrayList<>();
    public boolean virementOff = true;

    public Compte(Personne proprietaire, double solde) {
        this.proprietaire = proprietaire;
        this.numero = ++compteur;
        this.solde = solde;
    }

    public Personne getProprietaire() {return proprietaire;}
    public void setProprietaire(Personne proprietaire) {this.proprietaire = proprietaire;}

    public long getNumero() {return numero;}
    //public void setNumero(long numero) {this.numero = numero;}

    public double getSolde() {return solde;}
    public void setSolde(double solde) {this.solde = solde;}

    public void retirer(double montant) {
        if (montant <= solde) {
            solde -= montant;
            if (virementOff) {
                ajouterTransaction(new Transaction("Retrait", montant, new Date(), "Retrait d'argent"));
                System.out.println(getClass().getSimpleName() + " : Retrait de " + montant + " effectué. Nouveau solde : " + solde);
            }
        } else {
            if (virementOff) {
                System.out.println("Retrait de " + montant + "€ impossible, solde insuffisant.");
            }
        }
    }

    public void credit(double montant) {
        solde += montant;
        if (virementOff) {
            ajouterTransaction(new Transaction("Crédit", montant, new Date(), "Crédit d'argent"));
            System.out.println(getClass().getSimpleName() + " : Crédit de " + montant + " effectué. Nouveau solde : " + solde);
        }
    }
    public void virement(Compte destination, double montant) {
        virementOff = false;
        if (montant <= solde) {
            this.retirer(montant);
            destination.credit(montant);
            ajouterTransaction(new Transaction("Virement", montant, new Date(), "Virement d'argent"));
            System.out.println("Virement de " + montant + " vers le compte numéro " + destination.getNumero() + " effectué.");
        } else {
            System.out.println("Virement impossible, solde insuffisant.");
        }
        virementOff = true;
    }

    private void ajouterTransaction(Transaction transaction) {historique.add(transaction);}
    public List<Transaction> getHistorique() {return historique;}

    @Override
    public String toString() {
        return "Compte { " +
                "propriétaire = " + proprietaire +
                ", numéro = " + numero +
                ", solde = " + solde +
                " }";
    }
}
