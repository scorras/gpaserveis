package es.bcn.gpa.gpaserveis.test.parent;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.isNull;
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
import es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.Expedients_Api;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaprocediments.ProcedimentsApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpatramits.TramitsApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaunitats.UnitatsGestoresApi;
import es.bcn.gpa.gpaserveis.test.config.TestsConfigHelper;
import lombok.extern.apachecommons.CommonsLog;
import net.opentrends.openframe.services.configuration.context.ContextPropertySourcesInitializer;

/**
 * The Class ParentTest.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {}, initializers = ContextPropertySourcesInitializer.class)

/** The Constant log. */
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

			when(unitatsGestoresApi.cercaUnitatsGestores(isNull(Integer.class), isNull(Integer.class), isNull(Boolean.class),
			        isNull(Boolean.class), isNull(Boolean.class), isNull(Boolean.class), isNull(Integer.class), isNull(DateTime.class),
			        isNull(DateTime.class), isNull(String.class), isNull(String.class), isNull(BigDecimal.class), isNull(Integer.class),
			        any(String.class), isNull(Integer.class), isNull(Integer.class), isNull(String.class), isNull(Long.class),
			        isNull(Integer.class), isNull(Integer.class))).thenReturn(TestsConfigHelper.cercaUnitatsGestoresResponse());

			when(unitatsGestoresApi.consultarDadesUnitatGestora(any(BigDecimal.class)))
			        .thenReturn(TestsConfigHelper.consultarDadesUnitatGestoraResponse());

			when(tramitsApi.cercaTramitsProcediment(any(BigDecimal.class), isNull(Integer.class), isNull(Integer.class),
			        isNull(Boolean.class), isNull(Boolean.class), isNull(Boolean.class), isNull(Boolean.class), isNull(Integer.class),
			        isNull(DateTime.class), isNull(DateTime.class), isNull(String.class), isNull(String.class), isNull(Integer.class),
			        isNull(Integer.class), isNull(String.class), isNull(BigDecimal.class), isNull(String.class), isNull(Integer.class),
			        isNull(String.class), isNull(String.class), isNull(String.class), isNull(Integer.class), isNull(Integer.class),
			        isNull(String.class), isNull(String.class), isNull(Long.class), isNull(Integer.class), isNull(BigDecimal.class)))
			                .thenReturn(TestsConfigHelper.cercaTramitsProcedimentResponse());

			when(expedients_Api.cercaExpedients(isNull(Integer.class), isNull(Integer.class), any(String.class), any(String.class),
			        isNull(BigDecimal.class), isNull(BigDecimal.class), isNull(String.class), isNull(Boolean.class), isNull(Boolean.class),
			        isNull(Boolean.class), isNull(Boolean.class), any(Integer.class), any(DateTime.class), any(DateTime.class),
			        any(String.class), any(List.class), isNull(BigDecimal.class), isNull(BigDecimal.class), isNull(Integer.class),
			        any(Integer.class), isNull(Integer.class), any(List.class), any(String.class), any(String.class), any(String.class),
			        isNull(Long.class), isNull(Integer.class), any(String.class), any(List.class)))
			                .thenReturn(TestsConfigHelper.cercaExpedientsResponse());
		} catch (Exception e) {
			log.error("setUp()", e); //$NON-NLS-1$

			throw new GPAServeisRuntimeException(e);
		}

		if (log.isDebugEnabled()) {
			log.debug("setUp() - fi"); //$NON-NLS-1$
		}
	}
}
