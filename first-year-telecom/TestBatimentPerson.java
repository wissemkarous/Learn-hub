package tp3Java;

public class TestBatimentPerson {
	
	public static void main(String[] args) {
        Proprietaire p1 = new Proprietaire("453487894", "Triki", "Ismail");
        Proprietaire p2 = new Proprietaire("123698541", "Karous", "Wissem");
        Proprietaire p3 = new Proprietaire("564684132", "Yousfi", "Hani");

        Batiment b = new Batiment("batiment ", 100.0, p1);
        Maison m = new Maison("maison ", 150.0, 50.0, 5, p2);
        Immeuble i = new Immeuble("immeuble", 500.0, 10, p3);
        
        System.out.println(b);
        System.out.println(m);
        System.out.println(i);
        
	}

}
