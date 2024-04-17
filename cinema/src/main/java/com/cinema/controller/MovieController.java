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
import org.springframework.web.bind.annotation.RestController;

import com.cinema.entities.MovieShow;
import com.cinema.services.MovieShowService;

@RestController
@CrossOrigin
public class MovieController {

	@Autowired
	private MovieShowService movieShowService;

	@PostMapping("/movie-shows")
	ResponseEntity<MovieShow> create(@RequestBody MovieShow movieShow) {
		MovieShow m = this.movieShowService.create(movieShow);
		return ResponseEntity.status(HttpStatus.OK).body(m);
	}

	@PutMapping("/movie-shows/{id}")
	ResponseEntity<MovieShow> update(@RequestBody MovieShow movieShow, @PathVariable(name = "id") int id) {
		MovieShow m = this.movieShowService.update(movieShow, id);
		return ResponseEntity.status(HttpStatus.OK).body(m);
	}

	@DeleteMapping("/movie-shows/{id}")
	ResponseEntity<MovieShow> delete(@PathVariable(name = "id") int id) {
		MovieShow movieShow = this.movieShowService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body(movieShow);
	}

	@GetMapping("/movie-shows")
	ResponseEntity<List<MovieShow>> getAll() {
		List<MovieShow> movieShowList = this.movieShowService.getAll();
		return ResponseEntity.status(HttpStatus.OK).body(movieShowList);
	}

	@GetMapping("/movie-shows/{id}")
	ResponseEntity<MovieShow> getById(@PathVariable(name = "id") int id) {
		MovieShow movieShow = this.movieShowService.getById(id);
		return ResponseEntity.status(HttpStatus.OK).body(movieShow);
	}

}
