package es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.cerca.procediment;

import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.business.dto.procediments.DadesProcedimentBDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.procediment.InternalToEstatConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.procediment.InternalToTramitadorConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.unitatgestora.InternalToUnitatGestoraConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.unitatgestora.InternalToUnitatGestoraListConverter;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.cerca.procediments.ProcedimentsCercaRDTO;

/**
 * The Class DadesProcedimentBDTOToProcedimentsCercaRDTOMapper.
 */
@Component
public class DadesProcedimentBDTOToProcedimentsCercaRDTOMapper extends PropertyMap<DadesProcedimentBDTO, ProcedimentsCercaRDTO> {

	/** The internal to estat converter. */
	private InternalToEstatConverter internalToEstatConverter;

	/** The internal to unitat gestora converter. */
	private InternalToUnitatGestoraConverter internalToUnitatGestoraConverter;

	/** The internal to unitat gestora list converter. */
	private InternalToUnitatGestoraListConverter internalToUnitatGestoraListConverter;

	/** The internal to tramitador converter. */
	private InternalToTramitadorConverter internalToTramitadorConverter;

	/**
	 * Instantiates a new resposta dades procediment BDTO to procediments cerca
	 * RDTO mapper.
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
	public DadesProcedimentBDTOToProcedimentsCercaRDTOMapper(
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
		map().setId(source.getProcedimentsRDTO().getId());
		map().setCodi(source.getProcedimentsRDTO().getCodi());
		map().setVersio(source.getProcedimentsRDTO().getVersio());
		map().setNom(source.getProcedimentsRDTO().getNom());
		map().setNomCastella(source.getProcedimentsRDTO().getNomCastella());
		map().setDescripcio(source.getProcedimentsRDTO().getDescripcio());
		using(internalToUnitatGestoraConverter).map(source.getUgrRDTO()).setUgr(null);
		using(internalToUnitatGestoraListConverter).map(source.getUgoRDTOList()).setUgo(null);
		// using(internalToEstatConverter).map(source.getProcedimentsRDTO().getEstatsProcediment().getEstats().getId()).setEstat(null);
		map().setEstat(source.getProcedimentsRDTO().getEstatsProcediment().getEstats().getDescripcio());
		using(internalToTramitadorConverter).map(source.getProcedimentsRDTO().getReqOperatius().getAplicacioNegoci()).setTramitador(null);
		map().setAplicacioNegoci(source.getProcedimentsRDTO().getReqOperatius().getAplicacioNegoci());
		map().setOrganResolutori(source.getProcedimentsRDTO().getIdentificacions().getOrganResolutori());
	}

}
