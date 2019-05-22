package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.documentacio.digitalitzar;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "DocumentDigitalitzacio")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "document" })
@Getter
@Setter
public class DocumentDigitalitzacioRDTO {

	@ApiModelProperty(value = "Document", required = true)
	private DocumentDigitalitzatRDTO document;

}
