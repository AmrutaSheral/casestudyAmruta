package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Music;
import com.entity.Venue;
import com.exception.VenueNotFoundException;
import com.repo.VenueRepo;
@Service
public class VenueServiceImpl {
	@Autowired
	private VenueRepo venueRepo;
	
	@Autowired																				//
	private MusicClient musicClient;
	

	public Venue addVenue(Venue venue) throws VenueNotFoundException {								//
		Music music=musicClient.byId(venue.getVenueId());
		if(music==null) {
			throw new VenueNotFoundException("Music not found with this id");
		}
		else {
			return venueRepo.save(venue);
		}
		
	}

	public List<Venue> allVenues() {
		
		return venueRepo.findAll();
	}

	public Venue getById(int venueId) throws VenueNotFoundException {
		
		return venueRepo.findById(venueId).orElseThrow(()-> new VenueNotFoundException("Venue not find with this id"));
	}

	public Venue getByName(String name) throws VenueNotFoundException {
		
		Venue venue= venueRepo.findByName(name);
		if(venue==null) {
			throw new VenueNotFoundException("No music found with this venue name");
		}
		return venue;
	}

	public Venue deleteVenue(int venueId) throws VenueNotFoundException {
		Venue venue = venueRepo.findById(venueId).orElseThrow(()-> new VenueNotFoundException("Venue not find with this id"));
		venueRepo.delete(venue);
		return venue;
	}
	
	public Venue updateMusic(int musicId, int venueId) throws VenueNotFoundException {
		Music music=musicClient.byId(musicId);																		//
		if(music==null) {
			throw new VenueNotFoundException("Music not found with this id");
		}
		else {
			Venue venue=venueRepo.findById(venueId).orElseThrow(()-> new VenueNotFoundException("Venue not find with this id"));
			venue.setVenueId(musicId);
			return venueRepo.save(venue);
		}
	}
	
	public List<Venue> venueByMusicName(String title) throws VenueNotFoundException{
		Music music=musicClient.viewMusic(title);															//
		if(music==null) {
			throw new VenueNotFoundException("No concerts for this music");
		}
		else {
			int musicId=music.getMusicId();
			List<Venue> venue=venueRepo.findByMusicId(musicId);
			if(venue.isEmpty()) {
				throw new VenueNotFoundException("No concerts for this music");
			}
				return venue;
		
		}
	}
	
	public List<Venue> venuesByLocation(String location) throws VenueNotFoundException{
		List<Venue> lis= venueRepo.findByLocation(location);
		if(lis.isEmpty()) {
			throw new VenueNotFoundException("No venues found for this location");
		}
		return lis;
	}

}
