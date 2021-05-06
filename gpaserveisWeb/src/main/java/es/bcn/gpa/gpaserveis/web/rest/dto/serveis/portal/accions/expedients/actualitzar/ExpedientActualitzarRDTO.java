package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.expedients.actualitzar;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.PersonesRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.accions.expedients.actualitzar.AtributsActualitzarRDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "ExpedientActualitzar")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "sollicitant", "representant", "dadesOperacio", "personesInteressades", "personesImplicades" })
@Getter
@Setter
public class ExpedientActualitzarRDTO {

	@ApiModelProperty(value = "sol·licitant", required = true)
	private PersonesRDTO sollicitant;
	@ApiModelProperty(value = "representant", required = false)
	private PersonesRDTO representant;
	@ApiModelProperty(value = "Atributs", required = false)
	private List<AtributsActualitzarRDTO> dadesOperacio;
	@ApiModelProperty(value = "Persones interessades", required = false)
	private List<PersonesRDTO> personesInteressades;
	@ApiModelProperty(value = "Persones implicades", required = false)
	private List<PersonesRDTO> personesImplicades;

}
