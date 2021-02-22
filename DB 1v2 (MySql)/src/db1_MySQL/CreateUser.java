package db1_MySQL;

import java.sql.* ;


public class CreateUser {

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
					 "GRANT SELECT,INSERT,UPDATE,DELETE," +
					 "CREATE,DROP " +
					 "ON EMP.* TO 'hrsysuser'@'localhost' " +
					 "IDENTIFIED BY 'hrsysuser';");	
			 stmt.close();
			 con.close();			 			 
		}
		catch( Exception e ) {
			 e.printStackTrace();
		}
	}//end main
}//end class 


