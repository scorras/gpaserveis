package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.sollicituds.helper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.PersonesRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.sollicituds.crear.SollicitudCrearRDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SollicitudCrearHelper {

	private SollicitudCrearRDTO sollicitudCrearRDTO;

	private List<PersonesRDTO> personesSollicitud;

	private BigDecimal idTramitsOvt;

	private BigDecimal idExpedient;

	public SollicitudCrearHelper(SollicitudCrearRDTO sollicitudCrearRDTO, BigDecimal idTramitOvt, BigDecimal idExpedient) {
		super();
		this.idExpedient = idExpedient;
		this.idTramitsOvt = idTramitOvt;
		this.sollicitudCrearRDTO = sollicitudCrearRDTO;
		this.personesSollicitud = new ArrayList<>();
		this.personesSollicitud.add(sollicitudCrearRDTO.getSollicitant());
		if (sollicitudCrearRDTO.getRepresentant() != null){
			this.personesSollicitud.add(sollicitudCrearRDTO.getRepresentant());
		}

	}

}
