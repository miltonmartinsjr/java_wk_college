package application;

public class Test01
    extends Main {

    public Test01(final String name) {

        super(name);
    }

    public void run() {

        for (int i = 0; i < 10; i++) {
            System.out.println(this.getName());
        }
    }

}
