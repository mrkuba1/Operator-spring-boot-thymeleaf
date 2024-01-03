package bdbt_project.SpringApplication.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Klienci")
@NoArgsConstructor
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_KLIENTA")
	private Long customerId;
	@Column(name = "IMIE")
	private String name;
	@Column(name = "NAZWISKO")
	private String surname;
	@Column(name = "NUMER_TELEFONU")
	private String phoneNumber;
	@ManyToOne
	@JoinColumn(name = "ID_OPERATORA")
	private Operator operator;
	@OneToMany(mappedBy = "customer", cascade = CascadeType.REMOVE)
	private List<Offer> offers = new ArrayList<>();
	
	public String getFullName() {
		return name + " " + surname;
	}
	
	@Override
	public String toString() {
		return name + " " + surname;
	}
}
