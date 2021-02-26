package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.cercar;

import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.cerca.PaginacioRDTO;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "RespostaCercaExpedientsTramitadors")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "data", "paginacio" })
@Getter
@Setter
public class RespostaCercaExpedientsTramitadorsRDTO {

	private List<ExpedientsCercaTramitadorsRDTO> data = Collections.emptyList();
	private PaginacioRDTO paginacio;

}
