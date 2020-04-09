package com.spain.csd.ps.api.service;

import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spain.csd.ps.api.entity.Payment;
import com.spain.csd.ps.api.repository.PaymentRepository;

@Service
public class PaymentService {
	
	@Autowired
	private PaymentRepository repository;
	
	public Payment makePayment(Payment payment) {
		
		payment.setPaymentStatus(paymentProcessing(payment));
		payment.setTransactionId(UUID.randomUUID().toString());
		return repository.save(payment);
	}

	public String paymentProcessing(Payment payment) {
		// api should be 3rd party gateway.(paytm..)
		return new Random().nextBoolean()?"success":"false";
	}

	public Payment findPaymentHistoryByOrderId(int orderId) {
		
		return repository.findByOrderId(orderId);
	}

}
