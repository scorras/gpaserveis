package es.bcn.gpa.gpaserveis.test.parent;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Matchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.io.File;
import java.math.BigDecimal;
import java.util.List;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import es.bcn.gpa.gpaserveis.business.exception.GPAServeisRuntimeException;
import es.bcn.gpa.gpaserveis.rest.client.api.gpadocumentacio.ConfiguracioDocumentacioApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpadocumentacio.DocumentacioApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpadocumentacio.DocumentacioRequeritApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpadocumentacio.DownloadEntradaApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.AcumulaciExpedientsApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.AvisosApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.CanviUnitatGestoraApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.ComentarisApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.ConvidarATramitartApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.DadesEspecifiquesApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.EstatsApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.ExpedientsApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.Expedients_Api;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.PersonesInteressades_Api;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.PersonesSollicitudApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.Persones_Api;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.RetornarLaTramitacioApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaprocediments.DadesGrupsApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaprocediments.DadesOperacionsApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaprocediments.ProcedimentsApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpatramits.AccionsEstatsApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpatramits.TramitsApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpatramits.TramitsOvtApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaunitats.UnitatsGestoresApi;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsTramitacioRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocumentRevisio;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.SignarDocument;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ActualitzarDadesSollicitud;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.AcumularExpedientRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.AvisCreacioAccio;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.CanviUnitatGestoraRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ComentariCreacioAccio;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ConvidarTramitarRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.CrearRegistre;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ExpedientCanviEstatAccio;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ExpedientsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PersonesSollicitudRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RetornarLaTramitacioRDTO;
import es.bcn.gpa.gpaserveis.test.config.TestsConfigHelper;
import lombok.extern.apachecommons.CommonsLog;
import net.opentrends.openframe.services.configuration.context.ContextPropertySourcesInitializer;

/**
 * The Class ParentTest.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {}, initializers = ContextPropertySourcesInitializer.class)
@CommonsLog
public abstract class ParentTest {

	/** The procediments api. */
	@Autowired
	protected ProcedimentsApi procedimentsApi;

	/** The unitats gestores api. */
	@Autowired
	protected UnitatsGestoresApi unitatsGestoresApi;

	/** The tramits api. */
	@Autowired
	protected TramitsApi tramitsApi;

	/** The expedients api. */
	@Autowired
	protected Expedients_Api expedients_Api;

	/** The expedients api. */
	@Autowired
	protected ExpedientsApi expedientsApi;

	/** The persones interessades api. */
	@Autowired
	protected PersonesInteressades_Api personesInteressades_Api;

	/** The persones api. */
	@Autowired
	protected Persones_Api persones_Api;

	/** The tramits ovt api. */
	@Autowired
	protected TramitsOvtApi tramitsOvtApi;

	/** The dades grups api. */
	@Autowired
	protected DadesGrupsApi dadesGrupsApi;

	/** The configuracio documentacio api. */
	@Autowired
	protected ConfiguracioDocumentacioApi configuracioDocumentacioApi;

	/** The accions estats api. */
	@Autowired
	protected AccionsEstatsApi accionsEstatsApi;

	/** The documentacio api. */
	@Autowired
	protected DocumentacioApi documentacioApi;

	/** The documentacio requerit api. */
	@Autowired
	protected DocumentacioRequeritApi documentacioRequeritApi;

	/** The dades especifiques api. */
	@Autowired
	protected DadesEspecifiquesApi dadesEspecifiquesApi;

	/** The download entrada api. */
	@Autowired
	protected DownloadEntradaApi downloadEntradaApi;

	/** The comentaris api. */
	@Autowired
	protected ComentarisApi comentarisApi;

	/** The avisos api. */
	@Autowired
	protected AvisosApi avisosApi;

	/** The estats api. */
	@Autowired
	protected EstatsApi estatsApi;

	/** The retornar la tramitacio api. */
	@Autowired
	protected RetornarLaTramitacioApi retornarLaTramitacioApi;

	/** The convidar A tramitart api. */
	@Autowired
	protected ConvidarATramitartApi convidarATramitartApi;

	/** The canvi unitat gestora api. */
	@Autowired
	protected CanviUnitatGestoraApi canviUnitatGestoraApi;

	/** The dades operacions api. */
	@Autowired
	protected DadesOperacionsApi dadesOperacionsApi;

	/** The acumulaci expedients api. */
	@Autowired
	protected AcumulaciExpedientsApi acumulaciExpedientsApi;

	/** The persones sollicitud api. */
	@Autowired
	protected PersonesSollicitudApi personesSollicitudApi;

	/**
	 * Sets the up.
	 */
	@SuppressWarnings("unchecked")
	@Before
	public void setUp() {
		if (log.isDebugEnabled()) {
			log.debug("setUp() - inici"); //$NON-NLS-1$
		}

		try {
			when(procedimentsApi.cercaProcediments(isNull(Integer.class), isNull(Integer.class), any(List.class), any(String.class),
			        any(String.class), any(String.class), any(List.class), isNull(Boolean.class), isNull(Boolean.class),
			        isNull(Boolean.class), isNull(Boolean.class), any(Integer.class), any(String.class), any(List.class), any(List.class),
			        isNull(BigDecimal.class), isNull(BigDecimal.class), any(Integer.class), isNull(Integer.class), any(String.class),
			        any(Integer.class), any(String.class), any(Integer.class), isNull(Integer.class), any(String.class), isNull(Long.class),
			        isNull(Integer.class), any(List.class))).thenReturn(TestsConfigHelper.cercaProcedimentsResponse());

			when(procedimentsApi.consultarDadesProcediment(any(BigDecimal.class)))
			        .thenReturn(TestsConfigHelper.consultarDadesProcedimentResponse());

			when(procedimentsApi.consultarDadesProcedimentPerCodi(any(String.class)))
			        .thenReturn(TestsConfigHelper.consultarDadesProcedimentResponse());

			when(unitatsGestoresApi.cercaUnitatsGestores(isNull(Integer.class), isNull(Integer.class), isNull(Boolean.class),
			        isNull(Boolean.class), isNull(Boolean.class), isNull(Boolean.class), isNull(Integer.class), isNull(DateTime.class),
			        isNull(DateTime.class), isNull(DateTime.class), isNull(String.class), isNull(String.class), isNull(String.class),
			        isNull(BigDecimal.class), isNull(Integer.class), any(String.class), isNull(Integer.class), isNull(Integer.class),
			        isNull(String.class), isNull(Long.class), isNull(Integer.class), isNull(BigDecimal.class), any(List.class),
			        isNull(Integer.class))).thenReturn(TestsConfigHelper.cercaUnitatsGestoresResponse());

			when(unitatsGestoresApi.consultarDadesUnitatGestora(any(BigDecimal.class)))
			        .thenReturn(TestsConfigHelper.consultarDadesUnitatGestoraResponse());

			when(tramitsApi.cercaTramitsProcediment(any(BigDecimal.class), isNull(Integer.class), isNull(Integer.class),
			        isNull(Boolean.class), isNull(Boolean.class), isNull(Boolean.class), isNull(Boolean.class), isNull(Integer.class),
			        isNull(DateTime.class), isNull(DateTime.class), isNull(String.class), isNull(String.class), isNull(Integer.class),
			        isNull(Integer.class), isNull(String.class), isNull(BigDecimal.class), isNull(String.class), isNull(Integer.class),
			        isNull(String.class), isNull(String.class), isNull(String.class), isNull(Integer.class), isNull(Integer.class),
			        isNull(String.class), isNull(String.class), isNull(Long.class), isNull(Integer.class), isNull(BigDecimal.class)))
			                .thenReturn(TestsConfigHelper.cercaTramitsProcedimentResponse());

			when(expedients_Api.cercaExpedients(isNull(Integer.class), isNull(Integer.class), any(String.class), isNull(List.class),
			        any(String.class), isNull(BigDecimal.class), isNull(BigDecimal.class), isNull(String.class), isNull(Boolean.class),
			        isNull(Boolean.class), isNull(Boolean.class), isNull(Boolean.class), any(Integer.class), any(DateTime.class),
			        any(DateTime.class), any(String.class), any(List.class), isNull(BigDecimal.class), isNull(BigDecimal.class),
			        isNull(Boolean.class), isNull(Integer.class), isNull(String.class), any(String.class), any(Integer.class),
			        isNull(Integer.class), any(List.class), any(BigDecimal.class), any(String.class), any(String.class), isNull(Long.class),
			        isNull(Integer.class), any(String.class), any(List.class))).thenReturn(TestsConfigHelper.cercaExpedientsResponse());

			when(expedients_Api.consultarDadesExpedient(eq(BigDecimal.ONE)))
			        .thenReturn(TestsConfigHelper.consultarDadesExpedientResponse());

			when(expedients_Api.consultarDadesExpedientPerCodi(eq("1"))).thenReturn(TestsConfigHelper.consultarDadesExpedientResponse());

			when(expedients_Api.consultarDadesExpedient(eq(new BigDecimal(2))))
			        .thenReturn(TestsConfigHelper.consultarDadesExpedientAcumularResponse());

			when(expedients_Api.consultarDadesExpedientPerCodi(eq("2")))
			        .thenReturn(TestsConfigHelper.consultarDadesExpedientAcumularResponse());

			when(expedients_Api.consultarDadesExpedientPerCodi(eq("ES_LO1080193_2019_EXP_000000000000000000000000000001")))
			        .thenReturn(TestsConfigHelper.consultarDadesExpedientResponse());

			when(expedients_Api.cercaExpedientsAcumular(isNull(Integer.class), isNull(Integer.class), isNull(String.class),
			        isNull(Boolean.class), isNull(Boolean.class), isNull(Boolean.class), isNull(Boolean.class), isNull(Integer.class),
			        isNull(String.class), isNull(BigDecimal.class), any(BigDecimal.class), isNull(BigDecimal.class), isNull(Integer.class),
			        isNull(String.class), isNull(Integer.class), isNull(Integer.class), isNull(String.class), isNull(String.class),
			        isNull(Long.class), isNull(Integer.class))).thenReturn(TestsConfigHelper.cercaExpedientsAcumularResponse());

			when(expedients_Api.cercaExpedientsAcumulats(any(BigDecimal.class), isNull(Integer.class), isNull(Integer.class),
			        isNull(Boolean.class), isNull(Boolean.class), isNull(Boolean.class), isNull(Boolean.class), isNull(Integer.class),
			        isNull(String.class), isNull(Integer.class), isNull(Integer.class), isNull(Integer.class), isNull(String.class),
			        isNull(Long.class), isNull(Integer.class))).thenReturn(TestsConfigHelper.cercaExpedientsAcumularResponse());

			when(expedientsApi.cercaHistoricsExpedient(any(BigDecimal.class), isNull(Integer.class), isNull(Integer.class),
			        isNull(Boolean.class), isNull(Boolean.class), isNull(Boolean.class), isNull(Boolean.class), isNull(Integer.class),
			        isNull(String.class), isNull(Integer.class), isNull(Integer.class), isNull(Integer.class), isNull(String.class),
			        any(List.class), isNull(Long.class), isNull(Integer.class)))
			                .thenReturn(TestsConfigHelper.cercaHistoricsExpedientResponse());

			when(personesInteressades_Api.cercaPersonesInteresadesExpedient(any(BigDecimal.class), isNull(Integer.class),
			        isNull(Integer.class), isNull(Boolean.class), isNull(Boolean.class), isNull(Boolean.class), isNull(Boolean.class),
			        isNull(Integer.class), isNull(String.class), isNull(Integer.class), isNull(Integer.class), isNull(Integer.class),
			        isNull(String.class), isNull(Long.class), isNull(Integer.class)))
			                .thenReturn(TestsConfigHelper.cercaPersonesInteresadesExpedientResponse());

			when(persones_Api.cercaAltresPersonesImplicadesExpedient(any(BigDecimal.class), isNull(Integer.class), isNull(Integer.class),
			        isNull(Boolean.class), isNull(Boolean.class), isNull(Boolean.class), isNull(Boolean.class), isNull(Integer.class),
			        isNull(String.class), isNull(Integer.class), isNull(Integer.class), isNull(Integer.class), isNull(String.class),
			        isNull(Long.class), isNull(Integer.class)))
			                .thenReturn(TestsConfigHelper.cercaAltresPersonesImplicadesExpedientResponse());

			when(tramitsOvtApi.consultarDadesTramitOvt(any(BigDecimal.class)))
			        .thenReturn(TestsConfigHelper.consultarDadesTramitOvtResponse());

			when(dadesGrupsApi.cercaDadesOperacioAgrupatsPerTramitOvt(any(BigDecimal.class), any(BigDecimal.class), isNull(String.class),
			        isNull(String.class))).thenReturn(TestsConfigHelper.cercaDadesOperacioResponse());

			when(dadesGrupsApi.cercaDadesOperacio(any(BigDecimal.class), isNull(String.class), isNull(String.class)))
			        .thenReturn(TestsConfigHelper.cercaDadesOperacioResponse());

			when(configuracioDocumentacioApi.cercaConfiguracioDocumentacioEntradaPerTramitOvt(any(BigDecimal.class), any(BigDecimal.class),
			        isNull(Integer.class), isNull(Integer.class), isNull(Boolean.class), isNull(Boolean.class), isNull(Boolean.class),
			        isNull(Boolean.class), isNull(Integer.class), isNull(String.class), isNull(Integer.class), isNull(Integer.class),
			        isNull(Integer.class), isNull(String.class), isNull(Long.class), isNull(Integer.class)))
			                .thenReturn(TestsConfigHelper.cercaConfiguracioDocumentacioEntradaResponse());

			when(configuracioDocumentacioApi.cercaConfiguracioDocumentacioEntrada(any(BigDecimal.class), isNull(Integer.class),
			        isNull(Integer.class), isNull(Boolean.class), isNull(Boolean.class), isNull(Boolean.class), isNull(Boolean.class),
			        isNull(Integer.class), isNull(String.class), isNull(Integer.class), isNull(Integer.class), isNull(Integer.class),
			        isNull(String.class), isNull(Long.class), isNull(Integer.class)))
			                .thenReturn(TestsConfigHelper.cercaConfiguracioDocumentacioEntradaResponse());

			when(configuracioDocumentacioApi.cercaConfiguracioDocumentacioTramitacio(any(BigDecimal.class), isNull(Integer.class),
			        isNull(Integer.class), isNull(Boolean.class), isNull(Boolean.class), isNull(Boolean.class), isNull(Boolean.class),
			        isNull(Integer.class), isNull(String.class), isNull(Integer.class), isNull(Integer.class), isNull(Integer.class),
			        isNull(String.class), isNull(Long.class), isNull(Integer.class)))
			                .thenReturn(TestsConfigHelper.cercaConfiguracioDocumentacioTramitacioResponse());

			when(accionsEstatsApi.cercaAccionsPossibles(any(BigDecimal.class)))
			        .thenReturn(TestsConfigHelper.cercaAccionsPossiblesResponse());

			when(documentacioApi.cercaDocumentsEntradaAgrupatsPerTramitOvt(any(BigDecimal.class)))
			        .thenReturn(TestsConfigHelper.cercaDocumentsEntradaAgrupatsPerTramitOvtResponse());

			when(documentacioRequeritApi.cercaConfiguracioDocumentacioEntradaRequerida(any(BigDecimal.class)))
			        .thenReturn(TestsConfigHelper.cercaConfiguracioDocumentacioEntradaRequeridaResponse());

			when(dadesEspecifiquesApi.consultarDadesEspecifiquesExpedient(any(BigDecimal.class)))
			        .thenReturn(TestsConfigHelper.consultarDadesEspecifiquesExpedientResponse());

			when(unitatsGestoresApi.consultarDadesUnitatGestoraPerNom(any(String.class)))
			        .thenReturn(TestsConfigHelper.consultarDadesUnitatGestoraResponse());

			when(expedients_Api.crearSollicitudExpedient(any(ExpedientsRDTO.class)))
			        .thenReturn(TestsConfigHelper.crearSollicitudExpedientResponse());

			when(expedients_Api.actualitzarDadesSollicitud(any(ActualitzarDadesSollicitud.class)))
			        .thenReturn(TestsConfigHelper.crearSollicitudExpedientResponse());

			when(documentacioApi.consultarDadesDocumentAportat(any(BigDecimal.class)))
			        .thenReturn(TestsConfigHelper.consultarDadesDocumentAportatResponse());

			when(documentacioApi.consultarDadesDocumentGenerat(any(BigDecimal.class)))
			        .thenReturn(TestsConfigHelper.consultarDadesDocumentGeneratResponse());

			doNothing().when(documentacioApi).esborrarDocumentExpedient(any(List.class), any(BigDecimal.class));

			when(downloadEntradaApi.descarregarDocumentEntradaExpedient(any(BigDecimal.class), any(BigDecimal.class)))
			        .thenReturn(TestsConfigHelper.descarregarDocumentExpedientResponse());

			doNothing().when(comentarisApi).crearComentariAccio(any(BigDecimal.class), any(BigDecimal.class),
			        any(ComentariCreacioAccio.class));

			doNothing().when(avisosApi).crearAvisAccio(any(BigDecimal.class), any(BigDecimal.class), any(AvisCreacioAccio.class));

			when(expedientsApi.canviarEstatAccioExpedient(any(BigDecimal.class), any(BigDecimal.class),
			        any(ExpedientCanviEstatAccio.class))).thenReturn(TestsConfigHelper.canviarEstatAccioExpedientResponse());

			when(estatsApi.cercaHistoricsEstats(any(BigDecimal.class))).thenReturn(TestsConfigHelper.cercaHistoricsEstatsResponse());

			doNothing().when(documentacioApi).revisarDocumentacioEntrada(any(DocumentRevisio.class));

			when(expedients_Api.crearRegistreSolicitudExpedient(any(BigDecimal.class), any(CrearRegistre.class)))
			        .thenReturn(TestsConfigHelper.crearRegistreSolicitudExpedientResponse());

			when(configuracioDocumentacioApi.getPlantillaDocVinculada(any(BigDecimal.class), any(BigDecimal.class)))
			        .thenReturn(TestsConfigHelper.getPlantillaDocVinculadaResponse());

			when(documentacioApi.crearDocumentEntrada(any(DocsEntradaRDTO.class), any(BigDecimal.class)))
			        .thenReturn(TestsConfigHelper.guardarDocumentEntradaResponse());

			when(documentacioApi.guardarDocumentEntradaFitxer(any(String.class), any(File.class), any(BigDecimal.class)))
			        .thenReturn(TestsConfigHelper.guardarDocumentEntradaResponse());

			when(documentacioApi.crearDocumentTramitacio(any(DocsTramitacioRDTO.class), any(BigDecimal.class)))
			        .thenReturn(TestsConfigHelper.guardarDocumentTramitacioResponse());

			when(documentacioApi.guardarDocumentTramitacioFitxer(any(String.class), any(File.class), any(BigDecimal.class)))
			        .thenReturn(TestsConfigHelper.guardarDocumentTramitacioResponse());

			when(documentacioApi.guardarDocumentTramitacioPlantilla(any(DocsTramitacioRDTO.class), any(BigDecimal.class)))
			        .thenReturn(TestsConfigHelper.guardarDocumentTramitacioResponse());

			when(documentacioApi.crearPeticioPortaSig(any(SignarDocument.class)))
			        .thenReturn(TestsConfigHelper.crearPeticioPortaSigResponse());

			doNothing().when(retornarLaTramitacioApi).retornarTramitacioExpedient(any(RetornarLaTramitacioRDTO.class));

			doNothing().when(convidarATramitartApi).convidarTramitarExpedient(any(ConvidarTramitarRDTO.class));

			doNothing().when(canviUnitatGestoraApi).canviarUnitatGestoraExpedient(any(CanviUnitatGestoraRDTO.class));

			when(expedients_Api.consultarDadesRegistreAssentament(any(String.class)))
			        .thenReturn(TestsConfigHelper.consultarDadesRegistreAssentamentResponse());

			when(dadesOperacionsApi.cercaDadesOperacioRequerits(any(BigDecimal.class), isNull(Integer.class), isNull(Integer.class),
			        isNull(Boolean.class), isNull(Boolean.class), isNull(Boolean.class), isNull(Boolean.class), isNull(Integer.class),
			        isNull(String.class), isNull(Integer.class), isNull(Integer.class), isNull(Integer.class), isNull(String.class),
			        isNull(Long.class), isNull(Integer.class))).thenReturn(TestsConfigHelper.cercaDadesOperacioRequeritsResponse());

			doNothing().when(acumulaciExpedientsApi).acumularExpedient(any(AcumularExpedientRDTO.class));

			when(personesSollicitudApi.actualitzarDadesAltraPersonaImplicada(any(PersonesSollicitudRDTO.class), isNull(Integer.class),
			        isNull(Integer.class), isNull(Boolean.class), isNull(Boolean.class), isNull(Boolean.class), isNull(Boolean.class),
			        isNull(Integer.class), isNull(String.class), isNull(Integer.class), isNull(Integer.class), isNull(Integer.class),
			        isNull(String.class), isNull(Long.class), isNull(Integer.class)))
			                .thenReturn(TestsConfigHelper.cercaAltresPersonesImplicadesExpedientResponse());

		} catch (Exception e) {
			log.error("setUp()", e); //$NON-NLS-1$

			throw new GPAServeisRuntimeException(e);
		}

		if (log.isDebugEnabled()) {
			log.debug("setUp() - fi"); //$NON-NLS-1$
		}
	}
}
