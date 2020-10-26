package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.signar;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * The Class PreparacioSignaturaCriptograficaDocumentMassiuRDTO.
 */
@ApiModel(value = "PreparacioSignaturaCriptograficaDocumentMassiu")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "documents", "urlRetorn" })
@Getter
@Setter
public class PreparacioSignaturaCriptograficaDocumentMassiuRDTO {

	/** The documents. */
	@ApiModelProperty(value = "Informació sobre la llista de documents a signar")
	private List<PreparacioSignaturaCriptograficaDocumentRDTO> documents;

	/** The url retorn. */
	@ApiModelProperty(value = "URL de redirecció per a l'execució de la signatura criptogràfica online a client")
	private String urlRetorn;

}
