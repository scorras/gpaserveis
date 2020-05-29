package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.signar;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

/**
 * The Class SignaturaSegellDocumentRDTO.
 */
@ApiModel(value = "SignaturaSegellDocument", parent = SignaturaDocumentRDTO.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({})
@Getter
@Setter
public class SignaturaSegellDocumentRDTO extends SignaturaDocumentRDTO {

}
