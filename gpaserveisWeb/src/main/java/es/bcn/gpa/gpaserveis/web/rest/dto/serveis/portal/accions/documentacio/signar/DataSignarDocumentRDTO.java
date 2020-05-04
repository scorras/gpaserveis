package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.signar;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.ConfDocsTramPolitiquesSig;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "DataSignarDocument")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "usuariPortaSig", "confDocsTramPolitiquesSig" })
@Getter
@Setter
public class DataSignarDocumentRDTO {

	@ApiModelProperty(value = "Persona que signa el document")
	UsuariPortaSigRDTO usuariPortaSig;

	@ApiModelProperty(value = "Configuracio de modalitat i signatura")
	ConfDocsTramPolitiquesSig confDocsTramPolitiquesSig;

}
