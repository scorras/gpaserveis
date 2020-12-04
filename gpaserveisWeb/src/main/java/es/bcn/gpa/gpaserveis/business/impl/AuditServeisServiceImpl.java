package es.bcn.gpa.gpaserveis.business.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import es.bcn.gpa.gpaserveis.business.AuditServeisService;
import es.bcn.gpa.gpaserveis.business.dto.audit.AuditServeisBDTO;
import es.bcn.gpa.gpaserveis.business.exception.GPAServeisServiceException;
import es.bcn.gpa.gpaserveis.integration.orm.dao.AuditServeisTramitadorsDao;
import lombok.extern.apachecommons.CommonsLog;
import net.opentrends.openframe.services.security.core.userdetails.ImiUserDetails;
import net.opentrends.openframe.services.security.util.SecurityUtils;

/**
 * The Class ServeisServiceImpl.
 */
@Service
@Qualifier("serveisService")
@CommonsLog
public class AuditServeisServiceImpl implements AuditServeisService {

	/** The audit serveis tramitadors dao. */
	@Autowired(required = true)
	@Qualifier("auditServeisTramitadorsDao")
	private AuditServeisTramitadorsDao auditServeisTramitadorsDao;

	/**
	 * Registrar auditoria de Serveis Tramitadors.
	 * 
	 * @param <E>
	 *
	 * @param auditServeisTramitadorsBDTO
	 *            the audit serveis tramitadors BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public <E> void registrarAuditServeisTramitadors(AuditServeisBDTO auditServeisBDTO, E dadesEntrada, E dadesResposta, E detallError)
			throws GPAServeisServiceException {

		ObjectMapper mapper = new ObjectMapper();

		try {
			auditServeisBDTO.setDadesEntrada(dadesEntrada == null ? "--" : mapper.writeValueAsString(dadesEntrada));
			auditServeisBDTO.setDadesResposta(dadesResposta == null ? "--" : mapper.writeValueAsString(dadesResposta));
			auditServeisBDTO.setDetallError(detallError == null ? "--" : mapper.writeValueAsString(detallError));

			auditServeisTramitadorsDao.insert(auditServeisBDTO);
		} catch (Exception e) {
			throw new GPAServeisServiceException(e);
		}

	}

	/**
	 * Rellenar auditServeisBDTO.
	 *
	 * @return AuditServeisBDTO the audit serveis BDTO
	 * 
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public AuditServeisBDTO rellenarAuditoria() {

		ImiUserDetails userDetails = SecurityUtils.getLoggedUserDetails();

		AuditServeisBDTO auditServeisBDTO = new AuditServeisBDTO();
		auditServeisBDTO.setMomentExecucio(new Date());
		if (userDetails != null) {
			auditServeisBDTO.setDadesAuth(userDetails.getPayload());
			auditServeisBDTO.setUsuari(userDetails.getUsername());
		} else {
			auditServeisBDTO.setDadesAuth("--");
			auditServeisBDTO.setUsuari("--");
		}

		return auditServeisBDTO;
	}
}
