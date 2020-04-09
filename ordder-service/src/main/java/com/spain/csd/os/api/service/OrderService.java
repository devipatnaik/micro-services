package com.spain.csd.os.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.spain.csd.os.api.common.Payment;
import com.spain.csd.os.api.common.TransactionRequest;
import com.spain.csd.os.api.common.TransactionResponse;
import com.spain.csd.os.api.entity.Order;
import com.spain.csd.os.api.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	
	@Autowired
	private RestTemplate template;
	
	public TransactionResponse bookOrder(TransactionRequest request) {
		String response="";
		
		Order order = request.getOrder();
		Payment payment = request.getPayment();
		payment.setOrderId(order.getId());
		payment.setAmount(order.getAmount());
		
		// rest call to payment-service
		Payment paymentresponse = template.postForObject("http://PAYMENT-SERVICE/api/payment/makePayment", payment, Payment.class);
		
		/*if(paymentresponse.getPaymentStatus().equals("success")) {
			
			paymentresponse.setPaymentStatus("Payment Processing Successfull !! and Order Placed");
		
		}else if(paymentresponse.getPaymentStatus().equals("false")) {
			paymentresponse.setPaymentStatus("Payment Failure!");
		}*/
		
		response = paymentresponse.getPaymentStatus().equals("success") ? "Payment Processing Successfull !! and Order Placed" : "Payment Failure";
		
		repository.save(order);
		
		return new TransactionResponse(order,paymentresponse.getAmount(),paymentresponse.getTransactionId(),response);
	}
}
