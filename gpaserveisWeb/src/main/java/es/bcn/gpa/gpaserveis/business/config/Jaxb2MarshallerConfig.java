package es.bcn.gpa.gpaserveis.business.config;

import java.util.HashMap;

import javax.xml.bind.Marshaller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.sollicituds.SollicitudConsultaRDTO;

/**
 * The Class Jaxb2MarshallerConfig.
 */
@Configuration
@Lazy(true)
public class Jaxb2MarshallerConfig {

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
		// "alternative/additiona - ly":
		// marshaller.setContextPath(<jaxb.context-file>)
		// marshaller.setPackagesToScan({"com.foo", "com.baz", "com.bar"});

		jaxb2Marshaller.setMarshallerProperties(new HashMap<String, Object>() {
			{
				put(Marshaller.JAXB_FORMATTED_OUTPUT, true);
				put(Marshaller.JAXB_ENCODING, "UTF-8");
			}
		});

		return jaxb2Marshaller;
	}

}