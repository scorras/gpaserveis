package es.bcn.gpa.gpaserveis.web.initialization.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import lombok.extern.apachecommons.CommonsLog;

@CommonsLog
public class ClientRequestInterceptor extends HandlerInterceptorAdapter {

	private ClientEntity clientEntity;

	public ClientRequestInterceptor(ClientEntity clientEntity) {
		this.clientEntity = clientEntity;
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String usuariInteressat = request.getHeader("usuari-interessat");
		log.info("Header usuari-interessat: " + usuariInteressat);
		clientEntity.setUsuariInteressat(usuariInteressat);

		String usuariAutenticat = request.getHeader("usuari-autenticat");
		log.info("Header usuari-autenticat: " + usuariAutenticat);
		clientEntity.setUsuariAutenticat(usuariAutenticat);
		return true;
	}
}