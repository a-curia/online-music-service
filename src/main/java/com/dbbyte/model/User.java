package com.dbbyte.model;

import java.util.Set;

import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;

@Table(keyspace = "playlist", name = "users", readConsistency = "QUORUM", writeConsistency = "QUORUM", caseSensitiveKeyspace = false, caseSensitiveTable = false)
public class User {
	
	@PartitionKey
	@Column(name = "username")
	private String username;
	private String password;
	private Set<String> playlist_names;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String username, String password, Set<String> playlist_names) {
		super();
		this.username = username;
		this.password = password;
		this.playlist_names = playlist_names;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<String> getPlaylist_names() {
		return playlist_names;
	}

	public void setPlaylist_names(Set<String> playlist_names) {
		this.playlist_names = playlist_names;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", playlist_names=" + playlist_names + "]";
	}


}
