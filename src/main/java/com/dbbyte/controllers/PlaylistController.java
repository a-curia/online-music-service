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
import com.dbbyte.model.Playlist;
import com.dbbyte.util.CassandraConnector;

@RestController
public class PlaylistController {
	
    @RequestMapping("/playlistTracks")
    public List<Playlist> playlistTracks(@RequestParam(value="username", defaultValue="admin") String username, @RequestParam(value="playlist_name", defaultValue="playlist_admin_1") String playlist_name) {
    	
    	CassandraConnector connector = new CassandraConnector();
        connector.connect("51.15.134.30", null);
        Session session = connector.getSession();
    	
	    ResultSet rs = session.execute("SELECT * FROM playlist.playlist_tracks WHERE username = '"+username+"' AND playlist_name = '"+playlist_name+"';"); 
	    
	    List<Playlist> list = new ArrayList<>();

	    
	    for (Row row : rs) {
	    	String username1 = row.getString("username");
	    	String playlist_name1 = row.getString("playlist_name");
	    	String sequence_no = row.getString("sequence_no");
	    	String artist = row.getString("artist");
	    	String track_name = row.getString("track_name");
	    	String genre = row.getString("genre");
	    	int track_length_in_seconds = row.getInt("track_length_in_seconds");
	    	UUID track_id = row.getUUID("track_id");
	    	
	    	list.add(new Playlist(username1, playlist_name1, sequence_no, artist, track_name, genre, track_length_in_seconds, track_id));
	    }	    
	    
        connector.close();
        return list;
    }	
}
