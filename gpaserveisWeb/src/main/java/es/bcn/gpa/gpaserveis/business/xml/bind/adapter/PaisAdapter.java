package es.bcn.gpa.gpaserveis.business.xml.bind.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.apache.commons.lang.StringUtils;

import es.bcn.gpa.gpaserveis.business.ServeisService;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PaisosRDTO;

/**
 * The Class PaisAdapter.
 */
public class PaisAdapter extends XmlAdapter<String, String> {

	/** The serveis service. */
	protected final ServeisService serveisService;

	/**
	 * Instantiates a new pais adapter.
	 *
	 * @param serveisService
	 *            the serveis service
	 */
	public PaisAdapter(ServeisService serveisService) {
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
			PaisosRDTO paisosRDTO = serveisService.consultarPaisosByCodi(sourceValue);
			if (paisosRDTO != null) {
				return paisosRDTO.getNom();
			}
		}
		return sourceValue;
	}
}
