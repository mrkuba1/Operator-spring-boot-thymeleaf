package bdbt_project.SpringApplication.service;

import bdbt_project.SpringApplication.entity.*;
import bdbt_project.SpringApplication.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class OperatorService {
	@Autowired
	private final OperatorRepository operatorRepository;
	@Autowired
	private final DepartmentRepository departmentRepository;
	@Autowired
	private final CustomerRepository customerRepository;
	@Autowired
	private final OfferRepository offerRepository;
	@Autowired
	private final EmployeeRepository employeeRepository;
	@Autowired
	private final SenderRepository senderRepository;
	
	
	@Autowired
	public OperatorService(OperatorRepository operatorRepository, DepartmentRepository departmentRepository, EmployeeRepository employeeRepository, CustomerRepository customerRepository, OfferRepository offerRepository, SenderRepository senderRepository) {
		this.operatorRepository = operatorRepository;
		this.departmentRepository = departmentRepository;
		this.customerRepository = customerRepository;
		this.employeeRepository = employeeRepository;
		this.offerRepository = offerRepository;
		this.senderRepository = senderRepository;
		
	}
	
	public List<Operator> findAll() {
		return operatorRepository.findAll();
	}
	
	public void saveOperator(Operator operator) {
		operatorRepository.save(operator);
	}
	
	public void updateOperator(Operator operator) {
		operatorRepository.save(operator);
	}
	
	public Operator findById(Long id) {
		return operatorRepository.findById(id).get();
	}
	
	public void deleteOperator(Long id) {
		operatorRepository.deleteById(id);
	}
	
}
