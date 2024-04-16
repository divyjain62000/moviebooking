package com.cinema.dto;

import java.io.Serializable;

import com.cinema.entities.Booking;
import com.cinema.entities.Payment;

public class BookingDTO implements Serializable {
	private Booking booking;
	private Payment payment;
	
	public BookingDTO() {
		super();
	}

	public BookingDTO(Booking booking, Payment payment) {
		super();
		this.booking = booking;
		this.payment = payment;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	@Override
	public String toString() {
		return "BookingDTO [booking=" + booking + ", payment=" + payment + "]";
	}
	
}
