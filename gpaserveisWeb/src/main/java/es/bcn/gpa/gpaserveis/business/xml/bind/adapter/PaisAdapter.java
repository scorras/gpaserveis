package es.bcn.gpa.gpaserveis.business.xml.bind.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.business.ServeisService;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PaisosRDTO;

/**
 * The Class PaisAdapter.
 */
@Component
@Configurable
public class PaisAdapter extends XmlAdapter<String, String> {

	/** The serveis service. */
	private static ServeisService serveisService;

	/**
	 * Inits the serveis service.
	 *
	 * @param serveisService
	 *            the serveis service
	 */
	@Autowired
	public void initServeisService(ServeisService serveisService) {
		PaisAdapter.serveisService = serveisService;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.xml.bind.annotation.adapters.XmlAdapter#unmarshal(java.lang.Object)
	 */
	@Override
	public String unmarshal(String sourceValue) throws Exception {
		return sourceValue;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.xml.bind.annotation.adapters.XmlAdapter#marshal(java.lang.Object)
	 */
	@Override
	public String marshal(String sourceValue) throws Exception {
		if (StringUtils.isNotEmpty(sourceValue)) {
			PaisosRDTO paisosRDTO = serveisService.consultarPaisosByCodi(sourceValue);
			if (paisosRDTO != null) {
				return paisosRDTO.getNom();
			}
		}
		return sourceValue;
	}
}
