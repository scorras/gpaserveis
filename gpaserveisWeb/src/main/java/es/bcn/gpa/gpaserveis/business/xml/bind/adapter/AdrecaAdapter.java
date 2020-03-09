package es.bcn.gpa.gpaserveis.business.xml.bind.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import es.bcn.gpa.gpaserveis.business.ServeisService;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.TipusViesRDTO;

/**
 * The Class AdrecaAdapter.
 */
public class AdrecaAdapter extends XmlAdapter<String, String> {

	/** The serveis service. */
	protected final ServeisService serveisService;

	/**
	 * Instantiates a new adreca adapter.
	 *
	 * @param serveisService
	 *            the serveis service
	 */
	public AdrecaAdapter(ServeisService serveisService) {
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
		if (ArrayUtils.isNotEmpty(sourceValueArray)) {
			TipusViesRDTO tipusViesRDTO = serveisService.consultarTipusViesByCodi(sourceValueArray[0]);
			if (tipusViesRDTO != null) {
				sourceValueArray[0] = tipusViesRDTO.getNom();
				return StringUtils.join(sourceValueArray, " ");
			}
		}
		return sourceValue;
	}
}
