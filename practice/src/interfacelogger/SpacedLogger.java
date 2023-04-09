package interfacelogger;

public class SpacedLogger implements Logger {

	@Override
	public void log(String log) {
		for (int i = 0; i < log.length(); i++) {
			System.out.print(log.charAt(i) + " ");
		}
	}

	@Override
	public void error(String error) {
		System.err.print("ERROR: ");
		for (int i = 0; i < error.length(); i++) {
			System.err.print(error.charAt(i) + " ");
		}
	}
}
