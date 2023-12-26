package wiss;
public class Test1 {
    public static void main(String[] args) {
        System.out.println("main : début");
        Except1 ex = new Except1();
        String[] input1 = {"10", "11", "15", "20", "10"};
        ex.methodeA(input1);
        System.out.println("main : fin");
    }
}
