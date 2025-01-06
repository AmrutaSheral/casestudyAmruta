package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Concerts;
import com.service.ConcertServiceImpl;

@RestController
@RequestMapping("/concert/Admin")
public class ConcertControllerAdmin {
	
	@Autowired
	private ConcertServiceImpl concertServiceImpl;
	
	@PostMapping("/add")
	public Concerts addConcert(@RequestBody Concerts concert) {
		return concertServiceImpl.addConcert(concert);
	}
	@GetMapping("/all")
	public List<Concerts> allConcerts(){
		return concertServiceImpl.allConcerts();
	}
	@DeleteMapping("/delete/{concertId}")
	public Concerts deleteConcert(@PathVariable int concertId) {
		return concertServiceImpl.deleteConcert(concertId);
	}
	@GetMapping("/byVenue/{venueId}")
	public List<Concerts> concertsByVenue(@PathVariable int venueId){
		return concertServiceImpl.concertsByVenue(venueId);
	}
	@GetMapping("/seats/{concertId}")
	public int seats(@PathVariable int concertId) {
		return concertServiceImpl.seats(concertId);
	}

}
