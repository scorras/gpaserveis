package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "AuditServeisRDTO")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "momentExecucio", "usuari", "dadesAuth", "dadesEntrada", "dadesResposta", "mappingAccio", "valueAccio",
		"tipusPeticio", "resultat", "detallError" })
@Getter
@Setter
public class AuditServeisRDTO {

	@ApiModelProperty(value = "id de l'auditoria d'accions", required = true)
	private BigDecimal id;
	@ApiModelProperty(value = "Moment en el qual s'executo la accio", required = true)
	private Date momentExecucio;
	@ApiModelProperty(value = "Nome del usuari que executa la accio", required = true)
	private String usuari;
	@ApiModelProperty(value = "Dades del usuari que executa la accio", required = true)
	private String dadesAuth;
	@ApiModelProperty(value = "Dades d'entrada", required = true)
	private String dadesEntrada;
	@ApiModelProperty(value = "Dades de resposta", required = true)
	private String dadesResposta;
	@ApiModelProperty(value = "Mapatge de l'acció executada", required = true)
	private String mappingAccio;
	@ApiModelProperty(value = "Valor de l'acció executada", required = true)
	private String valueAccio;
	@ApiModelProperty(value = "Tipus de petició de l'acció executada", required = true)
	private String tipusPeticio;
	@ApiModelProperty(value = "Resultat de la resposta en executar l'acció", required = true)
	private String resultat;
	@ApiModelProperty(value = "Detall de l'error", required = false)
	private String detallError;

}
