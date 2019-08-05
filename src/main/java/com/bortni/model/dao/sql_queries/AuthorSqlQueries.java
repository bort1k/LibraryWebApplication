package com.bortni.model.dao.sql_queries;

public class AuthorSqlQueries {

    public static final String SELECT_ALL = "SELECT * FROM authors ,languages " +
            "WHERE languages.id = language_id";

    public static final String SELECT_ONE = "SELECT * FROM authors, languages " +
            "WHERE language_id = languages.id AND authors.id = ?";

}
