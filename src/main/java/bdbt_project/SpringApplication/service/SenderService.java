package bdbt_project.SpringApplication.service;

import bdbt_project.SpringApplication.entity.Operator;
import bdbt_project.SpringApplication.entity.Sender;
import bdbt_project.SpringApplication.repository.OperatorRepository;
import bdbt_project.SpringApplication.repository.SenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SenderService {
	@Autowired
	private final SenderRepository senderRepository;
	@Autowired
	private final OperatorRepository operatorRepository;
	
	public SenderService(SenderRepository senderRepository, OperatorRepository operatorRepository) {
		this.senderRepository = senderRepository;
		this.operatorRepository=operatorRepository;
	}
	
	public List<Sender> findAll() {
		return senderRepository.findAll();
	}
	
	public void saveSender(Sender sender) {
		senderRepository.save(sender);
	}
	
	public Sender findById(Long id) {
		return senderRepository.findById(id).get();
	}
	public void updateSender(Sender sender)
	{
		senderRepository.save(sender);
	}
	public void deleteSenderById(Long id)
	{
		senderRepository.deleteById(id);
	}
	public List<Sender> findAllByOperatorId(Long id) {
		Operator operator = operatorRepository.getById(id);
		return senderRepository.findAllByOperator(operator);
	}
}
