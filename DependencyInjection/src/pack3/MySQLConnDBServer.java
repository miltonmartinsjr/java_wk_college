package pack3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnDBServer {

    public Connection con;

    public MySQLConnDBServer() {

        try {
            Class.forName("com.mysql.jbdc.Driver");

            String url = "jdbc:mysql://localhost:3306";
            this.con = DriverManager.getConnection(url, "root", "root");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
