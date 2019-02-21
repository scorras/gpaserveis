package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.ConfDocEntradaRequeritRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.EstatsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ExpedientsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.Persones;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits.AccionsEstatsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaunitats.UnitatsGestoresRDTO;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "DadesExpedientRDTO")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "expedients", "unitatGestora", "historics", "sollicitant", "representant", "personesInteressades",
        "personesImplicades", "accionsPossibles", "documentsAportats", "documentsRequerits" })
@Getter
@Setter
public class DadesExpedientRDTO {

	@JsonProperty("expedients")
	private ExpedientsRDTO expedientsRDTO = null;

	@JsonProperty("unitatGestora")
	private UnitatsGestoresRDTO unitatsGestoresRDTO = null;

	@JsonProperty("historics")
	private List<EstatsRDTO> historicsEstats = null;

	@JsonProperty("sollicitant")
	private Persones sollicitant;

	@JsonProperty("representant")
	private Persones representant;

	@JsonProperty("personesInteressades")
	private List<Persones> personesInteressades;

	@JsonProperty("personesImplicades")
	private List<Persones> personesImplicades;

	@JsonProperty("accionsPossibles")
	private List<AccionsEstatsRDTO> accionsPossibles;

	@JsonProperty("documentsAportats")
	private List<DocsEntradaRDTO> documentsAportats;

	@JsonProperty("documentsRequerits")
	private List<ConfDocEntradaRequeritRDTO> documentsRequerits;

}
