package es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.ConfdocsentTramitsOvt;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.ConfiguracioDocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.Persones;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.DadesOperTramitsOvt;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.DadesOperValidVal;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.DadesOperacions;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.DadesOperacionsValidacio;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.Items;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaunitats.UnitatsGestoresRDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.Constants;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.expedient.EstatApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.procediment.TipusValidacioApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.procediment.TramitOvtApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.BaseApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.common.BooleanApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.DadesAtributsRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.DadesAtributsValidacionsRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.DadesAtributsValorsLlistaRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.DadesAtributsValorsValidacionsRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.DocumentsIdentitatRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.DocumentsRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.PersonesRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.UnitatGestoraRDTO;

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
	 * @param historicsRDTOApi
	 *            the historics RDTO api
	 * @param historicEstatApiParamValueTranslator
	 *            the historic estat api param value translator
	 * @return the es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal. historics
	 *         RDTO
	 */
	public static es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.HistoricsRDTO buildHistoricsRDTOExpedient(
	        es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.HistoricsRDTO historicsRDTOApi,
	        BaseApiParamValueTranslator historicEstatApiParamValueTranslator) {

		es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.HistoricsRDTO historicsRDTO = new es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.HistoricsRDTO();
		DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(Constants.DATE_TIME_PATTERN);
		historicsRDTO.setDataCreacio(
		        (historicsRDTOApi.getDataCreacio() != null) ? dateTimeFormatter.print(historicsRDTOApi.getDataCreacio()) : null);
		// TODO Mejorar esta chapucilla
		historicsRDTO.setEstat(getEstatExpedient(historicsRDTOApi.getDescripcio(), historicEstatApiParamValueTranslator));
		return historicsRDTO;
	}

	/**
	 * Gets the estat expedient.
	 *
	 * @param descripcioHistoric
	 *            the descripcio historic
	 * @param historicEstatApiParamValueTranslator
	 *            the historic estat api param value translator
	 * @return the estat expedient
	 */
	private static String getEstatExpedient(String descripcioHistoric, BaseApiParamValueTranslator historicEstatApiParamValueTranslator) {
		// Formato:
		// "Se ha realizado un cambio de estado del expediente de \"Pendent
		// al·legacions\" a \"En tramitació\" "
		String estatExpedient = null;
		Pattern pattern = Pattern.compile("\"(.*?)\"");
		Matcher matcher = pattern.matcher(descripcioHistoric);
		while (matcher.find()) {
			estatExpedient = matcher.group(NumberUtils.INTEGER_ONE);
		}
		return historicEstatApiParamValueTranslator.getApiParamValueByInternalValue(estatExpedient);
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
			personesRDTO.setSexe(
			        tipusSexeApiParamValueTranslator.getApiParamValueByInternalValue(persones.getPersonesDadescontacte().getSexe()));
		}
		DocumentsIdentitatRDTO documentsIdentitatRDTO = new DocumentsIdentitatRDTO();
		if (persones.getDocumentsIdentitat() != null) {
			documentsIdentitatRDTO.setTipusDocument(tipusDocumentIdentitatApiParamValueTranslator
			        .getApiParamValueByInternalValue(persones.getDocumentsIdentitat().getTipusDocumentIdentitat().getId()));
			documentsIdentitatRDTO.setNumeroDocument(persones.getDocumentsIdentitat().getNumeroDocument().toUpperCase());
			documentsIdentitatRDTO.setPais(persones.getDocumentsIdentitat().getPaisos().getCodiIso());
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
	 * @param expedientEstatApiParamValueTranslator
	 *            the expedient estat api param value translator
	 * @return the es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal. dades
	 *         grups RDTO
	 */
	public static es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.DadesGrupsRDTO buildDadesGrupsRDTOProcediment(
	        es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.DadesGrupsRDTO internalDadesGrupsRDTO,
	        BaseApiParamValueTranslator tipusCampApiParamValueTranslator, BaseApiParamValueTranslator tipusValidacioApiParamValueTranslator,
	        BaseApiParamValueTranslator expedientEstatApiParamValueTranslator) {

		if (internalDadesGrupsRDTO == null) {
			return null;
		}

		es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.DadesGrupsRDTO dadesGrupsRDTO = new es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.DadesGrupsRDTO();
		dadesGrupsRDTO.setTitol(internalDadesGrupsRDTO.getTitol());
		dadesGrupsRDTO.setDescripcio(internalDadesGrupsRDTO.getDescripcio());
		dadesGrupsRDTO.setColumnes(
		        (internalDadesGrupsRDTO.getNomColumnes() != null) ? String.valueOf(internalDadesGrupsRDTO.getNomColumnes()) : null);
		dadesGrupsRDTO.setUrlValidacio(internalDadesGrupsRDTO.getUrlValidacio());
		dadesGrupsRDTO.setOrdre((internalDadesGrupsRDTO.getOrdre() != null) ? String.valueOf(internalDadesGrupsRDTO.getOrdre()) : null);
		ArrayList<DadesAtributsRDTO> dadesAtributsRDTOList = new ArrayList<DadesAtributsRDTO>();
		if (CollectionUtils.isNotEmpty(internalDadesGrupsRDTO.getDadesOperacionsList())) {
			for (DadesOperacions dadesOperacions : internalDadesGrupsRDTO.getDadesOperacionsList()) {
				dadesAtributsRDTOList.add(ConverterHelper.buildDadesAtributsRDTOProcediment(dadesOperacions,
				        tipusCampApiParamValueTranslator, tipusValidacioApiParamValueTranslator, expedientEstatApiParamValueTranslator));
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
	 * @param expedientEstatApiParamValueTranslator
	 *            the expedient estat api param value translator
	 * @return the dades atributs RDTO
	 */
	public static DadesAtributsRDTO buildDadesAtributsRDTOProcediment(DadesOperacions dadesOperacions,
	        BaseApiParamValueTranslator tipusCampApiParamValueTranslator, BaseApiParamValueTranslator tipusValidacioApiParamValueTranslator,
	        BaseApiParamValueTranslator expedientEstatApiParamValueTranslator) {
		DadesAtributsRDTO dadesAtributsRDTO = new DadesAtributsRDTO();
		dadesAtributsRDTO.setCodi(dadesOperacions.getCodi());
		dadesAtributsRDTO.setDescripcio(dadesOperacions.getDescripcio());
		dadesAtributsRDTO.setTitol(dadesOperacions.getTitol());
		dadesAtributsRDTO.setTipus(tipusCampApiParamValueTranslator.getApiParamValueByInternalValue(dadesOperacions.getTipus()));
		if (CollectionUtils.isNotEmpty(dadesOperacions.getItemsList())) {
			ArrayList<DadesAtributsValorsLlistaRDTO> dadesAtributsValorsLlistaRDTOList = new ArrayList<DadesAtributsValorsLlistaRDTO>();
			DadesAtributsValorsLlistaRDTO dadesAtributsValorsLlistaRDTO = null;
			for (Items items : dadesOperacions.getItemsList()) {
				dadesAtributsValorsLlistaRDTO = new DadesAtributsValorsLlistaRDTO();
				dadesAtributsValorsLlistaRDTO.setValor(items.getItemDescripcio());
				dadesAtributsValorsLlistaRDTO.setOrdre((items.getItemOrdre() != null) ? String.valueOf(items.getItemOrdre()) : null);
				dadesAtributsValorsLlistaRDTOList.add(dadesAtributsValorsLlistaRDTO);
			}
			Collections.sort(dadesAtributsValorsLlistaRDTOList);
			dadesAtributsRDTO.setValorsLlista(dadesAtributsValorsLlistaRDTOList);
		}
		if (esTramitOvt(dadesOperacions, TramitOvtApiParamValue.SOL) && dadesOperacions.getEstatIdext() != null
		        && expedientEstatApiParamValueTranslator.getApiParamValueByInternalValue(dadesOperacions.getEstatIdext())
		                .equals(EstatApiParamValue.SOL_LICITUD_EN_REVISIO.getApiParamValue())) {
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
		dadesAtributsRDTO.setUrlValidacio(StringUtils.EMPTY);
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

	public static DocumentsRDTO buildDocumentsRDTOProcediment(ConfiguracioDocsEntradaRDTO configuracioDocsEntradaRDTO,
	        BooleanApiParamValueTranslator booleanApiParamValueTranslator,
	        BaseApiParamValueTranslator suportConfeccioApiParamValueTranslator,
	        BaseApiParamValueTranslator expedientEstatApiParamValueTranslator) {
		DocumentsRDTO documentsRDTO = new DocumentsRDTO();
		documentsRDTO.setCodi((configuracioDocsEntradaRDTO.getId() != null) ? String.valueOf(configuracioDocsEntradaRDTO.getId()) : null);
		documentsRDTO.setDescripcio(configuracioDocsEntradaRDTO.getNom());
		documentsRDTO.setDescripcioAmpliada(configuracioDocsEntradaRDTO.getDescripcioAmpliada());
		if (esTramitOvt(configuracioDocsEntradaRDTO, TramitOvtApiParamValue.SOL)
		        && configuracioDocsEntradaRDTO.getIniciProcediment() != null
		        && expedientEstatApiParamValueTranslator
		                .getApiParamValueByInternalValue(BigDecimal.valueOf(configuracioDocsEntradaRDTO.getIniciProcediment()))
		                .equals(EstatApiParamValue.SOL_LICITUD_EN_REVISIO.getApiParamValue())) {
			documentsRDTO.setObligatori(Boolean.TRUE);
		} else {
			documentsRDTO.setObligatori(Boolean.FALSE);
		}
		documentsRDTO.setRepetible(booleanApiParamValueTranslator
		        .getApiParamValueAsBooleanByInternalValue(configuracioDocsEntradaRDTO.getAtributsDocs().getRepetible()));
		documentsRDTO.setSuportConfeccio(
		        suportConfeccioApiParamValueTranslator.getApiParamValueByInternalValue(configuracioDocsEntradaRDTO.getSuportConfeccio()));
		documentsRDTO.setSuportEnllac(configuracioDocsEntradaRDTO.getSuportEnllac());
		return documentsRDTO;
	}

	/**
	 * Es tramit ovt.
	 *
	 * @param configuracioDocsEntradaRDTO
	 *            the configuracio docs entrada RDTO
	 * @param tramitOvtApiParamValue
	 *            the tramit ovt api param value
	 * @return true, if successful
	 */
	private static boolean esTramitOvt(ConfiguracioDocsEntradaRDTO configuracioDocsEntradaRDTO,
	        TramitOvtApiParamValue tramitOvtApiParamValue) {
		if (CollectionUtils.isNotEmpty(configuracioDocsEntradaRDTO.getConfdocsentTramitsOvtList())) {
			for (ConfdocsentTramitsOvt confdocsentTramitsOvt : configuracioDocsEntradaRDTO.getConfdocsentTramitsOvtList()) {
				if (confdocsentTramitsOvt.getTramitOvtIdext()
				        .compareTo(tramitOvtApiParamValue.getInternalValue()) == NumberUtils.INTEGER_ZERO) {
					return true;
				}
			}
		}
		return false;
	}

}