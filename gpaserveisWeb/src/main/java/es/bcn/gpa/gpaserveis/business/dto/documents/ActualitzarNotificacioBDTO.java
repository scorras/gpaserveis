package es.bcn.gpa.gpaserveis.business.dto.documents;

import java.math.BigDecimal;

import org.joda.time.DateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ActualitzarNotificacioBDTO {

	/** The notificacio id. */
	private BigDecimal notificacioId;

	/** The estat. */
	private String estat;

	/** The num registre. */
	private String numRegistre;

	/** The codi error. */
	private Integer codiError;

	/** The descripcio error. */
	private String descripcioError;

	/** The data hora registre. */
	private DateTime dataHoraRegistre;

	/** The data hora diposit. */
	private DateTime dataHoraDiposit;

	/** The data hora visualitzacio. */
	private DateTime dataHoraVisualitzacio;

	/** The data hora aceptacio rebuig. */
	private DateTime dataHoraAceptacioRebuig;

	/** The data limit. */
	private DateTime dataLimit;

	/** The data enviament. */
	private DateTime dataEnviament;

	/** The data acusament rebuda. */
	private DateTime dataAcusamentRebuda;

}
