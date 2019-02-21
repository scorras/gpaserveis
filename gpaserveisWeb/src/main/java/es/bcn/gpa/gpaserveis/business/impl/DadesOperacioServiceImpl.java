package es.bcn.gpa.gpaserveis.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import es.bcn.gpa.gpaserveis.business.DadesOperacioService;
import es.bcn.gpa.gpaserveis.business.dto.procediments.DadesOperacioCercaBDTO;
import es.bcn.gpa.gpaserveis.business.exception.GPAServeisServiceException;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaprocediments.DadesGrupsApi;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.PageDataOfDadesGrupsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaprocediments.ApiException;
import lombok.extern.apachecommons.CommonsLog;

/**
 * The Class DadesOperacioServiceImpl.
 */
@Service
@CommonsLog
public class DadesOperacioServiceImpl implements DadesOperacioService {

	@Autowired
	private DadesGrupsApi dadesGrupsApi;

	@Override
	@HystrixCommand(fallbackMethod = "fallbackCercaDadesOperacio")
	public PageDataOfDadesGrupsRDTO cercaDadesOperacio(DadesOperacioCercaBDTO dadesOperacioCercaBDTO) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("cercaDadesOperacio(DadesOperacioCercaBDTO) - inici"); //$NON-NLS-1$
		}

		try {
			PageDataOfDadesGrupsRDTO pageDataOfDadesGrupsRDTO = dadesGrupsApi.cercaDadesOperacioAgrupats1(
			        dadesOperacioCercaBDTO.getIdProcediment(), dadesOperacioCercaBDTO.getIdTramitOvt(), null, null);

			if (log.isDebugEnabled()) {
				log.debug("cercaDadesOperacio(DadesOperacioCercaBDTO) - fi"); //$NON-NLS-1$
			}
			return pageDataOfDadesGrupsRDTO;
		} catch (ApiException e) {
			log.error("cercaDadesOperacio(DadesOperacioCercaBDTO)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}
	}

	public PageDataOfDadesGrupsRDTO fallbackCercaDadesOperacio(DadesOperacioCercaBDTO dadesOperacioCercaBDTO)
	        throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackCercaDadesOperacio(DadesOperacioCercaBDTO) - inici"); //$NON-NLS-1$
		}

		throw new GPAServeisServiceException("El servei de procediments no està disponible");
	}

}
