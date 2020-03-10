package es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.consulta.sollicitud;

import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.business.dto.expedients.DadesSollicitudBDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.common.InternalToDataHoraConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.document.InternalToDocumentAportatConsultaListConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient.InternalToExpedientAccioConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient.InternalToPersonaConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient.InternalToPersonaListConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient.InternalToProcedimentConsultaConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient.InternalToRegistreConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.sollicitud.InternalToDadesOperacioListConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.tramit.InternalToTramitOvtConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.unitatgestora.InternalToUnitatGestoraConverter;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.sollicituds.SollicitudConsultaRDTO;

/**
 * The Class DadesSollicitudBDTOToSollicitudsConsultaRDTOMapper.
 */
@Component
public class DadesSollicitudBDTOToSollicitudsConsultaRDTOMapper extends PropertyMap<DadesSollicitudBDTO, SollicitudConsultaRDTO> {

	/** The internal to tramit ovt converter. */
	private InternalToTramitOvtConverter internalToTramitOvtConverter;

	/** The internal to data hora converter. */
	private InternalToDataHoraConverter internalToDataHoraConverter;

	/** The internal to expedient accio converter. */
	private InternalToExpedientAccioConverter internalToExpedientAccioConverter;

	/** The internal to registre converter. */
	private InternalToRegistreConverter internalToRegistreConverter;

	/** The internal to persona converter. */
	private InternalToPersonaConverter internalToPersonaConverter;

	/** The internal to persona list converter. */
	private InternalToPersonaListConverter internalToPersonaListConverter;

	/** The internal to document aportat consulta list converter. */
	private InternalToDocumentAportatConsultaListConverter internalToDocumentAportatConsultaListConverter;

	/** The internal to dades operacio list converter. */
	private InternalToDadesOperacioListConverter internalToDadesOperacioListConverter;

	/** The internal to procediment consulta converter. */
	private InternalToProcedimentConsultaConverter internalToProcedimentConsultaConverter;

	/** The internal to unitat gestora converter. */
	private InternalToUnitatGestoraConverter internalToUnitatGestoraConverter;

	/**
	 * Instantiates a new dades sollicitud BDTO to sollicituds consulta RDTO
	 * mapper.
	 *
	 * @param internalToTramitOvtConverter
	 *            the internal to tramit ovt converter
	 * @param internalToDataHoraConverter
	 *            the internal to data hora converter
	 * @param internalToExpedientAccioConverter
	 *            the internal to expedient accio converter
	 * @param internalToRegistreConverter
	 *            the internal to registre converter
	 * @param internalToPersonaConverter
	 *            the internal to persona converter
	 * @param internalToPersonaListConverter
	 *            the internal to persona list converter
	 * @param internalToDocumentAportatConsultaListConverter
	 *            the internal to document aportat consulta list converter
	 * @param internalToDadesOperacioListConverter
	 *            the internal to dades operacio list converter
	 * @param internalToProcedimentConsultaConverter
	 *            the internal to procediment consulta converter
	 * @param internalToUnitatGestoraConverter
	 *            the internal to unitat gestora converter
	 */
	@Autowired
	public DadesSollicitudBDTOToSollicitudsConsultaRDTOMapper(
	        @Qualifier("tramitInternalToTramitOvtConverter") InternalToTramitOvtConverter internalToTramitOvtConverter,
	        @Qualifier("internalToDataHoraConverter") InternalToDataHoraConverter internalToDataHoraConverter,
	        @Qualifier("expedientInternalToExpedientAccioConverter") InternalToExpedientAccioConverter internalToExpedientAccioConverter,
	        @Qualifier("expedientInternalToRegistreConverter") InternalToRegistreConverter internalToRegistreConverter,
	        @Qualifier("expedientInternalToPersonaConverter") InternalToPersonaConverter internalToPersonaConverter,
	        @Qualifier("expedientInternalToPersonaListConverter") InternalToPersonaListConverter internalToPersonaListConverter,
	        @Qualifier("internalToDocumentAportatConsultaListConverter") InternalToDocumentAportatConsultaListConverter internalToDocumentAportatConsultaListConverter,
	        @Qualifier("sollicitudInternalToDadesOperacioListConverter") InternalToDadesOperacioListConverter internalToDadesOperacioListConverter,
	        @Qualifier("expedientInternalToProcedimentConsultaConverter") InternalToProcedimentConsultaConverter internalToProcedimentConsultaConverter,
	        @Qualifier("internalToUnitatGestoraConverter") InternalToUnitatGestoraConverter internalToUnitatGestoraConverter) {
		this.internalToTramitOvtConverter = internalToTramitOvtConverter;
		this.internalToDataHoraConverter = internalToDataHoraConverter;
		this.internalToExpedientAccioConverter = internalToExpedientAccioConverter;
		this.internalToRegistreConverter = internalToRegistreConverter;
		this.internalToPersonaConverter = internalToPersonaConverter;
		this.internalToPersonaListConverter = internalToPersonaListConverter;
		this.internalToDocumentAportatConsultaListConverter = internalToDocumentAportatConsultaListConverter;
		this.internalToDadesOperacioListConverter = internalToDadesOperacioListConverter;
		this.internalToProcedimentConsultaConverter = internalToProcedimentConsultaConverter;
		this.internalToUnitatGestoraConverter = internalToUnitatGestoraConverter;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.PropertyMap#configure()
	 */
	@Override
	protected void configure() {
		map().setId(source.getSollicitudsRDTO().getId());
		map().setHash(source.getSollicitudsRDTO().getHash());
		using(internalToTramitOvtConverter).map(source.getSollicitudsRDTO().getTramitOvtIdext()).setTramit(null);
		using(internalToDataHoraConverter).map(source.getSollicitudsRDTO().getDataSollicitud()).setDataSollicitud(null);
		using(internalToDataHoraConverter).map(source.getSollicitudsRDTO().getDataPresentacio()).setDataPresentacio(null);
		using(internalToExpedientAccioConverter).map(source.getExpedientsRDTO()).setExpedient(null);
		using(internalToRegistreConverter).map(source.getSollicitudsRDTO().getRegistreAssentament()).setRegistre(null);
		using(internalToPersonaConverter).map(source.getSollicitant()).setSollicitant(null);
		using(internalToPersonaConverter).map(source.getRepresentant()).setRepresentant(null);
		using(internalToPersonaListConverter).map(source.getPersonesInteressades()).setPersonesInteressades(null);
		using(internalToPersonaListConverter).map(source.getPersonesImplicades()).setPersonesImplicades(null);
		using(internalToDocumentAportatConsultaListConverter).map(source.getDocumentsAportats()).setDocumentsAportats(null);
		using(internalToDadesOperacioListConverter).map(source.getDadesOperacio()).setDadesOperacio(null);
		using(internalToProcedimentConsultaConverter).map(source.getExpedientsRDTO()).setProcediment(null);
		using(internalToUnitatGestoraConverter).map(source.getUnitatsGestoresRDTO()).setUnitatGestora(null);
	}

}
