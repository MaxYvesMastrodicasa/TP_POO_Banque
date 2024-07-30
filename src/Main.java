import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Personne personne = new Personne("Martin","Dupont",EtatCivil.MARIE);
        CompteEpargne compteEpargne = new CompteEpargne(personne, 123456789, 1000.0,0.02);
        CompteCourant compteCourant = new CompteCourant(personne, 987654321, 1000.0,200.0);
        System.out.println(personne.toString());
        System.out.println("Solde compte courant : " + compteCourant.getSolde());
        System.out.println("Solde compte epargne : " + compteEpargne.getSolde());
        compteEpargne.virement(compteCourant,100);
        compteCourant.retirer(1500);
        compteCourant.virement(compteEpargne,1200);
        System.out.println(compteCourant.getHistorique());
        System.out.println(compteEpargne.getHistorique());
    }
}
