package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.documents;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.TramitsOvtRDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "RespostaConsultaDocumentsEntrada")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "documentacioEntrada" })
@Getter
@Setter
public class RespostaConsultaDocumentsEntradaRDTO {

	@ApiModelProperty(value = "Documentació d'entrada")
	private DocumentsEntradaConsultaRDTO documentacioEntrada;

	@ApiModelProperty(value = "Dades del tràmit")
	private TramitsOvtRDTO tramit;

}
