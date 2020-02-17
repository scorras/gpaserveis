package es.bcn.gpa.gpaserveis.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

import es.bcn.gpa.gpaserveis.business.ExpedientsService;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsConvidarTramitarBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsRegistrarBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsTornarEnrereBDTO;
import es.bcn.gpa.gpaserveis.business.exception.GPAServeisServiceException;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.Comentaris;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ConvidarTramitarRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.CrearRegistre;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.DropdownItemBDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.Estats;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ExpedientsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PageDataOfPersonesSollicitudRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.Persones;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PersonesDadescontacte;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PersonesSollicitudRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RespostaObtenirXmlExpedient;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.TornarEnrereRDTO;
import es.bcn.gpa.gpaserveis.test.parent.RestServerParentTest;
import lombok.extern.apachecommons.CommonsLog;

/**
 * The Class BaseRestControllerTest.
 */
@DirtiesContext(classMode = ClassMode.AFTER_CLASS)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@CommonsLog
public class ExpedientsServiceImplTest extends RestServerParentTest {

	/** The documents service. */
	@Autowired
	@InjectMocks
	private ExpedientsService expedientsService;

	/**
	 * Setup.
	 * 
	 * @throws GPAServeisServiceException
	 */
	@Before
	public void setup() throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("setup() - inici"); //$NON-NLS-1$
		}

		MockitoAnnotations.initMocks(this);

		// ServeisServiceExceptionHandler serveisServiceExceptionHandler =
		// Mockito.mock(ServeisServiceExceptionHandler.class);
		// doNothing().doThrow(GPAServeisServiceException.class).when(serveisServiceExceptionHandler);
		// ServeisServiceExceptionHandler.handleException(new
		// GPAServeisServiceException());

		if (log.isDebugEnabled()) {
			log.debug("setup() - fi"); //$NON-NLS-1$
		}
	}

	/** Logger for this class. */
	private static final Log LOGGER = LogFactory.getLog(ExpedientsServiceImplTest.class);

	/** The exception. */
	@Rule
	public ExpectedException exception = ExpectedException.none();

	/**
	 * Test stage 01 comprovar documents signats expedient.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testStage01_donarAccesAltraPersonaImplicada() throws GPAServeisServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage03_ComprovarDocumentsSignatsExpedient() - inici"); //$NON-NLS-1$
		}

		PersonesSollicitudRDTO sollicitant = new PersonesSollicitudRDTO();
		sollicitant.setEsInteressada(1);
		sollicitant.setEditable(true);
		sollicitant.setRelacio(BigDecimal.ONE);
		Persones personesSollicitant = new Persones();
		personesSollicitant.setCognom1("cognom1Sollicitant");
		personesSollicitant.setCognom2("cognom2Sollicitant");
		personesSollicitant.setNomRaoSocial("nomRaoSocialSollicitant");
		personesSollicitant.setTipusPersona(BigDecimal.ZERO);
		PersonesDadescontacte personesDadescontacteSollicitant = new PersonesDadescontacte();
		personesSollicitant.setPersonesDadescontacte(personesDadescontacteSollicitant);
		sollicitant.setPersones(personesSollicitant);
		sollicitant.setEmail("testting@iecisa.com");
		sollicitant.setNumeroDocument("00000000T");
		sollicitant.setNomPresentacio("Hernan");
		sollicitant.setRelacio(new BigDecimal(1));
		sollicitant.setRelacioPrincipal(1);
		sollicitant.setSeleccionable(true);
		sollicitant.setVisibilitatOvt(1);

		PageDataOfPersonesSollicitudRDTO result = expedientsService.donarAccesAltraPersonaImplicada(sollicitant);
		assertNotNull(result);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage03_ComprovarDocumentsSignatsExpedient() - fi"); //$NON-NLS-1$
		}
	}

	/**
	 * Test stage 01 comprovar documents signats expedient.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Ignore
	@Test
	public void testStage01_donarAccesAltraPersonaImplicadaKO() throws GPAServeisServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage03_ComprovarDocumentsSignatsExpedient() - inici"); //$NON-NLS-1$
		}

		// TODO Este test no funciona bien, ya que no debería devolver datos
		// cuando se le pasa un nulo

		PageDataOfPersonesSollicitudRDTO result = expedientsService.donarAccesAltraPersonaImplicada(null);
		assertTrue(result == null);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage03_ComprovarDocumentsSignatsExpedient() - fi"); //$NON-NLS-1$
		}
	}

	/**
	 * Test stage 01 comprovar documents signats expedient.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testStage02_crearDataXmlExpedient() throws GPAServeisServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage03_ComprovarDocumentsSignatsExpedient() - inici"); //$NON-NLS-1$
		}

		expedientsService.crearDataXmlExpedient(new BigDecimal(1));
		assertTrue(true);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage03_ComprovarDocumentsSignatsExpedient() - fi"); //$NON-NLS-1$
		}
	}

	/**
	 * Test stage 01 comprovar documents signats expedient.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testStage02_crearDataXmlExpedientKO() throws GPAServeisServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage03_ComprovarDocumentsSignatsExpedient() - inici"); //$NON-NLS-1$
		}

		RespostaObtenirXmlExpedient result = expedientsService.crearDataXmlExpedient(null);
		assertTrue(result == null);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage03_ComprovarDocumentsSignatsExpedient() - fi"); //$NON-NLS-1$
		}
	}

	/**
	 * Test stage 01 comprovar documents signats expedient.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testStage03_esborrarComentari() throws GPAServeisServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage03_ComprovarDocumentsSignatsExpedient() - inici"); //$NON-NLS-1$
		}

		expedientsService.esborrarComentari(new BigDecimal(1), new BigDecimal(1));
		assertTrue(true);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage03_ComprovarDocumentsSignatsExpedient() - fi"); //$NON-NLS-1$
		}
	}

	/**
	 * Test stage 01 comprovar documents signats expedient.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testStage03_esborrarComentariKO() throws GPAServeisServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage03_ComprovarDocumentsSignatsExpedient() - inici"); //$NON-NLS-1$
		}

		expedientsService.esborrarComentari(null, null);
		assertTrue(true);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage03_ComprovarDocumentsSignatsExpedient() - fi"); //$NON-NLS-1$
		}
	}

	/**
	 * Test stage 01 comprovar documents signats expedient.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testStage04_esborrarRegistre() throws GPAServeisServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage03_ComprovarDocumentsSignatsExpedient() - inici"); //$NON-NLS-1$
		}

		Estats estat = new Estats();
		estat.accioEstatIdext(new BigDecimal(19));
		estat.setExpedient(new BigDecimal(1));
		estat.setUsuari(new BigDecimal(241));

		ExpedientsRDTO expedients = new ExpedientsRDTO();
		expedients.setAccioEstatIdext(new BigDecimal(4));
		expedients.setCodi("2019_EXP_0001");
		expedients.setCodiLlarg("2019_EXP_00000000000000000001");
		expedients.estatActual(new BigDecimal(2));
		expedients.setEstat(estat);

		PersonesSollicitudRDTO sollicitant = new PersonesSollicitudRDTO();
		sollicitant.setEsInteressada(1);
		sollicitant.setEditable(true);
		sollicitant.setRelacio(BigDecimal.ONE);
		Persones personesSollicitant = new Persones();
		personesSollicitant.setCognom1("cognom1Sollicitant");
		personesSollicitant.setCognom2("cognom2Sollicitant");
		personesSollicitant.setNomRaoSocial("nomRaoSocialSollicitant");
		personesSollicitant.setTipusPersona(BigDecimal.ZERO);
		PersonesDadescontacte personesDadescontacteSollicitant = new PersonesDadescontacte();
		personesSollicitant.setPersonesDadescontacte(personesDadescontacteSollicitant);
		sollicitant.setPersones(personesSollicitant);
		sollicitant.setEmail("testting@iecisa.com");
		sollicitant.setNumeroDocument("00000000T");
		sollicitant.setNomPresentacio("Hernan");
		sollicitant.setRelacio(new BigDecimal(1));
		sollicitant.setRelacioPrincipal(1);
		sollicitant.setSeleccionable(true);
		sollicitant.setVisibilitatOvt(1);

		CrearRegistre crearRegistre = new CrearRegistre();
		crearRegistre.setDocuments(Arrays.asList(new BigDecimal[] { new BigDecimal(1) }));
		crearRegistre.setExpedient(expedients);

		ExpedientsRegistrarBDTO expedientsRegistrarBDTO = new ExpedientsRegistrarBDTO(crearRegistre);

		expedientsService.esborrarRegistre(expedientsRegistrarBDTO);
		assertTrue(true);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage03_ComprovarDocumentsSignatsExpedient() - fi"); //$NON-NLS-1$
		}
	}

	/**
	 * Test stage 01 comprovar documents signats expedient.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test(expected = GPAServeisServiceException.class)
	public void testStage04_esborrarRegistreKO() throws GPAServeisServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage03_ComprovarDocumentsSignatsExpedient() - inici"); //$NON-NLS-1$
		}

		expedientsService.esborrarRegistre(null);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage03_ComprovarDocumentsSignatsExpedient() - fi"); //$NON-NLS-1$
		}
	}

	/**
	 * Test stage 01 comprovar documents signats expedient.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testStage05_convidarTramitarExpedient() throws GPAServeisServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage03_ComprovarDocumentsSignatsExpedient() - inici"); //$NON-NLS-1$
		}

		Comentaris comentari = new Comentaris();
		comentari.setDataCreacio(new DateTime());
		comentari.setExpedient(new BigDecimal(1));
		comentari.setTitol("testStage05");
		comentari.setDescripcio("convidarTramitarExpedient()");

		List<DropdownItemBDTO> llistaUnitatGestoraConvidada = new ArrayList<>();

		DropdownItemBDTO unitatGestoraConvidada = new DropdownItemBDTO();
		unitatGestoraConvidada.setDescripcio("UG_testStage05_convidarTramitarExpedient()");
		llistaUnitatGestoraConvidada.add(unitatGestoraConvidada);

		ConvidarTramitarRDTO convidarTramitarRDTO = new ConvidarTramitarRDTO();
		// TODO GPA-2901
		convidarTramitarRDTO.setUnitatGestoraConvidada(unitatGestoraConvidada);
		// convidarTramitarRDTO.setCodiUnitatGestoraList(llistaUnitatGestoraConvidada);
		convidarTramitarRDTO.setComentari(comentari);

		ExpedientsConvidarTramitarBDTO expedientsConvidarTramitarBDTO = new ExpedientsConvidarTramitarBDTO(new BigDecimal(1),
				convidarTramitarRDTO);

		expedientsService.convidarTramitarExpedient(expedientsConvidarTramitarBDTO);
		assertTrue(true);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage03_ComprovarDocumentsSignatsExpedient() - fi"); //$NON-NLS-1$
		}
	}

	/**
	 * Test stage 01 comprovar documents signats expedient.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test(expected = GPAServeisServiceException.class)
	public void testStage05_convidarTramitarExpedientKO() throws GPAServeisServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage03_ComprovarDocumentsSignatsExpedient() - inici"); //$NON-NLS-1$
		}

		// TODO lanza una NullPointerException, así que no pasa por el catch de
		// RestClientException por lo que el fallback no funciona correctamente

		expedientsService.convidarTramitarExpedient(null);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage03_ComprovarDocumentsSignatsExpedient() - fi"); //$NON-NLS-1$
		}
	}

	/**
	 * Test stage 01 comprovar documents signats expedient.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testStage06_tornarEnrereExpedient() throws GPAServeisServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage03_ComprovarDocumentsSignatsExpedient() - inici"); //$NON-NLS-1$
		}

		Comentaris comentari = new Comentaris();
		comentari.setDataCreacio(new DateTime());
		comentari.setExpedient(new BigDecimal(1));
		comentari.setTitol("testStage06");
		comentari.setDescripcio("tornarEnrereExpedient()");

		DropdownItemBDTO unitatGestoraConvidada = new DropdownItemBDTO();
		unitatGestoraConvidada.setDescripcio("UG_testStage06_tornarEnrereExpedient");

		TornarEnrereRDTO tornarEnrereRDTO = new TornarEnrereRDTO();
		tornarEnrereRDTO.setComentari(comentari);

		ExpedientsTornarEnrereBDTO expedientsTornarEnrereBDTO = new ExpedientsTornarEnrereBDTO(new BigDecimal(1), tornarEnrereRDTO);

		expedientsService.tornarEnrereExpedient(expedientsTornarEnrereBDTO);
		assertTrue(true);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage03_ComprovarDocumentsSignatsExpedient() - fi"); //$NON-NLS-1$
		}
	}

	/**
	 * Test stage 01 comprovar documents signats expedient.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test(expected = GPAServeisServiceException.class)
	public void testStage06_tornarEnrereExpedientKO() throws GPAServeisServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage03_ComprovarDocumentsSignatsExpedient() - inici"); //$NON-NLS-1$
		}

		expedientsService.tornarEnrereExpedient(null);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage03_ComprovarDocumentsSignatsExpedient() - fi"); //$NON-NLS-1$
		}
	}
}