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

@ApiModel(value = "DadesContacte")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "email", "telefon", "mobil", "fax", "tipusVia", "nomVia", "numero", "escala", "bloc", "porta", "pis", "codiPostal",
        "municipi", "provincia", "pais", "municipiEstranger", "provinciaEstranger" })
@XmlRootElement(name = "dadesNotificacio")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class DadesContacteRDTO {

	@ApiModelProperty(value = "Email")
	@XmlElement(name = "email")
	private String email;
	@ApiModelProperty(value = "Telèfon fixe")
	@XmlElement(name = "telefon")
	private String telefon;
	@ApiModelProperty(value = "Telèfon mobil")
	@XmlElement(name = "mobil")
	private String mobil;
	@ApiModelProperty(value = "Fax")
	@XmlElement(name = "fax")
	private String fax;

	@ApiModelProperty(value = "Codi INE del tipus de via")
	@XmlElement(name = "tipusVia")
	private String tipusVia;
	@ApiModelProperty(value = "Nom de la via")
	@XmlElement(name = "nomVia")
	private String nomVia;
	@ApiModelProperty(value = "Número")
	@XmlElement(name = "numero")
	private String numero;
	@ApiModelProperty(value = "Escala")
	@XmlElement(name = "escala")
	private String escala;
	@ApiModelProperty(value = "Bloc")
	@XmlElement(name = "bloc")
	private String bloc;
	@ApiModelProperty(value = "Porta")
	@XmlElement(name = "porta")
	private String porta;
	@ApiModelProperty(value = "Pis")
	@XmlElement(name = "pis")
	private String pis;

	@ApiModelProperty(value = "Codi Postal")
	@XmlElement(name = "codiPostal")
	private String codiPostal;
	@ApiModelProperty(value = "Codi INE del Municipi")
	@XmlElement(name = "municipi")
	private String municipi;
	@ApiModelProperty(value = "Codi INE de la Província")
	@XmlElement(name = "provincia")
	private String provincia;
	@ApiModelProperty(value = "Codi INE del Pais")
	@XmlElement(name = "pais")
	private String pais;

	@ApiModelProperty(value = "Municipi estranger")
	@XmlElement(name = "municipiEstranger")
	private String municipiEstranger;
	@ApiModelProperty(value = "Provincia estrangera")
	@XmlElement(name = "provinciaEstranger")
	private String provinciaEstranger;

}