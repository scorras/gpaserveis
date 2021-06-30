package es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.sollicitud;

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
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.MunicipisRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PaisosRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ProvinciesRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.Items;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.Constants;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.sollicituds.DadesAtributsSollicitudsRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.sollicituds.DadesAtributsValorsLlistaMultipleRepetibleSollicitudsRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.sollicituds.DadesAtributsValorsLlistaRepetibleSollicitudsRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.sollicituds.DadesAtributsValorsLlistaSollicitudsRDTO;
import lombok.extern.apachecommons.CommonsLog;

/**
 * The Class InternalToDadesOperacioListConverter.
 */
@Component("sollicitudInternalToDadesOperacioListConverter")
@CommonsLog
public class InternalToDadesOperacioListConverter extends AbstractConverter<List<DadaEspecificaBDTO>, List<DadesAtributsSollicitudsRDTO>> {

	@Autowired
	private ServeisService serveisService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.AbstractConverter#convert(java.lang.Object)
	 */
	@Override
	protected List<DadesAtributsSollicitudsRDTO> convert(List<DadaEspecificaBDTO> source) {
		List<DadesAtributsSollicitudsRDTO> dadesAtributsSollicitudsRDTOList = null;
		DadesAtributsSollicitudsRDTO dadesAtributsSollicitudsRDTO = null;
		String index = null;
		List<String> valorList = null;
		List<String> valorCastellaList = null;
		List<DadesAtributsValorsLlistaSollicitudsRDTO> valorsLlistaList = null;
		MunicipisRDTO municipisRDTO = null;
		ProvinciesRDTO provinciesRDTO = null;
		PaisosRDTO paisosRDTO = null;
		StringBuffer valorStringBuffer = null;
		StringBuffer valorCastellaStringBuffer = null;
		List<DadesAtributsValorsLlistaRepetibleSollicitudsRDTO> valorsLlistaRepetibleList = null;
		List<DadesAtributsValorsLlistaMultipleRepetibleSollicitudsRDTO> valorsLlistaMultipleRepetibleList = null;

		if (CollectionUtils.isNotEmpty(source)) {
			DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(Constants.DATE_TIME_PATTERN);
			dadesAtributsSollicitudsRDTOList = new ArrayList<DadesAtributsSollicitudsRDTO>();
			for (DadaEspecificaBDTO dadaEspecificaBDTO : source) {
				dadesAtributsSollicitudsRDTO = new DadesAtributsSollicitudsRDTO();
				dadesAtributsSollicitudsRDTO.setCodi(dadaEspecificaBDTO.getDadaOperacio().getCodi());
				index = null;
				municipisRDTO = null;
				provinciesRDTO = null;
				paisosRDTO = null;
				valorList = new ArrayList<String>();
				valorCastellaList = new ArrayList<String>();
				valorsLlistaList = new ArrayList<DadesAtributsValorsLlistaSollicitudsRDTO>();
				valorsLlistaRepetibleList = new ArrayList<DadesAtributsValorsLlistaRepetibleSollicitudsRDTO>();
				valorsLlistaMultipleRepetibleList = new ArrayList<DadesAtributsValorsLlistaMultipleRepetibleSollicitudsRDTO>();
				List<HashMap<Integer, Integer>> valorsListaMultiple = new ArrayList<HashMap<Integer, Integer>>();
				List<Integer> ordreRepeticioList = new ArrayList<Integer>();
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
										valorCastellaStringBuffer = new StringBuffer();
										valorCastellaStringBuffer.append(valorCastella);
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
				}
				if (dadaEspecificaBDTO.getDadaEspecificaRepetible() != null && CollectionUtils.isNotEmpty(dadaEspecificaBDTO.getDadaEspecificaRepetible().getDadesEspecifiquesValorsJsonList())) {
					//TODO
					/*
					for (DadesEspecifiquesValorsJson dadesEspecifiquesValorsJson : dadaEspecificaBDTO.getDadaEspecificaRepetible()
							.getDadesEspecifiquesValorsJsonList()) {
					}
					*/
				}
				
				if (!valorsListaMultiple.isEmpty()) {
					Collections.sort(ordreRepeticioList);
					for(Integer ordreRepeticio : ordreRepeticioList) {
						DadesAtributsValorsLlistaMultipleRepetibleSollicitudsRDTO dadesAtributsValorsLlistaMultipleRepetibleSollicitudsRDTO = new DadesAtributsValorsLlistaMultipleRepetibleSollicitudsRDTO();
						List<DadesAtributsValorsLlistaRepetibleSollicitudsRDTO> dadesAtributsValorsLlistaRepetibleSollicitudsRDTOList = new ArrayList<DadesAtributsValorsLlistaRepetibleSollicitudsRDTO>();
						for (HashMap<Integer, Integer> entry : valorsListaMultiple) {
							if (entry.containsKey(ordreRepeticio)) {
								dadesAtributsValorsLlistaRepetibleSollicitudsRDTOList.add(obtenirDadesAtributsValorsLlistaRepetible(entry.get(ordreRepeticio),
								dadaEspecificaBDTO.getDadaOperacio().getItemsList()));
							}
						}
						dadesAtributsValorsLlistaMultipleRepetibleSollicitudsRDTO.setValorsLlistaRepetible(dadesAtributsValorsLlistaRepetibleSollicitudsRDTOList);
						valorsLlistaMultipleRepetibleList.add(dadesAtributsValorsLlistaMultipleRepetibleSollicitudsRDTO);
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
				dadesAtributsSollicitudsRDTO.setIndex(index);
				dadesAtributsSollicitudsRDTO.setValor(valorList);
				dadesAtributsSollicitudsRDTO.setValorCastella(valorCastellaList);
				dadesAtributsSollicitudsRDTO.setValorsLlista(valorsLlistaList);
				dadesAtributsSollicitudsRDTO.setValorsLlistaRepetible(valorsLlistaRepetibleList);
				dadesAtributsSollicitudsRDTO.setValorsLlistaMultipleRepetible(valorsLlistaMultipleRepetibleList);
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
	 * @return the dades atributs valors llista sollicituds RDTO
	 */
	private DadesAtributsValorsLlistaSollicitudsRDTO obtenirItemLlista(Integer valorLlista, List<Items> itemsList) {
		for (Items items : itemsList) {
			if (items.getItemId().intValue() == valorLlista.intValue()) {
				DadesAtributsValorsLlistaSollicitudsRDTO dadesAtributsValorsLlistaSollicitudsRDTO = new DadesAtributsValorsLlistaSollicitudsRDTO();
				dadesAtributsValorsLlistaSollicitudsRDTO.setIndex(items.getItemId().toString());
				dadesAtributsValorsLlistaSollicitudsRDTO.setValor(items.getItemDescripcio());
				dadesAtributsValorsLlistaSollicitudsRDTO.setValorCastella(items.getItemDescripcioCastella());
				return dadesAtributsValorsLlistaSollicitudsRDTO;
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
	 * @return the dades atributs valors llista sollicituds RDTO
	 */
	private DadesAtributsValorsLlistaSollicitudsRDTO obtenirItemLlistaMunicipi(MunicipisRDTO municipisRDTO, String codiIneMunicipiComplet) {
		DadesAtributsValorsLlistaSollicitudsRDTO dadesAtributsValorsLlistaSollicitudsRDTO = new DadesAtributsValorsLlistaSollicitudsRDTO();
		dadesAtributsValorsLlistaSollicitudsRDTO.setIndex(codiIneMunicipiComplet);
		dadesAtributsValorsLlistaSollicitudsRDTO.setValor((municipisRDTO != null) ? municipisRDTO.getNom() : StringUtils.EMPTY);
		return dadesAtributsValorsLlistaSollicitudsRDTO;
	}

	/**
	 * Obtenir item llista provincia.
	 *
	 * @param provinciesRDTO
	 *            the provincies RDTO
	 * @param codiIneProvincia
	 *            the codi ine provincia
	 * @return the dades atributs valors llista sollicituds RDTO
	 */
	private DadesAtributsValorsLlistaSollicitudsRDTO obtenirItemLlistaProvincia(ProvinciesRDTO provinciesRDTO, String codiIneProvincia) {
		DadesAtributsValorsLlistaSollicitudsRDTO dadesAtributsValorsLlistaSollicitudsRDTO = new DadesAtributsValorsLlistaSollicitudsRDTO();
		dadesAtributsValorsLlistaSollicitudsRDTO.setIndex(codiIneProvincia);
		dadesAtributsValorsLlistaSollicitudsRDTO.setValor((provinciesRDTO != null) ? provinciesRDTO.getNom() : StringUtils.EMPTY);
		return dadesAtributsValorsLlistaSollicitudsRDTO;
	}

	/**
	 * Obtenir item llista pais.
	 *
	 * @param paisosRDTO
	 *            the paisos RDTO
	 * @param codiInePais
	 *            the codi ine pais
	 * @return the dades atributs valors llista sollicituds RDTO
	 */
	private DadesAtributsValorsLlistaSollicitudsRDTO obtenirItemLlistaPais(PaisosRDTO paisosRDTO, String codiInePais) {
		DadesAtributsValorsLlistaSollicitudsRDTO dadesAtributsValorsLlistaSollicitudsRDTO = new DadesAtributsValorsLlistaSollicitudsRDTO();
		dadesAtributsValorsLlistaSollicitudsRDTO.setIndex(codiInePais);
		dadesAtributsValorsLlistaSollicitudsRDTO.setValor((paisosRDTO != null) ? paisosRDTO.getNom() : StringUtils.EMPTY);
		return dadesAtributsValorsLlistaSollicitudsRDTO;
	}
	
	
	/**
	 * Obtenir item llista.
	 *
	 * @param valorLlista
	 *            the valor llista
	 * @param itemsList
	 *            the items list
	 * @return the dades atributs valors llista repetible sollicituds RDTO
	 */
	private DadesAtributsValorsLlistaRepetibleSollicitudsRDTO obtenirDadesAtributsValorsLlistaRepetible(Integer valorLlista, List<Items> itemsList) {
		DadesAtributsValorsLlistaRepetibleSollicitudsRDTO dadesAtributsValorsLlistaRepetibleSollicitudsRDTO = new DadesAtributsValorsLlistaRepetibleSollicitudsRDTO();
		List<DadesAtributsValorsLlistaSollicitudsRDTO> llistaList = new ArrayList<DadesAtributsValorsLlistaSollicitudsRDTO>();
		DadesAtributsValorsLlistaSollicitudsRDTO dadesAtributsValorsLlistaSollicitudsRDTO = obtenirItemLlista(valorLlista, itemsList);
		llistaList.add(dadesAtributsValorsLlistaSollicitudsRDTO);
		dadesAtributsValorsLlistaRepetibleSollicitudsRDTO.setValorsLlista(llistaList);
		return dadesAtributsValorsLlistaRepetibleSollicitudsRDTO;
	}
}