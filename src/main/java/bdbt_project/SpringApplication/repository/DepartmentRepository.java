package bdbt_project.SpringApplication.repository;

import bdbt_project.SpringApplication.entity.Department;
import bdbt_project.SpringApplication.entity.Operator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
	List<Department> findAllByOperator(Operator operator);
}
