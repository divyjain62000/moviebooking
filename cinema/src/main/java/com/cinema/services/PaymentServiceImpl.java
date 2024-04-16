package com.cinema.services;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.entities.Payment;
import com.cinema.repositories.PaymentRepository;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;
	
	@Override
	public Payment save(Payment payment) {
		payment.setPaymentDateTime(LocalDateTime.now());
		this.paymentRepository.save(payment);
		return null;
	}

	@Override
	public Payment getById(int id) {
		Optional<Payment> p = this.paymentRepository.findById(id);
		if (p.isPresent())
			return p.get();
		return null;
	}
	
	@Override
	public Payment getByBookingId(int bookingId) {
		Optional<Payment> p=this.paymentRepository.findByBookingId(bookingId);
		if(!p.isPresent()) return null;
		return p.get();
	}
}
