package tp3Java;

public class Batiment {
     String adresse;
     double surfaceHabitable;
     Proprietaire proprietaire;

    public Batiment(String adresse, double surfaceH, Proprietaire proprietaire) {
        this.adresse = adresse;
        this.surfaceHabitable = surfaceH;
        this.proprietaire = proprietaire;
    }

    public String toString() {
    	return "Adresse : " + adresse + ", Surface habitable : " + surfaceHabitable + ", " + proprietaire.toString();
    }
  }
