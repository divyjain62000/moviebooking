package com.cinema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cinema.entities.Booking;
import java.util.*;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
	List<Booking> findAllByUserId(int userId);
}
