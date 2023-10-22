package tp3Java;

public abstract class Personne {
  String numeroSocial;
  String nom;
  String prenom;

 public Personne(String numeroSocial, String nom, String prenom) {
     this.numeroSocial = numeroSocial;
     this.nom = nom;
     this.prenom = prenom;
 }

 public String getNumeroSocial() {
     return numeroSocial;
 }

 public void setNumeroSocial(String numeroSocial) {
     this.numeroSocial = numeroSocial;
 }

 public String getNom() {
     return nom;
 }

 public void setNom(String nom) {
     this.nom = nom;
 }

 public String getPrenom() {
     return prenom;
 }

 public void setPrenom(String prenom) {
     this.prenom = prenom;
 }

 public abstract String toString();
}