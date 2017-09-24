package com.dbbyte.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.dbbyte.model.Artists;
import com.dbbyte.model.Track;
import com.dbbyte.util.CassandraConnector;

@Controller
public class IndexController {
	private static final String appName="Online Music Service";
	
    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("siteName", appName);
        return "index";
    }
    
    @RequestMapping("/pageArtistsByFirstLetter")
    public String artistsByFirstLetter(@RequestParam(value="first_letter", defaultValue="A") String first_letter, Model model) {
    	
    	CassandraConnector connector = new CassandraConnector();
        connector.connect("51.15.134.30", null);
        Session session = connector.getSession();
    	
	    ResultSet rsTbA = session.execute("SELECT * FROM playlist.artists_by_first_letter WHERE first_letter = '"+first_letter+"';"); 
	    
	    List<Artists> list = new ArrayList<>();

	    
	    for (Row artistRow : rsTbA) {
	    	String firstLetter = artistRow.getString("first_letter");
	    	String artists = artistRow.getString("artist");
	    	
	    	list.add(new Artists(firstLetter,artists));
	    }	    
	    
        connector.close();
        model.addAttribute("artists", list);
        
        return "artists_view";
    }
    

    @RequestMapping("/pageTrackById")
    public String trackById(@RequestParam(value="id", defaultValue="235bc2af-e3d4-4087-9cac-f3859305a20e") UUID id, Model model) {
    	
    	CassandraConnector connector = new CassandraConnector();
        connector.connect("51.15.134.30", null);
        Session session = connector.getSession();
    	
	    ResultSet rsTbA = session.execute("SELECT * FROM playlist.track_by_id WHERE track_id = "+id+";"); 
	    
	    List<Track> list = new ArrayList<Track>();

	    
	    for (Row artistRow : rsTbA) {
	    	UUID track_id = artistRow.getUUID("track_id");
	    	String track = artistRow.getString("track");
	    	String artists = artistRow.getString("artist");
	    	int track_length_in_seconds = artistRow.getInt("track_length_in_seconds");
	    	String genre = artistRow.getString("genre");
	    	String music_file = artistRow.getString("music_file");
//	    	Boolean starred = artistRow.getBool("starred");
	    	
	    	
	    	list.add(new Track(track_id, track, artists, track_length_in_seconds, genre, music_file, true));
	    }	    
	    
        connector.close();
        model.addAttribute("tracks", list);
        
        return "tracks_view";
    }	
	
	
    @RequestMapping("/pageTrackByGenre")
    public String trackByGenre(@RequestParam(value="genre", defaultValue="classical") String genre, Model model) {
    	
    	CassandraConnector connector = new CassandraConnector();
        connector.connect("51.15.134.30", null);
        Session session = connector.getSession();
    	
	    ResultSet rsTbA = session.execute("SELECT * FROM playlist.track_by_genre WHERE genre = '"+genre+"';"); 
	    
	    List<Track> list = new ArrayList<Track>();

	    
	    for (Row artistRow : rsTbA) {
	    	UUID track_id = artistRow.getUUID("track_id");
	    	String track = artistRow.getString("track");
	    	String artist = artistRow.getString("artist");
	    	int track_length_in_seconds = artistRow.getInt("track_length_in_seconds");
	    	String genreFrom = artistRow.getString("genre");
	    	String music_file = artistRow.getString("music_file");
	    	Boolean starred = artistRow.getBool("starred");
	    	
	    	
	    	list.add(new Track(track_id, track, artist, track_length_in_seconds, genreFrom, music_file, starred));
	    }	    
	    
        connector.close();
        model.addAttribute("tracks", list);
        
        return "tracks_view";
    }	
    
    
    @RequestMapping("/pageTrackByArtist")
    public String trackByArtist(@RequestParam(value="artist", defaultValue="Richard") String artist, Model model) {
    	
    	CassandraConnector connector = new CassandraConnector();
        connector.connect("51.15.134.30", null);
        Session session = connector.getSession();
    	
	    ResultSet rsTbA = session.execute("SELECT * FROM playlist.track_by_artist WHERE artist = '"+artist+"';"); 
	    
	    List<Track> list = new ArrayList<>();

	    
	    for (Row artistRow : rsTbA) {
	    	UUID track_id = artistRow.getUUID("track_id");
	    	String track = artistRow.getString("track");
	    	String artists = artistRow.getString("artist");
	    	int track_length_in_seconds = artistRow.getInt("track_length_in_seconds");
	    	String genre = artistRow.getString("genre");
	    	String music_file = artistRow.getString("music_file");
	    	Boolean starred = artistRow.getBool("starred");
	    	
	    	
	    	list.add(new Track(track_id, track, artists, track_length_in_seconds, genre, music_file, starred));
	    }	    
	    
        connector.close();
        model.addAttribute("tracks", list);
        
        return "tracks_view";
    }	    
        
    
    
    
    
    
    
    

    
}
