package com.bortni.model.dao.implementation;

import com.bortni.model.dao.mapper.AdministratorMapper;
import com.bortni.model.dao.sql_queries.AdministratorSqlQueries;
import com.bortni.model.entities.Administrator;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.function.Predicate;

public final class AdministratorDaoImpl {
    private Connection connection;
    private AdministratorMapper mapper = new AdministratorMapper();

    public AdministratorDaoImpl(Connection connection) {
        this.connection = connection;
    }

    public Administrator getById(int id) {
        Administrator administrator = new Administrator.AdministratorBuilder().build();
        String sql = AdministratorSqlQueries.SELECT_ONE;
        final ResultSet resultSet;

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                administrator = mapper.getFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        return administrator;
    }

}
