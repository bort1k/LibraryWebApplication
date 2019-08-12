package com.bortni.model.dao.sql_queries;

public class ReaderSqlQueries {
    public static final String SELECT_ALL = "SELECT * FROM readers";
    public static final String SELECT_ONE = "SELECT * FROM readers WHERE readers.id = ?";

    public static final String CREATE = "INSERT INTO readers(email, password, telephone_number, first_name, last_name) " +
            "VALUES (?, ?, ?, ?, ?)";

    public static final String SELECT_READER_BY_EMAIL_AND_PASSWORD = "SELECT * FROM readers WHERE email = ? " +
            "AND password = ?";

    public static final String SELECT_READER_BY_EMAIL = "SELECT email FROM readers WHERE email = ?";
}
