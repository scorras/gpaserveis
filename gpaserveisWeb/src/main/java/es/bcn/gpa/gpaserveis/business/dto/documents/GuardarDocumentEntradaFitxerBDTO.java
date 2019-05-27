package es.bcn.gpa.gpaserveis.business.dto.documents;

import java.math.BigDecimal;

import org.springframework.web.multipart.MultipartFile;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsEntradaRDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GuardarDocumentEntradaFitxerBDTO {

	/** The id expedient. */
	private BigDecimal idExpedient;

	/** The docs entrada RDTO. */
	private DocsEntradaRDTO docsEntradaRDTO;

	/** The file. */
	private MultipartFile file;

}
