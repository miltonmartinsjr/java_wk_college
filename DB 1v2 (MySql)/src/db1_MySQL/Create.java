package db1_MySQL;

import java.sql.* ;


public class Create {

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
					 "CREATE DATABASE EMP");
			 stmt.close();
			 con.close();
			 //
			 url = "jdbc:mysql://localhost:3306/EMP";
			 con = DriverManager.getConnection(
			          url,"root", "root");
			 //
			 System.out.println("URL: " + url);
			 System.out.println("Connection: " + con);
			 //	 
	         stmt = con.createStatement();			 
			 stmt.executeUpdate(
					 "CREATE TABLE COMPANY " +
			         "(ID INT PRIMARY KEY     NOT NULL," +
			         " NAME           TEXT    NOT NULL, " + 
			         " AGE            INT     NOT NULL, " + 
			         " ADDRESS        CHAR(50), " + 
			         " SALARY         REAL)");	
	   //   Pas deux CREATE dans un stmt.executeUpdate()	 
	   /*      stmt.executeUpdate(
					 "CREATE TABLE COMPANY " +
			         "(ID INT PRIMARY KEY     NOT NULL," +
			         " NAME           TEXT    NOT NULL, " + 
			         " AGE            INT     NOT NULL, " + 
			         " ADDRESS        CHAR(50), " + 
			         " SALARY         REAL); "+
			         "CREATE TABLE COMPANY2 " +
			         "(ID INT PRIMARY KEY     NOT NULL," +
			         " NAME           TEXT    NOT NULL, " + 
			         " AGE            INT     NOT NULL, " + 
			         " ADDRESS        CHAR(50), " + 
			         " SALARY         REAL); "
			         );
	     */
			 stmt.close();
			 con.close();
		}
		catch( Exception e ) {
			 e.printStackTrace();
		}
	}//end main
}//end class 


