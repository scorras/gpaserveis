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

	private BigDecimal unitatGestoraId;

	public SollicitudCrearHelper(SollicitudCrearRDTO sollicitudCrearRDTO, BigDecimal unitatGestoraId) {
		super();
		this.sollicitudCrearRDTO = sollicitudCrearRDTO;
		this.unitatGestoraId = unitatGestoraId;
		this.personesSollicitud = new ArrayList<>();
		this.personesSollicitud.add(sollicitudCrearRDTO.getSollicitant());
		this.personesSollicitud.add(sollicitudCrearRDTO.getRepresentant());
		this.personesSollicitud.addAll(sollicitudCrearRDTO.getPersonesInteressades());
		this.personesSollicitud.addAll(sollicitudCrearRDTO.getPersonesImplicades());
	}

}
