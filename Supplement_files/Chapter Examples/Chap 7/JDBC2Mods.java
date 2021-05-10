import java.sql.*;
public class JDBC2Mods
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
			statement = connection.createStatement(
							ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_UPDATABLE);

			String select = "SELECT * FROM Accounts";

			System.out.println(
						  "\nInitial contents of table:\n");
			//Steps 3 and 4...
			displayTable();

			//Start of step 5...

			//First the update...
			results.absolute(2);
			//(Move to row 2 of ResultSet.)
			results.updateFloat("balance", 42.55f);
			results.updateRow();

			//Now the insertion...
			results.moveToInsertRow();
			results.updateInt("acctNum", 999999);
			results.updateString("surname", "Harrison");
			results.updateString("firstNames",
										"Christine Dawn");
			results.updateFloat("balance", 2500f);
			results.insertRow();

			//Finally, the deletion...
			results.absolute(3);   //Move to row 3.
			results.deleteRow();

			System.out.println(
						  "\nNew contents of table:\n");
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
	                       			+ " "
                           			+ results.getString(2));
            System.out.printf("Balance: %.2f %n%n",
                              		results.getFloat(4));
        }
    }
}
