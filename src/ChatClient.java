import java.rmi.*;

public class ChatClient {
	public static void main(String args[]) {
		try {
			int i = 0;
			
			CommandLineReader reader = new CommandLineReader();
			

			// Récupération d'un stub sur l'objet serveur.
			Hello obj = (Hello) Naming.lookup("//Nicolas:1/mon_serveur");
			
			String functionToLaunch = reader.getFunction();
			
			// Appel d'une méthode sur l'objet distant.
			switch (functionToLaunch){
			case "sayHello":
				obj.sayHello();
			}
		
		} catch (Exception exc) {
			System.out.println("ERREUR");
		}
	}
}