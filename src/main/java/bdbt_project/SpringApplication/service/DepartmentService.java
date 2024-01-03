package bdbt_project.SpringApplication.service;

import bdbt_project.SpringApplication.entity.Department;
import bdbt_project.SpringApplication.entity.Operator;
import bdbt_project.SpringApplication.repository.DepartmentRepository;
import bdbt_project.SpringApplication.repository.OperatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
	@Autowired
	private final DepartmentRepository departmentRepository;
	@Autowired
	private final OperatorRepository operatorRepository;
	
	@Autowired
	public DepartmentService(DepartmentRepository departmentRepository, OperatorRepository operatorRepository) {
		this.departmentRepository = departmentRepository;
		this.operatorRepository = operatorRepository;
	}
	
	public List<Department> findAll() {
		return departmentRepository.findAll();
	}
	
	public void saveDepartment(Department department) {
		departmentRepository.save(department);
	}
	
	public void updateDepartment(Department department) {
		departmentRepository.save(department);
	}
	
	public List<Department> findAllByOperatorId(Long id) {
		Operator operator = operatorRepository.getById(id);
		return departmentRepository.findAllByOperator(operator);
	}
	
	public void deleteDepartmentById(Long id) {
		departmentRepository.deleteById(id);
	}
	
	public Department findById(Long id) {
		return departmentRepository.findById(id).get();
		
	}
}
