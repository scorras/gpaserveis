package es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.consulta.expedient;

import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.InternalToDataHoraConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient.InternalToEstatConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.unitatgestora.InternalToUnitatGestoraConverter;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.DadesExpedientRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.expedients.ExpedientsConsultaRDTO;

/**
 * The Class DadesExpedientRDTOToExpedientsConsultaRDTOMapper.
 */
@Component
public class DadesExpedientRDTOToExpedientsConsultaRDTOMapper extends PropertyMap<DadesExpedientRDTO, ExpedientsConsultaRDTO> {

	/** The internal to data hora converter. */
	private InternalToDataHoraConverter internalToDataHoraConverter;

	/** The internal to unitat gestora converter. */
	private InternalToUnitatGestoraConverter internalToUnitatGestoraConverter;

	private InternalToEstatConverter internalToEstatConverter;

	@Autowired
	public DadesExpedientRDTOToExpedientsConsultaRDTOMapper(
	        @Qualifier("internalToDataHoraConverter") InternalToDataHoraConverter internalToDataHoraConverter,
	        @Qualifier("internalToUnitatGestoraConverter") InternalToUnitatGestoraConverter internalToUnitatGestoraConverter,
	        @Qualifier("expedientInternalToEstatConverter") InternalToEstatConverter internalToEstatConverter) {
		this.internalToDataHoraConverter = internalToDataHoraConverter;
		this.internalToUnitatGestoraConverter = internalToUnitatGestoraConverter;
		this.internalToEstatConverter = internalToEstatConverter;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.PropertyMap#configure()
	 */
	@Override
	protected void configure() {
		map().setId(source.getExpedientsRDTO().getId());
		map().setCodi(source.getExpedientsRDTO().getCodi());
		// TODO Campos calculados? Se refieren a los TramitsOVT asociados a
		// Dades d'Operació o Conf. Doc. de RPA.
		// map().setPermetAportacio(???????);
		// map().setPermetEsmena(??????);
		// map().setPermetAlegacio(???????);
		using(internalToDataHoraConverter).map(source.getExpedientsRDTO().getDataPresentacio()).setDataPresentacio(null);
		using(internalToDataHoraConverter).map(source.getExpedientsRDTO().getDarreraModificacio()).setDataModificacio(null);
		using(internalToUnitatGestoraConverter).map(source.getUnitatsGestoresRDTO()).setUnitatGestora(null);
		using(internalToEstatConverter).map(source.getExpedientsRDTO().getIdEstat()).setEstat(null);

	}

}
