package tp2java;
import java.util.Scanner;

public class TabInt {
	
	
	
	public static int[] creeEtRemplir(int n) {
		
		Scanner sc = new Scanner(System.in);
	    int[] t = new int[n];
		for (int i = 0; i<n; i++) {
			System.out.printf("entrer T["+(i+1)+"] :");
			t[i] = sc.nextInt();
			
		}
		return t;
	}
	
	
	public static void afficher (int[] t) {
	        System.out.print("[ ");
	        for (int i = 0; i < t.length; i++) {
	            System.out.print(t[i]);
	            if (i < t.length - 1) {
	                System.out.print(", ");
	            }
	        }
	        System.out.println(" ]");
	    }
	
	public static float moyenne(int[] t) {
		int s = 0;
		for (int i =0; i < t.length; i++) {
			s += t[i];
		}
		return (s/t.length);
	}


   public static int[] supprimer(int[] t) {
	   Scanner sc = new Scanner(System.in);
	   System.out.println("Donner la position du supprission : ");
		   int p = sc.nextInt();
		   int[] tn = new int[t.length-1];
		   if (p > 0 && p < t.length ) {
			   
			   int j = 0;
			   for (int i = 0; i<t.length; i++) {
				   if (i != p) {
					   tn[j] = t[i];
					   j++;
				   }
				      
				   
			   }
		   }
		   else {
			   
			   for (int i = 0; i<t.length - 1; i++) {
					   tn[i] = t[i];
					   
				   }
		   }
		   return tn;
   }



public static int[] inserer(int[] t) {
	   Scanner sc = new Scanner(System.in);
	   
	   System.out.println("Donner le nouveau entier : ");
	   int ep = sc.nextInt();
	   System.out.println("Donner la position de l'insertion : ");
	   int p = sc.nextInt();
		   
		   int[] tn = new int[t.length+1];
		  
			   int j = 0;
			   for (int i = 0; i<tn.length; i++) {
				   if (i != p) {
					   tn[i] = t[j];
					   j++;
				   }
				   else { tn[i] = ep;}
						   
				      

			   }
			   return tn;
}


public static int produitScalaire(int[] t1, int[] t2) {
	
	int s = 0;
	if (t1.length != t2.length) {
		System.out.println("on ne peut pas faire un produit scalaire entre deux tableaux de taille different!");
	}
	else {
	for (int i = 0; i < t1.length; i++ ) {
		s += t1[i] * t2[i]; 
		
	}
	
	
}
	return s;
	
}
}

		

    
    
    
   


