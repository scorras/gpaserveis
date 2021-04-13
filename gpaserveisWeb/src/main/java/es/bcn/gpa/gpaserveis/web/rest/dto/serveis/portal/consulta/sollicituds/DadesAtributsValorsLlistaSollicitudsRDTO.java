package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.sollicituds;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "ValorsLlistaSollicitud")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "index", "valor" })
@XmlRootElement(name = "VALOR_LLISTA")
@XmlType(name = "DadesAtributsValorsLlistaSollicituds", propOrder = { "index", "valor" })
@XmlAccessorType(XmlAccessType.NONE)
@Getter
@Setter
public class DadesAtributsValorsLlistaSollicitudsRDTO {

	@ApiModelProperty(value = "Codi del valor de la llista")
	@XmlElement(name = "INDEX", required = true, type = String.class)
	private String index;

	@ApiModelProperty(value = "Valor de la llista")
	@XmlElement(name = "VALOR", required = true, type = String.class)
	private String valor;

}
