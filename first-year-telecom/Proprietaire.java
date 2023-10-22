package tp3Java;

class Proprietaire extends Personne {
    public Proprietaire(String numeroSocial, String nom, String prenom) {
        super(numeroSocial, nom, prenom);
    }

    public String toString() {
        return "Propriétaire : " + prenom + " " + nom + ", Numéro social : " + numeroSocial;
    }
}