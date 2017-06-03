package com.anasochenkova.database;

/**This class is needed for representing <strong>songs</strong> in Viewable form
 * Created by Anastasia on 01.06.2017.
 *
 * @author Anastasia
 * @version 1.0
 */
public class ViewableSong {
    private int songId;
    private String songName;
    private int songYear;
    private String bandName;

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

    public String getBandName() {
        return bandName;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
    }

    @Override
    public String toString() {
        return "ViewableSong{ "+songId+ ", "+ songName+", "+ songYear+", "+ bandName+" }";
    }
}
