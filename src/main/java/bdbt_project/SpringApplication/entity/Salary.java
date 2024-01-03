//package bdbt_project.SpringApplication.entity;
//
//import lombok.Data;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import javax.persistence.*;
//import java.util.Date;
//
//@Data
//@Setter
//@Getter
//@Entity
//@NoArgsConstructor
//@Table(name = "WYNAGRODZENIA")
//public class Salary {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "ID_WYNAGRODZENIA")
//	private Long salaryId;
//	@Column(name = "DATA_PRZYZNANIA", nullable = false)
//	private Date dateOfReceive;
//	@Column(name = "PENSJA_PODSTAWOWA", nullable = false)
//	private Double wage;
//	@Column(name = "PREMIA")
//	private Double bonus;
//	@ManyToOne
//	@JoinColumn(name = "ID_PRACOWNIKA")
//	private Employee employee;
//}
