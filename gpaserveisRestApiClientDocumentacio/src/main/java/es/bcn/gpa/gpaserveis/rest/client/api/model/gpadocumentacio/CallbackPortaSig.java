package es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio;

import java.util.Objects;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-05-13T13:50:42.299+02:00")
public class CallbackPortaSig {
	@JsonProperty("codiEstat")
	private String codiEstat = null;

	@JsonProperty("codiPeticio")
	private String codiPeticio = null;

	@JsonProperty("codiUsuari")
	private String codiUsuari = null;

	@JsonProperty("nifUsuari")
	private String nifUsuari = null;

	@JsonProperty("nomCompletUsuari")
	private String nomCompletUsuari = null;

	@JsonProperty("ticketSignatura")
	private String ticketSignatura = null;

	@JsonProperty("tipusPeticio")
	private String tipusPeticio = null;

	@JsonProperty("dataCaducitat")
	private DateTime dataCaducitat = null;

	@JsonProperty("instantSignatura")
	private DateTime instantSignatura = null;

	public CallbackPortaSig codiEstat(String codiEstat) {
		this.codiEstat = codiEstat;
		return this;
	}

	@ApiModelProperty(value = "")
	public String getCodiEstat() {
		return codiEstat;
	}

	public void setCodiEstat(String codiEstat) {
		this.codiEstat = codiEstat;
	}

	public CallbackPortaSig codiPeticio(String codiPeticio) {
		this.codiPeticio = codiPeticio;
		return this;
	}

	@ApiModelProperty(value = "")
	public String getCodiPeticio() {
		return codiPeticio;
	}

	public void setCodiPeticio(String codiPeticio) {
		this.codiPeticio = codiPeticio;
	}

	public CallbackPortaSig codiUsuari(String codiUsuari) {
		this.codiUsuari = codiUsuari;
		return this;
	}

	@ApiModelProperty(value = "")
	public String getCodiUsuari() {
		return codiUsuari;
	}

	public void setCodiUsuari(String codiUsuari) {
		this.codiUsuari = codiUsuari;
	}

	public CallbackPortaSig nifUsuari(String nifUsuari) {
		this.nifUsuari = nifUsuari;
		return this;
	}

	@ApiModelProperty(value = "")
	public String getNifUsuari() {
		return nifUsuari;
	}

	public void setNifUsuari(String nifUsuari) {
		this.nifUsuari = nifUsuari;
	}

	public CallbackPortaSig nomCompletUsuari(String nomCompletUsuari) {
		this.nomCompletUsuari = nomCompletUsuari;
		return this;
	}

	@ApiModelProperty(value = "")
	public String getNomCompletUsuari() {
		return nomCompletUsuari;
	}

	public void setNomCompletUsuari(String nomCompletUsuari) {
		this.nomCompletUsuari = nomCompletUsuari;
	}

	public CallbackPortaSig ticketSignatura(String ticketSignatura) {
		this.ticketSignatura = ticketSignatura;
		return this;
	}

	@ApiModelProperty(value = "")
	public String getTicketSignatura() {
		return ticketSignatura;
	}

	public void setTicketSignatura(String ticketSignatura) {
		this.ticketSignatura = ticketSignatura;
	}

	public CallbackPortaSig tipusPeticio(String tipusPeticio) {
		this.tipusPeticio = tipusPeticio;
		return this;
	}

	@ApiModelProperty(value = "")
	public String getTipusPeticio() {
		return tipusPeticio;
	}

	public void setTipusPeticio(String tipusPeticio) {
		this.tipusPeticio = tipusPeticio;
	}

	public CallbackPortaSig dataCaducitat(DateTime dataCaducitat) {
		this.dataCaducitat = dataCaducitat;
		return this;
	}

	@ApiModelProperty(value = "")
	public DateTime getDataCaducitat() {
		return dataCaducitat;
	}

	public void setDataCaducitat(DateTime dataCaducitat) {
		this.dataCaducitat = dataCaducitat;
	}

	public CallbackPortaSig instantSignatura(DateTime instantSignatura) {
		this.instantSignatura = instantSignatura;
		return this;
	}

	@ApiModelProperty(value = "")
	public DateTime geInstantSignatura() {
		return dataCaducitat;
	}

	public void setInstantSignatura(DateTime instantSignatura) {
		this.instantSignatura = instantSignatura;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		CallbackPortaSig callbackPortaSig = (CallbackPortaSig) o;
		return Objects.equals(this.codiEstat, callbackPortaSig.codiEstat) && Objects.equals(this.codiPeticio, callbackPortaSig.codiPeticio)
				&& Objects.equals(this.codiUsuari, callbackPortaSig.codiUsuari)
				&& Objects.equals(this.nifUsuari, callbackPortaSig.nifUsuari)
				&& Objects.equals(this.nomCompletUsuari, callbackPortaSig.nomCompletUsuari)
				&& Objects.equals(this.ticketSignatura, callbackPortaSig.ticketSignatura)
				&& Objects.equals(this.tipusPeticio, callbackPortaSig.tipusPeticio)
				&& Objects.equals(this.dataCaducitat, callbackPortaSig.dataCaducitat)
				&& Objects.equals(this.instantSignatura, callbackPortaSig.instantSignatura);
	}

	@Override
	public int hashCode() {
		return Objects.hash(codiEstat, codiPeticio, codiUsuari, nifUsuari, nomCompletUsuari, ticketSignatura, tipusPeticio, dataCaducitat,
				instantSignatura);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class UsuariPortaSig {\n");

		sb.append("    codiEstat: ").append(toIndentedString(codiEstat)).append("\n");
		sb.append("    codiPeticio: ").append(toIndentedString(codiPeticio)).append("\n");
		sb.append("    codiUsuari: ").append(toIndentedString(codiUsuari)).append("\n");
		sb.append("    nifUsuari: ").append(toIndentedString(nifUsuari)).append("\n");
		sb.append("    nomCompletUsuari: ").append(toIndentedString(nomCompletUsuari)).append("\n");
		sb.append("    ticketSignatura: ").append(toIndentedString(ticketSignatura)).append("\n");
		sb.append("    tipusPeticio: ").append(toIndentedString(tipusPeticio)).append("\n");
		sb.append("    dataCaducitat: ").append(toIndentedString(dataCaducitat)).append("\n");
		sb.append("    instantSignatura: ").append(toIndentedString(instantSignatura)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
