package es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.auth.impl;

import java.util.List;
import java.util.Map;

import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.Pair;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.auth.Authentication;

public class AuthenticationImpl implements Authentication {

	@Override
	public void applyToParams(List<Pair> queryParams, Map<String, String> headerParams) {
		headerParams.put("x-imi-authorization", "{\"user\": \"T000000\" }");
	}
}
