//Server.
import java.rmi.*;
import java.util.ArrayList;

public class Bank1Server
{
   private static final String HOST = "localhost";

   public static void main(String[] args)
                                      throws Exception
   {
      //Create an initialised array of four Account
      //objects...
      Account[] account =
       {new Account(111111,"Smith","Fred James",112.58),
        new Account(222222,"Jones","Sally",507.85),
        new Account(234567,"White","Mary Jane",2345.00),
        new Account(666666,"Satan","Beelzebub",666.00)};

      ArrayList<Account> acctDetails =
                               new ArrayList<Account>();

      //Insert the Account objects into the ArrayList...
      for (int i=0; i<account.length; i++)
         acctDetails.add(account[i]);

      //Create an implementation object, passing the
      //above ArrayList to the constructor...
      Bank1Impl temp = new Bank1Impl(acctDetails);

      //Save the object's name in a String...
      String rmiObjectName =
                      "rmi://" + HOST + "/Accounts";
	  //(Could omit host name, since 'localhost' would be
	  //assumed by default.)

      //Bind the object's name to its reference...
      Naming.rebind(rmiObjectName,temp);

      System.out.println("Binding complete...\n");
	}
}

