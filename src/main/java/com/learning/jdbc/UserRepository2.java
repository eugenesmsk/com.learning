package com.learning.jdbc;

import com.learning.jdbc.model.User;

import java.sql.Connection;

public class UserRepository2 extends AbstractRepository<User> {

    public UserRepository2(Connection connection) {
        super(connection, User.class);
    }

}
