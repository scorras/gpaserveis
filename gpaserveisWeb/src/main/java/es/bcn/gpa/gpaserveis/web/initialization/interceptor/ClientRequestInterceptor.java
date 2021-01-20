package es.bcn.gpa.gpaserveis.web.initialization.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class ClientRequestInterceptor extends HandlerInterceptorAdapter {

	private ClientEntity clientEntity;

	public ClientRequestInterceptor(ClientEntity clientEntity) {
		this.clientEntity = clientEntity;
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String usuariInteressat = request.getHeader("usuari-interessat");
		clientEntity.setUsuariInteressat(usuariInteressat);
		return true;
	}
}