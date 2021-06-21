package es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.ConfDocEntradaRequeritRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsTramitacioRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.DocumentsIdentitat;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.EstatsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.Persones;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PersonesDadescontacte;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PersonesSollicitud;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PersonesSollicitudRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.SollicitudsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.TipusDocumentIdentitat;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.DadesOperTramitsOvt;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.DadesOperValidVal;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.DadesOperacions;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.DadesOperacionsValidacio;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.DadesoperEstatsExp;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.Items;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.ProcedimentPersones;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaunitats.UnitatsGestoresRDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.Constants;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.common.BooleanApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.document.ConfiguracioApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.expedient.EstatTramitadorApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.expedient.RelacioPersonaApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.procediment.TipusValidacioApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.procediment.TramitOvtApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.BaseApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.common.BooleanApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.document.NivellCriticitatApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.expedient.TipusDocumentIdentitatApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.expedient.TipusPersonaApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.expedient.TipusSexeApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.expedient.TipusViaNotificacioApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.procediment.NivellVisibilitatApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.procediment.TramitsOvtProcedimentsApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.ConfiguracioDocumentacioRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.DadesContacteRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.DocumentsIdentitatRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.PersonesRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.RegistreRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.SollicitudsExpedientRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.accions.documentacio.DeclaracioResponsablePresentadaAccioRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.accions.documentacio.DocumentAportatAccioRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.accions.documentacio.DocumentCompletatAccioRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.accions.documentacio.DocumentDigitalitzarAccioRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.accions.documentacio.DocumentIncorporatNouAccioRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.accions.documentacio.RequerimentPreparatAccioRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.accions.expedients.TercerPersonaActualitzadaAccioRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.accions.expedients.TercerPersonaCreadaAccioRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.DadesAtributsRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.DadesAtributsValidacionsRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.DadesAtributsValorsLlistaRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.DadesAtributsValorsValidacionsRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.HistoricsRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.ProcedimentPersonesRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.UnitatGestoraRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.TramitsOvtRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.documents.ConfiguracioDocumentacioRequeridaConsultaRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.documents.DocumentAportatConsultaRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.documents.DocumentGeneratConsultaRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.notificar.PersonesNotificacioRDTO;

/**
 * The Class ConverterHelper.
 */
public class ConverterHelper {

	/** The Constant CODI_EXPEDIENT_FORMATTED_PATTERN. */
	private static final String CODI_EXPEDIENT_FORMATTED_PATTERN = "(\\d{4}_)(EXP_)?(\\d+)";

	/** The Constant CODI_EXPEDIENT_EN_PREPARACIO_FORMAT. */
	private static final String CODI_EXPEDIENT_EN_PREPARACIO_FORMAT = "%s%s";

	/** The Constant CODI_EXPEDIENT_ALTRES_ESTATS_FORMAT. */
	private static final String CODI_EXPEDIENT_ALTRES_ESTATS_FORMAT = "%sEXP_%s";

	/**
	 * Builds the unitat gestora RDTO unitats.
	 *
	 * @param unitatsGestoresRDTO
	 *            the unitats gestores RDTO
	 * @return the unitat gestora RDTO
	 */
	public static UnitatGestoraRDTO buildUnitatGestoraRDTOUnitats(UnitatsGestoresRDTO unitatsGestoresRDTO) {
		UnitatGestoraRDTO unitatGestoraRDTO = new UnitatGestoraRDTO();
		unitatGestoraRDTO.setCodi(unitatsGestoresRDTO.getNom());
		unitatGestoraRDTO.setNom(unitatsGestoresRDTO.getDescripcio());
		return unitatGestoraRDTO;
	}

	/**
	 * Builds the historics RDTO expedient.
	 *
	 * @param estatsRDTO
	 *            the estats RDTO
	 * @return the historics RDTO
	 */
	public static HistoricsRDTO buildHistoricsRDTOExpedient(EstatsRDTO estatsRDTO) {

		HistoricsRDTO historicsRDTO = new HistoricsRDTO();
		DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(Constants.DATE_TIME_PATTERN);
		historicsRDTO.setDataCreacio((estatsRDTO.getDataCreacio() != null) ? dateTimeFormatter.print(estatsRDTO.getDataCreacio()) : null);
		historicsRDTO.setEstat(estatsRDTO.getDescripcioEstatActualCiutadaCatala());
		historicsRDTO.setEstatCastella(estatsRDTO.getDescripcioEstatActualCiutadaCastella());
		return historicsRDTO;
	}

	/**
	 * Builds the historics tramitadors RDTO expedient.
	 *
	 * @param estatsRDTO
	 *            the estats RDTO
	 * @return the historics RDTO
	 */
	public static HistoricsRDTO buildHistoricsTramitadorsRDTOExpedient(EstatsRDTO estatsRDTO) {

		HistoricsRDTO historicsRDTO = new HistoricsRDTO();
		DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(Constants.DATE_TIME_PATTERN);
		historicsRDTO.setDataCreacio((estatsRDTO.getDataCreacio() != null) ? dateTimeFormatter.print(estatsRDTO.getDataCreacio()) : null);
		historicsRDTO.setEstat(estatsRDTO.getDescripcioEstatActualTramitadorCatala());
		historicsRDTO.setEstatCastella(estatsRDTO.getDescripcioEstatActualTramitadorCastella());
		return historicsRDTO;
	}

	/**
	 * Builds the persones RDTO expedient.
	 *
	 * @param persones
	 *            the persones
	 * @param tipusPersonaApiParamValueTranslator
	 *            the tipus persona api param value translator
	 * @param tipusDocumentIdentitatApiParamValueTranslator
	 *            the tipus document identitat api param value translator
	 * @param tipusSexeApiParamValueTranslator
	 *            the tipus sexe api param value translator
	 * @return the persones RDTO
	 */
	public static PersonesRDTO buildPersonesRDTOExpedient(Persones persones,
	        BaseApiParamValueTranslator tipusPersonaApiParamValueTranslator,
	        BaseApiParamValueTranslator tipusDocumentIdentitatApiParamValueTranslator,
	        BaseApiParamValueTranslator tipusSexeApiParamValueTranslator, BooleanApiParamValueTranslator booleanApiParamValueTranslator) {

		if (persones == null) {
			return null;
		}

		PersonesRDTO personesRDTO = new PersonesRDTO();
		personesRDTO.setTipusPersona(tipusPersonaApiParamValueTranslator.getApiParamValueByInternalValue(persones.getTipusPersona()));
		personesRDTO.setNomRaoSocial(persones.getNomRaoSocial());
		personesRDTO.setCognom1(persones.getCognom1());
		personesRDTO.setCognom2(persones.getCognom2());
		if (persones.getPersonesDadescontacte() != null) {
			DadesContacteRDTO dadesContacte = new DadesContacteRDTO();
			dadesContacte.setEmail(persones.getPersonesDadescontacte().getEmail());
			dadesContacte.setTelefon(persones.getPersonesDadescontacte().getTelefon());
			dadesContacte.setMobil(persones.getPersonesDadescontacte().getMobil());
			dadesContacte.setFax(persones.getPersonesDadescontacte().getFax());
			dadesContacte.setTipusVia(persones.getPersonesDadescontacte().getTipusVia());
			dadesContacte.setNomVia(persones.getPersonesDadescontacte().getDireccioPostal());
			dadesContacte.setNumero(persones.getPersonesDadescontacte().getNumero());
			dadesContacte.setEscala(persones.getPersonesDadescontacte().getEscala());
			dadesContacte.setBloc(persones.getPersonesDadescontacte().getBloc());
			dadesContacte.setPorta(persones.getPersonesDadescontacte().getPorta());
			dadesContacte.setPis(persones.getPersonesDadescontacte().getPis());
			dadesContacte.setCodiPostal(persones.getPersonesDadescontacte().getCodiPostal());
			dadesContacte.setMunicipi(persones.getPersonesDadescontacte().getMunicipi());
			dadesContacte.setProvincia(persones.getPersonesDadescontacte().getProvincia());
			dadesContacte.setPais(persones.getPersonesDadescontacte().getPais());
			dadesContacte.setMunicipiEstranger(persones.getPersonesDadescontacte().getMunicipiEstranger());
			dadesContacte.setProvinciaEstranger(persones.getPersonesDadescontacte().getProvinciaEstranger());
			dadesContacte.setNotificacioPaper(booleanApiParamValueTranslator
			        .getApiParamValueAsBooleanByInternalValue(persones.getPersonesDadescontacte().getNotificacioPaper()));

			personesRDTO.setDadesNotificacio(dadesContacte);
		}
		DocumentsIdentitatRDTO documentsIdentitatRDTO = new DocumentsIdentitatRDTO();
		if (persones.getDocumentsIdentitat() != null) {
			if (persones.getDocumentsIdentitat().getTipusDocumentIdentitat() != null) {
				documentsIdentitatRDTO.setTipusDocument(tipusDocumentIdentitatApiParamValueTranslator
				        .getApiParamValueByInternalValue(persones.getDocumentsIdentitat().getTipusDocumentIdentitat().getId()));
			}
			documentsIdentitatRDTO.setNumeroDocument(persones.getDocumentsIdentitat().getNumeroDocument().toUpperCase());
			documentsIdentitatRDTO.setPais(persones.getDocumentsIdentitat().getPais());
		}
		personesRDTO.setDocumentIndentitat(documentsIdentitatRDTO);
		return personesRDTO;
	}

	/**
	 * Builds the persones RDTO expedient.
	 *
	 * @param personesSol
	 *            the personesSol
	 * @param tipusPersonaApiParamValueTranslator
	 *            the tipus persona api param value translator
	 * @param tipusDocumentIdentitatApiParamValueTranslator
	 *            the tipus document identitat api param value translator
	 * @param tipusSexeApiParamValueTranslator
	 *            the tipus sexe api param value translator
	 * @param relacioPersonaApiParamValueTranslator
	 *            the relacio persona api param value translator
	 * @return the persones RDTO
	 */
	public static PersonesRDTO buildPersonesRDTOExpedient(PersonesSollicitudRDTO personesSol,
	        BaseApiParamValueTranslator tipusPersonaApiParamValueTranslator,
	        BaseApiParamValueTranslator tipusDocumentIdentitatApiParamValueTranslator,
	        BaseApiParamValueTranslator tipusSexeApiParamValueTranslator,
	        BaseApiParamValueTranslator relacioPersonaApiParamValueTranslator) {

		if (personesSol == null) {
			return null;
		}

		PersonesRDTO personesRDTO = new PersonesRDTO();
		personesRDTO.setTipusPersona(
		        tipusPersonaApiParamValueTranslator.getApiParamValueByInternalValue(personesSol.getPersones().getTipusPersona()));
		personesRDTO.setNomRaoSocial(personesSol.getPersones().getNomRaoSocial());
		personesRDTO.setCognom1(personesSol.getPersones().getCognom1());
		personesRDTO.setCognom2(personesSol.getPersones().getCognom2());
		if (personesSol.getPersones().getPersonesDadescontacte() != null) {
			DadesContacteRDTO dadesContacte = new DadesContacteRDTO();
			dadesContacte.setEmail(personesSol.getPersones().getPersonesDadescontacte().getEmail());
			dadesContacte.setTelefon(personesSol.getPersones().getPersonesDadescontacte().getTelefon());
			dadesContacte.setMobil(personesSol.getPersones().getPersonesDadescontacte().getMobil());
			dadesContacte.setFax(personesSol.getPersones().getPersonesDadescontacte().getFax());
			dadesContacte.setTipusVia(personesSol.getPersones().getPersonesDadescontacte().getTipusVia());
			dadesContacte.setNomVia(personesSol.getPersones().getPersonesDadescontacte().getDireccioPostal());
			dadesContacte.setNumero(personesSol.getPersones().getPersonesDadescontacte().getNumero());
			dadesContacte.setEscala(personesSol.getPersones().getPersonesDadescontacte().getEscala());
			dadesContacte.setBloc(personesSol.getPersones().getPersonesDadescontacte().getBloc());
			dadesContacte.setPorta(personesSol.getPersones().getPersonesDadescontacte().getPorta());
			dadesContacte.setPis(personesSol.getPersones().getPersonesDadescontacte().getPis());
			dadesContacte.setCodiPostal(personesSol.getPersones().getPersonesDadescontacte().getCodiPostal());
			dadesContacte.setMunicipi(personesSol.getPersones().getPersonesDadescontacte().getMunicipi());
			dadesContacte.setProvincia(personesSol.getPersones().getPersonesDadescontacte().getProvincia());
			dadesContacte.setPais(personesSol.getPersones().getPersonesDadescontacte().getPais());
			dadesContacte.setMunicipiEstranger(personesSol.getPersones().getPersonesDadescontacte().getMunicipiEstranger());
			dadesContacte.setProvinciaEstranger(personesSol.getPersones().getPersonesDadescontacte().getProvinciaEstranger());

			personesRDTO.setDadesNotificacio(dadesContacte);
		}
		DocumentsIdentitatRDTO documentsIdentitatRDTO = new DocumentsIdentitatRDTO();
		if (personesSol.getPersones().getDocumentsIdentitat() != null) {
			if (personesSol.getPersones().getDocumentsIdentitat().getTipusDocumentIdentitat() != null) {
				documentsIdentitatRDTO.setTipusDocument(tipusDocumentIdentitatApiParamValueTranslator.getApiParamValueByInternalValue(
				        personesSol.getPersones().getDocumentsIdentitat().getTipusDocumentIdentitat().getId()));
			}
			documentsIdentitatRDTO.setNumeroDocument(personesSol.getPersones().getDocumentsIdentitat().getNumeroDocument().toUpperCase());
			documentsIdentitatRDTO.setPais(personesSol.getPersones().getDocumentsIdentitat().getPais());
		}
		personesRDTO.setDocumentIndentitat(documentsIdentitatRDTO);
		personesRDTO.setRelacio(relacioPersonaApiParamValueTranslator.getApiParamValueByInternalValue(personesSol.getRelacio()));
		personesRDTO.setRelacioTerceraPersona(personesSol.getRelacioImplicada());
		return personesRDTO;
	}

	/**
	 * Builds the persones sollicitud expedient.
	 *
	 * @param personesRDTO
	 *            the persones RDTO
	 * @param relacioPersonaApiParamValue
	 *            the relacio persona api param value
	 * @param tipusPersonaApiParamValueTranslator
	 *            the tipus persona api param value translator
	 * @param tipusDocumentIdentitatApiParamValueTranslator
	 *            the tipus document identitat api param value translator
	 * @param tipusSexeApiParamValueTranslator
	 *            the tipus sexe api param value translator
	 * @return the persones sollicitud
	 */
	public static PersonesSollicitud buildPersonesSollicitudExpedient(PersonesRDTO personesRDTO,
	        RelacioPersonaApiParamValue relacioPersonaApiParamValue,
	        TipusPersonaApiParamValueTranslator tipusPersonaApiParamValueTranslator,
	        TipusDocumentIdentitatApiParamValueTranslator tipusDocumentIdentitatApiParamValueTranslator,
	        BooleanApiParamValueTranslator booleanApiParamValueTranslator,
	        TipusSexeApiParamValueTranslator tipusSexeApiParamValueTranslator, boolean relacionPrincipal) {
		PersonesSollicitud personesSollicitud = null;

		if (personesRDTO != null) {
			personesSollicitud = new PersonesSollicitud();
			personesSollicitud.setEsInteressada(BooleanApiParamValue.FALSE.getInternalValue());
			if (relacioPersonaApiParamValue != null && (relacioPersonaApiParamValue.getInternalValue()
			        .compareTo(RelacioPersonaApiParamValue.SOLLICITANT.getInternalValue()) == 0
			        || relacioPersonaApiParamValue.getInternalValue()
			                .compareTo(RelacioPersonaApiParamValue.REPRESENTANT.getInternalValue()) == 0)) {
				personesSollicitud.setEsInteressada(BooleanApiParamValue.TRUE.getInternalValue());

				personesSollicitud.setRelacio(relacioPersonaApiParamValue.getInternalValue());
			}
			personesSollicitud.setRelacioImplicada(personesRDTO.getRelacioTerceraPersona());
			personesSollicitud
			        .setRelacioPrincipal(booleanApiParamValueTranslator.getInternalValueByApiParamValueAsBoolean(relacionPrincipal));
			personesSollicitud.setVisibilitatOvt(
			        booleanApiParamValueTranslator.getInternalValueByApiParamValueAsBoolean(personesRDTO.getVisibilitatOvt()));
			Persones persones = new Persones();
			persones.setTipusPersona(tipusPersonaApiParamValueTranslator.getInternalValueByApiParamValue(personesRDTO.getTipusPersona()));
			persones.setNomRaoSocial(personesRDTO.getNomRaoSocial());
			persones.setCognom1(personesRDTO.getCognom1());
			persones.setCognom2(personesRDTO.getCognom2());
			DocumentsIdentitat documentsIdentitat = new DocumentsIdentitat();
			TipusDocumentIdentitat tipusDocumentIdentitat = new TipusDocumentIdentitat();
			tipusDocumentIdentitat.setId(tipusDocumentIdentitatApiParamValueTranslator
			        .getInternalValueByApiParamValue(personesRDTO.getDocumentIndentitat().getTipusDocument()));
			documentsIdentitat.setTipusDocumentIdentitat(tipusDocumentIdentitat);
			documentsIdentitat.setTipus(tipusDocumentIdentitatApiParamValueTranslator
			        .getInternalValueByApiParamValue(personesRDTO.getDocumentIndentitat().getTipusDocument()));
			documentsIdentitat.setNumeroDocument(personesRDTO.getDocumentIndentitat().getNumeroDocument());
			documentsIdentitat.setPais(personesRDTO.getDocumentIndentitat().getPais());
			persones.setDocumentsIdentitat(documentsIdentitat);
			PersonesDadescontacte personesDadescontacte = new PersonesDadescontacte();
			if (personesRDTO.getDadesNotificacio() != null) {
				personesDadescontacte.setEmail(personesRDTO.getDadesNotificacio().getEmail());
				personesDadescontacte.setTelefon(personesRDTO.getDadesNotificacio().getTelefon());
				personesDadescontacte.setMobil(personesRDTO.getDadesNotificacio().getMobil());
				personesDadescontacte.setFax(personesRDTO.getDadesNotificacio().getFax());
				personesDadescontacte.setTipusVia(personesRDTO.getDadesNotificacio().getTipusVia());
				personesDadescontacte.setDireccioPostal(personesRDTO.getDadesNotificacio().getNomVia());
				personesDadescontacte.setNumero(personesRDTO.getDadesNotificacio().getNumero());
				personesDadescontacte.setEscala(personesRDTO.getDadesNotificacio().getEscala());
				personesDadescontacte.setBloc(personesRDTO.getDadesNotificacio().getBloc());
				personesDadescontacte.setPorta(personesRDTO.getDadesNotificacio().getPorta());
				personesDadescontacte.setPis(personesRDTO.getDadesNotificacio().getPis());
				personesDadescontacte.setCodiPostal(personesRDTO.getDadesNotificacio().getCodiPostal());
				personesDadescontacte.setMunicipi(personesRDTO.getDadesNotificacio().getMunicipi());
				personesDadescontacte.setProvincia(personesRDTO.getDadesNotificacio().getProvincia());
				personesDadescontacte.setPais(personesRDTO.getDadesNotificacio().getPais());
				personesDadescontacte.setMunicipiEstranger(personesRDTO.getDadesNotificacio().getMunicipiEstranger());
				personesDadescontacte.setProvinciaEstranger(personesRDTO.getDadesNotificacio().getProvinciaEstranger());
				personesDadescontacte.setNotificacioPaper(booleanApiParamValueTranslator
				        .getInternalValueByApiParamValueAsBoolean(personesRDTO.getDadesNotificacio().getNotificacioPaper()));
				persones.setPersonesDadescontacte(personesDadescontacte);
			}
			personesSollicitud.setPersones(persones);
		}

		return personesSollicitud;
	}

	/**
	 * Builds the persones notificacio expedient.
	 *
	 * @param personesNotificacioRDTO
	 *            the persones notificacio RDTO
	 * @param tipusPersonaApiParamValueTranslator
	 *            the tipus persona api param value translator
	 * @param tipusDocumentIdentitatApiParamValueTranslator
	 *            the tipus document identitat api param value translator
	 * @param tipusViaNotificacioApiParamValueTranslator
	 *            the tipus via notificacio api param value translator
	 * @return the es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.
	 *         persones
	 */
	public static es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.Persones buildPersonesNotificacioExpedient(
	        PersonesNotificacioRDTO personesNotificacioRDTO, TipusPersonaApiParamValueTranslator tipusPersonaApiParamValueTranslator,
	        TipusDocumentIdentitatApiParamValueTranslator tipusDocumentIdentitatApiParamValueTranslator,
	        TipusViaNotificacioApiParamValueTranslator tipusViaNotificacioApiParamValueTranslator) {
		if (personesNotificacioRDTO == null) {
			return null;
		}

		es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.Persones persones = new es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.Persones();
		persones.setTipusPersona(
		        tipusPersonaApiParamValueTranslator.getInternalValueByApiParamValue(personesNotificacioRDTO.getTipusPersona()));
		StringBuffer stringBuffer = new StringBuffer();
		if (StringUtils.isNotEmpty(personesNotificacioRDTO.getNom())) {
			stringBuffer.append(personesNotificacioRDTO.getNom() + " ");
			persones.setNomRaoSocial(personesNotificacioRDTO.getNom());
		} else {
			persones.setNomRaoSocial(StringUtils.EMPTY);
		}
		if (StringUtils.isNotEmpty(personesNotificacioRDTO.getCognom1())) {
			stringBuffer.append(personesNotificacioRDTO.getCognom1() + " ");
			persones.setCognom1(personesNotificacioRDTO.getCognom1());
		} else {
			persones.setCognom1(StringUtils.EMPTY);
		}
		if (StringUtils.isNotEmpty(personesNotificacioRDTO.getCognom2())) {
			stringBuffer.append(personesNotificacioRDTO.getCognom2());
			persones.setCognom2(personesNotificacioRDTO.getCognom2());
		} else {
			persones.setCognom2(StringUtils.EMPTY);
		}
		persones.setNomPresentacio(stringBuffer.toString());

		if (personesNotificacioRDTO.getDadesNotificacio() != null) {
			es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.PersonesDadescontacte personesDadescontacte = new es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.PersonesDadescontacte();
			personesDadescontacte.setEmail(personesNotificacioRDTO.getDadesNotificacio().getEmail());
			personesDadescontacte.setTelefon(personesNotificacioRDTO.getDadesNotificacio().getTelefon());
			personesDadescontacte.setMobil(personesNotificacioRDTO.getDadesNotificacio().getMobil());
			personesDadescontacte.setTipusViesValor(personesNotificacioRDTO.getDadesNotificacio().getTipusVia());
			personesDadescontacte.setDireccioPostal(personesNotificacioRDTO.getDadesNotificacio().getNomVia());
			personesDadescontacte.setNumero(personesNotificacioRDTO.getDadesNotificacio().getNumero());
			personesDadescontacte.setBloc(personesNotificacioRDTO.getDadesNotificacio().getBloc());
			personesDadescontacte.setPorta(personesNotificacioRDTO.getDadesNotificacio().getPorta());
			personesDadescontacte.setPis(personesNotificacioRDTO.getDadesNotificacio().getPis());
			personesDadescontacte.setCodiPostal(personesNotificacioRDTO.getDadesNotificacio().getCodiPostal());
			personesDadescontacte.setMunicipiValor(personesNotificacioRDTO.getDadesNotificacio().getMunicipi());
			personesDadescontacte.setProvinciaValor(personesNotificacioRDTO.getDadesNotificacio().getProvincia());
			personesDadescontacte.setNotificacioPaper((int) tipusViaNotificacioApiParamValueTranslator
			        .getInternalValueByApiParamValue(personesNotificacioRDTO.getDadesNotificacio().getViaNotificacio()));

			persones.setPersonesDadescontacte(personesDadescontacte);
		}

		es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocumentsIdentitat documentsIdentitat = new es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocumentsIdentitat();
		if (personesNotificacioRDTO.getDocumentIdentitat() != null) {
			if (personesNotificacioRDTO.getDocumentIdentitat().getTipusDocument() != null) {
				documentsIdentitat.setTipus(tipusDocumentIdentitatApiParamValueTranslator
				        .getInternalValueByApiParamValue(personesNotificacioRDTO.getDocumentIdentitat().getTipusDocument()));
			}
			if (personesNotificacioRDTO.getDocumentIdentitat().getNumeroDocument() != null) {
				documentsIdentitat.setNumeroDocument(personesNotificacioRDTO.getDocumentIdentitat().getNumeroDocument().toUpperCase());
			}
		}
		persones.setDocumentsIdentitat(documentsIdentitat);

		return persones;
	}

	/**
	 * Builds the persones RDTO expedient.
	 *
	 * @param persones
	 *            the persones
	 * @param tipusPersonaApiParamValueTranslator
	 *            the tipus persona api param value translator
	 * @param tipusDocumentIdentitatApiParamValueTranslator
	 *            the tipus document identitat api param value translator
	 * @param tipusSexeApiParamValueTranslator
	 *            the tipus sexe api param value translator
	 * @return the persones RDTO
	 */
	public static PersonesRDTO buildPersonesRDTOExpedient(es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.Persones persones,
	        BaseApiParamValueTranslator tipusPersonaApiParamValueTranslator,
	        BaseApiParamValueTranslator tipusDocumentIdentitatApiParamValueTranslator,
	        BaseApiParamValueTranslator tipusSexeApiParamValueTranslator) {

		if (persones == null) {
			return null;
		}

		PersonesRDTO personesRDTO = new PersonesRDTO();
		personesRDTO.setTipusPersona(tipusPersonaApiParamValueTranslator.getApiParamValueByInternalValue(persones.getTipusPersona()));
		personesRDTO.setNomRaoSocial(persones.getNomRaoSocial());
		personesRDTO.setCognom1(persones.getCognom1());
		personesRDTO.setCognom2(persones.getCognom2());
		if (persones.getPersonesDadescontacte() != null) {
			DadesContacteRDTO dadesContacte = new DadesContacteRDTO();
			dadesContacte.setEmail(persones.getPersonesDadescontacte().getEmail());
			dadesContacte.setTelefon(persones.getPersonesDadescontacte().getTelefon());
			dadesContacte.setMobil(persones.getPersonesDadescontacte().getMobil());
			dadesContacte.setFax(persones.getPersonesDadescontacte().getFax());
			dadesContacte.setTipusVia(persones.getPersonesDadescontacte().getTipusVia());
			dadesContacte.setNomVia(persones.getPersonesDadescontacte().getDireccioPostal());
			dadesContacte.setNumero(persones.getPersonesDadescontacte().getNumero());
			dadesContacte.setEscala(persones.getPersonesDadescontacte().getEscala());
			dadesContacte.setBloc(persones.getPersonesDadescontacte().getBloc());
			dadesContacte.setPorta(persones.getPersonesDadescontacte().getPorta());
			dadesContacte.setPis(persones.getPersonesDadescontacte().getPis());
			dadesContacte.setCodiPostal(persones.getPersonesDadescontacte().getCodiPostal());
			dadesContacte.setMunicipi(persones.getPersonesDadescontacte().getMunicipi());
			dadesContacte.setProvincia(persones.getPersonesDadescontacte().getProvincia());
			dadesContacte.setPais(persones.getPersonesDadescontacte().getPais());
			dadesContacte.setMunicipiEstranger(persones.getPersonesDadescontacte().getMunicipiEstranger());
			dadesContacte.setProvinciaEstranger(persones.getPersonesDadescontacte().getProvinciaEstranger());

			personesRDTO.setDadesNotificacio(dadesContacte);
		}
		DocumentsIdentitatRDTO documentsIdentitatRDTO = new DocumentsIdentitatRDTO();
		if (persones.getDocumentsIdentitat() != null) {
			if (persones.getDocumentsIdentitat().getTipusDocumentIdentitat() != null) {
				documentsIdentitatRDTO.setTipusDocument(tipusDocumentIdentitatApiParamValueTranslator
				        .getApiParamValueByInternalValue(persones.getDocumentsIdentitat().getTipusDocumentIdentitat().getId()));
			}
			documentsIdentitatRDTO.setNumeroDocument(persones.getDocumentsIdentitat().getNumeroDocument().toUpperCase());
			documentsIdentitatRDTO.setPais(persones.getDocumentsIdentitat().getPais());
		}
		personesRDTO.setDocumentIndentitat(documentsIdentitatRDTO);
		return personesRDTO;
	}

	/**
	 * Builds the dades grups RDTO procediment.
	 *
	 * @param internalDadesGrupsRDTO
	 *            the internal dades grups RDTO
	 * @param tipusCampApiParamValueTranslator
	 *            the tipus camp api param value translator
	 * @param tipusValidacioApiParamValueTranslator
	 *            the tipus validacio api param value translator
	 * @param expedientEstatTramitadorApiParamValueTranslator
	 *            the expedient estat api param value translator
	 * @param nivellCriticitatApiParamValueTranslator
	 * @param booleanApiParamValueTranslator
	 * @return the es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal. dades
	 *         grups RDTO
	 */
	public static es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.DadesGrupsRDTO buildDadesGrupsRDTOProcediment(
	        es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.DadesGrupsRDTO internalDadesGrupsRDTO,
	        BaseApiParamValueTranslator tipusCampApiParamValueTranslator, BaseApiParamValueTranslator tipusValidacioApiParamValueTranslator,
	        BaseApiParamValueTranslator expedientEstatTramitadorApiParamValueTranslator,
	        NivellCriticitatApiParamValueTranslator nivellCriticitatApiParamValueTranslator,
	        BooleanApiParamValueTranslator booleanApiParamValueTranslator, BaseApiParamValueTranslator tipusGrupApiParamValueTranslator) {

		if (internalDadesGrupsRDTO == null) {
			return null;
		}

		es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.DadesGrupsRDTO dadesGrupsRDTO = new es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.DadesGrupsRDTO();
		dadesGrupsRDTO.setId(internalDadesGrupsRDTO.getId());
		dadesGrupsRDTO.setTitol(internalDadesGrupsRDTO.getTitol());
		dadesGrupsRDTO.setTitolCastella(internalDadesGrupsRDTO.getTitolCastella());
		dadesGrupsRDTO.setDescripcio(internalDadesGrupsRDTO.getDescripcio());
		dadesGrupsRDTO.setDescripcioCastella(internalDadesGrupsRDTO.getDescripcioCastella());
		dadesGrupsRDTO.setTipus(tipusGrupApiParamValueTranslator.getApiParamValueByInternalValue(internalDadesGrupsRDTO.getTipusGrup()));
		dadesGrupsRDTO.setColumnes(
		        (internalDadesGrupsRDTO.getNomColumnes() != null) ? String.valueOf(internalDadesGrupsRDTO.getNomColumnes()) : null);
		dadesGrupsRDTO.setUrlValidacio(internalDadesGrupsRDTO.getUrlValidacio());
		dadesGrupsRDTO.setOrdre((internalDadesGrupsRDTO.getOrdre() != null) ? String.valueOf(internalDadesGrupsRDTO.getOrdre()) : null);
		ArrayList<DadesAtributsRDTO> dadesAtributsRDTOList = new ArrayList<DadesAtributsRDTO>();
		if (CollectionUtils.isNotEmpty(internalDadesGrupsRDTO.getDadesOperacionsList())) {
			for (DadesOperacions dadesOperacions : internalDadesGrupsRDTO.getDadesOperacionsList()) {
				dadesAtributsRDTOList
				        .add(ConverterHelper.buildDadesAtributsRDTOProcediment(dadesOperacions, tipusCampApiParamValueTranslator,
				                tipusValidacioApiParamValueTranslator, expedientEstatTramitadorApiParamValueTranslator,
				                nivellCriticitatApiParamValueTranslator, booleanApiParamValueTranslator));
			}
		}
		dadesGrupsRDTO.setAtributs(dadesAtributsRDTOList);
		return dadesGrupsRDTO;
	}

	/**
	 * Builds the dades atributs RDTO procediment.
	 *
	 * @param dadesOperacions
	 *            the dades operacions
	 * @param tipusCampApiParamValueTranslator
	 *            the tipus camp api param value translator
	 * @param tipusValidacioApiParamValueTranslator
	 *            the tipus validacio api param value translator
	 * @param expedientEstatTramitadorApiParamValueTranslator
	 *            the expedient estat api param value translator
	 * @param nivellCriticitatApiParamValueTranslator
	 * @param booleanApiParamValueTranslator
	 * @return the dades atributs RDTO
	 */
	public static DadesAtributsRDTO buildDadesAtributsRDTOProcediment(DadesOperacions dadesOperacions,
	        BaseApiParamValueTranslator tipusCampApiParamValueTranslator, BaseApiParamValueTranslator tipusValidacioApiParamValueTranslator,
	        BaseApiParamValueTranslator expedientEstatTramitadorApiParamValueTranslator,
	        NivellCriticitatApiParamValueTranslator nivellCriticitatApiParamValueTranslator,
	        BooleanApiParamValueTranslator booleanApiParamValueTranslator) {
		DadesAtributsRDTO dadesAtributsRDTO = new DadesAtributsRDTO();
		dadesAtributsRDTO.setCodi(dadesOperacions.getCodi());
		dadesAtributsRDTO.setDescripcio(dadesOperacions.getDescripcio());
		dadesAtributsRDTO.setDescripcioCastella(dadesOperacions.getDescripcioCastella());
		dadesAtributsRDTO.setTitol(dadesOperacions.getTitol());
		dadesAtributsRDTO.setTitolCastella(dadesOperacions.getTitolCastella());
		dadesAtributsRDTO.setTipus(tipusCampApiParamValueTranslator.getApiParamValueByInternalValue(dadesOperacions.getTipus()));
		dadesAtributsRDTO.setVisibilitat(
		        booleanApiParamValueTranslator.getApiParamValueAsBooleanByInternalValue(dadesOperacions.getVisibilitatPortal()));
		dadesAtributsRDTO.setCriticitat(
		        nivellCriticitatApiParamValueTranslator.getApiParamValueByInternalValue(dadesOperacions.getNivellCriticitat()));
		if (dadesOperacions.getRepeticions() == null) {
			dadesAtributsRDTO.setRepeticions(Constants.DADES_ATRIBUTS_CARDINALITAT_N);
		} else if (dadesOperacions.getRepeticions().compareTo(BigDecimal.ONE) == NumberUtils.INTEGER_ZERO.intValue()) {
			dadesAtributsRDTO.setRepeticions(NumberUtils.INTEGER_ONE.toString());
		} else {
			dadesAtributsRDTO.setRepeticions(dadesOperacions.getRepeticions().toString());
		}
		if (CollectionUtils.isNotEmpty(dadesOperacions.getItemsList())) {
			ArrayList<DadesAtributsValorsLlistaRDTO> dadesAtributsValorsLlistaRDTOList = new ArrayList<DadesAtributsValorsLlistaRDTO>();
			DadesAtributsValorsLlistaRDTO dadesAtributsValorsLlistaRDTO = null;
			for (Items items : dadesOperacions.getItemsList()) {
				dadesAtributsValorsLlistaRDTO = new DadesAtributsValorsLlistaRDTO();
				dadesAtributsValorsLlistaRDTO.setCodi((items.getItemId() != null) ? String.valueOf(items.getItemId()) : null);
				dadesAtributsValorsLlistaRDTO.setValor(items.getItemDescripcio());
				dadesAtributsValorsLlistaRDTO.setValorCastella(items.getItemDescripcioCastella());
				dadesAtributsValorsLlistaRDTO.setOrdre((items.getItemOrdre() != null) ? String.valueOf(items.getItemOrdre()) : null);
				dadesAtributsValorsLlistaRDTOList.add(dadesAtributsValorsLlistaRDTO);
			}
			Collections.sort(dadesAtributsValorsLlistaRDTOList);
			dadesAtributsRDTO.setValorsLlista(dadesAtributsValorsLlistaRDTOList);
		}
		if (esTramitOvt(dadesOperacions, TramitOvtApiParamValue.SOL)
		        && esObligatoriPerEstat(dadesOperacions, expedientEstatTramitadorApiParamValueTranslator)) {
			DadesOperacionsValidacio dadesOperacionsValidacio = new DadesOperacionsValidacio();
			dadesOperacionsValidacio.setTipusValidacio(TipusValidacioApiParamValue.OBLIGATORI.getInternalValue());
			if (dadesOperacions.getDadesOperacionsValidacio() == null) {
				dadesOperacions.setDadesOperacionsValidacio(new ArrayList<DadesOperacionsValidacio>());
			}
			dadesOperacions.getDadesOperacionsValidacio().add(NumberUtils.INTEGER_ZERO, dadesOperacionsValidacio);
		}
		if (CollectionUtils.isNotEmpty(dadesOperacions.getDadesOperacionsValidacio())) {
			ArrayList<DadesAtributsValidacionsRDTO> dadesAtributsValidacionsRDTOList = new ArrayList<DadesAtributsValidacionsRDTO>();
			DadesAtributsValidacionsRDTO dadesAtributsValidacionsRDTO = null;
			for (DadesOperacionsValidacio dadesOperacionsValidacio : dadesOperacions.getDadesOperacionsValidacio()) {
				dadesAtributsValidacionsRDTO = new DadesAtributsValidacionsRDTO();
				dadesAtributsValidacionsRDTO.setTipus(tipusValidacioApiParamValueTranslator
				        .getApiParamValueByInternalValue(dadesOperacionsValidacio.getTipusValidacio()));
				if (CollectionUtils.isNotEmpty(dadesOperacionsValidacio.getDadesOperacionsValidValors())) {
					ArrayList<DadesAtributsValorsValidacionsRDTO> dadesAtributsValorsValidacionsRDTOList = new ArrayList<DadesAtributsValorsValidacionsRDTO>();
					DadesAtributsValorsValidacionsRDTO dadesAtributsValorsValidacionsRDTO = null;
					for (DadesOperValidVal dadesOperValidVal : dadesOperacionsValidacio.getDadesOperacionsValidValors()) {
						dadesAtributsValorsValidacionsRDTO = new DadesAtributsValorsValidacionsRDTO();
						dadesAtributsValorsValidacionsRDTO.setValor(dadesOperValidVal.getValor());
						dadesAtributsValorsValidacionsRDTO
						        .setOrdre((dadesOperValidVal.getOrdre() != null) ? String.valueOf(dadesOperValidVal.getOrdre()) : null);
						dadesAtributsValorsValidacionsRDTOList.add(dadesAtributsValorsValidacionsRDTO);
					}
					Collections.sort(dadesAtributsValorsValidacionsRDTOList);
					dadesAtributsValidacionsRDTO.setValorsValidacions(dadesAtributsValorsValidacionsRDTOList);
				}
				dadesAtributsValidacionsRDTOList.add(dadesAtributsValidacionsRDTO);
			}
			dadesAtributsRDTO.setValidacions(dadesAtributsValidacionsRDTOList);
		}
		dadesAtributsRDTO.setUrlOrigen(dadesOperacions.getUrlOrigen());
		return dadesAtributsRDTO;
	}

	/**
	 * Es tramit ovt.
	 *
	 * @param dadesOperacions
	 *            the dades operacions
	 * @param tramitOvtApiParamValue
	 *            the tramit ovt api param value
	 * @return true, if successful
	 */
	private static boolean esTramitOvt(DadesOperacions dadesOperacions, TramitOvtApiParamValue tramitOvtApiParamValue) {
		if (CollectionUtils.isNotEmpty(dadesOperacions.getDadesOperTramitsOvtList())) {
			for (DadesOperTramitsOvt dadesOperTramitsOvt : dadesOperacions.getDadesOperTramitsOvtList()) {
				if (dadesOperTramitsOvt.getTramitOvtIdext()
				        .compareTo(tramitOvtApiParamValue.getInternalValue()) == NumberUtils.INTEGER_ZERO) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Es obligatori per estat.
	 *
	 * @param dadesOperacions
	 *            the dades operacions
	 * @param expedientEstatTramitadorApiParamValueTranslator
	 *            the expedient estat tramitador api param value translator
	 * @return the boolean
	 */
	private static Boolean esObligatoriPerEstat(DadesOperacions dadesOperacions,
	        BaseApiParamValueTranslator expedientEstatTramitadorApiParamValueTranslator) {
		if (CollectionUtils.isNotEmpty(dadesOperacions.getDadesoperEstatsExpList())) {
			for (DadesoperEstatsExp dadesoperEstatsExp : dadesOperacions.getDadesoperEstatsExpList()) {
				if (expedientEstatTramitadorApiParamValueTranslator.getApiParamValueByInternalValue(dadesoperEstatsExp.getEstatExpIdext())
				        .equals(EstatTramitadorApiParamValue.SOL_LICITUD_EN_REVISIO.getApiParamValue())) {
					return Boolean.TRUE;
				}
			}
		}
		return Boolean.FALSE;
	}

	/**
	 * Builds the documents requerits RDTO expedient.
	 *
	 * @param confDocEntradaRequeritRDTOList
	 *            the conf doc entrada requerit RDTO list
	 * @param booleanApiParamValueTranslator
	 *            the boolean api param value translator
	 * @param suportConfeccioApiParamValueTranslator
	 *            the suport confeccio api param value translator
	 * @param expedientEstatTramitadorApiParamValueTranslator
	 *            the expedient estat tramitador api param value translator
	 * @return the array list
	 */
	public static ArrayList<ConfiguracioDocumentacioRequeridaConsultaRDTO> buildDocumentsRequeritsRDTOExpedient(
	        List<ConfDocEntradaRequeritRDTO> confDocEntradaRequeritRDTOList, BooleanApiParamValueTranslator booleanApiParamValueTranslator,
	        BaseApiParamValueTranslator suportConfeccioApiParamValueTranslator,
	        BaseApiParamValueTranslator expedientEstatTramitadorApiParamValueTranslator) {
		ArrayList<ConfiguracioDocumentacioRequeridaConsultaRDTO> configuracioDocumentacioRequeridaConsultaRDTOList = null;

		if (CollectionUtils.isNotEmpty(confDocEntradaRequeritRDTOList)) {
			configuracioDocumentacioRequeridaConsultaRDTOList = new ArrayList<ConfiguracioDocumentacioRequeridaConsultaRDTO>();
			ConfiguracioDocumentacioRequeridaConsultaRDTO configuracioDocumentacioRequeridaConsultaRDTO = null;

			for (ConfDocEntradaRequeritRDTO confDocEntradaRequeritRDTO : confDocEntradaRequeritRDTOList) {
				configuracioDocumentacioRequeridaConsultaRDTO = new ConfiguracioDocumentacioRequeridaConsultaRDTO();
				configuracioDocumentacioRequeridaConsultaRDTO
				        .setCodi((confDocEntradaRequeritRDTO.getUniqueId() != null) ? confDocEntradaRequeritRDTO.getUniqueId() : null);
				configuracioDocumentacioRequeridaConsultaRDTO.setDescripcio(confDocEntradaRequeritRDTO.getNom());
				configuracioDocumentacioRequeridaConsultaRDTO.setDescripcioCastella(confDocEntradaRequeritRDTO.getNomCastella());
				configuracioDocumentacioRequeridaConsultaRDTO.setDescripcioAmpliada(confDocEntradaRequeritRDTO.getDescripcioAmpliada());
				configuracioDocumentacioRequeridaConsultaRDTO.setSuportConfeccio(suportConfeccioApiParamValueTranslator
				        .getApiParamValueByInternalValue(confDocEntradaRequeritRDTO.getSuportConfeccio()));
				configuracioDocumentacioRequeridaConsultaRDTO.setSuportEnllac(confDocEntradaRequeritRDTO.getSuportEnllac());
				configuracioDocumentacioRequeridaConsultaRDTOList.add(configuracioDocumentacioRequeridaConsultaRDTO);
			}
		}

		return configuracioDocumentacioRequeridaConsultaRDTOList;
	}

	/**
	 * Builds the documents aportats consulta RDTO list expedient.
	 *
	 * @param docsEntradaRDTOList
	 *            the docs entrada RDTO list
	 * @param tramitOvtApiParamValueTranslator
	 *            the tramit ovt api param value translator
	 * @param revisioApiParamValueTranslator
	 *            the revisio api param value translator
	 * @param tipusPersonaApiParamValueTranslator
	 *            the tipus persona api param value translator
	 * @param tipusDocumentIdentitatApiParamValueTranslator
	 *            the tipus document identitat api param value translator
	 * @param tipusSexeApiParamValueTranslator
	 *            the tipus sexe api param value translator
	 * @param origenApiParamValueTranslator
	 *            the origen api param value translator
	 * @return the array list
	 */
	public static ArrayList<DocumentAportatConsultaRDTO> buildDocumentsAportatsConsultaRDTOListExpedient(
	        List<DocsEntradaRDTO> docsEntradaRDTOList, BaseApiParamValueTranslator tramitOvtApiParamValueTranslator,
	        BaseApiParamValueTranslator revisioApiParamValueTranslator, BaseApiParamValueTranslator tipusPersonaApiParamValueTranslator,
	        BaseApiParamValueTranslator tipusDocumentIdentitatApiParamValueTranslator,
	        BaseApiParamValueTranslator tipusSexeApiParamValueTranslator, BaseApiParamValueTranslator origenApiParamValueTranslator) {
		ArrayList<DocumentAportatConsultaRDTO> documentAportatConsultaRDTOList = null;
		DocumentAportatConsultaRDTO documentAportatConsultaRDTO = null;
		ConfiguracioDocumentacioRDTO configuracioDocumentacioRDTO = null;
		RegistreRDTO registreRDTO = null;
		TramitsOvtRDTO tramitsOvtRDTO = null;
		if (CollectionUtils.isNotEmpty(docsEntradaRDTOList)) {
			DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(Constants.DATE_TIME_PATTERN);
			documentAportatConsultaRDTOList = new ArrayList<DocumentAportatConsultaRDTO>();
			for (DocsEntradaRDTO docsEntradaRDTO : docsEntradaRDTOList) {
				documentAportatConsultaRDTO = new DocumentAportatConsultaRDTO();
				documentAportatConsultaRDTO.setId(docsEntradaRDTO.getId());
				documentAportatConsultaRDTO.setIdGestorDocumental(docsEntradaRDTO.getMigracioIdOrigen());
				documentAportatConsultaRDTO.setNom(docsEntradaRDTO.getDocsFisicsNom());
				documentAportatConsultaRDTO.setDataPresentacio((docsEntradaRDTO.getDataPresentacio() != null)
				        ? dateTimeFormatter.print(docsEntradaRDTO.getDataPresentacio()) : null);
				documentAportatConsultaRDTO.setDataCreacio(
				        (docsEntradaRDTO.getDataCreacio() != null) ? dateTimeFormatter.print(docsEntradaRDTO.getDataCreacio()) : null);
				documentAportatConsultaRDTO
				        .setRevisio(revisioApiParamValueTranslator.getApiParamValueByInternalValue(docsEntradaRDTO.getRevisio()));
				documentAportatConsultaRDTO
				        .setOrigen(origenApiParamValueTranslator.getApiParamValueByInternalValue(docsEntradaRDTO.getOrigen()));
				configuracioDocumentacioRDTO = new ConfiguracioDocumentacioRDTO();
				configuracioDocumentacioRDTO.setCodi((docsEntradaRDTO.getConfiguracioDocsEntrada().getUniqueId() != null)
				        ? String.valueOf(docsEntradaRDTO.getConfiguracioDocsEntrada().getUniqueId()) : null);
				configuracioDocumentacioRDTO.setDescripcio(docsEntradaRDTO.getConfiguracioDocsEntradaNom());
				configuracioDocumentacioRDTO.setDescripcioCastella(docsEntradaRDTO.getConfiguracioDocsEntradaNomCastella());
				configuracioDocumentacioRDTO.setCodiNti(docsEntradaRDTO.getConfiguracioDocsEntrada().getCodiNti());
				documentAportatConsultaRDTO.setConfiguracioDocumentacio(configuracioDocumentacioRDTO);
				if (docsEntradaRDTO.getRegistreAssentament() != null) {
					registreRDTO = new RegistreRDTO();
					registreRDTO.setNumRegistre(docsEntradaRDTO.getRegistreAssentament().getCodi());
					registreRDTO.setDataRegistre((docsEntradaRDTO.getRegistreAssentament().getDataRegistre() != null)
					        ? dateTimeFormatter.print(docsEntradaRDTO.getRegistreAssentament().getDataRegistre()) : null);
					registreRDTO.setPersona(buildPersonesRDTOExpedient(docsEntradaRDTO.getRegistreAssentament().getPersones(),
					        tipusPersonaApiParamValueTranslator, tipusDocumentIdentitatApiParamValueTranslator,
					        tipusSexeApiParamValueTranslator));
					documentAportatConsultaRDTO.setRegistre(registreRDTO);
				}
				if (docsEntradaRDTO.getTramitOvtIdext() != null) {
					tramitsOvtRDTO = new TramitsOvtRDTO();
					tramitsOvtRDTO
					        .setCodi(tramitOvtApiParamValueTranslator.getApiParamValueByInternalValue(docsEntradaRDTO.getTramitOvtIdext()));
					// La descripción se seteará con la información obtenida del
					// servicio de trámites
					documentAportatConsultaRDTO.setTramit(tramitsOvtRDTO);
				}
				documentAportatConsultaRDTO.setHash(docsEntradaRDTO.getHash());
				documentAportatConsultaRDTO.setCodiCSV(docsEntradaRDTO.getCsv());
				documentAportatConsultaRDTOList.add(documentAportatConsultaRDTO);
			}
		}
		return documentAportatConsultaRDTOList;
	}

	/**
	 * Builds the documents aportats accio RDTO list expedient.
	 *
	 * @param docsEntradaRDTOList
	 *            the docs entrada RDTO list
	 * @param origenApiParamValueTranslator
	 *            the origen api param value translator
	 * @param revisioApiParamValueTranslator
	 *            the revisio api param value translator
	 * @return the array list
	 */
	public static ArrayList<DocumentAportatAccioRDTO> buildDocumentsAportatsAccioRDTOListExpedient(
	        List<DocsEntradaRDTO> docsEntradaRDTOList, BaseApiParamValueTranslator origenApiParamValueTranslator,
	        BaseApiParamValueTranslator revisioApiParamValueTranslator) {
		ArrayList<DocumentAportatAccioRDTO> documentAportatAccioRDTOList = null;
		if (CollectionUtils.isNotEmpty(docsEntradaRDTOList)) {
			documentAportatAccioRDTOList = new ArrayList<DocumentAportatAccioRDTO>();
			for (DocsEntradaRDTO docsEntradaRDTO : docsEntradaRDTOList) {
				documentAportatAccioRDTOList.add(buildDocumentsAportatsAccioRDTOExpedient(docsEntradaRDTO, origenApiParamValueTranslator,
				        revisioApiParamValueTranslator));
			}
		}
		return documentAportatAccioRDTOList;
	}

	/**
	 * Builds the documents digitalitzat accio RDTO list expedient.
	 *
	 * @param docsEntradaRDTOList
	 *            the docs entrada RDTO list
	 * @param origenApiParamValueTranslator
	 *            the origen api param value translator
	 * @param revisioApiParamValueTranslator
	 *            the revisio api param value translator
	 * @return the array list
	 */
	public static ArrayList<DocumentDigitalitzarAccioRDTO> buildDocumentsDigitalitzatAccioRDTOListExpedient(
	        List<DocsEntradaRDTO> docsEntradaRDTOList, BaseApiParamValueTranslator origenApiParamValueTranslator,
	        BaseApiParamValueTranslator revisioApiParamValueTranslator) {
		ArrayList<DocumentDigitalitzarAccioRDTO> documentDigitalitzarAccioRDTOList = null;
		if (CollectionUtils.isNotEmpty(docsEntradaRDTOList)) {
			documentDigitalitzarAccioRDTOList = new ArrayList<DocumentDigitalitzarAccioRDTO>();
			for (DocsEntradaRDTO docsEntradaRDTO : docsEntradaRDTOList) {
				documentDigitalitzarAccioRDTOList.add(buildDocumentsDigitalitzatAccioRDTOExpedient(docsEntradaRDTO,
				        origenApiParamValueTranslator, revisioApiParamValueTranslator));
			}
		}
		return documentDigitalitzarAccioRDTOList;
	}

	/**
	 * Builds the documents digitalitzat accio RDTO expedient.
	 *
	 * @param docsEntradaRDTO
	 *            the docs entrada RDTO
	 * @param origenApiParamValueTranslator
	 *            the origen api param value translator
	 * @param revisioApiParamValueTranslator
	 *            the revisio api param value translator
	 * @return the document digitalitzar accio RDTO
	 */
	private static DocumentDigitalitzarAccioRDTO buildDocumentsDigitalitzatAccioRDTOExpedient(DocsEntradaRDTO docsEntradaRDTO,
	        BaseApiParamValueTranslator origenApiParamValueTranslator, BaseApiParamValueTranslator revisioApiParamValueTranslator) {
		DocumentDigitalitzarAccioRDTO documentDigitalitzarAccioRDTO = null;

		if (docsEntradaRDTO != null) {
			DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(Constants.DATE_TIME_PATTERN);
			documentDigitalitzarAccioRDTO = new DocumentDigitalitzarAccioRDTO();
			documentDigitalitzarAccioRDTO.setId(docsEntradaRDTO.getId());
			if (docsEntradaRDTO.getDocsFisics() != null) {
				documentDigitalitzarAccioRDTO.setNom(docsEntradaRDTO.getDocsFisics().getNom());
			}
			if (docsEntradaRDTO.getConfiguracioDocsEntrada() != null) {
				ConfiguracioDocumentacioRDTO configuracioDocumentacioRDTO = buildConfiguracioDocumentacioRDTO(docsEntradaRDTO);
				documentDigitalitzarAccioRDTO.setConfiguracioDocumentacio(configuracioDocumentacioRDTO);
			}
			documentDigitalitzarAccioRDTO
			        .setOrigen(origenApiParamValueTranslator.getApiParamValueByInternalValue(docsEntradaRDTO.getOrigen()));
			documentDigitalitzarAccioRDTO
			        .setRevisio(revisioApiParamValueTranslator.getApiParamValueByInternalValue(docsEntradaRDTO.getRevisio()));
			documentDigitalitzarAccioRDTO.setDataPresentacio(
			        (docsEntradaRDTO.getDataPresentacio() != null) ? dateTimeFormatter.print(docsEntradaRDTO.getDataPresentacio()) : null);
			documentDigitalitzarAccioRDTO.setDataModificacio((docsEntradaRDTO.getDataUltimaModificacio() != null)
			        ? dateTimeFormatter.print(docsEntradaRDTO.getDataUltimaModificacio()) : null);
			documentDigitalitzarAccioRDTO.setUrlDigitalitzacio(docsEntradaRDTO.getUrlDigitalitzacio());
		}

		return documentDigitalitzarAccioRDTO;
	}

	/**
	 * Builds the documents aportats accio RDTO expedient.
	 *
	 * @param docsEntradaRDTO
	 *            the docs entrada RDTO
	 * @param origenApiParamValueTranslator
	 *            the origen api param value translator
	 * @param revisioApiParamValueTranslator
	 *            the revisio api param value translator
	 * @return the document aportat accio RDTO
	 */
	public static DocumentAportatAccioRDTO buildDocumentsAportatsAccioRDTOExpedient(DocsEntradaRDTO docsEntradaRDTO,
	        BaseApiParamValueTranslator origenApiParamValueTranslator, BaseApiParamValueTranslator revisioApiParamValueTranslator) {
		DocumentAportatAccioRDTO documentAportatAccioRDTO = null;

		if (docsEntradaRDTO != null) {
			DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(Constants.DATE_TIME_PATTERN);
			documentAportatAccioRDTO = new DocumentAportatAccioRDTO();
			documentAportatAccioRDTO.setId(docsEntradaRDTO.getId());
			documentAportatAccioRDTO.setIdGestorDocumental(docsEntradaRDTO.getMigracioIdOrigen());
			if (docsEntradaRDTO.getDocsFisics() != null) {
				documentAportatAccioRDTO.setNom(docsEntradaRDTO.getDocsFisics().getNom());
			}
			if (docsEntradaRDTO.getConfiguracioDocsEntrada() != null) {
				ConfiguracioDocumentacioRDTO configuracioDocumentacioRDTO = buildConfiguracioDocumentacioRDTO(docsEntradaRDTO);
				documentAportatAccioRDTO.setConfiguracioDocumentacio(configuracioDocumentacioRDTO);
			}
			documentAportatAccioRDTO.setOrigen(origenApiParamValueTranslator.getApiParamValueByInternalValue(docsEntradaRDTO.getOrigen()));
			documentAportatAccioRDTO
			        .setRevisio(revisioApiParamValueTranslator.getApiParamValueByInternalValue(docsEntradaRDTO.getRevisio()));
			documentAportatAccioRDTO.setDataPresentacio(
			        (docsEntradaRDTO.getDataPresentacio() != null) ? dateTimeFormatter.print(docsEntradaRDTO.getDataPresentacio()) : null);
			documentAportatAccioRDTO.setDataModificacio((docsEntradaRDTO.getDataUltimaModificacio() != null)
			        ? dateTimeFormatter.print(docsEntradaRDTO.getDataUltimaModificacio()) : null);
			documentAportatAccioRDTO.setHash(docsEntradaRDTO.getHash());
			documentAportatAccioRDTO.setCodiCSV(docsEntradaRDTO.getCsv());
		}

		return documentAportatAccioRDTO;
	}

	/**
	 * Builds the document incorporat nou accio RDTO expedient.
	 *
	 * @param docsEntradaRDTO
	 *            the docs entrada RDTO
	 * @param origenApiParamValueTranslator
	 *            the origen api param value translator
	 * @param revisioApiParamValueTranslator
	 *            the revisio api param value translator
	 * @return the document incorporat nou accio RDTO
	 */
	public static DocumentIncorporatNouAccioRDTO buildDocumentIncorporatNouAccioRDTOExpedient(DocsEntradaRDTO docsEntradaRDTO,
	        BaseApiParamValueTranslator origenApiParamValueTranslator, BaseApiParamValueTranslator revisioApiParamValueTranslator) {
		DocumentIncorporatNouAccioRDTO documentIncorporatNouAccioRDTO = null;

		if (docsEntradaRDTO != null) {
			DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(Constants.DATE_TIME_PATTERN);
			documentIncorporatNouAccioRDTO = new DocumentIncorporatNouAccioRDTO();
			documentIncorporatNouAccioRDTO.setId(docsEntradaRDTO.getId());
			if (docsEntradaRDTO.getDocsFisics() != null) {
				documentIncorporatNouAccioRDTO.setNom(docsEntradaRDTO.getDocsFisics().getNom());
			}
			documentIncorporatNouAccioRDTO.setConfiguracio(ConfiguracioApiParamValue.APORTADA.getApiParamValue());
			if (docsEntradaRDTO.getConfiguracioDocsEntrada() != null) {
				ConfiguracioDocumentacioRDTO configuracioDocumentacioRDTO = buildConfiguracioDocumentacioRDTO(docsEntradaRDTO);
				documentIncorporatNouAccioRDTO.setConfiguracioDocumentacio(configuracioDocumentacioRDTO);
			}
			documentIncorporatNouAccioRDTO
			        .setOrigen(origenApiParamValueTranslator.getApiParamValueByInternalValue(docsEntradaRDTO.getOrigen()));
			documentIncorporatNouAccioRDTO
			        .setRevisio(revisioApiParamValueTranslator.getApiParamValueByInternalValue(docsEntradaRDTO.getRevisio()));
			documentIncorporatNouAccioRDTO.setDataCreacio(
			        (docsEntradaRDTO.getDataCreacio() != null) ? dateTimeFormatter.print(docsEntradaRDTO.getDataCreacio()) : null);
		}

		return documentIncorporatNouAccioRDTO;
	}

	/**
	 * Builds the document incorporat nou accio RDTO expedient.
	 *
	 * @param docsTramitacioRDTO
	 *            the docs tramitacio RDTO
	 * @param origenApiParamValueTranslator
	 *            the origen api param value translator
	 * @return the document incorporat nou accio RDTO
	 */
	public static DocumentIncorporatNouAccioRDTO buildDocumentIncorporatNouAccioRDTOExpedient(DocsTramitacioRDTO docsTramitacioRDTO,
	        BaseApiParamValueTranslator origenApiParamValueTranslator) {
		DocumentIncorporatNouAccioRDTO documentIncorporatNouAccioRDTO = null;

		if (docsTramitacioRDTO != null) {
			DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(Constants.DATE_TIME_PATTERN);
			documentIncorporatNouAccioRDTO = new DocumentIncorporatNouAccioRDTO();
			documentIncorporatNouAccioRDTO.setId(docsTramitacioRDTO.getId());
			if (docsTramitacioRDTO.getDocsFisics() != null) {
				documentIncorporatNouAccioRDTO.setNom(docsTramitacioRDTO.getDocsFisics().getNom());
			}
			documentIncorporatNouAccioRDTO.setConfiguracio(ConfiguracioApiParamValue.GENERADA.getApiParamValue());
			if (docsTramitacioRDTO.getConfiguracioDocsTramitacio() != null) {
				ConfiguracioDocumentacioRDTO configuracioDocumentacioRDTO = buildConfiguracioDocumentacioRDTO(docsTramitacioRDTO);
				documentIncorporatNouAccioRDTO.setConfiguracioDocumentacio(configuracioDocumentacioRDTO);
			}
			documentIncorporatNouAccioRDTO
			        .setOrigen(origenApiParamValueTranslator.getApiParamValueByInternalValue(docsTramitacioRDTO.getOrigen()));
			documentIncorporatNouAccioRDTO.setDataCreacio(
			        (docsTramitacioRDTO.getDataCreacio() != null) ? dateTimeFormatter.print(docsTramitacioRDTO.getDataCreacio()) : null);
		}

		return documentIncorporatNouAccioRDTO;
	}

	/**
	 * Builds the documents generats consulta RDTO list expedient.
	 *
	 * @param docsTramitacioRDTOList
	 *            the docs tramitacio RDTO list
	 * @param origenApiParamValueTranslator
	 *            the origen api param value translator
	 * @return the array list
	 */
	public static ArrayList<DocumentGeneratConsultaRDTO> buildDocumentsGeneratsConsultaRDTOListExpedient(
	        List<DocsTramitacioRDTO> docsTramitacioRDTOList, BaseApiParamValueTranslator origenApiParamValueTranslator) {
		ArrayList<DocumentGeneratConsultaRDTO> documentGeneratConsultaRDTOList = null;
		DocumentGeneratConsultaRDTO documentGeneratConsultaRDTO = null;
		ConfiguracioDocumentacioRDTO configuracioDocumentacioRDTO = null;
		RegistreRDTO registreRDTO = null;
		if (CollectionUtils.isNotEmpty(docsTramitacioRDTOList)) {
			DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(Constants.DATE_TIME_PATTERN);
			documentGeneratConsultaRDTOList = new ArrayList<DocumentGeneratConsultaRDTO>();
			for (DocsTramitacioRDTO docsTramitacioRDTO : docsTramitacioRDTOList) {
				documentGeneratConsultaRDTO = new DocumentGeneratConsultaRDTO();
				documentGeneratConsultaRDTO.setId(docsTramitacioRDTO.getId());
				documentGeneratConsultaRDTO.setIdGestorDocumental(docsTramitacioRDTO.getMigracioIdOrigen());
				documentGeneratConsultaRDTO.setNom(docsTramitacioRDTO.getDocsFisicsNom());
				documentGeneratConsultaRDTO.setDataComunicat((docsTramitacioRDTO.getDataComunicat() != null)
				        ? dateTimeFormatter.print(docsTramitacioRDTO.getDataComunicat()) : null);
				documentGeneratConsultaRDTO.setDataCreacio((docsTramitacioRDTO.getDataCreacio() != null)
				        ? dateTimeFormatter.print(docsTramitacioRDTO.getDataCreacio()) : null);
				documentGeneratConsultaRDTO
				        .setOrigen(origenApiParamValueTranslator.getApiParamValueByInternalValue(docsTramitacioRDTO.getOrigen()));
				configuracioDocumentacioRDTO = new ConfiguracioDocumentacioRDTO();
				configuracioDocumentacioRDTO.setCodi((docsTramitacioRDTO.getConfiguracioDocsTramitacio().getUniqueId() != null)
				        ? String.valueOf(docsTramitacioRDTO.getConfiguracioDocsTramitacio().getUniqueId()) : null);
				configuracioDocumentacioRDTO.setDescripcio(docsTramitacioRDTO.getConfiguracioDocsTramitacioNom());
				configuracioDocumentacioRDTO.setDescripcioCastella(docsTramitacioRDTO.getConfiguracioDocsTramitacioNomCastella());
				configuracioDocumentacioRDTO.setCodiNti(docsTramitacioRDTO.getConfiguracioDocsTramitacio().getCodiNti());
				documentGeneratConsultaRDTO.setConfiguracioDocumentacio(configuracioDocumentacioRDTO);

				if (docsTramitacioRDTO.getNotificacions() != null && docsTramitacioRDTO.getNotificacions().getNumRegistre() != null) {
					registreRDTO = new RegistreRDTO();
					registreRDTO.setNumRegistre(docsTramitacioRDTO.getNotificacions().getNumRegistre());
					registreRDTO.setDataRegistre((docsTramitacioRDTO.getNotificacions().getDataRegistre() != null)
					        ? dateTimeFormatter.print(docsTramitacioRDTO.getNotificacions().getDataRegistre()) : null);

					documentGeneratConsultaRDTO.setRegistre(registreRDTO);
				}

				documentGeneratConsultaRDTO.setHash(docsTramitacioRDTO.getHash());
				documentGeneratConsultaRDTO.setCodiCSV(docsTramitacioRDTO.getCsv());
				documentGeneratConsultaRDTOList.add(documentGeneratConsultaRDTO);
			}
		}
		return documentGeneratConsultaRDTOList;
	}

	/**
	 * Builds the requeriment preparat accio RDTO expedient.
	 *
	 * @param docsTramitacioRDTO
	 *            the docs tramitacio RDTO
	 * @param origenApiParamValueTranslator
	 *            the origen api param value translator
	 * @return the requeriment preparat accio RDTO
	 */
	public static RequerimentPreparatAccioRDTO buildRequerimentPreparatAccioRDTOExpedient(DocsTramitacioRDTO docsTramitacioRDTO,
	        BaseApiParamValueTranslator origenApiParamValueTranslator) {
		RequerimentPreparatAccioRDTO requerimentPreparatAccioRDTO = null;

		if (docsTramitacioRDTO != null) {
			DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(Constants.DATE_TIME_PATTERN);
			requerimentPreparatAccioRDTO = new RequerimentPreparatAccioRDTO();
			requerimentPreparatAccioRDTO.setId(docsTramitacioRDTO.getId());
			if (docsTramitacioRDTO.getDocsFisics() != null) {
				requerimentPreparatAccioRDTO.setNom(docsTramitacioRDTO.getDocsFisics().getNom());
			}
			if (docsTramitacioRDTO.getConfiguracioDocsTramitacio() != null) {
				ConfiguracioDocumentacioRDTO configuracioDocumentacioRDTO = new ConfiguracioDocumentacioRDTO();
				configuracioDocumentacioRDTO.setCodi(docsTramitacioRDTO.getConfiguracioDocsTramitacio().getUniqueId() != null
				        ? String.valueOf(docsTramitacioRDTO.getConfiguracioDocsTramitacio().getUniqueId()) : null);
				configuracioDocumentacioRDTO.setDescripcio(docsTramitacioRDTO.getConfiguracioDocsTramitacio().getNom());
				configuracioDocumentacioRDTO.setDescripcioCastella(docsTramitacioRDTO.getConfiguracioDocsTramitacio().getNomCastella());
				requerimentPreparatAccioRDTO.setConfiguracioDocumentacio(configuracioDocumentacioRDTO);
			}
			requerimentPreparatAccioRDTO
			        .setOrigen(origenApiParamValueTranslator.getApiParamValueByInternalValue(docsTramitacioRDTO.getOrigen()));
			requerimentPreparatAccioRDTO.setDataCreacio(
			        (docsTramitacioRDTO.getDataCreacio() != null) ? dateTimeFormatter.print(docsTramitacioRDTO.getDataCreacio()) : null);
		}
		return requerimentPreparatAccioRDTO;
	}

	/**
	 * Builds the document completat accio RDTO expedient.
	 *
	 * @param docsEntradaRDTO
	 *            the docs entrada RDTO
	 * @return the document completat accio RDTO
	 */
	public static DocumentCompletatAccioRDTO buildDocumentCompletatAccioRDTOExpedient(DocsEntradaRDTO docsEntradaRDTO) {
		DocumentCompletatAccioRDTO documentCompletatAccioRDTO = null;

		if (docsEntradaRDTO != null) {
			DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(Constants.DATE_TIME_PATTERN);
			documentCompletatAccioRDTO = new DocumentCompletatAccioRDTO();
			documentCompletatAccioRDTO.setId(docsEntradaRDTO.getId());
			documentCompletatAccioRDTO.setConfiguracio(ConfiguracioApiParamValue.APORTADA.getApiParamValue());
			if (docsEntradaRDTO.getConfiguracioDocsEntrada() != null) {
				ConfiguracioDocumentacioRDTO configuracioDocumentacioRDTO = buildConfiguracioDocumentacioRDTO(docsEntradaRDTO);
				documentCompletatAccioRDTO.setConfiguracioDocumentacio(configuracioDocumentacioRDTO);
			}
			documentCompletatAccioRDTO.setDataCreacio(
			        (docsEntradaRDTO.getDataCreacio() != null) ? dateTimeFormatter.print(docsEntradaRDTO.getDataCreacio()) : null);
			documentCompletatAccioRDTO.setDataModificacio((docsEntradaRDTO.getDataUltimaModificacio() != null)
			        ? dateTimeFormatter.print(docsEntradaRDTO.getDataUltimaModificacio()) : null);
		}

		return documentCompletatAccioRDTO;
	}

	/**
	 * Builds the document completat accio RDTO expedient.
	 *
	 * @param docsTramitacioRDTO
	 *            the docs tramitacio RDTO
	 * @return the document completat accio RDTO
	 */
	public static DocumentCompletatAccioRDTO buildDocumentCompletatAccioRDTOExpedient(DocsTramitacioRDTO docsTramitacioRDTO) {
		DocumentCompletatAccioRDTO documentCompletatAccioRDTO = null;

		if (docsTramitacioRDTO != null) {
			DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(Constants.DATE_TIME_PATTERN);
			documentCompletatAccioRDTO = new DocumentCompletatAccioRDTO();
			documentCompletatAccioRDTO.setId(docsTramitacioRDTO.getId());
			documentCompletatAccioRDTO.setConfiguracio(ConfiguracioApiParamValue.APORTADA.getApiParamValue());
			if (docsTramitacioRDTO.getConfiguracioDocsTramitacio() != null) {
				ConfiguracioDocumentacioRDTO configuracioDocumentacioRDTO = buildConfiguracioDocumentacioRDTO(docsTramitacioRDTO);
				documentCompletatAccioRDTO.setConfiguracioDocumentacio(configuracioDocumentacioRDTO);
			}
			documentCompletatAccioRDTO.setDataCreacio(
			        (docsTramitacioRDTO.getDataCreacio() != null) ? dateTimeFormatter.print(docsTramitacioRDTO.getDataCreacio()) : null);
			documentCompletatAccioRDTO.setDataModificacio((docsTramitacioRDTO.getDataUltimaModificacio() != null)
			        ? dateTimeFormatter.print(docsTramitacioRDTO.getDataUltimaModificacio()) : null);
		}

		return documentCompletatAccioRDTO;
	}

	/**
	 * Builds the declaracio responsable presentada accio RDTO expedient.
	 *
	 * @param docsEntradaRDTO
	 *            the docs entrada RDTO
	 * @param origenApiParamValueTranslator
	 *            the origen api param value translator
	 * @return the declaracio responsable presentada accio RDTO
	 */
	public static DeclaracioResponsablePresentadaAccioRDTO buildDeclaracioResponsablePresentadaAccioRDTOExpedient(
	        DocsEntradaRDTO docsEntradaRDTO, BaseApiParamValueTranslator origenApiParamValueTranslator) {
		DeclaracioResponsablePresentadaAccioRDTO declaracioResponsablePresentadaAccioRDTO = null;

		if (docsEntradaRDTO != null) {
			DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(Constants.DATE_TIME_PATTERN);
			declaracioResponsablePresentadaAccioRDTO = new DeclaracioResponsablePresentadaAccioRDTO();
			declaracioResponsablePresentadaAccioRDTO.setId(docsEntradaRDTO.getId());
			if (docsEntradaRDTO.getConfiguracioDocsEntrada() != null) {
				ConfiguracioDocumentacioRDTO configuracioDocumentacioRDTO = buildConfiguracioDocumentacioRDTO(docsEntradaRDTO);
				declaracioResponsablePresentadaAccioRDTO.setConfiguracioDocumentacio(configuracioDocumentacioRDTO);
			}
			declaracioResponsablePresentadaAccioRDTO
			        .setOrigen(origenApiParamValueTranslator.getApiParamValueByInternalValue(docsEntradaRDTO.getOrigen()));
			declaracioResponsablePresentadaAccioRDTO.setDataCreacio(
			        (docsEntradaRDTO.getDataCreacio() != null) ? dateTimeFormatter.print(docsEntradaRDTO.getDataCreacio()) : null);
		}

		return declaracioResponsablePresentadaAccioRDTO;
	}

	/**
	 * Builds the codi expedient.
	 *
	 * @param codi
	 *            the codi
	 * @param idEstat
	 *            the id estat
	 * @return the string
	 */
	public static String buildCodiExpedient(String codi, BigDecimal idEstat) {
		// Formato en función del estado
		// Si el estado es En Preparació, <AAAA>_<ID_Específic sin ceros a la
		// izquierda>
		// En cualquier otro caso, <AAAA>_EXP_<ID_Específic sin ceros a la
		// izquierda>
		Pattern codiExpedientFormattedPattern = Pattern.compile(CODI_EXPEDIENT_FORMATTED_PATTERN);
		Matcher codiExpedientFormattedMatcher = codiExpedientFormattedPattern.matcher(codi);
		if (codiExpedientFormattedMatcher.matches()) {
			if (idEstat.compareTo(EstatTramitadorApiParamValue.EN_PREPARACIO.getInternalValue()) == NumberUtils.INTEGER_ZERO) {
				return String.format(CODI_EXPEDIENT_EN_PREPARACIO_FORMAT, codiExpedientFormattedMatcher.group(1),
				        codiExpedientFormattedMatcher.group(3));
			} else {
				return String.format(CODI_EXPEDIENT_ALTRES_ESTATS_FORMAT, codiExpedientFormattedMatcher.group(1),
				        codiExpedientFormattedMatcher.group(3));
			}
		} else {
			return codi;
		}
	}

	/**
	 * Builds the document digitalitzar accio RDTO.
	 *
	 * @param docsTramitacioRDTO
	 *            the docs tramitacio RDTO
	 * @return the document digitalitzar accio RDTO
	 */
	public static DocumentDigitalitzarAccioRDTO buildDocumentDigitalitzarAccioRDTO(DocsTramitacioRDTO docsTramitacioRDTO) {
		DocumentDigitalitzarAccioRDTO documentDigitalitzarAccioRDTO = null;

		if (docsTramitacioRDTO != null) {
			documentDigitalitzarAccioRDTO = new DocumentDigitalitzarAccioRDTO();
			documentDigitalitzarAccioRDTO.setId(docsTramitacioRDTO.getId());
			if (docsTramitacioRDTO.getConfiguracioDocsTramitacio() != null) {
				ConfiguracioDocumentacioRDTO configuracioDocumentacioRDTO = buildConfiguracioDocumentacioRDTO(docsTramitacioRDTO);
				documentDigitalitzarAccioRDTO.setConfiguracioDocumentacio(configuracioDocumentacioRDTO);
			}
			documentDigitalitzarAccioRDTO.setUrlDigitalitzacio(docsTramitacioRDTO.getUrlDigitalitzacio());
		}

		return documentDigitalitzarAccioRDTO;
	}

	/**
	 * Builds the document digitalitzar accio RDTO.
	 *
	 * @param docsEntradaRDTO
	 *            the docs entrada RDTO
	 * @param origenApiParamValueTranslator
	 *            the origen api param value translator
	 * @param revisioApiParamValueTranslator
	 *            the revisio api param value translator
	 * @return the document digitalitzar accio RDTO
	 */
	public static DocumentDigitalitzarAccioRDTO buildDocumentDigitalitzarAccioRDTO(DocsEntradaRDTO docsEntradaRDTO,
	        BaseApiParamValueTranslator origenApiParamValueTranslator, BaseApiParamValueTranslator revisioApiParamValueTranslator) {
		DocumentDigitalitzarAccioRDTO documentDigitalitzarAccioRDTO = null;

		if (docsEntradaRDTO != null) {
			documentDigitalitzarAccioRDTO = new DocumentDigitalitzarAccioRDTO();
			documentDigitalitzarAccioRDTO.setId(docsEntradaRDTO.getId());
			documentDigitalitzarAccioRDTO.setNom(docsEntradaRDTO.getDocsFisics().getNom());
			if (docsEntradaRDTO.getConfiguracioDocsEntrada() != null) {
				ConfiguracioDocumentacioRDTO configuracioDocumentacioRDTO = buildConfiguracioDocumentacioRDTO(docsEntradaRDTO);
				documentDigitalitzarAccioRDTO.setConfiguracioDocumentacio(configuracioDocumentacioRDTO);
			}
			documentDigitalitzarAccioRDTO.setUrlDigitalitzacio(docsEntradaRDTO.getUrlDigitalitzacio());
			documentDigitalitzarAccioRDTO
			        .setRevisio(revisioApiParamValueTranslator.getApiParamValueByInternalValue(docsEntradaRDTO.getRevisio()));
			documentDigitalitzarAccioRDTO
			        .setOrigen(origenApiParamValueTranslator.getApiParamValueByInternalValue(docsEntradaRDTO.getOrigen()));
		}

		return documentDigitalitzarAccioRDTO;
	}

	/**
	 * build the configuracio documentacio.
	 *
	 * @param docsEntradaRDTO
	 *            the docs entrada RDTO
	 * @return the configuracio documentacio RDTO
	 */
	private static ConfiguracioDocumentacioRDTO buildConfiguracioDocumentacioRDTO(DocsEntradaRDTO docsEntradaRDTO) {

		ConfiguracioDocumentacioRDTO configuracioDocumentacioRDTO = new ConfiguracioDocumentacioRDTO();
		configuracioDocumentacioRDTO.setCodi(docsEntradaRDTO.getConfiguracioDocsEntrada().getUniqueId() != null
		        ? String.valueOf(docsEntradaRDTO.getConfiguracioDocsEntrada().getUniqueId()) : null);
		configuracioDocumentacioRDTO.setDescripcio(docsEntradaRDTO.getConfiguracioDocsEntrada().getNom());
		configuracioDocumentacioRDTO.setDescripcioCastella(docsEntradaRDTO.getConfiguracioDocsEntrada().getNomCastella());
		configuracioDocumentacioRDTO.setCodiNti(docsEntradaRDTO.getConfiguracioDocsEntrada().getCodiNti());

		return configuracioDocumentacioRDTO;
	}

	/**
	 * build the configuracio documentacio.
	 *
	 * @param docsTramitacioRDTO
	 *            the docs tramitacio RDTO
	 * @return the configuracio documentacio RDTO
	 */
	private static ConfiguracioDocumentacioRDTO buildConfiguracioDocumentacioRDTO(DocsTramitacioRDTO docsTramitacioRDTO) {

		ConfiguracioDocumentacioRDTO configuracioDocumentacioRDTO = new ConfiguracioDocumentacioRDTO();
		configuracioDocumentacioRDTO.setCodi(docsTramitacioRDTO.getConfiguracioDocsTramitacio().getUniqueId() != null
		        ? String.valueOf(docsTramitacioRDTO.getConfiguracioDocsTramitacio().getUniqueId()) : null);
		configuracioDocumentacioRDTO.setDescripcio(docsTramitacioRDTO.getConfiguracioDocsTramitacio().getNom());
		configuracioDocumentacioRDTO.setDescripcioCastella(docsTramitacioRDTO.getConfiguracioDocsTramitacio().getNomCastella());
		configuracioDocumentacioRDTO.setCodiNti(docsTramitacioRDTO.getConfiguracioDocsTramitacio().getCodiNti());
		return configuracioDocumentacioRDTO;
	}

	/**
	 * Builds the sollicituds RDTO expedient.
	 *
	 * @param sollicitudsRDTO
	 *            the sollicituds RDTO
	 * @param tramitOvtApiParamValueTranslator
	 *            the tramit ovt api param value translator
	 * @return the sollicituds expedient RDTO
	 */
	public static SollicitudsExpedientRDTO buildSollicitudsRDTOExpedient(SollicitudsRDTO sollicitudsRDTO,
	        BaseApiParamValueTranslator tramitOvtApiParamValueTranslator) {
		if (sollicitudsRDTO == null) {
			return null;
		}
		SollicitudsExpedientRDTO sollicitudsExpedientRDTO = new SollicitudsExpedientRDTO();
		sollicitudsExpedientRDTO.setId(sollicitudsRDTO.getId());
		sollicitudsExpedientRDTO
		        .setTipus(tramitOvtApiParamValueTranslator.getApiParamValueByInternalValue(sollicitudsRDTO.getTramitOvtIdext()));
		sollicitudsExpedientRDTO.setEstat(ConverterHelper.getEstatSollicitudByIdRegistre(sollicitudsRDTO.getRegistre()));
		return sollicitudsExpedientRDTO;
	}

	/**
	 * Gets the estat sollicitud by id registre.
	 *
	 * @param idRegistre
	 *            the id registre
	 * @return the estat sollicitud by id registre
	 */
	public static String getEstatSollicitudByIdRegistre(BigDecimal idRegistre) {
		return (idRegistre == null) ? Constants.DESCRIPCIO_ESTAT_ESBORRANY : Constants.DESCRIPCIO_ESTAT_REGISTRAT;
	}

	/**
	 * Builds the document aportat consulta RDTO document.
	 *
	 * @param docsEntradaRDTO
	 *            the docs entrada RDTO
	 * @param tramitOvtApiParamValueTranslator
	 *            the tramit ovt api param value translator
	 * @param revisioApiParamValueTranslator
	 *            the revisio api param value translator
	 * @param tipusPersonaApiParamValueTranslator
	 *            the tipus persona api param value translator
	 * @param tipusDocumentIdentitatApiParamValueTranslator
	 *            the tipus document identitat api param value translator
	 * @param tipusSexeApiParamValueTranslator
	 *            the tipus sexe api param value translator
	 * @param origenApiParamValueTranslator
	 *            the origen api param value translator
	 * @return the document aportat consulta RDTO
	 */
	public static DocumentAportatConsultaRDTO buildDocumentAportatConsultaRDTODocument(DocsEntradaRDTO docsEntradaRDTO,
	        BaseApiParamValueTranslator tramitOvtApiParamValueTranslator, BaseApiParamValueTranslator revisioApiParamValueTranslator,
	        BaseApiParamValueTranslator tipusPersonaApiParamValueTranslator,
	        BaseApiParamValueTranslator tipusDocumentIdentitatApiParamValueTranslator,
	        BaseApiParamValueTranslator tipusSexeApiParamValueTranslator, BaseApiParamValueTranslator origenApiParamValueTranslator) {

		DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(Constants.DATE_TIME_PATTERN);

		ConfiguracioDocumentacioRDTO configuracioDocumentacioRDTO = null;
		RegistreRDTO registreRDTO = null;
		TramitsOvtRDTO tramitsOvtRDTO = null;
		DocumentAportatConsultaRDTO documentAportatConsultaRDTO = new DocumentAportatConsultaRDTO();

		documentAportatConsultaRDTO.setId(docsEntradaRDTO.getId());
		documentAportatConsultaRDTO.setIdGestorDocumental(docsEntradaRDTO.getMigracioIdOrigen());
		documentAportatConsultaRDTO.setNom(docsEntradaRDTO.getDocsFisicsNom());

		configuracioDocumentacioRDTO = new ConfiguracioDocumentacioRDTO();
		configuracioDocumentacioRDTO.setCodi((docsEntradaRDTO.getConfiguracioDocsEntrada().getUniqueId() != null)
		        ? String.valueOf(docsEntradaRDTO.getConfiguracioDocsEntrada().getUniqueId()) : null);
		configuracioDocumentacioRDTO.setDescripcio(docsEntradaRDTO.getConfiguracioDocsEntradaNom());
		configuracioDocumentacioRDTO.setDescripcioCastella(docsEntradaRDTO.getConfiguracioDocsEntradaNomCastella());
		configuracioDocumentacioRDTO.setCodiNti(docsEntradaRDTO.getConfiguracioDocsEntrada().getCodiNti());
		documentAportatConsultaRDTO.setConfiguracioDocumentacio(configuracioDocumentacioRDTO);

		documentAportatConsultaRDTO.setDataPresentacio(
		        (docsEntradaRDTO.getDataPresentacio() != null) ? dateTimeFormatter.print(docsEntradaRDTO.getDataPresentacio()) : null);

		if (docsEntradaRDTO.getRegistreAssentament() != null) {
			registreRDTO = new RegistreRDTO();
			registreRDTO.setNumRegistre(docsEntradaRDTO.getRegistreAssentament().getCodi());
			registreRDTO.setDataRegistre((docsEntradaRDTO.getRegistreAssentament().getDataRegistre() != null)
			        ? dateTimeFormatter.print(docsEntradaRDTO.getRegistreAssentament().getDataRegistre()) : null);
			registreRDTO.setPersona(buildPersonesRDTOExpedient(docsEntradaRDTO.getRegistreAssentament().getPersones(),
			        tipusPersonaApiParamValueTranslator, tipusDocumentIdentitatApiParamValueTranslator, tipusSexeApiParamValueTranslator));
			documentAportatConsultaRDTO.setRegistre(registreRDTO);
		}

		documentAportatConsultaRDTO
		        .setRevisio(revisioApiParamValueTranslator.getApiParamValueByInternalValue(docsEntradaRDTO.getRevisio()));
		documentAportatConsultaRDTO.setDataCreacio(
		        (docsEntradaRDTO.getDataCreacio() != null) ? dateTimeFormatter.print(docsEntradaRDTO.getDataCreacio()) : null);
		documentAportatConsultaRDTO.setOrigen(origenApiParamValueTranslator.getApiParamValueByInternalValue(docsEntradaRDTO.getOrigen()));
		documentAportatConsultaRDTO.setHash(docsEntradaRDTO.getHash());
		documentAportatConsultaRDTO.setCodiCSV(docsEntradaRDTO.getCsv());

		if (docsEntradaRDTO.getTramitOvtIdext() != null) {
			tramitsOvtRDTO = new TramitsOvtRDTO();
			tramitsOvtRDTO.setCodi(tramitOvtApiParamValueTranslator.getApiParamValueByInternalValue(docsEntradaRDTO.getTramitOvtIdext()));
			// La descripción se seteará con la información obtenida del
			// servicio de trámites
			documentAportatConsultaRDTO.setTramit(tramitsOvtRDTO);
		}
		return documentAportatConsultaRDTO;
	}

	/**
	 * Builds the document generat consulta RDTO document.
	 *
	 * @param docsTramitacioRDTO
	 *            the docs tramitacio RDTO
	 * @param origenApiParamValueTranslator
	 *            the origen api param value translator
	 * @return the document generat consulta RDTO
	 */
	public static DocumentGeneratConsultaRDTO buildDocumentGeneratConsultaRDTODocument(DocsTramitacioRDTO docsTramitacioRDTO,
	        BaseApiParamValueTranslator origenApiParamValueTranslator) {

		DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(Constants.DATE_TIME_PATTERN);

		ConfiguracioDocumentacioRDTO configuracioDocumentacioRDTO = null;

		DocumentGeneratConsultaRDTO documentGeneratConsultaRDTO = new DocumentGeneratConsultaRDTO();

		documentGeneratConsultaRDTO.setId(docsTramitacioRDTO.getId());
		documentGeneratConsultaRDTO.setIdGestorDocumental(docsTramitacioRDTO.getMigracioIdOrigen());
		documentGeneratConsultaRDTO.setNom(docsTramitacioRDTO.getDocsFisicsNom());

		configuracioDocumentacioRDTO = new ConfiguracioDocumentacioRDTO();
		configuracioDocumentacioRDTO.setCodi((docsTramitacioRDTO.getConfiguracioDocsTramitacio().getUniqueId() != null)
		        ? String.valueOf(docsTramitacioRDTO.getConfiguracioDocsTramitacio().getUniqueId()) : null);
		configuracioDocumentacioRDTO.setDescripcio(docsTramitacioRDTO.getConfiguracioDocsTramitacioNom());
		configuracioDocumentacioRDTO.setDescripcioCastella(docsTramitacioRDTO.getConfiguracioDocsTramitacioNomCastella());
		configuracioDocumentacioRDTO.setCodiNti(docsTramitacioRDTO.getConfiguracioDocsTramitacio().getCodiNti());
		documentGeneratConsultaRDTO.setConfiguracioDocumentacio(configuracioDocumentacioRDTO);

		documentGeneratConsultaRDTO.setDataCreacio(
		        (docsTramitacioRDTO.getDataCreacio() != null) ? dateTimeFormatter.print(docsTramitacioRDTO.getDataCreacio()) : null);
		documentGeneratConsultaRDTO.setDataComunicat(
		        (docsTramitacioRDTO.getDataComunicat() != null) ? dateTimeFormatter.print(docsTramitacioRDTO.getDataComunicat()) : null);
		documentGeneratConsultaRDTO
		        .setOrigen(origenApiParamValueTranslator.getApiParamValueByInternalValue(docsTramitacioRDTO.getOrigen()));
		documentGeneratConsultaRDTO.setHash(docsTramitacioRDTO.getHash());
		documentGeneratConsultaRDTO.setCodiCSV(docsTramitacioRDTO.getCsv());

		return documentGeneratConsultaRDTO;
	}

	public static ProcedimentPersonesRDTO buildProcedimentPersoneRDTOProcediments(
	        NivellVisibilitatApiParamValueTranslator nivellVisibilitatApiParamValueTranslator,
	        TramitsOvtProcedimentsApiParamValueTranslator tramitsOvtProcedimentsApiParamValueTranslator,
	        ProcedimentPersones procedimentPersones) {

		ProcedimentPersonesRDTO procedimentPersonesRDTO = new ProcedimentPersonesRDTO();
		procedimentPersonesRDTO.setTipus(procedimentPersones.getRelacio());
		procedimentPersonesRDTO.setNivellVisibilitat(
		        nivellVisibilitatApiParamValueTranslator.getApiParamValueByInternalValue(procedimentPersones.getNivellVisibilitat()));

		// if (procedimentPersones.getTramitsOvtList() != null) {
		// TramitsOvtProcedimentsRDTO tramitsOvtProcedimentsRDTO = null;
		// ArrayList<TramitsOvtProcedimentsRDTO> tramitList = new
		// ArrayList<TramitsOvtProcedimentsRDTO>();
		// for (ProcedimentPersonesTramOvt procedimentPersonesTramOvt :
		// procedimentPersones.getTramitsOvtList()) {
		//
		// tramitsOvtProcedimentsRDTO = new TramitsOvtProcedimentsRDTO();
		// tramitsOvtProcedimentsRDTO.setNom(tramitsOvtProcedimentsApiParamValueTranslator
		// .getApiParamValueByInternalValue(procedimentPersonesTramOvt.getTramitOvtIdext()));
		//
		// tramitList.add(tramitsOvtProcedimentsRDTO);
		// }
		//
		// procedimentPersonesRDTO.setTramits(tramitList);
		// }

		return procedimentPersonesRDTO;

	}

	/**
	 * Builds the persones sollicitud expedient.
	 *
	 * @param personesRDTO
	 *            the persones RDTO
	 * @param relacioPersonaApiParamValue
	 *            the relacio persona api param value
	 * @param tipusPersonaApiParamValueTranslator
	 *            the tipus persona api param value translator
	 * @param tipusDocumentIdentitatApiParamValueTranslator
	 *            the tipus document identitat api param value translator
	 * @param tipusSexeApiParamValueTranslator
	 *            the tipus sexe api param value translator
	 * @return the persones sollicitud
	 */
	public static PersonesSollicitudRDTO buildPersonesSollicitudRDTOExpedient(PersonesRDTO personesRDTO,
	        RelacioPersonaApiParamValue relacioPersonaApiParamValue,
	        TipusPersonaApiParamValueTranslator tipusPersonaApiParamValueTranslator,
	        TipusDocumentIdentitatApiParamValueTranslator tipusDocumentIdentitatApiParamValueTranslator,
	        BooleanApiParamValueTranslator booleanApiParamValueTranslator,
	        TipusSexeApiParamValueTranslator tipusSexeApiParamValueTranslator, boolean relacionPrincipal) {

		PersonesSollicitudRDTO personesSollicitud = null;

		if (personesRDTO != null) {
			personesSollicitud = new PersonesSollicitudRDTO();

			personesSollicitud.setId(personesRDTO.getId());

			personesSollicitud.setEsInteressada(BooleanApiParamValue.FALSE.getInternalValue());
			if (relacioPersonaApiParamValue != null && (relacioPersonaApiParamValue.getInternalValue()
			        .compareTo(RelacioPersonaApiParamValue.SOLLICITANT.getInternalValue()) == 0
			        || relacioPersonaApiParamValue.getInternalValue()
			                .compareTo(RelacioPersonaApiParamValue.REPRESENTANT.getInternalValue()) == 0)) {
				personesSollicitud.setEsInteressada(BooleanApiParamValue.TRUE.getInternalValue());

				personesSollicitud.setRelacio(relacioPersonaApiParamValue.getInternalValue());
			}
			personesSollicitud.setRelacioImplicada(personesRDTO.getRelacioTerceraPersona());
			personesSollicitud
			        .setRelacioPrincipal(booleanApiParamValueTranslator.getInternalValueByApiParamValueAsBoolean(relacionPrincipal));
			personesSollicitud.setVisibilitatOvt(
			        booleanApiParamValueTranslator.getInternalValueByApiParamValueAsBoolean(personesRDTO.getVisibilitatOvt()));
			Persones persones = new Persones();
			persones.setTipusPersona(tipusPersonaApiParamValueTranslator.getInternalValueByApiParamValue(personesRDTO.getTipusPersona()));
			persones.setNomRaoSocial(personesRDTO.getNomRaoSocial());
			persones.setCognom1(personesRDTO.getCognom1());
			persones.setCognom2(personesRDTO.getCognom2());
			DocumentsIdentitat documentsIdentitat = new DocumentsIdentitat();
			TipusDocumentIdentitat tipusDocumentIdentitat = new TipusDocumentIdentitat();
			tipusDocumentIdentitat.setId(tipusDocumentIdentitatApiParamValueTranslator
			        .getInternalValueByApiParamValue(personesRDTO.getDocumentIndentitat().getTipusDocument()));
			documentsIdentitat.setTipusDocumentIdentitat(tipusDocumentIdentitat);
			documentsIdentitat.setTipus(tipusDocumentIdentitatApiParamValueTranslator
			        .getInternalValueByApiParamValue(personesRDTO.getDocumentIndentitat().getTipusDocument()));
			documentsIdentitat.setNumeroDocument(personesRDTO.getDocumentIndentitat().getNumeroDocument());
			documentsIdentitat.setPais(personesRDTO.getDocumentIndentitat().getPais());
			persones.setDocumentsIdentitat(documentsIdentitat);
			PersonesDadescontacte personesDadescontacte = new PersonesDadescontacte();
			if (personesRDTO.getDadesNotificacio() != null) {
				personesDadescontacte.setEmail(personesRDTO.getDadesNotificacio().getEmail());
				personesDadescontacte.setTelefon(personesRDTO.getDadesNotificacio().getTelefon());
				personesDadescontacte.setMobil(personesRDTO.getDadesNotificacio().getMobil());
				personesDadescontacte.setFax(personesRDTO.getDadesNotificacio().getFax());
				personesDadescontacte.setTipusVia(personesRDTO.getDadesNotificacio().getTipusVia());
				personesDadescontacte.setDireccioPostal(personesRDTO.getDadesNotificacio().getNomVia());
				personesDadescontacte.setNumero(personesRDTO.getDadesNotificacio().getNumero());
				personesDadescontacte.setEscala(personesRDTO.getDadesNotificacio().getEscala());
				personesDadescontacte.setBloc(personesRDTO.getDadesNotificacio().getBloc());
				personesDadescontacte.setPorta(personesRDTO.getDadesNotificacio().getPorta());
				personesDadescontacte.setPis(personesRDTO.getDadesNotificacio().getPis());
				personesDadescontacte.setCodiPostal(personesRDTO.getDadesNotificacio().getCodiPostal());
				personesDadescontacte.setMunicipi(personesRDTO.getDadesNotificacio().getMunicipi());
				personesDadescontacte.setProvincia(personesRDTO.getDadesNotificacio().getProvincia());
				personesDadescontacte.setPais(personesRDTO.getDadesNotificacio().getPais());
				personesDadescontacte.setMunicipiEstranger(personesRDTO.getDadesNotificacio().getMunicipiEstranger());
				personesDadescontacte.setProvinciaEstranger(personesRDTO.getDadesNotificacio().getProvinciaEstranger());
				personesDadescontacte.setNotificacioPaper(booleanApiParamValueTranslator
				        .getInternalValueByApiParamValueAsBoolean(personesRDTO.getDadesNotificacio().getNotificacioPaper()));
				persones.setPersonesDadescontacte(personesDadescontacte);
			}
			personesSollicitud.setPersones(persones);
		}

		return personesSollicitud;
	}

	/**
	 * Builds the tercera persona accio RDTO expedient.
	 * 
	 * @param personesSollicitudRDTO
	 * @return tercerPersonaCreadaAccioRDTO
	 */
	public static TercerPersonaCreadaAccioRDTO buildTercerPersonaCreadaAccioRDTO(PersonesSollicitudRDTO personesSollicitudRDTO) {
		TercerPersonaCreadaAccioRDTO tercerPersonaCreadaAccioRDTO = null;

		if (personesSollicitudRDTO != null) {
			tercerPersonaCreadaAccioRDTO = new TercerPersonaCreadaAccioRDTO();

			tercerPersonaCreadaAccioRDTO.setId(personesSollicitudRDTO.getId());
		}

		return tercerPersonaCreadaAccioRDTO;
	}

	/**
	 * Builds the tercera persona accio RDTO expedient.
	 * 
	 * @param personesSollicitudRDTO
	 * @return tercerPersonaCreadaAccioRDTO
	 */
	public static TercerPersonaActualitzadaAccioRDTO buildTercerPersonaActualitzadaAccioRDTO(
	        PersonesSollicitudRDTO personesSollicitudRDTO) {
		TercerPersonaActualitzadaAccioRDTO tercerPersonaActualitzadaAccioRDTO = null;

		if (personesSollicitudRDTO != null) {
			tercerPersonaActualitzadaAccioRDTO = new TercerPersonaActualitzadaAccioRDTO();

			tercerPersonaActualitzadaAccioRDTO.setId(personesSollicitudRDTO.getId());
		}

		return tercerPersonaActualitzadaAccioRDTO;
	}
}