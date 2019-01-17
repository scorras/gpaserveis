package es.bcn.gpa.gpaserveis.web.rest.controller.mock;

import java.math.BigDecimal;

import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.ResultatRespostaDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.obrir.expedients.RespostaObrirExpedientsRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.obrir.expedients.RespostaObrirSolicitudsRDTO;

public class RespostaObrirSolicitudMockService {

	public RespostaObrirSolicitudsRDTO getRespostaObrirSolicituds(BigDecimal idExpedient) {

		RespostaObrirSolicitudsRDTO resposta = new RespostaObrirSolicitudsRDTO();

		ResultatRespostaDTO resultat = new ResultatRespostaDTO();

		resultat.setCodi("OK");
		resultat.setDescripcio("Expedient obert correctament");

		RespostaObrirExpedientsRDTO expedient = new RespostaObrirExpedientsRDTO();
		expedient.setId(idExpedient);
		expedient.setCodi("PROC-0001");

		resposta.setResultat(resultat);
		resposta.setExpedient(expedient);

		return resposta;
	}

}
