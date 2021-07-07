package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.sollicituds;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import es.bcn.gpa.gpaserveis.business.xml.bind.adapted.DadesAtributsSollicitudsValorAdapted;
import es.bcn.gpa.gpaserveis.business.xml.bind.adapter.DadesAtributsSollicitudsValorAdapter;
import es.bcn.gpa.gpaserveis.web.rest.dto.json.JsonDadesAtributsSollicitudsSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "AtributsSollicitud")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "codi", "titol", "index", "valor", "valorCastella", "valorsLlista", "valorsLlistaRepetible", "valorsLlistaMultipleRepetible", "valorRepetible"})
@JsonSerialize(using = JsonDadesAtributsSollicitudsSerializer.class)
@XmlRootElement(name = "DADA_OPERACIO")
@XmlType(name = "DadesAtributsSollicituds", propOrder = { "codi", "titol", "index", "valorAdapted", "valorCastella", "valorsLlista", "valorsLlistaRepetible", "valorsLlistaMultipleRepetible", "valorRepetibleAdapted"})
@XmlAccessorType(XmlAccessType.NONE)
@Getter
@Setter
public class DadesAtributsSollicitudsRDTO {

	@ApiModelProperty(value = "Codi de l'atribut")
	@XmlElement(name = "CODI", required = true, type = String.class)
	private String codi;
	@ApiModelProperty(value = "Codi del valor de la llista")
	@XmlElement(name = "INDEX", required = false, type = String.class)
	private String index;
	@ApiModelProperty(value = "Llista de valors de l'atribut")
	@XmlTransient
	private List<String> valor;

	@JsonIgnore
	@XmlElement(name = "VALORS")
	@XmlJavaTypeAdapter(DadesAtributsSollicitudsValorAdapter.class)
	public DadesAtributsSollicitudsValorAdapted getValorAdapted() {
		DadesAtributsSollicitudsValorAdapted valorAdapted = new DadesAtributsSollicitudsValorAdapted();
		valorAdapted.setCodi(codi);
		valorAdapted.setValor(valor);
		valorAdapted.setValorRepetible(false);
		return valorAdapted;
	}

	@ApiModelProperty(value = "Llista de valors de l'atribut en castellà")
	@XmlElementWrapper(name = "VALORS_CASTELLA")
	@XmlElement(name = "VALOR_CASTELLA")
	private List<String> valorCastella;
	@ApiModelProperty(value = "Si el tipus de camp de l'atribut és llista múltiple, valors d'aquesta llista")
	@XmlElement(name = "VALOR_LLISTA")
	private List<DadesAtributsValorsLlistaSollicitudsRDTO> valorsLlista;
	@ApiModelProperty(value = "Si el tipus de camp de l'atribut és llesta repetible, valors d'aquesta llista")
	@XmlElement(name = "VALOR_LLISTA_REPETIBLE")
	private List<DadesAtributsValorsLlistaRepetibleSollicitudsRDTO> valorsLlistaRepetible;
	@ApiModelProperty(value = "Si el tipus de camp de l'atribut és llesta múltiple repetible, valors d'aquesta llista")
	@XmlElement(name = "VALOR_LLISTA_REPETIBLE")
	private List<DadesAtributsValorsLlistaMultipleRepetibleSollicitudsRDTO> valorsLlistaMultipleRepetible;
	
	@XmlTransient
	private List<String> valorRepetible;
	
	@JsonIgnore
	@XmlElement(name = "VALORS")
	@XmlJavaTypeAdapter(DadesAtributsSollicitudsValorAdapter.class)
	public DadesAtributsSollicitudsValorAdapted getValorRepetibleAdapted() {
		DadesAtributsSollicitudsValorAdapted valorRepetibleAdapted = new DadesAtributsSollicitudsValorAdapted();
		valorRepetibleAdapted.setCodi(codi);
		valorRepetibleAdapted.setValor(valorRepetible);
		valorRepetibleAdapted.setValorRepetible(true);
		
		return valorRepetibleAdapted;
	}
	
	@ApiModelProperty(value = "Titol de l'atribut")
	@XmlElement(name = "TITOL", required = false, type = String.class)
	private String titol;

}
