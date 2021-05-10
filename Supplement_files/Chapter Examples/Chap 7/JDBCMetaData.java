import java.sql.*;

public class JDBCMetaData
{
   private static Connection connection;
   private static Statement statement;
   private static ResultSet results;

   public static void main(String[] args)
   {
      try
      {
         //Step 1...
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
         //Step 2...
         statement = connection.createStatement();

         String select = "SELECT * FROM Accounts"
                         	+ " WHERE acctNum = 123456";


		//Step 3...
         results = statement.executeQuery(select);

         //Start of step 4...
         ResultSetMetaData metaData =
                                results.getMetaData();
         int numFields = metaData.getColumnCount();

         //Check that record has been found...
         boolean found = results.next();

         if (!found)
         {
            //No point in continuing...
            System.out.println("\nNot found!");
            connection.close();
            return;
		}

         //Cycle through the database fields, displaying
         //meta data about each one...
         for (int i=1; i<=numFields; i++)
		//N.B. Remember that count must start at 1!
         {
            System.out.println("\nField name: "
                           + metaData.getColumnName(i));

            System.out.println("Field type:  "
                       + metaData.getColumnTypeName(i));

            int colType = metaData.getColumnType(i);

            System.out.print("Value: ");

            //Select the appropriate getXXX method,
            //according to the SQL type of the field...
            switch (colType)
            {
               case Types.INTEGER:
                         System.out.println(
                                     results.getInt(i));
                         break;
               case Types.VARCHAR:
                         System.out.println(
                                  results.getString(i));
                         break;
               case Types.NUMERIC:
                         System.out.printf("%.2f %n%n",
                                   results.getFloat(i));
                         break;
               default: System.out.println("Unknown");
            }
         }
         //End of step 4.

         //(No further queries, so no Step 5!)

         //Step 6...
         connection.close();
      }
      catch(SQLException ex)
      {
         System.out.println(
                      	"* SQL or connection error! *");
         ex.printStackTrace();
         System.exit(1);
      }
   }
}
