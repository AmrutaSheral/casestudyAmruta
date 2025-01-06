package com.repo;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.Concerts;
@Repository
public interface ConcertRepo extends JpaRepository<Concerts, Integer> {

	List<Concerts> findByVenueId(int venueId);
	
}
