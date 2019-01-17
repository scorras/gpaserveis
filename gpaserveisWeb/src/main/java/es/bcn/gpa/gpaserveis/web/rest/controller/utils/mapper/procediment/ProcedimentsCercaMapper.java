package es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.procediment;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.PropertyMap;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.ProcedimentsRDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.BaseApiParamValueConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.impl.procediment.EstatApiParamValueConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.impl.procediment.TramitadorApiParamValueConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.procediment.TramitadorApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.UnitatGestoraRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.cerca.procediments.ProcedimentsCercaRDTO;

/**
 * The Class ProcedimentsCercaMapper.
 */
public class ProcedimentsCercaMapper extends PropertyMap<ProcedimentsRDTO, ProcedimentsCercaRDTO> {

	/** The estat api param value converter. */
	private BaseApiParamValueConverter estatApiParamValueConverter = new EstatApiParamValueConverter();

	/** The tramitador api param value converter. */
	private BaseApiParamValueConverter tramitadorApiParamValueConverter = new TramitadorApiParamValueConverter();

	/** The ugr converter. */
	final Converter<String, UnitatGestoraRDTO> ugrConverter = new AbstractConverter<String, UnitatGestoraRDTO>() {
		@Override
		protected UnitatGestoraRDTO convert(String source) {
			UnitatGestoraRDTO unitatGestoraRDTO = new UnitatGestoraRDTO();
			unitatGestoraRDTO.setNom(source);
			return unitatGestoraRDTO;
		}
	};

	/** The ugo converter. */
	final Converter<String, List<UnitatGestoraRDTO>> ugoConverter = new AbstractConverter<String, List<UnitatGestoraRDTO>>() {
		@Override
		protected List<UnitatGestoraRDTO> convert(String source) {
			List<UnitatGestoraRDTO> unitatGestoraRDTOList = new ArrayList<UnitatGestoraRDTO>();
			UnitatGestoraRDTO unitatGestoraRDTO = null;
			if (StringUtils.isNotEmpty(source)) {
				String[] ugoNomList = source.split("\\s*,\\s*");
				for (String ugoNom : ugoNomList) {
					unitatGestoraRDTO = new UnitatGestoraRDTO();
					unitatGestoraRDTO.setNom(ugoNom);
					unitatGestoraRDTOList.add(unitatGestoraRDTO);
				}
			}
			return unitatGestoraRDTOList;
		}
	};

	/** The estat converter. */
	final Converter<BigDecimal, String> estatConverter = new AbstractConverter<BigDecimal, String>() {
		@Override
		protected String convert(BigDecimal source) {
			return estatApiParamValueConverter.getApiParamValueByInternalValue(source);
		}
	};

	/** The tramitador converter. */
	final Converter<String, String> tramitadorConverter = new AbstractConverter<String, String>() {
		@Override
		protected String convert(String source) {
			Integer internalValue = StringUtils.isEmpty(source) ? TramitadorApiParamValue.OGE.getInternalValue()
	                : TramitadorApiParamValue.APLICACIO_DE_NEGOCI.getInternalValue();

			return tramitadorApiParamValueConverter.getApiParamValueByInternalValue(internalValue);
		}
	};

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.PropertyMap#configure()
	 */
	@Override
	protected void configure() {
		map().setId(source.getId());
		map().setCodi(source.getCodi());
		map().setVersio(source.getVersio());
		map().setNom(source.getNom());
		map().setDescripcio(source.getDescripcio());
		using(ugrConverter).map(source.getUgrNom()).setUgr(null);
		using(ugoConverter).map(source.getUgosNoms()).setUgo(null);
		using(estatConverter).map(source.getEstatProcediment()).setEstat(null);
		using(tramitadorConverter).map(source.getReqOperatius().getAplicacioNegoci()).setTramitador(null);
		map().setAplicacioNegoci(source.getReqOperatius().getAplicacioNegoci());

	}

}
