package com.anasochenkova.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Anastasia on 25.05.2017.
 */
public class UseDB {

    private final static String HOST =
            "jdbc:mysql://localhost:3306/musicdb";
    private final static String FULLURL =
            "jdbc:mysql://localhost:3306/musicdb?useUnicode=true&useSSL=true&useJDBCCompliantTimezoneShift=true" +
                    "&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "root";

    private Connection connection;

    UseDB(){
        initConnection();
    }

    public  void initConnection() {
        try {
            connection = DriverManager.getConnection(FULLURL, USERNAME, PASSWORD);
            if(!connection.isClosed()){
                System.out.println("Connection opened!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("DataBase connection Failed!");
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
