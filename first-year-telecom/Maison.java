package tp3Java;

public class Maison extends Batiment {
    private int nbPieces;
    private double surfaceJardin;

    public Maison(String adresse, double surfaceH, double surfaceJ, int nbPieces, Proprietaire proprietaire) {
        super(adresse, surfaceH, proprietaire);
        this.nbPieces = nbPieces;
        this.surfaceJardin = surfaceJ;
    }

    @Override
    public String toString() {
        return "Maison : " + super.adresse + ", Surface habitable : " + super.surfaceHabitable + "m², Propriétaire : " + super.proprietaire + ", Nombre de pièces : " + nbPieces + ", Surface du jardin : " + surfaceJardin + "m²";
    }
}