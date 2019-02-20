package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.expedients;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.TramitsOvtRDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "DocumentsAportatsExpedients")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "tramits" })
@Getter
@Setter
public class DocumentsAportatsExpedientsRDTO {

	@ApiModelProperty(value = "Documents aportats agrupats per tràmit")
	private List<TramitsOvtRDTO> tramits;

}
