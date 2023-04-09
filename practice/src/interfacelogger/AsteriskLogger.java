package interfacelogger;

public class AsteriskLogger implements Logger {

	@Override
	public void log(String log) {
		System.out.println("***" + log + "***");
	}

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
