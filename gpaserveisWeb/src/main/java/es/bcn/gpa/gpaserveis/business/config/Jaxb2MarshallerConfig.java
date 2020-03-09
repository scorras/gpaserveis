package es.bcn.gpa.gpaserveis.business.config;

import java.util.HashMap;

import javax.xml.bind.Marshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import es.bcn.gpa.gpaserveis.business.ServeisService;
import es.bcn.gpa.gpaserveis.business.xml.bind.adapter.AdrecaAdapter;
import es.bcn.gpa.gpaserveis.business.xml.bind.adapter.DataHoraAdapter;
import es.bcn.gpa.gpaserveis.business.xml.bind.adapter.MunicipiAdapter;
import es.bcn.gpa.gpaserveis.business.xml.bind.adapter.PaisAdapter;
import es.bcn.gpa.gpaserveis.business.xml.bind.adapter.ProvinciaAdapter;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.sollicituds.SollicitudConsultaRDTO;

/**
 * The Class Jaxb2MarshallerConfig.
 */
@Configuration
public class Jaxb2MarshallerConfig {

	/** The serveis service. */
	@Autowired
	private ServeisService serveisService;

	/**
	 * Jaxb 2 marshaller.
	 *
	 * @return the jaxb 2 marshaller
	 */
	@SuppressWarnings("serial")
	@Bean(name = "jaxb2Marshaller")
	public Jaxb2Marshaller jaxb2Marshaller() {
		Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
		jaxb2Marshaller.setClassesToBeBound(new Class[] { SollicitudConsultaRDTO.class });
		jaxb2Marshaller.setMarshallerProperties(new HashMap<String, Object>() {
			{
				put(Marshaller.JAXB_FORMATTED_OUTPUT, true);
				put(Marshaller.JAXB_ENCODING, "UTF-8");
			}
		});
		jaxb2Marshaller.setAdapters(adrecaAdapter(serveisService), dataHoraAdapter(), municipiAdapter(serveisService),
		        paisAdapter(serveisService), provinciaAdapter(serveisService));

		return jaxb2Marshaller;
	}

	/**
	 * Adreca adapter.
	 *
	 * @param serveisService
	 *            the serveis service
	 * @return the adreca adapter
	 */
	@Bean
	public AdrecaAdapter adrecaAdapter(ServeisService serveisService) {
		return new AdrecaAdapter(serveisService);
	}

	/**
	 * Data hora adapter.
	 *
	 * @return the data hora adapter
	 */
	@Bean
	public DataHoraAdapter dataHoraAdapter() {
		return new DataHoraAdapter();
	}

	/**
	 * Municipi adapter.
	 *
	 * @param serveisService
	 *            the serveis service
	 * @return the municipi adapter
	 */
	@Bean
	public MunicipiAdapter municipiAdapter(ServeisService serveisService) {
		return new MunicipiAdapter(serveisService);
	}

	/**
	 * Pais adapter.
	 *
	 * @param serveisService
	 *            the serveis service
	 * @return the pais adapter
	 */
	@Bean
	public PaisAdapter paisAdapter(ServeisService serveisService) {
		return new PaisAdapter(serveisService);
	}

	/**
	 * Provincia adapter.
	 *
	 * @param serveisService
	 *            the serveis service
	 * @return the provincia adapter
	 */
	@Bean
	public ProvinciaAdapter provinciaAdapter(ServeisService serveisService) {
		return new ProvinciaAdapter(serveisService);
	}

}