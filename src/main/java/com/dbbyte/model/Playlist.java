package com.dbbyte.model;

import java.util.UUID;

import com.datastax.driver.mapping.annotations.ClusteringColumn;
import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;

@Table(keyspace = "playlist", name = "playlist_tracks")
public class Playlist {
	
	@PartitionKey(0)
	@Column(name = "username")
	private String username;
	@PartitionKey(1)
	@Column(name = "playlist_name")
	private String playlist_name;
	@ClusteringColumn
	private String sequence_no;
	
	private String artist;
	private String track_name;
	private String genre;
	private int track_length_in_seconds;
	private UUID track_id;
	
	public Playlist() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Playlist(String username, String playlist_name, String sequence_no, String artist, String track_name,
			String genre, int track_length_in_seconds, UUID track_id) {
		super();
		this.username = username;
		this.playlist_name = playlist_name;
		this.sequence_no = sequence_no;
		this.artist = artist;
		this.track_name = track_name;
		this.genre = genre;
		this.track_length_in_seconds = track_length_in_seconds;
		this.track_id = track_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPlaylist_name() {
		return playlist_name;
	}
	public void setPlaylist_name(String playlist_name) {
		this.playlist_name = playlist_name;
	}
	public String getSequence_no() {
		return sequence_no;
	}
	public void setSequence_no(String sequence_no) {
		this.sequence_no = sequence_no;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getTrack_name() {
		return track_name;
	}
	public void setTrack_name(String track_name) {
		this.track_name = track_name;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public int getTrack_length_in_seconds() {
		return track_length_in_seconds;
	}
	public void setTrack_length_in_seconds(int track_length_in_seconds) {
		this.track_length_in_seconds = track_length_in_seconds;
	}
	public UUID getTrack_id() {
		return track_id;
	}
	public void setTrack_id(UUID track_id) {
		this.track_id = track_id;
	}
	@Override
	public String toString() {
		return "Playlist [username=" + username + ", playlist_name=" + playlist_name + ", sequence_no=" + sequence_no
				+ ", artist=" + artist + ", track_name=" + track_name + ", genre=" + genre
				+ ", track_length_in_seconds=" + track_length_in_seconds + ", track_id=" + track_id + "]";
	}
	
}
