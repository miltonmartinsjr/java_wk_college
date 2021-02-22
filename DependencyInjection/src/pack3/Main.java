package pack3;

public class Main {

    public static void main(
        final String[] args) {

        MyClass1 c = new MyClass1();
        c.set(new MySQLConnDBServer().con);
        System.out.println(c.ConnId());

    }
    // Connection avec seter
}
