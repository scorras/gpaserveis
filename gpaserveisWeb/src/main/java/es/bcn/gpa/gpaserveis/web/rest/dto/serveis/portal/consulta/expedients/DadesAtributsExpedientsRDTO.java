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
@JsonPropertyOrder({ "codi", "index", "valor", "valorCastella", "valorsLlista", "valorsLlistaRepetible", "valorsLlistaMultipleRepetible", "valorRepetible", "titol" })
@JsonSerialize(using = JsonDadesAtributsExpedientsSerializer.class)
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
	@ApiModelProperty(value = "Si el tipus de camp de l'atribut és llesta repetible, valors d'aquesta llista")
	private List<DadesAtributsValorsLlistaRepetibleExpedientsRDTO> valorsLlistaRepetible;
	@ApiModelProperty(value = "Si el tipus de camp de l'atribut és llesta múltiple repetible, valors d'aquesta llista")
	private List<DadesAtributsValorsLlistaMultipleRepetibleExpedientsRDTO> valorsLlistaMultipleRepetible;
	@ApiModelProperty(value = "Llista de valors repetible de l'atribut")
	private List<String> valorRepetible;
	@ApiModelProperty(value = "Titol de l'atribut")
	private String titol;

}
