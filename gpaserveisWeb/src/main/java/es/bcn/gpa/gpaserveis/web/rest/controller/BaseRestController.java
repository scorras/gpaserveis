package es.bcn.gpa.gpaserveis.web.rest.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import es.bcn.gpa.gpaserveis.business.exception.GPAServeisRuntimeException;
import es.bcn.gpa.gpaserveis.business.exception.GPAServeisServiceException;
import lombok.extern.apachecommons.CommonsLog;
import net.opentrends.openframe.services.rest.controller.AbstractRestController;
import net.opentrends.openframe.services.rest.exception.ResourceNotFoundException;
import net.opentrends.openframe.services.rest.support.ErrorSupport;

@CommonsLog
public class BaseRestController extends AbstractRestController {

	@ExceptionHandler
	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorSupport handleException(HttpServletRequest req, GPAServeisServiceException ex) {
		if (log.isDebugEnabled()) {
			log.debug("handleException(HttpServletRequest, GPAServeisServiceException) - inici"); //$NON-NLS-1$
		}

		if (log.isErrorEnabled()) {
			log.error("S'ha produït una incidència", ex); //$NON-NLS-1$
		}

		ErrorSupport errorSupport = new ErrorSupport(req, ex);

		if (log.isDebugEnabled()) {
			log.debug("handleException(HttpServletRequest, GPAServeisServiceException) - fi"); //$NON-NLS-1$
		}
		return errorSupport;
	}

	@ExceptionHandler
	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorSupport handleException(HttpServletRequest req, GPAServeisRuntimeException ex) {
		if (log.isDebugEnabled()) {
			log.debug("handleException(HttpServletRequest, GPAServeisRuntimeException) - inici"); //$NON-NLS-1$
		}

		if (log.isErrorEnabled()) {
			log.error("S'ha produït una incidència", ex); //$NON-NLS-1$
		}
		ErrorSupport errorSupport = new ErrorSupport(req, ex);

		if (log.isDebugEnabled()) {
			log.debug("handleException(HttpServletRequest, GPAServeisRuntimeException) - fi"); //$NON-NLS-1$
		}
		return errorSupport;
	}

	@ExceptionHandler
	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorSupport handleException(HttpServletRequest req, RuntimeException ex) {
		if (log.isDebugEnabled()) {
			log.debug("handleException(HttpServletRequest, RuntimeException) - inici"); //$NON-NLS-1$
		}

		if (log.isErrorEnabled()) {
			log.error("S'ha produït una incidència", ex); //$NON-NLS-1$
		}
		ErrorSupport errorSupport = new ErrorSupport(req, ex);

		if (log.isDebugEnabled()) {
			log.debug("handleException(HttpServletRequest, RuntimeException) - fi"); //$NON-NLS-1$
		}
		return errorSupport;
	}

	@ExceptionHandler
	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorSupport handleException(HttpServletRequest req, ResourceNotFoundException ex) {
		if (log.isDebugEnabled()) {
			log.debug("handleException(HttpServletRequest, ResourceNotFoundException) - inici"); //$NON-NLS-1$
		}

		if (log.isErrorEnabled()) {
			log.error("S'ha produït una incidència", ex); //$NON-NLS-1$
		}
		ErrorSupport errorSupport = new ErrorSupport(req, ex);

		if (log.isDebugEnabled()) {
			log.debug("handleException(HttpServletRequest, ResourceNotFoundException) - fi"); //$NON-NLS-1$
		}
		return errorSupport;
	}

	@ExceptionHandler
	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorSupport handleException(HttpServletRequest req, Throwable ex) {
		if (log.isDebugEnabled()) {
			log.debug("handleException(HttpServletRequest, Throwable) - inici"); //$NON-NLS-1$
		}

		if (log.isErrorEnabled()) {
			log.error("S'ha produït una incidència", ex); //$NON-NLS-1$
		}
		ErrorSupport errorSupport = new ErrorSupport(req, ex);

		if (log.isDebugEnabled()) {
			log.debug("handleException(HttpServletRequest, Throwable) - fi"); //$NON-NLS-1$
		}
		return errorSupport;
	}

}
