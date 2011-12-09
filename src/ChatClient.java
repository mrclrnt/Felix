import java.rmi.*;

public class ChatClient {
	public static void main(String args[]) {
		try {
			int i = 0;
			while (i < 10) {
				CommandLineReader reader = new CommandLineReader();
			}

			// R�cup�ration d'un stub sur l'objet serveur.
			Hello obj = (Hello) Naming.lookup("//Nicolas:1/mon_serveur");
			// Appel d'une m�thode sur l'objet distant.
			obj.sayHello();
		} catch (Exception exc) {
			System.out.println("ERREUR");
		}
	}
}