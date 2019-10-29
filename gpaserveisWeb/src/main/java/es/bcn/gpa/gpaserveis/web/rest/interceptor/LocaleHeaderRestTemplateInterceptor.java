package es.bcn.gpa.gpaserveis.web.rest.interceptor;

import java.io.IOException;
import java.util.Locale;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

/**
 * The Class LocaleHeaderRestTemplateInterceptor.
 */
public class LocaleHeaderRestTemplateInterceptor implements ClientHttpRequestInterceptor {

	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {

		Locale locale = LocaleContextHolder.getLocale();
		if (locale != null) {
			request.getHeaders().add(HttpHeaders.ACCEPT_LANGUAGE, locale.getLanguage());
		}

		return execution.execute(request, body);
	}

}
