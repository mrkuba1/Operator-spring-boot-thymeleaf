package bdbt_project.SpringApplication.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "PRACOWNICY")
@NoArgsConstructor
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PRACOWNIKA")
	private Long employeeId;
	@Column(name = "IMIE", nullable = false)
	private String name;
	@Column(name = "NAZWISKO", nullable = false)
	private String surname;
	@Column(name = "PLEC", nullable = false)
	private String gender;
	@Column(name = "PESEL", nullable = false)
	private String peselNumber;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "DATA_ZATRUDNIENIA", nullable = false)
	private Date dateOfEmployment;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "DATA_ZWOLNIENIA")
	private Date dateOfDismissal;
	@ManyToOne
	@JoinColumn(name = "ID_OPERATORA")
	private Operator operator;
	@ManyToOne
	@JoinColumn(name = "ID_ODDZIALU")
	private Department department;
	@OneToMany(mappedBy = "employee", cascade = CascadeType.REMOVE)
	private List<Sender> senders = new ArrayList<>();
	
	public String getFormattedDateOfEmployment() {
		if (dateOfEmployment == null) {
			return null;
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		return dateFormat.format(dateOfEmployment);
	}
	
	public String getFormattedDateOfDismissal() {
		if (dateOfDismissal == null) {
			return null;
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		return dateFormat.format(dateOfDismissal);
	}
	
	public String getFullName() {
		if (name == null) {
			return "";
		}
		return name + " " + surname;
	}
	
	@Override
	public String toString() {
		return name + " " + surname;
		
	}
	
}
