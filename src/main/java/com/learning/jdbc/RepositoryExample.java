package com.learning.jdbc;

import com.learning.jdbc.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

public class RepositoryExample {

    public static void main(String[] args) throws Exception {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "password");
        //UserRepository userRepository = new UserRepository(connection);

        //List<User> all = userRepository.findAll();

        UserRepository2 userRepository2 = new UserRepository2(connection);
        List<User> all = userRepository2.findAll();
    }

}
