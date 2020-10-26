package com.example.testJava.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.testJava.model.Payment;


public interface PaymentRepository extends JpaRepository<Payment, Long> {
	public Optional<Payment> findById(Long id);


}
