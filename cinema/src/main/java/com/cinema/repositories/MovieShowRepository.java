package com.cinema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cinema.entities.MovieShow;

@Repository
public interface MovieShowRepository extends JpaRepository<MovieShow,Integer>{

}
