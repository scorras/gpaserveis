package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.resolucio.validar;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "PersonaValidarResolucioDocument")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "matricula", "documentIdentitat" })
@Getter
@Setter
public class PersonaValidarResolucioDocumentRDTO {
	@ApiModelProperty(value = "Matrícula de la persona que va a signar el document", required = true)
	private String matricula;

	@ApiModelProperty(value = "Document d'identitat de la persona que va a signar el document", required = true)
	private String documentIdentitat;
}
