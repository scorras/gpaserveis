package es.bcn.gpa.gpaserveis.business.xml.bind.adapter;

import java.io.StringReader;
import java.util.Arrays;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.json.XML;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

import es.bcn.gpa.gpaserveis.business.xml.bind.adapted.DadesAtributsSollicitudsValorAdapted;
import es.bcn.gpa.gpaserveis.business.xml.bind.adapted.DadesAtributsSollicitudsValorsLlistaRepetibleAdapted;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.Constants;

/**
 * The Class DadesAtributsSollicitudsValorAdapter.
 */
public class DadesAtributsSollicitudsValorsLlistaRepetibleAdapter extends XmlAdapter<Object, DadesAtributsSollicitudsValorsLlistaRepetibleAdapted> {

	private DocumentBuilder documentBuilder;

	private Document document;

	/**
	 * Instantiates a new dades atributs sollicituds valor adapter.
	 */
	public DadesAtributsSollicitudsValorsLlistaRepetibleAdapter() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.xml.bind.annotation.adapters.XmlAdapter#unmarshal(java.lang.Object)
	 */
	@Override
	public DadesAtributsSollicitudsValorsLlistaRepetibleAdapted unmarshal(Object o) throws Exception {
		Element element = (Element) o;
		DadesAtributsSollicitudsValorsLlistaRepetibleAdapted dadesAtributsSollicitudsValorsLlistaRepetibleAdapted = new DadesAtributsSollicitudsValorsLlistaRepetibleAdapted();
		//TODO
//		dadesAtributsSollicitudsValorsLlistaRepetibleAdapted.setValorsLlistaRepetible(Arrays.asList(element.getTagName()));
		return dadesAtributsSollicitudsValorsLlistaRepetibleAdapted;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.xml.bind.annotation.adapters.XmlAdapter#marshal(java.lang.Object)
	 */
	@Override
	public Object marshal(DadesAtributsSollicitudsValorsLlistaRepetibleAdapted dadesAtributsSollicitudsValorsLlistaRepetibleAdapted) throws Exception {
		Element valorsElement = null;
		Element valorElement = null;
		//TODO
//		if (CollectionUtils.isNotEmpty(dadesAtributsSollicitudsValorsLlistaRepetibleAdapted.getValorsLlistaRepetible())) {
//			valorsElement = getDocument().createElement("VALOR_LLISTA_REPETIBLE");
//			valorElement = getDocument().createElement("VALOR");
//			if (StringUtils.equals(dadesAtributsSollicitudsValorAdapted.getCodi(), Constants.CODI_DADA_OPERACIO_DADES_EXTERNES)) {
//				Object json = new JSONTokener(dadesAtributsSollicitudsValorsLlistaRepetibleAdapted.getValorsLlistaRepetible().get(0)).nextValue();
//				String xmlJson = XML.toString(json);
//				if (json instanceof JSONArray) {
//					xmlJson = "<valorArray>" + xmlJson + "</valorArray>";
//				} else if (json instanceof JSONObject) {
//					xmlJson = "<valorSimple>" + xmlJson + "</valorSimple>";
//				}
//				Document documentJson = getDocumentBuilder().parse(new InputSource(new StringReader(xmlJson)));
//				Node importedNode = getDocument().importNode(documentJson.getDocumentElement(), true);
//				valorElement.appendChild(importedNode);
//			} else {
//				// Elemento VALOR con el valor en string
//				valorElement.setTextContent(dadesAtributsSollicitudsValorAdapted.getValor().get(0));
//			}
//			valorsElement.appendChild(valorElement);
//		}
		return valorsElement;
	}

	private DocumentBuilder getDocumentBuilder() throws ParserConfigurationException {
		if (null == documentBuilder) {
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			documentBuilder = documentBuilderFactory.newDocumentBuilder();
		}
		return documentBuilder;
	}

	private Document getDocument() throws ParserConfigurationException {
		if (null == document) {
			document = getDocumentBuilder().newDocument();
		}
		return document;
	}

}