package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.accions.expedients;

import java.math.BigDecimal;

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

@ApiModel(value = "ExpedientAccio")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "codi" })
@XmlRootElement(name = "expedient")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class ExpedientAccioRDTO {

	@ApiModelProperty("Identificador de l'expedient")
	@XmlElement(name = "id")
	private BigDecimal id;
	@ApiModelProperty("Codi identificador de l'expedient")
	@XmlElement(name = "codi")
	private String codi;

}
