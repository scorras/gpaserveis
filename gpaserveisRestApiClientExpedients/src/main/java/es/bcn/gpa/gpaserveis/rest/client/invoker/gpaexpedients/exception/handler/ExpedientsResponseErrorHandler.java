package es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.exception.handler;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.ResponseErrorHandler;

import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.exception.ExpedientsException;

public class ExpedientsResponseErrorHandler implements ResponseErrorHandler {
	private ResponseErrorHandler myErrorHandler = new DefaultResponseErrorHandler();

	public boolean hasError(ClientHttpResponse response) throws IOException {
		return myErrorHandler.hasError(response);
	}

	public void handleError(ClientHttpResponse response) throws IOException {
		String body = IOUtils.toString(response.getBody());
		throw new ExpedientsException(response.getStatusCode(), body, body);
	}
}
