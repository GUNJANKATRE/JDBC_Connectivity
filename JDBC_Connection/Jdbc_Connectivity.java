package com.tka;

import java.sql.Connection;
import java.sql.DriverManager;

public class Jdbc_Connectivity

{ 
	public static void mai(String[] args) throws Exception 
     {
	    Class.forName("com.mysql.cj.jdbc.Driver");

			String url="jdbc:mysql://localhost:3306/infosys?useSSL=false";
			String user="root";
			String Pass="Gunjankatre";


        Connection c=DriverManager.getConnection(url, user, Pass);

		 if(c!=null)
			System.out.println("Database connected!");
		 else
			 System.out.println("Databse NotConnected!");

         }

}
