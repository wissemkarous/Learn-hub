package wiss;

public class Except1 {

	public void methodeA(String args[]) {

	    System.out.println(" methodeA : debut");

	    try {

	        System.out.println(" methodeA : appel de methodeB");

	        this.methodeB(args);

	        System.out.println(" methodeA : retour de methodeB");

	    if (args.length > 4)

	        throw new Exception();

	    }

	    catch (Exception e) {

	        System.out.println(" methodeA : afficher : "+ e);

	    }

	    finally

	    {

	        System.out.println(" methodeA : execute finally");

	    }

	        System.out.println(" methodeA : fin");

	}

	 

	public void methodeB(String args[]) {

	    System.out.println(" methodeB : debut");

	    try {

	        System.out.println(" methodeB : tente d’acceder a args[2]");

	        String s = args[2];

	        int x=Integer.parseInt(s);

	        System.out.println(" methodeB : a reussi a acceder a args[2]");

	    }

	    catch (ArrayIndexOutOfBoundsException e) {

	        System.out.println(" methodeB : capture : "+ e);

	    }

	    catch (NumberFormatException e) {

	        System.out.println(" number "+ e);

	    }

	    catch (Exception e) {

	        System.out.println(" exceptionnnnnn : "+ e);

	    }

	  

	    finally {

	        System.out.println(" methodeB : execute finally");

	    }

	        System.out.println(" methodeB : fin");

	    }

	 

	public static void main(String args[]) {

	    System.out.println("main : debut");

	    Except1 ex = new Except1();

	    try {

	        System.out.println("main : appel de methodeA");

	        ex.methodeA(args);

	        System.out.println("main : retour de methodeA");

	        }

	    catch (Exception e) {

	        System.out.println("main : capture : "+e);

	    }

	    System.out.println("main : fin");

	    }

	}



