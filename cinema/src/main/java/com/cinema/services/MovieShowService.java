package com.cinema.services;

import com.cinema.entities.MovieShow;
import java.util.*;

public interface MovieShowService {
	
	MovieShow create(MovieShow movieShow);
	MovieShow update(MovieShow movieShow,int id);
	MovieShow delete(int id);
	List<MovieShow> getAll();
	MovieShow getById(int id);
	
}
