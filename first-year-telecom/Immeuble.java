package tp3Java;

public class Immeuble extends Batiment {
    private int nbAppart;
    private Locataire locataire;

    public Immeuble(String adresse, double surfaceH, int nbAppart, Proprietaire proprietaire) {
        super(adresse, surfaceH, proprietaire);
        this.nbAppart = nbAppart;
        this.locataire = null;
    }

    public void louer(Locataire locataire) {
        this.locataire = locataire;
    }

    public void liberer() {
        this.locataire = null;
    }

    public String toString() {
        String infoLocataire = "Non loué";
        if (locataire != null) {
            infoLocataire = locataire.toString();
        }
        return "Immeuble : " + super.adresse + ", Surface habitable : " + super.surfaceHabitable + "m², Propriétaire : " + super.proprietaire + ", Nombre d'appartements : " + nbAppart + ", Locataire : " + infoLocataire;
    }
}