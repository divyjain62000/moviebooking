package com.cinema.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cinema.entities.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
	Optional<Payment> findByBookingId(int bookingId);
}
