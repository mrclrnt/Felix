import java.rmi.Remote;


public interface Hello extends Remote {
	
	public void sayHello() throws java.rmi.RemoteException;
	
}
