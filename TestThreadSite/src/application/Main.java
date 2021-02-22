package application;

public class Main {

    public static void main(
        final String[] args) {

        ThreadHeritage t001 = new ThreadHeritage("A");
        Heritage02 t002 = new Heritage02(" cB");

        t002.setPriority(1);
        t001.start();
        t002.start();

    }

}
