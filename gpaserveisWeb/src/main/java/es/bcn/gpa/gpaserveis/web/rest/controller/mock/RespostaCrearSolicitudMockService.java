package es.bcn.gpa.gpaserveis.web.rest.controller.mock;

import java.math.BigDecimal;

import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.ResultatRespostaDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.crear.solicituds.RespostaCrearExpedientsRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.crear.solicituds.RespostaCrearSolicitudsRDTO;

public class RespostaCrearSolicitudMockService {

	public RespostaCrearSolicitudsRDTO getRespostaRespostaCrearSolicituds() {

		RespostaCrearSolicitudsRDTO resposta = new RespostaCrearSolicitudsRDTO();

		ResultatRespostaDTO resultat = new ResultatRespostaDTO();

		resultat.setCodi("OK");
		resultat.setDescripcio("Expedient en estat esborrany creat correctament");

		RespostaCrearExpedientsRDTO expedient = new RespostaCrearExpedientsRDTO();
		expedient.setId(new BigDecimal("1"));

		resposta.setResultat(resultat);
		resposta.setExpedient(expedient);

		return resposta;
	}

}
