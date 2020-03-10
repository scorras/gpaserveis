package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal;

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

@ApiModel(value = "UnitatGestora")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "codi", "nom" })
@XmlRootElement(name = "UNITAT_GESTORA")
@XmlType(name = "UnitatGestora", propOrder = { "codi", "nom" })
@XmlAccessorType(XmlAccessType.NONE)
@Getter
@Setter
public class UnitatGestoraRDTO {

	@ApiModelProperty(value = "Codi de la Unitat Gestora")
	@XmlElement(name = "CODI", required = true, type = String.class)
	private String codi;
	@ApiModelProperty(value = "Nom de la Unitat Gestora")
	@XmlElement(name = "NOM", required = true, type = String.class)
	private String nom;

}
