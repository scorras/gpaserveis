package es.bcn.gpa.gpaserveis.business.xml.bind.adapter;

import java.math.BigDecimal;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.business.ServeisService;

@Component
@Configurable
public class AdrecaAdapter extends XmlAdapter<String, String> {

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
		AdrecaAdapter.serveisService = serveisService;
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
		return serveisService.crearDataXmlExpedient(new BigDecimal(21)).getDadesXml();
	}
}
