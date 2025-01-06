package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Concerts;
import com.exception.VenueNotFoundException;
import com.service.ConcertServiceImpl;

@RestController
@RequestMapping("/concert")
//@CrossOrigin(origins = "http://localhost:3000/")
public class ConcertController {
	
	@Autowired
	private ConcertServiceImpl concertServiceImpl;
	
	@GetMapping("/all")
	public List<Concerts> allConcerts(){
		return concertServiceImpl.allConcerts();
	}

	@GetMapping("/byVenue/{VenueId}")
	public List<Concerts> concertsByVenue(@PathVariable int venueId){
		return concertServiceImpl.concertsByVenue(venueId);
	}
	
	@GetMapping("/seats/{concertId}")
	public int seats(@PathVariable int concertId) {
		return concertServiceImpl.seats(concertId);
	}
	
	@GetMapping("/concertbyId/{concertId}")
	public Concerts concertById(@PathVariable int concertId) throws VenueNotFoundException {
		return concertServiceImpl.concertById(concertId);
	}
	
	@PutMapping("/updateSeats/{concertId}/{updatedSeats}")
	public Concerts updateSeats(@PathVariable int concertId ,@PathVariable int updatedSeats) {
		return concertServiceImpl.updateSeats(concertId,updatedSeats);
	}

}
