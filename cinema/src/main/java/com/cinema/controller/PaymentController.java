package com.cinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cinema.entities.Payment;
import com.cinema.services.PaymentService;

@RestController
@CrossOrigin
public class PaymentController {

	@Autowired
	private PaymentService paymentService;

	@PostMapping("/payments")
	ResponseEntity<Payment> save(@RequestBody Payment payment) {
		this.paymentService.save(payment);
		return ResponseEntity.status(HttpStatus.OK).body(payment);
	}

	@GetMapping("/payments/{id}")
	ResponseEntity<Payment> getById(@PathVariable(name ="id") int id) {
		Payment payment = this.paymentService.getById(id);
		return ResponseEntity.status(HttpStatus.OK).body(payment);
	}

}
