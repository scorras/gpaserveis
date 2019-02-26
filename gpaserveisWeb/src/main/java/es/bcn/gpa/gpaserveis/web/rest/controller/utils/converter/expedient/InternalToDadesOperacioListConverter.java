package es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.DadesEspecifiquesRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.DadesEspecifiquesValors;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.Constants;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.expedients.DadesAtributsExpedientsRDTO;

/**
 * The Class InternalToDadesOperacioListConverter.
 */
@Component("expedientInternalToDadesOperacioListConverter")
public class InternalToDadesOperacioListConverter
        extends AbstractConverter<List<DadesEspecifiquesRDTO>, List<DadesAtributsExpedientsRDTO>> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.AbstractConverter#convert(java.lang.Object)
	 */
	@Override
	protected List<DadesAtributsExpedientsRDTO> convert(List<DadesEspecifiquesRDTO> source) {
		List<DadesAtributsExpedientsRDTO> dadesAtributsExpedientsRDTOList = null;
		DadesAtributsExpedientsRDTO dadesAtributsExpedientsRDTO = null;
		List<String> valorList = null;
		StringBuffer valorStringBuffer = null;

		if (CollectionUtils.isNotEmpty(source)) {
			DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(Constants.DATE_TIME_PATTERN);
			dadesAtributsExpedientsRDTOList = new ArrayList<DadesAtributsExpedientsRDTO>();
			for (DadesEspecifiquesRDTO dadesEspecifiquesRDTO : source) {
				dadesAtributsExpedientsRDTO = new DadesAtributsExpedientsRDTO();
				dadesAtributsExpedientsRDTO.setCodi(
				        (dadesEspecifiquesRDTO.getCampIdext() != null) ? String.valueOf(dadesEspecifiquesRDTO.getCampIdext()) : null);
				valorList = new ArrayList<String>();
				if (CollectionUtils.isNotEmpty(dadesEspecifiquesRDTO.getDadesEspecifiquesValorsList())) {
					for (DadesEspecifiquesValors dadesEspecifiquesValors : dadesEspecifiquesRDTO.getDadesEspecifiquesValorsList()) {
						// Transformación directa a String excepto para valores
						// de tipo fecha o lista múltiple
						if (CollectionUtils.isNotEmpty(dadesEspecifiquesValors.getValorListaMultipleList())) {
							for (Integer valorListaMultiple : dadesEspecifiquesValors.getValorListaMultipleList()) {
								valorList.add(String.valueOf(valorListaMultiple));
							}
						} else {
							valorStringBuffer = new StringBuffer();
							valorStringBuffer.append((dadesEspecifiquesValors.getValorBoolean() != null)
							        ? dadesEspecifiquesValors.getValorBoolean() : StringUtils.EMPTY);
							valorStringBuffer.append((dadesEspecifiquesValors.getValorCalendar() != null)
							        ? dateTimeFormatter.print(dadesEspecifiquesValors.getValorCalendar()) : StringUtils.EMPTY);
							valorStringBuffer.append((dadesEspecifiquesValors.getValorClob() != null)
							        ? dadesEspecifiquesValors.getValorClob() : StringUtils.EMPTY);
							valorStringBuffer.append((dadesEspecifiquesValors.getValorComarca() != null)
							        ? dadesEspecifiquesValors.getValorComarca() : StringUtils.EMPTY);
							valorStringBuffer.append((dadesEspecifiquesValors.getValorDouble() != null)
							        ? dadesEspecifiquesValors.getValorDouble() : StringUtils.EMPTY);
							valorStringBuffer.append((dadesEspecifiquesValors.getValorInteger() != null)
							        ? dadesEspecifiquesValors.getValorInteger() : StringUtils.EMPTY);
							valorStringBuffer.append((dadesEspecifiquesValors.getValorListaMultiple() != null)
							        ? dadesEspecifiquesValors.getValorListaMultiple() : StringUtils.EMPTY);
							valorStringBuffer.append((dadesEspecifiquesValors.getValorListaSimple() != null)
							        ? dadesEspecifiquesValors.getValorListaSimple() : StringUtils.EMPTY);
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
				dadesAtributsExpedientsRDTO.setValor(valorList);
				dadesAtributsExpedientsRDTOList.add(dadesAtributsExpedientsRDTO);
			}

		}

		return dadesAtributsExpedientsRDTOList;
	}
}