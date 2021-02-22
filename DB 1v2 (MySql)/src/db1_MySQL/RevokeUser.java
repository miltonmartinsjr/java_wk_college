package db1_MySQL;

import java.sql.* ;


public class RevokeUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			 // 
		     Class.forName("com.mysql.jdbc.Driver");
		     //
			 String url = "jdbc:mysql://localhost:3306/";
			 Connection con = DriverManager.getConnection(
					          url,"root", "root");
			 //
			 System.out.println("URL: " + url);
			 System.out.println("Connection: " + con);
			 //
			 Statement stmt;
			 stmt = con.createStatement();
			 stmt.executeUpdate(
					 "REVOKE ALL PRIVILEGES ON *.* " +
					 "FROM 'hrsysuser'@'localhost'");
			 stmt.executeUpdate(
					 "REVOKE GRANT OPTION ON *.* " +
					 "FROM 'hrsysuser'@'localhost'");
			 stmt.executeUpdate("DROP USER 'hrsysuser'@'localhost'");
			/* stmt.executeUpdate(
					 "DELETE FROM mysql.user WHERE " +
					 "User='hrsysuser' and Host='localhost'");
			 stmt.executeUpdate("FLUSH PRIVILEGES"); */
			 stmt.close();
			 con.close();			 			 
		}
		catch( Exception e ) {
			 e.printStackTrace();
		}
	}//end main
}//end class 


