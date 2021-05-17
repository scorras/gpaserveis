package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.expedients;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import es.bcn.gpa.gpaserveis.web.rest.dto.json.JsonDadesAtributsExpedientsSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "AtributsExpedient")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "codi", "index", "valor", "valorCastella", "valorsLlista" })
@Getter
@Setter
public class DadesAtributsExpedientsRDTO {

	@ApiModelProperty(value = "Codi de l'atribut")
	private String codi;
	@ApiModelProperty(value = "Codi del valor de la llista")
	private String index;
	@ApiModelProperty(value = "Llista de valors de l'atribut")
	private List<String> valor;
	@ApiModelProperty(value = "Llista de valors de l'atribut en castellà")
	private List<String> valorCastella;
	@ApiModelProperty(value = "Si el tipus de camp de l'atribut és llista, valors d'aquesta llista")
	private List<DadesAtributsValorsLlistaExpedientsRDTO> valorsLlista;

}
