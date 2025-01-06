package com.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.entity.Music;

@FeignClient(name = "MusicService")
public interface MusicClient {
	
	@GetMapping("/music/byId/{musicId}")
	public Music byId(@PathVariable int musicId);
	
	@GetMapping("/music/byTitle/{title}")
	public Music viewMusic(@PathVariable String title);
	

}