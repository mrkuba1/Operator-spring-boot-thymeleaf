package bdbt_project.SpringApplication.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name = "ODDZIALY")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ODDZIALU")
	private Long departmentId;
	@Column(name = "NAZWA", nullable = false)
	private String name;
	@Column(name = "NUMER_TELEFONU", nullable = false)
	private String phoneNumber;
	@ManyToOne
	@JoinColumn(name = "ID_OPERATORA")
	private Operator operator;
	@OneToMany(mappedBy = "department", cascade = CascadeType.REMOVE)
	private List<Employee> employees = new ArrayList<>();
	
	public String getNameAndOperatorName() {
		return name + " Operator:" + operator.getName();
	}
	
	@Override
	public String toString() {
		return name + " " + operator.toStringShort();
	}
}