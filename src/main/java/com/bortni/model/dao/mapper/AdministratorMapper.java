package com.bortni.model.dao.mapper;

import com.bortni.model.entities.Administrator;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdministratorMapper implements Mapper<Administrator>{

    @Override
    public Administrator getFromResultSet(ResultSet resultSet) throws SQLException {
        return new Administrator.AdministratorBuilder()
                .setId(resultSet.getInt("id"))
                .setLogin(resultSet.getString("login"))
                .setPassword("password")
                .build();
    }
}
