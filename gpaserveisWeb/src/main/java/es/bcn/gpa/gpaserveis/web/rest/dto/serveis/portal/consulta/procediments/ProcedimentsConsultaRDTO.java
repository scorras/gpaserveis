package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.procediments;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.UnitatGestoraRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.DadesIdentificacioRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.TramitsRDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="ProcedimentConsulta")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "codi",
    "descripcio",
    "ugr",
    "ugo",
    "organResolutori",
    "inici",
    "versio",
    "estat",
    "tramits",
    "dadesIdentificacio"
})
public class ProcedimentsConsultaRDTO {
	
	@ApiModelProperty(value="Identificador del procediment")
	private BigDecimal id;
	@ApiModelProperty(value="Codi del procediment")
	private String codi;
	@ApiModelProperty(value="Descripció del procediment")
	private String descripcio;
	@ApiModelProperty(value="Unitat gestora responsable")
	private UnitatGestoraRDTO ugr;
	@ApiModelProperty(value="Llista d'unitats gestores operatives")
	private List<UnitatGestoraRDTO> ugo;
	@ApiModelProperty(value="Òrgan resolutori")
	private String organResolutori;
	@ApiModelProperty(value="Tipus d'inici del procediment",
		allowableValues="OFICI, SOLICITUD, ADMINISTRACIO, ALTRES")
	private List<String> inici;
	@ApiModelProperty(value="Versió del procediment")
	private String versio;
	@ApiModelProperty(value="Estat actual del procediment",
		allowableValues="EN_ELABORACIO, PUBLICAT, FINALITZAT")
	private String estat;
	@ApiModelProperty(value="Tràmits del procediment")
	private TramitsRDTO tramits;
	@ApiModelProperty(value="Dades d'identificació del procediment")
	private DadesIdentificacioRDTO dadesIdentificacio;
	
	
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
	public String getDescripcio() {
		return descripcio;
	}
	public void setDescripcio(String descripcio) {
		this.descripcio = descripcio;
	}
	public UnitatGestoraRDTO getUgr() {
		return ugr;
	}
	public void setUgr(UnitatGestoraRDTO ugr) {
		this.ugr = ugr;
	}
	public List<UnitatGestoraRDTO> getUgo() {
		return ugo;
	}
	public void setUgo(List<UnitatGestoraRDTO> ugo) {
		this.ugo = ugo;
	}
	public String getOrganResolutori() {
		return organResolutori;
	}
	public void setOrganResolutori(String organResolutori) {
		this.organResolutori = organResolutori;
	}
	public List<String> getInici() {
		return inici;
	}
	public void setInici(List<String> inici) {
		this.inici = inici;
	}
	public String getVersio() {
		return versio;
	}
	public void setVersio(String versio) {
		this.versio = versio;
	}
	public String getEstat() {
		return estat;
	}
	public void setEstat(String estat) {
		this.estat = estat;
	}
	public TramitsRDTO getTramits() {
		return tramits;
	}
	public void setTramits(TramitsRDTO tramits) {
		this.tramits = tramits;
	}
	public DadesIdentificacioRDTO getDadesIdentificacio() {
		return dadesIdentificacio;
	}
	public void setDadesIdentificacio(DadesIdentificacioRDTO dadesIdentificacio) {
		this.dadesIdentificacio = dadesIdentificacio;
	}
	
}
