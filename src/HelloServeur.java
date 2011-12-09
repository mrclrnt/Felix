import java.net.InetAddress;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class HelloServeur extends UnicastRemoteObject implements Hello {

	private static final long serialVersionUID = 1L;
	
	String message;
	// Implémentation du constructeur
	public HelloServeur(String msg) throws java.rmi.RemoteException {
		message = msg;
	}
	// Implémentation de la méthode distante
	public void sayHello() throws java.rmi.RemoteException {
		System.out.println(message);
	}
	
	public static void main(String[] args) {
		
		int port; 
		String URL;
		try { // transformation d ’une chaîne de caractères en entier
			Integer I = new Integer(args[0]); 
			port = I.intValue();
			} catch (Exception ex) {
			System.out.println(" Please enter: Server <port>"); return;
			}
		try {
			// Création du serveur de nom - rmiregistry
			Registry registry = LocateRegistry.createRegistry(port);
			// Création d ’une instance de l’objet serveur
			Hello obj = new HelloServeur("test message");
			// Calcul de l’URL du serveur
			URL = "//"+InetAddress.getLocalHost().getHostName()+":"+port+"/mon_serveur";
			Naming.rebind(URL, obj);
		} catch (Exception exc) {}
	}

}
