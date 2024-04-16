package com.cinema.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.entities.MovieShow;
import com.cinema.repositories.MovieShowRepository;

@Service
public class MovieShowServiceImpl implements MovieShowService {

	@Autowired
	private MovieShowRepository movieShowRepository;

	@Override
	public MovieShow create(MovieShow movieShow) {
		MovieShow createdMovieShow = this.movieShowRepository.save(movieShow);
		return createdMovieShow;
	}

	@Override
	public List<MovieShow> getAll() {
		List<MovieShow> movieShowList = this.movieShowRepository.findAll();
		return movieShowList;
	}

	@Override
	public MovieShow update(MovieShow movieShow, int id) {
		MovieShow m = this.movieShowRepository.findById(id).get();
		m.setMovieName(movieShow.getMovieName());
		m.setShowTimming(movieShow.getShowTimming());
		m.setAvailableSeats(movieShow.getAvailableSeats());
		m.setTheaterAddress(movieShow.getTheaterAddress());
		m.setTotalSeats(movieShow.getTotalSeats());
		m.setPosterURL(movieShow.getPosterURL());
		m.setTicketPrice(movieShow.getTicketPrice());
		MovieShow updatedMovieShow = this.movieShowRepository.save(m);
		return updatedMovieShow;
	}

	@Override
	public MovieShow delete(int id) {
		MovieShow m = this.movieShowRepository.findById(id).get();
		this.movieShowRepository.delete(m);
		return m;
	}

	@Override
	public MovieShow getById(int id) {
		Optional<MovieShow> msOptional = this.movieShowRepository.findById(id);
		if (!msOptional.isPresent())
			return null;
		return msOptional.get();
	}

}
