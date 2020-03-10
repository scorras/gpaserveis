package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.sollicituds;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "AtributsSollicitud")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "codi", "valor" })
@XmlRootElement(name = "DADA_OPERACIO")
@XmlType(name = "DadesAtributsSollicituds", propOrder = { "codi", "valors" })
@XmlAccessorType(XmlAccessType.NONE)
@Getter
@Setter
public class DadesAtributsSollicitudsRDTO {

	@ApiModelProperty(value = "Codi de l'atribut")
	@XmlElement(name = "CODI", required = true, type = String.class)
	private String codi;
	@ApiModelProperty(value = "Llista de valors de l'atribut")
	@XmlElementWrapper(name = "VALORS")
	@XmlElement(name = "VALOR")
	private List<String> valors;

}
