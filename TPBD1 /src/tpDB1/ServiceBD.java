package tpDB1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ServiceBD {

    private Connection conn;

    private final String DB_URL = "jdbc:mysql://localhost:3306/college";// changer
                                                                        // la
                                                                        // base
                                                                        // donnee
    // Nom du pilote JDBC et URL de la base de donnÃ©es

    private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

    private final String PASS = ""; // ou PASS="";

    private ResultSet rs;

    private Statement stmt;

    // Identifiants de la base de donnÃ©es
    private final String USER = "root";

    public ServiceBD() {

        ConnectBD();
    }

    public void close() {

        try {
            this.stmt.close();
            this.conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public ArrayList<ArrayList<Object>> executeQuery(
        final String sql) {

        ArrayList<ArrayList<Object>> lignes = new ArrayList<>();

        try {
            this.rs = this.stmt.executeQuery(sql);
            ResultSetMetaData meta = this.rs.getMetaData();
            int colCount = meta.getColumnCount();
            while (this.rs.next()) {
                ArrayList<Object> ligne = new ArrayList<>();
                for (int col = 1; col <= colCount; col++) {
                    ligne.add(this.rs.getObject(col));
                }
                lignes.add(ligne);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return lignes;
    }

    public int executeUpdate(
        final String sql) {

        int result;
        try {
            result = this.stmt.executeUpdate(sql);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            result = -1;
            e.printStackTrace();
        }
        return result;
    }

    private void ConnectBD() {

        try {

            // Enregister le pilote JDBC
            Class.forName(this.JDBC_DRIVER);

            // Ouvrir une connection
            this.conn = DriverManager.getConnection(this.DB_URL, this.USER, this.PASS);

            // CrÃ©ation de la dÃ©claration;
            this.stmt = this.conn.createStatement();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println("Sans connection à la base de données.");
            System.out.println("Avez vous oublié de démarrer le serveur de base de donées ?");
            System.out.println();
            e.printStackTrace();
        }
    }

}
