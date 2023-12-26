package tp3Java;

class Locataire extends Personne {
    public Locataire(String numeroSocial, String nom, String prenom) {
        super(numeroSocial, nom, prenom);
    }

    public String toString() {
        return "Locataire : " + prenom + " " + nom + ", Numéro social : " + numeroSocial;
    }
}