package bdbt_project.SpringApplication.service;


import bdbt_project.SpringApplication.entity.Customer;
import bdbt_project.SpringApplication.entity.Operator;
import bdbt_project.SpringApplication.repository.CustomerRepository;
import bdbt_project.SpringApplication.repository.OperatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CustomerService {
	@Autowired
	private final CustomerRepository customerRepository;
	@Autowired
	private final OperatorRepository operatorRepository;
	
	public CustomerService(CustomerRepository customerRepository, OperatorRepository operatorRepository) {
		this.customerRepository = customerRepository;
		this.operatorRepository = operatorRepository;
	}
	
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}
	
	public void saveCustomer(Customer customer) {
		customerRepository.save(customer);
	}
	
	public void updateCustomer(Customer customer) {
		customerRepository.save(customer);
	}
	
	public void deleteCustomerById(Long id) {
		customerRepository.deleteById(id);
	}
	
	public List<Customer> findAllByOperatorId(Long id) {
		Operator operator = operatorRepository.getById(id);
		return customerRepository.findAllByOperator(operator);
	}
	
	public Customer findById(Long id) {
		return customerRepository.findById(id).get();
		
	}
	
}
