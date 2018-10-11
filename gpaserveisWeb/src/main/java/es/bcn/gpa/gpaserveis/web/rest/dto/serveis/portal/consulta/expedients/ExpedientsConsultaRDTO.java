package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.expedients;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.HistoricsRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.PersonesRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.RegistreRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.UnitatGestoraRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.procediments.ProcedimentsConsultaRDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="ExpedientsConsulta")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "codi",
    "permetAportacio",
    "permetEsmena",
    "permetAlegacio",
    "dataPresentacio",
    "dataModificacio",
    "unitatGestora",
    "estat",
    "historics",
    "procediment",
    "registre",
    "solicitant",
    "representant",
    "documents",
    "atributs"
})
public class ExpedientsConsultaRDTO {
	
	@ApiModelProperty(value="Identificador de l'expedient")
	private BigDecimal id;
	@ApiModelProperty(value="Codi de l'expedient")
	private String codi;
	@ApiModelProperty(value="Indica si l'expedient permet aportar documentació sense requerir")
	private boolean permetAportacio;
	@ApiModelProperty(value="Indica si l'expedient permet realitzar esmenes")
	private boolean permetEsmena;
	@ApiModelProperty(value="Indica si l'expedient permet realitzar al·legacions")
	private boolean permetAlegacio;
	@ApiModelProperty(value="Data de presentació de l'expedient")
	private String dataPresentacio;
	@ApiModelProperty(value="Data de l'última modificació de l'expedient")
	private String dataModificacio;
	@ApiModelProperty(value="Unitat gestora")
	private UnitatGestoraRDTO unitatGestora;
	@ApiModelProperty(value="Estat actual del procediment",
		allowableValues="EN_PREPARACIO, EN_REVISIO, PENDENT_SUBSANACIO, EN_TRAMITACIO, PENDENT_ALEGACIONS, PENDENT_INFORMES, PROPOSAT_RESOLUCIO, RESOLT, TANCAT")
	private String estat;
	private List<HistoricsRDTO> historics = Collections.emptyList();
	private ProcedimentsConsultaRDTO procediment;
	private RegistreRDTO registre;
	private PersonesRDTO solicitant;
	private PersonesRDTO representant;
	private List<DocumentsExpedientsRDTO> documents = Collections.emptyList();
	private List<DadesAtributsExpedientsRDTO> atributs = Collections.emptyList();
	
	
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
	public boolean isPermetAportacio() {
		return permetAportacio;
	}
	public void setPermetAportacio(boolean permetAportacio) {
		this.permetAportacio = permetAportacio;
	}
	public boolean isPermetEsmena() {
		return permetEsmena;
	}
	public void setPermetEsmena(boolean permetEsmena) {
		this.permetEsmena = permetEsmena;
	}
	public boolean isPermetAlegacio() {
		return permetAlegacio;
	}
	public void setPermetAlegacio(boolean permetAlegacio) {
		this.permetAlegacio = permetAlegacio;
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
	public String getEstat() {
		return estat;
	}
	public void setEstat(String estat) {
		this.estat = estat;
	}
	public List<HistoricsRDTO> getHistorics() {
		return historics;
	}
	public void setHistorics(List<HistoricsRDTO> historics) {
		this.historics = historics;
	}
	public ProcedimentsConsultaRDTO getProcediment() {
		return procediment;
	}
	public void setProcediment(ProcedimentsConsultaRDTO procediment) {
		this.procediment = procediment;
	}
	public RegistreRDTO getRegistre() {
		return registre;
	}
	public void setRegistre(RegistreRDTO registre) {
		this.registre = registre;
	}
	public PersonesRDTO getSolicitant() {
		return solicitant;
	}
	public void setSolicitant(PersonesRDTO solicitant) {
		this.solicitant = solicitant;
	}
	public PersonesRDTO getRepresentant() {
		return representant;
	}
	public void setRepresentant(PersonesRDTO representant) {
		this.representant = representant;
	}
	public List<DocumentsExpedientsRDTO> getDocuments() {
		return documents;
	}
	public void setDocuments(List<DocumentsExpedientsRDTO> documents) {
		this.documents = documents;
	}
	public List<DadesAtributsExpedientsRDTO> getAtributs() {
		return atributs;
	}
	public void setAtributs(List<DadesAtributsExpedientsRDTO> atributs) {
		this.atributs = atributs;
	}
	
	
	
	
}
