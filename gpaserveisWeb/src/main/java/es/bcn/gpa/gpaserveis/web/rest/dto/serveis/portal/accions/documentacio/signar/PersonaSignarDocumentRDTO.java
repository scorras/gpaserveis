package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.signar;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "PersonaSignarDocument")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "matricula", "documentIdentitat", "nom" })
@Getter
@Setter
public class PersonaSignarDocumentRDTO {
	@ApiModelProperty(value = "Matrícula de la persona que va a signar el document", required = true)
	private String matricula;

	@ApiModelProperty(value = "Document d'identitat de la persona que va a signar el document", required = true)
	private String documentIdentitat;

	@ApiModelProperty(value = "Nom de la persona que va a signar el document", required = true)
	private String nom;
}
