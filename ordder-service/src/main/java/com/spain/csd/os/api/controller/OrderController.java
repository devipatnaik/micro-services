package com.spain.csd.os.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spain.csd.os.api.common.TransactionRequest;
import com.spain.csd.os.api.common.TransactionResponse;
import com.spain.csd.os.api.service.OrderService;

@RestController
@RequestMapping(value = "/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping(value = "/bookOrder")
	public TransactionResponse bookOrder(@RequestBody TransactionRequest request) {
		return orderService.bookOrder(request);
	}
}
