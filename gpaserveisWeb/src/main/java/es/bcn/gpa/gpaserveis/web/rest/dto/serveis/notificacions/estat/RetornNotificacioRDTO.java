package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.notificacions.estat;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "RetornNotificacio")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "notificacioId", "estat", "codiError", "descripcioError", "numRegistre", "dataHoraRegistre", "dataHoraDiposit", "dataHoraVisualitzacio", "dataHoraAceptacioRebuig", "dataLimit", "docEvidenciaElectronic", "dataEnviament", "dataAcusamentRebuda", "docEvidenciaPaper" })
@Getter
@Setter
public class RetornNotificacioRDTO {

	@ApiModelProperty(value = "Identificador de la notificació")
	private Long notificacioId;
	@ApiModelProperty(value = "Estat de la notificació")
	private String estat;
	@ApiModelProperty(value = "codi de l'error")
	private Integer codiError;
	@ApiModelProperty(value = "Descripció de l'error")
	private String descripcioError;
	@ApiModelProperty(value = "Número de registre de la notificació.")
	private String numRegistre;	
	@ApiModelProperty(value = "Data en la que ha estat registrada la notificació. Format: dd/MM/yyyy hh:mm:ss")
	private String dataHoraRegistre;
	@ApiModelProperty(value = "Data en la que ha estat diposada la notificació. Format: dd/MM/yyyy hh:mm:ss")
	private String dataHoraDiposit;
	@ApiModelProperty(value = "Data en la que ha estat visualitzada la notificació. Format: dd/MM/yyyy hh:mm:ss")
	private String dataHoraVisualitzacio;
	@ApiModelProperty(value = "Data en la que ha estat acceptada/rebutjada la notificació. Format: dd/MM/yyyy hh:mm:ss")
	private String dataHoraAceptacioRebuig;
	@ApiModelProperty(value = "Data límit de la notificació. Format: dd/MM/yyyy")
	private String dataLimit;
	@ApiModelProperty(value = "Document de la evidència electrònica de la notificació")
	private String docEvidenciaElectronic;
	@ApiModelProperty(value = "Data d'enviament de la notificació. Format: dd/MM/yyyy hh:mm:ss")
	private String dataEnviament;
	@ApiModelProperty(value = "Data de l'acussament de rebuda de la notificació. Format: dd/MM/yyyy hh:mm:ss")
	private String dataAcusamentRebuda;
	@ApiModelProperty(value = "Document de la evidència en paper de la notificació")
	private String docEvidenciaPaper;
	
}