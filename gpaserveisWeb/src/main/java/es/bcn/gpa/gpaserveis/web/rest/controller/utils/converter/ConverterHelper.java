package es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.math.NumberUtils;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.Persones;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaunitats.UnitatsGestoresRDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.Constants;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.BaseApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.DocumentsIdentitatRDTO;
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
		unitatGestoraRDTO.setCodi(unitatsGestoresRDTO.getNom());
		unitatGestoraRDTO.setDescripcio(unitatsGestoresRDTO.getDescripcio());
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
			documentsIdentitatRDTO.setNumeroDocument(persones.getDocumentsIdentitat().getNumeroDocument());
			documentsIdentitatRDTO.setPais(persones.getDocumentsIdentitat().getPaisos().getCodiIso());
		}
		personesRDTO.setDocumentIndentitat(documentsIdentitatRDTO);
		return personesRDTO;
	}

}