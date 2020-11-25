package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.mcisignatures.notificacions.protocolretorn9;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ApiModel(value = "signaturaDTO")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "idSignatura", "refDocumentSignat", "estatSignatura", "metadades" })
@Getter
@Setter
@ToString
public class SignaturaDTO {

	@ApiModelProperty(required = true, value = "Identificador de la signatura")
	private String idSignatura;
	@ApiModelProperty(required = true, value = "Referència de el document signat")
	private String refDocumentSignat;
	@ApiModelProperty(required = true, value = "Estat de la signatura")
	private EstatDTO estatSignatura;
	@ApiModelProperty(required = true, value = "Metadades de la signatura")
	private MetadadesSignaturaDTO metadades;

}
