package com.dbbyte.repositories;


import java.util.ArrayList;
import java.util.List;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.dbbyte.model.Artists;

public class ArtistsRepository {

    private static final String TABLE_NAME = "artists";

    private static final String TABLE_NAME_BY_FIRST_LETTER = TABLE_NAME + "by_first_letter";

    private Session session;

    public ArtistsRepository(Session session) {
        this.session = session;
    }


    public void createTable() {
        StringBuilder sb = new StringBuilder("CREATE TABLE IF NOT EXISTS ").append(TABLE_NAME).append("(").append("id uuid PRIMARY KEY, ").append("first_letter text,").append("artist text);");

        final String query = sb.toString();
        session.execute(query);
    }

    public void createTableArtistssByTitle() {
        StringBuilder sb = new StringBuilder("CREATE TABLE IF NOT EXISTS ").append(TABLE_NAME_BY_FIRST_LETTER).append("(").append("id uuid, ").append("title text,").append("PRIMARY KEY (title, id));");

        final String query = sb.toString();
        session.execute(query);
    }

    public void alterTableArtistss(String columnName, String columnType) {
        StringBuilder sb = new StringBuilder("ALTER TABLE ").append(TABLE_NAME).append(" ADD ").append(columnName).append(" ").append(columnType).append(";");

        final String query = sb.toString();
        session.execute(query);
    }

    public void insertArtists(Artists Artists) {
        StringBuilder sb = new StringBuilder("INSERT INTO ").append(TABLE_NAME).append("(first_letter, artist) ").append("VALUES (").append(Artists.getFirst_letter()).append(", '").append(Artists.getArtist()).append("');");

        final String query = sb.toString();
        session.execute(query);
    }

    public void insertArtistsByTitle(Artists Artists) {
        StringBuilder sb = new StringBuilder("INSERT INTO ").append(TABLE_NAME_BY_FIRST_LETTER).append("(first_letter, artist) ").append("VALUES (").append(Artists.getFirst_letter()).append(", '").append(Artists.getArtist()).append("');");

        final String query = sb.toString();
        session.execute(query);
    }

    public void insertArtistsBatch(Artists Artists) {
        StringBuilder sb = new StringBuilder("BEGIN BATCH ").append("INSERT INTO ").append(TABLE_NAME).append("(first_letter, artist) ").append("VALUES (").append(Artists.getFirst_letter()).append(", '").append(Artists.getArtist()).append("');").append("INSERT INTO ").append(TABLE_NAME_BY_FIRST_LETTER).append("(id, title) ").append("VALUES (").append(Artists.getFirst_letter()).append(", '").append(Artists.getArtist()).append("');")
                .append("APPLY BATCH;");

        final String query = sb.toString();
        session.execute(query);
    }

    public Artists selectByTitle(String title) {
        StringBuilder sb = new StringBuilder("SELECT * FROM ").append(TABLE_NAME_BY_FIRST_LETTER).append(" WHERE first_letter = '").append(title).append("';");

        final String query = sb.toString();

        ResultSet rs = session.execute(query);

        List<Artists> Artistss = new ArrayList<Artists>();

        for (Row r : rs) {
            Artists s = new Artists(r.getString("getString"), r.getString("artist"));
            Artistss.add(s);
        }

        return Artistss.get(0);
    }

    public List<Artists> selectAll() {
        StringBuilder sb = new StringBuilder("SELECT * FROM ").append(TABLE_NAME);

        final String query = sb.toString();
        ResultSet rs = session.execute(query);

        List<Artists> Artistss = new ArrayList<Artists>();

        for (Row r : rs) {
            Artists Artists = new Artists(r.getString("first_letter"), r.getString("artist"));
            Artistss.add(Artists);
        }
        return Artistss;
    }

    public List<Artists> selectAllArtistsByFirstLetter() {
        StringBuilder sb = new StringBuilder("SELECT * FROM ").append(TABLE_NAME_BY_FIRST_LETTER);

        final String query = sb.toString();
        ResultSet rs = session.execute(query);

        List<Artists> Artistss = new ArrayList<Artists>();

        for (Row r : rs) {
            Artists Artists = new Artists(r.getString("first_letter"), r.getString("artist"));
            Artistss.add(Artists);
        }
        return Artistss;
    }

    public void deleteArtistsByTitle(String first_letter) {
        StringBuilder sb = new StringBuilder("DELETE FROM ").append(TABLE_NAME_BY_FIRST_LETTER).append(" WHERE first_letter = '").append(first_letter).append("';");

        final String query = sb.toString();
        session.execute(query);
    }

    public void deleteTable(String tableName) {
        StringBuilder sb = new StringBuilder("DROP TABLE IF EXISTS ").append(tableName);

        final String query = sb.toString();
        session.execute(query);
    }
}