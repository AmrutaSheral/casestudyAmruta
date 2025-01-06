package com.entity;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Music {
	
	private int musicId;	
	private String title;
	private String description;
	private int duration;
	private String language;
	private String genre;
	private Date releaseDate;

}
