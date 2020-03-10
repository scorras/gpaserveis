package es.bcn.gpa.gpaserveis.business.xml.bind;

import java.io.InputStream;
import java.io.StringWriter;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;

/**
 * The Class Jaxb2MarshallerWrapper.
 */
@Component
public class Jaxb2MarshallerWrapper {

	/** The jaxb 2 marshaller. */
	@Autowired
	private Jaxb2Marshaller jaxb2Marshaller;

	/**
	 * Marshall xml.
	 *
	 * @param <T>
	 *            the generic type
	 * @param obj
	 *            the obj
	 * @return the string
	 */
	public <T> String marshallXml(final T obj) {
		StringWriter stringWriter = new StringWriter();
		StreamResult streamResult = new StreamResult(stringWriter);
		jaxb2Marshaller.marshal(obj, streamResult);
		return stringWriter.toString();
	}

	/**
	 * Unmarshall xml.
	 *
	 * @param <T>
	 *            the generic type
	 * @param xml
	 *            the xml
	 * @return the t
	 */
	@SuppressWarnings("unchecked")
	public <T> T unmarshallXml(final InputStream xml) {
		return (T) jaxb2Marshaller.unmarshal(new StreamSource(xml));
	}
}