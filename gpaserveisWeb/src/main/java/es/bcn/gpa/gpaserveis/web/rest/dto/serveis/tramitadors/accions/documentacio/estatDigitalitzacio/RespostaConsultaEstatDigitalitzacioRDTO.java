package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.documentacio.estatDigitalitzacio;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "RespostaConsultaEstatDigitalitzacio")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "idPeticio", "codiDocuments", "estat" })
@Getter
@Setter
public class RespostaConsultaEstatDigitalitzacioRDTO {

	@ApiModelProperty(value = "Identificador de la petició de digitalització")
	private String idPeticio;
	@ApiModelProperty(value = "Identificadors en Documentum dels documents digitalitzats separats per comes")
	private List<String> codiDocuments;
	@ApiModelProperty(value = "Estat del document escanejat. 2: OK, 3: KO")
	private String estat;

}
