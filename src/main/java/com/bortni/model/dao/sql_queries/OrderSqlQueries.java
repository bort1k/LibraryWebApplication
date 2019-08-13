package com.bortni.model.dao.sql_queries;

public class OrderSqlQueries {
    public static final String SELECT_ALL = "SELECT * FROM books, books_translate, authors, languages, orders, readers "+
            "WHERE books.id = books_translate.book_id " +
            "AND author_id = authors.id " +
            "AND languages.id = books_translate.language_id " +
            "AND languages.id = authors.language_id " +
            "AND orders.book_id = books.id " +
            "AND books.reader_id = readers.id ";

    public static final String SELECT_BY_READER_ID = SELECT_ALL + "AND books.reader_id = ?";
}
