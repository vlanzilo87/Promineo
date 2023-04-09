package interfacelogger;

public class App {

	public static void main(String[] args) {
		
		Logger asteriskLogger1 = new AsteriskLogger();
		Logger spacedLogger1 = new SpacedLogger();
		
		asteriskLogger1.log("Here is the log.");
		asteriskLogger1.error("Uh oh, error!");
		System.out.println();
		spacedLogger1.log("Here is the log.");
		System.out.println();
		spacedLogger1.error("Uh oh, error!");
	}

}
