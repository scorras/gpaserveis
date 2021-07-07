package es.bcn.gpa.gpaserveis.web.rest.controller.helper.bean;

import java.util.ArrayList;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.DadesEspecifiquesRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.DadesEspecifiquesRepetiblesRDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValidateDadesOperacioResultat {

	private ArrayList<DadesEspecifiquesRDTO> dadesEspecifiquesRDTOList;

	private ArrayList<DadesEspecifiquesRepetiblesRDTO> dadesEspecifiquesRepetiblesRDTOList;

}
