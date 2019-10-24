package es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.consulta.expedient;

import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.business.dto.expedients.DadesExpedientBDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.common.InternalToDataHoraConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.document.InternalToDocumentAportatConsultaListConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient.InternalToAccioCiutadaListConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient.InternalToCodiConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient.InternalToDadesAtributsRequeritsListConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient.InternalToDadesOperacioListConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient.InternalToDocumentsEntradaRequeritsListConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient.InternalToEstatCiutadaConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient.InternalToHistoricEstatCiutadaListConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient.InternalToPersonaConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient.InternalToPersonaListConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient.InternalToProcedimentConsultaConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient.InternalToRegistreConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.unitatgestora.InternalToUnitatGestoraConverter;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.expedients.ExpedientConsultaRDTO;

/**
 * The Class DadesExpedientBDTOToExpedientsConsultaRDTOMapper.
 */
@Component
public class DadesExpedientBDTOToExpedientsConsultaRDTOMapper extends PropertyMap<DadesExpedientBDTO, ExpedientConsultaRDTO> {

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

	/** The internal to accio ciutada list converter. */
	private InternalToAccioCiutadaListConverter internalToAccioCiutadaListConverter;

	/** The internal to document aportat consulta list converter. */
	private InternalToDocumentAportatConsultaListConverter internalToDocumentAportatConsultaListConverter;

	/** The internal to documents entrada requerits list converter. */
	private InternalToDocumentsEntradaRequeritsListConverter internalToDocumentsEntradaRequeritsListConverter;

	/** The internal to dades operacio list converter. */
	public InternalToDadesOperacioListConverter internalToDadesOperacioListConverter;

	/** The internal to dades atributs requerits list converter. */
	public InternalToDadesAtributsRequeritsListConverter internalToDadesAtributsRequeritsListConverter;

	/** The internal to codi converter. */
	private InternalToCodiConverter internalToCodiConverter;

	/**
	 * Instantiates a new dades expedient BDTO to expedients consulta RDTO
	 * mapper.
	 *
	 * @param internalToDataHoraConverter
	 *            the internal to data hora converter
	 * @param internalToUnitatGestoraConverter
	 *            the internal to unitat gestora converter
	 * @param internalToEstatCiutadaConverter
	 *            the internal to estat ciutada converter
	 * @param internalToHistoricEstatCiutadaListConverter
	 *            the internal to historic estat ciutada list converter
	 * @param internalToProcedimentConsultaConverter
	 *            the internal to procediment consulta converter
	 * @param internalToRegistreConverter
	 *            the internal to registre converter
	 * @param internalToPersonaConverter
	 *            the internal to persona converter
	 * @param internalToPersonaListConverter
	 *            the internal to persona list converter
	 * @param internalToAccioCiutadaListConverter
	 *            the internal to accio ciutada list converter
	 * @param internalToDocumentAportatListConverter
	 *            the internal to document aportat list converter
	 * @param internalToDocumentsEntradaRequeritsListConverter
	 *            the internal to documents entrada requerits list converter
	 * @param internalToDadesOperacioListConverter
	 *            the internal to dades operacio list converter
	 */
	@Autowired
	public DadesExpedientBDTOToExpedientsConsultaRDTOMapper(
			@Qualifier("internalToDataHoraConverter") InternalToDataHoraConverter internalToDataHoraConverter,
			@Qualifier("internalToUnitatGestoraConverter") InternalToUnitatGestoraConverter internalToUnitatGestoraConverter,
			@Qualifier("expedientInternalToEstatCiutadaConverter") InternalToEstatCiutadaConverter internalToEstatCiutadaConverter,
			@Qualifier("expedientInternalToHistoricEstatCiutadaListConverter") InternalToHistoricEstatCiutadaListConverter internalToHistoricEstatCiutadaListConverter,
			@Qualifier("expedientInternalToProcedimentConsultaConverter") InternalToProcedimentConsultaConverter internalToProcedimentConsultaConverter,
			@Qualifier("expedientInternalToRegistreConverter") InternalToRegistreConverter internalToRegistreConverter,
			@Qualifier("expedientInternalToPersonaConverter") InternalToPersonaConverter internalToPersonaConverter,
			@Qualifier("expedientInternalToPersonaListConverter") InternalToPersonaListConverter internalToPersonaListConverter,
			@Qualifier("expedientInternalToAccioCiutadaListConverter") InternalToAccioCiutadaListConverter internalToAccioCiutadaListConverter,
			@Qualifier("internalToDocumentAportatConsultaListConverter") InternalToDocumentAportatConsultaListConverter internalToDocumentAportatConsultaListConverter,
			@Qualifier("expedientInternalToDocumentsEntradaRequeritsListConverter") InternalToDocumentsEntradaRequeritsListConverter internalToDocumentsEntradaRequeritsListConverter,
			@Qualifier("expedientInternalToDadesOperacioListConverter") InternalToDadesOperacioListConverter internalToDadesOperacioListConverter,
			@Qualifier("expedientInternalToDadesAtributsRequeritsListConverter") InternalToDadesAtributsRequeritsListConverter internalToDadesAtributsRequeritsListConverter,
			@Qualifier("expedientInternalToCodiConverter") InternalToCodiConverter internalToCodiConverter) {
		this.internalToDataHoraConverter = internalToDataHoraConverter;
		this.internalToUnitatGestoraConverter = internalToUnitatGestoraConverter;
		this.internalToEstatCiutadaConverter = internalToEstatCiutadaConverter;
		this.internalToHistoricEstatCiutadaListConverter = internalToHistoricEstatCiutadaListConverter;
		this.internalToProcedimentConsultaConverter = internalToProcedimentConsultaConverter;
		this.internalToRegistreConverter = internalToRegistreConverter;
		this.internalToPersonaConverter = internalToPersonaConverter;
		this.internalToPersonaListConverter = internalToPersonaListConverter;
		this.internalToAccioCiutadaListConverter = internalToAccioCiutadaListConverter;
		this.internalToDocumentAportatConsultaListConverter = internalToDocumentAportatConsultaListConverter;
		this.internalToDocumentsEntradaRequeritsListConverter = internalToDocumentsEntradaRequeritsListConverter;
		this.internalToDadesOperacioListConverter = internalToDadesOperacioListConverter;
		this.internalToDadesAtributsRequeritsListConverter = internalToDadesAtributsRequeritsListConverter;
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
		using(internalToDataHoraConverter).map(source.getExpedientsRDTO().getDataAllegacio()).setDataLimitAllegacions(null);
		using(internalToDataHoraConverter).map(source.getExpedientsRDTO().getDataEsmena()).setDataLimitEsmena(null);
		using(internalToUnitatGestoraConverter).map(source.getUnitatsGestoresRDTO()).setUnitatGestora(null);
		map().setEstat(source.getExpedientsRDTO().getDescEstatCiutadaCatala());
		map().setEstatCastella(source.getExpedientsRDTO().getDescEstatCiutadaCastella());
		using(internalToHistoricEstatCiutadaListConverter).map(source.getHistoricsEstats()).setHistorics(null);
		using(internalToProcedimentConsultaConverter).map(source.getExpedientsRDTO()).setProcediment(null);
		using(internalToRegistreConverter).map(source.getExpedientsRDTO().getSollicituds().getRegistreAssentament()).setRegistre(null);
		using(internalToPersonaConverter).map(source.getSollicitant()).setSollicitant(null);
		using(internalToPersonaConverter).map(source.getRepresentant()).setRepresentant(null);
		using(internalToPersonaListConverter).map(source.getPersonesInteressades()).setPersonesInteressades(null);
		using(internalToPersonaListConverter).map(source.getPersonesImplicades()).setPersonesImplicades(null);
		using(internalToAccioCiutadaListConverter).map(source.getAccionsDisponibles()).setAccionsDisponibles(null);
		using(internalToDocumentAportatConsultaListConverter).map(source.getDocumentsAportats()).setDocumentsAportats(null);
		using(internalToDadesOperacioListConverter).map(source.getDadesOperacio()).setDadesOperacio(null);
		using(internalToDocumentsEntradaRequeritsListConverter).map(source).setConfiguracioDocumentacioRequerida(null);
		using(internalToDadesAtributsRequeritsListConverter).map(source).setAtributsRequerits(null);
	}

}
