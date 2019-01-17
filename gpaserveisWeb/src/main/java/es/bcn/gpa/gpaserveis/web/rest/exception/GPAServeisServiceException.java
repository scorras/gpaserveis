package es.bcn.gpa.gpaserveis.web.rest.exception;

import java.util.List;

/**
 * The Class GPAServeisServiceException.
 */
public class GPAServeisServiceException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The list errors valors. */
	private List<String> listErrorsValors;

	/**
	 * Instantiates a new GPA serveis service exception.
	 */
	public GPAServeisServiceException() {
		super();
	}

	/**
	 * Instantiates a new GPA serveis service exception.
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
	public GPAServeisServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * Instantiates a new GPA serveis service exception.
	 *
	 * @param message
	 *            the message
	 * @param cause
	 *            the cause
	 */
	public GPAServeisServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Instantiates a new GPA serveis service exception.
	 *
	 * @param message
	 *            the message
	 */
	public GPAServeisServiceException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new GPA serveis service exception.
	 *
	 * @param cause
	 *            the cause
	 */
	public GPAServeisServiceException(Throwable cause) {
		super(cause);
	}

	public GPAServeisServiceException(String message, List<String> listErrorsValors) {
		super(message);
		this.listErrorsValors = listErrorsValors;
	}

	/**
	 * Gets the list errors valors.
	 *
	 * @return the listErrorsValors
	 */
	public List<String> getListErrorsValors() {
		return listErrorsValors;
	}

	/**
	 * Sets the list errors valors.
	 *
	 * @param listErrorsValors
	 *            the listErrorsValors to set
	 */
	public void setListErrorsValors(List<String> listErrorsValors) {
		this.listErrorsValors = listErrorsValors;
	}

}
