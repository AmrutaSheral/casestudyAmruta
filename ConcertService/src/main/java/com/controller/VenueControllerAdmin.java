package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Venue;
import com.exception.VenueNotFoundException;
import com.service.VenueServiceImpl;

@RestController
@RequestMapping("/venue/Admin")
public class VenueControllerAdmin {
	
	@Autowired
	private VenueServiceImpl venueServiceImpl;
	
	@PostMapping("/addVenue")
	public Venue addVenue(@RequestBody Venue venue) throws VenueNotFoundException {
		return venueServiceImpl.addVenue(venue);
	}
	@GetMapping("/allVenues")
	public List<Venue> allVenues() {
		
		return venueServiceImpl.allVenues();
	}

	@GetMapping("/byId/{venueId}")
	public Venue getById(@PathVariable int venueId) throws VenueNotFoundException {
		
		return venueServiceImpl.getById(venueId);
	}

	@GetMapping("/byName/{name}")
	public Venue getByName(@PathVariable String name) throws VenueNotFoundException {
		
		return venueServiceImpl.getByName(name);
	}

	@DeleteMapping("/delete/{venueId}")
	public Venue deleteVenue(@PathVariable int venueId) throws VenueNotFoundException {
		
		return venueServiceImpl.deleteVenue(venueId);
	}
	@PutMapping("/UpdateMusic/{musicId}/{venueId}")
	public Venue updateMusic(@PathVariable int musicId,@PathVariable int venueId) throws VenueNotFoundException {
		return venueServiceImpl.updateMusic(musicId, venueId);
	}
	@GetMapping("/venueByMusic/{title}")
	public List<Venue> venueByMusicName(@PathVariable String title) throws VenueNotFoundException{
		return venueServiceImpl.venueByMusicName(title);
	}
	@GetMapping("/venuesByLocation/{location}")
	public List<Venue> venuesByLocation(@PathVariable String location) throws VenueNotFoundException{
		return venueServiceImpl.venuesByLocation(location);
	}

}
