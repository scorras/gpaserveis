package es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.ConfDocEntradaRequeritRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.DocumentsIdentitat;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.EstatsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.Paisos;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.Persones;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PersonesDadescontacte;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PersonesSollicitud;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.TipusDocumentIdentitat;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.DadesOperTramitsOvt;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.DadesOperValidVal;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.DadesOperacions;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.DadesOperacionsValidacio;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.DadesoperEstatsExp;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.Items;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaunitats.UnitatsGestoresRDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.Constants;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.common.BooleanApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.expedient.EstatTramitadorApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.expedient.RelacioPersonaApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.procediment.TipusValidacioApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.procediment.TramitOvtApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.BaseApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.common.BooleanApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.expedient.TipusDocumentIdentitatApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.expedient.TipusPersonaApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.expedient.TipusSexeApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.expedient.TipusViaApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.ConfiguracioDocumentacioRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.DadesAtributsRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.DadesAtributsValidacionsRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.DadesAtributsValorsLlistaRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.DadesAtributsValorsValidacionsRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.DadesContacteRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.DocumentsIdentitatRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.HistoricsRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.PersonesRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.RegistreRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.UnitatGestoraRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.DocumentAportatAccioRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.TramitsOvtRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.documents.ConfiguracioDocumentacioRequeridaConsultaRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.documents.DocumentAportatConsultaRDTO;

/**
 * The Class ConverterHelper.
 */
public class ConverterHelper {

	/**
	 * Builds the unitat gestora RDTO unitats.
	 *
	 * @param unitatsGestoresRDTO
	 *            the unitats gestores RDTO
	 * @return the unitat gestora RDTO
	 */
	public static UnitatGestoraRDTO buildUnitatGestoraRDTOUnitats(UnitatsGestoresRDTO unitatsGestoresRDTO) {
		UnitatGestoraRDTO unitatGestoraRDTO = new UnitatGestoraRDTO();
		unitatGestoraRDTO.setCodi(unitatsGestoresRDTO.getCodi());
		unitatGestoraRDTO.setNom(unitatsGestoresRDTO.getNom());
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
	        BaseApiParamValueTranslator tipusSexeApiParamValueTranslator, BaseApiParamValueTranslator tipusViaApiParamValueTranslator) {

		if (persones == null) {
			return null;
		}

		PersonesRDTO personesRDTO = new PersonesRDTO();
		personesRDTO.setTipusPersona(tipusPersonaApiParamValueTranslator.getApiParamValueByInternalValue(persones.getTipusPersona()));
		personesRDTO.setNomRaoSocial(persones.getNomRaoSocial());
		personesRDTO.setCognom1(persones.getCognom1());
		personesRDTO.setCognom2(persones.getCognom2());
		if (persones.getPersonesDadescontacte() != null) {
			personesRDTO.setSexe(
			        tipusSexeApiParamValueTranslator.getApiParamValueByInternalValue(persones.getPersonesDadescontacte().getSexe()));
			DadesContacteRDTO dadesContacte = new DadesContacteRDTO();
			dadesContacte.setEmail(persones.getPersonesDadescontacte().getEmail());
			dadesContacte.setTelefon(persones.getPersonesDadescontacte().getTelefon());
			dadesContacte.setMobil(persones.getPersonesDadescontacte().getMobil());
			dadesContacte.setFax(persones.getPersonesDadescontacte().getFax());
			dadesContacte.setTipusVia(
			        tipusViaApiParamValueTranslator.getApiParamValueByInternalValue(persones.getPersonesDadescontacte().getTipusVia()));
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
			documentsIdentitatRDTO.setPais(persones.getDocumentsIdentitat().getPaisos().getCodiIne());
		}
		personesRDTO.setDocumentIndentitat(documentsIdentitatRDTO);
		return personesRDTO;
	}

	public static PersonesSollicitud buildPersonesSollicitudExpedient(PersonesRDTO personesRDTO,
	        RelacioPersonaApiParamValue relacioPersonaApiParamValue,
	        TipusPersonaApiParamValueTranslator tipusPersonaApiParamValueTranslator,
	        TipusDocumentIdentitatApiParamValueTranslator tipusDocumentIdentitatApiParamValueTranslator,
	        TipusSexeApiParamValueTranslator tipusSexeApiParamValueTranslator,
	        TipusViaApiParamValueTranslator tipusViaApiParamValueTranslator) {
		PersonesSollicitud personesSollicitud = null;

		if (personesRDTO != null) {
			personesSollicitud = new PersonesSollicitud();
			personesSollicitud.setEsInteressada(BooleanApiParamValue.TRUE.getInternalValue());
			personesSollicitud.setRelacio(relacioPersonaApiParamValue.getInternalValue());
			personesSollicitud.setRelacioPrincipal(BooleanApiParamValue.TRUE.getInternalValue());
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
			Paisos paisos = new Paisos();
			paisos.setCodiIne(personesRDTO.getDocumentIndentitat().getPais());
			documentsIdentitat.setPaisos(paisos);
			documentsIdentitat.setPais(personesRDTO.getDocumentIndentitat().getPais());
			persones.setDocumentsIdentitat(documentsIdentitat);
			PersonesDadescontacte personesDadescontacte = new PersonesDadescontacte();
			personesDadescontacte.setSexe(tipusSexeApiParamValueTranslator.getInternalValueByApiParamValue(personesRDTO.getSexe()));
			if (personesRDTO.getDadesNotificacio() != null) {
				personesDadescontacte.setEmail(personesRDTO.getDadesNotificacio().getEmail());
				personesDadescontacte.setTelefon(personesRDTO.getDadesNotificacio().getTelefon());
				personesDadescontacte.setMobil(personesRDTO.getDadesNotificacio().getMobil());
				personesDadescontacte.setFax(personesRDTO.getDadesNotificacio().getFax());
				personesDadescontacte.setTipusVia(
				        tipusViaApiParamValueTranslator.getInternalValueByApiParamValue(personesRDTO.getDadesNotificacio().getTipusVia()));
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
				persones.setPersonesDadescontacte(personesDadescontacte);
			}
			personesSollicitud.setPersones(persones);
		}

		return personesSollicitud;
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
	        BaseApiParamValueTranslator tipusSexeApiParamValueTranslator, BaseApiParamValueTranslator tipusViaApiParamValueTranslator) {

		if (persones == null) {
			return null;
		}

		PersonesRDTO personesRDTO = new PersonesRDTO();
		personesRDTO.setTipusPersona(tipusPersonaApiParamValueTranslator.getApiParamValueByInternalValue(persones.getTipusPersona()));
		personesRDTO.setNomRaoSocial(persones.getNomRaoSocial());
		personesRDTO.setCognom1(persones.getCognom1());
		personesRDTO.setCognom2(persones.getCognom2());
		if (persones.getPersonesDadescontacte() != null) {
			personesRDTO.setSexe(
			        tipusSexeApiParamValueTranslator.getApiParamValueByInternalValue(persones.getPersonesDadescontacte().getSexe()));

			DadesContacteRDTO dadesContacte = new DadesContacteRDTO();
			dadesContacte.setEmail(persones.getPersonesDadescontacte().getEmail());
			dadesContacte.setTelefon(persones.getPersonesDadescontacte().getTelefon());
			dadesContacte.setMobil(persones.getPersonesDadescontacte().getMobil());
			dadesContacte.setFax(persones.getPersonesDadescontacte().getFax());
			dadesContacte.setTipusVia(
			        tipusViaApiParamValueTranslator.getApiParamValueByInternalValue(persones.getPersonesDadescontacte().getTipusVia()));
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
			documentsIdentitatRDTO.setPais(persones.getDocumentsIdentitat().getPaisos().getCodiIne());
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
	 * @return the es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal. dades
	 *         grups RDTO
	 */
	public static es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.DadesGrupsRDTO buildDadesGrupsRDTOProcediment(
	        es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.DadesGrupsRDTO internalDadesGrupsRDTO,
	        BaseApiParamValueTranslator tipusCampApiParamValueTranslator, BaseApiParamValueTranslator tipusValidacioApiParamValueTranslator,
	        BaseApiParamValueTranslator expedientEstatTramitadorApiParamValueTranslator) {

		if (internalDadesGrupsRDTO == null) {
			return null;
		}

		es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.DadesGrupsRDTO dadesGrupsRDTO = new es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.DadesGrupsRDTO();
		dadesGrupsRDTO.setTitol(internalDadesGrupsRDTO.getTitol());
		dadesGrupsRDTO.setTitolCastella(internalDadesGrupsRDTO.getTitolCastella());
		dadesGrupsRDTO.setDescripcio(internalDadesGrupsRDTO.getDescripcio());
		dadesGrupsRDTO.setDescripcioCastella(internalDadesGrupsRDTO.getDescripcioCastella());
		dadesGrupsRDTO.setColumnes(
		        (internalDadesGrupsRDTO.getNomColumnes() != null) ? String.valueOf(internalDadesGrupsRDTO.getNomColumnes()) : null);
		dadesGrupsRDTO.setUrlValidacio(internalDadesGrupsRDTO.getUrlValidacio());
		dadesGrupsRDTO.setOrdre((internalDadesGrupsRDTO.getOrdre() != null) ? String.valueOf(internalDadesGrupsRDTO.getOrdre()) : null);
		ArrayList<DadesAtributsRDTO> dadesAtributsRDTOList = new ArrayList<DadesAtributsRDTO>();
		if (CollectionUtils.isNotEmpty(internalDadesGrupsRDTO.getDadesOperacionsList())) {
			for (DadesOperacions dadesOperacions : internalDadesGrupsRDTO.getDadesOperacionsList()) {
				dadesAtributsRDTOList
				        .add(ConverterHelper.buildDadesAtributsRDTOProcediment(dadesOperacions, tipusCampApiParamValueTranslator,
				                tipusValidacioApiParamValueTranslator, expedientEstatTramitadorApiParamValueTranslator));
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
	 * @return the dades atributs RDTO
	 */
	public static DadesAtributsRDTO buildDadesAtributsRDTOProcediment(DadesOperacions dadesOperacions,
	        BaseApiParamValueTranslator tipusCampApiParamValueTranslator, BaseApiParamValueTranslator tipusValidacioApiParamValueTranslator,
	        BaseApiParamValueTranslator expedientEstatTramitadorApiParamValueTranslator) {
		DadesAtributsRDTO dadesAtributsRDTO = new DadesAtributsRDTO();
		dadesAtributsRDTO.setCodi(dadesOperacions.getCodi());
		dadesAtributsRDTO.setDescripcio(dadesOperacions.getDescripcio());
		dadesAtributsRDTO.setDescripcioCastella(dadesOperacions.getDescripcioCastella());
		dadesAtributsRDTO.setTitol(dadesOperacions.getTitol());
		dadesAtributsRDTO.setTitolCastella(dadesOperacions.getTitolCastella());
		dadesAtributsRDTO.setTipus(tipusCampApiParamValueTranslator.getApiParamValueByInternalValue(dadesOperacions.getTipus()));
		if (CollectionUtils.isNotEmpty(dadesOperacions.getItemsList())) {
			ArrayList<DadesAtributsValorsLlistaRDTO> dadesAtributsValorsLlistaRDTOList = new ArrayList<DadesAtributsValorsLlistaRDTO>();
			DadesAtributsValorsLlistaRDTO dadesAtributsValorsLlistaRDTO = null;
			for (Items items : dadesOperacions.getItemsList()) {
				dadesAtributsValorsLlistaRDTO = new DadesAtributsValorsLlistaRDTO();
				dadesAtributsValorsLlistaRDTO.setCodi((items.getItemId() != null) ? String.valueOf(items.getItemId()) : null);
				dadesAtributsValorsLlistaRDTO.setValor(items.getItemDescripcio());
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
	 * @return the array list
	 */
	public static ArrayList<DocumentAportatConsultaRDTO> buildDocumentsAportatsConsultaRDTOListExpedient(
	        List<DocsEntradaRDTO> docsEntradaRDTOList, BaseApiParamValueTranslator tramitOvtApiParamValueTranslator,
	        BaseApiParamValueTranslator revisioApiParamValueTranslator, BaseApiParamValueTranslator tipusPersonaApiParamValueTranslator,
	        BaseApiParamValueTranslator tipusDocumentIdentitatApiParamValueTranslator,
	        BaseApiParamValueTranslator tipusSexeApiParamValueTranslator, BaseApiParamValueTranslator tipusViaApiParamValueTranslator) {
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
				documentAportatConsultaRDTO.setNom(docsEntradaRDTO.getDocsFisicsNom());
				documentAportatConsultaRDTO.setDataPresentacio((docsEntradaRDTO.getDataPresentacio() != null)
				        ? dateTimeFormatter.print(docsEntradaRDTO.getDataPresentacio()) : null);
				documentAportatConsultaRDTO
				        .setRevisio(revisioApiParamValueTranslator.getApiParamValueByInternalValue(docsEntradaRDTO.getRevisio()));
				configuracioDocumentacioRDTO = new ConfiguracioDocumentacioRDTO();
				configuracioDocumentacioRDTO.setCodi((docsEntradaRDTO.getConfiguracioDocsEntrada().getUniqueId() != null)
				        ? String.valueOf(docsEntradaRDTO.getConfiguracioDocsEntrada().getUniqueId()) : null);
				configuracioDocumentacioRDTO.setDescripcio(docsEntradaRDTO.getConfiguracioDocsEntradaNom());
				configuracioDocumentacioRDTO.setDescripcioCastella(docsEntradaRDTO.getConfiguracioDocsEntradaNomCastella());
				documentAportatConsultaRDTO.setConfiguracioDocumentacio(configuracioDocumentacioRDTO);
				if (docsEntradaRDTO.getRegistreAssentament() != null) {
					registreRDTO = new RegistreRDTO();
					registreRDTO.setNumRegistre(docsEntradaRDTO.getRegistreAssentament().getCodi());
					registreRDTO.setDataRegistre((docsEntradaRDTO.getRegistreAssentament().getDataRegistre() != null)
					        ? dateTimeFormatter.print(docsEntradaRDTO.getRegistreAssentament().getDataRegistre()) : null);
					registreRDTO.setPersona(buildPersonesRDTOExpedient(docsEntradaRDTO.getRegistreAssentament().getPersones(),
					        tipusPersonaApiParamValueTranslator, tipusDocumentIdentitatApiParamValueTranslator,
					        tipusSexeApiParamValueTranslator, tipusViaApiParamValueTranslator));
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
			if (docsEntradaRDTO.getDocsFisics() != null) {
				documentAportatAccioRDTO.setNom(docsEntradaRDTO.getDocsFisics().getNom());
			}
			if (docsEntradaRDTO.getConfiguracioDocsEntrada() != null) {
				ConfiguracioDocumentacioRDTO configuracioDocumentacioRDTO = new ConfiguracioDocumentacioRDTO();
				configuracioDocumentacioRDTO.setCodi(docsEntradaRDTO.getConfiguracioDocsEntrada().getUniqueId() != null
				        ? String.valueOf(docsEntradaRDTO.getConfiguracioDocsEntrada().getUniqueId()) : null);
				configuracioDocumentacioRDTO.setDescripcio(docsEntradaRDTO.getConfiguracioDocsEntrada().getNom());
				configuracioDocumentacioRDTO.setDescripcioCastella(docsEntradaRDTO.getConfiguracioDocsEntrada().getNomCastella());
				documentAportatAccioRDTO.setConfiguracioDocumentacio(configuracioDocumentacioRDTO);
			}
			documentAportatAccioRDTO.setOrigen(origenApiParamValueTranslator.getApiParamValueByInternalValue(docsEntradaRDTO.getOrigen()));
			documentAportatAccioRDTO
			        .setRevisio(revisioApiParamValueTranslator.getApiParamValueByInternalValue(docsEntradaRDTO.getRevisio()));
			documentAportatAccioRDTO.setDataPresentacio(
			        (docsEntradaRDTO.getDataPresentacio() != null) ? dateTimeFormatter.print(docsEntradaRDTO.getDataPresentacio()) : null);
			documentAportatAccioRDTO.setDataModificacio((docsEntradaRDTO.getDataUltimaModificacio() != null)
			        ? dateTimeFormatter.print(docsEntradaRDTO.getDataUltimaModificacio()) : null);
		}

		return documentAportatAccioRDTO;
	}

}