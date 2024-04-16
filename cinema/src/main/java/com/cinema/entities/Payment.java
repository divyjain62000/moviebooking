package com.cinema.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String paymentMode;

	private LocalDateTime paymentDateTime;

	private String status;

	@OneToOne
	private Booking booking;

	private double totalAmount;

	public Payment() {
		super();
	}

	public Payment(int id, String paymentMode, LocalDateTime paymentDateTime, String status, Booking booking,
			double totalAmount) {
		super();
		this.id = id;
		this.paymentMode = paymentMode;
		this.paymentDateTime = paymentDateTime;
		this.status = status;
		this.booking = booking;
		this.totalAmount = totalAmount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public LocalDateTime getPaymentDateTime() {
		return paymentDateTime;
	}

	public void setPaymentDateTime(LocalDateTime paymentDateTime) {
		this.paymentDateTime = paymentDateTime;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	@Override
	public String toString() {
		return "Payment [id=" + id + ", paymentMode=" + paymentMode + ", paymentDateTime=" + paymentDateTime
				+ ", status=" + status + ", booking=" + booking + ", totalAmount=" + totalAmount + "]";
	}

}
