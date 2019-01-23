package es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.ProcedimentsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.ProcedimentsUgos;

/**
 * The Class MapperHelper.
 */
public class MapperHelper {

	/**
	 * Gets the id ugo list.
	 *
	 * @param procedimentsRDTO
	 *            the procediments RDTO
	 * @return the id ugo list
	 */
	public static List<BigDecimal> getIdUgoList(ProcedimentsRDTO procedimentsRDTO) {
		ArrayList<BigDecimal> idUgoList = new ArrayList<BigDecimal>();
		if (CollectionUtils.isNotEmpty(procedimentsRDTO.getUgosList())) {
			for (ProcedimentsUgos procedimentsUgos : procedimentsRDTO.getUgosList()) {
				idUgoList.add(procedimentsUgos.getUgoIdext());
			}
		}
		return idUgoList;
	}
}
