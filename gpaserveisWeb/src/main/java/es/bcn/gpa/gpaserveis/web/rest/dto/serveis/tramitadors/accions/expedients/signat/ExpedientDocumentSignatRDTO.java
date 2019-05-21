package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.signat;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "ExpedientDocumentSignat")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "comentari" })
@Getter
@Setter
public class ExpedientDocumentSignatRDTO {

	@ApiModelProperty(value = "Comentari associat al document signat.")
	private String comentari;

}
