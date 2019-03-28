package es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient;

import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ExpedientsRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.cerca.procediments.ProcedimentsCercaRDTO;

/**
 * The Class InternalToProcedimentCercaConverter.
 */
@Component("expedientInternalToProcedimentCercaConverter")
public class InternalToProcedimentCercaConverter extends AbstractConverter<ExpedientsRDTO, ProcedimentsCercaRDTO> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.AbstractConverter#convert(java.lang.Object)
	 */
	@Override
	protected ProcedimentsCercaRDTO convert(ExpedientsRDTO source) {
		ProcedimentsCercaRDTO procedimentsCercaRDTO = new ProcedimentsCercaRDTO();
		procedimentsCercaRDTO.setId(source.getProcedimentIdext());
		procedimentsCercaRDTO.setCodi(source.getProcedimentCodi());
		procedimentsCercaRDTO.setVersio(source.getProcedimentVersio());
		procedimentsCercaRDTO.setNom(source.getNomProcediment());
		procedimentsCercaRDTO.setNomCastella(source.getNomProcedimentCastella());
		return procedimentsCercaRDTO;
	}
}