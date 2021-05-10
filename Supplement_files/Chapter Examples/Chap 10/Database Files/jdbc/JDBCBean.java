package jdbc;

import java.sql.*;
import java.util.Vector;

public class JDBCBean
{
	private Vector<Object> acctDetails;

	public JDBCBean() throws SQLException,
	{
		Connection link = null;
		Statement statement = null;
		ResultSet results = null;

		link = DriverManager.getConnection(
							"jdbc:odbc:Finances","","");
		statement = link.createStatement();
		results = statement.executeQuery(
								"SELECT * FROM Accounts");

		acctDetails = new Vector<Object>();

		while (results.next())
		{
			acctDetails.add(results.getInt(1));
			acctDetails.add(results.getString(3)
							+ " " + results.getString(2));
			acctDetails.add(results.getFloat(4));
		}

		link.close();
	}

	public Vector<Object> getAcctDetails()
	{
		return acctDetails;
	}

}


