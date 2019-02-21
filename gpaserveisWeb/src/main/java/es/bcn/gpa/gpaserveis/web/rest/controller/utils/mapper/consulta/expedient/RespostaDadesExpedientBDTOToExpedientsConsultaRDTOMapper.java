package es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.consulta.expedient;

import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.business.dto.expedients.DadesExpedientBDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.common.InternalToDataHoraConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.document.InternalToDocumentAportatListConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient.InternalToAccioListConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient.InternalToDocumentsEntradaRequeritsListConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient.InternalToEstatCiutadaConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient.InternalToHistoricEstatCiutadaListConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient.InternalToPersonaConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient.InternalToPersonaListConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient.InternalToProcedimentConsultaConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient.InternalToRegistreConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.unitatgestora.InternalToUnitatGestoraConverter;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.expedients.ExpedientsConsultaRDTO;

/**
 * The Class RespostaDadesExpedientBDTOToExpedientsConsultaRDTOMapper.
 */
@Component
public class RespostaDadesExpedientBDTOToExpedientsConsultaRDTOMapper extends PropertyMap<DadesExpedientBDTO, ExpedientsConsultaRDTO> {

	/** The internal to data hora converter. */
	private InternalToDataHoraConverter internalToDataHoraConverter;

	/** The internal to unitat gestora converter. */
	private InternalToUnitatGestoraConverter internalToUnitatGestoraConverter;

	/** The internal to estat ciutada converter. */
	private InternalToEstatCiutadaConverter internalToEstatCiutadaConverter;

	/** The internal to historic estat ciutada list converter. */
	private InternalToHistoricEstatCiutadaListConverter internalToHistoricEstatCiutadaListConverter;

	/** The internal to procediment consulta converter. */
	private InternalToProcedimentConsultaConverter internalToProcedimentConsultaConverter;

	/** The internal to registre converter. */
	private InternalToRegistreConverter internalToRegistreConverter;

	/** The internal to persona converter. */
	private InternalToPersonaConverter internalToPersonaConverter;

	/** The internal to persona list converter. */
	private InternalToPersonaListConverter internalToPersonaListConverter;

	/** The internal to accio list converter. */
	private InternalToAccioListConverter internalToAccioListConverter;

	/** The internal to document aportat list converter. */
	private InternalToDocumentAportatListConverter internalToDocumentAportatListConverter;

	/** The internal to documents entrada requerits list converter. */
	private InternalToDocumentsEntradaRequeritsListConverter internalToDocumentsEntradaRequeritsListConverter;

	@Autowired
	public RespostaDadesExpedientBDTOToExpedientsConsultaRDTOMapper(
	        @Qualifier("internalToDataHoraConverter") InternalToDataHoraConverter internalToDataHoraConverter,
	        @Qualifier("internalToUnitatGestoraConverter") InternalToUnitatGestoraConverter internalToUnitatGestoraConverter,
	        @Qualifier("expedientInternalToEstatCiutadaConverter") InternalToEstatCiutadaConverter internalToEstatCiutadaConverter,
	        @Qualifier("expedientInternalToHistoricEstatCiutadaListConverter") InternalToHistoricEstatCiutadaListConverter internalToHistoricEstatCiutadaListConverter,
	        @Qualifier("expedientInternalToProcedimentConsultaConverter") InternalToProcedimentConsultaConverter internalToProcedimentConsultaConverter,
	        @Qualifier("expedientInternalToRegistreConverter") InternalToRegistreConverter internalToRegistreConverter,
	        @Qualifier("expedientInternalToPersonaConverter") InternalToPersonaConverter internalToPersonaConverter,
	        @Qualifier("expedientInternalToPersonaListConverter") InternalToPersonaListConverter internalToPersonaListConverter,
	        @Qualifier("expedientInternalToAccioListConverter") InternalToAccioListConverter internalToAccioListConverter,
	        @Qualifier("internalToDocumentAportatListConverter") InternalToDocumentAportatListConverter internalToDocumentAportatListConverter,
	        @Qualifier("expedientInternalToDocumentsEntradaRequeritsListConverter") InternalToDocumentsEntradaRequeritsListConverter internalToDocumentsEntradaRequeritsListConverter) {
		this.internalToDataHoraConverter = internalToDataHoraConverter;
		this.internalToUnitatGestoraConverter = internalToUnitatGestoraConverter;
		this.internalToEstatCiutadaConverter = internalToEstatCiutadaConverter;
		this.internalToHistoricEstatCiutadaListConverter = internalToHistoricEstatCiutadaListConverter;
		this.internalToProcedimentConsultaConverter = internalToProcedimentConsultaConverter;
		this.internalToRegistreConverter = internalToRegistreConverter;
		this.internalToPersonaConverter = internalToPersonaConverter;
		this.internalToPersonaListConverter = internalToPersonaListConverter;
		this.internalToAccioListConverter = internalToAccioListConverter;
		this.internalToDocumentAportatListConverter = internalToDocumentAportatListConverter;
		this.internalToDocumentsEntradaRequeritsListConverter = internalToDocumentsEntradaRequeritsListConverter;
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
		using(internalToUnitatGestoraConverter).map(source.getUnitatsGestoresRDTO()).setUnitatGestora(null);
		// using(internalToEstatCiutadaConverter).map(source.getExpedientsRDTO().getIdEstat()).setEstat(null);
		map().setEstat(source.getExpedientsRDTO().getDescEstatCiutada());
		using(internalToHistoricEstatCiutadaListConverter).map(source.getHistoricsEstats()).setHistorics(null);
		using(internalToProcedimentConsultaConverter).map(source.getExpedientsRDTO()).setProcediment(null);
		using(internalToRegistreConverter).map(source.getExpedientsRDTO().getSollicituds().getRegistreAssentament()).setRegistre(null);
		using(internalToPersonaConverter).map(source.getSollicitant()).setSollicitant(null);
		using(internalToPersonaConverter).map(source.getRepresentant()).setRepresentant(null);
		using(internalToPersonaListConverter).map(source.getPersonesInteressades()).setPersonesInteressades(null);
		using(internalToPersonaListConverter).map(source.getPersonesImplicades()).setPersonesImplicades(null);
		using(internalToAccioListConverter).map(source.getAccionsPossibles()).setAccionsPossibles(null);
		using(internalToDocumentAportatListConverter).map(source.getDocumentsAportats()).setDocumentsAportats(null);
		using(internalToDocumentsEntradaRequeritsListConverter).map(source.getDocumentsRequerits()).setDocumentsRequerits(null);
	}

}
