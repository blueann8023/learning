package me.lm.learning.framework.serviceproviderframesketch.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ResearchJdbc {
    public static void main(String[] args){
        try {

            // Classloader load class (instance Class)
            // Initial class (run static block)
            // Static block
            // DriverManager.registerDriver:Provider Registration API
            Class.forName("com.mysql.jdbc.Driver");//Service Provider Interface Implemetns
            // Driver: Service Provider Interface
            // DriverManager.getConnection : Service Access API
            // Connection : Service Interface
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/spring", "root", "root");
            connection.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
