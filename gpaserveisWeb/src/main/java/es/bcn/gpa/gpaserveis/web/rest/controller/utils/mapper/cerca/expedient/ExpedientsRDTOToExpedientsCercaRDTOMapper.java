package es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.cerca.expedient;

import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ExpedientsRDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.cerca.expedient.converter.InternalToDataModificacioConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.cerca.expedient.converter.InternalToDataPresentacioConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.cerca.expedient.converter.InternalToEstatConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.cerca.expedient.converter.InternalToProcedimentConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.cerca.expedient.converter.InternalToSollicitantConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.cerca.expedient.converter.InternalToTramitadorConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.cerca.expedient.converter.InternalToUnitatGestoraConverter;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.cerca.expedients.ExpedientsCercaRDTO;

/**
 * The Class ExpedientsRDTOToExpedientsCercaRDTOMapper.
 */
@Component
public class ExpedientsRDTOToExpedientsCercaRDTOMapper extends PropertyMap<ExpedientsRDTO, ExpedientsCercaRDTO> {

	/** The internal to data presentacio converter. */
	private InternalToDataPresentacioConverter internalToDataPresentacioConverter;

	/** The internal to data modificacio converter. */
	private InternalToDataModificacioConverter internalToDataModificacioConverter;

	/** The internal to sollicitant converter. */
	private InternalToSollicitantConverter internalToSollicitantConverter;

	/** The internal to estat converter. */
	private InternalToEstatConverter internalToEstatConverter;

	/** The internal to tramitador converter. */
	private InternalToTramitadorConverter internalToTramitadorConverter;

	/** The internal to unitat gestora converter. */
	private InternalToUnitatGestoraConverter internalToUnitatGestoraConverter;

	/** The internal to procediment converter. */
	private InternalToProcedimentConverter internalToProcedimentConverter;

	/**
	 * Instantiates a new expedients RDTO to expedients cerca RDTO mapper.
	 *
	 * @param internalToDataPresentacioConverter
	 *            the internal to data presentacio converter
	 * @param internalToDataModificacioConverter
	 *            the internal to data modificacio converter
	 * @param internalToSollicitantConverter
	 *            the internal to sollicitant converter
	 * @param internalToEstatConverter
	 *            the internal to estat converter
	 * @param internalToTramitadorConverter
	 *            the internal to tramitador converter
	 * @param internalToUnitatGestoraConverter
	 *            the internal to unitat gestora converter
	 * @param internalToProcedimentConverter
	 *            the internal to procediment converter
	 */
	@Autowired
	public ExpedientsRDTOToExpedientsCercaRDTOMapper(
	        @Qualifier("expedientInternalToDataPresentacioConverter") InternalToDataPresentacioConverter internalToDataPresentacioConverter,
	        @Qualifier("expedientInternalToDataModificacioConverter") InternalToDataModificacioConverter internalToDataModificacioConverter,
	        @Qualifier("expedientInternalToSollicitantConverter") InternalToSollicitantConverter internalToSollicitantConverter,
	        @Qualifier("expedientInternalToEstatConverter") InternalToEstatConverter internalToEstatConverter,
	        @Qualifier("expedientInternalToTramitadorConverter") InternalToTramitadorConverter internalToTramitadorConverter,
	        @Qualifier("expedientInternalToUnitatGestoraConverter") InternalToUnitatGestoraConverter internalToUnitatGestoraConverter,
	        @Qualifier("expedientInternalToProcedimentConverter") InternalToProcedimentConverter internalToProcedimentConverter) {
		this.internalToDataPresentacioConverter = internalToDataPresentacioConverter;
		this.internalToDataModificacioConverter = internalToDataModificacioConverter;
		this.internalToSollicitantConverter = internalToSollicitantConverter;
		this.internalToEstatConverter = internalToEstatConverter;
		this.internalToTramitadorConverter = internalToTramitadorConverter;
		this.internalToUnitatGestoraConverter = internalToUnitatGestoraConverter;
		this.internalToProcedimentConverter = internalToProcedimentConverter;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.PropertyMap#configure()
	 */
	@Override
	protected void configure() {
		map().setId(source.getId());
		map().setCodi(source.getCodi());
		using(internalToDataPresentacioConverter).map(source.getDataPresentacio()).setDataPresentacio(null);
		using(internalToDataModificacioConverter).map(source.getDarreraModificacio()).setDataModificacio(null);
		using(internalToSollicitantConverter).map(source.getSollicitant()).setSollicitant(null);
		using(internalToEstatConverter).map(source.getEstatActual()).setEstat(null);
		using(internalToTramitadorConverter).map(source.getTramitador()).setTramitador(null);
		map().setAplicacioNegoci(source.getAplicacioNegoci());
		using(internalToUnitatGestoraConverter).map(source.getDescUnitatGestora()).setUnitatGestora(null);
		using(internalToProcedimentConverter).map(source.getNomProcediment()).setProcediment(null);
	}

}
