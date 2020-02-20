package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "ConfiguracioDocumentacio")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "codi", "descripcio", "descripcioCastella" })
@XmlRootElement(name = "configuracioDocumentacio")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class ConfiguracioDocumentacioRDTO {

	@ApiModelProperty(value = "Codi del document")
	@XmlElement(name = "codi")
	private String codi;
	@ApiModelProperty(value = "Descripció del document")
	@XmlElement(name = "descripcio")
	private String descripcio;
	@ApiModelProperty(value = "Descripció del document en castellà")
	@XmlElement(name = "descripcioCastella")
	private String descripcioCastella;
	@ApiModelProperty(value = "Codi Nti del document")
	@XmlElement(name = "codiNti")
	private String codiNti;

}
