import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Readers 
{
	//RegisterReader
	public	static void resisterReader(Scanner sc,Connection c) throws SQLException 
	{
        System.out.print("Enter Reader Name: ");
        String name = sc.nextLine();
        
        System.out.print("Enter Reader Id: ");
        String id = sc.nextLine();

        
        String query="insert into books (name,id) values (?, ?);";
        PreparedStatement stmt = c.prepareStatement(query);
        
        stmt.setString(1,name);
        stmt.setString(2,id);
        
        stmt.executeUpdate();

        System.out.println("Reader Registered");
    }


	//CancelMembership
    public static void cancelMembership(Scanner sc,Connection c) throws SQLException
       {
          System.out.print("Enter id ID to remove: ");
         int id = sc.nextInt();

          String query = "delete from reader where id = ?";
          PreparedStatement stmt = c.prepareStatement(query);
          
          stmt.setInt(1, id);
 
          int row = stmt.executeUpdate();
          System.out.println("Reader removed.");
}
}



