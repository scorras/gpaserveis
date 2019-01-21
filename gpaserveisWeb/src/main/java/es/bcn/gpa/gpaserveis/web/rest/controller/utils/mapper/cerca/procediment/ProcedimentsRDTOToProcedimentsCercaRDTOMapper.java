package es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.cerca.procediment;

import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.ProcedimentsRDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.cerca.procediment.converter.InternalToEstatConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.cerca.procediment.converter.InternalToTramitadorConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.cerca.procediment.converter.InternalToUgoConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.cerca.procediment.converter.InternalToUgrConverter;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.cerca.procediments.ProcedimentsCercaRDTO;

/**
 * The Class ProcedimentsRDTOToProcedimentsCercaRDTOMapper.
 */
@Component
public class ProcedimentsRDTOToProcedimentsCercaRDTOMapper extends PropertyMap<ProcedimentsRDTO, ProcedimentsCercaRDTO> {

	/** The internal to estat converter. */
	private InternalToEstatConverter internalToEstatConverter;

	/** The internal to ugr converter. */
	private InternalToUgrConverter internalToUgrConverter;

	/** The internal to ugo converter. */
	private InternalToUgoConverter internalToUgoConverter;

	/** The internal to tramitador converter. */
	private InternalToTramitadorConverter internalToTramitadorConverter;

	/**
	 * Instantiates a new procediments RDTO to procediments cerca RDTO mapper.
	 *
	 * @param internalToEstatConverter
	 *            the internal to estat converter
	 * @param internalToUgrConverter
	 *            the internal to ugr converter
	 * @param internalToUgoConverter
	 *            the internal to ugo converter
	 * @param internalToTramitadorConverter
	 *            the internal to tramitador converter
	 */
	@Autowired
	public ProcedimentsRDTOToProcedimentsCercaRDTOMapper(InternalToEstatConverter internalToEstatConverter,
	        InternalToUgrConverter internalToUgrConverter, InternalToUgoConverter internalToUgoConverter,
	        InternalToTramitadorConverter internalToTramitadorConverter) {
		this.internalToEstatConverter = internalToEstatConverter;
		this.internalToUgrConverter = internalToUgrConverter;
		this.internalToUgoConverter = internalToUgoConverter;
		this.internalToTramitadorConverter = internalToTramitadorConverter;
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
		map().setVersio(source.getVersio());
		map().setNom(source.getNom());
		map().setDescripcio(source.getDescripcio());
		using(internalToUgrConverter).map(source.getUgrNom()).setUgr(null);
		using(internalToUgoConverter).map(source.getUgosNoms()).setUgo(null);
		using(internalToEstatConverter).map(source.getEstatProcediment()).setEstat(null);
		using(internalToTramitadorConverter).map(source.getReqOperatius().getAplicacioNegoci()).setTramitador(null);
		map().setAplicacioNegoci(source.getReqOperatius().getAplicacioNegoci());

	}

}
