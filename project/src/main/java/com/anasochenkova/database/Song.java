package com.anasochenkova.database;

import javax.persistence.Entity;
import javax.persistence.Id;

/**This class is needed for getting entity <strong>"songs"</strong> from DB
 * Created by Anastasia on 25.05.2017.
 *
 * @author Anastasia
 * @version 1.0
 */
@Entity(name="songs")
public class Song {
    @Id
    private int songId;
    private String songName;
    private int songYear;
    private int bandId;

    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public int getSongYear() {
        return songYear;
    }

    public void setSongYear(int songYear) {
        this.songYear = songYear;
    }

    public int getBandId() {
        return bandId;
    }

    public void setBandId(int bandId) {
        this.bandId = bandId;
    }

    @Override
    public String toString() {
        return "Song{ "+songId+ ", "+ songName+", "+ songYear+", "+ bandId+" }";
    }
}
