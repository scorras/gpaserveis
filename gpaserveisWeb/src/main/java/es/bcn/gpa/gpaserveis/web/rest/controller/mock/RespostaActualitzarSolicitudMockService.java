package es.bcn.gpa.gpaserveis.web.rest.controller.mock;

import java.math.BigDecimal;

import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.ResultatRespostaDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.actualitzar.solicituds.RespostaActualitzarExpedientsRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.actualitzar.solicituds.RespostaActualitzarSolicitudsRDTO;

public class RespostaActualitzarSolicitudMockService {

	public RespostaActualitzarSolicitudsRDTO getRespostaRespostaActualitzarSolicituds(BigDecimal idExpedient) {

		RespostaActualitzarSolicitudsRDTO resposta = new RespostaActualitzarSolicitudsRDTO();

		ResultatRespostaDTO resultat = new ResultatRespostaDTO();

		resultat.setCodi("OK");
		resultat.setDescripcio("Expedient en estat esborrany actualitzat correctament");

		RespostaActualitzarExpedientsRDTO expedient = new RespostaActualitzarExpedientsRDTO();
		expedient.setId(idExpedient);

		resposta.setResultat(resultat);
		resposta.setExpedient(expedient);

		return resposta;
	}

}
