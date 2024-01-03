package bdbt_project.SpringApplication.repository;

import bdbt_project.SpringApplication.entity.Customer;
import bdbt_project.SpringApplication.entity.Operator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	List<Customer> findAllByOperator(Operator operator);
}
