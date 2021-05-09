package com.learning.jdbc;

import com.learning.jdbc.model.User;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//ORM - object relation mapping
public abstract class AbstractRepository<T> {

    private final Connection connection;
    private final Class<T> clazz;

    public AbstractRepository(Connection connection, Class<T> clazz) {
        this.connection = connection;
        this.clazz = clazz;
    }

    public List<T> findAll() throws Exception {
        TableName tableNameAnnotation = clazz.getAnnotation(TableName.class);
        String tableName = tableNameAnnotation.name();

        List<T> result = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM " + tableName)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    T obj = deserialize(resultSet, clazz);
                    result.add(obj);
                }
            }
        }
        return result;
    }

    private T deserialize(ResultSet rs, Class<T> clazz) throws Exception {
        Field[] fields = clazz.getDeclaredFields();
        T instance = clazz.newInstance(); //default constructor
        for (Field field : fields) {
            field.setAccessible(true);
            Object value = rs.getObject(field.getName());
            field.set(instance, value);
        }
        return instance;
    }

}
