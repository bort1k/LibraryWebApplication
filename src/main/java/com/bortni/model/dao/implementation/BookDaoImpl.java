package com.bortni.model.dao.implementation;

import com.bortni.model.dao.BookDao;
import com.bortni.model.dao.mapper.BookMapper;
import com.bortni.model.dao.sql_queries.BookAttributeSqlQueries;
import com.bortni.model.dao.sql_queries.BookSqlQueries;
import com.bortni.model.entities.Book;
import com.bortni.model.entities.BookAttribute;
import com.bortni.model.entities.Language;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao {

    private Logger LOGGER = Logger.getLogger(BookDaoImpl.class);

    private Connection connection;
    private BookMapper mapper = new BookMapper();

    public BookDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Book getByIdAndLanguage(int bookId, Language language) {
        Book book = new Book.BookBuilder().build();
        final ResultSet resultSet;
        String sql = BookSqlQueries.SELECT_ONE_WITH_LANGUAGE;

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, bookId);
            preparedStatement.setInt(2, language.getId());
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                book = mapper.getFromResultSet(resultSet);
                LOGGER.info("book was created");
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        return book;
    }

    @Override
    public List<Book> getAllAvailable() {
        String sql = BookSqlQueries.SELECT_ALL_AVAILABLE;
        return getListByQuery(sql);
    }

    @Override
    public List<Book> getAllAvailableByLanguage(Language language) {
        String sql = BookSqlQueries.SELECT_ALL_AVAILABLE_WITH_LANGUAGE;
        return getListByQueryAndLanguage(sql, language);
    }


    @Override
    public List<Book> getLastThree(Language language) {
        String sql = BookSqlQueries.SELECT_LAST_THREE;
        return getListByQueryAndLanguage(sql, language);
    }

    @Override
    public void create(Book object) {
        String sql = BookSqlQueries.CREATE;
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            setParameters(object,preparedStatement);
            preparedStatement.execute();
            LOGGER.info("book was created");
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
            LOGGER.info("book was created");
        } catch (SQLException | IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        return book;
    }

    @Override
    public List<Book> getAll() {
        String sql = BookSqlQueries.SELECT_ALL + BookSqlQueries.ORDER_BY_BOOKS_ID_DESC;
        return getListByQuery(sql);
    }

    @Override
    public void update(Book object) {
        String sql = BookSqlQueries.UPDATE;
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            setParameters(object, preparedStatement);
            preparedStatement.setInt(8, object.getId());
            preparedStatement.execute();
            LOGGER.info("book was updated");
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
            preparedStatement.execute();
            LOGGER.info("Book was deleted");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public void close() {
        try{
            connection.close();
            LOGGER.info("connection was closed");
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public List<BookAttribute> getBookAttributesByBookId(int bookId){
        List<BookAttribute> bookAttributes;
        String sql = BookSqlQueries.SELECT_BOOK_ATTRIBUTES;
        final ResultSet resultSet;
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, bookId);
            resultSet = preparedStatement.executeQuery();
            bookAttributes = mapper.getBookAttributes(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        return bookAttributes;
    }

    @Override
    public List<BookAttribute> getBookAttributesByBookIdAndLanguage(int book_id, Language language) {
        List<BookAttribute> bookAttributes;
        String sql = BookSqlQueries.SELECT_BOOK_ATTRIBUTES_WITH_LANGUAGE;
        final ResultSet resultSet;
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, book_id);
            preparedStatement.setInt(2, language.getId());
            resultSet = preparedStatement.executeQuery();
            bookAttributes = mapper.getBookAttributes(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        return bookAttributes;
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
                Book book = mapper.getFromResultSet(resultSet);
                books.add(book);
                LOGGER.info("book was created");
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        return books;
    }

    private List<Book> getListByQueryAndLanguage(String query, Language language){
        List<Book> books = new ArrayList<>();
        final ResultSet resultSet;
        try (PreparedStatement preparedStatementBook = connection.prepareStatement(query)){
            preparedStatementBook.setInt(1, language.getId());
            resultSet = preparedStatementBook.executeQuery();
            while (resultSet.next()){
                Book book = mapper.getFromResultSet(resultSet);
                LOGGER.info("book was created");
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

}
