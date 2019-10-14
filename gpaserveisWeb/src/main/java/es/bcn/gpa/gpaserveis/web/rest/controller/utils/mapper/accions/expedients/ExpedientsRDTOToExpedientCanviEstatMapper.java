package es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.accions.expedients;

import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ExpedientCanviEstat;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ExpedientsRDTO;

/**
 * The Class ExpedientsRDTOToExpedientCanviEstatMapper.
 */
@Component("expedientsRDTOToExpedientCanviEstatMapper")
public class ExpedientsRDTOToExpedientCanviEstatMapper extends PropertyMap<ExpedientsRDTO, ExpedientCanviEstat> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.PropertyMap#configure()
	 */
	@Override
	protected void configure() {
		map().setDiesTerminiRequeriment(source.getDiesTerminiRequeriment());
		map().setDiesTerminiAllegacio(source.getDiesTerminiAllegacio());
	}

}
