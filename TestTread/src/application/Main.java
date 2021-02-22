package application;

public class Main {

    public static void main(
        final String[] args) {

        Test01 t = new Test01("A");
        Test01 t2 = new Test01("  B");
        t.start();
        t2.start();

    }

}
