package interfacelogger;

public class AsteriskLogger implements Logger {

	//The log method on the AsteriskLogger should print out the String it receives between 3 asterisks
	//on either side of the String (e.g. if the String passed in is “Hello”, then it should print ***Hello*** to the console).
	@Override
	public void log(String log) {
		System.out.println("***" + log + "***");
	}

	//The error method on the AsteriskLogger should print the String it receives inside a box of asterisks, with the
	//String preceded by the word “ERROR:”. For example, if “Hello” is the argument, the following should be printed:
	@Override
	public void error(String error) {
		for (int i = 0; i < error.length() + 13; i++) {
			System.err.print("*");
		}
		System.out.println();
		System.err.println("***ERROR: " + error + "***");
		for (int i = 0; i < error.length() + 13; i++) {
			System.err.print("*");
		}
	}

}
