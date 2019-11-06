package es.bcn.gpa.gpaserveis.web.rest.interceptor;

import java.io.IOException;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import net.opentrends.openframe.services.security.core.userdetails.ImiUserDetails;
import net.opentrends.openframe.services.security.util.SecurityUtils;

/**
 * The Class ImiAuthHeaderRestTemplateInterceptor.
 */
public class ImiAuthHeaderRestTemplateInterceptor implements ClientHttpRequestInterceptor {

	/** The auth imi header. */
	private final String AUTH_IMI_HEADER = "x-imi-authorization";

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

		ImiUserDetails imiUser = SecurityUtils.getLoggedUserDetails();
		if (imiUser != null) {

			String authHeader = imiUser.getPayload();

			if (authHeader != null) {
				request.getHeaders().add(AUTH_IMI_HEADER, authHeader);
			}
		}
		return execution.execute(request, body);
	}

}
