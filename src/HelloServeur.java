import java.net.InetAddress;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class HelloServeur extends UnicastRemoteObject implements Hello {

	private static final long serialVersionUID = 1L;
	
	private String message;
	
	// Impl�mentation du constructeur
	public HelloServeur(String msg) throws java.rmi.RemoteException {
		message = msg;
	}
	// Impl�mentation de la m�thode distante
	public void sayHello() throws java.rmi.RemoteException {
		System.out.println(message);
	}
	
	public static void main(String[] args) {
		
		int port; 
		String URL;
		try { // transformation d �une cha�ne de caract�res en entier
			Integer I = new Integer(args[0]); 
			port = I.intValue();
			} catch (Exception ex) {
			port = 1;
			}
		try {
			// Cr�ation du serveur de nom - rmiregistry
			Registry registry = LocateRegistry.createRegistry(port);
			// Cr�ation d �une instance de l�objet serveur
			Hello obj = new HelloServeur("Hello Client, you are connected.");
			// Calcul de l�URL du serveur
			URL = "//"+InetAddress.getLocalHost().getHostName()+":"+port+"/mon_serveur";
			Naming.rebind(URL, obj);
		} catch (Exception exc) {
			System.out.println("exception");
		}
	}

}
