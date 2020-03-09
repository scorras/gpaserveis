package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.apache.commons.lang.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.business.xml.bind.adapter.AdrecaAdapter;
import es.bcn.gpa.gpaserveis.business.xml.bind.adapter.MunicipiAdapter;
import es.bcn.gpa.gpaserveis.business.xml.bind.adapter.PaisAdapter;
import es.bcn.gpa.gpaserveis.business.xml.bind.adapter.ProvinciaAdapter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "DadesContacte")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "email", "telefon", "mobil", "fax", "tipusVia", "nomVia", "numero", "escala", "bloc", "porta", "pis", "codiPostal",
        "municipi", "provincia", "pais", "municipiEstranger", "provinciaEstranger" })
@XmlRootElement(name = "DADES_NOTIFICACIO")
@XmlType(name = "DadesContacte", propOrder = { "email", "telefon", "mobil", "fax", "adreca", "codiPostal", "municipiProvincia", "provincia",
        "pais", "municipiEstranger", "provinciaEstranger" })
@XmlAccessorType(XmlAccessType.NONE)
@Getter
@Setter
public class DadesContacteRDTO {

	@ApiModelProperty(value = "Email")
	@XmlElement(name = "EMAIL", required = true, type = String.class)
	private String email;
	@ApiModelProperty(value = "Telèfon fixe")
	@XmlElement(name = "TELEFON", required = false, type = String.class)
	private String telefon;
	@ApiModelProperty(value = "Telèfon mobil")
	@XmlElement(name = "MOBIL", required = false, type = String.class)
	private String mobil;
	@ApiModelProperty(value = "Fax")
	@XmlElement(name = "FAX", required = false, type = String.class)
	private String fax;

	@ApiModelProperty(value = "Codi INE del tipus de via")
	@XmlTransient
	private String tipusVia;
	@ApiModelProperty(value = "Nom de la via")
	@XmlTransient
	private String nomVia;
	@ApiModelProperty(value = "Número")
	@XmlTransient
	private String numero;
	@ApiModelProperty(value = "Escala")
	@XmlTransient
	private String escala;
	@ApiModelProperty(value = "Bloc")
	@XmlTransient
	private String bloc;
	@ApiModelProperty(value = "Porta")
	@XmlTransient
	private String porta;
	@ApiModelProperty(value = "Pis")
	@XmlTransient
	private String pis;

	@ApiModelProperty(value = "Codi Postal")
	@XmlElement(name = "CODI_POSTAL", required = false, type = String.class)
	private String codiPostal;
	@ApiModelProperty(value = "Codi INE del Municipi")
	@XmlTransient
	private String municipi;
	@ApiModelProperty(value = "Codi INE de la Província")
	@XmlElement(name = "PROVINCIA", required = false)
	@XmlJavaTypeAdapter(ProvinciaAdapter.class)
	private String provincia;
	@ApiModelProperty(value = "Codi INE del Pais")
	@XmlElement(name = "PAIS", required = false)
	@XmlJavaTypeAdapter(PaisAdapter.class)
	private String pais;

	@ApiModelProperty(value = "Municipi estranger")
	@XmlElement(name = "MUNICIPI_ESTRANGER", required = false, type = String.class)
	private String municipiEstranger;
	@ApiModelProperty(value = "Provincia estrangera")
	@XmlElement(name = "PROVINCIA_ESTRANGER", required = false, type = String.class)
	private String provinciaEstranger;

	@JsonIgnore
	@XmlElement(name = "ADRECA", required = false)
	@XmlJavaTypeAdapter(AdrecaAdapter.class)
	public String getAdreca() {
		return StringUtils.join(new String[] { tipusVia, nomVia, numero, bloc, escala, pis, porta }, " ");
	}

	@JsonIgnore
	@XmlElement(name = "MUNICIPI", required = false)
	@XmlJavaTypeAdapter(MunicipiAdapter.class)
	public String getMunicipiProvincia() {
		return StringUtils.join(new String[] { provincia, municipi }, " ");
	}

}