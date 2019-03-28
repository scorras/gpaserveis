package es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient;

import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ExpedientsRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.procediments.ProcedimentsConsultaRDTO;

/**
 * The Class InternalToProcedimentConsultaConverter.
 */
@Component("expedientInternalToProcedimentConsultaConverter")
public class InternalToProcedimentConsultaConverter extends AbstractConverter<ExpedientsRDTO, ProcedimentsConsultaRDTO> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.AbstractConverter#convert(java.lang.Object)
	 */
	@Override
	protected ProcedimentsConsultaRDTO convert(ExpedientsRDTO source) {
		ProcedimentsConsultaRDTO procedimentsConsultaRDTO = new ProcedimentsConsultaRDTO();
		procedimentsConsultaRDTO.setId(source.getProcedimentIdext());
		procedimentsConsultaRDTO.setCodi(source.getProcedimentCodi());
		procedimentsConsultaRDTO.setVersio(source.getProcedimentVersio());
		procedimentsConsultaRDTO.setNom(source.getNomProcediment());
		procedimentsConsultaRDTO.setNomCastella(source.getNomProcedimentCastella());
		return procedimentsConsultaRDTO;
	}
}