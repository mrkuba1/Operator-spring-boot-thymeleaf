//package bdbt_project.SpringApplication.service;
//
//import bdbt_project.SpringApplication.repository.EmployeeRepository;
//import bdbt_project.SpringApplication.repository.SalaryRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class SalaryService {
//	@Autowired
//	private EmployeeRepository employeeRepository;
//	@Autowired
//	private SalaryRepository salaryRepository;
//
//	public SalaryService(EmployeeRepository employeeRepository,SalaryRepository salaryRepository)
//	{
//		this.salaryRepository=salaryRepository;
//		this.employeeRepository=employeeRepository;
//	}
//	public List<Salary> findAll()
//	{
//		return salaryRepository.findAll();
//	}
//	public Salary findById(Long id)
//	{
//		return salaryRepository.getById(id);
//	}
//	public void saveSalary(Salary salary)
//	{
//		salaryRepository.save(salary);
//	}
//	public void updateSalary(Salary salary)
//	{
//		salaryRepository.save(salary);
//	}
//	public void deleteSalaryById(Long id)
//	{
//		Salary salary=salaryRepository.getById(id);
//		salaryRepository.delete(salary);
//	}
//
//}
