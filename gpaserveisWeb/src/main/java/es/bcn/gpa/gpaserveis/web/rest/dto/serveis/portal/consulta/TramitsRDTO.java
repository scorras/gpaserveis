package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="Tramits")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "codi",
    "descripcio"
})
public class TramitsRDTO {
	
	@ApiModelProperty(value="Identificador del tràmit")
    private BigDecimal id;
	@ApiModelProperty(value="Codi del tràmit")
    private String codi;
	@ApiModelProperty(value="Descripció del tràmit")
    private String descripcio;
	public BigDecimal getId() {
		return id;
	}
	public void setId(BigDecimal id) {
		this.id = id;
	}
	public String getCodi() {
		return codi;
	}
	public void setCodi(String codi) {
		this.codi = codi;
	}
	public String getDescripcio() {
		return descripcio;
	}
	public void setDescripcio(String descripcio) {
		this.descripcio = descripcio;
	}
	
}