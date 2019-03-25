package es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.accions.documentacio.upload;

import java.io.IOException;

import org.apache.commons.codec.binary.Base64;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import es.bcn.gpa.gpaserveis.business.exception.GPAServeisRuntimeException;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsEntradaRDTO;

/**
 * The Class MultipartFileToDocsEntradaRDTOMapper.
 */
@Component("multipartFileToDocsEntradaRDTOMapper")
public class MultipartFileToDocsEntradaRDTOMapper extends PropertyMap<MultipartFile, DocsEntradaRDTO> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.PropertyMap#configure()
	 */
	@Override
	protected void configure() {
		try {
			map().setFileToUploadContent(Base64.encodeBase64String(source.getBytes()));
		} catch (IOException e) {
			throw new GPAServeisRuntimeException(e);
		}
	}

}
