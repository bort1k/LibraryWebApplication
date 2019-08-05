package com.bortni.model.dao.sql_queries;

public class BookSqlQueries {

    public static final String SELECT_ALL = "SELECT * FROM books, books_translate, authors, languages " +
            "WHERE books.id = book_id AND author_id = authors.id AND languages.id = books_translate.language_id " +
            "AND languages.id = authors.language_id ";
    public static final String SELECT_ALL_AVAILABLE = "SELECT * FROM books, books_translate, authors, languages " +
            "WHERE books.id = book_id AND languages.id = books_translate.language_id " +
            "AND books.is_available = TRUE AND author_id = authors.id " +
            "AND languages.id = authors.language_id ";
    public static final String SELECT_ONE = "SELECT * FROM books, books_translate, languages " +
            "WHERE books.id = book_id AND languages.id = language_id AND books.id = ? " ;

    public static final String SELECT_LAST_THREE = SELECT_ALL + "ORDER BY books.id DESC LIMIT 3";

    //need to be changed
    public static final String CREATE = "INSERT INTO books(title, number_of_pages, is_available, " +
            "address, language, publication_year, publication_office)" +
            "VALUES(?,?,?,?,?,?,?);";
    public static final String UPDATE = "UPDATE books SET title=?,number_of_pages=?,is_available=?,address=?,language=?," +
            "publication_year=?,publication_office=? WHERE books.id=?";
    public static final String DELETE = "DELETE FROM books WHERE books.id=?";
}
