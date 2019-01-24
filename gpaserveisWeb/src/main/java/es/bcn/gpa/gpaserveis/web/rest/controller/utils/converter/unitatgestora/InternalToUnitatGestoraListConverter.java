package es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.unitatgestora;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.AbstractConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.business.UnitatsGestoresService;
import es.bcn.gpa.gpaserveis.business.exception.GPAServeisRuntimeException;
import es.bcn.gpa.gpaserveis.business.exception.GPAServeisServiceException;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.ProcedimentsUgos;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaunitats.UnitatsGestoresRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.UnitatGestoraRDTO;

/**
 * The Class InternalToUnitatGestoraListConverter.
 */
@Component("internalToUnitatGestoraListConverter")
public class InternalToUnitatGestoraListConverter extends AbstractConverter<List<ProcedimentsUgos>, List<UnitatGestoraRDTO>> {

	/** The unitats gestores service. */
	@Autowired
	private UnitatsGestoresService unitatsGestoresService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.AbstractConverter#convert(java.lang.Object)
	 */
	@Override
	protected List<UnitatGestoraRDTO> convert(List<ProcedimentsUgos> source) {
		ArrayList<UnitatGestoraRDTO> unitatGestoraRDTOList = new ArrayList<UnitatGestoraRDTO>();
		UnitatsGestoresRDTO unitatsGestoresRDTO = null;
		UnitatGestoraRDTO unitatGestoraRDTO = null;

		for (ProcedimentsUgos procedimentsUgos : source) {
			try {
				// TODO Quizá este no sea el lugar más adecuado para realizar la
				// llamada al servicio de Unitats Gestores
				unitatsGestoresRDTO = unitatsGestoresService.consultarDadesUnitatGestora(procedimentsUgos.getUgoIdext());
			} catch (GPAServeisServiceException e) {
				throw new GPAServeisRuntimeException(e);
			}
			unitatGestoraRDTO = new UnitatGestoraRDTO();
			unitatGestoraRDTO.setNom(unitatsGestoresRDTO.getNom());
			unitatGestoraRDTO.setDescripcio(unitatsGestoresRDTO.getDescripcio());
			unitatGestoraRDTOList.add(unitatGestoraRDTO);
		}

		return unitatGestoraRDTOList;
	}
}