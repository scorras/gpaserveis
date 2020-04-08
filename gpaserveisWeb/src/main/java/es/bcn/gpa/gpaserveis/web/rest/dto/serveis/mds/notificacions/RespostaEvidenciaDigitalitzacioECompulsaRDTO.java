package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.mds.notificacions;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.document.EstatDigitalizaApiParamValueTranslator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "RespostaEvidenciaDigitalitzacioECompulsa")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "idDocumentum", "idPeticio", "estatECompulsa" })
@Getter
@Setter
public class RespostaEvidenciaDigitalitzacioECompulsaRDTO {

	@ApiModelProperty(value = "Identificadors en documentum dels documents digitalitzats")
	private List<String> idDocumentum;
	@ApiModelProperty(value = "Identificador de la petició de digitalització")
	private String idPeticio;
	@ApiModelProperty(value = "\"OK\" si l'escaneig s'ha realitzat correctament o \"KO\" en cas contrari.", allowableValues = EstatDigitalizaApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES)
	private String estatECompulsa;

}
