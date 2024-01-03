package bdbt_project.SpringApplication.service;

import bdbt_project.SpringApplication.entity.Offer;
import bdbt_project.SpringApplication.entity.Operator;
import bdbt_project.SpringApplication.repository.OfferRepository;
import bdbt_project.SpringApplication.repository.OperatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferService {
	@Autowired
	private final OfferRepository offerRepository;
	@Autowired
	private final OperatorRepository operatorRepository;
	public OfferService(OfferRepository offerRepository,OperatorRepository operatorRepository)
	{
		this.offerRepository=offerRepository;
		this.operatorRepository=operatorRepository;
	}
	public List<Offer> findAll()
	{
		return offerRepository.findAll();
	}
	public void deleteOfferById(Long id)
	{
		offerRepository.deleteById(id);
	}
	public void saveOffer(Offer offer)
	{
		offerRepository.save(offer);
	}
	public void updateOffer(Offer offer)
	{
		offerRepository.save(offer);
	}
	public Offer findById(Long id)
	{
		return offerRepository.findById(id).get();
	}
	public List<Offer> findAllByOperatorId(Long id) {
		Operator operator = operatorRepository.getById(id);
		return offerRepository.findAllByOperator(operator);
	}
	
}
