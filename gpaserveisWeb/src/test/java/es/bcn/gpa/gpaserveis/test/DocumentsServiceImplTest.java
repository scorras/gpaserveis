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
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

import es.bcn.gpa.gpaserveis.business.DocumentsService;
import es.bcn.gpa.gpaserveis.business.dto.documents.ActualitzarDeclaracioResponsableBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.ActualitzarDocumentEntradaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.ActualitzarDocumentTramitacioBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.CrearDeclaracioResponsableBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.CrearDocumentEntradaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.CrearDocumentEntradaDigitalitzarBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.CrearDocumentTramitacioBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.CrearDocumentTramitacioDigitalitzarBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.CrearRequerimentBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.DescarregarDocumentExpedientBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.DocsAssociatsIntraBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.DocumentsEntradaCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.DocumentsTramitacioCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.EsborrarDocumentBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.GuardarDocumentEntradaFitxerBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.GuardarDocumentTramitacioFitxerBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.GuardarRequerimentFitxerBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.DocumentAportatValidarBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.DocumentCrearNotificacioBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.DocumentGeneratRegistrarComunicatBDTO;
import es.bcn.gpa.gpaserveis.business.exception.GPAServeisServiceException;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.CallbackDigitalitzacio;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.CallbackPortaSig;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.ConfiguracioDocsEntrada;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.ConfiguracioDocsTramitacio;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.CrearNotificacio;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsAssociatsIntra;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsEntActualizarRegistre;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsFisics;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsTramitacioRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocumentActualizarRegistre;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocumentRegistrarComunicat;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocumentRevisio;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocumentsIdentitat;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.GuardarRequerimentExpedient;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.NotificacionsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.PageDataOfConfiguracioDocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.PageDataOfConfiguracioDocsTramitacioRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.Persones;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.PersonesDadescontacte;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.RegistreAssentament;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.Requeriments;
import es.bcn.gpa.gpaserveis.test.parent.RestServerParentTest;
import lombok.extern.apachecommons.CommonsLog;

/**
 * The Class BaseRestControllerTest.
 */
@DirtiesContext(classMode = ClassMode.AFTER_CLASS)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@CommonsLog
public class DocumentsServiceImplTest extends RestServerParentTest {

	/** The documents service. */
	@Autowired
	@InjectMocks
	private DocumentsService documentsService;

	/**
	 * Setup.
	 */
	@Before
	public void setup() {
		if (log.isDebugEnabled()) {
			log.debug("setup() - inici"); //$NON-NLS-1$
		}

		MockitoAnnotations.initMocks(this);

		if (log.isDebugEnabled()) {
			log.debug("setup() - fi"); //$NON-NLS-1$
		}
	}

	/** Logger for this class. */
	private static final Log LOGGER = LogFactory.getLog(DocumentsServiceImplTest.class);

	/** The exception. */
	@Rule
	public ExpectedException exception = ExpectedException.none();

	/**
	 * Test stage 03 comprovar documents signats expedient.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testStage03_ComprovarDocumentsSignatsExpedient() throws Exception {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage03_ComprovarDocumentsSignatsExpedient() - inici"); //$NON-NLS-1$
		}

		Boolean result = documentsService.comprovarDocumentsSignatsExpedient(new BigDecimal(1));
		assertNotNull(result);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage03_ComprovarDocumentsSignatsExpedient() - fi"); //$NON-NLS-1$
		}
	}

	/**
	 * Test stage 03 comprovar documents signats expedient.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testStage03_ComprovarDocumentsSignatsExpedientKO() throws Exception {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage03_ComprovarDocumentsSignatsExpedient() - inici"); //$NON-NLS-1$
		}

		Boolean result = documentsService.comprovarDocumentsSignatsExpedient(null);
		assertNotNull(result);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage03_ComprovarDocumentsSignatsExpedient() - fi"); //$NON-NLS-1$
		}
	}

	/**
	 * Test stage 04 insert documentacio entrada.
	 *
	 * @throws GPAServeisServiceException
	 *             the GPA documentacio service exception
	 * @throws OpenTextException
	 *             the open text exception
	 */
	@Test
	public void testStage04_InsertDocumentacioEntrada() throws GPAServeisServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage04_InsertDocumentacioEntrada() - inici"); //$NON-NLS-1$
		}

		BigDecimal idExpedient = new BigDecimal(1);
		DocsEntradaRDTO docsEntradaRDTO = new DocsEntradaRDTO();
		docsEntradaRDTO.setConfigDocEntrada(new BigDecimal(1));
		ConfiguracioDocsEntrada configuracioDocsEntrada = new ConfiguracioDocsEntrada();
		configuracioDocsEntrada.setId(new BigDecimal(6));
		docsEntradaRDTO.setConfiguracioDocsEntrada(configuracioDocsEntrada);
		docsEntradaRDTO.setConfiguracioDocsEntradaNom("Acreditació de pagaments");
		docsEntradaRDTO.setRevisio(2);
		RegistreAssentament registreAssentament = new RegistreAssentament();
		registreAssentament.setId(new BigDecimal(2));
		registreAssentament.setCodi("12/2019");
		registreAssentament.setUsuari(new BigDecimal(1));
		registreAssentament.setDataRegistre(new DateTime());
		registreAssentament.setPersona(new BigDecimal(2));
		Persones persones = new Persones();
		persones.setId(new BigDecimal(2));
		persones.setDadesContacte(new Long(2));
		persones.setDocIndentitat(new BigDecimal(2));
		persones.setTipusPersona(new BigDecimal(1));
		persones.setNomRaoSocial("Maria");
		persones.setCognom1("Martin");
		persones.setCognom2("Mora");
		DocumentsIdentitat documentsIdentitat = new DocumentsIdentitat();
		documentsIdentitat.setId(new BigDecimal(2));
		documentsIdentitat.setTipus(new BigDecimal(0));
		documentsIdentitat.setNumeroDocument("12345668H");
		documentsIdentitat.setPais("108");
		persones.setDocumentsIdentitat(documentsIdentitat);
		PersonesDadescontacte personesDadescontacte = new PersonesDadescontacte();
		personesDadescontacte.setId(new BigDecimal(2));
		personesDadescontacte.setBloc("1");
		personesDadescontacte.setDireccioPostal("calle22");
		personesDadescontacte.setNumero("1");
		personesDadescontacte.setPis("2");
		personesDadescontacte.setPorta("B");
		personesDadescontacte.setTelefon("666123456");
		persones.setPersonesDadescontacte(personesDadescontacte);
		persones.setNomPresentacio("Maria Martin Mora");
		registreAssentament.setPersones(persones);
		docsEntradaRDTO.setRegistreAssentament(registreAssentament);
		docsEntradaRDTO.setOrigen(1);
		docsEntradaRDTO.setComentari("Comentaris");

		CrearDocumentEntradaBDTO crearDcoumentEntradaBDTO = new CrearDocumentEntradaBDTO(idExpedient, docsEntradaRDTO);

		DocsEntradaRDTO docsEntradaRDTODB = documentsService.crearDocumentEntrada(crearDcoumentEntradaBDTO);
		assertNotNull(docsEntradaRDTODB.getId());

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage04_InsertDocumentacioEntrada() - fi"); //$NON-NLS-1$
		}
	}

	/**
	 * Test stage 04 update documentacio entrada.
	 *
	 * @throws GPAServeisServiceException
	 *             the GPA documentacio service exception
	 * @throws OpenTextException
	 *             the open text exception
	 */
	@Test
	public void testStage04_UpdateDocumentacioEntrada() throws GPAServeisServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage04_UpdateDocumentacioEntrada() - inici"); //$NON-NLS-1$
		}

		BigDecimal idExpedient = new BigDecimal(1);
		DocsEntradaRDTO docsEntradaRDTO = new DocsEntradaRDTO();
		docsEntradaRDTO.setId(new BigDecimal(1));
		docsEntradaRDTO.setDataCreacio(new DateTime());
		docsEntradaRDTO.setDataPresentacio(new DateTime());
		docsEntradaRDTO.setDocumentacio(new BigDecimal(1));
		docsEntradaRDTO.setEliminat(0);
		docsEntradaRDTO.setDocumentFisic(new BigDecimal(1));
		docsEntradaRDTO.setConfigDocEntrada(new BigDecimal(5));
		ConfiguracioDocsEntrada configuracioDocsEntrada = new ConfiguracioDocsEntrada();
		configuracioDocsEntrada.setId(new BigDecimal(5));
		docsEntradaRDTO.setConfiguracioDocsEntrada(configuracioDocsEntrada);
		docsEntradaRDTO.setConfiguracioDocsEntradaNom("Formulari de sol•licitud");
		docsEntradaRDTO.setRevisio(3);
		RegistreAssentament registreAssentament = new RegistreAssentament();
		registreAssentament.setId(new BigDecimal(2));
		registreAssentament.setCodi("12/2019");
		registreAssentament.setUsuari(new BigDecimal(1));
		registreAssentament.setDataRegistre(new DateTime());
		registreAssentament.setPersona(new BigDecimal(2));
		Persones persones = new Persones();
		persones.setId(new BigDecimal(2));
		persones.setDadesContacte(new Long(2));
		persones.setDocIndentitat(new BigDecimal(2));
		persones.setTipusPersona(new BigDecimal(1));
		persones.setNomRaoSocial("Maria");
		persones.setCognom1("Martin");
		persones.setCognom2("Mora");
		DocumentsIdentitat documentsIdentitat = new DocumentsIdentitat();
		documentsIdentitat.setId(new BigDecimal(2));
		documentsIdentitat.setTipus(new BigDecimal(0));
		documentsIdentitat.setNumeroDocument("12345668H");
		documentsIdentitat.setPais("108");
		persones.setDocumentsIdentitat(documentsIdentitat);
		PersonesDadescontacte personesDadescontacte = new PersonesDadescontacte();
		personesDadescontacte.setId(new BigDecimal(2));
		personesDadescontacte.setBloc("1");
		personesDadescontacte.setDireccioPostal("calle22");
		personesDadescontacte.setNumero("1");
		personesDadescontacte.setPis("2");
		personesDadescontacte.setPorta("B");
		personesDadescontacte.setTelefon("666123456");
		persones.setPersonesDadescontacte(personesDadescontacte);
		persones.setNomPresentacio("Maria Martin Mora");
		registreAssentament.setPersones(persones);
		docsEntradaRDTO.setRegistreAssentament(registreAssentament);
		docsEntradaRDTO.setOrigen(1);
		docsEntradaRDTO.setComentari("Comentaris");

		ActualitzarDocumentEntradaBDTO actualitzarDocumentEntradaBDTO = new ActualitzarDocumentEntradaBDTO(idExpedient, docsEntradaRDTO);

		documentsService.actualitzarDocumentEntrada(actualitzarDocumentEntradaBDTO);
		assertTrue(true);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage04_UpdateDocumentacioEntrada() - fi"); //$NON-NLS-1$
		}
	}

	/**
	 * Test stage 04 save document entrada fitxer.
	 *
	 * @throws GPAServeisServiceException
	 *             the GPA documentacio service exception
	 * @throws OpenTextException
	 *             the open text exception
	 */
	@Test
	public void testStage04_SaveDocumentEntradaFitxer() throws GPAServeisServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage04_SaveDocumentEntradaFitxer() - inici"); //$NON-NLS-1$
		}

		BigDecimal idExpedient = new BigDecimal(1);
		DocsEntradaRDTO docsEntradaRDTO = new DocsEntradaRDTO();
		docsEntradaRDTO.setId(new BigDecimal(1));
		docsEntradaRDTO.setDataCreacio(new DateTime());
		docsEntradaRDTO.setDataPresentacio(new DateTime());
		docsEntradaRDTO.setDocumentacio(new BigDecimal(1));
		docsEntradaRDTO.setEliminat(0);
		docsEntradaRDTO.setDocumentFisic(new BigDecimal(1));
		docsEntradaRDTO.setConfigDocEntrada(new BigDecimal(5));
		ConfiguracioDocsEntrada configuracioDocsEntrada = new ConfiguracioDocsEntrada();
		configuracioDocsEntrada.setId(new BigDecimal(5));
		docsEntradaRDTO.setConfiguracioDocsEntrada(configuracioDocsEntrada);
		docsEntradaRDTO.setConfiguracioDocsEntradaNom("Formulari de sol•licitud");
		docsEntradaRDTO.setRevisio(3);
		DocsFisics docsFisics = new DocsFisics();
		docsFisics.setNom("prova.txt");
		docsFisics.setTamany((long) 12345);
		docsEntradaRDTO.setDocsFisics(docsFisics);
		RegistreAssentament registreAssentament = new RegistreAssentament();
		registreAssentament.setId(new BigDecimal(2));
		registreAssentament.setCodi("12/2019");
		registreAssentament.setUsuari(new BigDecimal(1));
		registreAssentament.setDataRegistre(new DateTime());
		registreAssentament.setPersona(new BigDecimal(2));
		Persones persones = new Persones();
		persones.setId(new BigDecimal(2));
		persones.setDadesContacte(new Long(2));
		persones.setDocIndentitat(new BigDecimal(2));
		persones.setTipusPersona(new BigDecimal(1));
		persones.setNomRaoSocial("Maria");
		persones.setCognom1("Martin");
		persones.setCognom2("Mora");
		DocumentsIdentitat documentsIdentitat = new DocumentsIdentitat();
		documentsIdentitat.setId(new BigDecimal(2));
		documentsIdentitat.setTipus(new BigDecimal(0));
		documentsIdentitat.setNumeroDocument("12345668H");
		documentsIdentitat.setPais("108");
		persones.setDocumentsIdentitat(documentsIdentitat);
		PersonesDadescontacte personesDadescontacte = new PersonesDadescontacte();
		personesDadescontacte.setId(new BigDecimal(2));
		personesDadescontacte.setBloc("1");
		personesDadescontacte.setDireccioPostal("calle22");
		personesDadescontacte.setNumero("1");
		personesDadescontacte.setPis("2");
		personesDadescontacte.setPorta("B");
		personesDadescontacte.setTelefon("666123456");
		persones.setPersonesDadescontacte(personesDadescontacte);
		persones.setNomPresentacio("Maria Martin Mora");
		registreAssentament.setPersones(persones);
		docsEntradaRDTO.setRegistreAssentament(registreAssentament);
		docsEntradaRDTO.setOrigen(1);
		docsEntradaRDTO.setComentari("Comentaris");

		MockMultipartFile mockMultipartFile = new MockMultipartFile("file", "prova.txt", "text/plain", "prova".getBytes());
		GuardarDocumentEntradaFitxerBDTO guardarDocumentEntradaFitxerBDTO = new GuardarDocumentEntradaFitxerBDTO(idExpedient,
				docsEntradaRDTO, mockMultipartFile, null);
		DocsEntradaRDTO docsEntradaRDTODB = documentsService.guardarDocumentEntradaFitxer(guardarDocumentEntradaFitxerBDTO);
		;
		assertNotNull(docsEntradaRDTODB.getId());

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage04_SaveDocumentEntradaFitxer() - fi"); //$NON-NLS-1$
		}
	}

	/**
	 * Test stage 04 create declaracio responsable.
	 *
	 * @throws GPAServeisServiceException
	 *             the GPA documentacio service exception
	 * @throws OpenTextException
	 *             the open text exception
	 */
	@Test
	public void testStage04_CreateDeclaracioResponsable() throws GPAServeisServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage04_CreateDeclaracioResponsable() - inici"); //$NON-NLS-1$
		}

		BigDecimal idExpedient = new BigDecimal(1);
		DocsEntradaRDTO docsEntradaRDTO = new DocsEntradaRDTO();
		docsEntradaRDTO.setId(new BigDecimal(1));
		docsEntradaRDTO.setDataCreacio(new DateTime());
		docsEntradaRDTO.setDataPresentacio(new DateTime());
		docsEntradaRDTO.setDocumentacio(new BigDecimal(1));
		docsEntradaRDTO.setEliminat(0);
		docsEntradaRDTO.setDocumentFisic(new BigDecimal(1));
		docsEntradaRDTO.setConfigDocEntrada(new BigDecimal(5));
		ConfiguracioDocsEntrada configuracioDocsEntrada = new ConfiguracioDocsEntrada();
		configuracioDocsEntrada.setId(new BigDecimal(5));
		docsEntradaRDTO.setConfiguracioDocsEntrada(configuracioDocsEntrada);
		docsEntradaRDTO.setConfiguracioDocsEntradaNom("Formulari de sol•licitud");
		docsEntradaRDTO.setRevisio(3);
		DocsFisics docsFisics = new DocsFisics();
		docsFisics.setNom("prova.txt");
		docsFisics.setTamany((long) 12345);
		docsEntradaRDTO.setDocsFisics(docsFisics);
		RegistreAssentament registreAssentament = new RegistreAssentament();
		registreAssentament.setId(new BigDecimal(2));
		registreAssentament.setCodi("12/2019");
		registreAssentament.setUsuari(new BigDecimal(1));
		registreAssentament.setDataRegistre(new DateTime());
		registreAssentament.setPersona(new BigDecimal(2));
		Persones persones = new Persones();
		persones.setId(new BigDecimal(2));
		persones.setDadesContacte(new Long(2));
		persones.setDocIndentitat(new BigDecimal(2));
		persones.setTipusPersona(new BigDecimal(1));
		persones.setNomRaoSocial("Maria");
		persones.setCognom1("Martin");
		persones.setCognom2("Mora");
		DocumentsIdentitat documentsIdentitat = new DocumentsIdentitat();
		documentsIdentitat.setId(new BigDecimal(2));
		documentsIdentitat.setTipus(new BigDecimal(0));
		documentsIdentitat.setNumeroDocument("12345668H");
		documentsIdentitat.setPais("108");
		persones.setDocumentsIdentitat(documentsIdentitat);
		PersonesDadescontacte personesDadescontacte = new PersonesDadescontacte();
		personesDadescontacte.setId(new BigDecimal(2));
		personesDadescontacte.setBloc("1");
		personesDadescontacte.setDireccioPostal("calle22");
		personesDadescontacte.setNumero("1");
		personesDadescontacte.setPis("2");
		personesDadescontacte.setPorta("B");
		personesDadescontacte.setTelefon("666123456");
		persones.setPersonesDadescontacte(personesDadescontacte);
		persones.setNomPresentacio("Maria Martin Mora");
		registreAssentament.setPersones(persones);
		docsEntradaRDTO.setRegistreAssentament(registreAssentament);
		docsEntradaRDTO.setOrigen(1);
		docsEntradaRDTO.setComentari("Comentaris");

		CrearDeclaracioResponsableBDTO crearDeclaracioResponsableBDTO = new CrearDeclaracioResponsableBDTO(idExpedient, docsEntradaRDTO);

		documentsService.crearDeclaracioResponsable(crearDeclaracioResponsableBDTO);
		assertTrue(true);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage04_CreateDeclaracioResponsable() - fi"); //$NON-NLS-1$
		}
	}

	/**
	 * Test stage 04 update declaracio responsable.
	 *
	 * @throws GPAServeisServiceException
	 *             the GPA documentacio service exception
	 * @throws OpenTextException
	 *             the open text exception
	 */
	@Test
	public void testStage04_UpdateDeclaracioResponsable() throws GPAServeisServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage04_UpdateDeclaracioResponsable() - inici"); //$NON-NLS-1$
		}

		BigDecimal idExpedient = new BigDecimal(1);
		DocsEntradaRDTO docsEntradaRDTO = new DocsEntradaRDTO();
		docsEntradaRDTO.setId(new BigDecimal(1));
		docsEntradaRDTO.setDataCreacio(new DateTime());
		docsEntradaRDTO.setDataPresentacio(new DateTime());
		docsEntradaRDTO.setDocumentacio(new BigDecimal(1));
		docsEntradaRDTO.setEliminat(0);
		docsEntradaRDTO.setDocumentFisic(new BigDecimal(1));
		docsEntradaRDTO.setConfigDocEntrada(new BigDecimal(5));
		ConfiguracioDocsEntrada configuracioDocsEntrada = new ConfiguracioDocsEntrada();
		configuracioDocsEntrada.setId(new BigDecimal(5));
		docsEntradaRDTO.setConfiguracioDocsEntrada(configuracioDocsEntrada);
		docsEntradaRDTO.setConfiguracioDocsEntradaNom("Formulari de sol•licitud");
		docsEntradaRDTO.setRevisio(3);
		DocsFisics docsFisics = new DocsFisics();
		docsFisics.setNom("prova.txt");
		docsFisics.setTamany((long) 12345);
		docsEntradaRDTO.setDocsFisics(docsFisics);
		RegistreAssentament registreAssentament = new RegistreAssentament();
		registreAssentament.setId(new BigDecimal(2));
		registreAssentament.setCodi("12/2019");
		registreAssentament.setUsuari(new BigDecimal(1));
		registreAssentament.setDataRegistre(new DateTime());
		registreAssentament.setPersona(new BigDecimal(2));
		Persones persones = new Persones();
		persones.setId(new BigDecimal(2));
		persones.setDadesContacte(new Long(2));
		persones.setDocIndentitat(new BigDecimal(2));
		persones.setTipusPersona(new BigDecimal(1));
		persones.setNomRaoSocial("Maria");
		persones.setCognom1("Martin");
		persones.setCognom2("Mora");
		DocumentsIdentitat documentsIdentitat = new DocumentsIdentitat();
		documentsIdentitat.setId(new BigDecimal(2));
		documentsIdentitat.setTipus(new BigDecimal(0));
		documentsIdentitat.setNumeroDocument("12345668H");
		documentsIdentitat.setPais("108");
		persones.setDocumentsIdentitat(documentsIdentitat);
		PersonesDadescontacte personesDadescontacte = new PersonesDadescontacte();
		personesDadescontacte.setId(new BigDecimal(2));
		personesDadescontacte.setBloc("1");
		personesDadescontacte.setDireccioPostal("calle22");
		personesDadescontacte.setNumero("1");
		personesDadescontacte.setPis("2");
		personesDadescontacte.setPorta("B");
		personesDadescontacte.setTelefon("666123456");
		persones.setPersonesDadescontacte(personesDadescontacte);
		persones.setNomPresentacio("Maria Martin Mora");
		registreAssentament.setPersones(persones);
		docsEntradaRDTO.setRegistreAssentament(registreAssentament);
		docsEntradaRDTO.setOrigen(1);
		docsEntradaRDTO.setComentari("Comentaris");

		ActualitzarDeclaracioResponsableBDTO actualitzarDeclaracioResponsable = new ActualitzarDeclaracioResponsableBDTO(idExpedient,
				docsEntradaRDTO);

		documentsService.actualitzarDeclaracioResponsable(actualitzarDeclaracioResponsable);
		assertTrue(true);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage04_UpdateDeclaracioResponsable() - fi"); //$NON-NLS-1$
		}
	}

	/**
	 * Test stage 05 insert documentacio tramitacio.
	 *
	 * @throws GPAServeisServiceException
	 *             the GPA documentacio service exception
	 * @throws OpenTextException
	 *             the open text exception
	 */
	@Test
	public void testStage05_SaveDocumentTramitacioFitxer() throws GPAServeisServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage05_SaveDocumentTramitacioFitxer() - inici"); //$NON-NLS-1$
		}

		BigDecimal idExpedient = new BigDecimal(1);
		DocsTramitacioRDTO docsTramitacioRDTO = new DocsTramitacioRDTO();
		docsTramitacioRDTO.setConfigDocTramitacio(new BigDecimal(1));
		docsTramitacioRDTO.setEstat(new BigDecimal(1));
		ConfiguracioDocsTramitacio configuracioDocsTramitacio = new ConfiguracioDocsTramitacio();
		configuracioDocsTramitacio.setId(new BigDecimal(1));
		docsTramitacioRDTO.setConfiguracioDocsTramitacio(configuracioDocsTramitacio);
		docsTramitacioRDTO.setConfiguracioDocsTramitacioNom("Diligència d’inici d’ofici (Condicionat)");
		DocsFisics docsFisics = new DocsFisics();
		docsFisics.setNom("prova.txt");
		docsTramitacioRDTO.setDocsFisics(docsFisics);
		docsTramitacioRDTO.setOrigen(1);
		docsTramitacioRDTO.setComentari("Comentaris");
		docsTramitacioRDTO.setEstatDocsTramitacio(BigDecimal.ONE);

		MockMultipartFile mockMultipartFile = new MockMultipartFile("file", "prova.txt", "text/plain", "prova".getBytes());
		GuardarDocumentTramitacioFitxerBDTO guardarDocumentTramitacioFitxerBDTO = new GuardarDocumentTramitacioFitxerBDTO(idExpedient,
				docsTramitacioRDTO, mockMultipartFile);
		DocsTramitacioRDTO docsTramitacioRDTODB = documentsService.guardarDocumentTramitacioFitxer(guardarDocumentTramitacioFitxerBDTO);
		assertNotNull(docsTramitacioRDTODB.getId());

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage05_SaveDocumentTramitacioFitxer() - fi"); //$NON-NLS-1$
		}
	}

	/**
	 * Test stage 05 update documentacio tramitacio.
	 *
	 * @throws GPAServeisServiceException
	 *             the GPA documentacio service exception
	 * @throws OpenTextException
	 *             the open text exception
	 */
	@Test
	public void testStage05_UpdateDocumentacioTramitacio() throws GPAServeisServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage05_UpdateDocumentacioTramitacio() - inici"); //$NON-NLS-1$
		}

		BigDecimal idExpedient = new BigDecimal(1);
		DocsTramitacioRDTO docsTramitacioRDTO = new DocsTramitacioRDTO();
		docsTramitacioRDTO.setId(BigDecimal.ONE);
		docsTramitacioRDTO.setConfigDocTramitacio(new BigDecimal(1));
		docsTramitacioRDTO.setEstat(new BigDecimal(1));
		ConfiguracioDocsTramitacio configuracioDocsTramitacio = new ConfiguracioDocsTramitacio();
		configuracioDocsTramitacio.setId(new BigDecimal(1));
		docsTramitacioRDTO.setConfiguracioDocsTramitacio(configuracioDocsTramitacio);
		docsTramitacioRDTO.setConfiguracioDocsTramitacioNom("Diligència d’inici d’ofici (Condicionat)");
		DocsFisics docsFisics = new DocsFisics();
		docsFisics.setNom("prova.txt");
		docsTramitacioRDTO.setDocsFisics(docsFisics);
		docsTramitacioRDTO.setOrigen(1);
		docsTramitacioRDTO.setComentari("Comentaris");
		docsTramitacioRDTO.setEstatDocsTramitacio(BigDecimal.ONE);

		ActualitzarDocumentTramitacioBDTO actualitzarDocumentTramitacio = new ActualitzarDocumentTramitacioBDTO(idExpedient,
				docsTramitacioRDTO);

		DocsTramitacioRDTO docsTramitacioRDTODB = documentsService.actualitzarDocumentTramitacio(actualitzarDocumentTramitacio);
		assertNotNull(docsTramitacioRDTODB.getId());

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage05_UpdateDocumentacioTramitacio() - fi"); //$NON-NLS-1$
		}
	}

	/**
	 * Test stage 05 save document tramitacio plantilla.
	 *
	 * @throws GPAServeisServiceException
	 *             the GPA documentacio service exception
	 */
	@Test
	public void testStage05_SaveDocumentTramitacioPlantilla() throws GPAServeisServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage05_SaveDocumentTramitacioPlantilla() - inici"); //$NON-NLS-1$
		}

		BigDecimal idExpedient = new BigDecimal(1);
		BigDecimal idSollicitud = new BigDecimal(1);
		DocsTramitacioRDTO docsTramitacioRDTO = new DocsTramitacioRDTO();
		docsTramitacioRDTO.setConfigDocTramitacio(new BigDecimal(1));
		docsTramitacioRDTO.setEstat(new BigDecimal(1));
		ConfiguracioDocsTramitacio configuracioDocsTramitacio = new ConfiguracioDocsTramitacio();
		configuracioDocsTramitacio.setId(new BigDecimal(1));
		docsTramitacioRDTO.setConfiguracioDocsTramitacio(configuracioDocsTramitacio);
		docsTramitacioRDTO.setConfiguracioDocsTramitacioNom("Diligència d’inici d’ofici (Condicionat)");
		DocsFisics docsFisics = new DocsFisics();
		docsFisics.setNom("prova.txt");
		docsTramitacioRDTO.setDocsFisics(docsFisics);
		docsTramitacioRDTO.setOrigen(1);
		docsTramitacioRDTO.setComentari("Comentaris");
		docsTramitacioRDTO.setEstatDocsTramitacio(BigDecimal.ONE);

		CrearDocumentTramitacioBDTO guardarDocumentTramitacioPlantillaBDTO = new CrearDocumentTramitacioBDTO(idExpedient, idSollicitud,
				docsTramitacioRDTO);

		DocsTramitacioRDTO docsTramitacioRDTODB = documentsService
				.guardarDocumentTramitacioPlantilla(guardarDocumentTramitacioPlantillaBDTO);
		assertNotNull(docsTramitacioRDTODB.getId());

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage05_SaveDocumentTramitacioPlantilla() - fi"); //$NON-NLS-1$
		}
	}

	/**
	 * Test stage 08 revisar documentacio entrada.
	 *
	 * @throws GPAServeisServiceException
	 *             the GPA documentacio service exception
	 */
	@Test
	public void testStage08_RevisarDocumentacioEntrada() throws GPAServeisServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage08_RevisarDocumentacioEntrada() - inici"); //$NON-NLS-1$
		}

		List<BigDecimal> docsEntradaIds = Arrays.asList(new BigDecimal[] { new BigDecimal(1), new BigDecimal(2) });
		DocumentRevisio documentRevisio = new DocumentRevisio();
		documentRevisio.setCodiExpedient("EXP_2019_337501");
		documentRevisio.setDocsEntradaIds(docsEntradaIds);
		documentRevisio.setEstatRevisioId(1);
		documentRevisio.setExpedientId(new BigDecimal(1));
		DocumentAportatValidarBDTO documentAportatValidarBDTO = new DocumentAportatValidarBDTO(documentRevisio);
		documentsService.revisarDocumentacioEntrada(documentAportatValidarBDTO);
		assertTrue(true);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage08_RevisarDocumentacioEntrada() - fi"); //$NON-NLS-1$
		}
	}

	/**
	 * Test stage 12 download file entrada.
	 *
	 * @throws GPAServeisServiceException
	 *             the GPA documentacio service exception
	 * @throws OpenTextException
	 *             the open text exception
	 */
	@Test
	public void testStage12_DownloadFile() throws GPAServeisServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage12_DownloadFile() - inici"); //$NON-NLS-1$
		}

		DescarregarDocumentExpedientBDTO descarregarDocumentExpedientBDTO = new DescarregarDocumentExpedientBDTO(new BigDecimal(1),
				new BigDecimal(1));

		byte[] resource = documentsService.descarregarDocumentExpedient(descarregarDocumentExpedientBDTO);
		assertNotNull(resource);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage12_DownloadFile() - fi"); //$NON-NLS-1$
		}
	}

	/**
	 * Test stage 18 insert requeriment.
	 *
	 * @throws GPAServeisServiceException
	 *             the GPA documentacio service exception
	 * @throws OpenTextException
	 *             the open text exception
	 */
	@Test
	public void testStage18_InsertRequerimentFixer() throws GPAServeisServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage18_InsertRequerimentFixer() - inici"); //$NON-NLS-1$
		}

		BigDecimal idExpedient = new BigDecimal(1);
		DocsTramitacioRDTO docsTramitacioRDTO = new DocsTramitacioRDTO();
		docsTramitacioRDTO.setConfigDocTramitacio(new BigDecimal(1));
		docsTramitacioRDTO.setEstat(new BigDecimal(1));
		ConfiguracioDocsTramitacio configuracioDocsTramitacio = new ConfiguracioDocsTramitacio();
		configuracioDocsTramitacio.setId(new BigDecimal(1));
		docsTramitacioRDTO.setConfiguracioDocsTramitacio(configuracioDocsTramitacio);
		docsTramitacioRDTO.setConfiguracioDocsTramitacioNom("Diligència d’inici d’ofici (Condicionat)");
		DocsFisics docsFisics = new DocsFisics();
		docsFisics.setNom("prova.txt");
		docsTramitacioRDTO.setDocsFisics(docsFisics);
		docsTramitacioRDTO.setOrigen(1);
		docsTramitacioRDTO.setComentari("Comentaris");

		List<BigDecimal> idsConfDocEntradaList = new ArrayList<BigDecimal>();
		idsConfDocEntradaList.add(new BigDecimal(1));

		List<BigDecimal> idsDadesOperList = new ArrayList<BigDecimal>();
		idsDadesOperList.add(new BigDecimal(1));

		MockMultipartFile mockMultipartFile = new MockMultipartFile("file", "prova.txt", "text/plain", "prova".getBytes());
		GuardarRequerimentExpedient guardarRequerimentExpedient = new GuardarRequerimentExpedient();
		guardarRequerimentExpedient.setDocsTramitacio(docsTramitacioRDTO);
		guardarRequerimentExpedient.setIdsConfDocEntradaList(idsConfDocEntradaList);
		guardarRequerimentExpedient.setIdsDadesOperList(idsDadesOperList);
		GuardarRequerimentFitxerBDTO guardarRequerimentFitxerBDTO = new GuardarRequerimentFitxerBDTO(idExpedient,
				guardarRequerimentExpedient, mockMultipartFile);
		documentsService.guardarRequerimentFitxer(guardarRequerimentFitxerBDTO);
		assertTrue(true);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage18_InsertRequerimentFixer() - fi"); //$NON-NLS-1$
		}
	}

	/**
	 * Test stage 18 insert requeriment plantilla.
	 *
	 * @throws GPAServeisServiceException
	 *             the GPA documentacio service exception
	 * @throws OpenTextException
	 *             the open text exception
	 */
	@Test
	public void testStage18_InsertRequerimentPlantilla() throws GPAServeisServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage18_InsertRequerimentPlantilla() - inici"); //$NON-NLS-1$
		}

		BigDecimal idExpedient = new BigDecimal(1);
		DocsTramitacioRDTO docsTramitacioRDTO = new DocsTramitacioRDTO();
		docsTramitacioRDTO.setConfigDocTramitacio(new BigDecimal(1));
		docsTramitacioRDTO.setEstat(new BigDecimal(1));
		ConfiguracioDocsTramitacio configuracioDocsTramitacio = new ConfiguracioDocsTramitacio();
		configuracioDocsTramitacio.setId(new BigDecimal(1));
		docsTramitacioRDTO.setConfiguracioDocsTramitacio(configuracioDocsTramitacio);
		docsTramitacioRDTO.setConfiguracioDocsTramitacioNom("Diligència d’inici d’ofici (Condicionat)");
		DocsFisics docsFisics = new DocsFisics();
		docsFisics.setNom("prova.txt");
		docsTramitacioRDTO.setDocsFisics(docsFisics);
		docsTramitacioRDTO.setOrigen(1);
		docsTramitacioRDTO.setComentari("Comentaris");

		List<BigDecimal> idsConfDocEntradaList = new ArrayList<BigDecimal>();
		idsConfDocEntradaList.add(new BigDecimal(1));

		List<BigDecimal> idsDadesOperList = new ArrayList<BigDecimal>();
		idsDadesOperList.add(new BigDecimal(1));
		GuardarRequerimentExpedient guardarRequerimentExpedient = new GuardarRequerimentExpedient();
		guardarRequerimentExpedient.setDocsTramitacio(docsTramitacioRDTO);
		guardarRequerimentExpedient.setIdsConfDocEntradaList(idsConfDocEntradaList);
		guardarRequerimentExpedient.setIdsDadesOperList(idsDadesOperList);
		CrearRequerimentBDTO crearRequerimentBDTO = new CrearRequerimentBDTO(idExpedient, guardarRequerimentExpedient);
		documentsService.guardarRequerimentPlantilla(crearRequerimentBDTO);
		assertTrue(true);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage18_InsertRequerimentPlantilla() - fi"); //$NON-NLS-1$
		}
	}

	/**
	 * Test stage 19 update requeriment.
	 *
	 * @throws GPAServeisServiceException
	 *             the GPA documentacio service exception
	 * @throws OpenTextException
	 *             the open text exception
	 */
	@Test
	public void testStage19_UpdateRequeriment() throws GPAServeisServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage19_UpdateRequeriment() - inici"); //$NON-NLS-1$
		}

		BigDecimal idExpedient = new BigDecimal(1);
		DocsTramitacioRDTO docsTramitacioRDTO = new DocsTramitacioRDTO();
		docsTramitacioRDTO.setId(new BigDecimal(1));
		docsTramitacioRDTO.setDataCreacio(new DateTime());
		docsTramitacioRDTO.setDocumentacio(new BigDecimal(1));
		docsTramitacioRDTO.setEliminat(0);
		docsTramitacioRDTO.setDocumentFisic(new BigDecimal(4));
		docsTramitacioRDTO.setConfigDocTramitacio(new BigDecimal(4));
		docsTramitacioRDTO.setEstat(new BigDecimal(3));
		Requeriments requeriments = new Requeriments();
		requeriments.setId(BigDecimal.ONE);
		requeriments.setDocsTramitacio(BigDecimal.ONE);
		docsTramitacioRDTO.setRequeriments(requeriments);
		ConfiguracioDocsTramitacio configuracioDocsTramitacio = new ConfiguracioDocsTramitacio();
		configuracioDocsTramitacio.setId(new BigDecimal(4));
		docsTramitacioRDTO.setConfiguracioDocsTramitacio(configuracioDocsTramitacio);
		docsTramitacioRDTO.setConfiguracioDocsTramitacioNom("Memòria");

		List<BigDecimal> idsConfDocEntradaList = new ArrayList<BigDecimal>();
		idsConfDocEntradaList.add(new BigDecimal(1));

		List<BigDecimal> idsDadesOperList = new ArrayList<BigDecimal>();
		idsDadesOperList.add(new BigDecimal(1));

		GuardarRequerimentExpedient guardarRequerimentExpedient = new GuardarRequerimentExpedient();
		guardarRequerimentExpedient.setDocsTramitacio(docsTramitacioRDTO);
		guardarRequerimentExpedient.setIdsConfDocEntradaList(idsConfDocEntradaList);
		guardarRequerimentExpedient.setIdsDadesOperList(idsDadesOperList);
		CrearRequerimentBDTO crearRequerimentBDTO = new CrearRequerimentBDTO(idExpedient, guardarRequerimentExpedient);
		documentsService.actualitzarRequeriment(crearRequerimentBDTO);
		assertTrue(true);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage19_UpdateRequeriment() - fi"); //$NON-NLS-1$
		}
	}

	/**
	 * Test stage 26 associar registre documentacio.
	 *
	 * @throws GPAServeisServiceException
	 *             the GPA documentacio service exception
	 */
	@Test
	public void testStage26_AssociarRegistreDocumentacio() throws GPAServeisServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage26_AssociarRegistreDocumentacio() - inici"); //$NON-NLS-1$
		}

		DocumentActualizarRegistre actualizarRegistreRDTO = new DocumentActualizarRegistre();
		actualizarRegistreRDTO.setIdDoc(BigDecimal.ONE);
		actualizarRegistreRDTO.setIdRegistre(BigDecimal.ONE);
		documentsService.associarRegistreDocumentacioExpedient(actualizarRegistreRDTO);
		assertTrue(true);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage26_AssociarRegistreDocumentacio() - fi"); //$NON-NLS-1$
		}
	}

	/**
	 * Test stage 26 associar registre documentacio expedient.
	 *
	 * @throws GPAServeisServiceException
	 *             the GPA documentacio service exception
	 */
	@Test
	public void testStage27_AssociarRegistreDocumentacioExpedient() throws GPAServeisServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage27_AssociarRegistreDocumentacioExpedient() - inici"); //$NON-NLS-1$
		}

		List<BigDecimal> listIdsDocsEnt = new ArrayList<>();
		listIdsDocsEnt.add(BigDecimal.ONE);

		DocsEntActualizarRegistre actualizarRegistreRDTO = new DocsEntActualizarRegistre();
		actualizarRegistreRDTO.setIdRegistre(BigDecimal.ONE);
		actualizarRegistreRDTO.setListIdsDocsEnt(listIdsDocsEnt);

		documentsService.associarRegistreDocsEnt(actualizarRegistreRDTO);
		assertTrue(true);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage27_AssociarRegistreDocumentacioExpedient() - fi"); //$NON-NLS-1$
		}
	}

	/**
	 * Test stage 01 callback porta sig.
	 *
	 * @throws GPAServeisServiceException
	 *             the GPA documentacio service exception
	 * @throws OpenTextException
	 *             the open text exception
	 */
	@Test
	public void testStage01_CallbackPortaSig() throws GPAServeisServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage31_CallbackPortaSig() - inici"); //$NON-NLS-1$
		}

		CallbackPortaSig callbackPortaSigRDTO = new CallbackPortaSig();
		callbackPortaSigRDTO.setCodiEstat("COMPLETADA");
		callbackPortaSigRDTO.setCodiPeticio("abcdefg");
		callbackPortaSigRDTO.setCodiUsuari("Y12345");
		callbackPortaSigRDTO.setNifUsuari("54321y");
		callbackPortaSigRDTO.setNomCompletUsuari("Jhon Doe");
		callbackPortaSigRDTO.setTicketPeticio(BigDecimal.ONE);
		callbackPortaSigRDTO.setTipusPeticio("SIGNATURA");
		callbackPortaSigRDTO.setDataCaducitat(null);
		callbackPortaSigRDTO.setInstantSignatura(new DateTime());

		documentsService.callbackPortaSig(callbackPortaSigRDTO);
		assertTrue(true);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage31_CallbackPortaSig() - fi"); //$NON-NLS-1$
		}
	}

	/**
	 * Test stage 31 insert documentacio entrada digitalitzat.
	 *
	 * @throws GPAServeisServiceException
	 *             the GPA documentacio service exception
	 * @throws OpenTextException
	 *             the open text exception
	 * @throws DigitalitzacioException
	 *             the digitalitzacio exception
	 */
	@Test
	public void testStage31_InsertDocumentacioEntradaDigitalitzat() throws GPAServeisServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage31_InsertDocumentacioEntradaDigitalitzat() - inici"); //$NON-NLS-1$
		}

		BigDecimal idExpedient = new BigDecimal(1);
		DocsEntradaRDTO docsEntradaRDTO = new DocsEntradaRDTO();
		docsEntradaRDTO.setConfigDocEntrada(new BigDecimal(1));
		ConfiguracioDocsEntrada configuracioDocsEntrada = new ConfiguracioDocsEntrada();
		configuracioDocsEntrada.setId(new BigDecimal(6));
		docsEntradaRDTO.setConfiguracioDocsEntrada(configuracioDocsEntrada);
		docsEntradaRDTO.setConfiguracioDocsEntradaNom("Acreditació de pagaments");
		docsEntradaRDTO.setRevisio(2);
		RegistreAssentament registreAssentament = new RegistreAssentament();
		registreAssentament.setId(new BigDecimal(2));
		registreAssentament.setCodi("12/2019");
		registreAssentament.setUsuari(new BigDecimal(1));
		registreAssentament.setDataRegistre(new DateTime());
		registreAssentament.setPersona(new BigDecimal(2));
		Persones persones = new Persones();
		persones.setId(new BigDecimal(2));
		persones.setDadesContacte(new Long(2));
		persones.setDocIndentitat(new BigDecimal(2));
		persones.setTipusPersona(new BigDecimal(1));
		persones.setNomRaoSocial("Maria");
		persones.setCognom1("Martin");
		persones.setCognom2("Mora");
		DocumentsIdentitat documentsIdentitat = new DocumentsIdentitat();
		documentsIdentitat.setId(new BigDecimal(2));
		documentsIdentitat.setTipus(new BigDecimal(0));
		documentsIdentitat.setNumeroDocument("12345668H");
		documentsIdentitat.setPais("108");
		persones.setDocumentsIdentitat(documentsIdentitat);
		PersonesDadescontacte personesDadescontacte = new PersonesDadescontacte();
		personesDadescontacte.setId(new BigDecimal(2));
		personesDadescontacte.setBloc("1");
		personesDadescontacte.setDireccioPostal("calle22");
		personesDadescontacte.setNumero("1");
		personesDadescontacte.setPis("2");
		personesDadescontacte.setPorta("B");
		personesDadescontacte.setTelefon("666123456");
		persones.setPersonesDadescontacte(personesDadescontacte);
		persones.setNomPresentacio("Maria Martin Mora");
		registreAssentament.setPersones(persones);
		docsEntradaRDTO.setRegistreAssentament(registreAssentament);
		docsEntradaRDTO.setOrigen(1);
		docsEntradaRDTO.setComentari("Comentaris");

		CrearDocumentEntradaDigitalitzarBDTO crearDocumentEntradaDigitalitzarBDTO = new CrearDocumentEntradaDigitalitzarBDTO(idExpedient,
				docsEntradaRDTO);

		DocsEntradaRDTO docsEntradaRDTODB = documentsService.crearDocumentEntradaDigitalitzat(crearDocumentEntradaDigitalitzarBDTO);
		assertNotNull(docsEntradaRDTODB.getId());

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage31_InsertDocumentacioEntradaDigitalitzat() - fi"); //$NON-NLS-1$
		}
	}

	/**
	 * Test stage 32 insert documentacio tramitacio digitalitzat.
	 *
	 * @throws GPAServeisServiceException
	 *             the GPA documentacio service exception
	 * @throws OpenTextException
	 *             the open text exception
	 * @throws DigitalitzacioException
	 *             the digitalitzacio exception
	 */
	@Test
	public void testStage32_InsertDocumentacioTramitacioDigitalitzat() throws GPAServeisServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage32_InsertDocumentacioTramitacioDigitalitzat() - inici"); //$NON-NLS-1$
		}

		BigDecimal idExpedient = new BigDecimal(1);
		DocsTramitacioRDTO docsTramitacioRDTO = new DocsTramitacioRDTO();
		docsTramitacioRDTO.setConfigDocTramitacio(new BigDecimal(1));
		ConfiguracioDocsTramitacio configuracioDocsTramitacio = new ConfiguracioDocsTramitacio();
		configuracioDocsTramitacio.setId(new BigDecimal(6));
		docsTramitacioRDTO.setConfiguracioDocsTramitacio(configuracioDocsTramitacio);
		docsTramitacioRDTO.setConfiguracioDocsTramitacioNom("Acreditació de pagaments");
		RegistreAssentament registreAssentament = new RegistreAssentament();
		registreAssentament.setId(new BigDecimal(2));
		registreAssentament.setCodi("12/2019");
		registreAssentament.setUsuari(new BigDecimal(1));
		registreAssentament.setDataRegistre(new DateTime());
		registreAssentament.setPersona(new BigDecimal(2));
		Persones persones = new Persones();
		persones.setId(new BigDecimal(2));
		persones.setDadesContacte(new Long(2));
		persones.setDocIndentitat(new BigDecimal(2));
		persones.setTipusPersona(new BigDecimal(1));
		persones.setNomRaoSocial("Maria");
		persones.setCognom1("Martin");
		persones.setCognom2("Mora");
		DocumentsIdentitat documentsIdentitat = new DocumentsIdentitat();
		documentsIdentitat.setId(new BigDecimal(2));
		documentsIdentitat.setTipus(new BigDecimal(0));
		documentsIdentitat.setNumeroDocument("12345668H");
		documentsIdentitat.setPais("108");
		persones.setDocumentsIdentitat(documentsIdentitat);
		PersonesDadescontacte personesDadescontacte = new PersonesDadescontacte();
		personesDadescontacte.setId(new BigDecimal(2));
		personesDadescontacte.setBloc("1");
		personesDadescontacte.setDireccioPostal("calle22");
		personesDadescontacte.setNumero("1");
		personesDadescontacte.setPis("2");
		personesDadescontacte.setPorta("B");
		personesDadescontacte.setTelefon("666123456");
		persones.setPersonesDadescontacte(personesDadescontacte);
		persones.setNomPresentacio("Maria Martin Mora");
		registreAssentament.setPersones(persones);
		docsTramitacioRDTO.setRegistreAssentament(registreAssentament);
		docsTramitacioRDTO.setOrigen(1);
		docsTramitacioRDTO.setComentari("Comentaris");

		CrearDocumentTramitacioDigitalitzarBDTO crearDocumentTramitacioDigitalitzarBDTO = new CrearDocumentTramitacioDigitalitzarBDTO(
				idExpedient, docsTramitacioRDTO);

		DocsTramitacioRDTO docsTramitacioRDTODB = documentsService
				.crearDocumentTramitacioDigitalitzat(crearDocumentTramitacioDigitalitzarBDTO);
		assertNotNull(docsTramitacioRDTODB.getId());

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage32_InsertDocumentacioTramitacioDigitalitzat() - fi"); //$NON-NLS-1$
		}
	}

	/**
	 * Test stage 33 registrar comunicat document tramitacio.
	 *
	 * @throws GPAServeisServiceException
	 *             the GPA documentacio service exception
	 */
	@Test
	public void testStage33_RegistrarComunicatDocumentTramitacio() throws GPAServeisServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage33_RegistrarComunicatDocumentTramitacio() - inici"); //$NON-NLS-1$
		}

		DocumentRegistrarComunicat documentRegistrarComunicat = new DocumentRegistrarComunicat();
		documentRegistrarComunicat.setCanalComunicat(new BigDecimal(1));
		documentRegistrarComunicat.setDocsTramitacioId(new BigDecimal(1));
		documentRegistrarComunicat.setDataComunicat(new DateTime());
		documentRegistrarComunicat.setMissatgeComunicat("Missatge comunicat");

		DocumentGeneratRegistrarComunicatBDTO documentGeneratRegistrarComunicatBDTO = new DocumentGeneratRegistrarComunicatBDTO(
				documentRegistrarComunicat);

		documentsService.registrarComunicatDocumentTramitacio(documentGeneratRegistrarComunicatBDTO);
		assertTrue(true);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage33_RegistrarComunicatDocumentTramitacio() - fi"); //$NON-NLS-1$
		}
	}

	/**
	 * Test stage 34 callback digitalitzacio.
	 *
	 * @throws GPAServeisServiceException
	 *             the GPA documentacio service exception
	 */
	@Test
	public void testStage34_CallbackDigitalitzacio() throws GPAServeisServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage33_RegistrarComunicatDocumentTramitacio() - inici"); //$NON-NLS-1$
		}

		CallbackDigitalitzacio callbackDigitalitzacioRDTO = new CallbackDigitalitzacio();
		callbackDigitalitzacioRDTO.setIdDocScan("ES_L01080193_2019_000000000000000000000000018588");
		callbackDigitalitzacioRDTO.setDataDigitalitzacio(new DateTime());
		callbackDigitalitzacioRDTO.setEstat(BigDecimal.valueOf(2));
		callbackDigitalitzacioRDTO.setIdioma(BigDecimal.ONE);
		documentsService.callbackDigitalitzacio(callbackDigitalitzacioRDTO);
		assertTrue(true);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage33_RegistrarComunicatDocumentTramitacio() - fi"); //$NON-NLS-1$
		}
	}

	/**
	 * Test stage 39 associats docs intra.
	 *
	 * @throws GPAServeisServiceException
	 *             the GPA documentacio service exception
	 * @throws OpenTextException
	 *             the open text exception
	 */
	@Test
	public void testStage01_AssociatsDocsIntra() throws GPAServeisServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage39_AssociatsDocsIntra() - inici"); //$NON-NLS-1$
		}

		DocsEntradaRDTO docsEntrada = new DocsEntradaRDTO();
		docsEntrada.setConfigDocEntrada(new BigDecimal(1));
		ConfiguracioDocsEntrada configuracioDocsEntrada = new ConfiguracioDocsEntrada();
		configuracioDocsEntrada.setId(new BigDecimal(6));
		docsEntrada.setConfiguracioDocsEntrada(configuracioDocsEntrada);
		docsEntrada.setConfiguracioDocsEntradaNom("Acreditació de pagaments");
		docsEntrada.setRevisio(2);
		RegistreAssentament registreAssentament = new RegistreAssentament();
		registreAssentament.setId(new BigDecimal(2));
		registreAssentament.setCodi("12/2019");
		registreAssentament.setUsuari(new BigDecimal(1));
		registreAssentament.setDataRegistre(new DateTime());
		registreAssentament.setPersona(new BigDecimal(2));
		Persones persones = new Persones();
		persones.setId(new BigDecimal(2));
		persones.setDadesContacte(new Long(2));
		persones.setDocIndentitat(new BigDecimal(2));
		persones.setTipusPersona(new BigDecimal(1));
		persones.setNomRaoSocial("Maria");
		persones.setCognom1("Martin");
		persones.setCognom2("Mora");
		DocumentsIdentitat documentsIdentitat = new DocumentsIdentitat();
		documentsIdentitat.setId(new BigDecimal(2));
		documentsIdentitat.setTipus(new BigDecimal(0));
		documentsIdentitat.setNumeroDocument("12345668H");
		documentsIdentitat.setPais("108");
		persones.setDocumentsIdentitat(documentsIdentitat);
		PersonesDadescontacte personesDadescontacte = new PersonesDadescontacte();
		personesDadescontacte.setId(new BigDecimal(2));
		personesDadescontacte.setBloc("1");
		personesDadescontacte.setDireccioPostal("calle22");
		personesDadescontacte.setNumero("1");
		personesDadescontacte.setPis("2");
		personesDadescontacte.setPorta("B");
		personesDadescontacte.setTelefon("666123456");
		persones.setPersonesDadescontacte(personesDadescontacte);
		persones.setNomPresentacio("Maria Martin Mora");
		registreAssentament.setPersones(persones);
		docsEntrada.setRegistreAssentament(registreAssentament);
		docsEntrada.setOrigen(1);
		docsEntrada.setComentari("Comentaris");

		DocsAssociatsIntra docsAssociatsIntra = new DocsAssociatsIntra();
		docsAssociatsIntra.setIdDocumentOriginal(BigDecimal.ONE);
		docsAssociatsIntra.setIdExpedientDestino(BigDecimal.ONE);
		docsAssociatsIntra.setIdExpedientOrigen(BigDecimal.ONE);
		docsAssociatsIntra.setDocsEntrada(docsEntrada);

		DocsAssociatsIntraBDTO docsAssociatsIntraBDTO = new DocsAssociatsIntraBDTO(docsAssociatsIntra);

		documentsService.associatsDocsIntra(docsAssociatsIntraBDTO);
		assertTrue(true);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage39_AssociatsDocsIntra() - fi"); //$NON-NLS-1$
		}
	}

	/**
	 * Test stage 43 es borrar documentacio entrada.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testStage43_EsBorrarDocumentacioEntrada() throws Exception {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage43_EsBorrarDocumentacioEntrada() - inici"); //$NON-NLS-1$
		}

		DocsEntradaRDTO docsEntrada = new DocsEntradaRDTO();
		docsEntrada.setConfigDocEntrada(new BigDecimal(1));
		ConfiguracioDocsEntrada configuracioDocsEntrada = new ConfiguracioDocsEntrada();
		configuracioDocsEntrada.setId(new BigDecimal(6));
		docsEntrada.setConfiguracioDocsEntrada(configuracioDocsEntrada);
		docsEntrada.setConfiguracioDocsEntradaNom("Acreditació de pagaments");
		docsEntrada.setRevisio(2);
		RegistreAssentament registreAssentament = new RegistreAssentament();
		registreAssentament.setId(new BigDecimal(2));
		registreAssentament.setCodi("12/2019");
		registreAssentament.setUsuari(new BigDecimal(1));
		registreAssentament.setDataRegistre(new DateTime());
		registreAssentament.setPersona(new BigDecimal(2));
		Persones persones = new Persones();
		persones.setId(new BigDecimal(2));
		persones.setDadesContacte(new Long(2));
		persones.setDocIndentitat(new BigDecimal(2));
		persones.setTipusPersona(new BigDecimal(1));
		persones.setNomRaoSocial("Maria");
		persones.setCognom1("Martin");
		persones.setCognom2("Mora");
		DocumentsIdentitat documentsIdentitat = new DocumentsIdentitat();
		documentsIdentitat.setId(new BigDecimal(2));
		documentsIdentitat.setTipus(new BigDecimal(0));
		documentsIdentitat.setNumeroDocument("12345668H");
		documentsIdentitat.setPais("108");
		persones.setDocumentsIdentitat(documentsIdentitat);
		PersonesDadescontacte personesDadescontacte = new PersonesDadescontacte();
		personesDadescontacte.setId(new BigDecimal(2));
		personesDadescontacte.setBloc("1");
		personesDadescontacte.setDireccioPostal("calle22");
		personesDadescontacte.setNumero("1");
		personesDadescontacte.setPis("2");
		personesDadescontacte.setPorta("B");
		personesDadescontacte.setTelefon("666123456");
		persones.setPersonesDadescontacte(personesDadescontacte);
		persones.setNomPresentacio("Maria Martin Mora");
		registreAssentament.setPersones(persones);
		docsEntrada.setRegistreAssentament(registreAssentament);
		docsEntrada.setOrigen(1);
		docsEntrada.setComentari("Comentaris");

		EsborrarDocumentBDTO esborrarDocumentBDTO = new EsborrarDocumentBDTO(BigDecimal.ONE, docsEntrada.getId());

		documentsService.esBorrarDocumentacioEntrada(esborrarDocumentBDTO);
		assertTrue(true);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage43_EsBorrarDocumentacioEntrada() - fi"); //$NON-NLS-1$
		}
	}

	/**
	 * Test stage 44 es borrar documentacio tramitacio.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testStage44_EsBorrarDocumentacioTramitacio() throws Exception {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage44_EsBorrarDocumentacioTramitacio() - inici"); //$NON-NLS-1$
		}

		DocsTramitacioRDTO docsTramitacioRDTO = new DocsTramitacioRDTO();
		docsTramitacioRDTO.setConfigDocTramitacio(new BigDecimal(1));
		ConfiguracioDocsTramitacio configuracioDocsTramitacio = new ConfiguracioDocsTramitacio();
		configuracioDocsTramitacio.setId(new BigDecimal(6));
		docsTramitacioRDTO.setConfiguracioDocsTramitacio(configuracioDocsTramitacio);
		docsTramitacioRDTO.setConfiguracioDocsTramitacioNom("Acreditació de pagaments");
		RegistreAssentament registreAssentament = new RegistreAssentament();
		registreAssentament.setId(new BigDecimal(2));
		registreAssentament.setCodi("12/2019");
		registreAssentament.setUsuari(new BigDecimal(1));
		registreAssentament.setDataRegistre(new DateTime());
		registreAssentament.setPersona(new BigDecimal(2));
		Persones persones = new Persones();
		persones.setId(new BigDecimal(2));
		persones.setDadesContacte(new Long(2));
		persones.setDocIndentitat(new BigDecimal(2));
		persones.setTipusPersona(new BigDecimal(1));
		persones.setNomRaoSocial("Maria");
		persones.setCognom1("Martin");
		persones.setCognom2("Mora");
		DocumentsIdentitat documentsIdentitat = new DocumentsIdentitat();
		documentsIdentitat.setId(new BigDecimal(2));
		documentsIdentitat.setTipus(new BigDecimal(0));
		documentsIdentitat.setNumeroDocument("12345668H");
		documentsIdentitat.setPais("108");
		persones.setDocumentsIdentitat(documentsIdentitat);
		PersonesDadescontacte personesDadescontacte = new PersonesDadescontacte();
		personesDadescontacte.setId(new BigDecimal(2));
		personesDadescontacte.setBloc("1");
		personesDadescontacte.setDireccioPostal("calle22");
		personesDadescontacte.setNumero("1");
		personesDadescontacte.setPis("2");
		personesDadescontacte.setPorta("B");
		personesDadescontacte.setTelefon("666123456");
		persones.setPersonesDadescontacte(personesDadescontacte);
		persones.setNomPresentacio("Maria Martin Mora");
		registreAssentament.setPersones(persones);
		docsTramitacioRDTO.setRegistreAssentament(registreAssentament);
		docsTramitacioRDTO.setOrigen(1);
		docsTramitacioRDTO.setComentari("Comentaris");

		EsborrarDocumentBDTO esborrarDocumentBDTO = new EsborrarDocumentBDTO(BigDecimal.ONE, docsTramitacioRDTO.getId());

		documentsService.esBorrarDocumentacioTramitacio(esborrarDocumentBDTO);
		assertTrue(true);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage44_EsBorrarDocumentacioTramitacio() - fi"); //$NON-NLS-1$
		}
	}

	/**
	 * Test stage 45 save document gestor documental.
	 *
	 * @throws GPAServeisServiceException
	 *             the GPA documentacio service exception
	 * @throws OpenTextException
	 *             the open text exception
	 */
	@Test
	public void testStage45_SaveDocumentEntradaGestorDocumental() throws GPAServeisServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage45_SaveDocumentEntradaGestorDocumental() - inici"); //$NON-NLS-1$
		}

		BigDecimal idExpedient = new BigDecimal(1);
		DocsEntradaRDTO docsEntradaRDTO = new DocsEntradaRDTO();
		docsEntradaRDTO.setId(new BigDecimal(1));
		docsEntradaRDTO.setDataCreacio(new DateTime());
		docsEntradaRDTO.setDataPresentacio(new DateTime());
		docsEntradaRDTO.setDocumentacio(new BigDecimal(1));
		docsEntradaRDTO.setEliminat(0);
		docsEntradaRDTO.setDocumentFisic(new BigDecimal(1));
		docsEntradaRDTO.setConfigDocEntrada(new BigDecimal(5));
		ConfiguracioDocsEntrada configuracioDocsEntrada = new ConfiguracioDocsEntrada();
		configuracioDocsEntrada.setId(new BigDecimal(5));
		docsEntradaRDTO.setConfiguracioDocsEntrada(configuracioDocsEntrada);
		docsEntradaRDTO.setConfiguracioDocsEntradaNom("Formulari de sol•licitud");
		docsEntradaRDTO.setRevisio(3);
		DocsFisics docsFisics = new DocsFisics();
		docsFisics.setNom("prova.txt");
		docsFisics.setTamany((long) 12345);
		docsEntradaRDTO.setDocsFisics(docsFisics);
		RegistreAssentament registreAssentament = new RegistreAssentament();
		registreAssentament.setId(new BigDecimal(2));
		registreAssentament.setCodi("12/2019");
		registreAssentament.setUsuari(new BigDecimal(1));
		registreAssentament.setDataRegistre(new DateTime());
		registreAssentament.setPersona(new BigDecimal(2));
		Persones persones = new Persones();
		persones.setId(new BigDecimal(2));
		persones.setDadesContacte(new Long(2));
		persones.setDocIndentitat(new BigDecimal(2));
		persones.setTipusPersona(new BigDecimal(1));
		persones.setNomRaoSocial("Maria");
		persones.setCognom1("Martin");
		persones.setCognom2("Mora");
		DocumentsIdentitat documentsIdentitat = new DocumentsIdentitat();
		documentsIdentitat.setId(new BigDecimal(2));
		documentsIdentitat.setTipus(new BigDecimal(0));
		documentsIdentitat.setNumeroDocument("12345668H");
		documentsIdentitat.setPais("108");
		persones.setDocumentsIdentitat(documentsIdentitat);
		PersonesDadescontacte personesDadescontacte = new PersonesDadescontacte();
		personesDadescontacte.setId(new BigDecimal(2));
		personesDadescontacte.setBloc("1");
		personesDadescontacte.setDireccioPostal("calle22");
		personesDadescontacte.setNumero("1");
		personesDadescontacte.setPis("2");
		personesDadescontacte.setPorta("B");
		personesDadescontacte.setTelefon("666123456");
		persones.setPersonesDadescontacte(personesDadescontacte);
		persones.setNomPresentacio("Maria Martin Mora");
		registreAssentament.setPersones(persones);
		docsEntradaRDTO.setRegistreAssentament(registreAssentament);
		docsEntradaRDTO.setOrigen(1);
		docsEntradaRDTO.setComentari("Comentaris");

		String idGestorDocumental = "12/2019";
		MockMultipartFile mockMultipartFile = new MockMultipartFile("file", "prova.txt", "text/plain", "prova".getBytes());
		GuardarDocumentEntradaFitxerBDTO guardarDocumentEntradaFitxerBDTO = new GuardarDocumentEntradaFitxerBDTO(idExpedient,
				docsEntradaRDTO, mockMultipartFile, idGestorDocumental);

		documentsService.guardarDocumentEntradaGestorDocumental(guardarDocumentEntradaFitxerBDTO);
		assertTrue(true);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage45_SaveDocumentEntradaGestorDocumental() - fi"); //$NON-NLS-1$
		}
	}

	/**
	 * Test stage 04 insert documentacio entrada.
	 *
	 * @throws GPAServeisServiceException
	 *             the GPA documentacio service exception
	 * @throws OpenTextException
	 *             the open text exception
	 */
	@Test
	public void testStage46_InsertDocumentacioTramitacio() throws GPAServeisServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage46_InsertDocumentacioTramitacio() - inici"); //$NON-NLS-1$
		}

		BigDecimal idExpedient = new BigDecimal(1);
		BigDecimal idSollicitud = new BigDecimal(1);
		DocsTramitacioRDTO docsTramitacioRDTO = new DocsTramitacioRDTO();
		docsTramitacioRDTO.setConfigDocTramitacio(new BigDecimal(1));
		docsTramitacioRDTO.setEstat(new BigDecimal(1));
		ConfiguracioDocsTramitacio configuracioDocsTramitacio = new ConfiguracioDocsTramitacio();
		configuracioDocsTramitacio.setId(new BigDecimal(1));
		docsTramitacioRDTO.setConfiguracioDocsTramitacio(configuracioDocsTramitacio);
		docsTramitacioRDTO.setConfiguracioDocsTramitacioNom("Diligència d’inici d’ofici (Condicionat)");
		DocsFisics docsFisics = new DocsFisics();
		docsFisics.setNom("prova.txt");
		docsTramitacioRDTO.setDocsFisics(docsFisics);
		docsTramitacioRDTO.setOrigen(1);
		docsTramitacioRDTO.setComentari("Comentaris");
		docsTramitacioRDTO.setEstatDocsTramitacio(BigDecimal.ONE);

		CrearDocumentTramitacioBDTO actualitzarDocumentTramitacioBDTO = new CrearDocumentTramitacioBDTO(idExpedient, idSollicitud,
				docsTramitacioRDTO);

		DocsTramitacioRDTO docsEntradaRDTODB = documentsService.crearDocumentTramitacio(actualitzarDocumentTramitacioBDTO);
		assertTrue(true);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage46_InsertDocumentacioTramitacio() - fi"); //$NON-NLS-1$
		}
		assertNotNull(docsEntradaRDTODB.getId());

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage46_InsertDocumentacioTramitacio() - fi"); //$NON-NLS-1$
		}
	}

	/**
	 * Test stage 04 update documentacio entrada.
	 *
	 * @throws GPAServeisServiceException
	 *             the GPA documentacio service exception
	 * @throws OpenTextException
	 *             the open text exception
	 */
	@Test
	public void testStage47_UpdateDocumentacioTramitacio() throws GPAServeisServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage47_UpdateDocumentacioTramitacio() - inici"); //$NON-NLS-1$
		}

		BigDecimal idExpedient = new BigDecimal(1);
		DocsTramitacioRDTO docsTramitacioRDTO = new DocsTramitacioRDTO();
		docsTramitacioRDTO.setConfigDocTramitacio(new BigDecimal(1));
		docsTramitacioRDTO.setEstat(new BigDecimal(1));
		ConfiguracioDocsTramitacio configuracioDocsTramitacio = new ConfiguracioDocsTramitacio();
		configuracioDocsTramitacio.setId(new BigDecimal(1));
		docsTramitacioRDTO.setConfiguracioDocsTramitacio(configuracioDocsTramitacio);
		docsTramitacioRDTO.setConfiguracioDocsTramitacioNom("Diligència d’inici d’ofici (Condicionat)");
		DocsFisics docsFisics = new DocsFisics();
		docsFisics.setNom("prova.txt");
		docsTramitacioRDTO.setDocsFisics(docsFisics);
		docsTramitacioRDTO.setOrigen(1);
		docsTramitacioRDTO.setComentari("Comentaris");
		docsTramitacioRDTO.setEstatDocsTramitacio(BigDecimal.ONE);

		ActualitzarDocumentTramitacioBDTO actualitzarDocumentTramitacioBDTO = new ActualitzarDocumentTramitacioBDTO(idExpedient,
				docsTramitacioRDTO);

		documentsService.actualitzarDocumentTramitacio(actualitzarDocumentTramitacioBDTO);
		assertTrue(true);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage47_UpdateDocumentacioTramitacio() - fi"); //$NON-NLS-1$
		}
	}

	/**
	 * Test stage 04 update documentacio entrada.
	 *
	 * @throws GPAServeisServiceException
	 *             the GPA documentacio service exception
	 * @throws OpenTextException
	 *             the open text exception
	 */
	@Test
	public void testStage48_obtenirDocsTramitacioByNotificationId() throws GPAServeisServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage48_obtenirDocsTramitacioByNotificationId() - inici"); //$NON-NLS-1$
		}

		documentsService.obtenirDocsTramitacioByNotificationId((long) 1);
		assertTrue(true);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage48_obtenirDocsTramitacioByNotificationId() - fi"); //$NON-NLS-1$
		}
	}

	/**
	 * Test stage 04 update documentacio entrada.
	 *
	 * @throws GPAServeisServiceException
	 *             the GPA documentacio service exception
	 * @throws OpenTextException
	 *             the open text exception
	 */
	@Test
	public void testStage49_cercaConfiguracioDocumentacioEntrada() throws GPAServeisServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage49_cercaConfiguracioDocumentacioEntrada() - inici"); //$NON-NLS-1$
		}

		DocumentsEntradaCercaBDTO documentsEntradaCercaBDTO = new DocumentsEntradaCercaBDTO(new BigDecimal(1), new BigDecimal(1));

		PageDataOfConfiguracioDocsEntradaRDTO pageDataOfConfiguracioDocsEntradaRDTO = documentsService
				.cercaConfiguracioDocumentacioEntrada(documentsEntradaCercaBDTO);
		assertNotNull(pageDataOfConfiguracioDocsEntradaRDTO);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage49_cercaConfiguracioDocumentacioEntrada() - fi"); //$NON-NLS-1$
		}
	}

	/**
	 * Test stage 04 update documentacio entrada.
	 *
	 * @throws GPAServeisServiceException
	 *             the GPA documentacio service exception
	 * @throws OpenTextException
	 *             the open text exception
	 */
	@Test
	public void testStage50_cercaConfiguracioDocumentacioEntradaPerTramitOvt() throws GPAServeisServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage49_cercaConfiguracioDocumentacioEntrada() - inici"); //$NON-NLS-1$
		}

		DocumentsEntradaCercaBDTO documentsEntradaCercaBDTO = new DocumentsEntradaCercaBDTO(new BigDecimal(1), new BigDecimal(1));

		PageDataOfConfiguracioDocsEntradaRDTO pageDataOfConfiguracioDocsEntradaRDTO = documentsService
				.cercaConfiguracioDocumentacioEntradaPerTramitOvt(documentsEntradaCercaBDTO);
		assertNotNull(pageDataOfConfiguracioDocsEntradaRDTO);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage49_cercaConfiguracioDocumentacioEntrada() - fi"); //$NON-NLS-1$
		}
	}

	/**
	 * Test stage 04 update documentacio entrada.
	 *
	 * @throws GPAServeisServiceException
	 *             the GPA documentacio service exception
	 * @throws OpenTextException
	 *             the open text exception
	 */
	@Test
	public void testStage51_cercaConfiguracioDocumentacioTramitacio() throws GPAServeisServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage49_cercaConfiguracioDocumentacioEntrada() - inici"); //$NON-NLS-1$
		}

		DocumentsTramitacioCercaBDTO documentsTramitacioCercaBDTO = new DocumentsTramitacioCercaBDTO(new BigDecimal(1));

		PageDataOfConfiguracioDocsTramitacioRDTO pageDataOfConfiguracioDocsTramitacioRDTO = documentsService
				.cercaConfiguracioDocumentacioTramitacio(documentsTramitacioCercaBDTO);
		assertNotNull(pageDataOfConfiguracioDocsTramitacioRDTO);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage49_cercaConfiguracioDocumentacioEntrada() - fi"); //$NON-NLS-1$
		}
	}

	/**
	 * Test stage 04 update documentacio entrada.
	 *
	 * @throws GPAServeisServiceException
	 *             the GPA documentacio service exception
	 * @throws OpenTextException
	 *             the open text exception
	 */
	@Test
	public void testStage52_crearNotificacio() throws GPAServeisServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage49_cercaConfiguracioDocumentacioEntrada() - inici"); //$NON-NLS-1$
		}

		Persones persones = new Persones();
		persones.setId(new BigDecimal(2));
		persones.setDadesContacte(new Long(2));
		persones.setDocIndentitat(new BigDecimal(2));
		persones.setTipusPersona(new BigDecimal(1));
		persones.setNomRaoSocial("Maria");
		persones.setCognom1("Martin");
		persones.setCognom2("Mora");
		DocumentsIdentitat documentsIdentitat = new DocumentsIdentitat();
		documentsIdentitat.setId(new BigDecimal(2));
		documentsIdentitat.setTipus(new BigDecimal(0));
		documentsIdentitat.setNumeroDocument("12345668H");
		documentsIdentitat.setPais("108");
		persones.setDocumentsIdentitat(documentsIdentitat);
		PersonesDadescontacte personesDadescontacte = new PersonesDadescontacte();
		personesDadescontacte.setId(new BigDecimal(2));
		personesDadescontacte.setBloc("1");
		personesDadescontacte.setDireccioPostal("calle22");
		personesDadescontacte.setNumero("1");
		personesDadescontacte.setPis("2");
		personesDadescontacte.setPorta("B");
		personesDadescontacte.setTelefon("666123456");
		persones.setPersonesDadescontacte(personesDadescontacte);
		persones.setNomPresentacio("Maria Martin Mora");

		CrearNotificacio crearNotificacio = new CrearNotificacio();
		crearNotificacio.setCodiExpedient("2019_EXP_0001");
		crearNotificacio.setCodiProcediment("AF01");
		crearNotificacio.setIdDocumentPrincipal(new BigDecimal(1));
		crearNotificacio.setIdExpedient(new BigDecimal(1));
		crearNotificacio.setIdsAnnexosList(Arrays.asList(new BigDecimal[] { new BigDecimal(1), new BigDecimal(2) }));
		crearNotificacio.setPersones(Arrays.asList(new Persones[] { persones }));

		DocumentCrearNotificacioBDTO documentCrearNotificacioBDTO = new DocumentCrearNotificacioBDTO(crearNotificacio);

		NotificacionsRDTO notificacionsRDTO = documentsService.crearNotificacio(documentCrearNotificacioBDTO);
		assertNotNull(notificacionsRDTO);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage49_cercaConfiguracioDocumentacioEntrada() - fi"); //$NON-NLS-1$
		}
	}

	/**
	 * Test stage 04 update documentacio entrada.
	 *
	 * @throws GPAServeisServiceException
	 *             the GPA documentacio service exception
	 * @throws OpenTextException
	 *             the open text exception
	 */
	@Test
	public void testStage53_obrirRequerimentsExpedient() throws GPAServeisServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage49_cercaConfiguracioDocumentacioEntrada() - inici"); //$NON-NLS-1$
		}

		documentsService.obrirRequerimentsExpedient(new BigDecimal(1));
		assertTrue(true);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage49_cercaConfiguracioDocumentacioEntrada() - fi"); //$NON-NLS-1$
		}
	}

	/**
	 * Test stage 04 update documentacio entrada.
	 *
	 * @throws GPAServeisServiceException
	 *             the GPA documentacio service exception
	 * @throws OpenTextException
	 *             the open text exception
	 */
	@Test
	public void testStage54_desassociarRegistreDocumentacioExpedient() throws GPAServeisServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage49_cercaConfiguracioDocumentacioEntrada() - inici"); //$NON-NLS-1$
		}

		DocumentActualizarRegistre documentActualizarRegistre = new DocumentActualizarRegistre();
		documentActualizarRegistre.setIdDoc(new BigDecimal(1));
		documentActualizarRegistre.setIdRegistre(new BigDecimal(1));

		documentsService.desassociarRegistreDocumentacioExpedient(documentActualizarRegistre);
		assertTrue(true);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("testStage49_cercaConfiguracioDocumentacioEntrada() - fi"); //$NON-NLS-1$
		}
	}
}