import java.rmi.Naming;
import java.rmi.server.UnicastRemoteObject;


public class HelloServeur extends UnicastRemoteObject implements Hello {

	private static final long serialVersionUID = 1L;
	
	String message;
	// Impl�mentation du constructeur
	public HelloServeur(String msg) throws java.rmi.RemoteException {
		message = msg;
	}
	// Impl�mentation de la m�thode distante
	public void sayHello() throws java.rmi.RemoteException {
		System.out.println(message);
	}
	
	
	public static void main(String[] args) {
		try {
			// Cr�e une instance de l �objet serveur.
			Hello obj = new HelloServeur("test");
			// Enregistre l'objet cr�er aupr�s du serveur de noms.
			Naming.rebind("//ma_machine/mon_serveur", obj);
			System.out.println("HelloServeur " + " bound in registry");
			
		} catch (Exception exc){ }

	}

}
