package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.signar;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.document.TipusSignaturaApiParamValueTranslator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * The Class SignaturaDocumentRDTO.
 */
@ApiModel(value = "SignaturaDocument", discriminator = "modalitatSignatura")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "modalitatSignatura", "politicaSignatura", "usuariPortasig", "usuariManuscrita" })
@Getter
@Setter
public class SignaturaDocumentRDTO {

	/** The modalitat signatura. */
	@ApiModelProperty(value = "Modalitat de signatura", allowableValues = TipusSignaturaApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES_OFFLINE)
	private String modalitatSignatura = null;

	/** The politica signatura. */
	@ApiModelProperty(value = "Política de signatura")
	private String politicaSignatura = null;

	/** The usuari. */
	@ApiModelProperty(value = "Informació de l'usuari de Portasignatures", required = false)
	private UsuariPortasignaturesRDTO usuariPortasig;

	/** The usuari. */
	@ApiModelProperty(value = "Informació de l'usuari de tablet", required = false)
	private UsuariManuscritaRDTO usuariManuscrita;

}
