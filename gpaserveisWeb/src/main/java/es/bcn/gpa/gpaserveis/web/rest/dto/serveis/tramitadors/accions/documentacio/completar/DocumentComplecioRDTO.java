package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.documentacio.completar;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "DocumentComplecio")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "document" })
@Getter
@Setter
public class DocumentComplecioRDTO {

	@ApiModelProperty(value = "Document", required = true)
	private DocumentCompletatRDTO document;

}
