package es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.accions.expedients;

import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ExpedientCanviEstatAccio;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ExpedientsRDTO;

/**
 * The Class ExpedientsRDTOToExpedientCanviEstatAccioMapper.
 */
@Component("expedientsRDTOToExpedientCanviEstatAccioMapper")
public class ExpedientsRDTOToExpedientCanviEstatAccioMapper extends PropertyMap<ExpedientsRDTO, ExpedientCanviEstatAccio> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.PropertyMap#configure()
	 */
	@Override
	protected void configure() {
		map().setIdEstat(source.getIdEstat());
		map().setDescEstat(source.getDescEstat());
		map().setIdProcediment(source.getProcedimentIdext());
		map().setDiesTerminiRequeriment(source.getDiesTerminiRequeriment());
		map().setDiesTerminiAllegacio(source.getDiesTerminiAllegacio());
	}

}
