package bdbt_project.SpringApplication.service;

import bdbt_project.SpringApplication.entity.Employee;
import bdbt_project.SpringApplication.entity.Operator;
import bdbt_project.SpringApplication.repository.EmployeeRepository;
import bdbt_project.SpringApplication.repository.OperatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private OperatorRepository operatorRepository;
	
	public EmployeeService(EmployeeRepository employeeRepository, OperatorRepository operatorRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}
	
	public void saveEmployee(Employee employee) {
		employeeRepository.save(employee);
	}
	
	public void updateEmployee(Employee employee) {
		employeeRepository.save(employee);
	}
	
	public void deleteEmployeeById(Long id) {
		employeeRepository.deleteById(id);
	}
	
	public Employee findById(Long id) {
		return employeeRepository.findById(id).get();
	}
	public List<Employee> findAllByOperatorId(Long id) {
		Operator operator = operatorRepository.getById(id);
		return employeeRepository.findAllByOperator(operator);
	}
}
