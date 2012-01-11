import java.net.InetAddress;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class ChatServer extends UnicastRemoteObject implements Hello, Connexion {

	private static final long serialVersionUID = 1L;
	
	private String message;
	private List<String> idList;
	
	// Implémentation du constructeur
	public ChatServer(String msg) throws java.rmi.RemoteException {
		message = msg;
	}
	// Implémentation des méthodes distantes
	public void sayHello() throws java.rmi.RemoteException {
		System.out.println(message);
	}

	public void connect(String id) throws java.rmi.RemoteException {
		if (this.idList.contains(id)){
			System.out.println("This id is already used, please try with another one");
		} else {
			this.idList.add(id);
			System.out.println("You are connected as " + id);
		}
	}
	
	public static void main(String[] args) {
		
		int port; 
		String URL;
		try { // transformation d ’une chaîne de caractères en entier
			Integer I = new Integer(args[0]); 
			port = I.intValue();
			} catch (Exception ex) {
			port = 1;
			}
		System.out.println(port);
		try {
			// Création du serveur de nom - rmiregistry
			Registry registry = LocateRegistry.createRegistry(port);
			// Création d ’une instance de l’objet serveur
			Hello obj = new ChatServer("Hello Client, you can ask the ChatServer");
			// Calcul de l’URL du serveur
			URL = "//"+InetAddress.getLocalHost().getHostName()+":"+port+"/mon_serveur";
			Naming.rebind(URL, obj);
			System.out.println("serveur ok");
		} catch (Exception exc) {
			System.out.println("exception");
		}
	}

}
