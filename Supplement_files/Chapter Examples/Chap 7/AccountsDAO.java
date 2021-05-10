package myDAOs;

import java.sql.*;
import javax.naming.*;
import javax.sql.*;
import java.util.*;

public class AccountsDAO implements java.io.Serializable
{
	private Connection connection;

	public AccountsDAO()
					throws SQLException, NamingException
	{
		Context initialContext = new InitialContext();

		Context context =
		  (Context)initialContext.lookup("java:comp/env");
		DataSource dataSource =
			  (DataSource)context.lookup("jdbc/Finances");

		connection = dataSource.getConnection();
	}

	public ArrayList<Object> getAcctDetails()
									throws SQLException
	{
		ArrayList<Object> acctDetails = null;
		Statement statement = null;
		ResultSet results = null;

		statement = connection.createStatement();
		results = statement.executeQuery(
								"SELECT * FROM Accounts");

		acctDetails = new ArrayList <Object>();

		while (results.next())
		{
			acctDetails.add(results.getInt(1));
			acctDetails.add(results.getString(3) + " "
								+ results.getString(2));
			acctDetails.add(results.getFloat(4));
		}

		return acctDetails;
	}

	public void close() throws SQLException
	{
		//Any error on disconnecting is handled by servlet.
		connection.close();
	}
}

