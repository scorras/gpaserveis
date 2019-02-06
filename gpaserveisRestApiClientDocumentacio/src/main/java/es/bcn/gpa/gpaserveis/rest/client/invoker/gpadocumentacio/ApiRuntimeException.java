package es.bcn.gpa.gpaserveis.rest.client.invoker.gpadocumentacio;

/**
 * The Class ApiRuntimeException.
 */
public class ApiRuntimeException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new api runtime exception.
	 */
	public ApiRuntimeException() {
		super();
	}

	/**
	 * Instantiates a new api runtime exception.
	 *
	 * @param message
	 *            the message
	 * @param cause
	 *            the cause
	 * @param enableSuppression
	 *            the enable suppression
	 * @param writableStackTrace
	 *            the writable stack trace
	 */
	public ApiRuntimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * Instantiates a new api runtime exception.
	 *
	 * @param message
	 *            the message
	 * @param cause
	 *            the cause
	 */
	public ApiRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Instantiates a new api runtime exception.
	 *
	 * @param message
	 *            the message
	 */
	public ApiRuntimeException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new api runtime exception.
	 *
	 * @param cause
	 *            the cause
	 */
	public ApiRuntimeException(Throwable cause) {
		super(cause);
	}

}
