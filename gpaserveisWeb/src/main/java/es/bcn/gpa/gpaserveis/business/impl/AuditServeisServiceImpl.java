package es.bcn.gpa.gpaserveis.business.impl;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import es.bcn.gpa.gpaserveis.business.AuditServeisService;
import es.bcn.gpa.gpaserveis.business.dto.audit.AuditServeisBDTO;
import es.bcn.gpa.gpaserveis.business.exception.GPAServeisServiceException;
import es.bcn.gpa.gpaserveis.integration.orm.dao.AuditServeisMdsDao;
import es.bcn.gpa.gpaserveis.integration.orm.dao.AuditServeisNotificacionsDao;
import es.bcn.gpa.gpaserveis.integration.orm.dao.AuditServeisPortaSignaturesDao;
import es.bcn.gpa.gpaserveis.integration.orm.dao.AuditServeisPortalDao;
import es.bcn.gpa.gpaserveis.integration.orm.dao.AuditServeisPortalSollicitudsDao;
import es.bcn.gpa.gpaserveis.integration.orm.dao.AuditServeisSignaturesDao;
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

	@Autowired(required = true)
	@Qualifier("auditServeisMdsDao")
	private AuditServeisMdsDao auditServeisMdsDao;

	@Autowired(required = true)
	@Qualifier("auditServeisPortalDao")
	private AuditServeisPortalDao auditServeisPortalDao;

	@Autowired(required = true)
	@Qualifier("auditServeisPortalSollicitudsDao")
	private AuditServeisPortalSollicitudsDao auditServeisPortalSollicitudsDao;

	@Autowired(required = true)
	@Qualifier("auditServeisNotificacionsDao")
	private AuditServeisNotificacionsDao auditServeisNotificacionsDao;

	@Autowired(required = true)
	@Qualifier("auditServeisSignaturesDao")
	private AuditServeisSignaturesDao auditServeisSignaturesDao;

	@Autowired(required = true)
	@Qualifier("auditServeisPortaSignaturesDao")
	private AuditServeisPortaSignaturesDao auditServeisPortaSignaturesDao;

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

	public <E> void registrarAuditServeisMds(AuditServeisBDTO auditServeisBDTO, E dadesEntrada, E dadesResposta, E detallError)
			throws GPAServeisServiceException {

		ObjectMapper mapper = new ObjectMapper();

		try {
			auditServeisBDTO.setDadesEntrada(dadesEntrada == null ? "--" : mapper.writeValueAsString(dadesEntrada));
			auditServeisBDTO.setDadesResposta(dadesResposta == null ? "--" : mapper.writeValueAsString(dadesResposta));
			auditServeisBDTO.setDetallError(detallError == null ? "--" : mapper.writeValueAsString(detallError));

			auditServeisMdsDao.insert(auditServeisBDTO);
		} catch (Exception e) {
			throw new GPAServeisServiceException(e);
		}

	}

	public <E> void registrarAuditServeisPortal(AuditServeisBDTO auditServeisBDTO, E dadesEntrada, E dadesResposta, E detallError)
			throws GPAServeisServiceException {

		ObjectMapper mapper = new ObjectMapper();

		try {
			auditServeisBDTO.setDadesEntrada(dadesEntrada == null ? "--" : mapper.writeValueAsString(dadesEntrada));
			auditServeisBDTO.setDadesResposta(dadesResposta == null ? "--" : mapper.writeValueAsString(dadesResposta));
			auditServeisBDTO.setDetallError(detallError == null ? "--" : mapper.writeValueAsString(detallError));

			auditServeisPortalDao.insert(auditServeisBDTO);
		} catch (Exception e) {
			throw new GPAServeisServiceException(e);
		}

	}

	public <E> void registrarAuditServeisPortalSollicituds(AuditServeisBDTO auditServeisBDTO, E dadesEntrada, E dadesResposta,
			E detallError) throws GPAServeisServiceException {

		ObjectMapper mapper = new ObjectMapper();

		try {
			auditServeisBDTO.setDadesEntrada(dadesEntrada == null ? "--" : mapper.writeValueAsString(dadesEntrada));
			auditServeisBDTO.setDadesResposta(dadesResposta == null ? "--" : mapper.writeValueAsString(dadesResposta));
			auditServeisBDTO.setDetallError(detallError == null ? "--" : mapper.writeValueAsString(detallError));

			auditServeisPortalSollicitudsDao.insert(auditServeisBDTO);
		} catch (Exception e) {
			throw new GPAServeisServiceException(e);
		}

	}

	public <E> void registrarAuditServeisNotificacions(AuditServeisBDTO auditServeisBDTO, E dadesEntrada, E dadesResposta, E detallError)
			throws GPAServeisServiceException {

		ObjectMapper mapper = new ObjectMapper();

		try {
			auditServeisBDTO.setDadesEntrada(dadesEntrada == null ? "--" : mapper.writeValueAsString(dadesEntrada));
			auditServeisBDTO.setDadesResposta(dadesResposta == null ? "--" : mapper.writeValueAsString(dadesResposta));
			auditServeisBDTO.setDetallError(detallError == null ? "--" : mapper.writeValueAsString(detallError));

			auditServeisNotificacionsDao.insert(auditServeisBDTO);
		} catch (Exception e) {
			throw new GPAServeisServiceException(e);
		}

	}

	public <E> void registrarAuditServeisSignatures(AuditServeisBDTO auditServeisBDTO, E dadesEntrada, E dadesResposta, E detallError)
			throws GPAServeisServiceException {

		ObjectMapper mapper = new ObjectMapper();

		try {
			auditServeisBDTO.setDadesEntrada(dadesEntrada == null ? "--" : mapper.writeValueAsString(dadesEntrada));
			auditServeisBDTO.setDadesResposta(dadesResposta == null ? "--" : mapper.writeValueAsString(dadesResposta));
			auditServeisBDTO.setDetallError(detallError == null ? "--" : mapper.writeValueAsString(detallError));

			auditServeisSignaturesDao.insert(auditServeisBDTO);
		} catch (Exception e) {
			throw new GPAServeisServiceException(e);
		}

	}

	public <E> void registrarAuditServeisPortaSignatures(AuditServeisBDTO auditServeisBDTO, E dadesEntrada, E dadesResposta, E detallError)
			throws GPAServeisServiceException {

		ObjectMapper mapper = new ObjectMapper();

		try {
			auditServeisBDTO.setDadesEntrada(dadesEntrada == null ? "--" : mapper.writeValueAsString(dadesEntrada));
			auditServeisBDTO.setDadesResposta(dadesResposta == null ? "--" : mapper.writeValueAsString(dadesResposta));
			auditServeisBDTO.setDetallError(detallError == null ? "--" : mapper.writeValueAsString(detallError));

			auditServeisPortaSignaturesDao.insert(auditServeisBDTO);
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
		if (userDetails != null && StringUtils.isNotEmpty(userDetails.getUsername())) {
			auditServeisBDTO.setDadesAuth(userDetails.getPayload());
			auditServeisBDTO.setUsuari(userDetails.getUsername());
		} else {
			auditServeisBDTO.setDadesAuth("--");
			auditServeisBDTO.setUsuari("--");
		}

		return auditServeisBDTO;
	}
}
