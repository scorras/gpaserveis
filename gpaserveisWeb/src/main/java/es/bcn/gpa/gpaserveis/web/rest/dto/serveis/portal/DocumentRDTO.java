package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal;

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

@ApiModel(value = "Document")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "idGestorDocumental", "nom" })
@XmlRootElement(name = "DOCUMENT")
@XmlType(name = "Document", propOrder = { "id", "idGestorDocumental", "nom" })
@XmlAccessorType(XmlAccessType.NONE)
@Getter
@Setter
public class DocumentRDTO {

	@ApiModelProperty(value = "Id del document")
	@XmlElement(name = "ID", required = true, type = BigDecimal.class)
	private BigDecimal id;
	@ApiModelProperty(value = "Id del gestor documental")
	@XmlElement(name = "ID_GESTOR_DOCUMENTAL", required = false, type = String.class)
	private String idGestorDocumental;
	@ApiModelProperty(value = "Nom del document")
	@XmlElement(name = "NOM", required = false, type = String.class)
	private String nom;

}
