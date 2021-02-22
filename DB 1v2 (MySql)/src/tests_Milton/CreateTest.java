package tests_Milton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTest {

    public static void main(
        final String[] args) {
        // TODO Auto-generated method stub

        try {
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/";
            Connection con = DriverManager.getConnection(url, "root", "");

            System.out.println("URL: " + url);
            System.out.println("Connection: " + con);

            Statement stmt;
            stmt = con.createStatement();
            stmt.executeUpdate("CREATE DATABASE EMP");
            stmt.close();
            con.close();

            url = "jdbc:mysql://localhost:3306/EMP";
            con = DriverManager.getConnection(url, "root", "");

            System.out.println("URL: " + url);
            System.out.println("Connection: " + con);

            stmt = con.createStatement();
            stmt.executeUpdate(
                "CREATE TABLE COMPANY "
                    + "(ID INT PRIMARY KEY     NOT NULL,"
                    + " NAME           TEXT    NOT NULL, "
                    + " AGE            INT     NOT NULL, "
                    + " ADDRESS        CHAR(50), "
                    + " SALARY         REAL)");

            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
