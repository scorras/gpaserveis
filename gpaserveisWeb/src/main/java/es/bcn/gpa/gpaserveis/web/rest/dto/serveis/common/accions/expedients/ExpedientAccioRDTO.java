package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.accions.expedients;

import java.math.BigDecimal;

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

@ApiModel(value = "ExpedientAccio")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "codi", "pathGestorDocumental" })
@XmlRootElement(name = "EXPEDIENT")
@XmlType(name = "ExpedientAccio", propOrder = { "id", "codi", "pathGestorDocumental" })
@XmlAccessorType(XmlAccessType.NONE)
@Getter
@Setter
public class ExpedientAccioRDTO {

	@ApiModelProperty("Identificador de l'expedient")
	@XmlElement(name = "ID", required = true, type = BigDecimal.class)
	private BigDecimal id;
	@ApiModelProperty("Codi identificador de l'expedient")
	@XmlElement(name = "CODI", required = true, type = String.class)
	private String codi;
	@ApiModelProperty(value = "Path Gestor Documental")
	@XmlElement(name = "PATH_GESTOR_DOCUMENTAL", required = false, type = String.class)
	private String pathGestorDocumental;

}
