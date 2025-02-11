package com.jspider.qflix_java_servlet.dto;

import java.time.LocalDate;

public class Movie {

	private int id;
	private String name;
	private LocalDate releasedYear;
	private String genresType;
	private String language;
	private String description;
	private String productionHouse;
	private String directorName;
	private String quality;
	transient private byte[] image;
	
}
