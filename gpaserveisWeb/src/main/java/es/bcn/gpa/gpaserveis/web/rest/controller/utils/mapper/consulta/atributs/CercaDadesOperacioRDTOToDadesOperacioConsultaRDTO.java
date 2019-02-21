package es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.consulta.atributs;

import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.business.dto.procediments.RespostaDadesOperacioCercaBDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.procediment.InternalToDadesGrupListConverter;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.atributs.DadesOperacioConsultaRDTO;

/**
 * The Class CercaDadesOperacioRDTOToDadesOperacioConsultaRDTO.
 */
@Component
public class CercaDadesOperacioRDTOToDadesOperacioConsultaRDTO
        extends PropertyMap<RespostaDadesOperacioCercaBDTO, DadesOperacioConsultaRDTO> {

	/** The internal to dades grup list converter. */
	private InternalToDadesGrupListConverter internalToDadesGrupListConverter;

	/**
	 * Instantiates a new cerca dades operacio RDTO to dades operacio consulta
	 * RDTO.
	 *
	 * @param internalToDadesGrupListConverter
	 *            the internal to dades grup list converter
	 */
	@Autowired
	public CercaDadesOperacioRDTOToDadesOperacioConsultaRDTO(
	        @Qualifier("procedimentInternalToDadesGrupListConverter") InternalToDadesGrupListConverter internalToDadesGrupListConverter) {
		this.internalToDadesGrupListConverter = internalToDadesGrupListConverter;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.PropertyMap#configure()
	 */
	@Override
	protected void configure() {
		using(internalToDadesGrupListConverter).map(source.getDadesGrupsRDTOList()).setGrups(null);
	}

}
