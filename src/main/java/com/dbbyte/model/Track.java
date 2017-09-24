package com.dbbyte.model;

import java.util.UUID;

public class Track {
	private UUID track_id;
	private String track;
	private String artist;
	private int track_length_in_seconds;
	private String genre;
	private String music_file;
	private Boolean starred;
	
	public Track() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Track(UUID track_id, String track, String artist, int track_length_in_seconds, String genre,
			String music_file, Boolean starred) {
		super();
		this.track_id = track_id;
		this.track = track;
		this.artist = artist;
		this.track_length_in_seconds = track_length_in_seconds;
		this.genre = genre;
		this.music_file = music_file;
		this.starred = starred;
	}

	public UUID getTrack_id() {
		return track_id;
	}

	public void setTrack_id(UUID track_id) {
		this.track_id = track_id;
	}

	public String getTrack() {
		return track;
	}

	public void setTrack(String track) {
		this.track = track;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public int getTrack_length_in_seconds() {
		return track_length_in_seconds;
	}

	public void setTrack_length_in_seconds(int track_length_in_seconds) {
		this.track_length_in_seconds = track_length_in_seconds;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getMusic_file() {
		return music_file;
	}

	public void setMusic_file(String music_file) {
		this.music_file = music_file;
	}

	public Boolean getStarred() {
		return starred;
	}

	public void setStarred(Boolean starred) {
		this.starred = starred;
	}

	@Override
	public String toString() {
		return "Track [track_id=" + track_id + ", track=" + track + ", artist=" + artist + ", track_length_in_seconds="
				+ track_length_in_seconds + ", genre=" + genre + ", music_file=" + music_file + ", starred=" + starred
				+ "]";
	}
	
	
	
	
}
