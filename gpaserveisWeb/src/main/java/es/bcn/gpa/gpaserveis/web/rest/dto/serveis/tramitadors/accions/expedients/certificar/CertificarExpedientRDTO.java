package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.certificar;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "CertificarExpedient")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "codiExpedient", "comentari" })
@Getter
@Setter
public class CertificarExpedientRDTO {

	@ApiModelProperty(value = "Codi de l'expedient certificat.", required = true)
	private String codiExpedient;
	@ApiModelProperty(value = "Comentari associat a la certificació.", required = true)
	private String comentari;

}
