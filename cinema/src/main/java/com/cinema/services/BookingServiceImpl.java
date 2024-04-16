package com.cinema.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.dto.BookingDTO;
import com.cinema.entities.Booking;
import com.cinema.entities.Payment;
import com.cinema.entities.MovieShow;
import com.cinema.exceptions.CustomException;
import com.cinema.repositories.BookingRepository;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingRepository bookingRepository;

	@Autowired
	private MovieShowService movieShowService;
	
	@Autowired
	private PaymentService paymentService;

	@Override
	public Booking bookSeats(Booking booking) throws CustomException {
		MovieShow movieShow = this.movieShowService.getById(booking.getMovieShow().getId());
		if (movieShow.getAvailableSeats() < booking.getTotalBookedSeats()) {
			CustomException ce = new CustomException();
			if (movieShow.getAvailableSeats() == 0)
				ce.addException("totalBookedSeats", "No seat left");
			else
				ce.addException("totalBookedSeats", "Only " + movieShow.getAvailableSeats() + " seats left");
			throw ce;
		}
		booking.setBookingDateTime(LocalDateTime.now());
		Booking createdBooking = this.bookingRepository.save(booking);
		movieShow.setAvailableSeats((short)(movieShow.getAvailableSeats()-booking.getTotalBookedSeats()));
		this.movieShowService.update(movieShow, movieShow.getId());
		return createdBooking;
	}

	@Override
	public Booking update(Booking booking, int id) {
		Booking b = this.bookingRepository.findById(id).get();
		b.setUser(booking.getUser());
		b.setBookingDateTime(booking.getBookingDateTime());
		b.setMovieShow(booking.getMovieShow());
		b.setTotalBookedSeats(booking.getTotalBookedSeats());
		Booking updatedBooking = this.bookingRepository.save(b);
		return updatedBooking;
	}

	@Override
	public List<BookingDTO> getAll() {
		List<Booking> bookingList = this.bookingRepository.findAll();
		List<BookingDTO> res=new ArrayList<>();
		for(Booking b:bookingList) {
			Payment p=this.paymentService.getByBookingId(b.getId());
			BookingDTO bookingDTO=new BookingDTO();
			bookingDTO.setBooking(b);
			bookingDTO.setPayment(p);
			res.add(bookingDTO);
		}
 		return res;
	}

	@Override
	public List<BookingDTO> getAllByUserId(int userId) {
		List<Booking> bookingList = this.bookingRepository.findAllByUserId(userId);
		List<BookingDTO> res=new ArrayList<>();
		for(Booking b:bookingList) {
			Payment p=this.paymentService.getByBookingId(b.getId());
			BookingDTO bookingDTO=new BookingDTO();
			bookingDTO.setBooking(b);
			bookingDTO.setPayment(p);
			res.add(bookingDTO);
		}
 		return res;
	}

	@Override
	public Booking delete(int id) {
		Booking booking = this.bookingRepository.findById(id).get();
		MovieShow movieShow = this.movieShowService.getById(booking.getMovieShow().getId());
		movieShow.setAvailableSeats((short)(movieShow.getAvailableSeats()+booking.getTotalBookedSeats()));
		this.bookingRepository.delete(booking);
		this.movieShowService.update(movieShow, movieShow.getId());
		return booking;
	}

}
