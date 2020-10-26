package com.example.testJava.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.testJava.model.Payment;
import com.example.testJava.repository.PaymentRepository;



@Service
public class PaymentDao {

	@Autowired
	PaymentRepository paymentRepository;
	
	public List<Payment> readAll(){
		return paymentRepository.findAll();
	}
	
	public Optional<Payment> readById(Long id) {
		return paymentRepository.findById(id);
	}
	
	
	public Payment create(Payment payment) {
		return paymentRepository.save(payment);
	}
	
	public void delete(Long id) {
		paymentRepository.deleteById(id);
	}
	
	public Payment update(Optional<Payment> pay2) {
		Payment pay=paymentRepository.findById(pay2.getId());
		pay.setIdPlatform(pay2.getIdPlatform());
		pay.setNamaPlatform(pay2.getNamaPlatform());
		pay.setDocType(pay2.getDocType());
		pay.setTermOfPayment(pay2.getTermOfPayment());
		return paymentRepository.saveAll(pay2);
	}
	
}
