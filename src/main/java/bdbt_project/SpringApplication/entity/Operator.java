package bdbt_project.SpringApplication.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Operatorzy_telekomunikacyjni")
public class Operator {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_OPERATORA")
	private Long operatorId;
	@Column(name = "NAZWA", nullable = false)
	private String name;
	@Column(name = "NIP", nullable = false)
	private String nipNumber;
	@Column(name = "EMAIL", nullable = false)
	private String email;
	@Column(name = "NUMER_TELEFONU", nullable = false)
	private String phoneNumber;
	@OneToMany(mappedBy = "operator", cascade = CascadeType.REMOVE)
	private List<Department> departments = new ArrayList<>();
	@OneToMany(mappedBy = "operator", cascade = CascadeType.REMOVE)
	private List<Sender> senders = new ArrayList<>();
	@OneToMany(mappedBy = "operator", cascade = CascadeType.REMOVE)
	private List<Offer> offers = new ArrayList<>();
	@OneToMany(mappedBy = "operator", cascade = CascadeType.REMOVE)
	private List<Customer> customers = new ArrayList<>();
	@OneToMany(mappedBy = "operator", cascade = CascadeType.REMOVE)
	private List<Employee> employees = new ArrayList<>();
	
	public String toStringShort() {
		return name + " NIP:" + nipNumber;
	}
	
	@Override
	public String toString() {
		return name + " NIP: " + nipNumber;
	}
}