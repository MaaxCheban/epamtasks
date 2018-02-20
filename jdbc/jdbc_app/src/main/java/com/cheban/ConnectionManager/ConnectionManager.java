package com.cheban.ConnectionManager;
import java.sql.*;

/**
 * Created by MAX on 20.02.2018.
 */
public class ConnectionManager {
    private static final String url = "jdbc:mysql://localhost:3306/sample?serverTimezone=UTC&useSSL=false";
    private static final String user = "root";
    private static final String password = "root";

    private static Connection connection = null;


    public static Connection getConnection(){
        if(connection == null){
            try {
                connection = DriverManager.getConnection(url, user, password);
            } catch (SQLException ex) {
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());
            }
        }
        return connection;
    }


}
