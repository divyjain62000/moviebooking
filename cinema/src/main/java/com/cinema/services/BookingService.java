package com.cinema.services;

import com.cinema.dto.BookingDTO;
import com.cinema.entities.Booking;
import com.cinema.exceptions.CustomException;

import java.util.*;

public interface BookingService {

	Booking bookSeats(Booking booking) throws CustomException;

	Booking update(Booking booking, int id);

	Booking delete(int id);

	List<BookingDTO> getAll();

	List<BookingDTO> getAllByUserId(int userId);
}
