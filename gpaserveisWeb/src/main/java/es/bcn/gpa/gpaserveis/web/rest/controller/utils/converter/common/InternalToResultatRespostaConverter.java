package es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.common;

import org.apache.commons.lang.StringUtils;
import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.business.dto.RespostaResultatBDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.ErrorDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.ResultatRespostaDTO;

/**
 * The Class InternalToResultatRespostaConverter.
 */
@Component("internalToResultatRespostaConverter")
public class InternalToResultatRespostaConverter extends AbstractConverter<RespostaResultatBDTO, ResultatRespostaDTO> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.AbstractConverter#convert(java.lang.Object)
	 */
	@Override
	protected ResultatRespostaDTO convert(RespostaResultatBDTO source) {
		ResultatRespostaDTO resultatRespostaDTO = new ResultatRespostaDTO();

		resultatRespostaDTO.setCodi(source.getResultat().getCodi());
		resultatRespostaDTO.setDescripcio(source.getResultat().getDescripcio());
		if (source.getErrorPrincipal() != null) {
			ErrorDTO errorDTO = new ErrorDTO();
			errorDTO.setCodi(source.getErrorPrincipal().getCodi());
			errorDTO.setDescripcio(source.getErrorPrincipal().getDescripcio()
			        + (StringUtils.isEmpty(source.getMissatgeAddicional()) ? StringUtils.EMPTY : source.getMissatgeAddicional()));
			resultatRespostaDTO.setDetallError(errorDTO);
		}
		return resultatRespostaDTO;
	}
}