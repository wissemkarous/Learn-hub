package wiss;

public class Test3 {
    public static void main(String[] args) {
        System.out.println("main : début");
        Except1 ex = new Except1();
        String[] input3 = {"10", "11", "z", "12"};
        ex.methodeA(input3);
        System.out.println("main : fin");
    }
}
