package com.tka;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class delete_query
{
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
        	
        	String query="Delete from employee where id=1";
        	PreparedStatement stmt=c.prepareStatement(query);
        	
        	 int num=stmt.executeUpdate();
        	 
        	 System.out.println(num);
        	 System.out.println("employee Delete");
        	 
        }
         else
        	 System.out.println("Databse NotConnected!");
         
         
	}

}


	

	



 
 




