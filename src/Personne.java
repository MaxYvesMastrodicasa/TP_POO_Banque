enum EtatCivil {
    CELIBATAIRE,
    MARIE,
    DIVORCE,
    VEUF
}

public class Personne {
    private String prenom;
    private String nom;
    private EtatCivil etatCivil;

    public Personne() {}

    public Personne(String prenom, String nom, EtatCivil etatCivil) {
        this.prenom = prenom;
        this.nom = nom;
        this.etatCivil = etatCivil;
    }

    public String getPrenom() {return prenom;}
    public void setPrenom(String prenom) {this.prenom = prenom;}

    public String getNom() {return nom;}
    public void setNom(String nom) {this.nom = nom;}

    public EtatCivil getEtatCivil(){return etatCivil;}
    public void setEtatCivil(EtatCivil etatCivil){
        this.etatCivil = etatCivil;}

    @Override
    public String toString() {
        return prenom + " " + nom + " (" + etatCivil + ")";
    }
}
