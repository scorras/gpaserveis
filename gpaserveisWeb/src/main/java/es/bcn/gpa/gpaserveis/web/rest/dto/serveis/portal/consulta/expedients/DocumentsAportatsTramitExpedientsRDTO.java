package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.expedients;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.DocumentRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.TramitsOvtRDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "DocumentsAportatsTramitExpedients")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "tramit", "documents" })
@Getter
@Setter
public class DocumentsAportatsTramitExpedientsRDTO {

	@ApiModelProperty(value = "Tràmit")
	private TramitsOvtRDTO tramit;

	@ApiModelProperty(value = "Documents aportats a l'expedient en el tràmit")
	private List<DocumentRDTO> documents;
}
