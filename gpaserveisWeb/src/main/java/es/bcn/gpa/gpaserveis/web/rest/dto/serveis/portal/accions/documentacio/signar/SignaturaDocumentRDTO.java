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
@ApiModel(value = "SignaturaDocument", discriminator = "modalitatSignatura", subTypes = { SignaturaPortasignaturesDocumentRDTO.class,
        SignaturaSegellDocumentRDTO.class, SignaturaManuscritaDocumentRDTO.class })
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "modalitatSignatura", "politicaSignatura" })
@Getter
@Setter
public class SignaturaDocumentRDTO {

	/** The modalitat signatura. */
	@ApiModelProperty(value = "Modalitat de signatura", allowableValues = TipusSignaturaApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES_OFFLINE)
	private String modalitatSignatura = null;

	/** The politica signatura. */
	@ApiModelProperty(value = "Política de signatura")
	private String politicaSignatura = null;

}
