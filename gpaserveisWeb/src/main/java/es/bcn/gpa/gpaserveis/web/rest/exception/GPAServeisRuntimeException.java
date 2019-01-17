package es.bcn.gpa.gpaserveis.web.rest.exception;

/**
 * The Class GPAServeisRuntimeException.
 */
public class GPAServeisRuntimeException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new GPA serveis service exception.
	 */
	public GPAServeisRuntimeException() {
		super();
	}

	/**
	 * Instantiates a new GPA serveis service exception.
	 *
	 * @param message the message
	 * @param cause the cause
	 * @param enableSuppression the enable suppression
	 * @param writableStackTrace the writable stack trace
	 */
	public GPAServeisRuntimeException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * Instantiates a new GPA serveis service exception.
	 *
	 * @param message the message
	 * @param cause the cause
	 */
	public GPAServeisRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Instantiates a new GPA serveis service exception.
	 *
	 * @param message the message
	 */
	public GPAServeisRuntimeException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new GPA serveis service exception.
	 *
	 * @param cause the cause
	 */
	public GPAServeisRuntimeException(Throwable cause) {
		super(cause);
	}
	
}
