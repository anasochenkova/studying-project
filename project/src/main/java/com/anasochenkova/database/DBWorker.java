package com.anasochenkova.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/** This class does all the necessary work with database.
 *
 * Created by Anastasia on 27.05.2017.
 * @author Anastasia Sochenkova
 * @version 1.0
 */
public class DBWorker {
    /** Variable that inits database*/
    private UseDB user;
    /** helps to make requests to database*/
    private Statement statement;

    /** Empty constructor that inits DB */
    DBWorker(){
        user = new UseDB();
        try {
            statement = user.getConnection().createStatement();
            System.out.println("Statement creation succeed!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Statement creation failed!");
        }
    }




    /** This method gets songs from DB according to the filter conditions
     *
     * @param selector String of needed columns
     * @param conditions String of filter conditions
     * @return {@code List<Song>}
     */
    public List<Song> getFilteredorFullSongs(String selector, String conditions) {
        List<Song> list = new LinkedList<Song>();
        String condBlock;
        ResultSet resultSet;
        Song song;

        if (selector==null||selector.isEmpty()){
            selector="*";
        }
        if (conditions==null||conditions.isEmpty()){
            condBlock="";
        }
        else{
            condBlock=" WHERE "+conditions;
        }
        try {
             resultSet= statement.executeQuery("SELECT "+selector
                    +"FROM songs"+condBlock+";");
             while(resultSet.next()){
                 song = new Song();
                 song.setSongId(resultSet.getInt("songId"));
                 song.setSongName(resultSet.getString("songName"));
                 song.setSongYear(resultSet.getInt("songYear"));
                 song.setBandId(resultSet.getInt("bandId"));
                 list.add(song);

             }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Query failed!");
        }
        return list;
    }





    /** This method gets songs from DB in Viewable form according to the filter conditions
     *
     * @param selector String of needed columns
     * @param conditions String of filter conditions
     * @return {@code List<ViewableSong>}
     */
    public List<ViewableSong> getFilteredorFullViewableSongs(String selector, String conditions) {
        List<ViewableSong> list = new LinkedList<ViewableSong>();
        String condBlock;
        ResultSet resultSet;
        ViewableSong song;

        if (selector==null||selector.isEmpty()){
            selector="*";
        }
        if (conditions==null||conditions.isEmpty()){
            condBlock="";
        }
        else{
            condBlock=" WHERE "+conditions;
        }
        try {
            resultSet= statement.executeQuery("SELECT "+selector
                    +"FROM songs LEFT JOIN bands ON songs.bandId=bands.bandId"
                    +condBlock+";");
            while(resultSet.next()){
                song = new ViewableSong();
                song.setSongId(resultSet.getInt("songs.songId"));
                song.setSongName(resultSet.getString("songs.songName"));
                song.setSongYear(resultSet.getInt("songs.songYear"));
                song.setBandName(resultSet.getString("bands.bandName"));
                list.add(song);

            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Query failed!");
        }
        return list;
    }



    /** Updates value of the song's column got by songId
     *
     * @param songId int
     * @param column String
     * @param value String
     */
    public void updateSong(int songId, String column, String value){
        String condBlock;
        String query = "UPDATE songs SET "+ column+" = "+value
                +" WHERE songId = "+songId+";";
        //query = "update songs set songYear=2007 where songId=40;";
        try {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Update failed!");
        }
    }


    /** Updates value of the song's column got by songId
     *
     * @param name String
     * @param year int
     * @param bandId int
     */
    public void insertSong(String name,int year, int bandId) {
        String query;
        if (bandId != 0) {
            query = "INSERT INTO songs(songName, songYear, bandId) Values(\"" +
                    name + "\"," + year + "," + bandId + ");";
        } else {
            query = "INSERT INTO songs(songName, songYear) Values(\"" +
                    name + "\"," + year + ");";
        }
        //query = "INSERT INTO songs(songName, SongYear) Values (\"lalala\",20);";
        try {
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Insert failed!");
        }
    }

    /** Deletes song from DB by Id
     *
     * @param id int
     */
    public void deleteSong(int id){
        String query = "DELETE FROM songs WHERE songId="+id;
        try {
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Delete failed!");
        }
    }


}
