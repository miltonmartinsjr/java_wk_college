package application;

public class Heritage02
    extends Thread {

    public Heritage02(final String name) {

        super(name);

    }

    public void run() {

        for (int i = 0; i < 10; i++) {
            System.out.println(this.getName());

        }
    }

}
