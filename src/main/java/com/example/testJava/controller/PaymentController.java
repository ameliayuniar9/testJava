package com.example.testJava.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.testJava.dao.PaymentDao;
import com.example.testJava.model.Payment;

@RestController
@RequestMapping("/payment")
public class PaymentController {

	@Autowired
	PaymentDao paymentDao;
	
	@PostMapping("/createPayment")
	public Payment create(@Validated @RequestBody Payment payment) {
		return paymentDao.create(payment);
	}
	
	@GetMapping("/AllPayment")
	public List<Payment> readAll(){
		return paymentDao.readAll();
	}
	
	@GetMapping("/PaymentById/{id}")
	public ResponseEntity<Optional<Payment>> readById(@PathVariable(value="id") Long id) {
		Optional<Payment> tab = paymentDao.readById(id);
		if(tab==null) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok().body(tab);
		}
	}
	
	
	@PutMapping("/updatePayment/{id}")
	public ResponseEntity<Payment> update(@PathVariable(value="id") Long id, @Validated @RequestBody Payment payment){
		Optional<Payment> pay = paymentDao.readById(id);
		if(pay==null) {
			return ResponseEntity.notFound().build();
		}else {
			pay.setIdPlatform(payment.getIdPlatform());
			pay.setNamaPlatform(payment.getNamaPlatform());
			pay.setDocType(payment.getDocType());
			pay.setTermOfPayment(payment.getTermOfPayment());
			
			Payment tabResult = paymentDao.update(pay);
			return ResponseEntity.ok().body(tabResult);
		}
	
	}
	
	@DeleteMapping("/deletePayment/{id}")
	public ResponseEntity<Payment> delete(@PathVariable(value="id") Long id){
		Optional<Payment> pay = paymentDao.readById(id);
		if(pay==null) {
			return ResponseEntity.notFound().build();
		}else {
			paymentDao.delete(id);
			return ResponseEntity.ok().build();
		}
	}
}
