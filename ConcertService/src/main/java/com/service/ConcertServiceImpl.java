package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Concerts;
import com.exception.VenueNotFoundException;
import com.repo.ConcertRepo;

@Service
public class ConcertServiceImpl {
	
	@Autowired
	private ConcertRepo concertRepo;
	
	public Concerts addConcert(Concerts concert) {
		return concertRepo.save(concert);
	}
	
	public List<Concerts> allConcerts(){
		return concertRepo.findAll();
	}
	
	public Concerts deleteConcert(int concertId) {
		Concerts concert=concertRepo.findById(concertId).get();
		concertRepo.delete(concert);
		return concert;
	}
	
	public List<Concerts> concertsByVenue(int venueId){
		return concertRepo.findByVenueId(venueId);
	}
	public int seats(int concertId) {
		Concerts concert=concertRepo.findById(concertId).get();
		if(concert.getSeats()==0) {
			return concert.getSeats();
		}
		return concert.getSeats();
	}

	public Concerts concertById(int concertId) throws VenueNotFoundException {
		// TODO Auto-generated method stub
		return concertRepo.findById(concertId).orElseThrow(()-> new VenueNotFoundException("No concerts found"));
	}

	public Concerts updateSeats(int concertId, int updatedSeats) {
		// TODO Auto-generated method stub
		Concerts concert=concertRepo.findById(concertId).get();
		concert.setSeats(updatedSeats);
		return concertRepo.save(concert);
	}

}
