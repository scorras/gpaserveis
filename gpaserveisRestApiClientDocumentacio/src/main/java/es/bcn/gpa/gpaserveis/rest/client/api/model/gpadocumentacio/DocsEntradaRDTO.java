/*
 * API gpadocumentacio
 * API gpadocumentacio
 *
 * OpenAPI spec version: 1.17.0
 * Contact: sergio.corras@iecisa.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * DocsEntradaRDTO
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-02-05T09:46:30.928+01:00")
public class DocsEntradaRDTO {
	@JsonProperty("codi")
	private String codi = null;

	@JsonProperty("comentari")
	private String comentari = null;

	@JsonProperty("configDocEntrada")
	private BigDecimal configDocEntrada = null;

	@JsonProperty("configuracioDocsEntrada")
	private ConfiguracioDocsEntrada configuracioDocsEntrada = null;

	@JsonProperty("configuracioDocsEntradaId")
	private BigDecimal configuracioDocsEntradaId = null;

	@JsonProperty("configuracioDocsEntradaNom")
	private String configuracioDocsEntradaNom = null;

	@JsonProperty("configuracioDocsEntradaNomCastella")
	private String configuracioDocsEntradaNomCastella = null;

	@JsonProperty("dataCreacio")
	private DateTime dataCreacio = null;

	@JsonProperty("dataDigitalitzacio")
	private DateTime dataDigitalitzacio = null;

	@JsonProperty("dataPresentacio")
	private DateTime dataPresentacio = null;

	@JsonProperty("dataUltimaModificacio")
	private DateTime dataUltimaModificacio = null;

	@JsonProperty("declaracioResponsable")
	private Integer declaracioResponsable = null;

	@JsonProperty("digitalitzat")
	private Integer digitalitzat = null;

	@JsonProperty("docsFisics")
	private DocsFisics docsFisics = null;

	@JsonProperty("docsFisicsNom")
	private String docsFisicsNom = null;

	@JsonProperty("docsTercers")
	private Integer docsTercers = null;

	@JsonProperty("documentFisic")
	private BigDecimal documentFisic = null;

	@JsonProperty("documentacio")
	private BigDecimal documentacio = null;

	@JsonProperty("editable")
	private Boolean editable = null;

	@JsonProperty("eliminat")
	private Integer eliminat = null;

	@JsonProperty("estatDigitalitzacio")
	private BigDecimal estatDigitalitzacio = null;

	@JsonProperty("id")
	private BigDecimal id = null;

	@JsonProperty("idIdiomaPlantilla")
	private BigDecimal idIdiomaPlantilla = null;

	@JsonProperty("idioma")
	private BigDecimal idioma = null;

	@JsonProperty("idiomaDigitalitzacio")
	private BigDecimal idiomaDigitalitzacio = null;

	@JsonProperty("metadata")
	private Map<String, List<String>> metadata = null;

	@JsonProperty("migracioIdOrigen")
	private String migracioIdOrigen = null;

	@JsonProperty("nou")
	private Integer nou = null;

	@JsonProperty("numDocsConfiguracio")
	private BigDecimal numDocsConfiguracio = null;

	@JsonProperty("obligatoriEnEstat")
	private Boolean obligatoriEnEstat = null;

	@JsonProperty("origen")
	private Integer origen = null;

	@JsonProperty("plantillaPdf")
	private Boolean plantillaPdf = null;

	@JsonProperty("registreAssentament")
	private RegistreAssentament registreAssentament = null;

	@JsonProperty("registreCodi")
	private String registreCodi = null;

	@JsonProperty("registreIdext")
	private BigDecimal registreIdext = null;

	@JsonProperty("requerit")
	private Boolean requerit = null;

	@JsonProperty("revisio")
	private Integer revisio = null;

	@JsonProperty("seleccionable")
	private Boolean seleccionable = null;

	@JsonProperty("sollicitudIdext")
	private BigDecimal sollicitudIdext = null;

	@JsonProperty("tipusMimeDescripcio")
	private String tipusMimeDescripcio = null;

	@JsonProperty("tramitOvtIdext")
	private BigDecimal tramitOvtIdext = null;

	@JsonProperty("ultimaModificacioIdext")
	private BigDecimal ultimaModificacioIdext = null;

	@JsonProperty("urlDigitalitzacio")
	private String urlDigitalitzacio = null;

	@JsonProperty("usuariIdext")
	private BigDecimal usuariIdext = null;

	public DocsEntradaRDTO codi(String codi) {
		this.codi = codi;
		return this;
	}

	/**
	 * Get codi
	 * 
	 * @return codi
	 **/
	@ApiModelProperty(value = "")
	public String getCodi() {
		return codi;
	}

	public void setCodi(String codi) {
		this.codi = codi;
	}

	public DocsEntradaRDTO comentari(String comentari) {
		this.comentari = comentari;
		return this;
	}

	/**
	 * Get comentari
	 * 
	 * @return comentari
	 **/
	@ApiModelProperty(value = "")
	public String getComentari() {
		return comentari;
	}

	public void setComentari(String comentari) {
		this.comentari = comentari;
	}

	public DocsEntradaRDTO configDocEntrada(BigDecimal configDocEntrada) {
		this.configDocEntrada = configDocEntrada;
		return this;
	}

	/**
	 * Get configDocEntrada
	 * 
	 * @return configDocEntrada
	 **/
	@ApiModelProperty(value = "")
	public BigDecimal getConfigDocEntrada() {
		return configDocEntrada;
	}

	public void setConfigDocEntrada(BigDecimal configDocEntrada) {
		this.configDocEntrada = configDocEntrada;
	}

	public DocsEntradaRDTO configuracioDocsEntrada(ConfiguracioDocsEntrada configuracioDocsEntrada) {
		this.configuracioDocsEntrada = configuracioDocsEntrada;
		return this;
	}

	/**
	 * Get configuracioDocsEntrada
	 * 
	 * @return configuracioDocsEntrada
	 **/
	@ApiModelProperty(value = "")
	public ConfiguracioDocsEntrada getConfiguracioDocsEntrada() {
		return configuracioDocsEntrada;
	}

	public void setConfiguracioDocsEntrada(ConfiguracioDocsEntrada configuracioDocsEntrada) {
		this.configuracioDocsEntrada = configuracioDocsEntrada;
	}

	public DocsEntradaRDTO configuracioDocsEntradaId(BigDecimal configuracioDocsEntradaId) {
		this.configuracioDocsEntradaId = configuracioDocsEntradaId;
		return this;
	}

	/**
	 * Get configuracioDocsEntradaId
	 * 
	 * @return configuracioDocsEntradaId
	 **/
	@ApiModelProperty(value = "")
	public BigDecimal getConfiguracioDocsEntradaId() {
		return configuracioDocsEntradaId;
	}

	public void setConfiguracioDocsEntradaId(BigDecimal configuracioDocsEntradaId) {
		this.configuracioDocsEntradaId = configuracioDocsEntradaId;
	}

	public DocsEntradaRDTO configuracioDocsEntradaNom(String configuracioDocsEntradaNom) {
		this.configuracioDocsEntradaNom = configuracioDocsEntradaNom;
		return this;
	}

	/**
	 * Get configuracioDocsEntradaNom
	 * 
	 * @return configuracioDocsEntradaNom
	 **/
	@ApiModelProperty(value = "")
	public String getConfiguracioDocsEntradaNom() {
		return configuracioDocsEntradaNom;
	}

	public void setConfiguracioDocsEntradaNom(String configuracioDocsEntradaNom) {
		this.configuracioDocsEntradaNom = configuracioDocsEntradaNom;
	}

	public DocsEntradaRDTO configuracioDocsEntradaNomCastella(String configuracioDocsEntradaNomCastella) {
		this.configuracioDocsEntradaNomCastella = configuracioDocsEntradaNomCastella;
		return this;
	}

	/**
	 * Get configuracioDocsEntradaNomCastella
	 * 
	 * @return configuracioDocsEntradaNomCastella
	 **/
	@ApiModelProperty(value = "")
	public String getConfiguracioDocsEntradaNomCastella() {
		return configuracioDocsEntradaNomCastella;
	}

	public void setConfiguracioDocsEntradaNomCastella(String configuracioDocsEntradaNomCastella) {
		this.configuracioDocsEntradaNomCastella = configuracioDocsEntradaNomCastella;
	}

	public DocsEntradaRDTO dataCreacio(DateTime dataCreacio) {
		this.dataCreacio = dataCreacio;
		return this;
	}

	/**
	 * Get dataCreacio
	 * 
	 * @return dataCreacio
	 **/
	@ApiModelProperty(value = "")
	public DateTime getDataCreacio() {
		return dataCreacio;
	}

	public void setDataCreacio(DateTime dataCreacio) {
		this.dataCreacio = dataCreacio;
	}

	public DocsEntradaRDTO dataDigitalitzacio(DateTime dataDigitalitzacio) {
		this.dataDigitalitzacio = dataDigitalitzacio;
		return this;
	}

	/**
	 * Get dataDigitalitzacio
	 * 
	 * @return dataDigitalitzacio
	 **/
	@ApiModelProperty(value = "")
	public DateTime getDataDigitalitzacio() {
		return dataDigitalitzacio;
	}

	public void setDataDigitalitzacio(DateTime dataDigitalitzacio) {
		this.dataDigitalitzacio = dataDigitalitzacio;
	}

	public DocsEntradaRDTO dataPresentacio(DateTime dataPresentacio) {
		this.dataPresentacio = dataPresentacio;
		return this;
	}

	/**
	 * Get dataPresentacio
	 * 
	 * @return dataPresentacio
	 **/
	@ApiModelProperty(value = "")
	public DateTime getDataPresentacio() {
		return dataPresentacio;
	}

	public void setDataPresentacio(DateTime dataPresentacio) {
		this.dataPresentacio = dataPresentacio;
	}

	public DocsEntradaRDTO dataUltimaModificacio(DateTime dataUltimaModificacio) {
		this.dataUltimaModificacio = dataUltimaModificacio;
		return this;
	}

	/**
	 * Get dataUltimaModificacio
	 * 
	 * @return dataUltimaModificacio
	 **/
	@ApiModelProperty(value = "")
	public DateTime getDataUltimaModificacio() {
		return dataUltimaModificacio;
	}

	public void setDataUltimaModificacio(DateTime dataUltimaModificacio) {
		this.dataUltimaModificacio = dataUltimaModificacio;
	}

	public DocsEntradaRDTO declaracioResponsable(Integer declaracioResponsable) {
		this.declaracioResponsable = declaracioResponsable;
		return this;
	}

	/**
	 * Get declaracioResponsable
	 * 
	 * @return declaracioResponsable
	 **/
	@ApiModelProperty(value = "")
	public Integer getDeclaracioResponsable() {
		return declaracioResponsable;
	}

	public void setDeclaracioResponsable(Integer declaracioResponsable) {
		this.declaracioResponsable = declaracioResponsable;
	}

	public DocsEntradaRDTO digitalitzat(Integer digitalitzat) {
		this.digitalitzat = digitalitzat;
		return this;
	}

	/**
	 * Get digitalitzat
	 * 
	 * @return digitalitzat
	 **/
	@ApiModelProperty(value = "")
	public Integer getDigitalitzat() {
		return digitalitzat;
	}

	public void setDigitalitzat(Integer digitalitzat) {
		this.digitalitzat = digitalitzat;
	}

	public DocsEntradaRDTO docsFisics(DocsFisics docsFisics) {
		this.docsFisics = docsFisics;
		return this;
	}

	/**
	 * Get docsFisics
	 * 
	 * @return docsFisics
	 **/
	@ApiModelProperty(value = "")
	public DocsFisics getDocsFisics() {
		return docsFisics;
	}

	public void setDocsFisics(DocsFisics docsFisics) {
		this.docsFisics = docsFisics;
	}

	public DocsEntradaRDTO docsFisicsNom(String docsFisicsNom) {
		this.docsFisicsNom = docsFisicsNom;
		return this;
	}

	/**
	 * Get docsFisicsNom
	 * 
	 * @return docsFisicsNom
	 **/
	@ApiModelProperty(value = "")
	public String getDocsFisicsNom() {
		return docsFisicsNom;
	}

	public void setDocsFisicsNom(String docsFisicsNom) {
		this.docsFisicsNom = docsFisicsNom;
	}

	public DocsEntradaRDTO docsTercers(Integer docsTercers) {
		this.docsTercers = docsTercers;
		return this;
	}

	/**
	 * Get docsTercers
	 * 
	 * @return docsTercers
	 **/
	@ApiModelProperty(value = "")
	public Integer getDocsTercers() {
		return docsTercers;
	}

	public void setDocsTercers(Integer docsTercers) {
		this.docsTercers = docsTercers;
	}

	public DocsEntradaRDTO documentFisic(BigDecimal documentFisic) {
		this.documentFisic = documentFisic;
		return this;
	}

	/**
	 * Get documentFisic
	 * 
	 * @return documentFisic
	 **/
	@ApiModelProperty(value = "")
	public BigDecimal getDocumentFisic() {
		return documentFisic;
	}

	public void setDocumentFisic(BigDecimal documentFisic) {
		this.documentFisic = documentFisic;
	}

	public DocsEntradaRDTO documentacio(BigDecimal documentacio) {
		this.documentacio = documentacio;
		return this;
	}

	/**
	 * Get documentacio
	 * 
	 * @return documentacio
	 **/
	@ApiModelProperty(value = "")
	public BigDecimal getDocumentacio() {
		return documentacio;
	}

	public void setDocumentacio(BigDecimal documentacio) {
		this.documentacio = documentacio;
	}

	public DocsEntradaRDTO editable(Boolean editable) {
		this.editable = editable;
		return this;
	}

	/**
	 * Get editable
	 * 
	 * @return editable
	 **/
	@ApiModelProperty(value = "")
	public Boolean isEditable() {
		return editable;
	}

	public void setEditable(Boolean editable) {
		this.editable = editable;
	}

	public DocsEntradaRDTO eliminat(Integer eliminat) {
		this.eliminat = eliminat;
		return this;
	}

	/**
	 * Get eliminat
	 * 
	 * @return eliminat
	 **/
	@ApiModelProperty(value = "")
	public Integer getEliminat() {
		return eliminat;
	}

	public void setEliminat(Integer eliminat) {
		this.eliminat = eliminat;
	}

	public DocsEntradaRDTO estatDigitalitzacio(BigDecimal estatDigitalitzacio) {
		this.estatDigitalitzacio = estatDigitalitzacio;
		return this;
	}

	/**
	 * Get estatDigitalitzacio
	 * 
	 * @return estatDigitalitzacio
	 **/
	@ApiModelProperty(value = "")
	public BigDecimal getEstatDigitalitzacio() {
		return estatDigitalitzacio;
	}

	public void setEstatDigitalitzacio(BigDecimal estatDigitalitzacio) {
		this.estatDigitalitzacio = estatDigitalitzacio;
	}

	public DocsEntradaRDTO id(BigDecimal id) {
		this.id = id;
		return this;
	}

	/**
	 * Get id
	 * 
	 * @return id
	 **/
	@ApiModelProperty(value = "")
	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public DocsEntradaRDTO idIdiomaPlantilla(BigDecimal idIdiomaPlantilla) {
		this.idIdiomaPlantilla = idIdiomaPlantilla;
		return this;
	}

	/**
	 * Get idIdiomaPlantilla
	 * 
	 * @return idIdiomaPlantilla
	 **/
	@ApiModelProperty(value = "")
	public BigDecimal getIdIdiomaPlantilla() {
		return idIdiomaPlantilla;
	}

	public void setIdIdiomaPlantilla(BigDecimal idIdiomaPlantilla) {
		this.idIdiomaPlantilla = idIdiomaPlantilla;
	}

	public DocsEntradaRDTO idioma(BigDecimal idioma) {
		this.idioma = idioma;
		return this;
	}

	/**
	 * Get idioma
	 * 
	 * @return idioma
	 **/
	@ApiModelProperty(value = "")
	public BigDecimal getIdioma() {
		return idioma;
	}

	public void setIdioma(BigDecimal idioma) {
		this.idioma = idioma;
	}

	public DocsEntradaRDTO idiomaDigitalitzacio(BigDecimal idiomaDigitalitzacio) {
		this.idiomaDigitalitzacio = idiomaDigitalitzacio;
		return this;
	}

	/**
	 * Get idiomaDigitalitzacio
	 * 
	 * @return idiomaDigitalitzacio
	 **/
	@ApiModelProperty(value = "")
	public BigDecimal getIdiomaDigitalitzacio() {
		return idiomaDigitalitzacio;
	}

	public void setIdiomaDigitalitzacio(BigDecimal idiomaDigitalitzacio) {
		this.idiomaDigitalitzacio = idiomaDigitalitzacio;
	}

	public DocsEntradaRDTO metadata(Map<String, List<String>> metadata) {
		this.metadata = metadata;
		return this;
	}

	public DocsEntradaRDTO putMetadataItem(String key, List<String> metadataItem) {
		if (this.metadata == null) {
			this.metadata = new HashMap<String, List<String>>();
		}
		this.metadata.put(key, metadataItem);
		return this;
	}

	/**
	 * Get metadata
	 * 
	 * @return metadata
	 **/
	@ApiModelProperty(value = "")
	public Map<String, List<String>> getMetadata() {
		return metadata;
	}

	public void setMetadata(Map<String, List<String>> metadata) {
		this.metadata = metadata;
	}

	public DocsEntradaRDTO migracioIdOrigen(String migracioIdOrigen) {
		this.migracioIdOrigen = migracioIdOrigen;
		return this;
	}

	/**
	 * Get migracioIdOrigen
	 * 
	 * @return migracioIdOrigen
	 **/
	@ApiModelProperty(value = "")
	public String getMigracioIdOrigen() {
		return migracioIdOrigen;
	}

	public void setMigracioIdOrigen(String migracioIdOrigen) {
		this.migracioIdOrigen = migracioIdOrigen;
	}

	public DocsEntradaRDTO nou(Integer nou) {
		this.nou = nou;
		return this;
	}

	/**
	 * Get nou
	 * 
	 * @return nou
	 **/
	@ApiModelProperty(value = "")
	public Integer getNou() {
		return nou;
	}

	public void setNou(Integer nou) {
		this.nou = nou;
	}

	public DocsEntradaRDTO numDocsConfiguracio(BigDecimal numDocsConfiguracio) {
		this.numDocsConfiguracio = numDocsConfiguracio;
		return this;
	}

	/**
	 * Get numDocsConfiguracio
	 * 
	 * @return numDocsConfiguracio
	 **/
	@ApiModelProperty(value = "")
	public BigDecimal getNumDocsConfiguracio() {
		return numDocsConfiguracio;
	}

	public void setNumDocsConfiguracio(BigDecimal numDocsConfiguracio) {
		this.numDocsConfiguracio = numDocsConfiguracio;
	}

	public DocsEntradaRDTO obligatoriEnEstat(Boolean obligatoriEnEstat) {
		this.obligatoriEnEstat = obligatoriEnEstat;
		return this;
	}

	/**
	 * Get obligatoriEnEstat
	 * 
	 * @return obligatoriEnEstat
	 **/
	@ApiModelProperty(value = "")
	public Boolean isObligatoriEnEstat() {
		return obligatoriEnEstat;
	}

	public void setObligatoriEnEstat(Boolean obligatoriEnEstat) {
		this.obligatoriEnEstat = obligatoriEnEstat;
	}

	public DocsEntradaRDTO origen(Integer origen) {
		this.origen = origen;
		return this;
	}

	/**
	 * Get origen
	 * 
	 * @return origen
	 **/
	@ApiModelProperty(value = "")
	public Integer getOrigen() {
		return origen;
	}

	public void setOrigen(Integer origen) {
		this.origen = origen;
	}

	public DocsEntradaRDTO plantillaPdf(Boolean plantillaPdf) {
		this.plantillaPdf = plantillaPdf;
		return this;
	}

	/**
	 * Get plantillaPdf
	 * 
	 * @return plantillaPdf
	 **/
	@ApiModelProperty(value = "")
	public Boolean isPlantillaPdf() {
		return plantillaPdf;
	}

	public void setPlantillaPdf(Boolean plantillaPdf) {
		this.plantillaPdf = plantillaPdf;
	}

	public DocsEntradaRDTO registreAssentament(RegistreAssentament registreAssentament) {
		this.registreAssentament = registreAssentament;
		return this;
	}

	/**
	 * Get registreAssentament
	 * 
	 * @return registreAssentament
	 **/
	@ApiModelProperty(value = "")
	public RegistreAssentament getRegistreAssentament() {
		return registreAssentament;
	}

	public void setRegistreAssentament(RegistreAssentament registreAssentament) {
		this.registreAssentament = registreAssentament;
	}

	public DocsEntradaRDTO registreCodi(String registreCodi) {
		this.registreCodi = registreCodi;
		return this;
	}

	/**
	 * Get registreCodi
	 * 
	 * @return registreCodi
	 **/
	@ApiModelProperty(value = "")
	public String getRegistreCodi() {
		return registreCodi;
	}

	public void setRegistreCodi(String registreCodi) {
		this.registreCodi = registreCodi;
	}

	public DocsEntradaRDTO registreIdext(BigDecimal registreIdext) {
		this.registreIdext = registreIdext;
		return this;
	}

	/**
	 * Get registreIdext
	 * 
	 * @return registreIdext
	 **/
	@ApiModelProperty(value = "")
	public BigDecimal getRegistreIdext() {
		return registreIdext;
	}

	public void setRegistreIdext(BigDecimal registreIdext) {
		this.registreIdext = registreIdext;
	}

	public DocsEntradaRDTO requerit(Boolean requerit) {
		this.requerit = requerit;
		return this;
	}

	/**
	 * Get requerit
	 * 
	 * @return requerit
	 **/
	@ApiModelProperty(value = "")
	public Boolean isRequerit() {
		return requerit;
	}

	public void setRequerit(Boolean requerit) {
		this.requerit = requerit;
	}

	public DocsEntradaRDTO revisio(Integer revisio) {
		this.revisio = revisio;
		return this;
	}

	/**
	 * Get revisio
	 * 
	 * @return revisio
	 **/
	@ApiModelProperty(value = "")
	public Integer getRevisio() {
		return revisio;
	}

	public void setRevisio(Integer revisio) {
		this.revisio = revisio;
	}

	public DocsEntradaRDTO seleccionable(Boolean seleccionable) {
		this.seleccionable = seleccionable;
		return this;
	}

	/**
	 * Get seleccionable
	 * 
	 * @return seleccionable
	 **/
	@ApiModelProperty(value = "")
	public Boolean isSeleccionable() {
		return seleccionable;
	}

	public void setSeleccionable(Boolean seleccionable) {
		this.seleccionable = seleccionable;
	}

	public DocsEntradaRDTO sollicitudIdext(BigDecimal sollicitudIdext) {
		this.sollicitudIdext = sollicitudIdext;
		return this;
	}

	public DocsEntradaRDTO tipusMimeDescripcio(String tipusMimeDescripcio) {
		this.tipusMimeDescripcio = tipusMimeDescripcio;
		return this;
	}

	/**
	 * Get tipusMimeDescripcio
	 * 
	 * @return tipusMimeDescripcio
	 **/
	@ApiModelProperty(value = "")
	public String getTipusMimeDescripcio() {
		return tipusMimeDescripcio;
	}

	public void setTipusMimeDescripcio(String tipusMimeDescripcio) {
		this.tipusMimeDescripcio = tipusMimeDescripcio;
	}

	public DocsEntradaRDTO tramitOvtIdext(BigDecimal tramitOvtIdext) {
		this.tramitOvtIdext = tramitOvtIdext;
		return this;
	}

	/**
	 * Get tramitOvtIdext
	 * 
	 * @return tramitOvtIdext
	 **/
	@ApiModelProperty(value = "")
	public BigDecimal getTramitOvtIdext() {
		return tramitOvtIdext;
	}

	public void setTramitOvtIdext(BigDecimal tramitOvtIdext) {
		this.tramitOvtIdext = tramitOvtIdext;
	}

	public DocsEntradaRDTO ultimaModificacioIdext(BigDecimal ultimaModificacioIdext) {
		this.ultimaModificacioIdext = ultimaModificacioIdext;
		return this;
	}

	/**
	 * Get ultimaModificacioIdext
	 * 
	 * @return ultimaModificacioIdext
	 **/
	@ApiModelProperty(value = "")
	public BigDecimal getUltimaModificacioIdext() {
		return ultimaModificacioIdext;
	}

	public void setUltimaModificacioIdext(BigDecimal ultimaModificacioIdext) {
		this.ultimaModificacioIdext = ultimaModificacioIdext;
	}

	public DocsEntradaRDTO urlDigitalitzacio(String urlDigitalitzacio) {
		this.urlDigitalitzacio = urlDigitalitzacio;
		return this;
	}

	/**
	 * Get urlDigitalitzacio
	 * 
	 * @return urlDigitalitzacio
	 **/
	@ApiModelProperty(value = "")
	public String getUrlDigitalitzacio() {
		return urlDigitalitzacio;
	}

	public void setUrlDigitalitzacio(String urlDigitalitzacio) {
		this.urlDigitalitzacio = urlDigitalitzacio;
	}

	public DocsEntradaRDTO usuariIdext(BigDecimal usuariIdext) {
		this.usuariIdext = usuariIdext;
		return this;
	}

	/**
	 * Get usuariIdext
	 * 
	 * @return usuariIdext
	 **/
	@ApiModelProperty(value = "")
	public BigDecimal getUsuariIdext() {
		return usuariIdext;
	}

	public void setUsuariIdext(BigDecimal usuariIdext) {
		this.usuariIdext = usuariIdext;
	}

	@ApiModelProperty(value = "")
	public BigDecimal getSollicitudIdext() {
		return sollicitudIdext;
	}

	public void setSollicitudIdext(BigDecimal sollicitudIdext) {
		this.sollicitudIdext = sollicitudIdext;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		DocsEntradaRDTO docsEntradaRDTO = (DocsEntradaRDTO) o;
		return Objects.equals(this.codi, docsEntradaRDTO.codi) && Objects.equals(this.comentari, docsEntradaRDTO.comentari)
		        && Objects.equals(this.configDocEntrada, docsEntradaRDTO.configDocEntrada)
		        && Objects.equals(this.configuracioDocsEntrada, docsEntradaRDTO.configuracioDocsEntrada)
		        && Objects.equals(this.configuracioDocsEntradaId, docsEntradaRDTO.configuracioDocsEntradaId)
		        && Objects.equals(this.configuracioDocsEntradaNom, docsEntradaRDTO.configuracioDocsEntradaNom)
		        && Objects.equals(this.configuracioDocsEntradaNomCastella, docsEntradaRDTO.configuracioDocsEntradaNomCastella)
		        && Objects.equals(this.dataCreacio, docsEntradaRDTO.dataCreacio)
		        && Objects.equals(this.dataDigitalitzacio, docsEntradaRDTO.dataDigitalitzacio)
		        && Objects.equals(this.dataPresentacio, docsEntradaRDTO.dataPresentacio)
		        && Objects.equals(this.dataUltimaModificacio, docsEntradaRDTO.dataUltimaModificacio)
		        && Objects.equals(this.declaracioResponsable, docsEntradaRDTO.declaracioResponsable)
		        && Objects.equals(this.digitalitzat, docsEntradaRDTO.digitalitzat)
		        && Objects.equals(this.docsFisics, docsEntradaRDTO.docsFisics)
		        && Objects.equals(this.docsFisicsNom, docsEntradaRDTO.docsFisicsNom)
		        && Objects.equals(this.docsTercers, docsEntradaRDTO.docsTercers)
		        && Objects.equals(this.documentFisic, docsEntradaRDTO.documentFisic)
		        && Objects.equals(this.documentacio, docsEntradaRDTO.documentacio)
		        && Objects.equals(this.editable, docsEntradaRDTO.editable) && Objects.equals(this.eliminat, docsEntradaRDTO.eliminat)
		        && Objects.equals(this.estatDigitalitzacio, docsEntradaRDTO.estatDigitalitzacio)
		        && Objects.equals(this.id, docsEntradaRDTO.id) && Objects.equals(this.idIdiomaPlantilla, docsEntradaRDTO.idIdiomaPlantilla)
		        && Objects.equals(this.idioma, docsEntradaRDTO.idioma)
		        && Objects.equals(this.idiomaDigitalitzacio, docsEntradaRDTO.idiomaDigitalitzacio)
		        && Objects.equals(this.metadata, docsEntradaRDTO.metadata)
		        && Objects.equals(this.migracioIdOrigen, docsEntradaRDTO.migracioIdOrigen) && Objects.equals(this.nou, docsEntradaRDTO.nou)
		        && Objects.equals(this.numDocsConfiguracio, docsEntradaRDTO.numDocsConfiguracio)
		        && Objects.equals(this.obligatoriEnEstat, docsEntradaRDTO.obligatoriEnEstat)
		        && Objects.equals(this.origen, docsEntradaRDTO.origen) && Objects.equals(this.plantillaPdf, docsEntradaRDTO.plantillaPdf)
		        && Objects.equals(this.registreAssentament, docsEntradaRDTO.registreAssentament)
		        && Objects.equals(this.registreCodi, docsEntradaRDTO.registreCodi)
		        && Objects.equals(this.registreIdext, docsEntradaRDTO.registreIdext)
		        && Objects.equals(this.requerit, docsEntradaRDTO.requerit) && Objects.equals(this.revisio, docsEntradaRDTO.revisio)
		        && Objects.equals(this.seleccionable, docsEntradaRDTO.seleccionable)
		        && Objects.equals(this.sollicitudIdext, docsEntradaRDTO.sollicitudIdext)
		        && Objects.equals(this.tipusMimeDescripcio, docsEntradaRDTO.tipusMimeDescripcio)
		        && Objects.equals(this.tramitOvtIdext, docsEntradaRDTO.tramitOvtIdext)
		        && Objects.equals(this.ultimaModificacioIdext, docsEntradaRDTO.ultimaModificacioIdext)
		        && Objects.equals(this.urlDigitalitzacio, docsEntradaRDTO.urlDigitalitzacio)
		        && Objects.equals(this.usuariIdext, docsEntradaRDTO.usuariIdext)
		        && Objects.equals(this.sollicitudIdext, docsEntradaRDTO.sollicitudIdext);
	}

	@Override
	public int hashCode() {
		return Objects.hash(codi, comentari, configDocEntrada, configuracioDocsEntrada, configuracioDocsEntradaId,
		        configuracioDocsEntradaNom, configuracioDocsEntradaNomCastella, dataCreacio, dataDigitalitzacio, dataPresentacio,
		        dataUltimaModificacio, declaracioResponsable, digitalitzat, docsFisics, docsFisicsNom, docsTercers, documentFisic,
		        documentacio, editable, eliminat, estatDigitalitzacio, id, idIdiomaPlantilla, idioma, idiomaDigitalitzacio, metadata,
		        migracioIdOrigen, nou, numDocsConfiguracio, obligatoriEnEstat, origen, plantillaPdf, registreAssentament, registreCodi,
		        registreIdext, requerit, revisio, seleccionable, sollicitudIdext, tipusMimeDescripcio, tramitOvtIdext,
		        ultimaModificacioIdext, urlDigitalitzacio, usuariIdext);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class DocsEntradaRDTO {\n");

		sb.append("    codi: ").append(toIndentedString(codi)).append("\n");
		sb.append("    comentari: ").append(toIndentedString(comentari)).append("\n");
		sb.append("    configDocEntrada: ").append(toIndentedString(configDocEntrada)).append("\n");
		sb.append("    configuracioDocsEntrada: ").append(toIndentedString(configuracioDocsEntrada)).append("\n");
		sb.append("    configuracioDocsEntradaId: ").append(toIndentedString(configuracioDocsEntradaId)).append("\n");
		sb.append("    configuracioDocsEntradaNom: ").append(toIndentedString(configuracioDocsEntradaNom)).append("\n");
		sb.append("    configuracioDocsEntradaNomCastella: ").append(toIndentedString(configuracioDocsEntradaNomCastella)).append("\n");
		sb.append("    dataCreacio: ").append(toIndentedString(dataCreacio)).append("\n");
		sb.append("    dataDigitalitzacio: ").append(toIndentedString(dataDigitalitzacio)).append("\n");
		sb.append("    dataPresentacio: ").append(toIndentedString(dataPresentacio)).append("\n");
		sb.append("    dataUltimaModificacio: ").append(toIndentedString(dataUltimaModificacio)).append("\n");
		sb.append("    declaracioResponsable: ").append(toIndentedString(declaracioResponsable)).append("\n");
		sb.append("    digitalitzat: ").append(toIndentedString(digitalitzat)).append("\n");
		sb.append("    docsFisics: ").append(toIndentedString(docsFisics)).append("\n");
		sb.append("    docsFisicsNom: ").append(toIndentedString(docsFisicsNom)).append("\n");
		sb.append("    docsTercers: ").append(toIndentedString(docsTercers)).append("\n");
		sb.append("    documentFisic: ").append(toIndentedString(documentFisic)).append("\n");
		sb.append("    documentacio: ").append(toIndentedString(documentacio)).append("\n");
		sb.append("    editable: ").append(toIndentedString(editable)).append("\n");
		sb.append("    eliminat: ").append(toIndentedString(eliminat)).append("\n");
		sb.append("    estatDigitalitzacio: ").append(toIndentedString(estatDigitalitzacio)).append("\n");
		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    idIdiomaPlantilla: ").append(toIndentedString(idIdiomaPlantilla)).append("\n");
		sb.append("    idioma: ").append(toIndentedString(idioma)).append("\n");
		sb.append("    idiomaDigitalitzacio: ").append(toIndentedString(idiomaDigitalitzacio)).append("\n");
		sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
		sb.append("    migracioIdOrigen: ").append(toIndentedString(migracioIdOrigen)).append("\n");
		sb.append("    nou: ").append(toIndentedString(nou)).append("\n");
		sb.append("    numDocsConfiguracio: ").append(toIndentedString(numDocsConfiguracio)).append("\n");
		sb.append("    obligatoriEnEstat: ").append(toIndentedString(obligatoriEnEstat)).append("\n");
		sb.append("    origen: ").append(toIndentedString(origen)).append("\n");
		sb.append("    plantillaPdf: ").append(toIndentedString(plantillaPdf)).append("\n");
		sb.append("    registreAssentament: ").append(toIndentedString(registreAssentament)).append("\n");
		sb.append("    registreCodi: ").append(toIndentedString(registreCodi)).append("\n");
		sb.append("    registreIdext: ").append(toIndentedString(registreIdext)).append("\n");
		sb.append("    requerit: ").append(toIndentedString(requerit)).append("\n");
		sb.append("    revisio: ").append(toIndentedString(revisio)).append("\n");
		sb.append("    seleccionable: ").append(toIndentedString(seleccionable)).append("\n");
		sb.append("    sollicitudIdext: ").append(toIndentedString(sollicitudIdext)).append("\n");
		sb.append("    tipusMimeDescripcio: ").append(toIndentedString(tipusMimeDescripcio)).append("\n");
		sb.append("    tramitOvtIdext: ").append(toIndentedString(tramitOvtIdext)).append("\n");
		sb.append("    ultimaModificacioIdext: ").append(toIndentedString(ultimaModificacioIdext)).append("\n");
		sb.append("    urlDigitalitzacio: ").append(toIndentedString(urlDigitalitzacio)).append("\n");
		sb.append("    usuariIdext: ").append(toIndentedString(usuariIdext)).append("\n");
		sb.append("    sollicitudIdext: ").append(toIndentedString(sollicitudIdext)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}

}
