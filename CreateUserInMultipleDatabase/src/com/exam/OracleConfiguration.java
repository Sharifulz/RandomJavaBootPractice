package com.exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class OracleConfiguration {

	public static void main(String args[]){  
		try{  
		//step1 load the driver class  
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		  
		//step2 create  the connection object  
		Connection con=DriverManager.getConnection(  
		"jdbc:oracle:thin:@localhost:1521:orcl","system","root");  
		  
		//step3 create the statement object  
		Statement stmt=con.createStatement();  
		  
		//step4 execute query  
		
		// SELECT username FROM ALL_USERS;
		// CREATE USER shoot IDENTIFIED BY 1234
		// DROP USER boot
		stmt.executeQuery("DROP USER boot");  
		System.out.println("User Created");
		//while(rs.next())  
		//System.out.println(rs.getString(1)+"  "+rs.getString(2));  
		  
		//step5 close the connection object  
		con.close();  
		  
		}catch(Exception e){
			System.out.println(e);
			}  
		}  

}
