import java.sql.*;

public class JDBCScrollableSelect
{
   private static Connection connection;
   private static Statement statement;
   private static ResultSet results;

   public static void main(String[] args)
   {
      try
      {
         connection = DriverManager.getConnection(
							"jdbc:odbc:Finances","","");
      }
      catch(SQLException sqlEx)
      {
         System.out.println(
                     "* Cannot connect to database! *");
         System.exit(1);
      }

      try
      {
         statement = connection.createStatement(
							ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_READ_ONLY);
         results = statement.executeQuery(
                              "SELECT * FROM Accounts");
      }
      catch(SQLException sqlEx)
      {
         System.out.println(
							  "* Cannot execute query! *");
         sqlEx.printStackTrace();
         System.exit(1);
      }

      try
      {
         while (results.next())
         //Iterate through the rows in the forward
         //direction, displaying the contents of each
         //row (as in the original program)...
            showRow();
      }
      catch(SQLException sqlEx)
      {
         System.out.println(
						"* Error retrieving data! *");
         sqlEx.printStackTrace();
         System.exit(1);
      }

      try
      {
         //Cursor for ResultSet is now positioned
         //just after last row, so we can make use
         //of method previous to access the data...
         while (results.previous())
         //Iterate through rows in reverse direction,
         //again displaying contents of each row...
            showRow();
      }
      catch(SQLException sqlEx)
      {
         System.out.println(
						"* Error retrieving data! *");
         sqlEx.printStackTrace();
         System.exit(1);
      }

      try
      {
         connection.close();
      }
      catch(SQLException sqlEx)
      {
         System.out.println(
						"* Unable to disconnect! *");
         sqlEx.printStackTrace();
      }
   }

   public static void showRow() throws SQLException
   {
      System.out.println();
      System.out.println("Account no. "
								+ results.getInt(1));
      System.out.println("Account holder:  "
                          + results.getString(3)
                          + " " + results.getString(2));
	  System.out.printf("Balance: %.2f %n%n",
								     results.getFloat(4));
   }
}
