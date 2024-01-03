package bdbt_project.SpringApplication.repository;

import bdbt_project.SpringApplication.entity.Offer;
import bdbt_project.SpringApplication.entity.Operator;
import bdbt_project.SpringApplication.service.OperatorService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {
	List<Offer> findAllByOperator(Operator operator);
}
