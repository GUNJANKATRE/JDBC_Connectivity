import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

  public class LibraryManagementSystem
  {
        //Class.forName("com.mysql.cj.jdbc.Driver");
		
		static String url="jdbc:mysql://localhost:3306/library?false";
		static String user="root";
		static String Pass="Gunjankatre";
		
         static Connection c;
		static Scanner sc=new Scanner(System.in);
		
		
	public static void main(String[]args) 
		{
			try 
			{
		       c=DriverManager.getConnection(url, user, Pass);
				int choice;
		        Books b = new Books();
		        Readers r=new Readers();

				do 
				{
					System.out.println("\nWelcome to Library");
		            System.out.println("1. Add book");
		            System.out.println("2. Check availability of book");
		            System.out.println("3. Find a book with detailed info");
		            System.out.println("4. Remove books");
		            System.out.println("5. Issue a book");
		            System.out.println("6. Return book");
		            System.out.println("7. Check book holders");
	                System.out.println("8. Register reader");
	                System.out.println("9. Cancel reader's membership");
	                System.out.println("10. Exit");
	                System.out.print("Enter your choice: ");
	                choice = sc.nextInt();
	                sc.nextLine(); 
		              
		        switch (choice)
	                {
                    case 1:b.addBook(sc,c);
                    	System.out.println("addBook");
                    break;
                    case 2:b.checkAvailability(sc, c);
                    System.out.println("checkAvailability");
                    break;
                    case 3:b.findBook(sc, c);
                    	System.out.println("findBook");
                    break;
                    case 4:b.removeBook(sc, c);
                    	System.out.println("removeBook");
                    break;
                    case 5:b.issueBook(sc, c);
                    System.out.println("issueBook");
                    break;
                    case 6:b.returnBook(sc, c);
                    	System.out.println("returnBook");
                    break;
                    case 7:b.checkBookHolders(c);
                    System.out.println("checkBookHolders");
                    break;
                    case 8:r.resisterReader(sc, c);
                    System.out.println("registerReader");
                    break;
                    case 9:r.cancelMembership(sc, c);
                    System.out.println("cancelMembership");
                    break;
                    case 10:System.out.println("Exiting...");
                    default:System.out.println("Invalid choice.");
                }

			}
	            while (choice !=10);
				      c.close();
			            }
	 catch (SQLException e)
			      {
				     e.printStackTrace();
			       }
			
		}
		
}	