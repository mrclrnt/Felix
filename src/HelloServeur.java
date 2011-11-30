import java.rmi.Naming;
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
		try {
			// Crée une instance de l ’objet serveur.
			Hello obj = new HelloServeur("test");
			// Enregistre l'objet créer auprès du serveur de noms.
			Naming.rebind("//ma_machine/mon_serveur", obj);
			System.out.println("HelloServeur " + " bound in registry");
			
		} catch (Exception exc){ }

	}

}
