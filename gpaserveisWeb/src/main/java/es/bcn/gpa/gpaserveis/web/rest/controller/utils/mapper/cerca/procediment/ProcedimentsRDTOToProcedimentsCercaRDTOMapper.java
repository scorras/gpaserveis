package es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.cerca.procediment;

import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.ProcedimentsRDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.procediment.InternalToEstatConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.procediment.InternalToTramitadorConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.unitatgestora.InternalToUnitatGestoraConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.unitatgestora.InternalToUnitatGestoraListConverter;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.cerca.procediments.ProcedimentsCercaRDTO;

/**
 * The Class ExpedientsRDTOToExpedientsCercaRDTOMapper.
 */
@Component
public class ProcedimentsRDTOToProcedimentsCercaRDTOMapper extends PropertyMap<ProcedimentsRDTO, ProcedimentsCercaRDTO> {

	/** The internal to estat converter. */
	private InternalToEstatConverter internalToEstatConverter;

	/** The internal to unitat gestora converter. */
	private InternalToUnitatGestoraConverter internalToUnitatGestoraConverter;

	/** The internal to unitat gestora list converter. */
	private InternalToUnitatGestoraListConverter internalToUnitatGestoraListConverter;

	/** The internal to tramitador converter. */
	private InternalToTramitadorConverter internalToTramitadorConverter;

	/**
	 * Instantiates a new procediments RDTO to procediments cerca RDTO mapper.
	 *
	 * @param internalToEstatConverter
	 *            the internal to estat converter
	 * @param internalToUnitatGestoraConverter
	 *            the internal to unitat gestora converter
	 * @param internalToUnitatGestoraListConverter
	 *            the internal to unitat gestora list converter
	 * @param internalToTramitadorConverter
	 *            the internal to tramitador converter
	 */
	@Autowired
	public ProcedimentsRDTOToProcedimentsCercaRDTOMapper(
	        @Qualifier("procedimentInternalToEstatConverter") InternalToEstatConverter internalToEstatConverter,
	        @Qualifier("internalToUnitatGestoraConverter") InternalToUnitatGestoraConverter internalToUnitatGestoraConverter,
	        @Qualifier("internalToUnitatGestoraListConverter") InternalToUnitatGestoraListConverter internalToUnitatGestoraListConverter,
	        @Qualifier("procedimentInternalToTramitadorConverter") InternalToTramitadorConverter internalToTramitadorConverter) {
		this.internalToEstatConverter = internalToEstatConverter;
		this.internalToUnitatGestoraConverter = internalToUnitatGestoraConverter;
		this.internalToUnitatGestoraListConverter = internalToUnitatGestoraListConverter;
		this.internalToTramitadorConverter = internalToTramitadorConverter;
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
		map().setId(source.getId());
		map().setCodi(source.getCodi());
		map().setVersio(source.getVersio());
		map().setNom(source.getNom());
		map().setDescripcio(source.getDescripcio());
		using(internalToUnitatGestoraConverter).map(source.getUgrIdext()).setUgr(null);
		using(internalToUnitatGestoraListConverter).map(source.getUgosList()).setUgo(null);
		using(internalToEstatConverter).map(source.getEstatsProcediment().getEstats().getId()).setEstat(null);
		using(internalToTramitadorConverter).map(source.getReqOperatius().getAplicacioNegoci()).setTramitador(null);
		map().setAplicacioNegoci(source.getReqOperatius().getAplicacioNegoci());
	}

}
