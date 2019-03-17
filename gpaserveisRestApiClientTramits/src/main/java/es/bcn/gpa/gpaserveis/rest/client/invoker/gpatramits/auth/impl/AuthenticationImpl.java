package es.bcn.gpa.gpaserveis.rest.client.invoker.gpatramits.auth.impl;

import java.util.List;
import java.util.Map;

import es.bcn.gpa.gpaserveis.rest.client.invoker.gpatramits.Pair;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpatramits.auth.Authentication;

public class AuthenticationImpl implements Authentication {

	@Override
	public void applyToParams(List<Pair> queryParams, Map<String, String> headerParams) {
		headerParams.put("x-imi-authorization", "{\"user\": \"T000000\" }");
	}
}
