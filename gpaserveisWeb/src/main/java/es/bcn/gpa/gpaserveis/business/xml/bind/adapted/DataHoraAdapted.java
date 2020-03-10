package es.bcn.gpa.gpaserveis.business.xml.bind.adapted;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;
import lombok.Setter;

@XmlRootElement(name = "DATA")
@XmlType(name = "DataHoraAdapted", propOrder = { "data", "hora" })
@XmlAccessorType(XmlAccessType.NONE)
@Getter
@Setter
public class DataHoraAdapted {

	@XmlElement(name = "DATA", required = true, type = String.class)
	private String data;

	@XmlElement(name = "HORA", required = true, type = String.class)
	private String hora;

}