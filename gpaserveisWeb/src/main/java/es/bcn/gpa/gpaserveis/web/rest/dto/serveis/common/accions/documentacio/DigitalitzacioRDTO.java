package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.accions.documentacio;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.Constants;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.document.IdiomaApiParamValueTranslator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "Digitalitzacio")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "idioma", "dataLimit" })
@Getter
@Setter
public class DigitalitzacioRDTO {

	@ApiModelProperty(value = "Idioma del document digitalitzat.", allowableValues = IdiomaApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES)
	private String idioma;
	@ApiModelProperty(value = "Data de digitalització del document.")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.DATE_TIME_PATTERN)
	private String dataDigitalitzacio;

}
