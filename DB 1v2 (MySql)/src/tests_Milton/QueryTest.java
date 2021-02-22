package tests_Milton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class QueryTest {

    public static List<EMP> EmpList = new ArrayList<>();

    public static void main(
        final String[] args) {

        try {

            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/EMP";
            Connection conec = DriverManager.getConnection(url, "root", "");
            //
            System.out.println("URL: " + url);
            System.out.println("Connection: " + conec);
            System.out.println();
            //
            Statement stmt;
            stmt = conec.createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM COMPANY");

            while (res.next()) {
                EMP anEMP = new EMP();
                anEMP.id = res.getInt("id");
                anEMP.name = res.getString("name");
                anEMP.age = res.getInt("age");
                anEMP.address = res.getString("address");
                anEMP.salary = res.getFloat("salary");
                QueryTest.EmpList.add(anEMP);

            }
            res.close();
            stmt.close();
            conec.close();

            for (EMP e : QueryTest.EmpList) {
                System.out.println("ID = " + e.id);
                System.out.println("Name = " + e.name);
                System.out.println("Age = " + e.age);
                System.out.println("Adress = " + e.address);
                System.out.println("Salary = " + e.salary);
                System.out.println();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

class EMP {
    public String address;

    public int age;

    public int id;

    public String name;

    public float salary;

    public EMP() {

    }

    public EMP(
        final int id,
        final String name,
        final int age,
        final String address,
        final float salary) {

        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.salary = salary;
    }

}
