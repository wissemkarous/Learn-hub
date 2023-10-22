package tp2java;

public class Test {
	
public static void main(String args[]) {
		
		
		int[] t = TabInt.creeEtRemplir(5);
		TabInt.afficher(t);		
		System.out.println("la moyenne est : " + TabInt.moyenne(t));
		TabInt.afficher((TabInt.supprimer(TabInt.inserer(t))));
		System.out.println(TabInt.produitScalaire(t,(TabInt.supprimer(TabInt.inserer(t)))));
		
	}
}


