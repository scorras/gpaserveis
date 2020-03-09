package es.bcn.gpa.gpaserveis.business.xml.bind.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.apache.commons.lang.StringUtils;

import es.bcn.gpa.gpaserveis.business.ServeisService;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ProvinciesRDTO;

/**
 * The Class ProvinciaAdapter.
 */
public class ProvinciaAdapter extends XmlAdapter<String, String> {

	/** The serveis service. */
	protected final ServeisService serveisService;

	/**
	 * Instantiates a new provincia adapter.
	 *
	 * @param serveisService
	 *            the serveis service
	 */
	public ProvinciaAdapter(ServeisService serveisService) {
		this.serveisService = serveisService;
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
			ProvinciesRDTO provinciesRDTO = serveisService.consultarProvinciesByCodi(sourceValue);
			if (provinciesRDTO != null) {
				return provinciesRDTO.getNom();
			}
		}
		return sourceValue;
	}
}
