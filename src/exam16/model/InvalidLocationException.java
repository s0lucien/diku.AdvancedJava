package exam16.model;

public class InvalidLocationException extends Exception {

	private static final long serialVersionUID = -6260293226123489899L;

	public InvalidLocationException() {

	}

	public InvalidLocationException(String message) {
		super(message);
	}

	public InvalidLocationException(Throwable cause) {
		super(cause);
	}

	public InvalidLocationException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidLocationException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
