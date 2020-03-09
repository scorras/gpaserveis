package es.bcn.gpa.gpaserveis.business.xml.bind.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import es.bcn.gpa.gpaserveis.business.ServeisService;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.MunicipisRDTO;

/**
 * The Class MunicipiAdapter.
 */
public class MunicipiAdapter extends XmlAdapter<String, String> {

	/** The serveis service. */
	protected final ServeisService serveisService;

	/**
	 * Instantiates a new municipi adapter.
	 *
	 * @param serveisService
	 *            the serveis service
	 */
	public MunicipiAdapter(ServeisService serveisService) {
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
		String[] sourceValueArray = StringUtils.split(sourceValue);
		if (ArrayUtils.isNotEmpty(sourceValueArray) && sourceValueArray.length == 2) {
			MunicipisRDTO municipisRDTO = serveisService.consultarMunicipisByCodi(sourceValueArray[1], sourceValueArray[0]);
			if (municipisRDTO != null) {
				return municipisRDTO.getNom();
			}
		}
		return sourceValue;
	}
}
