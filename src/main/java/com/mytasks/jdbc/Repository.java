package com.mytasks.jdbc;

import java.sql.*;

public class Repository {
    public static void main(String[] args) {

        try(Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "08irasah")) {
            try(PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users")) {
                try(ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String name = resultSet.getString("name");
                        int age = resultSet.getInt("age");
                        System.out.println("id: " + id + ", name: " + name + ", age: " + age);
                    }

                }
            }
            try(PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users VALUES (?, ?, ?)")) {
                preparedStatement.setInt(1, 1);
                preparedStatement.setString(2, "eugen");
                preparedStatement.setInt(3, 27);
                preparedStatement.executeUpdate();
                preparedStatement.setInt(1, 2);
                preparedStatement.setString(2, "alex");
                preparedStatement.setInt(3, 29);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
