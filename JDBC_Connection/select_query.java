package com.tka;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class select_query {

	public static void main(String[] args) throws Exception
	{
      Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url="jdbc:mysql://localhost:3306/infosys?useSSL=false";
		String user="root";
		String Pass="Gunjankatre";
		
		
		Connection c=DriverManager.getConnection(url, user, Pass);
	
         if(c!=null)
         {
        	System.out.println("Database connected!");
        	
        	String query="Select * from employee";
        	PreparedStatement stmt=c.prepareStatement(query);
        	
        	 ResultSet rs =stmt.executeQuery();
        	 
        	 while(rs.next())
        	 {
        		 System.out.println(rs.getObject("id") +" " + rs.getObject("name"));
        	 
        	 }
        	
        	
         }
         else
        	 System.out.println("Databse NotConnected!");
         
         
	}

}