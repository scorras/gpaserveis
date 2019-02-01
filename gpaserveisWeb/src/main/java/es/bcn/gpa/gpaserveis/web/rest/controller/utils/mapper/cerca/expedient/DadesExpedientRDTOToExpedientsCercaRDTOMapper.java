package es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.cerca.expedient;

import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.InternalToDataHoraConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient.InternalToEstatConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient.InternalToProcedimentConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient.InternalToSollicitantConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient.InternalToTramitadorConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.unitatgestora.InternalToUnitatGestoraConverter;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.DadesExpedientRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.cerca.expedients.ExpedientsCercaRDTO;

/**
 * The Class DadesExpedientRDTOToExpedientsCercaRDTOMapper.
 */
@Component
public class DadesExpedientRDTOToExpedientsCercaRDTOMapper extends PropertyMap<DadesExpedientRDTO, ExpedientsCercaRDTO> {

	/** The internal to data hora converter. */
	private InternalToDataHoraConverter internalToDataHoraConverter;

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
	 * Instantiates a new dades expedient RDTO to expedients cerca RDTO mapper.
	 *
	 * @param internalToDataHoraConverter
	 *            the internal to data hora converter
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
	public DadesExpedientRDTOToExpedientsCercaRDTOMapper(
	        @Qualifier("internalToDataHoraConverter") InternalToDataHoraConverter internalToDataHoraConverter,
	        @Qualifier("expedientInternalToSollicitantConverter") InternalToSollicitantConverter internalToSollicitantConverter,
	        @Qualifier("expedientInternalToEstatConverter") InternalToEstatConverter internalToEstatConverter,
	        @Qualifier("expedientInternalToTramitadorConverter") InternalToTramitadorConverter internalToTramitadorConverter,
	        @Qualifier("internalToUnitatGestoraConverter") InternalToUnitatGestoraConverter internalToUnitatGestoraConverter,
	        @Qualifier("expedientInternalToProcedimentConverter") InternalToProcedimentConverter internalToProcedimentConverter) {
		this.internalToDataHoraConverter = internalToDataHoraConverter;
		this.internalToSollicitantConverter = internalToSollicitantConverter;
		this.internalToEstatConverter = internalToEstatConverter;
		this.internalToTramitadorConverter = internalToTramitadorConverter;
		this.internalToUnitatGestoraConverter = internalToUnitatGestoraConverter;
		this.internalToProcedimentConverter = internalToProcedimentConverter;
	}

	/**
	 * Configure.
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.PropertyMap#configure()
	 */
	@Override
	protected void configure() {
		map().setId(source.getExpedientsRDTO().getId());
		map().setCodi(source.getExpedientsRDTO().getCodi());
		using(internalToDataHoraConverter).map(source.getExpedientsRDTO().getDataPresentacio()).setDataPresentacio(null);
		using(internalToDataHoraConverter).map(source.getExpedientsRDTO().getDarreraModificacio()).setDataModificacio(null);
		using(internalToSollicitantConverter).map(source.getExpedientsRDTO().getSollicitant()).setSollicitant(null);
		using(internalToEstatConverter).map(source.getExpedientsRDTO().getEstatActual()).setEstat(null);
		using(internalToTramitadorConverter).map(source.getExpedientsRDTO().getTramitador()).setTramitador(null);
		map().setAplicacioNegoci(source.getExpedientsRDTO().getAplicacioNegoci());
		using(internalToUnitatGestoraConverter).map(source.getUnitatsGestoresRDTO()).setUnitatGestora(null);
		using(internalToProcedimentConverter).map(source.getExpedientsRDTO().getNomProcediment()).setProcediment(null);
	}

}
