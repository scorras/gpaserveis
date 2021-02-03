package es.bcn.gpa.gpaserveis.test.parent;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
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
import es.bcn.gpa.gpaserveis.rest.client.api.gpadocumentacio.DownloadApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpadocumentacio.NotificacionsApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpadocumentacio.SignaturesApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.AcumulaciExpedientsApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.AvisosApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.ComentarisApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.DadesEspecifiquesApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.EstatsApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.ExpedientsApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.ExpedientsRelacionatsApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.Expedients_Api;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.PersonesInteressades_Api;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.PersonesSollicitudApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.Persones_Api;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.SollicitudsApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaprocediments.DadesGrupsApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaprocediments.DadesOperacionsApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaprocediments.ProcedimentsApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpatramits.AccionsEstatsApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpatramits.TramitsApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpatramits.TramitsOvtApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaunitats.UnitatsGestoresApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaunitats.UsuarisApi;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.CallbackDigitalitzacio;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.CallbackManuscrita;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.CrearNotificacio;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsTramitacioRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocumentRegistrarComunicat;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocumentRevisio;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.PrepararSignaturaCriptograficaDocumentMassiu;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.SignarCriptograficaDocument;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.SignarPortasignaturesDocument;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.SignarValidDocument;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ActualitzarDadesSollicitud;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.AcumularExpedientRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.AvisCreacioAccio;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.CanviUnitatGestoraRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ComentariCreacioAccio;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ConvidarTramitarRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.CrearRegistre;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ExpedientCanviEstat;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ExpedientsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PersonesSollicitudRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RedireccioAssentament;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RetornarTramitacioRDTO;
import es.bcn.gpa.gpaserveis.test.config.TestsConfigHelper;
import es.bcn.gpa.gpaserveis.web.initialization.interceptor.ClientEntity;
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

	/** The signatures api. */
	@Autowired
	protected SignaturesApi signaturesApi;

	/** The documentacio requerit api. */
	@Autowired
	protected DocumentacioRequeritApi documentacioRequeritApi;

	/** The dades especifiques api. */
	@Autowired
	protected DadesEspecifiquesApi dadesEspecifiquesApi;

	/** The download api. */
	@Autowired
	protected DownloadApi downloadApi;

	/** The comentaris api. */
	@Autowired
	protected ComentarisApi comentarisApi;

	/** The avisos api. */
	@Autowired
	protected AvisosApi avisosApi;

	/** The estats api. */
	@Autowired
	protected EstatsApi estatsApi;

	/** The dades operacions api. */
	@Autowired
	protected DadesOperacionsApi dadesOperacionsApi;

	/** The acumulaci expedients api. */
	@Autowired
	protected AcumulaciExpedientsApi acumulaciExpedientsApi;

	/** The persones sollicitud api. */
	@Autowired
	protected PersonesSollicitudApi personesSollicitudApi;

	/** The notificacions api. */
	@Autowired
	protected NotificacionsApi notificacionsApi;

	/** The expedients relacionats api. */
	@Autowired
	protected ExpedientsRelacionatsApi expedientsRelacionatsApi;

	/** The sollicituds api. */
	@Autowired
	protected SollicitudsApi sollicitudsApi;

	/** The usuaris api. */
	@Autowired
	protected UsuarisApi usuarisApi;

	/** The clientEntity. */
	@Autowired
	protected ClientEntity clientEntity;

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
					isNull(Boolean.class), isNull(BigDecimal.class), isNull(Long.class), isNull(Integer.class), any(String.class),
					any(String.class), isNull(Integer.class), isNull(Integer.class), isNull(Boolean.class), isNull(String.class),
					isNull(Long.class), isNull(Integer.class), isNull(BigDecimal.class), any(List.class), isNull(Integer.class)))
							.thenReturn(TestsConfigHelper.cercaUnitatsGestoresResponse());

			when(unitatsGestoresApi.consultarDadesUnitatGestora(any(BigDecimal.class)))
					.thenReturn(TestsConfigHelper.consultarDadesUnitatGestoraResponse());

			when(tramitsApi.cercaTramitsProcediment(any(BigDecimal.class), isNull(Integer.class), isNull(Integer.class),
					isNull(BigDecimal.class), isNull(BigDecimal.class), isNull(DateTime.class), isNull(String.class), isNull(Boolean.class),
					isNull(Boolean.class), isNull(BigDecimal.class), isNull(String.class), isNull(String.class), isNull(String.class),
					isNull(String.class), isNull(String.class), isNull(List.class), isNull(BigDecimal.class), isNull(String.class),
					isNull(String.class), isNull(String.class), isNull(Boolean.class), isNull(Boolean.class), isNull(Boolean.class),
					isNull(Boolean.class), isNull(Integer.class), isNull(DateTime.class), isNull(DateTime.class), isNull(String.class),
					isNull(String.class), isNull(String.class), isNull(Integer.class), isNull(BigDecimal.class), isNull(BigDecimal.class),
					isNull(BigDecimal.class), isNull(String.class), isNull(BigDecimal.class), isNull(BigDecimal.class),
					isNull(BigDecimal.class), isNull(BigDecimal.class), isNull(Integer.class), isNull(String.class),
					isNull(BigDecimal.class), isNull(String.class), isNull(Integer.class), isNull(String.class), isNull(String.class),
					isNull(String.class), isNull(Integer.class), isNull(Integer.class), isNull(String.class), isNull(String.class),
					isNull(Long.class), isNull(Integer.class), isNull(BigDecimal.class)))
							.thenReturn(TestsConfigHelper.cercaTramitsProcedimentResponse());

			when(expedients_Api.cercaExpedients(isNull(Integer.class), isNull(Integer.class), any(String.class), isNull(List.class),
					any(String.class), isNull(BigDecimal.class), isNull(BigDecimal.class), isNull(String.class), isNull(Boolean.class),
					isNull(Boolean.class), isNull(Boolean.class), isNull(Boolean.class), any(Integer.class), any(String.class),
					any(String.class), any(String.class), any(List.class), isNull(BigDecimal.class), isNull(BigDecimal.class),
					isNull(Boolean.class), isNull(Integer.class), any(Integer.class), isNull(String.class), isNull(String.class),
					any(String.class), any(Integer.class), isNull(Integer.class), any(List.class), any(BigDecimal.class),
					any(BigDecimal.class), any(String.class), isNull(Long.class), isNull(Integer.class), any(String.class),
					any(List.class))).thenReturn(TestsConfigHelper.cercaExpedientsResponse());

			when(expedients_Api.consultarDadesExpedient(eq(BigDecimal.ONE)))
					.thenReturn(TestsConfigHelper.consultarDadesExpedientResponse());

			when(expedients_Api.consultarDadesExpedientPerCodi(eq("1"))).thenReturn(TestsConfigHelper.consultarDadesExpedientResponse());

			when(expedients_Api.consultarDadesExpedient(eq(new BigDecimal(2))))
					.thenReturn(TestsConfigHelper.consultarDadesExpedientAcumularResponse());

			when(expedients_Api.consultarDadesExpedientPerCodi(eq("2")))
					.thenReturn(TestsConfigHelper.consultarDadesExpedientAcumularResponse());

			when(expedients_Api.consultarDadesExpedientPerCodi(eq("ES_L01080193_2019_EXP_000000000000000000000000000001")))
					.thenReturn(TestsConfigHelper.consultarDadesExpedientResponse());

			when(expedients_Api.consultarExpedientPerDocumentacioIdExt(any(BigDecimal.class))).thenReturn(BigDecimal.ONE);

			when(expedientsRelacionatsApi.obtenirExpedientsRelacionats(any(BigDecimal.class), isNull(Integer.class), isNull(Integer.class),
					isNull(Boolean.class), isNull(Boolean.class), isNull(Boolean.class), isNull(Boolean.class), isNull(Integer.class),
					isNull(String.class), isNull(Integer.class), isNull(Integer.class), isNull(Integer.class), isNull(String.class),
					isNull(Long.class), isNull(Integer.class))).thenReturn(TestsConfigHelper.obtenirExpedientsRelacionatsResponse());

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

			when(documentacioApi.cercaDocumentsEntradaAgrupatsPerTramitOvt(any(BigDecimal.class), any(BigDecimal.class)))
					.thenReturn(TestsConfigHelper.cercaDocumentsEntradaAgrupatsPerTramitOvtResponse());

			when(documentacioApi.cercaDocumentsTramitacioComunicats(any(BigDecimal.class), any(BigDecimal.class)))
					.thenReturn(TestsConfigHelper.cercaDocumentsTramitacioComunicatsResponse());

			when(documentacioRequeritApi.cercaConfiguracioDocumentacioEntradaRequerida(any(BigDecimal.class)))
					.thenReturn(TestsConfigHelper.cercaConfiguracioDocumentacioEntradaRequeridaResponse());

			when(dadesEspecifiquesApi.consultarDadesEspecifiquesExpedient(any(BigDecimal.class), any(BigDecimal.class)))
					.thenReturn(TestsConfigHelper.consultarDadesEspecifiquesExpedientResponse());

			when(unitatsGestoresApi.consultarDadesUnitatGestoraPerNom(any(String.class)))
					.thenReturn(TestsConfigHelper.consultarDadesUnitatGestoraResponse());

			when(expedients_Api.crearSollicitudExpedient(any(ExpedientsRDTO.class)))
					.thenReturn(TestsConfigHelper.crearSollicitudExpedientResponse());

			when(expedients_Api.actualitzarDadesSollicitud(any(ActualitzarDadesSollicitud.class)))
					.thenReturn(TestsConfigHelper.crearSollicitudExpedientResponse());

			when(documentacioApi.consultarDadesDocument(any(BigDecimal.class)))
					.thenReturn(TestsConfigHelper.consultarDadesDocumentResponse());

			when(documentacioApi.consultarDadesDocumentAportat(any(BigDecimal.class)))
					.thenReturn(TestsConfigHelper.consultarDadesDocumentAportatResponse());

			when(documentacioApi.consultarDadesDocumentGenerat(any(BigDecimal.class)))
					.thenReturn(TestsConfigHelper.consultarDadesDocumentGeneratResponse());

			doNothing().when(documentacioApi).esBorrarDocumentacioEntrada(any(BigDecimal.class), any(BigDecimal.class));

			doNothing().when(documentacioApi).esBorrarDocumentacioTramitacio(any(BigDecimal.class), any(BigDecimal.class));

			when(downloadApi.descarregarDocumentExpedient(any(BigDecimal.class), any(BigDecimal.class)))
					.thenReturn(TestsConfigHelper.descarregarDocumentExpedientResponse());

			when(comentarisApi.crearComentariAccio(any(BigDecimal.class), any(BigDecimal.class), any(ComentariCreacioAccio.class)))
					.thenReturn(TestsConfigHelper.crearComentariAccioResponse());

			doNothing().when(avisosApi).crearAvisAccio(any(BigDecimal.class), any(BigDecimal.class), any(AvisCreacioAccio.class));

			when(expedientsApi.canviarEstatExpedient(any(BigDecimal.class), any(ExpedientCanviEstat.class)))
					.thenReturn(TestsConfigHelper.canviarEstatExpedientResponse());

			when(estatsApi.cercaHistoricsEstats(any(BigDecimal.class))).thenReturn(TestsConfigHelper.cercaHistoricsEstatsResponse());

			doNothing().when(documentacioApi).revisarDocumentacioEntrada(any(DocumentRevisio.class));

			when(expedients_Api.crearRegistreSolicitudExpedient(any(BigDecimal.class), any(CrearRegistre.class)))
					.thenReturn(TestsConfigHelper.crearRegistreSolicitudExpedientResponse());

			doNothing().when(expedientsApi).redireccionarRegistre(any(RedireccioAssentament.class));

			when(configuracioDocumentacioApi.consultarPlantillaDocumentacioVinculada(any(BigDecimal.class), any(BigDecimal.class)))
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

			when(documentacioApi.guardarDocumentTramitacioJustificantPlantilla(any(DocsTramitacioRDTO.class), any(BigDecimal.class),
					any(BigDecimal.class))).thenReturn(TestsConfigHelper.guardarDocumentTramitacioResponse());

			when(signaturesApi.crearPeticioPortaSig(any(SignarPortasignaturesDocument.class)))
					.thenReturn(TestsConfigHelper.crearPeticioPortaSigResponse());

			when(expedientsApi.retornarTramitacioExpedient(any(BigDecimal.class), any(RetornarTramitacioRDTO.class)))
					.thenReturn(TestsConfigHelper.obtenirRetornTramitacio());

			doNothing().when(expedientsApi).convidarTramitarExpedient(any(ConvidarTramitarRDTO.class), any(BigDecimal.class));

			doNothing().when(expedientsApi).canviarUnitatGestoraExpedient(any(CanviUnitatGestoraRDTO.class), any(BigDecimal.class));

			when(expedients_Api.consultarDadesRegistreAssentament(any(String.class)))
					.thenReturn(TestsConfigHelper.consultarDadesRegistreAssentamentResponse());

			when(dadesOperacionsApi.cercaDadesOperacioRequerits(any(BigDecimal.class), isNull(Integer.class), isNull(Integer.class),
					isNull(Boolean.class), isNull(Boolean.class), isNull(Boolean.class), isNull(Boolean.class), isNull(Integer.class),
					isNull(String.class), isNull(Integer.class), isNull(Integer.class), isNull(Integer.class), isNull(String.class),
					isNull(Long.class), isNull(Integer.class))).thenReturn(TestsConfigHelper.cercaDadesOperacioRequeritsResponse());

			doNothing().when(acumulaciExpedientsApi).acumularExpedient(any(AcumularExpedientRDTO.class));

			when(personesSollicitudApi.donarAccesAltraPersonaImplicada(any(PersonesSollicitudRDTO.class), isNull(Integer.class),
					isNull(Integer.class), isNull(Boolean.class), isNull(Boolean.class), isNull(Boolean.class), isNull(Boolean.class),
					isNull(Integer.class), isNull(String.class), isNull(Integer.class), isNull(Integer.class), isNull(Integer.class),
					isNull(String.class), isNull(Long.class), isNull(Integer.class)))
							.thenReturn(TestsConfigHelper.cercaAltresPersonesImplicadesExpedientResponse());

			when(documentacioApi.crearDocumentEntradaDigitalitzat(any(DocsEntradaRDTO.class), any(BigDecimal.class)))
					.thenReturn(TestsConfigHelper.guardarDocumentEntradaResponse());

			when(documentacioApi.crearDocumentTramitacio(any(DocsTramitacioRDTO.class), any(BigDecimal.class)))
					.thenReturn(TestsConfigHelper.guardarDocumentTramitacioResponse());

			doNothing().when(documentacioApi).registrarComunicatDocumentTramitacio(any(DocumentRegistrarComunicat.class));

			doNothing().when(documentacioApi).callbackDigitalitzacio(any(CallbackDigitalitzacio.class));

			when(documentacioApi.consultarEstatDigitalitzacio(anyString()))
					.thenReturn(TestsConfigHelper.consultarEstatDigitalitzacioResponse());

			when(notificacionsApi.crearNotificacio(any(CrearNotificacio.class))).thenReturn(TestsConfigHelper.crearNotificacioResponse());

			doNothing().when(notificacionsApi).callbackNotificacio(any(String.class), any(File.class), any(File.class));

			when(documentacioApi.actualitzarDocumentTramitacio(any(DocsTramitacioRDTO.class), any(BigDecimal.class)))
					.thenReturn(TestsConfigHelper.actualitzarDocumentTramitacioResponse());

			when(documentacioApi.crearDocumentTramitacioDigitalitzat(any(DocsTramitacioRDTO.class), any(BigDecimal.class)))
					.thenReturn(TestsConfigHelper.crearDocumentTramitacioDigitalitzatResponse());

			when(accionsEstatsApi.cercaTransicioCanviEstat(any(BigDecimal.class), any(BigDecimal.class)))
					.thenReturn(TestsConfigHelper.obtenirTransicionsCanviEstat());

			when(sollicitudsApi.consultarDadesSollicituds(eq(BigDecimal.ONE)))
					.thenReturn(TestsConfigHelper.consultarDadesSollicitudResponse(BigDecimal.ONE, true));

			when(sollicitudsApi.consultarDadesSollicituds(eq(BigDecimal.valueOf(2))))
					.thenReturn(TestsConfigHelper.consultarDadesSollicitudResponse(BigDecimal.valueOf(2), false));

			when(sollicitudsApi.consultarDadesSollicituds(eq(BigDecimal.valueOf(3)))).thenReturn(null);

			when(sollicitudsApi.consultarDadesSollicituds(eq(BigDecimal.valueOf(4))))
					.thenReturn(TestsConfigHelper.consultarDadesSollicitudResponse(BigDecimal.valueOf(4), false));

			when(documentacioApi.consultarDadesDocumentAportat(any(BigDecimal.class)))
					.thenReturn(TestsConfigHelper.consultarDadesDocumentAportatsResponse());

			when(documentacioApi.cercaDocumentsEntradaPerSollicitud(any(BigDecimal.class), any(BigDecimal.class)))
					.thenReturn(TestsConfigHelper.cercaDocumentsEntradaPerSollicitudResponse());

			when(dadesEspecifiquesApi.consultarDadesEspecifiquesSollicitud(any(BigDecimal.class), any(BigDecimal.class)))
					.thenReturn(TestsConfigHelper.consultarDadesEspecifiquesExpedientResponse());

			when(sollicitudsApi.cercaSollicituds(isNull(Integer.class), isNull(Integer.class), isNull(Boolean.class), isNull(Boolean.class),
					isNull(Boolean.class), isNull(Boolean.class), isNull(Integer.class), isNull(String.class), isNull(BigDecimal.class),
					any(BigDecimal.class), any(BigDecimal.class), isNull(BigDecimal.class), isNull(Integer.class), isNull(Integer.class),
					isNull(Integer.class), isNull(String.class), isNull(Long.class), isNull(Integer.class)))
							.thenReturn(TestsConfigHelper.cercaSollicitudsResponse());

			when(documentacioApi.consultarDadesDocumentAportatPerCodiCSV(any(String.class), any(BigDecimal.class)))
					.thenReturn(TestsConfigHelper.consultarDadesDocumentAportatPerCodiCSVResponse());

			when(documentacioApi.consultarDadesDocumentGeneratPerCodiCSV(any(String.class), any(BigDecimal.class)))
					.thenReturn(TestsConfigHelper.consultarDadesDocumentGeneratPerCodiCSVResponse());

			when(documentacioApi.comprovarDocumentsSignatsExpedient(any(BigDecimal.class))).thenReturn(Boolean.TRUE);

			when(usuarisApi.consultarDadesUsuari(any(String.class))).thenReturn(TestsConfigHelper.consultarDadesUsuariResponse());

			when(unitatsGestoresApi.consultarUnitatOrganigrama(any(BigDecimal.class)))
					.thenReturn(TestsConfigHelper.consultarUnitatOrganigramaResponse());

			when(signaturesApi.peticioAmbDocumentsSignats(any(String.class))).thenReturn(Boolean.TRUE);

			doNothing().when(signaturesApi).finalitzarSignaturaTablet(any(CallbackManuscrita.class));

			when(signaturesApi.signarValid(any(SignarValidDocument.class))).thenReturn(TestsConfigHelper.signarValidResponse());

			when(signaturesApi.prepararSignaturaCriptografica(any(PrepararSignaturaCriptograficaDocumentMassiu.class)))
					.thenReturn(TestsConfigHelper.prepararSignaturaCriptograficaResponse());

			when(signaturesApi.signarCriptografica(any(SignarCriptograficaDocument.class)))
					.thenReturn(TestsConfigHelper.signarCriptograficaResponse());

			when(documentacioApi.consultarDadesDocumentGeneratPerIdGestorDocumental(any(String.class)))
					.thenReturn(TestsConfigHelper.consultarDadesDocumentGeneratPerCodiCSVResponse());

		} catch (Exception e) {
			log.error("setUp()", e); //$NON-NLS-1$

			throw new GPAServeisRuntimeException(e);
		}

		if (log.isDebugEnabled()) {
			log.debug("setUp() - fi"); //$NON-NLS-1$
		}
	}
}
