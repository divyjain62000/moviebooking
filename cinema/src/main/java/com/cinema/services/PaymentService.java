package com.cinema.services;

import com.cinema.entities.Payment;

public interface PaymentService {

	Payment save(Payment payment);

	Payment getById(int id);
	
	Payment getByBookingId(int bookingId);
}
