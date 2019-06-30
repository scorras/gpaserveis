package es.bcn.gpa.gpaserveis.web.rest.controller;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.bcn.gpa.gpaserveis.business.ServeisService;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.CallbackPortaSig;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.Constants;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.portasig.TipusCodiEstatPortasigApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.mciportasig.notificacions.MciPortasigResultatPeticioDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.mciportasig.notificacions.MciPortasigResultatPeticioRespostaDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.mciportasig.notificacions.MciPortasigSignatarisDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.apachecommons.CommonsLog;

/**
 * The Class ServeisPortalRestController.
 */
@RestController
@RequestMapping(value = "/serveis/portasignatures", produces = MediaType.APPLICATION_JSON_VALUE)
@Lazy(true)
@Api(value = "Serveis Portasignatures API", tags = "Serveis Portasignatures API")
@CommonsLog
public class ServeisPortaSignaturesRestController extends BaseRestController {

	/** The serveis service. */
	@Autowired
	private ServeisService serveisService;

	/**
	 * Servei específic que invocarà portasignatures per informar de l'estat de
	 * les peticions.
	 *
	 * @return void
	 */
	@PostMapping("/resultat_peticio")
	@ApiOperation(value = "Resultat de l'estat de les peticions", tags = { "Serveis Portasignatures API" })
	public MciPortasigResultatPeticioRespostaDTO resultatEstatPeticio(
	        @ApiParam(value = "Resultat del portasignatures a una petició de vist-i-plau/signatura", required = true) @RequestBody MciPortasigResultatPeticioDTO resultatPeticio) {

		if (log.isDebugEnabled()) {
			log.debug("resultatEstatPeticio(MciPortasigResultatPeticioDTO) - inici"); //$NON-NLS-1$
			log.debug(resultatPeticio); // $NON-NLS-1$
		}

		MciPortasigResultatPeticioRespostaDTO resposta = new MciPortasigResultatPeticioRespostaDTO();

		try {
			CallbackPortaSig callbackPortaSig = new CallbackPortaSig();
			callbackPortaSig.setCodiEstat(resultatPeticio.getCodiEstat());
			callbackPortaSig.setCodiPeticio(resultatPeticio.getCodiPeticio());
			MciPortasigSignatarisDTO mciPortasigSignatarisDTO = resultatPeticio.getDetallSignataris().get(0);
			callbackPortaSig.setCodiUsuari(mciPortasigSignatarisDTO.getCodiUsuari());
			callbackPortaSig.setNifUsuari(mciPortasigSignatarisDTO.getNifUsuari());
			callbackPortaSig.setNomCompletUsuari(mciPortasigSignatarisDTO.getNomCompletUsuari());
			callbackPortaSig.setTicketPeticio(mciPortasigSignatarisDTO.getTicketPeticio());
			callbackPortaSig.setTipusPeticio(mciPortasigSignatarisDTO.getTipusPeticio());

			if (mciPortasigSignatarisDTO.getCodiEstat().equals(TipusCodiEstatPortasigApiParamValue.COMPLETADA.getApiParamValue())) {
				DateTimeFormatter dataHoraFormatter = DateTimeFormat.forPattern(Constants.DATE_TIME_PATTERN);
				callbackPortaSig.setInstantSignatura(dataHoraFormatter.parseDateTime(mciPortasigSignatarisDTO.getInstantSignatura()));
			} else if (mciPortasigSignatarisDTO.getCodiEstat().equals(TipusCodiEstatPortasigApiParamValue.CADUCADA.getApiParamValue())) {
				DateTimeFormatter dataHoraFormatter = DateTimeFormat.forPattern(Constants.DATE_TIME_PATTERN);
				callbackPortaSig.setDataCaducitat(dataHoraFormatter.parseDateTime(mciPortasigSignatarisDTO.getDataCaducitat()));
			}

			serveisService.callbackPortaSig(callbackPortaSig);

		} catch (Exception e) {
			log.error("resultatEstatPeticio(MciPortasigResultatPeticioDTO)", e);
			// $NON-NLS-1$
			resposta.setCodiError("KO");
			resposta.setDescError(ExceptionUtils.getFullStackTrace(e));
		}

		if (log.isDebugEnabled()) {
			log.debug("resultatPeticio(MciPortasigResultatPeticioDTO) - fi"); //$NON-NLS-1$
		}
		return resposta;
	}

}