package com.repo;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.Venue;

@Repository
public interface VenueRepo extends JpaRepository<Venue, Integer> {

	Venue findByName(String name);

	List<Venue> findByMusicId(int musicId);

	List<Venue> findByLocation(String location);

}
