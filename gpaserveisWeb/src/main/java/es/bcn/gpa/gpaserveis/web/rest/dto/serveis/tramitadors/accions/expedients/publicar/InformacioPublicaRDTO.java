package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.publicar;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "InformacioPublica")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "codi", "comentaris", "documents" })
@Getter
@Setter
public class InformacioPublicaRDTO {

	@ApiModelProperty("Codi identificador de l'expedient")
	private String codi;

	@ApiModelProperty(value = "Llista de comentaris per a informació pública")
	private List<ComentariPerAInformacioPublicaRDTO> comentaris;

	@ApiModelProperty(value = "Llista de documents per a informació pública")
	private List<DocumentPerAInformacioPublicaRDTO> documents;
}
