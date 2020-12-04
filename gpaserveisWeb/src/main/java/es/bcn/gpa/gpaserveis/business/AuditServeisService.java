package es.bcn.gpa.gpaserveis.business;

import es.bcn.gpa.gpaserveis.business.dto.audit.AuditServeisBDTO;
import es.bcn.gpa.gpaserveis.business.exception.GPAServeisServiceException;

/**
 * The Interface ServeisPortalService.
 */
public interface AuditServeisService {

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
	<E> void registrarAuditServeisTramitadors(AuditServeisBDTO auditServeisBDTO, E dadesEntrada, E dadesResposta, E ex)
			throws GPAServeisServiceException;

	public AuditServeisBDTO rellenarAuditoria();
}
