import java.util.Scanner;



public class CommandLineReader {

	private String function;
	private String argument;
	
	public String getFunction() {
		return function;
	}

	public String getArgument() {
		return argument;
	}

	public CommandLineReader() {
		System.out.println("Enter a function, please");
		readCommandLine();
	}

	public void readCommandLine () {
		Scanner scanner = new Scanner(System.in);
		this.function = scanner.next();
		this.argument = scanner.next();
		
	}
}
