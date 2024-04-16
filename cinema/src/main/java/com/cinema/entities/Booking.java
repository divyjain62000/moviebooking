package com.cinema.entities;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne
	@JoinColumn(name = "movie_show_id")
	private MovieShow movieShow;

	private LocalDateTime bookingDateTime;

	private short totalBookedSeats;

	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Booking(int id, User user, MovieShow movieShow, LocalDateTime bookingDateTime,
			short totalBookedSeats) {
		super();
		this.id = id;
		this.user = user;
		this.movieShow = movieShow;
		this.bookingDateTime = bookingDateTime;
		this.totalBookedSeats = totalBookedSeats;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public MovieShow getMovieShow() {
		return movieShow;
	}

	public void setMovieShow(MovieShow movieShow) {
		this.movieShow = movieShow;
	}

	

	public LocalDateTime getBookingDateTime() {
		return bookingDateTime;
	}

	public void setBookingDateTime(LocalDateTime bookingDateTime) {
		this.bookingDateTime = bookingDateTime;
	}

	public short getTotalBookedSeats() {
		return totalBookedSeats;
	}

	public void setTotalBookedSeats(short totalBookedSeats) {
		this.totalBookedSeats = totalBookedSeats;
	}

	@Override
	public String toString() {
		return "Booking [id=" + id + ", user=" + user + ", movieShow=" + movieShow + ", bookingDateTime="
				+ bookingDateTime + ", totalBookedSeats=" + totalBookedSeats + "]";
	}

}
