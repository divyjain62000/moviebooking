package com.cinema.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cinema.dto.BookingDTO;
import com.cinema.entities.Booking;
import com.cinema.exceptions.CustomException;
import com.cinema.services.BookingService;

@RestController
@CrossOrigin
public class BookingController {

	@Autowired
	private BookingService bookingService;

	@PostMapping("/bookings")
	ResponseEntity<?> bookSeats(@RequestBody Booking booking) {
		try {
			Booking b = this.bookingService.bookSeats(booking);
			return ResponseEntity.status(HttpStatus.OK).body(b);
		}catch(CustomException ce) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ce.getExceptions());
		}
	}

	@PutMapping("/bookings/{id}")
	ResponseEntity<Booking> update(@RequestBody Booking booking, @PathVariable(name = "id") int id) {
		Booking b = this.bookingService.update(booking, id);
		return ResponseEntity.status(HttpStatus.OK).body(b);
	}

	@DeleteMapping("/bookings/{id}")
	ResponseEntity<Booking> delete(@PathVariable(name = "id") int id) {
		Booking b = this.bookingService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body(b);
	}

	@GetMapping("/bookings")
	ResponseEntity<List<BookingDTO>> getAll() {
		List<BookingDTO> bookingList = this.bookingService.getAll();
		return ResponseEntity.status(HttpStatus.OK).body(bookingList);
	}

	@GetMapping("/bookings-by-user-id")
	ResponseEntity<List<BookingDTO>> getAllByUserId(@RequestParam(name = "userId") int userId) {
		List<BookingDTO> bookingList = this.bookingService.getAllByUserId(userId);
		return ResponseEntity.status(HttpStatus.OK).body(bookingList);
	}

}
