/*
 * API gpadocumentacio
 * API gpadocumentacio
 *
 * OpenAPI spec version: 1.6.0
 * Contact: sergio.corras@iecisa.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.ConfiguracioDocsEntrada;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsFisics;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.RegistreAssentament;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.joda.time.DateTime;

/**
 * DocsEntradaRDTO
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-03-18T10:38:37.495+01:00")
public class DocsEntradaRDTO {
  @JsonProperty("comentari")
  private String comentari = null;

  @JsonProperty("configDocEntrada")
  private BigDecimal configDocEntrada = null;

  @JsonProperty("configuracioDocsEntrada")
  private ConfiguracioDocsEntrada configuracioDocsEntrada = null;

  @JsonProperty("configuracioDocsEntradaNom")
  private String configuracioDocsEntradaNom = null;

  @JsonProperty("dataCreacio")
  private DateTime dataCreacio = null;

  @JsonProperty("dataDigitalitzacio")
  private DateTime dataDigitalitzacio = null;

  @JsonProperty("dataPresentacio")
  private DateTime dataPresentacio = null;

  @JsonProperty("dataUltimaModificacio")
  private DateTime dataUltimaModificacio = null;

  @JsonProperty("digitalitzat")
  private Integer digitalitzat = null;

  @JsonProperty("docsFisics")
  private DocsFisics docsFisics = null;

  @JsonProperty("docsFisicsNom")
  private String docsFisicsNom = null;

  @JsonProperty("documentFisic")
  private BigDecimal documentFisic = null;

  @JsonProperty("documentacio")
  private BigDecimal documentacio = null;

  @JsonProperty("editable")
  private Boolean editable = null;

  @JsonProperty("eliminat")
  private Integer eliminat = null;

  @JsonProperty("fileToUploadContent")
  private String fileToUploadContent = null;

  @JsonProperty("fileToUploadName")
  private String fileToUploadName = null;

  @JsonProperty("fileToUploadPath")
  private String fileToUploadPath = null;

  @JsonProperty("fileToUploadSize")
  private Long fileToUploadSize = null;

  @JsonProperty("fileToUploadTipus")
  private Integer fileToUploadTipus = null;

  @JsonProperty("fileToUploadType")
  private String fileToUploadType = null;

  @JsonProperty("id")
  private BigDecimal id = null;

  @JsonProperty("idioma")
  private BigDecimal idioma = null;

  @JsonProperty("numDocsConfiguracio")
  private BigDecimal numDocsConfiguracio = null;

  @JsonProperty("obligatoriEnEstat")
  private Boolean obligatoriEnEstat = null;

  @JsonProperty("openTextMetadata")
  private Map<String, List<String>> openTextMetadata = null;

  @JsonProperty("origen")
  private Integer origen = null;

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

  @JsonProperty("tipusMimeDescripcio")
  private String tipusMimeDescripcio = null;

  @JsonProperty("tramitOvtIdext")
  private BigDecimal tramitOvtIdext = null;

  @JsonProperty("ultimaModificacioIdext")
  private BigDecimal ultimaModificacioIdext = null;

  @JsonProperty("usuariIdext")
  private BigDecimal usuariIdext = null;

  public DocsEntradaRDTO comentari(String comentari) {
    this.comentari = comentari;
    return this;
  }

   /**
   * Get comentari
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
   * @return configuracioDocsEntrada
  **/
  @ApiModelProperty(value = "")
  public ConfiguracioDocsEntrada getConfiguracioDocsEntrada() {
    return configuracioDocsEntrada;
  }

  public void setConfiguracioDocsEntrada(ConfiguracioDocsEntrada configuracioDocsEntrada) {
    this.configuracioDocsEntrada = configuracioDocsEntrada;
  }

  public DocsEntradaRDTO configuracioDocsEntradaNom(String configuracioDocsEntradaNom) {
    this.configuracioDocsEntradaNom = configuracioDocsEntradaNom;
    return this;
  }

   /**
   * Get configuracioDocsEntradaNom
   * @return configuracioDocsEntradaNom
  **/
  @ApiModelProperty(value = "")
  public String getConfiguracioDocsEntradaNom() {
    return configuracioDocsEntradaNom;
  }

  public void setConfiguracioDocsEntradaNom(String configuracioDocsEntradaNom) {
    this.configuracioDocsEntradaNom = configuracioDocsEntradaNom;
  }

  public DocsEntradaRDTO dataCreacio(DateTime dataCreacio) {
    this.dataCreacio = dataCreacio;
    return this;
  }

   /**
   * Get dataCreacio
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
   * @return dataUltimaModificacio
  **/
  @ApiModelProperty(value = "")
  public DateTime getDataUltimaModificacio() {
    return dataUltimaModificacio;
  }

  public void setDataUltimaModificacio(DateTime dataUltimaModificacio) {
    this.dataUltimaModificacio = dataUltimaModificacio;
  }

  public DocsEntradaRDTO digitalitzat(Integer digitalitzat) {
    this.digitalitzat = digitalitzat;
    return this;
  }

   /**
   * Get digitalitzat
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
   * @return docsFisicsNom
  **/
  @ApiModelProperty(value = "")
  public String getDocsFisicsNom() {
    return docsFisicsNom;
  }

  public void setDocsFisicsNom(String docsFisicsNom) {
    this.docsFisicsNom = docsFisicsNom;
  }

  public DocsEntradaRDTO documentFisic(BigDecimal documentFisic) {
    this.documentFisic = documentFisic;
    return this;
  }

   /**
   * Get documentFisic
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
   * @return eliminat
  **/
  @ApiModelProperty(value = "")
  public Integer getEliminat() {
    return eliminat;
  }

  public void setEliminat(Integer eliminat) {
    this.eliminat = eliminat;
  }

  public DocsEntradaRDTO fileToUploadContent(String fileToUploadContent) {
    this.fileToUploadContent = fileToUploadContent;
    return this;
  }

   /**
   * Get fileToUploadContent
   * @return fileToUploadContent
  **/
  @ApiModelProperty(value = "")
  public String getFileToUploadContent() {
    return fileToUploadContent;
  }

  public void setFileToUploadContent(String fileToUploadContent) {
    this.fileToUploadContent = fileToUploadContent;
  }

  public DocsEntradaRDTO fileToUploadName(String fileToUploadName) {
    this.fileToUploadName = fileToUploadName;
    return this;
  }

   /**
   * Get fileToUploadName
   * @return fileToUploadName
  **/
  @ApiModelProperty(value = "")
  public String getFileToUploadName() {
    return fileToUploadName;
  }

  public void setFileToUploadName(String fileToUploadName) {
    this.fileToUploadName = fileToUploadName;
  }

  public DocsEntradaRDTO fileToUploadPath(String fileToUploadPath) {
    this.fileToUploadPath = fileToUploadPath;
    return this;
  }

   /**
   * Get fileToUploadPath
   * @return fileToUploadPath
  **/
  @ApiModelProperty(value = "")
  public String getFileToUploadPath() {
    return fileToUploadPath;
  }

  public void setFileToUploadPath(String fileToUploadPath) {
    this.fileToUploadPath = fileToUploadPath;
  }

  public DocsEntradaRDTO fileToUploadSize(Long fileToUploadSize) {
    this.fileToUploadSize = fileToUploadSize;
    return this;
  }

   /**
   * Get fileToUploadSize
   * @return fileToUploadSize
  **/
  @ApiModelProperty(value = "")
  public Long getFileToUploadSize() {
    return fileToUploadSize;
  }

  public void setFileToUploadSize(Long fileToUploadSize) {
    this.fileToUploadSize = fileToUploadSize;
  }

  public DocsEntradaRDTO fileToUploadTipus(Integer fileToUploadTipus) {
    this.fileToUploadTipus = fileToUploadTipus;
    return this;
  }

   /**
   * Get fileToUploadTipus
   * @return fileToUploadTipus
  **/
  @ApiModelProperty(value = "")
  public Integer getFileToUploadTipus() {
    return fileToUploadTipus;
  }

  public void setFileToUploadTipus(Integer fileToUploadTipus) {
    this.fileToUploadTipus = fileToUploadTipus;
  }

  public DocsEntradaRDTO fileToUploadType(String fileToUploadType) {
    this.fileToUploadType = fileToUploadType;
    return this;
  }

   /**
   * Get fileToUploadType
   * @return fileToUploadType
  **/
  @ApiModelProperty(value = "")
  public String getFileToUploadType() {
    return fileToUploadType;
  }

  public void setFileToUploadType(String fileToUploadType) {
    this.fileToUploadType = fileToUploadType;
  }

  public DocsEntradaRDTO id(BigDecimal id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getId() {
    return id;
  }

  public void setId(BigDecimal id) {
    this.id = id;
  }

  public DocsEntradaRDTO idioma(BigDecimal idioma) {
    this.idioma = idioma;
    return this;
  }

   /**
   * Get idioma
   * @return idioma
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getIdioma() {
    return idioma;
  }

  public void setIdioma(BigDecimal idioma) {
    this.idioma = idioma;
  }

  public DocsEntradaRDTO numDocsConfiguracio(BigDecimal numDocsConfiguracio) {
    this.numDocsConfiguracio = numDocsConfiguracio;
    return this;
  }

   /**
   * Get numDocsConfiguracio
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
   * @return obligatoriEnEstat
  **/
  @ApiModelProperty(value = "")
  public Boolean isObligatoriEnEstat() {
    return obligatoriEnEstat;
  }

  public void setObligatoriEnEstat(Boolean obligatoriEnEstat) {
    this.obligatoriEnEstat = obligatoriEnEstat;
  }

  public DocsEntradaRDTO openTextMetadata(Map<String, List<String>> openTextMetadata) {
    this.openTextMetadata = openTextMetadata;
    return this;
  }

  public DocsEntradaRDTO putOpenTextMetadataItem(String key, List<String> openTextMetadataItem) {
    if (this.openTextMetadata == null) {
      this.openTextMetadata = new HashMap<String, List<String>>();
    }
    this.openTextMetadata.put(key, openTextMetadataItem);
    return this;
  }

   /**
   * Get openTextMetadata
   * @return openTextMetadata
  **/
  @ApiModelProperty(value = "")
  public Map<String, List<String>> getOpenTextMetadata() {
    return openTextMetadata;
  }

  public void setOpenTextMetadata(Map<String, List<String>> openTextMetadata) {
    this.openTextMetadata = openTextMetadata;
  }

  public DocsEntradaRDTO origen(Integer origen) {
    this.origen = origen;
    return this;
  }

   /**
   * Get origen
   * @return origen
  **/
  @ApiModelProperty(value = "")
  public Integer getOrigen() {
    return origen;
  }

  public void setOrigen(Integer origen) {
    this.origen = origen;
  }

  public DocsEntradaRDTO registreAssentament(RegistreAssentament registreAssentament) {
    this.registreAssentament = registreAssentament;
    return this;
  }

   /**
   * Get registreAssentament
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
   * @return seleccionable
  **/
  @ApiModelProperty(value = "")
  public Boolean isSeleccionable() {
    return seleccionable;
  }

  public void setSeleccionable(Boolean seleccionable) {
    this.seleccionable = seleccionable;
  }

  public DocsEntradaRDTO tipusMimeDescripcio(String tipusMimeDescripcio) {
    this.tipusMimeDescripcio = tipusMimeDescripcio;
    return this;
  }

   /**
   * Get tipusMimeDescripcio
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
   * @return ultimaModificacioIdext
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getUltimaModificacioIdext() {
    return ultimaModificacioIdext;
  }

  public void setUltimaModificacioIdext(BigDecimal ultimaModificacioIdext) {
    this.ultimaModificacioIdext = ultimaModificacioIdext;
  }

  public DocsEntradaRDTO usuariIdext(BigDecimal usuariIdext) {
    this.usuariIdext = usuariIdext;
    return this;
  }

   /**
   * Get usuariIdext
   * @return usuariIdext
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getUsuariIdext() {
    return usuariIdext;
  }

  public void setUsuariIdext(BigDecimal usuariIdext) {
    this.usuariIdext = usuariIdext;
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
    return Objects.equals(this.comentari, docsEntradaRDTO.comentari) &&
        Objects.equals(this.configDocEntrada, docsEntradaRDTO.configDocEntrada) &&
        Objects.equals(this.configuracioDocsEntrada, docsEntradaRDTO.configuracioDocsEntrada) &&
        Objects.equals(this.configuracioDocsEntradaNom, docsEntradaRDTO.configuracioDocsEntradaNom) &&
        Objects.equals(this.dataCreacio, docsEntradaRDTO.dataCreacio) &&
        Objects.equals(this.dataDigitalitzacio, docsEntradaRDTO.dataDigitalitzacio) &&
        Objects.equals(this.dataPresentacio, docsEntradaRDTO.dataPresentacio) &&
        Objects.equals(this.dataUltimaModificacio, docsEntradaRDTO.dataUltimaModificacio) &&
        Objects.equals(this.digitalitzat, docsEntradaRDTO.digitalitzat) &&
        Objects.equals(this.docsFisics, docsEntradaRDTO.docsFisics) &&
        Objects.equals(this.docsFisicsNom, docsEntradaRDTO.docsFisicsNom) &&
        Objects.equals(this.documentFisic, docsEntradaRDTO.documentFisic) &&
        Objects.equals(this.documentacio, docsEntradaRDTO.documentacio) &&
        Objects.equals(this.editable, docsEntradaRDTO.editable) &&
        Objects.equals(this.eliminat, docsEntradaRDTO.eliminat) &&
        Objects.equals(this.fileToUploadContent, docsEntradaRDTO.fileToUploadContent) &&
        Objects.equals(this.fileToUploadName, docsEntradaRDTO.fileToUploadName) &&
        Objects.equals(this.fileToUploadPath, docsEntradaRDTO.fileToUploadPath) &&
        Objects.equals(this.fileToUploadSize, docsEntradaRDTO.fileToUploadSize) &&
        Objects.equals(this.fileToUploadTipus, docsEntradaRDTO.fileToUploadTipus) &&
        Objects.equals(this.fileToUploadType, docsEntradaRDTO.fileToUploadType) &&
        Objects.equals(this.id, docsEntradaRDTO.id) &&
        Objects.equals(this.idioma, docsEntradaRDTO.idioma) &&
        Objects.equals(this.numDocsConfiguracio, docsEntradaRDTO.numDocsConfiguracio) &&
        Objects.equals(this.obligatoriEnEstat, docsEntradaRDTO.obligatoriEnEstat) &&
        Objects.equals(this.openTextMetadata, docsEntradaRDTO.openTextMetadata) &&
        Objects.equals(this.origen, docsEntradaRDTO.origen) &&
        Objects.equals(this.registreAssentament, docsEntradaRDTO.registreAssentament) &&
        Objects.equals(this.registreCodi, docsEntradaRDTO.registreCodi) &&
        Objects.equals(this.registreIdext, docsEntradaRDTO.registreIdext) &&
        Objects.equals(this.requerit, docsEntradaRDTO.requerit) &&
        Objects.equals(this.revisio, docsEntradaRDTO.revisio) &&
        Objects.equals(this.seleccionable, docsEntradaRDTO.seleccionable) &&
        Objects.equals(this.tipusMimeDescripcio, docsEntradaRDTO.tipusMimeDescripcio) &&
        Objects.equals(this.tramitOvtIdext, docsEntradaRDTO.tramitOvtIdext) &&
        Objects.equals(this.ultimaModificacioIdext, docsEntradaRDTO.ultimaModificacioIdext) &&
        Objects.equals(this.usuariIdext, docsEntradaRDTO.usuariIdext);
  }

  @Override
  public int hashCode() {
    return Objects.hash(comentari, configDocEntrada, configuracioDocsEntrada, configuracioDocsEntradaNom, dataCreacio, dataDigitalitzacio, dataPresentacio, dataUltimaModificacio, digitalitzat, docsFisics, docsFisicsNom, documentFisic, documentacio, editable, eliminat, fileToUploadContent, fileToUploadName, fileToUploadPath, fileToUploadSize, fileToUploadTipus, fileToUploadType, id, idioma, numDocsConfiguracio, obligatoriEnEstat, openTextMetadata, origen, registreAssentament, registreCodi, registreIdext, requerit, revisio, seleccionable, tipusMimeDescripcio, tramitOvtIdext, ultimaModificacioIdext, usuariIdext);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DocsEntradaRDTO {\n");
    
    sb.append("    comentari: ").append(toIndentedString(comentari)).append("\n");
    sb.append("    configDocEntrada: ").append(toIndentedString(configDocEntrada)).append("\n");
    sb.append("    configuracioDocsEntrada: ").append(toIndentedString(configuracioDocsEntrada)).append("\n");
    sb.append("    configuracioDocsEntradaNom: ").append(toIndentedString(configuracioDocsEntradaNom)).append("\n");
    sb.append("    dataCreacio: ").append(toIndentedString(dataCreacio)).append("\n");
    sb.append("    dataDigitalitzacio: ").append(toIndentedString(dataDigitalitzacio)).append("\n");
    sb.append("    dataPresentacio: ").append(toIndentedString(dataPresentacio)).append("\n");
    sb.append("    dataUltimaModificacio: ").append(toIndentedString(dataUltimaModificacio)).append("\n");
    sb.append("    digitalitzat: ").append(toIndentedString(digitalitzat)).append("\n");
    sb.append("    docsFisics: ").append(toIndentedString(docsFisics)).append("\n");
    sb.append("    docsFisicsNom: ").append(toIndentedString(docsFisicsNom)).append("\n");
    sb.append("    documentFisic: ").append(toIndentedString(documentFisic)).append("\n");
    sb.append("    documentacio: ").append(toIndentedString(documentacio)).append("\n");
    sb.append("    editable: ").append(toIndentedString(editable)).append("\n");
    sb.append("    eliminat: ").append(toIndentedString(eliminat)).append("\n");
    sb.append("    fileToUploadContent: ").append(toIndentedString(fileToUploadContent)).append("\n");
    sb.append("    fileToUploadName: ").append(toIndentedString(fileToUploadName)).append("\n");
    sb.append("    fileToUploadPath: ").append(toIndentedString(fileToUploadPath)).append("\n");
    sb.append("    fileToUploadSize: ").append(toIndentedString(fileToUploadSize)).append("\n");
    sb.append("    fileToUploadTipus: ").append(toIndentedString(fileToUploadTipus)).append("\n");
    sb.append("    fileToUploadType: ").append(toIndentedString(fileToUploadType)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    idioma: ").append(toIndentedString(idioma)).append("\n");
    sb.append("    numDocsConfiguracio: ").append(toIndentedString(numDocsConfiguracio)).append("\n");
    sb.append("    obligatoriEnEstat: ").append(toIndentedString(obligatoriEnEstat)).append("\n");
    sb.append("    openTextMetadata: ").append(toIndentedString(openTextMetadata)).append("\n");
    sb.append("    origen: ").append(toIndentedString(origen)).append("\n");
    sb.append("    registreAssentament: ").append(toIndentedString(registreAssentament)).append("\n");
    sb.append("    registreCodi: ").append(toIndentedString(registreCodi)).append("\n");
    sb.append("    registreIdext: ").append(toIndentedString(registreIdext)).append("\n");
    sb.append("    requerit: ").append(toIndentedString(requerit)).append("\n");
    sb.append("    revisio: ").append(toIndentedString(revisio)).append("\n");
    sb.append("    seleccionable: ").append(toIndentedString(seleccionable)).append("\n");
    sb.append("    tipusMimeDescripcio: ").append(toIndentedString(tipusMimeDescripcio)).append("\n");
    sb.append("    tramitOvtIdext: ").append(toIndentedString(tramitOvtIdext)).append("\n");
    sb.append("    ultimaModificacioIdext: ").append(toIndentedString(ultimaModificacioIdext)).append("\n");
    sb.append("    usuariIdext: ").append(toIndentedString(usuariIdext)).append("\n");
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

