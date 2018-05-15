package me.lm.learning.framework.serviceproviderframesketch.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ReserchJdbc {
    public static void main(String[] args){
        try {

            // Classloader load class (instance Class)
            // Initial class (run static block)
            // Static block
            // DriverManager.registerDriver:Service Register API
            Class.forName("com.mysql.jdbc.Driver");//Service Provider Interface Implemetns
            // Driver: Service Provider Interface
            // DriverManager.getConnection : Service Access API
            // Connection : Service interface
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/spring", "root", "root");
            connection.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
