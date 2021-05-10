import java.io.*;
import java.net.*;
import java.util.*;

public class EmailClient
{
	private static InetAddress host;
	private static final int PORT = 1234;
	private static String name;
	private static Scanner networkInput, userEntry;
	private static PrintWriter networkOutput

	public static void main(String[] args) throws IOException
	{
		try
		{
			host = InetAddress.getLocalHost();
		}
		catch(UnknownHostException e)
		{
			System.out.println("Host ID not found!");
			System.exit(1);
		}

		userEntry = new Scanner(System.in);

		do
		{
			System.out.print("\nEnter name ('Dave' or 'Karen'): ");
			name = userEntry.nextLine();
		}while (!name.equals("Dave") && !name.equals("Karen"));

		talkToServer();
	}

	private static void talkToServer() throws IOException
	{
		String option, message, response;

		do
		{


	 /********************************************************

			CREATE A SOCKET, SET UP INPUT AND OUTPUT STREAMS,
			ACCEPT THE USER'S REQUEST, CALL UP THE APPROPRIATE
			METHOD (doSend OR doRead), CLOSE THE LINK AND THEN
			ASK IF USER WANTS TO DO ANOTHER READ/SEND.


	 ********************************************************/

		}while (!option.equals("n"));

	}

	private static void doSend() throws IOException
	{
		System.out.println("\nEnter 1-line message: ");
		String message = userEntry.readLine();
		out.println(name);
		out.println("send");
		out.println(message);
	}

	private static void doRead() throws IOException
	{

		/*********************************
		BODY OF THIS METHOD REQUIRED
		*********************************/

	}
}
