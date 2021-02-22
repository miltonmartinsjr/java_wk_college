package db1_MySQL;

import java.sql.* ;

public class Update {

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
			 
			 stmt.executeUpdate("UPDATE COMPANY set SALARY = 25000.00 where ID=1");
		     // con.commit();
		     
		     stmt.executeUpdate("DELETE from COMPANY where ID=2;");
		     con.commit();
			 			 
			 ResultSet rs = stmt.executeQuery( "SELECT * FROM COMPANY" );
		      while ( rs.next() ) {
		         int id = rs.getInt("id");
		         String  name = rs.getString("name");
		         int age  = rs.getInt("age");
		         String  address = rs.getString("address");
		         float salary = rs.getFloat("salary");
		         System.out.println( "ID = " + id );
		         System.out.println( "NAME = " + name );
		         System.out.println( "AGE = " + age );
		         System.out.println( "ADDRESS = " + address );
		         System.out.println( "SALARY = " + salary );
		         System.out.println();
		      }
		      rs.close();
		      stmt.close();
		      con.close();
		}
		catch( Exception e ) {
			 e.printStackTrace();
		}
	}//end main
}//end class 
