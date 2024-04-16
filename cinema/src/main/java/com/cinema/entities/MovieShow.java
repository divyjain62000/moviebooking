package com.cinema.entities;


import java.time.LocalDateTime;

import jakarta.persistence.*;


@Entity
public class MovieShow {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String movieName;
	
	private LocalDateTime showTimming;
	
	private String theaterAddress;
	
	private short totalSeats;
	
	private short availableSeats;
	
	private String posterURL;
	
	private double ticketPrice;

	public MovieShow() {
		super();
	}

	public MovieShow(int id, String movieName, LocalDateTime showTimming, String theaterAddress, short totalSeats,
			short availableSeats,String posterURL,double ticketPrice) {
		super();
		this.id = id;
		this.movieName = movieName;
		this.showTimming = showTimming;
		this.theaterAddress = theaterAddress;
		this.totalSeats = totalSeats;
		this.availableSeats = availableSeats;
		this.posterURL=posterURL;
		this.ticketPrice=ticketPrice;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public LocalDateTime getShowTimming() {
		return showTimming;
	}

	public void setShowTimming(LocalDateTime showTimming) {
		this.showTimming = showTimming;
	}

	public String getTheaterAddress() {
		return theaterAddress;
	}

	public void setTheaterAddress(String theaterAddress) {
		this.theaterAddress = theaterAddress;
	}


	public short getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(short totalSeats) {
		this.totalSeats = totalSeats;
	}

	public short getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(short availableSeats) {
		this.availableSeats = availableSeats;
	}

	public String getPosterURL() {
		return posterURL;
	}

	public void setPosterURL(String posterURL) {
		this.posterURL = posterURL;
	}
	

	public double getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	@Override
	public String toString() {
		return "MovieShow [id=" + id + ", movieName=" + movieName + ", showTimming=" + showTimming + ", theaterAddress="
				+ theaterAddress + ", totalSeats=" + totalSeats + ", availableSeats=" + availableSeats + ", posterURL="
				+ posterURL + ", ticketPrice=" + ticketPrice + "]";
	}
	
}
