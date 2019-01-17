package es.bcn.gpa.gpaserveis.web.rest.controller.mock;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.DadesAtributsRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.DadesGrupsRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.TramitsRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.atributs.DadesOperacioConsultaRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.atributs.RespostaConsultaDadesOperacioRDTO;

public class RespostaConsultaDadesOperacioMockService {

	public RespostaConsultaDadesOperacioRDTO getRespostaConsultaDadesOperacio(BigDecimal idProcediment, BigDecimal idTramit) {

		RespostaConsultaDadesOperacioRDTO resposta = new RespostaConsultaDadesOperacioRDTO();

		DadesOperacioConsultaRDTO dadesOperacio = new DadesOperacioConsultaRDTO();

		dadesOperacio.setTramit(TramitsRDTOFactory.create(idTramit, "SOLC", "Sol·licitud"));

		dadesOperacio.setGrups(
		        Arrays.asList(
		                DadesGrupsRDTOFactory.create("Grup 1", "2", "1", null, null,
		                        Arrays.asList(DadesAtributsRDTOFactory.create("ATTR1", "Atribut 1", "1", "OBLIGATORI", "TEXT", null, null),
		                                DadesAtributsRDTOFactory.create("ATTR2", "Atribut 2", "2", "OBLIGATORI", "NUMERIC", null, null),
		                                DadesAtributsRDTOFactory.create("ATTR3", "Atribut 3", "3", null, "TEXT", null, null),
		                                DadesAtributsRDTOFactory.create("ATTR4", "Atribut 4", "4", "OBLIGATORI", "TEXT", null, null),
		                                DadesAtributsRDTOFactory.create("ATTR5", "Atribut 5", "5", null, "TEXT", null, null))),
		                DadesGrupsRDTOFactory.create("Grup 1", "3", "1", null, null,
		                        Arrays.asList(DadesAtributsRDTOFactory.create("ATTR1", "Atribut 1", "1", "OBLIGATORI", "TEXT", null, null),
		                                DadesAtributsRDTOFactory.create("ATTR2", "Atribut 2", "2", "OBLIGATORI", "NUMERIC", null, null),
		                                DadesAtributsRDTOFactory.create("ATTR3", "Atribut 3", "3", null, "TEXT", null, null),
		                                DadesAtributsRDTOFactory.create("ATTR4", "Atribut 4", "4", "OBLIGATORI", "TEXT", null, null),
		                                DadesAtributsRDTOFactory.create("ATTR5", "Atribut 5", "5", null, "TEXT", null, null)))));

		resposta.setDadesOperacio(dadesOperacio);
		return resposta;
	}

	private static class DadesAtributsRDTOFactory {

		private static DadesAtributsRDTO create(String codi, String descripcio, String ordre, String validacions, String tipus,
		        String urlValidacio, String urlAjuda) {

			DadesAtributsRDTO dadesAtributsRDTO = new DadesAtributsRDTO();

			dadesAtributsRDTO.setCodi(codi);
			dadesAtributsRDTO.setDescripcio(descripcio);
			dadesAtributsRDTO.setOrdre(ordre);
			dadesAtributsRDTO.setValidacions(validacions);
			dadesAtributsRDTO.setTipus(tipus);
			dadesAtributsRDTO.setUrlAjuda(urlAjuda);
			dadesAtributsRDTO.setUrlValidacio(urlValidacio);

			return dadesAtributsRDTO;
		}
	}

	private static class DadesGrupsRDTOFactory {

		private static DadesGrupsRDTO create(String descripcio, String columnes, String ordre, String urlValidacio, String urlAjuda,
		        List<DadesAtributsRDTO> atributs) {

			DadesGrupsRDTO dadesGrupsRDTO = new DadesGrupsRDTO();

			dadesGrupsRDTO.setDescripcio(descripcio);
			dadesGrupsRDTO.setColumnes(columnes);
			dadesGrupsRDTO.setOrdre(ordre);
			dadesGrupsRDTO.setUrlAjuda(urlAjuda);
			dadesGrupsRDTO.setUrlValidacio(urlValidacio);
			dadesGrupsRDTO.setAtributs(atributs);

			return dadesGrupsRDTO;
		}
	}

	private static class TramitsRDTOFactory {

		private static TramitsRDTO create(BigDecimal id, String codi, String descripcio) {

			TramitsRDTO tramitsRDTO = new TramitsRDTO();

			tramitsRDTO.setId(id);
			tramitsRDTO.setCodi(codi);
			tramitsRDTO.setDescripcio(descripcio);

			return tramitsRDTO;
		}
	}

}
