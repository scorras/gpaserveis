package es.bcn.gpa.gpaserveis.business.dto.documents;

import java.math.BigDecimal;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsEntradaRDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CrearDocumentEntradaBDTO {

	/** The id expedient. */
	private BigDecimal idExpedient;

	/** The docs entrada RDTO. */
	private DocsEntradaRDTO docsEntradaRDTO;

}
