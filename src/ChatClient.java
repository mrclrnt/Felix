import java.rmi.*;

public class ChatClient {
	public static void main(String args[]) {
    try {
      // Récupération d'un stub sur l'objet serveur.
      Hello obj = (Hello) Naming.lookup("//Nicolas:1/mon_serveur");
      // Appel d'une méthode sur l'objet distant.
      obj.sayHello();
    } catch (Exception exc) {
    	System.out.println("ERREUR");
    }
  }
}