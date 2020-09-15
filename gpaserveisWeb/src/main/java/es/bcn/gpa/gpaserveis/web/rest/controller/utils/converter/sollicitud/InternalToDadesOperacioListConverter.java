package es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.sollicitud;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.business.dto.expedients.DadaEspecificaBDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.DadesEspecifiquesValors;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.Items;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.Constants;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.sollicituds.DadesAtributsSollicitudsRDTO;

/**
 * The Class InternalToDadesOperacioListConverter.
 */
@Component("sollicitudInternalToDadesOperacioListConverter")
public class InternalToDadesOperacioListConverter extends AbstractConverter<List<DadaEspecificaBDTO>, List<DadesAtributsSollicitudsRDTO>> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.AbstractConverter#convert(java.lang.Object)
	 */
	@Override
	protected List<DadesAtributsSollicitudsRDTO> convert(List<DadaEspecificaBDTO> source) {
		List<DadesAtributsSollicitudsRDTO> dadesAtributsSollicitudsRDTOList = null;
		DadesAtributsSollicitudsRDTO dadesAtributsSollicitudsRDTO = null;
		List<String> valorList = null;
		StringBuffer valorStringBuffer = null;

		if (CollectionUtils.isNotEmpty(source)) {
			DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(Constants.DATE_TIME_PATTERN);
			dadesAtributsSollicitudsRDTOList = new ArrayList<DadesAtributsSollicitudsRDTO>();
			for (DadaEspecificaBDTO dadaEspecificaBDTO : source) {
				dadesAtributsSollicitudsRDTO = new DadesAtributsSollicitudsRDTO();
				dadesAtributsSollicitudsRDTO.setCodi(dadaEspecificaBDTO.getDadaOperacio().getCodi());
				valorList = new ArrayList<String>();
				if (CollectionUtils.isNotEmpty(dadaEspecificaBDTO.getDadaEspecifica().getDadesEspecifiquesValorsList())) {
					for (DadesEspecifiquesValors dadesEspecifiquesValors : dadaEspecificaBDTO.getDadaEspecifica()
					        .getDadesEspecifiquesValorsList()) {
						// Transformación directa a String excepto para valores
						// de tipo fecha o lista múltiple
						if (CollectionUtils.isNotEmpty(dadesEspecifiquesValors.getValorListaMultipleList())) {
							for (Integer valorListaMultiple : dadesEspecifiquesValors.getValorListaMultipleList()) {
								valorList.add(String.valueOf(valorListaMultiple));
							}
						} else {
							valorStringBuffer = new StringBuffer();
							valorStringBuffer.append((dadesEspecifiquesValors.getValorBoolean() != null)
							        ? BooleanUtils.toStringTrueFalse(BooleanUtils.toBoolean(dadesEspecifiquesValors.getValorBoolean(),
							                NumberUtils.INTEGER_ONE, NumberUtils.INTEGER_ZERO))
							        : StringUtils.EMPTY);
							valorStringBuffer.append((dadesEspecifiquesValors.getValorCalendar() != null)
							        ? dateTimeFormatter.print(dadesEspecifiquesValors.getValorCalendar()) : StringUtils.EMPTY);
							valorStringBuffer.append((dadesEspecifiquesValors.getValorClob() != null)
							        ? dadesEspecifiquesValors.getValorClob() : StringUtils.EMPTY);
							valorStringBuffer.append((dadesEspecifiquesValors.getValorDouble() != null)
							        ? dadesEspecifiquesValors.getValorDouble() : StringUtils.EMPTY);
							valorStringBuffer.append((dadesEspecifiquesValors.getValorInteger() != null)
							        ? dadesEspecifiquesValors.getValorInteger() : StringUtils.EMPTY);
							valorStringBuffer.append((dadesEspecifiquesValors.getValorListaMultiple() != null)
							        ? obtenirDescripcioItemLlista(dadesEspecifiquesValors.getValorListaMultiple(),
							                dadaEspecificaBDTO.getDadaOperacio().getItemsList())
							        : StringUtils.EMPTY);
							valorStringBuffer.append((dadesEspecifiquesValors.getValorListaSimple() != null)
							        ? obtenirDescripcioItemLlista(dadesEspecifiquesValors.getValorListaSimple(),
							                dadaEspecificaBDTO.getDadaOperacio().getItemsList())
							        : StringUtils.EMPTY);
							valorStringBuffer.append((dadesEspecifiquesValors.getValorMoneda() != null)
							        ? dadesEspecifiquesValors.getValorMoneda() : StringUtils.EMPTY);
							valorStringBuffer.append((dadesEspecifiquesValors.getValorMunicipi() != null)
							        ? dadesEspecifiquesValors.getValorMunicipi() : StringUtils.EMPTY);
							valorStringBuffer.append((dadesEspecifiquesValors.getValorPais() != null)
							        ? dadesEspecifiquesValors.getValorPais() : StringUtils.EMPTY);
							valorStringBuffer.append((dadesEspecifiquesValors.getValorProvincia() != null)
							        ? dadesEspecifiquesValors.getValorProvincia() : StringUtils.EMPTY);
							valorStringBuffer.append((dadesEspecifiquesValors.getValorString() != null)
							        ? dadesEspecifiquesValors.getValorString() : StringUtils.EMPTY);
							valorList.add(valorStringBuffer.toString());
						}
					}
				}
				dadesAtributsSollicitudsRDTO.setValors(valorList);
				dadesAtributsSollicitudsRDTOList.add(dadesAtributsSollicitudsRDTO);
			}

		}

		return dadesAtributsSollicitudsRDTOList;
	}

	/**
	 * Obtenir descripcio item llista.
	 *
	 * @param valorLlista
	 *            the valor llista
	 * @param itemsList
	 *            the items list
	 * @return the string
	 */
	private String obtenirDescripcioItemLlista(Integer valorLlista, List<Items> itemsList) {
		for (Items items : itemsList) {
			if (items.getItemId().intValue() == valorLlista.intValue()) {
				return items.getItemDescripcio();
			}
		}
		return null;
	}
}