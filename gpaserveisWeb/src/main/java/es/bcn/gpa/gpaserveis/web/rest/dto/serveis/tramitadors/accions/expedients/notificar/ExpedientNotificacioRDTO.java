package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.notificar;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "ExpedientNotificacioRDTO")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "titol", "textNotificacio", "destinataris", "documents" })
@Getter
@Setter
public class ExpedientNotificacioRDTO {

	@ApiModelProperty(value = "Títol de la notificació.", required = true)
	private String titol;
	@ApiModelProperty(value = "Text de la notificació.", required = true)
	private String textNotificacio;
	@ApiModelProperty(value = "Destinataris de la notificació.", required = true)
	private List<Object> destinataris;
	@ApiModelProperty(value = "Documents de la notificació.", required = true)
	private List<Object> documents;

}
