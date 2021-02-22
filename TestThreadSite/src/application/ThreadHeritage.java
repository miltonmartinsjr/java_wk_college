package application;

public class ThreadHeritage
    extends Thread {

    public ThreadHeritage(final String name) {

        super(name);

    }

    public void run() {

        for (int i = 0; i < 10; i++) {
            System.out.println(this.getName());

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}
