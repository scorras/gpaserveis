package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.accions.expedients;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.PersonesRDTO;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "CrearTerceraPersona")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "persona" })
@XmlRootElement(name = "TERCERA_PERSONA")
@XmlType(name = "CrearTerceraPersona", propOrder = { "persona" })
@XmlAccessorType(XmlAccessType.NONE)
@Getter
@Setter
public class CrearTerceraPersonaRDTO {

	@XmlElement(name = "TERCERA_PERSONA", required = true)
	private PersonesRDTO persona;

}
