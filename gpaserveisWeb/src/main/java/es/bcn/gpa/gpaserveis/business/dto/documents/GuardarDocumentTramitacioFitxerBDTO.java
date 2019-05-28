package es.bcn.gpa.gpaserveis.business.dto.documents;

import java.math.BigDecimal;

import org.springframework.web.multipart.MultipartFile;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsTramitacioRDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GuardarDocumentTramitacioFitxerBDTO {

	/** The id expedient. */
	private BigDecimal idExpedient;

	/** The docs tramitacio RDTO. */
	private DocsTramitacioRDTO docsTramitacioRDTO;

	/** The file. */
	private MultipartFile file;

}
