package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.mcisignatures.notificacions.protocolretorn9;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ApiModel(value = "metadadesSignaturaDTO")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "codi", "nom", "nif", "cif", "entitatCertificadora", "tipusSignatura", "signTime", "vistiplau", "carrec", "decret",
        "tractament", "intencionalitat" })
@Getter
@Setter
@ToString
public class MetadadesSignaturaDTO {

	@ApiModelProperty(required = true, value = "Codi de la metadada")
	private BigDecimal codi;
	@ApiModelProperty(required = true, value = "Nom de la metadada")
	private String nom;
	@ApiModelProperty(required = true, value = "Nif")
	private String nif;
	@ApiModelProperty(required = true, value = "Cif")
	private String cif;
	@ApiModelProperty(required = true, value = "Entitat certificadora")
	private String entitatCertificadora;
	@ApiModelProperty(required = true, value = "Tipus de signatura")
	private String tipusSignatura;
	@ApiModelProperty(required = true, value = "Moment en que es va realitzar la signatura")
	private String signTime;
	@ApiModelProperty(required = true, value = "Vist-i-plau si o no")
	private boolean vistiplau;
	@ApiModelProperty(required = true, value = "Carrec del signant")
	private String carrec;
	@ApiModelProperty(required = true, value = "Decret")
	private String decret;
	@ApiModelProperty(required = true, value = "Tractament del signant")
	private String tractament;
	@ApiModelProperty(required = true, value = "Intencionalitat")
	private String intencionalitat;

}
