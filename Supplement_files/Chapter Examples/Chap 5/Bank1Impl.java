import java.rmi.*;
import java.rmi.server.*;
import java.util.ArrayList;

public class Bank1Impl extends UnicastRemoteObject
                                        implements Bank1
{
   //Declare the ArrayList that will hold Account
   //objects...
   private ArrayList<Account> acctInfo;


   //The constructor must be supplied with an ArrayList
   //of Account objects...
   public Bank1Impl(ArrayList<Account> acctVals)
						throws RemoteException
   {
      acctInfo = acctVals;
   }

   //Definition for the single interface method...
   public ArrayList<Account> getBankAccounts()
						throws RemoteException
   {
      return acctInfo;
   }
}
