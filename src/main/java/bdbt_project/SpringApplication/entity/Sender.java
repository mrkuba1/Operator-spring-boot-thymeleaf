package bdbt_project.SpringApplication.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity
@Table(name = "NADAJNIKI")
@NoArgsConstructor
public class Sender {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_NADAJNIKA")
	private Long senderId;
	@Column(name = "LOKALIZACJA", nullable = false)
	private String location;
	@Column(name = "WYSOKOSC", nullable = false)
	private Double height;
	@Column(name = "PASMO", nullable = false)
	private Double bandwidth;
	@Column(name = "CZY_SPRAWNY", nullable = false)
	private String works;
	@ManyToOne
	@JoinColumn(name = "ID_OPERATORA")
	private Operator operator;
	@ManyToOne
	@JoinColumn(name = "ID_PRACOWNIKA")
	private Employee employee;
	
	@Override
	public String toString() {
		return location + " H: " + height + " B: " + bandwidth;
	}
}
