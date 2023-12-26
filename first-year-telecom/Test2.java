package wiss;

public class Test2 {
    public static void main(String[] args) {
        System.out.println("main : début");
        Except1 ex = new Except1();
        String[] input2 = {"10", "11"};
        ex.methodeA(input2);
        System.out.println("main : fin");
    }
}
