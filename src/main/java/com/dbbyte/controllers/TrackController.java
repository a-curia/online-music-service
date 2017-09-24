package com.dbbyte.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.dbbyte.model.Track;
import com.dbbyte.util.CassandraConnector;

@RestController
public class TrackController {

    @RequestMapping("/trackById")
    public List<Track> trackById(@RequestParam(value="id", defaultValue="235bc2af-e3d4-4087-9cac-f3859305a20e") UUID id) {
    	
    	CassandraConnector connector = new CassandraConnector();
        connector.connect("51.15.134.30", null);
        Session session = connector.getSession();
    	
	    ResultSet rs = session.execute("SELECT * FROM playlist.track_by_id WHERE track_id = "+id+";"); 
	    
	    List<Track> list = new ArrayList<>();

	    
	    for (Row row : rs) {
	    	UUID track_id = row.getUUID("track_id");
	    	String track = row.getString("track");
	    	String artists = row.getString("artist");
	    	int track_length_in_seconds = row.getInt("track_length_in_seconds");
	    	String genre = row.getString("genre");
	    	String music_file = row.getString("music_file");
//	    	Boolean starred = row.getBool("starred");
	    	
	    	
	    	list.add(new Track(track_id, track, artists, track_length_in_seconds, genre, music_file, true));
	    }	    
	    
        connector.close();
        return list;
    }	
	
	
    @RequestMapping("/trackByGenre")
    public List<Track> trackByGenre(@RequestParam(value="genre", defaultValue="classical") String genre) {
    	
    	CassandraConnector connector = new CassandraConnector();
        connector.connect("51.15.134.30", null);
        Session session = connector.getSession();
    	
	    ResultSet rs = session.execute("SELECT * FROM playlist.track_by_genre WHERE genre = '"+genre+"';"); 
	    
	    List<Track> list = new ArrayList<>();

	    
	    for (Row row : rs) {
	    	UUID track_id = row.getUUID("track_id");
	    	String track = row.getString("track");
	    	String artist = row.getString("artist");
	    	int track_length_in_seconds = row.getInt("track_length_in_seconds");
	    	String genreFrom = row.getString("genre");
	    	String music_file = row.getString("music_file");
	    	Boolean starred = row.getBool("starred");
	    	
	    	
	    	list.add(new Track(track_id, track, artist, track_length_in_seconds, genreFrom, music_file, starred));
	    }	    
	    
        connector.close();
        return list;
    }	
    
    
    @RequestMapping("/trackByArtist")
    public List<Track> trackByArtist(@RequestParam(value="artist", defaultValue="Richard") String artist) {
    	
    	CassandraConnector connector = new CassandraConnector();
        connector.connect("51.15.134.30", null);
        Session session = connector.getSession();
    	
	    ResultSet rs = session.execute("SELECT * FROM playlist.track_by_artist WHERE artist = '"+artist+"';"); 
	    
	    List<Track> list = new ArrayList<>();

	    
	    for (Row row : rs) {
	    	UUID track_id = row.getUUID("track_id");
	    	String track = row.getString("track");
	    	String artists = row.getString("artist");
	    	int track_length_in_seconds = row.getInt("track_length_in_seconds");
	    	String genre = row.getString("genre");
	    	String music_file = row.getString("music_file");
	    	Boolean starred = row.getBool("starred");
	    	
	    	
	    	list.add(new Track(track_id, track, artists, track_length_in_seconds, genre, music_file, starred));
	    }	    
	    
        connector.close();
        return list;
    }	    
    
    
}
