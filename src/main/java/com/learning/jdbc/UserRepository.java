package com.learning.jdbc;

import com.learning.jdbc.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    private final Connection connection;

    public UserRepository(Connection connection) {
        this.connection = connection;
    }

    public List<User> findAll() throws Exception {
        List<User> result = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users")) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    User user = new User();
                    user.id = resultSet.getInt("id");
                    user.name = resultSet.getString("name");
                    result.add(user);
                }
            }
        }
        return result;
    }

}
