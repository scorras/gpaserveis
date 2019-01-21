package es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper;

import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.PaginationAttributes;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.cerca.PaginacioRDTO;

/**
 * The Class PaginationAttributesToPaginacioRDTOMapper.
 */
@Component
public class PaginationAttributesToPaginacioRDTOMapper extends PropertyMap<PaginationAttributes, PaginacioRDTO> {
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
