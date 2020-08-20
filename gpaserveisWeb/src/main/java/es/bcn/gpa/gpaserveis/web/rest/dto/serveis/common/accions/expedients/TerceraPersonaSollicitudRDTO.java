package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.accions.expedients;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PersonesSollicitudRDTO;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "TerceraPersonaSollicitud")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "personesSollicitudRDTO" })
@Getter
@Setter
public class TerceraPersonaSollicitudRDTO {

	/** The personesSollicitud RDTO. */
	private PersonesSollicitudRDTO personesSollicitudRDTO;
}
