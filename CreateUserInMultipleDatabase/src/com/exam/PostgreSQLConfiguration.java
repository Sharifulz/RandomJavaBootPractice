package com.exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PostgreSQLConfiguration {

	public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/CTrendsEBS", "CTrends_conn", "123456")) {
 
            // When this class first attempts to establish a connection, it automatically loads any JDBC 4.0 drivers found within 
            // the class path. Note that your application must manually load any JDBC drivers prior to version 4.0.
//          Class.forName("org.postgresql.Driver"); 
 
            System.out.println("Connected to PostgreSQL database!");
            Statement statement = connection.createStatement();
            // CREATE USER boot WITH PASSWORD '1111';
            // CREATE USER erer WITH PASSWORD '2222'
            // DROP USER sttoop
            // ALTER USER davide WITH PASSWORD 'hu8jmn3';

             statement.executeUpdate("DROP USER sttoop");
            /*
            ResultSet resultSet = statement.executeQuery("SELECT * FROM public.gis_unions");
            while (resultSet.next()) {
                System.out.printf("%-30.30s  %-30.30s%n", resultSet.getString("union_code"), resultSet.getString("union_name"));
            }
            */
             connection.close();  
        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
    }
}
