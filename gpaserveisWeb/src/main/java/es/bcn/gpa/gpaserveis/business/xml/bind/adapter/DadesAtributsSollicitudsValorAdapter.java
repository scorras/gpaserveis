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
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.Constants;

/**
 * The Class DadesAtributsSollicitudsValorAdapter.
 */
public class DadesAtributsSollicitudsValorAdapter extends XmlAdapter<Object, DadesAtributsSollicitudsValorAdapted> {

	private DocumentBuilder documentBuilder;

	private Document document;

	/**
	 * Instantiates a new dades atributs sollicituds valor adapter.
	 */
	public DadesAtributsSollicitudsValorAdapter() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.xml.bind.annotation.adapters.XmlAdapter#unmarshal(java.lang.Object)
	 */
	@Override
	public DadesAtributsSollicitudsValorAdapted unmarshal(Object o) throws Exception {
		Element element = (Element) o;
		DadesAtributsSollicitudsValorAdapted dadesAtributsSollicitudsValorAdapted = new DadesAtributsSollicitudsValorAdapted();
		dadesAtributsSollicitudsValorAdapted.setValor(Arrays.asList(element.getTagName()));
		return dadesAtributsSollicitudsValorAdapted;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.xml.bind.annotation.adapters.XmlAdapter#marshal(java.lang.Object)
	 */
	@Override
	public Object marshal(DadesAtributsSollicitudsValorAdapted dadesAtributsSollicitudsValorAdapted) throws Exception {
		Element valorsElement = null;
		Element valorElement = null;
		if (CollectionUtils.isNotEmpty(dadesAtributsSollicitudsValorAdapted.getValor())) {
			valorsElement = getDocument().createElement("VALORS");
			valorElement = getDocument().createElement("VALOR");
			if (StringUtils.equals(dadesAtributsSollicitudsValorAdapted.getCodi(), Constants.CODI_DADA_OPERACIO_DADES_EXTERNES) ||
					dadesAtributsSollicitudsValorAdapted.isValorRepetible()) {
				// Elemento VALOR con el JSON en formato XML
				Object json = new JSONTokener(dadesAtributsSollicitudsValorAdapted.getValor().get(0)).nextValue();
				String xmlJson = XML.toString(json);
				if (json instanceof JSONArray) {
					xmlJson = "<valorArray>" + xmlJson + "</valorArray>";
				} else if (json instanceof JSONObject) {
					xmlJson = "<valorSimple>" + xmlJson + "</valorSimple>";
				}
				Document documentJson = getDocumentBuilder().parse(new InputSource(new StringReader(xmlJson)));
				Node importedNode = getDocument().importNode(documentJson.getDocumentElement(), true);
				valorElement.appendChild(importedNode);
			} else {
				// Elemento VALOR con el valor en string
				valorElement.setTextContent(dadesAtributsSollicitudsValorAdapted.getValor().get(0));
			}
			valorsElement.appendChild(valorElement);
		}
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