package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.mciportasig.notificacions;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "MciPortasigDetallSignataris")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "signatari" })
@Getter
@Setter
public class MciPortasigDetallSignatarisDTO {

	@ApiModelProperty("Detall de l'estat parcial de la petició, pels casos en que s'hagi demanat circuit de signatures/validacions")
	private List<MciPortasigSignatarisDTO> signatari;

}
