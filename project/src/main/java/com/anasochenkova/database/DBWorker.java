package com.anasochenkova.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Anastasia on 27.05.2017.
 */
public class DBWorker {
    private Statement statement;
    DBWorker(){
        UseDB user = new UseDB();
        try {
            statement = user.getConnection().createStatement();
            System.out.println("Statement creation succeed!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Statement creation failed!");
        }
    }
    List<Song> getFilteredorFullSongs(String selector, String conditionals) {
        List<Song> list = new LinkedList<Song>();
        String condBlock;
        ResultSet resultSet;
        Song song;

        if (selector==null||selector.isEmpty()){
            selector="*";
        }
        if (conditionals==null||conditionals.isEmpty()){
            condBlock="";
        }
        else{
            condBlock=" WHERE "+conditionals;
        }
        try {
             resultSet= statement.executeQuery("SELECT "+selector
                    +"FROM songs"+condBlock+";");
             while(resultSet.next()){
                 song = new Song();
                 song.setSongId(resultSet.getInt("songId"));
                 song.setSongName(resultSet.getString("songName"));
                 song.setBandId(resultSet.getInt("bandId"));
                 list.add(song);

             }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Query failed!");
        }
        return list;
    }

}
