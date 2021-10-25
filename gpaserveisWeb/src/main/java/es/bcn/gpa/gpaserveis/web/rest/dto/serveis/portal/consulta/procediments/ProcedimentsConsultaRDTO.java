package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.procediments;

import java.math.BigDecimal;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.procediment.IniciacioApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.UnitatGestoraRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.DadesIdentificacioRDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "ProcedimentConsulta")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "codi", "versio", "nom", "nomCastella", "descripcio", "descripcioCastella", "ugr", "ugo", "organResolutori",
        "inici", "estat", "estatCastella", "dadesIdentificacio"})
@XmlRootElement(name = "PROCEDIMENT")
@XmlType(name = "ProcedimentsConsulta", propOrder = { "id", "codi", "versio", "nom", "nomCastella" })
@XmlAccessorType(XmlAccessType.NONE)
@Getter
@Setter
public class ProcedimentsConsultaRDTO {

	@ApiModelProperty(value = "Identificador del procediment")
	@XmlElement(name = "ID", required = true, type = BigDecimal.class)
	private BigDecimal id;
	@ApiModelProperty(value = "Codi del procediment")
	@XmlElement(name = "CODI", required = true, type = String.class)
	private String codi;
	@ApiModelProperty(value = "Versió del procediment")
	@XmlElement(name = "VERSIO", required = true, type = BigDecimal.class)
	private BigDecimal versio;
	@ApiModelProperty(value = "Nom del procediment")
	@XmlElement(name = "NOM", required = true, type = String.class)
	private String nom;
	@ApiModelProperty(value = "Nom del procediment en castellà")
	@XmlElement(name = "NOM_ESP", required = true, type = String.class)
	private String nomCastella;
	@ApiModelProperty(value = "Descripció del procediment")
	@XmlTransient
	private String descripcio;
	@ApiModelProperty(value = "Descripció del procediment en castellà")
	@XmlTransient
	private String descripcioCastella;
	@ApiModelProperty(value = "Unitat gestora responsable")
	@XmlTransient
	private UnitatGestoraRDTO ugr;
	@ApiModelProperty(value = "Llista d'unitats gestores operatives")
	@XmlTransient
	private List<UnitatGestoraRDTO> ugo;
	@ApiModelProperty(value = "Òrgan resolutori")
	@XmlTransient
	private String organResolutori;
	@ApiModelProperty(value = "Tipus d'inici del procediment", allowableValues = IniciacioApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES)
	@XmlTransient
	private List<String> inici;
	@ApiModelProperty(value = "Estat actual del procediment")
	@XmlTransient
	private String estat;
	@ApiModelProperty(value = "Estat actual del procediment en castellà")
	@XmlTransient
	private String estatCastella;
	// @ApiModelProperty(value = "Llista de tràmits del procediment")
	// private List<TramitsRDTO> tramits;
	@ApiModelProperty(value = "Dades d'identificació del procediment")
	@XmlTransient
	private DadesIdentificacioRDTO dadesIdentificacio;	

}
