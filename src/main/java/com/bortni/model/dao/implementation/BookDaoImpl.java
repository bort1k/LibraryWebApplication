package com.bortni.model.dao.implementation;

import com.bortni.model.dao.BookDao;
import com.bortni.model.dao.mapper.BookMapper;
import com.bortni.model.dao.sql_queries.BookAttributeSqlQueries;
import com.bortni.model.dao.sql_queries.BookSqlQueries;
import com.bortni.model.entities.Book;
import com.bortni.model.entities.BookAttribute;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao {

    private Connection connection;
    private BookMapper mapper = new BookMapper();

    BookDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Book> getAllAvailable() {
        String sql = BookSqlQueries.SELECT_ALL_AVAILABLE;
        return getListByQuery(sql);
    }

    @Override
    public List<Book> getLastThree() {
        String sql = BookSqlQueries.SELECT_LAST_THREE;
        return getListByQuery(sql);
    }

    @Override
    public void create(Book object) {
        String sql = BookSqlQueries.CREATE;
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            setParameters(object,preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public Book getById(int id) {
        Book book = new Book.BookBuilder().build();
        final ResultSet resultSet;
        String sql = BookSqlQueries.SELECT_ONE;

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                book = mapper.getFromResultSet(resultSet);
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        return book;
    }

    @Override
    public List<Book> getAll() {
        String sql = BookSqlQueries.SELECT_ALL;
        return getListByQuery(sql);
    }

    @Override
    public void update(Book object) {
        String sql = BookSqlQueries.UPDATE;
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            setParameters(object, preparedStatement);
            preparedStatement.setInt(8, object.getId());
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public void delete(Book object) {
        String sql = BookSqlQueries.DELETE;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, object.getId());
            preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public void close() {
        try{
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public List<Book> searchByParam(String param){
        List<Book> books;
        String sqlSearchByTitleAndAuthor = BookSqlQueries.searchBooksTitleAndAuthorByParam(param);
        String sqlSearchByAttributes = BookSqlQueries.searchBookAttributesByBookId(param);

        if(getListByQuery(sqlSearchByTitleAndAuthor).size() != 0){
            books = getListByQuery(sqlSearchByTitleAndAuthor);
        }
        else {
            books = getListByQuery(sqlSearchByAttributes);
        }
        return books;
    }

    private List<Book> getListByQuery(String query){
        List<Book> books = new ArrayList<>();
        final ResultSet resultSet;
        try (PreparedStatement preparedStatementBook = connection.prepareStatement(query)){
            resultSet = preparedStatementBook.executeQuery();
            while (resultSet.next()){
                Book book = mapper.getBook(resultSet, getBookAttributes(resultSet.getInt(1)));
                books.add(book);
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        return books;
    }

    private void setParameters(Book object, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, object.getTitle());
        preparedStatement.setInt(2, object.getNumberOfPages());
        preparedStatement.setBoolean(3, object.isAvailable());
        preparedStatement.setString(4, object.getAddress());
        preparedStatement.setString(5, object.getBookLanguage());
        preparedStatement.setInt(6, object.getPublicationYear());
        preparedStatement.setString(7, object.getPublicationOffice());
    }

    private List<BookAttribute> getBookAttributes(int book_id) {
        return new BookAttributeDaoImpl(connection).getAttributesByBookId(book_id);
    }

}
