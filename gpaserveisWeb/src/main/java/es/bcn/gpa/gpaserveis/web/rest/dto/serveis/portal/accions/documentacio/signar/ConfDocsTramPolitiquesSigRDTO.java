package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.signar;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.document.TipusSignaturaApiParamValueTranslator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "ConfDocsTramPolitiquesSig")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "configuracioDocsTramitacio", "modalitatIdext", "ordre", "politicaSignatura" })
@Getter
@Setter
public class ConfDocsTramPolitiquesSigRDTO {

	@ApiModelProperty(value = "Persona que signa el document")
	private BigDecimal id = null;

	@ApiModelProperty(value = "Persona que signa el document")
	private BigDecimal configuracioDocsTramitacio = null;

	@ApiModelProperty(value = "Persona que signa el document", allowableValues = TipusSignaturaApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES)
	private String modalitatIdext = null;

	@ApiModelProperty(value = "Persona que signa el document")
	private BigDecimal ordre = null;

	@ApiModelProperty(value = "Persona que signa el document")
	private String politicaSignatura = null;

}
