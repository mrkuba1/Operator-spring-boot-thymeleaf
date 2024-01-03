package bdbt_project.SpringApplication.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.*;

@Setter
@Getter
@Entity
@Table(name = "USLUGI")
@NoArgsConstructor
public class Offer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_USLUGI")
	private Long offerId;
	@Column(name = "NAZWA", nullable = false)
	private String name;
	@Column(name = "TYP_USLUGI", nullable = false)
	private String type;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "DATA_ZAKONCZENIA_UMOWY", nullable = false)
	private Date dateOfEnd;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "DATA_ZAWARCIA_UMOWY", nullable = false)
	private Date dateOfStart;
	@Column(name = "WARTOSC")
	private Double value;
	@Column(name = "CZY_URZADZENIE")
	private String device;
	@ManyToOne
	@JoinColumn(name = "ID_OPERATORA")
	private Operator operator;
	@ManyToOne
	@JoinColumn(name = "ID_KLIENTA")
	private Customer customer;
	
	public String toStringshort() {
		return "Offer: " + name + " type: " + type + " value: " + value + " device?: " + device;
	}
	
	@Override
	public String toString() {
		return name + " " + type + " " + value;
	}
	
	public String getFormattedDateOfStart() {
		if (dateOfStart == null) {
			return null;
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		return dateFormat.format(dateOfStart);
	}
	
	public String getFormattedDateOfEnd() {
		if (dateOfEnd == null) {
			return null;
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		return dateFormat.format(dateOfEnd);
	}
}
