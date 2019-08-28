package es.bcn.gpa.gpaserveis.rest.client.invoker.gpaunitats.auth;

import org.springframework.http.HttpHeaders;
import org.springframework.util.MultiValueMap;

public class AuthenticationImpl implements Authentication {

	@Override
	public void applyToParams(MultiValueMap<String, String> queryParams, HttpHeaders headerParams) {
		headerParams.add("x-imi-authorization", "{\"user\": \"T000000\", \"grp\" : null}");

	}
}
