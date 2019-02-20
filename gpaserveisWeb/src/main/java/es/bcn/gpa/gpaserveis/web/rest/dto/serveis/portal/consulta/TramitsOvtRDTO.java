package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.procediment.TramitOvtApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.DocumentsRDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "TramitsOvt")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "codi", "nom", "documents" })
@Getter
@Setter
public class TramitsOvtRDTO {

	@ApiModelProperty(value = "Codi del tràmit", allowableValues = TramitOvtApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES)
	private String codi;
	@ApiModelProperty(value = "Nom del tràmit")
	private String nom;
	@ApiModelProperty(value = "Documents aportats a l'expedient en el tràmit")
	private List<DocumentsRDTO> documents;

}