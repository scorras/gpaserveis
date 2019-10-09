package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.acces;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.DocumentsIdentitatRDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "ExpedientAcces")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "documentIdentitat" })
@Getter
@Setter
public class ExpedientAccesRDTO {

	@ApiModelProperty(value = "Dades del document d'identitat.")
	private DocumentsIdentitatRDTO documentsIdentitatRDTO;

}
