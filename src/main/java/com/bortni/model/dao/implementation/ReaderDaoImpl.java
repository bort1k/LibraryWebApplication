package com.bortni.model.dao.implementation;

import com.bortni.model.dao.ReaderDao;
import com.bortni.model.dao.mapper.ReaderMapper;
import com.bortni.model.dao.sql_queries.ReaderSqlQueries;
import com.bortni.model.entities.Reader;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReaderDaoImpl implements ReaderDao {

    private Connection connection;
    private ReaderMapper mapper = new ReaderMapper();

    public ReaderDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Reader object) {
        String sql = ReaderSqlQueries.CREATE;
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, object.getEmail());
            preparedStatement.setString(2, object.getPassword());
            preparedStatement.setString(3, object.getTelephoneNumber());
            preparedStatement.setString(4, object.getFirstName());
            preparedStatement.setString(5, object.getLastName());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public Reader getById(int id) {
        Reader reader = new Reader.ReaderBuilder().build();
        String sql = ReaderSqlQueries.SELECT_ONE;
        final ResultSet resultSet;
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                reader = mapper.getFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        return reader;
    }

    @Override
    public List<Reader> getAll() {
        List<Reader> readers = new ArrayList<>();
        String sql = ReaderSqlQueries.SELECT_ALL;
        final ResultSet resultSet;
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                readers.add(mapper.getFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        return readers;
    }

    @Override
    public boolean isExist(String email, String password) {
        boolean exist;
        String sql = ReaderSqlQueries.SELECT_READER_BY_EMAIL_AND_PASSWORD;
        final ResultSet resultSet;
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, email);
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
    public Reader getReaderByEmailAndPassword(String email, String password) {
        String sql = ReaderSqlQueries.SELECT_READER_BY_EMAIL_AND_PASSWORD;
        final ResultSet resultSet;
        Reader reader = new Reader.ReaderBuilder().build();
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                reader = mapper.getFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        return reader;
    }

    @Override
    public boolean isEmailExist(String email) {
        boolean exist;
        String sql = ReaderSqlQueries.SELECT_READER_BY_EMAIL;
        final ResultSet resultSet;
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, email);
            resultSet = preparedStatement.executeQuery();
            exist = resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        return exist;
    }

    @Override
    public void update(Reader object) {

    }

    @Override
    public void delete(Reader object) {

    }

    @Override
    public void close() {

    }
}
