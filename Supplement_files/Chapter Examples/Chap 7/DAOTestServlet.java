import myDAOs.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.sql.*;
import javax.sql.*; //*** NOTE! ***
import javax.naming.*;

@WebServlet("/DataSourceTestServlet")
public class DAOTestServlet extends HttpServlet
{
    public void doGet(HttpServletRequest request,
    					HttpServletResponse response)
    				throws ServletException, IOException
    {
		try
		{
        	processRequest(request, response);
		}
		catch (SQLException sqlEx)
		{
			System.out.println("Error: " + sqlEx);
			sqlEx.printStackTrace();
		}
    }

    public void doPost(HttpServletRequest request,
    					HttpServletResponse response)
    				throws ServletException, IOException
    {
		try
		{
        	processRequest(request, response);
		}
		catch (SQLException sqlEx)
		{
			System.out.println("Error: " + sqlEx);
			sqlEx.printStackTrace();
		}
    }

public void processRequest(
						HttpServletRequest request,
    						HttpServletResponse response)
      throws ServletException, IOException, SQLException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<HTML>");
        out.println("<HEAD>");
        out.println("<TITLE>DAO Test</TITLE>");
        out.println("</HEAD>");
        out.println("<BODY><CENTER><BR><BR><BR>");
        out.println("<h1>Account Details</h1>");
        out.println("<TABLE BGCOLOR='aqua' BORDER=1>");
        out.println("<TR>");
        out.println(
				"<TH BGCOLOR='orange'>Acct.No.</TH>");
        out.println(
				"<TH BGCOLOR='orange'>Acct.Name</TH>");
        out.println(
				"<TH BGCOLOR='orange'>Balance</TH>");
        out.println("</TR>");

		AccountsDAO dao = null;
		try
		{
			dao = new AccountsDAO();
		}
		catch (NamingException namEx)
		{
			System.out.println("Error: " + namEx);
			namEx.printStackTrace();
			System.exit(1);
		}

		ArrayList<Object> accounts=dao.getAcctDetails();
		int acctNum;
		String acctName;
		float balance;
		String formattedBalance;
		final int NUM_FIELDS = 3;

		for (int i=0; i<accounts.size()/NUM_FIELDS; i++)
		{
			acctNum = 
			   (Integer)accounts.get(i*NUM_FIELDS);
			acctName = 
			  (String)accounts.get(i*NUM_FIELDS+1);
			balance = 
			 (Float)accounts.get(i*NUM_FIELDS + 2);
        	out.println("<TR>");
        	out.println("<TD>" + acctNum + "</TD>");
        	out.println("<TD>" + acctName + "</TD>");
			formattedBalance = 
							String.format("%.2f", balance);
			out.println("<TD>"+formattedBalance+"</TD>");        	
			out.println("</TR>");
		}
		out.println("</TABLE>");
		out.println("</CENTER>");

		out.println("</BODY>");
		out.println("</HTML>");

		out.close();

		dao.close();
    }
}
