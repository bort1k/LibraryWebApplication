package com.bortni.model.dao.implementation;

import com.bortni.model.dao.BookAttributeDao;
import com.bortni.model.dao.mapper.BookAttributeMapper;
import com.bortni.model.dao.sql_queries.BookAttributeSqlQueries;
import com.bortni.model.entities.BookAttribute;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookAttributeDaoImpl implements BookAttributeDao {

    private Connection connection;
    private BookAttributeMapper mapper = new BookAttributeMapper();

    public BookAttributeDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(BookAttribute object) {

    }

    @Override
    public BookAttribute getById(int id) {
        BookAttribute bookAttribute = new BookAttribute.BookAttributeBuilder().build();
        final ResultSet resultSet;
        String sql = BookAttributeSqlQueries.SELECT_ONE;

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                bookAttribute = mapper.getFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        return bookAttribute;
    }

    @Override
    public List<BookAttribute> getAll() {
        String sql = BookAttributeSqlQueries.SELECT_ALL;
        return getBookAttributes(sql);
    }

    @Override
    public List<BookAttribute> getAttributesByBookId(int book_id) {
        String sql = BookAttributeSqlQueries.SELECT_ALL_BY_BOOK_ID;
        return getBookAttributesByBookId(book_id, sql);
    }

    public List<BookAttribute> searchBookAttributesByBookId(String searchParam){
        String sql = BookAttributeSqlQueries.searchBookAttributesByBookId(searchParam);
        return getBookAttributes(sql);
    }

    private List<BookAttribute> getBookAttributesByBookId(int book_id, String sql) {
        List<BookAttribute> bookAttributes = new ArrayList<>();
        final ResultSet resultSet;
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, book_id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                bookAttributes.add(mapper.getFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        return bookAttributes;
    }

    private List<BookAttribute> getBookAttributes(String sql) {
        List<BookAttribute> bookAttributes = new ArrayList<>();
        final ResultSet resultSet;

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                bookAttributes.add(mapper.getFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        return bookAttributes;
    }

    @Override
    public void update(BookAttribute object) {

    }

    @Override
    public void delete(BookAttribute object) {

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
