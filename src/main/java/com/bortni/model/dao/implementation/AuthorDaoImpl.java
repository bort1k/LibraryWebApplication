package com.bortni.model.dao.implementation;

import com.bortni.model.dao.AuthorDao;
import com.bortni.model.dao.mapper.AuthorMapper;
import com.bortni.model.dao.mapper.Mapper;
import com.bortni.model.dao.sql_queries.AuthorSqlQueries;
import com.bortni.model.entities.Author;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuthorDaoImpl implements AuthorDao {

    private Connection connection;
    private AuthorMapper mapper = new AuthorMapper();

    public AuthorDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Author object) {

    }

    @Override
    public Author getById(int id) {
        Author author = new Author.AuthorBuilder().build();
        String sql = AuthorSqlQueries.SELECT_ONE;
        final ResultSet resultSet;

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                 author = mapper.getFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        return author;
    }

    @Override
    public List<Author> getAll() {
        List<Author> authors = new ArrayList<>();
        final ResultSet resultSet;
        String sql = AuthorSqlQueries.SELECT_ALL;

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                authors.add(mapper.getFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        return authors;
    }

    @Override
    public void update(Author object) {

    }

    @Override
    public void delete(Author object) {

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
