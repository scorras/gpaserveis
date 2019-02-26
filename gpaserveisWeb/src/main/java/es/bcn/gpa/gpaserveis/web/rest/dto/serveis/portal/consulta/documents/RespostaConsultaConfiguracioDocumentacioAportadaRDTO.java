package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.documents;

import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.TramitsOvtRDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "RespostaConsultaConfiguracioDocumentacioAportada")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "tramit", "configuracioDocumentacioAportada" })
@Getter
@Setter
public class RespostaConsultaConfiguracioDocumentacioAportadaRDTO {

	@ApiModelProperty(value = "Dades del tràmit")
	private TramitsOvtRDTO tramit;

	@ApiModelProperty("Llista de configuració documentació aportada")
	private List<ConfiguracioDocumentacioAportadaConsultaRDTO> configuracioDocumentacioAportada = Collections.emptyList();

}
