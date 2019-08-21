package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.notificar;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "ExpedientNotificacioRDTO")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "destinataris", "idsAnnexosList" })
@Getter
@Setter
public class ExpedientNotificacioRDTO {

	@ApiModelProperty(value = "Destinataris de la notificació.", required = true)
	private List<PersonesNotificacioRDTO> destinataris;

	@ApiModelProperty(value = "Llista d'identificadors dels annexo.")
	private List<BigDecimal> idsAnnexosList;

}
