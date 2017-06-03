package com.anasochenkova.database;


import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**This class is needed for testing the other classes' functionality
 * Created by Anastasia on 29.05.2017.
 *
 * @author Anastasia
 * @version 1.0
 */
public class Test {
    public static void main(String args[]){
        String query = "select * from bands";
        List<ViewableSong> songlist= new LinkedList<ViewableSong>();
        DBWorker worker = new DBWorker();
        //worker.insertSong("lalalala",2017,0);
        //worker.updateSong(40, "songYear", "2006");
        worker.deleteSong(45);
        songlist = worker.getFilteredorFullViewableSongs("","");
        for (ViewableSong song: songlist){
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
