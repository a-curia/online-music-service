package com.dbbyte.model;

public class Artists {
	
	private String first_letter;
	private String artist;
	
	
	public Artists() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Artists(String first_letter, String artist) {
		super();
		this.first_letter = first_letter;
		this.artist = artist;
	}


	public String getFirst_letter() {
		return first_letter;
	}


	public void setFirst_letter(String first_letter) {
		this.first_letter = first_letter;
	}


	public String getArtist() {
		return artist;
	}


	public void setArtist(String artist) {
		this.artist = artist;
	}


	@Override
	public String toString() {
		return "Artists [first_letter=" + first_letter + ", artist=" + artist + "]";
	}
	
	
	
}
