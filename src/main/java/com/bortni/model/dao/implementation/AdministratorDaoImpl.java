package com.bortni.model.dao.implementation;

import com.bortni.model.dao.AdministratorDao;
import com.bortni.model.dao.mapper.AdministratorMapper;
import com.bortni.model.dao.sql_queries.AdministratorSqlQueries;
import com.bortni.model.entities.Administrator;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public final class AdministratorDaoImpl implements AdministratorDao {
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

    @Override
    public Administrator getByLoginAndPassword(String login, String password) {
        Administrator administrator = new Administrator.AdministratorBuilder().build();
        String sql = AdministratorSqlQueries.SELECT_BY_LOGIN_AND_PASSWORD;
        final ResultSet resultSet;
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
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

    @Override
    public boolean isExist(String login, String password) {
        boolean exist;
        String sql = AdministratorSqlQueries.SELECT_BY_LOGIN_AND_PASSWORD;
        final ResultSet resultSet;
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);

            resultSet = preparedStatement.executeQuery();
            exist = resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        return exist;
    }

    @Override
    public void create(Administrator object) {

    }

    @Override
    public List<Administrator> getAll() {
        return null;
    }

    @Override
    public void update(Administrator object) {

    }

    @Override
    public void delete(Administrator object) {

    }

    @Override
    public void close() {
        try{
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}
