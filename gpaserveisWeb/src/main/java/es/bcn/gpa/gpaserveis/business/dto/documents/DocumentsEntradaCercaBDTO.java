package es.bcn.gpa.gpaserveis.business.dto.documents;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DocumentsEntradaCercaBDTO {

	/** The id configuracio documentacio. */
	private BigDecimal idConfiguracioDocumentacio;

	/** The id tramit ovt. */
	private BigDecimal idTramitOvt;

}
