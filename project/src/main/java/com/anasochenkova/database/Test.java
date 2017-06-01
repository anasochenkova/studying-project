package com.anasochenkova.database;


import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Anastasia on 29.05.2017.
 */
public class Test {
    public static void main(String args[]){
        String query = "select * from bands";
        List<Song> songlist= new LinkedList<Song>();
        DBWorker worker = new DBWorker();
        songlist = worker.getFilteredorFullSongs("","");
        for (Song song: songlist){
            System.out.println(song);
        }
        /*
        try {
            Statement statement = user.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString("bandName");
                System.out.println(""+id+" "+name);
            }
            //prepstatement=user.getConnection().prepareStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        */

    }
}
