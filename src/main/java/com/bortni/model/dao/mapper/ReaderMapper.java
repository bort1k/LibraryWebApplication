package com.bortni.model.dao.mapper;

import com.bortni.model.entities.Reader;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ReaderMapper implements Mapper<Reader> {
    @Override
    public Reader getFromResultSet(ResultSet resultSet) throws SQLException {
        return new Reader.ReaderBuilder()
                .setId(resultSet.getInt("id"))
                .setEmail(resultSet.getString("email"))
                .setPassword(resultSet.getString("password"))
                .setTelephoneNumber(resultSet.getString("telephone_number"))
                .setFirstName(resultSet.getString("first_name"))
                .setLastName(resultSet.getString("last_name"))
                .build();
    }
}
