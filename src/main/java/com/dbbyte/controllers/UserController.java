package com.dbbyte.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.dbbyte.model.User;
import com.dbbyte.util.CassandraConnector;

@RestController
public class UserController {
	
    @RequestMapping("/users")
    public List<User> getUserByUsername(@RequestParam(value="username", defaultValue="admin") String username) {
    	
    	CassandraConnector connector = new CassandraConnector();
        connector.connect("51.15.134.30", null);
        Session session = connector.getSession();
    	
	    ResultSet rs = session.execute("SELECT * FROM playlist.users WHERE username = '"+username+"';"); 
	    
	    List<User> list = new ArrayList<>();

	    
	    for (Row row : rs) {
	    	String username1 = row.getString("username");
	    	String password = row.getString("password");
	    	Set<String> playlist_names = row.getSet("playlist_names",String.class);
	    	
	    	list.add(new User(username1, password, playlist_names));
	    }	    
	    
        connector.close();
        return list;
    }	
}
