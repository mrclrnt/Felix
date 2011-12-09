import java.rmi.Remote;
import java.rmi.RemoteException;


public interface Connexion extends Remote{

	public void connect (String id) throws RemoteException;
	
}
