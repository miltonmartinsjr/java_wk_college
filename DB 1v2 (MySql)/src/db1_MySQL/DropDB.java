package db1_MySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DropDB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			 // 
		     Class.forName("com.mysql.jdbc.Driver");
		     //
			 String url = "jdbc:mysql://localhost:3306/EMP";
			 Connection con = DriverManager.getConnection(
					          url,"root", "root");
			 //
			 System.out.println("URL: " + url);
			 System.out.println("Connection: " + con);
			 //
			 Statement stmt;
			 stmt = con.createStatement();			 		 
			 stmt.executeUpdate(
					 "DROP DATABASE IF EXISTS EMP");	
			 stmt.close();
			 con.close();
		}
		catch( Exception e ) {
			 e.printStackTrace();
		}
	}//end main
}//end class 