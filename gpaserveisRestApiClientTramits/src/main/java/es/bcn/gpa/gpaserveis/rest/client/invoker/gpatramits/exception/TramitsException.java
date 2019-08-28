package es.bcn.gpa.gpaserveis.rest.client.invoker.gpatramits.exception;

import org.springframework.http.HttpStatus;

public class TramitsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private HttpStatus statusCode;

	private String body;

	public TramitsException(HttpStatus statusCode, String body, String message) {
		super(message);
		this.statusCode = statusCode;
		this.body = body;
	}

	public TramitsException(HttpStatus statusCode, String body, String message, Throwable cause) {
		super(message, cause);
		this.statusCode = statusCode;
		this.body = body;
	}

	public HttpStatus getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(HttpStatus statusCode) {
		this.statusCode = statusCode;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

}