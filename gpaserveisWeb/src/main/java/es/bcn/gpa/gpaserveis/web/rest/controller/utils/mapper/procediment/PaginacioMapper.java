package es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.procediment;

import org.modelmapper.PropertyMap;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.PaginationAttributes;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.cerca.PaginacioRDTO;

public class PaginacioMapper extends PropertyMap<PaginationAttributes, PaginacioRDTO> {
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.PropertyMap#configure()
	 */
	@Override
	protected void configure() {
		map().setNumeroPagina(source.getCurrentPageNumber());
		map().setResultatsPerPagina(source.getPageSize());
		map().setTotalPagines(source.getTotalPages());
		map().setTotalResultats(source.getTotalElements());
	}

}
