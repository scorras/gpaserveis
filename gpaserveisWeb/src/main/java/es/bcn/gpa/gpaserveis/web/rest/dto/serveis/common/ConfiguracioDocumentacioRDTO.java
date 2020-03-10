package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common;

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

@ApiModel(value = "ConfiguracioDocumentacio")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "codi", "descripcio", "descripcioCastella" })
@XmlRootElement(name = "CONFIGURACIO_DOCUMENTACIO")
@XmlType(name = "ConfiguracioDocumentacio", propOrder = { "codi", "descripcio", "descripcioCastella", "codiNti" })
@XmlAccessorType(XmlAccessType.NONE)
@Getter
@Setter
public class ConfiguracioDocumentacioRDTO {

	@ApiModelProperty(value = "Codi del document")
	@XmlElement(name = "CODI", required = true, type = String.class)
	private String codi;
	@ApiModelProperty(value = "Descripció del document")
	@XmlElement(name = "DESCRIPCIO", required = true, type = String.class)
	private String descripcio;
	@ApiModelProperty(value = "Descripció del document en castellà")
	@XmlElement(name = "DESCRIPCIO_CASTELLA", required = true, type = String.class)
	private String descripcioCastella;
	@ApiModelProperty(value = "Codi Nti del document")
	@XmlElement(name = "CODI_NTI", required = false, type = String.class)
	private String codiNti;

}
