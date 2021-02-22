package pack2;

public class Main {

    public static void main(
        final String[] args) {

        System.out.println(new MyClass1(new MySQLConnDBServer().getConnection()).ConnId());

    }
    // Connection avec geter
}
