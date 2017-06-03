package com.anasochenkova.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/** This class inits connection with database and allows to work with DB
 *
 * Created by Anastasia on 25.05.2017.
 *
 * @author Anastasia
 * @version 1.0
 */
public class UseDB {
    /** HOST URL */
    private final static String HOST =
            "jdbc:mysql://localhost:3306/musicdb";
    /** HOST URL with all properties*/
    private final static String FULLURL =
            "jdbc:mysql://localhost:3306/musicdb?useUnicode=true&useSSL=true&useJDBCCompliantTimezoneShift=true" +
                    "&useLegacyDatetimeCode=false&serverTimezone=UTC";
    /** USERNAME to access DB */
    private final static String USERNAME = "root";
    /** PASSWORD to access DB*/
    private final static String PASSWORD = "root";

    /** Connection with DB*/
    private Connection connection;



    /** Constructor that inits DB
     *
     */
    UseDB(){
        initConnection();
    }


    /**Method helps to open connection with DB
     */
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
