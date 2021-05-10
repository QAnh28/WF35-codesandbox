import java.sql.*;

public class JDBCSelect
{
   public static void main(String[] args)
   {
   	  Connection connection = null;
   	  Statement statement = null;
   	  ResultSet results = null;
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

         String select = "SELECT * FROM Accounts";
          //Step 3...
         results = statement.executeQuery(select);
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
         System.out.println();

         //Step 4...
         while (results.next())
         {
			System.out.println("Account no. "
                              + results.getInt(1));
	        System.out.println("Account holder:  "
	                          + results.getString(3)
	                          + " "
                              + results.getString(2));
            System.out.printf("Balance: %.2f %n%n"
                               + results.getFloat(4));
         }
      }
      catch(SQLException sqlEx)
      {
		 System.out.println(
                       "* Error retrieving data! *");
         sqlEx.printStackTrace();
         System.exit(1);
      }

      //(No further queries, so no Step 5!)

      try
      {
          //Step 6...
          connection.close();
      }
      catch(SQLException sqlEx)
      {
         System.out.println(
                      "* Unable to disconnect! *");
         sqlEx.printStackTrace();
         System.exit(1);
      }
   }
}
