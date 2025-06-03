import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Books
{
	public	static void addBook(Scanner sc,Connection c) throws SQLException 
	{
        System.out.print("Enter book title: ");
        String title = sc.nextLine();
        
        System.out.print("Enter author: ");
        String author = sc.nextLine();

        
        String query="insert into books (title, author) values (?, ?);";
        PreparedStatement stmt = c.prepareStatement(query);
        stmt.setString(1,title);
        stmt.setString(2,author);
        
        stmt.executeUpdate();

        System.out.println("Book added successfully.");
    }

            //checkavailability
   public static void checkAvailability(Scanner sc,Connection c) throws SQLException 
        {
           System.out.print("Enter book ID: ");
           int id = sc.nextInt();
               
           String query="select * from books where id = ?;";
           PreparedStatement stmt = c.prepareStatement(query);
           
           stmt.setInt(1, id);
    
           ResultSet rs = stmt.executeQuery();

             if (rs.next()) 
             {
            System.out.println(rs.getBoolean("is_present") ? "Book is_present." : "Book is issued.");
              }
             else 
             {
        System.out.println("Book not found.");
              }
        }
      
        


         //findbook
       public static void findBook(Scanner sc, Connection c) throws SQLException 
             {
          System.out.print("Enter book title: ");
          String title = sc.nextLine();
 
          String query = "select * from books where title = ?";
          PreparedStatement stmt = c.prepareStatement(query);
          
           stmt.setString(1, title);
 
          ResultSet rs = stmt.executeQuery();

         while (rs.next())
           {
    	     System.out.println("ID: " + rs.getInt("id"));
            }
           System.out.println("Title: " + rs.getString("title"));
           System.out.println("Author: " + rs.getString("author"));
           System.out.println("Is_present " + rs.getBoolean("is_present"));
           
 }

       //removebook
       public static void removeBook(Scanner sc,Connection c) throws SQLException
          {
             System.out.print("Enter book ID to remove: ");
            int id = sc.nextInt();

             String query = "delete from books where id = ?";
             PreparedStatement stmt = c.prepareStatement(query);
             stmt.setInt(1, id);
    
             int row = stmt.executeUpdate();
             System.out.println("Book removed.");
}
       
       //issuebook
       
       public static void issueBook(Scanner sc,Connection c) throws SQLException
       {
    	   System.out.print("Enter book ID to issue: ");
           int bookId = sc.nextInt();
           
           System.out.print("Enter reader ID: ");
           int readerId = sc.nextInt();

           // Check availability
           String check = "SELECT available FROM books WHERE id = ?";
           PreparedStatement checkStmt = c.prepareStatement(check);
           checkStmt.setInt(1, bookId);
           ResultSet rs = checkStmt.executeQuery();

           if (rs.next() && rs.getBoolean("available"))
         {
               String sql = "INSERT INTO issued_books (book_id, reader_id) VALUES (?, ?)";
               PreparedStatement stmt = c.prepareStatement(sql);
               
               stmt.setInt(1, bookId);
               stmt.setInt(2, readerId);
               stmt.executeUpdate();
               
               c.prepareStatement("UPDATE books SET available = FALSE WHERE id = " + bookId).executeUpdate();

               System.out.println("Book issued.");
           } else 
                 {
               System.out.println("Book not available.");
                  }
       }
       
       //returBook
       public static void returnBook(Scanner sc,Connection c) throws SQLException {
           System.out.print("Enter book ID to return: ");
           int bookId = sc.nextInt();

           String sql = "DELETE FROM issued_books WHERE book_id = ?";
           PreparedStatement stmt = c.prepareStatement(sql);
           stmt.setInt(1, bookId);
           stmt.executeUpdate();

           c.prepareStatement("UPDATE books SET available = TRUE WHERE id = " + bookId).executeUpdate();
           System.out.println("Book returned.");
       }

       //CheckBookHolders
       public  static void checkBookHolders(Connection c) throws SQLException
        {
           String sql = """
               SELECT b.title, r.name
               FROM issued_books ib
               JOIN books b ON ib.book_id = b.id
               JOIN readers r ON ib.reader_id = r.id
           """;
           ResultSet rs = c.createStatement().executeQuery(sql);

           while (rs.next()) 
           {
               System.out.println("Book: " + rs.getString("title") + " | Holder: " + rs.getString("name"));
           }
       }


       
       
  }

		

				
				
			
			




    



