import java.rmi.*;
import java.util.ArrayList;

public interface Bank1 extends Remote
{
   public ArrayList<Account> getBankAccounts()
							throws RemoteException;
}
