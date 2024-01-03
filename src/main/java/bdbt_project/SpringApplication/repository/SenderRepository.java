package bdbt_project.SpringApplication.repository;

import bdbt_project.SpringApplication.entity.Operator;
import bdbt_project.SpringApplication.entity.Sender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SenderRepository extends JpaRepository<Sender, Long> {
	List<Sender> findAllByOperator(Operator operator);
}
