package es.bcn.gpa.gpaserveis.test.parent;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

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
import es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.DadesEspecifiquesApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.ExpedientsApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.Expedients_Api;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.PaisosApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.PersonesInteressades_Api;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.Persones_Api;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaprocediments.DadesGrupsApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaprocediments.ProcedimentsApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpatramits.AccionsEstatsApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpatramits.TramitsApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpatramits.TramitsOvtApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaunitats.UnitatsGestoresApi;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.AportarDocumentacioExpedient;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.SubstituirDocumentExpedient;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ActualitzarDadesSollicitud;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ExpedientsRDTO;
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

	/** The paisos api. */
	@Autowired
	protected PaisosApi paisosApi;

	/** The download entrada api. */
	@Autowired
	protected DownloadEntradaApi downloadEntradaApi;

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

			when(expedients_Api.consultarDadesExpedient(any(BigDecimal.class)))
			        .thenReturn(TestsConfigHelper.consultarDadesExpedientResponse());

			when(expedients_Api.consultarDadesExpedientPerCodi(any(String.class)))
			        .thenReturn(TestsConfigHelper.consultarDadesExpedientResponse());

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
			                .thenReturn(TestsConfigHelper.cercaConfiguracioDocumentacioEntrada1Response());

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

			when(paisosApi.consultarDadesPaisPerCodiIso(any(String.class))).thenReturn(TestsConfigHelper.consultarDadesPaisResponse());

			when(expedients_Api.crearSollicitudExpedient(any(ExpedientsRDTO.class)))
			        .thenReturn(TestsConfigHelper.crearSollicitudExpedientResponse());

			when(expedients_Api.actualitzarDadesSollicitud(any(ActualitzarDadesSollicitud.class)))
			        .thenReturn(TestsConfigHelper.crearSollicitudExpedientResponse());

			when(documentacioApi.aportarDocumentacioExpedient(any(AportarDocumentacioExpedient.class), any(BigDecimal.class)))
			        .thenReturn(TestsConfigHelper.aportarDocumentacioExpedientResponse());

			when(documentacioApi.consultarDadesDocumentAportat(any(BigDecimal.class)))
			        .thenReturn(TestsConfigHelper.consultarDadesDocumentAportat());

			doNothing().when(documentacioApi).esborrarDocumentExpedient(any(List.class), any(BigDecimal.class));

			when(documentacioApi.substituirDocumentExpedient(any(BigDecimal.class), any(SubstituirDocumentExpedient.class)))
			        .thenReturn(TestsConfigHelper.substituirDocumentExpedientResponse());

			when(downloadEntradaApi.descarregarDocumentExpedient(any(BigDecimal.class), any(BigDecimal.class)))
			        .thenReturn(TestsConfigHelper.descarregarDocumentExpedientResponse());

		} catch (Exception e) {
			log.error("setUp()", e); //$NON-NLS-1$

			throw new GPAServeisRuntimeException(e);
		}

		if (log.isDebugEnabled()) {
			log.debug("setUp() - fi"); //$NON-NLS-1$
		}
	}
}
