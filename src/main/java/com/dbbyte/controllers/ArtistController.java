package com.dbbyte.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.dbbyte.model.Artists;
import com.dbbyte.util.CassandraConnector;

@RestController
public class ArtistController {
	
    @RequestMapping("/artistsByFirstLetter")
    public List<Artists> artistsByFirstLetter(@RequestParam(value="first_letter", defaultValue="A") String first_letter) {
    	
    	CassandraConnector connector = new CassandraConnector();
        connector.connect("51.15.134.30", null);
        Session session = connector.getSession();
    	
	    ResultSet rs = session.execute("SELECT * FROM playlist.artists_by_first_letter WHERE first_letter = '"+first_letter+"';"); 
	    
	    List<Artists> list = new ArrayList<>();

	    
	    for (Row row : rs) {
	    	String firstLetter = row.getString("first_letter");
	    	String artists = row.getString("artist");
	    	
	    	list.add(new Artists(firstLetter,artists));
	    }	    
	    
        connector.close();
        return list;
    }	
	
}
