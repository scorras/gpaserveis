package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.mciportasig.notificacions;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ApiModel(value = "MciPortasigSignataris")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "codiUsuari", "nifUsuari", "nomCompletUsuari", "tipusPeticio", "tipusDocument", "ordreIntervencio", "esObligada",
		"dataCaducitat", "codiEstat", "raoRetorn", "ticketPeticio", "carrec", "tractament", "instantSignatura" })
@Getter
@Setter
@ToString
public class MciPortasigSignatarisDTO {

	@ApiModelProperty(required = true, value = "Identificador ControlUser de l'usuari que ha de signar/validar el document. Té 10 posicions com màxim. Requerit.")
	private String codiUsuari;
	@ApiModelProperty(required = true, value = "NIF del usuari. 9 posicions. Requerit.")
	private String nifUsuari;
	@ApiModelProperty("Nom i cognoms del usuari. 60 posicions com màxim. Opcional.")
	private String nomCompletUsuari;
	@ApiModelProperty(required = true, value = "Amb 2 valors possibles: SIGNATURA i VIST_I_PLAU, indicant si es demana de l'usuari que signi o que validi el document. Requerit.", allowableValues = "SIGNATURA,VIST_I_PLAU")
	private String tipusPeticio;
	@ApiModelProperty(required = true, value = "Amb el mateix significat que el paràmetre tipusDocument en les interfícies E/S de MciSignatura 1.0 o que el paràmetre política en MciSignatura 2.0. Té 50 posicions com màxim. Requerit.")
	private String tipusDocument;
	@ApiModelProperty("Valor numèric que indica si a aquest usuari se li demanarà que signi abans o desprès que a la resta d'usuaris signataris, es a dir, permet definir circuits seqüencials; primer es demanarà al que tingui el valor més baix (per exemple, 1), després al següent valor més baix (per exemple, 2) i així successivament. A més, el valor podrà ser el mateix per dos o més usuaris, indicant un circuit paral·lel, durant el qual aquests usuaris poden anar signant/validant el document en qualsevol ordre. Requerit.")
	private BigDecimal ordreIntervencio;
	@ApiModelProperty("Camp rellevant no més en el cas de demanar signatura/validació per part de dos o més usuaris. En aquest cas, amb true, indica que es obligat que aquest usuari signi/validi el document, i que si l'usuari opta per retornar el document, la petició global serà retornada a l'aplicació origen (serà rebutjada), sense importar que la resta de usuaris signataris hagin signat/validat el document. Amb false, indica que si aquest usuari opta per retornar el document, el circuit de signatura continuarà, i que la petició global no més serà retornada a l'aplicació origen si tots els usuaris opten per retornar el document. Requerit (però ignorat en el cas de que no més s'informi un signatari, en aquest cas es true).")
	private boolean esObligada;
	@ApiModelProperty("Data, hora i minut límit abans de considerar aquest pas de la petició global com caducada i no permetre a l'usuari d'aquest pas signar el document. Si es supera la dataCaducitat en un pas, tota la petició global és considerada caducada, i l'aplicació origen és notificada. Opcional.")
	private String dataCaducitat;
	@ApiModelProperty(value = "", allowableValues = "PENDENT,COMPLETADA,RETORNADA,CADUCADA")
	private String codiEstat;
	@ApiModelProperty("Pel cas de retorn en aquest pas, quina ha sigut la raó donada pel usuari signatari/validador. Opcional. Aquest camp pot no estar informat o estar buit (no és obligat que l'usuari indiqui una raó). Té fins a 255 posicions de text.")
	private String raoRetorn;
	@ApiModelProperty("Si el document ja ha sigut signat/vist-i-plau, en aquest camp s'informa el id assignat pel Mòdul de Signatura a aquesta signatura/ vist-i-plau. La aplicació client pot fer servir APIs del Mòdul de Signatura per a obtindre les dades de la signatura (timestamp, common name del certificat del signatari...). Opcional. Aquest camp pot no estar informat o estar buit. Té fins a 14 posicions de text.")
	private BigDecimal ticketPeticio;
	@ApiModelProperty("Codi alfanumèric que indica el càrrec de l'usuari que ha de signar/validar el document. Els valors possibles estan inventariats al mòdul de signatura de l'Ajuntament i caldrà contactar amb els responsables de Seguretat de l'IMI per obtenir-los. 8 posicions com a màxim. Opcional, però si s'informa cal informar a més el paràmetre tractament. No més es retorna si al demanar el alta de la petició es va indicar un valor de versioIntegracio igual o major que 2.")
	private BigDecimal carrec;
	@ApiModelProperty("Codi alfanumèric que indica el tractament aplicable a l'usuari que ha de signar/validar el document. Els valors possibles estan inventariats al mòdul de signatura de l'Ajuntament i caldrà contactar amb els responsables de Seguretat de l'IMI per obtenir-los. 2 posicions com a màxim. Opcional, però si s'informa cal informar a més el paràmetre carrec.. No més es retorna si al demanar el alta de la petició es va indicar un valor de versioIntegracio igual o major que 2.")
	private BigDecimal tractament;
	@ApiModelProperty("Instant (data i hora) en que l'usuari va signar el document. No més es retorna si al demanar el alta de la petició es va indicar un valor de versioIntegracio igual o major que 2. Aquest camp pot no estar informat o estar buit, depenent de l'estat d'aquest pas.")
	private String instantSignatura;

}
