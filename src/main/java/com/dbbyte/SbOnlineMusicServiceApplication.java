package com.dbbyte;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.datastax.driver.core.Session;
import com.dbbyte.repositories.KeyspaceRepository;
import com.dbbyte.util.CassandraConnector;

@SpringBootApplication
public class SbOnlineMusicServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbOnlineMusicServiceApplication.class, args);
	
		
        CassandraConnector connector = new CassandraConnector();
        connector.connect("51.15.134.30", null);
        Session session = connector.getSession();

        KeyspaceRepository sr = new KeyspaceRepository(session);
        sr.createKeyspace("playlist", "SimpleStrategy", 1);
        sr.useKeyspace("playlist");

//        sr.deleteKeyspace("playlist");

        connector.close();


	}
}
