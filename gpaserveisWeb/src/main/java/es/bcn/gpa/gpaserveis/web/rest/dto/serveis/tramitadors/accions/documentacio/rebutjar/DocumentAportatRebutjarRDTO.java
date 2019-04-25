package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.documentacio.rebutjar;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "DocumentAportatRebutjar")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "comentari" })
@Getter
@Setter
public class DocumentAportatRebutjarRDTO {

	@ApiModelProperty(value = "Comentari amb la informació que NO ha estat validada.")
	private String comentari;

}
