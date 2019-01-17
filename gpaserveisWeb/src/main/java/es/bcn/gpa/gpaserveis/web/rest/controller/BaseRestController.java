package es.bcn.gpa.gpaserveis.web.rest.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import es.bcn.gpa.gpaserveis.web.rest.exception.GPAServeisRuntimeException;
import es.bcn.gpa.gpaserveis.web.rest.exception.GPAServeisServiceException;
import net.opentrends.openframe.services.rest.controller.AbstractRestController;
import net.opentrends.openframe.services.rest.exception.ResourceNotFoundException;
import net.opentrends.openframe.services.rest.support.ErrorSupport;

public class BaseRestController extends AbstractRestController {
	/**
	 * Logger for this class
	 */
	private static final Log LOGGER = LogFactory.getLog(BaseRestController.class);

	@ExceptionHandler
	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorSupport handleException(HttpServletRequest req, es.bcn.gpa.gpaserveis.rest.client.invoker.gpaprocediments.ApiException ex) {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(
			        "handleException(HttpServletRequest, es.bcn.gpa.gpaserveis.rest.client.invoker.gpaprocediments.ApiException) - inici"); //$NON-NLS-1$
		}

		if (LOGGER.isErrorEnabled()) {
			LOGGER.error("S'ha produït una incidència", ex); //$NON-NLS-1$
		}

		ErrorSupport errorSupport = new ErrorSupport(req, ex);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(
			        "handleException(HttpServletRequest, es.bcn.gpa.gpaserveis.rest.client.invoker.gpaprocediments.ApiException) - fi"); //$NON-NLS-1$
		}
		return errorSupport;
	}

	@ExceptionHandler
	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorSupport handleException(HttpServletRequest req, es.bcn.gpa.gpaserveis.rest.client.invoker.gpaunitats.ApiException ex) {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("handleException(HttpServletRequest, es.bcn.gpa.gpaserveis.rest.client.invoker.gpaunitats.ApiException) - inici"); //$NON-NLS-1$
		}

		if (LOGGER.isErrorEnabled()) {
			LOGGER.error("S'ha produït una incidència", ex); //$NON-NLS-1$
		}

		ErrorSupport errorSupport = new ErrorSupport(req, ex);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("handleException(HttpServletRequest, es.bcn.gpa.gpaserveis.rest.client.invoker.gpaunitats.ApiException) - fi"); //$NON-NLS-1$
		}
		return errorSupport;
	}

	@ExceptionHandler
	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorSupport handleException(HttpServletRequest req, es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.ApiException ex) {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(
			        "handleException(HttpServletRequest, es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.ApiException) - inici"); //$NON-NLS-1$
		}

		if (LOGGER.isErrorEnabled()) {
			LOGGER.error("S'ha produït una incidència", ex); //$NON-NLS-1$
		}

		ErrorSupport errorSupport = new ErrorSupport(req, ex);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("handleException(HttpServletRequest, es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.ApiException) - fi"); //$NON-NLS-1$
		}
		return errorSupport;
	}

	@ExceptionHandler
	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorSupport handleException(HttpServletRequest req, GPAServeisServiceException ex) {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("handleException(HttpServletRequest, GPAServeisServiceException) - inici"); //$NON-NLS-1$
		}

		if (LOGGER.isErrorEnabled()) {
			LOGGER.error("S'ha produït una incidència", ex); //$NON-NLS-1$
		}

		ErrorSupport errorSupport = new ErrorSupport(req, ex);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("handleException(HttpServletRequest, GPAServeisServiceException) - fi"); //$NON-NLS-1$
		}
		return errorSupport;
	}

	@ExceptionHandler
	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorSupport handleException(HttpServletRequest req, GPAServeisRuntimeException ex) {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("handleException(HttpServletRequest, GPAServeisRuntimeException) - inici"); //$NON-NLS-1$
		}

		if (LOGGER.isErrorEnabled()) {
			LOGGER.error("S'ha produït una incidència", ex); //$NON-NLS-1$
		}
		ErrorSupport errorSupport = new ErrorSupport(req, ex);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("handleException(HttpServletRequest, GPAServeisRuntimeException) - fi"); //$NON-NLS-1$
		}
		return errorSupport;
	}

	@ExceptionHandler
	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorSupport handleException(HttpServletRequest req, RuntimeException ex) {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("handleException(HttpServletRequest, RuntimeException) - inici"); //$NON-NLS-1$
		}

		if (LOGGER.isErrorEnabled()) {
			LOGGER.error("S'ha produït una incidència", ex); //$NON-NLS-1$
		}
		ErrorSupport errorSupport = new ErrorSupport(req, ex);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("handleException(HttpServletRequest, RuntimeException) - fi"); //$NON-NLS-1$
		}
		return errorSupport;
	}

	@ExceptionHandler
	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorSupport handleException(HttpServletRequest req, ResourceNotFoundException ex) {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("handleException(HttpServletRequest, ResourceNotFoundException) - inici"); //$NON-NLS-1$
		}

		if (LOGGER.isErrorEnabled()) {
			LOGGER.error("S'ha produït una incidència", ex); //$NON-NLS-1$
		}
		ErrorSupport errorSupport = new ErrorSupport(req, ex);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("handleException(HttpServletRequest, ResourceNotFoundException) - fi"); //$NON-NLS-1$
		}
		return errorSupport;
	}

	@ExceptionHandler
	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorSupport handleException(HttpServletRequest req, Throwable ex) {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("handleException(HttpServletRequest, Throwable) - inici"); //$NON-NLS-1$
		}

		if (LOGGER.isErrorEnabled()) {
			LOGGER.error("S'ha produït una incidència", ex); //$NON-NLS-1$
		}
		ErrorSupport errorSupport = new ErrorSupport(req, ex);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("handleException(HttpServletRequest, Throwable) - fi"); //$NON-NLS-1$
		}
		return errorSupport;
	}

}
