package es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.cerca.expedient;

import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.business.dto.expedients.DadesExpedientBDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.common.InternalToDataHoraConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient.InternalToCodiConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient.InternalToEstatTramitadorConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient.InternalToPersonaConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient.InternalToProcedimentCercaConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient.InternalToTramitadorConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.unitatgestora.InternalToUnitatGestoraConverter;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.cercar.ExpedientsCercaTramitadorsRDTO;

/**
 * The Class DadesExpedientBDTOToExpedientsCercaTramitadorsRDTOMapper.
 */
@Component
public class DadesExpedientBDTOToExpedientsCercaTramitadorsRDTOMapper
		extends PropertyMap<DadesExpedientBDTO, ExpedientsCercaTramitadorsRDTO> {

	/** The internal to data hora converter. */
	private InternalToDataHoraConverter internalToDataHoraConverter;

	/** The internal to persona converter. */
	private InternalToPersonaConverter internalToPersonaConverter;

	/** The internal to estat tramitador converter. */
	private InternalToEstatTramitadorConverter internalToEstatTramitadorConverter;

	/** The internal to tramitador converter. */
	private InternalToTramitadorConverter internalToTramitadorConverter;

	/** The internal to unitat gestora converter. */
	private InternalToUnitatGestoraConverter internalToUnitatGestoraConverter;

	/** The internal to procediment converter. */
	private InternalToProcedimentCercaConverter internalToProcedimentCercaConverter;

	/** The internal to codi converter. */
	private InternalToCodiConverter internalToCodiConverter;

	@Autowired
	public DadesExpedientBDTOToExpedientsCercaTramitadorsRDTOMapper(
			@Qualifier("internalToDataHoraConverter") InternalToDataHoraConverter internalToDataHoraConverter,
			@Qualifier("expedientInternalToPersonaConverter") InternalToPersonaConverter internalToPersonaConverter,
			@Qualifier("expedientInternalToEstatTramitadorConverter") InternalToEstatTramitadorConverter internalToEstatTramitadorConverter,
			@Qualifier("expedientInternalToTramitadorConverter") InternalToTramitadorConverter internalToTramitadorConverter,
			@Qualifier("internalToUnitatGestoraConverter") InternalToUnitatGestoraConverter internalToUnitatGestoraConverter,
			@Qualifier("expedientInternalToProcedimentCercaConverter") InternalToProcedimentCercaConverter internalToProcedimentCercaConverter,
			@Qualifier("expedientInternalToCodiConverter") InternalToCodiConverter internalToCodiConverter) {
		this.internalToDataHoraConverter = internalToDataHoraConverter;
		this.internalToPersonaConverter = internalToPersonaConverter;
		this.internalToEstatTramitadorConverter = internalToEstatTramitadorConverter;
		this.internalToTramitadorConverter = internalToTramitadorConverter;
		this.internalToUnitatGestoraConverter = internalToUnitatGestoraConverter;
		this.internalToProcedimentCercaConverter = internalToProcedimentCercaConverter;
		this.internalToCodiConverter = internalToCodiConverter;
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
		using(internalToCodiConverter).map(source.getExpedientsRDTO()).setCodi(null);
		using(internalToDataHoraConverter).map(source.getExpedientsRDTO().getDataPresentacio()).setDataPresentacio(null);
		using(internalToDataHoraConverter).map(source.getExpedientsRDTO().getDarreraModificacio()).setDataModificacio(null);
		using(internalToPersonaConverter).map(source.getExpedientsRDTO().getSollicitantPrincipal().getPersones()).setSollicitant(null);
		map().setEstat(source.getExpedientsRDTO().getDescEstatCatala());
		map().setEstatCastella(source.getExpedientsRDTO().getDescEstatCastella());
		using(internalToTramitadorConverter).map(source.getExpedientsRDTO().getTramitador()).setTramitador(null);
		map().setAplicacioNegoci(source.getExpedientsRDTO().getAplicacioNegoci());
		using(internalToUnitatGestoraConverter).map(source.getUnitatsGestoresRDTO()).setUnitatGestora(null);
		using(internalToProcedimentCercaConverter).map(source.getExpedientsRDTO()).setProcediment(null);
	}

}
