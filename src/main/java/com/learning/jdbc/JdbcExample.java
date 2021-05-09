package com.learning.jdbc;

import javax.print.attribute.standard.PresentationDirection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcExample {

    public static void main(String[] args) throws Exception {
        Class.forName("org.postgresql.Driver");

        //try-with-resourcesD
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "password")) {
            try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE id = ?")) {
                preparedStatement.setInt(1, 1);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String name = resultSet.getString("name");
                        System.out.println("id = " + id + " name " + name);
                    }
                }
            }
            //try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users VALUES (3, 'alex')")) {
            //    int linesModified = preparedStatement.executeUpdate();
            //    System.out.println("lines modified: " + linesModified);
            //}
        }
    }

}
