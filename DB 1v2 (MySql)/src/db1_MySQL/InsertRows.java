package db1_MySQL;

import java.sql.* ;

public class InsertRows {

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
			 con.setAutoCommit(false);
			 Statement stmt;
			 stmt = con.createStatement();
			 stmt.executeUpdate(
					 "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) " +
					 "VALUES (2, 'Allen', 25, 'Texas', 15000.00 )");
			 stmt.executeUpdate(
					 "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) " +
			         "VALUES (1, 'Paul', 32, 'California', 20000.00 )");
			 stmt.executeUpdate(
					 "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) " +
					 "VALUES (3, 'Teddy', 23, 'Norway', 20000.00 )");
			 stmt.executeUpdate(
					 "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) " +
					 "VALUES (4, 'Mark', 25, 'Rich-Mond ', 65000.00 )");	
			 stmt.close();
			 con.commit();
			 con.close();
		}
		catch( Exception e ) {
			 e.printStackTrace();
		}
	}//end main
}//end class 


