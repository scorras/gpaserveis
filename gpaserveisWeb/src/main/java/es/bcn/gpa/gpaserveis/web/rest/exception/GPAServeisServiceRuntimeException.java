package es.bcn.gpa.gpaserveis.web.rest.exception;

/**
 * The Class GPAServeisServiceRuntimeException.
 */
public class GPAServeisServiceRuntimeException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new GPA serveis service exception.
	 */
	public GPAServeisServiceRuntimeException() {
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
	public GPAServeisServiceRuntimeException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * Instantiates a new GPA serveis service exception.
	 *
	 * @param message the message
	 * @param cause the cause
	 */
	public GPAServeisServiceRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Instantiates a new GPA serveis service exception.
	 *
	 * @param message the message
	 */
	public GPAServeisServiceRuntimeException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new GPA serveis service exception.
	 *
	 * @param cause the cause
	 */
	public GPAServeisServiceRuntimeException(Throwable cause) {
		super(cause);
	}
	
}
