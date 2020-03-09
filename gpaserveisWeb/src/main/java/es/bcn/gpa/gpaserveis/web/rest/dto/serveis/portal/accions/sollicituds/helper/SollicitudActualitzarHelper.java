package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.sollicituds.helper;

import java.util.ArrayList;
import java.util.List;

import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.PersonesRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.sollicituds.actualitzar.SollicitudActualitzarRDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SollicitudActualitzarHelper {

	private SollicitudActualitzarRDTO sollicitudActualitzarRDTO;

	private List<PersonesRDTO> personesSollicitud;

	public SollicitudActualitzarHelper(SollicitudActualitzarRDTO sollicitudActualitzarRDTO) {
		super();
		this.sollicitudActualitzarRDTO = sollicitudActualitzarRDTO;
		this.personesSollicitud = new ArrayList<>();
		this.personesSollicitud.add(sollicitudActualitzarRDTO.getSollicitant());
		if (sollicitudActualitzarRDTO.getRepresentant() != null) {
			this.personesSollicitud.add(sollicitudActualitzarRDTO.getRepresentant());
		}

	}

}
