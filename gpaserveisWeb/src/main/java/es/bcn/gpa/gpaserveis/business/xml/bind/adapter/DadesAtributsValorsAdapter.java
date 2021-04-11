package es.bcn.gpa.gpaserveis.business.xml.bind.adapter;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import es.bcn.gpa.gpaserveis.business.exception.GPAServeisServiceException;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.sollicituds.DadesAtributsValorsLlistaSimpleSollicitudsRDTO;
import lombok.extern.apachecommons.CommonsLog;

/**
 * The Class DadesAtributsValorsAdapter.
 */
@CommonsLog
public class DadesAtributsValorsAdapter extends XmlAdapter<Object, List<Object>> {

	/** The document builder. */
	private DocumentBuilder documentBuilder;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.xml.bind.annotation.adapters.XmlAdapter#marshal(java.lang.Object)
	 */
	@Override
	public Object marshal(List<Object> v) throws Exception {
		if (v == null) {
			return null;
		}

		Document document = getDocumentBuilder().newDocument();
		Element root = document.createElement("VALORS");
		Element child = null;
		for (Object object : v) {
			if (object instanceof String) {
				child = document.createElement("VALOR");
				child.setTextContent((String) object);
				root.appendChild(child);
			} else if (object instanceof DadesAtributsValorsLlistaSimpleSollicitudsRDTO) {
				child = document.createElement("INDEX");
				child.setTextContent(((DadesAtributsValorsLlistaSimpleSollicitudsRDTO) object).getIndex());
				root.appendChild(child);
				child = document.createElement("VALOR");
				child.setTextContent(((DadesAtributsValorsLlistaSimpleSollicitudsRDTO) object).getValor());
				root.appendChild(child);
			}
		}
		return root;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.xml.bind.annotation.adapters.XmlAdapter#unmarshal(java.lang.Object)
	 */
	@Override
	public List<Object> unmarshal(Object v) throws Exception {
		if (v == null) {
			return null;
		}

		List<Object> objectList = new ArrayList<Object>();
		Object object = null;
		Element element = (Element) v;
		NodeList nodeList = element.getChildNodes();
		if (nodeList.getLength() > 1) {
			object = new DadesAtributsValorsLlistaSimpleSollicitudsRDTO();
		}
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node currentNode = nodeList.item(i);
			if (currentNode.getNodeType() == Node.ELEMENT_NODE && StringUtils.equals(currentNode.getNodeName(), "INDEX")) {
				if (object instanceof DadesAtributsValorsLlistaSimpleSollicitudsRDTO) {
					((DadesAtributsValorsLlistaSimpleSollicitudsRDTO) object).setIndex(currentNode.getTextContent());
				}
			} else if (currentNode.getNodeType() == Node.ELEMENT_NODE && StringUtils.equals(currentNode.getNodeName(), "VALOR")) {
				if (object instanceof DadesAtributsValorsLlistaSimpleSollicitudsRDTO) {
					((DadesAtributsValorsLlistaSimpleSollicitudsRDTO) object).setValor(currentNode.getTextContent());
				} else {
					object = currentNode.getTextContent();
				}
			}
		}
		objectList.add(object);

		return objectList;
	}

	/**
	 * Gets the document builder.
	 *
	 * @return the document builder
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	private DocumentBuilder getDocumentBuilder() throws GPAServeisServiceException {
		if (null == documentBuilder) {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			try {
				documentBuilder = dbf.newDocumentBuilder();
			} catch (ParserConfigurationException e) {
				log.error("Error en la instanciació de documentBuilder", e);
				throw new GPAServeisServiceException("Error en la instanciació de documentBuilder", e);
			}
		}
		return documentBuilder;
	}

}