package es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.modelmapper.AbstractConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.business.ServeisService;
import es.bcn.gpa.gpaserveis.business.dto.expedients.DadaEspecificaBDTO;
import es.bcn.gpa.gpaserveis.business.exception.GPAServeisServiceException;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.DadesEspecifiquesValors;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.DadesEspecifiquesValorsJson;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.MunicipisRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PaisosRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ProvinciesRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.Items;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.Constants;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.expedients.DadesAtributsExpedientsRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.expedients.DadesAtributsValorsLlistaExpedientsRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.expedients.DadesAtributsValorsLlistaMultipleRepetibleExpedientsRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.expedients.DadesAtributsValorsLlistaRepetibleExpedientsRDTO;
import lombok.extern.apachecommons.CommonsLog;

/**
 * The Class InternalToDadesOperacioListConverter.
 */
@Component("expedientInternalToDadesOperacioListConverter")
@CommonsLog
public class InternalToDadesOperacioListConverter extends AbstractConverter<List<DadaEspecificaBDTO>, List<DadesAtributsExpedientsRDTO>> {

	@Autowired
	private ServeisService serveisService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.AbstractConverter#convert(java.lang.Object)
	 */
	@Override
	protected List<DadesAtributsExpedientsRDTO> convert(List<DadaEspecificaBDTO> source) {
		List<DadesAtributsExpedientsRDTO> dadesAtributsExpedientsRDTOList = null;
		DadesAtributsExpedientsRDTO dadesAtributsExpedientsRDTO = null;
		String index = null;
		List<String> valorList = null;
		List<String> valorListRepetible = null;
		List<String> valorCastellaList = null;
		List<DadesAtributsValorsLlistaExpedientsRDTO> valorsLlistaList = null;
		List<DadesAtributsValorsLlistaRepetibleExpedientsRDTO> valorsLlistaRepetibleList = null;
		List<DadesAtributsValorsLlistaMultipleRepetibleExpedientsRDTO> valorsLlistaMultipleRepetibleList = null;
		MunicipisRDTO municipisRDTO = null;
		ProvinciesRDTO provinciesRDTO = null;
		PaisosRDTO paisosRDTO = null;
		StringBuffer valorStringBuffer = null;
		StringBuffer valorCastellaStringBuffer = null;

		if (CollectionUtils.isNotEmpty(source)) {
			DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(Constants.DATE_TIME_PATTERN);
			dadesAtributsExpedientsRDTOList = new ArrayList<DadesAtributsExpedientsRDTO>();
			for (DadaEspecificaBDTO dadaEspecificaBDTO : source) {
				dadesAtributsExpedientsRDTO = new DadesAtributsExpedientsRDTO();
				dadesAtributsExpedientsRDTO.setCodi(dadaEspecificaBDTO.getDadaOperacio().getCodi());
				index = null;
				municipisRDTO = null;
				provinciesRDTO = null;
				paisosRDTO = null;
				valorList = new ArrayList<String>();
				valorCastellaList = new ArrayList<String>();
				valorsLlistaList = new ArrayList<DadesAtributsValorsLlistaExpedientsRDTO>();
				valorsLlistaRepetibleList = new ArrayList<DadesAtributsValorsLlistaRepetibleExpedientsRDTO>();
				valorsLlistaMultipleRepetibleList = new ArrayList<DadesAtributsValorsLlistaMultipleRepetibleExpedientsRDTO>();
				List<HashMap<Integer, Integer>> valorsListaMultiple = new ArrayList<HashMap<Integer, Integer>>();
				List<Integer> ordreRepeticioList = new ArrayList<Integer>();
				valorListRepetible = new ArrayList<String>();
				if (dadaEspecificaBDTO.getDadaEspecifica() != null && CollectionUtils.isNotEmpty(dadaEspecificaBDTO.getDadaEspecifica().getDadesEspecifiquesValorsList())) {
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
							valorCastellaStringBuffer = new StringBuffer();
							
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
							if (dadesEspecifiquesValors.getValorListaMultiple() != null) {
								if (dadesEspecifiquesValors.getOrdreRepeticio() != null && dadesEspecifiquesValors.getOrdreRepeticioMultiple() != null) {
									HashMap<Integer, Integer> valorsListaMultipleMap = new HashMap<Integer, Integer>();
									valorsListaMultipleMap.put(dadesEspecifiquesValors.getOrdreRepeticio(), dadesEspecifiquesValors.getValorListaMultiple());
									valorsListaMultiple.add(valorsListaMultipleMap);
									if (!ordreRepeticioList.contains(dadesEspecifiquesValors.getOrdreRepeticio())) {
										ordreRepeticioList.add(dadesEspecifiquesValors.getOrdreRepeticio());
									}
								} else {
									valorsLlistaList.add(obtenirItemLlista(dadesEspecifiquesValors.getValorListaMultiple(),
									        dadaEspecificaBDTO.getDadaOperacio().getItemsList()));
								}
							} else {
								valorStringBuffer.append(StringUtils.EMPTY);
							}
							if (dadesEspecifiquesValors.getValorListaSimple() != null) {
								if (dadesEspecifiquesValors.getOrdreRepeticio() != null) {
									valorsLlistaRepetibleList.add(obtenirDadesAtributsValorsLlistaRepetible(dadesEspecifiquesValors.getValorListaSimple(),
									        dadaEspecificaBDTO.getDadaOperacio().getItemsList()));
								} else {
									valorsLlistaList.add(obtenirItemLlista(dadesEspecifiquesValors.getValorListaSimple(),
									        dadaEspecificaBDTO.getDadaOperacio().getItemsList()));
									index = obtenirIndexItemLlista(dadesEspecifiquesValors.getValorListaSimple(),
									        dadaEspecificaBDTO.getDadaOperacio().getItemsList());
									valorStringBuffer.append(obtenirDescripcioItemLlista(dadesEspecifiquesValors.getValorListaSimple(),
									        dadaEspecificaBDTO.getDadaOperacio().getItemsList()));
									
									String valorCastella = obtenirDescripcioCastellaItemLlista(dadesEspecifiquesValors.getValorListaSimple(),
									        dadaEspecificaBDTO.getDadaOperacio().getItemsList());
									if(StringUtils.isNotEmpty(valorCastella)){
										valorCastellaStringBuffer.append(valorCastella);
									} else {
										valorCastellaStringBuffer.append(StringUtils.EMPTY);
									}
								}
							} else {
								valorStringBuffer.append(StringUtils.EMPTY);
							}
							valorStringBuffer.append((dadesEspecifiquesValors.getValorMoneda() != null)
							        ? dadesEspecifiquesValors.getValorMoneda() : StringUtils.EMPTY);
							if (dadesEspecifiquesValors.getValorMunicipi() != null) {
								try {
									municipisRDTO = serveisService.consultarMunicipisByCodi(
									        dadesEspecifiquesValors.getValorMunicipi().substring(3),
									        dadesEspecifiquesValors.getValorMunicipi().substring(0, 3));
								} catch (GPAServeisServiceException e) {
									log.error("No s'ha pogut obtenir la informació del municipi", e);
								}
								valorsLlistaList.add(obtenirItemLlistaMunicipi(municipisRDTO, dadesEspecifiquesValors.getValorMunicipi()));
								index = dadesEspecifiquesValors.getValorMunicipi();
								valorStringBuffer.append((municipisRDTO != null) ? municipisRDTO.getNom() : StringUtils.EMPTY);
							} else {
								valorStringBuffer.append(StringUtils.EMPTY);
							}
							if (dadesEspecifiquesValors.getValorProvincia() != null) {
								try {
									provinciesRDTO = serveisService.consultarProvinciesByCodi(dadesEspecifiquesValors.getValorProvincia());
								} catch (GPAServeisServiceException e) {
									log.error("No s'ha pogut obtenir la informació de la província", e);
								}
								valorsLlistaList
								        .add(obtenirItemLlistaProvincia(provinciesRDTO, dadesEspecifiquesValors.getValorProvincia()));
								index = dadesEspecifiquesValors.getValorProvincia();
								valorStringBuffer.append((provinciesRDTO != null) ? provinciesRDTO.getNom() : StringUtils.EMPTY);
							} else {
								valorStringBuffer.append(StringUtils.EMPTY);
							}
							if (dadesEspecifiquesValors.getValorPais() != null) {
								try {
									paisosRDTO = serveisService.consultarPaisosByCodi(dadesEspecifiquesValors.getValorPais());
								} catch (GPAServeisServiceException e) {
									log.error("No s'ha pogut obtenir la informació del municipi", e);
								}
								valorsLlistaList.add(obtenirItemLlistaPais(paisosRDTO, dadesEspecifiquesValors.getValorPais()));
								index = dadesEspecifiquesValors.getValorPais();
								valorStringBuffer.append((paisosRDTO != null) ? paisosRDTO.getNom() : StringUtils.EMPTY);
							} else {
								valorStringBuffer.append(StringUtils.EMPTY);
							}
							valorStringBuffer.append((dadesEspecifiquesValors.getValorString() != null)
							        ? dadesEspecifiquesValors.getValorString() : StringUtils.EMPTY);

							if (StringUtils.isNotBlank(valorStringBuffer.toString())) {
								valorList.add(valorStringBuffer.toString());
							}
							if(valorCastellaStringBuffer != null && StringUtils.isNotEmpty(valorCastellaStringBuffer.toString())){
								valorCastellaList.add(valorCastellaStringBuffer.toString());
							}
						}
					}
					
					if (!valorsListaMultiple.isEmpty()) {
						Collections.sort(ordreRepeticioList);
						for(Integer ordreRepeticio : ordreRepeticioList) {
							DadesAtributsValorsLlistaMultipleRepetibleExpedientsRDTO dadesAtributsValorsLlistaMultipleRepetibleExpedientsRDTO = new DadesAtributsValorsLlistaMultipleRepetibleExpedientsRDTO();
							List<DadesAtributsValorsLlistaRepetibleExpedientsRDTO> dadesAtributsValorsLlistaRepetibleExpedientsRDTOList = new ArrayList<DadesAtributsValorsLlistaRepetibleExpedientsRDTO>();
							for (HashMap<Integer, Integer> entry : valorsListaMultiple) {
								if (entry.containsKey(ordreRepeticio)) {
									dadesAtributsValorsLlistaRepetibleExpedientsRDTOList.add(obtenirDadesAtributsValorsLlistaRepetible(entry.get(ordreRepeticio),
									dadaEspecificaBDTO.getDadaOperacio().getItemsList()));
								}
							}
							dadesAtributsValorsLlistaMultipleRepetibleExpedientsRDTO.setValorsLlistaRepetible(dadesAtributsValorsLlistaRepetibleExpedientsRDTOList);
							valorsLlistaMultipleRepetibleList.add(dadesAtributsValorsLlistaMultipleRepetibleExpedientsRDTO);
						}
					}
				}
				
				
				if (dadaEspecificaBDTO.getDadaEspecificaRepetible() != null && CollectionUtils.isNotEmpty(dadaEspecificaBDTO.getDadaEspecificaRepetible().getDadesEspecifiquesValorsJsonList())) {
					if (dadaEspecificaBDTO.getDadaOperacio().getCodi().contains(Constants.CODI_GRUP_) &&
							StringUtils.isNotEmpty(dadaEspecificaBDTO.getDadaOperacio().getTitolGrup())) {
						dadesAtributsExpedientsRDTO.setTitol(dadaEspecificaBDTO.getDadaOperacio().getTitolGrup());
					}
					for (DadesEspecifiquesValorsJson dadesEspecifiquesValorsJson : dadaEspecificaBDTO.getDadaEspecificaRepetible()
							.getDadesEspecifiquesValorsJsonList()) {
						valorStringBuffer = new StringBuffer();
						valorStringBuffer.append((dadesEspecifiquesValorsJson.getValorJson() != null)
						        ? dadesEspecifiquesValorsJson.getValorJson() : StringUtils.EMPTY);
						if (StringUtils.isNotBlank(valorStringBuffer.toString())) {
							valorListRepetible.add(valorStringBuffer.toString());
						}
					}
				}
				
				// Con el objetivo de que no aparezcan en el XML, las listas que
				// van vacías se ponen a null
				if (CollectionUtils.isEmpty(valorList)) {
					valorList = null;
				}
				if (CollectionUtils.isEmpty(valorsLlistaList)) {
					valorsLlistaList = null;
				}
				if(CollectionUtils.isEmpty(valorCastellaList)){
					valorCastellaList = null;
				}
				if(CollectionUtils.isEmpty(valorsLlistaRepetibleList)){
					valorsLlistaRepetibleList = null;
				}
				if(CollectionUtils.isEmpty(valorsLlistaMultipleRepetibleList)){
					valorsLlistaMultipleRepetibleList = null;
				}
				if (CollectionUtils.isEmpty(valorListRepetible)) {
					valorListRepetible = null;
				}
				dadesAtributsExpedientsRDTO.setIndex(index);
				dadesAtributsExpedientsRDTO.setValor(valorList);
				dadesAtributsExpedientsRDTO.setValorCastella(valorCastellaList);
				dadesAtributsExpedientsRDTO.setValorsLlista(valorsLlistaList);
				dadesAtributsExpedientsRDTO.setValorsLlistaRepetible(valorsLlistaRepetibleList);
				dadesAtributsExpedientsRDTO.setValorsLlistaMultipleRepetible(valorsLlistaMultipleRepetibleList);
				dadesAtributsExpedientsRDTO.setValorRepetible(valorListRepetible);
				dadesAtributsExpedientsRDTOList.add(dadesAtributsExpedientsRDTO);
			}

		}

		return dadesAtributsExpedientsRDTOList;
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
	
	/**
	 * Obtenir descripcio castella item llista.
	 *
	 * @param valorLlista the valor llista
	 * @param itemsList the items list
	 * @return the string
	 */
	private String obtenirDescripcioCastellaItemLlista(Integer valorLlista, List<Items> itemsList) {
		for (Items items : itemsList) {
			if (items.getItemId().intValue() == valorLlista.intValue()) {
				return items.getItemDescripcioCastella();
			}
		}
		return null;
	}

	/**
	 * Obtenir index item llista.
	 *
	 * @param valorLlista
	 *            the valor llista
	 * @param itemsList
	 *            the items list
	 * @return the string
	 */
	private String obtenirIndexItemLlista(Integer valorLlista, List<Items> itemsList) {
		for (Items items : itemsList) {
			if (items.getItemId().intValue() == valorLlista.intValue()) {
				return items.getItemId().toString();
			}
		}
		return null;
	}

	/**
	 * Obtenir item llista.
	 *
	 * @param valorLlista
	 *            the valor llista
	 * @param itemsList
	 *            the items list
	 * @return the dades atributs valors llista expedients RDTO
	 */
	private DadesAtributsValorsLlistaExpedientsRDTO obtenirItemLlista(Integer valorLlista, List<Items> itemsList) {
		for (Items items : itemsList) {
			if (items.getItemId().intValue() == valorLlista.intValue()) {
				DadesAtributsValorsLlistaExpedientsRDTO dadesAtributsValorsLlistaExpedientsRDTO = new DadesAtributsValorsLlistaExpedientsRDTO();
				dadesAtributsValorsLlistaExpedientsRDTO.setIndex(items.getItemId().toString());
				dadesAtributsValorsLlistaExpedientsRDTO.setValor(items.getItemDescripcio());
				dadesAtributsValorsLlistaExpedientsRDTO.setValorCastella(items.getItemDescripcioCastella());
				return dadesAtributsValorsLlistaExpedientsRDTO;
			}
		}
		return null;
	}

	/**
	 * Obtenir item llista municipi.
	 *
	 * @param municipisRDTO
	 *            the municipis RDTO
	 * @param codiIneMunicipiComplet
	 *            the codi ine municipi complet
	 * @return the dades atributs valors llista expedients RDTO
	 */
	private DadesAtributsValorsLlistaExpedientsRDTO obtenirItemLlistaMunicipi(MunicipisRDTO municipisRDTO, String codiIneMunicipiComplet) {
		DadesAtributsValorsLlistaExpedientsRDTO dadesAtributsValorsLlistaExpedientsRDTO = new DadesAtributsValorsLlistaExpedientsRDTO();
		dadesAtributsValorsLlistaExpedientsRDTO.setIndex(codiIneMunicipiComplet);
		dadesAtributsValorsLlistaExpedientsRDTO.setValor((municipisRDTO != null) ? municipisRDTO.getNom() : StringUtils.EMPTY);
		return dadesAtributsValorsLlistaExpedientsRDTO;
	}

	/**
	 * Obtenir item llista provincia.
	 *
	 * @param provinciesRDTO
	 *            the provincies RDTO
	 * @param codiIneProvincia
	 *            the codi ine provincia
	 * @return the dades atributs valors llista expedients RDTO
	 */
	private DadesAtributsValorsLlistaExpedientsRDTO obtenirItemLlistaProvincia(ProvinciesRDTO provinciesRDTO, String codiIneProvincia) {
		DadesAtributsValorsLlistaExpedientsRDTO dadesAtributsValorsLlistaExpedientsRDTO = new DadesAtributsValorsLlistaExpedientsRDTO();
		dadesAtributsValorsLlistaExpedientsRDTO.setIndex(codiIneProvincia);
		dadesAtributsValorsLlistaExpedientsRDTO.setValor((provinciesRDTO != null) ? provinciesRDTO.getNom() : StringUtils.EMPTY);
		return dadesAtributsValorsLlistaExpedientsRDTO;
	}

	/**
	 * Obtenir item llista pais.
	 *
	 * @param paisosRDTO
	 *            the paisos RDTO
	 * @param codiInePais
	 *            the codi ine pais
	 * @return the dades atributs valors llista expedients RDTO
	 */
	private DadesAtributsValorsLlistaExpedientsRDTO obtenirItemLlistaPais(PaisosRDTO paisosRDTO, String codiInePais) {
		DadesAtributsValorsLlistaExpedientsRDTO dadesAtributsValorsLlistaExpedientsRDTO = new DadesAtributsValorsLlistaExpedientsRDTO();
		dadesAtributsValorsLlistaExpedientsRDTO.setIndex(codiInePais);
		dadesAtributsValorsLlistaExpedientsRDTO.setValor((paisosRDTO != null) ? paisosRDTO.getNom() : StringUtils.EMPTY);
		return dadesAtributsValorsLlistaExpedientsRDTO;
	}
	
	/**
	 * Obtenir item llista.
	 *
	 * @param valorLlista
	 *            the valor llista
	 * @param itemsList
	 *            the items list
	 * @return the dades atributs valors llista repetible expedients RDTO
	 */
	private DadesAtributsValorsLlistaRepetibleExpedientsRDTO obtenirDadesAtributsValorsLlistaRepetible(Integer valorLlista, List<Items> itemsList) {
		DadesAtributsValorsLlistaRepetibleExpedientsRDTO dadesAtributsValorsLlistaRepetibleExpedientsRDTO = new DadesAtributsValorsLlistaRepetibleExpedientsRDTO();
		List<DadesAtributsValorsLlistaExpedientsRDTO> llistaList = new ArrayList<DadesAtributsValorsLlistaExpedientsRDTO>();
		DadesAtributsValorsLlistaExpedientsRDTO dadesAtributsValorsLlistaExpedientsRDTO = obtenirItemLlista(valorLlista, itemsList);
		llistaList.add(dadesAtributsValorsLlistaExpedientsRDTO);
		dadesAtributsValorsLlistaRepetibleExpedientsRDTO.setValorsLlista(llistaList);
		return dadesAtributsValorsLlistaRepetibleExpedientsRDTO;
	}
}