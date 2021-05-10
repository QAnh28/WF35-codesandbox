import java.sql.*;

public class JDBCChange
{
	private static Statement statement;
	private static ResultSet results;

    public static void main(String[] args)
    {
		Connection connection = null;

      	try
      	{
         //Step 1...
         connection = DriverManager.getConnection(
                            	"jdbc:odbc:Finances","","");
      }
      //For any of a number of reasons, it may not be
      //possible to establish a connection...
      catch(SQLException sqlEx)
      {
         System.out.println(
                     "* Cannot connect to database! *");
         System.exit(1);
      }
      try
      {
         //Step 2...
         statement = connection.createStatement();

         System.out.println(
                      "\nInitial contents of table:");
         //Steps 3 and 4...
         displayTable();

         //Start of step 5...
         String insert = "INSERT INTO Accounts"
                     + " VALUES (123456,'Smith',"
                     + "'John James',752.85)";
         int result = statement.executeUpdate(insert);
         if (result == 0)
            System.out.println(
                        	"\nUnable to insert record!");

         String change = "UPDATE Accounts"
                      		+ " SET surname = 'Bloggs',"
                      		+ "firstNames='Fred Joseph'"
                      		+ " WHERE acctNum = 123456";
         result = statement.executeUpdate(change);
         if (result == 0)
            System.out.println(
                         "\nUnable to update record!");

         String remove = "DELETE FROM Accounts"
                      			+ " WHERE balance < 100";
         result = statement.executeUpdate(remove);
         if (result == 0)
            System.out.println(
                         "\nUnable to delete record!");

         System.out.println("\nNew contents of table:");
         displayTable();
         //End of step 5.

         //Step 6...
         connection.close();
      }
      catch(SQLException sqlEx)
      {
         System.out.println(
                       "* SQL or connection error! *");
         sqlEx.printStackTrace();
         System.exit(1);
      }
   }
   public static void displayTable() throws SQLException
   {
	  String select = "SELECT * FROM Accounts";

      results = statement.executeQuery(select);
      System.out.println();
      while (results.next())
      {
		 System.out.println("Account no. "
                                 + results.getInt(1));
	     System.out.println("Account holder:  "
                          + results.getString(3)
                          + " " + results.getString(2));
         System.out.printf("Balance: %.2f %n%n",
                                   results.getFloat(4));
      }
   }
}
