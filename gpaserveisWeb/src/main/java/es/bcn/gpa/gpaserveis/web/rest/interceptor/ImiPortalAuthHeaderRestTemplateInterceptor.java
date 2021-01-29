package es.bcn.gpa.gpaserveis.web.rest.interceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * The Class ImiPortalAuthHeaderRestTemplateInterceptor.
 */
public class ImiPortalAuthHeaderRestTemplateInterceptor implements ClientHttpRequestInterceptor {

	/** The auth portal header usuari-autenticat. */
	private final String AUTH_PORTAL_USUARI_AUTENTICAT_HEADER = "usuari-autenticat";

	/** The auth portal header usuari-interessat. */
	private final String AUTH_PORTAL_USUARI_INTERESSAT_HEADER = "usuari-interessat";

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.http.client.ClientHttpRequestInterceptor#intercept(
	 * org.springframework.http.HttpRequest, byte[],
	 * org.springframework.http.client.ClientHttpRequestExecution)
	 */
	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {

		RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();

		if (requestAttributes != null) {

			HttpServletRequest serveltrequest = ((ServletRequestAttributes) requestAttributes).getRequest();

			String autenticat = (String) serveltrequest.getHeader(AUTH_PORTAL_USUARI_AUTENTICAT_HEADER);
			request.getHeaders().add(AUTH_PORTAL_USUARI_AUTENTICAT_HEADER, autenticat);

			String interessat = (String) serveltrequest.getHeader(AUTH_PORTAL_USUARI_INTERESSAT_HEADER);
			request.getHeaders().add(AUTH_PORTAL_USUARI_INTERESSAT_HEADER, interessat);

		}

		return execution.execute(request, body);
	}

}
