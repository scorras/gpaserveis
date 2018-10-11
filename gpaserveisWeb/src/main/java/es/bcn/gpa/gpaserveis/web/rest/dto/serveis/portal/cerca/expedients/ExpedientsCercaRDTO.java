package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.cerca.expedients;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.PersonesRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.UnitatGestoraRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.cerca.procediments.ProcedimentsCercaRDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="ExpedientsCerca")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "codi",
    "dataPresentacio",
    "dataModificacio",
    "unitatGestora",
    "procediment",
    "estat",
    "solicitant"
})
public class ExpedientsCercaRDTO {
	
	@ApiModelProperty(value="Identificador de l'expedient")
	private BigDecimal id;
	@ApiModelProperty(value="Codi de l'expedient")
	private String codi;
	@ApiModelProperty(value="Data de presentació de l'expedient")
	private String dataPresentacio;
	@ApiModelProperty(value="Data de l'última modificació de l'expedient")
	private String dataModificacio;
	@ApiModelProperty(value="Unitat gestora")
	private UnitatGestoraRDTO unitatGestora;
	private ProcedimentsCercaRDTO procediment;
	@ApiModelProperty(value="Estat actual del procediment",
		allowableValues="EN_PREPARACIO, EN_REVISIO, PENDENT_SUBSANACIO, EN_TRAMITACIO, PENDENT_ALEGACIONS, PENDENT_INFORMES, PROPOSAT_RESOLUCIO, RESOLT, TANCAT")
	private String estat;
	private PersonesRDTO solicitant;
	
	public BigDecimal getId() {
		return id;
	}
	public void setId(BigDecimal id) {
		this.id = id;
	}
	public String getCodi() {
		return codi;
	}
	public void setCodi(String codi) {
		this.codi = codi;
	}
	public String getDataPresentacio() {
		return dataPresentacio;
	}
	public void setDataPresentacio(String dataPresentacio) {
		this.dataPresentacio = dataPresentacio;
	}
	public String getDataModificacio() {
		return dataModificacio;
	}
	public void setDataModificacio(String dataModificacio) {
		this.dataModificacio = dataModificacio;
	}
	public UnitatGestoraRDTO getUnitatGestora() {
		return unitatGestora;
	}
	public void setUnitatGestora(UnitatGestoraRDTO unitatGestora) {
		this.unitatGestora = unitatGestora;
	}
	public ProcedimentsCercaRDTO getProcediment() {
		return procediment;
	}
	public void setProcediment(ProcedimentsCercaRDTO procediment) {
		this.procediment = procediment;
	}
	public String getEstat() {
		return estat;
	}
	public void setEstat(String estat) {
		this.estat = estat;
	}
	public PersonesRDTO getSolicitant() {
		return solicitant;
	}
	public void setSolicitant(PersonesRDTO solicitant) {
		this.solicitant = solicitant;
	}
}
