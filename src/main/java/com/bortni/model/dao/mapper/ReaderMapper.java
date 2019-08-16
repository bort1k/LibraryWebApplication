package com.bortni.model.dao.mapper;

import com.bortni.model.entities.Reader;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ReaderMapper implements Mapper<Reader> {
    @Override
    public Reader getFromResultSet(ResultSet resultSet) throws SQLException {
        return new Reader.ReaderBuilder()
                .setId(resultSet.getInt("readers.id"))
                .setEmail(resultSet.getString("readers.email"))
                .setPassword(resultSet.getString("readers.password"))
                .setTelephoneNumber(resultSet.getString("readers.telephone_number"))
                .setFirstName(resultSet.getString("readers.first_name"))
                .setLastName(resultSet.getString("readers.last_name"))
                .build();
    }
}
