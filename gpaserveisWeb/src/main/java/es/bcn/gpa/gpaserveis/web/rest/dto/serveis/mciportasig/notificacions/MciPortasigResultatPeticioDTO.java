package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.mciportasig.notificacions;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "MciPortasigResultatPeticio")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "codiAplicacio", "codiPeticio", "codiEstat", "raoRetorn", "detallSignataris" })
@Getter
@Setter
public class MciPortasigResultatPeticioDTO {

	@ApiModelProperty(required = true, value = "Identificador enviat per l'aplicació client en la seva petició original de signatura/validació. Té 20 posicions. Requerit.")
	private String codiAplicacio;
	@ApiModelProperty(required = true, value = "Identificador assignat pel Portasignatures en el moment d'acceptar la petició. 12 posicions. Requerit.")
	private String codiPeticio;
	@ApiModelProperty(required = true, value = "Indicador de l'estat global de la petició, o buit en cas que es produeixi un error. Requerit.", allowableValues = "COMPLETADA,RETORNADA,CADUCADA")
	private String codiEstat;
	@ApiModelProperty("Pel cas d'una petició globalment retornada, quina ha sigut la raó donada pel usuari signatari/validador responsable del retorn. Inclòs per a peticions retornades, aquest camp pot estar buit (no és obligat que l'usuari indiqui una raó). Opcional.")
	private String raoRetorn;
	@ApiModelProperty(required = true, value = "Detall de l'estat parcial de la petició, pels casos en que s'hagi demanat circuit de signatures/validacions")
	private MciPortasigDetallSignatarisDTO detallSignataris;

}
