public class CompteCourant extends Compte {

    private double decouvert;

    public CompteCourant(Personne proprietaire, long numero, double solde, double decouvert) {
        super(proprietaire, solde);
        this.decouvert = decouvert;
    }

    public double getDecouvert() {return decouvert;}
    public void setDecouvert(double decouvert) {this.decouvert = decouvert;}

    public void retirer(double montant) {
        if (this.getSolde() - montant >= -decouvert) {
            this.setSolde(getSolde()-montant);
            if (virementOff) {
                System.out.println("Retrait effectué. Nouveau solde : " + this.getSolde());
            }
        } else {
            if (virementOff) {
                System.out.println("Retrait de " + montant + "€ impossible, solde insuffisant.");
            }
        }
    }
}
