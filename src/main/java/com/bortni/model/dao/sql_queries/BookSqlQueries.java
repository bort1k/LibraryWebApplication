package com.bortni.model.dao.sql_queries;

public class BookSqlQueries {

    public static final String ORDER_BY_BOOKS_ID_DESC =
            "ORDER BY books.id DESC ";
    public static final String SELECT_ALL =
            "SELECT * FROM books, books_translate, authors, languages " +
            "WHERE books.id = books_translate.book_id " +
            "AND author_id = authors.id " +
            "AND languages.id = books_translate.language_id " +
            "AND languages.id = authors.language_id ";

    public static final String SELECT_ALL_AVAILABLE = SELECT_ALL +
            "AND books.is_available = TRUE " +
            ORDER_BY_BOOKS_ID_DESC;

    public static final String SELECT_ONE = SELECT_ALL + "AND books.id = ?";

    public static final String SELECT_LAST_THREE = SELECT_ALL_AVAILABLE +  "LIMIT 3";

    public static final String SELECT_BOOK_ATTRIBUTES =
            "SELECT * " +
                    "FROM attributes, books_attributes, books, languages " +
                    "WHERE attributes.id = books_attributes.attribute_id " +
                    "AND books.id = books_attributes.book_id " +
                    "AND attributes.language_id = languages.id " +
                    "AND books_attributes.book_id = ? ";


    //need to be changed
    public static final String CREATE = "INSERT INTO books(title, number_of_pages, is_available, " +
            "address, language, publication_year, publication_office)" +
            "VALUES(?,?,?,?,?,?,?);";
    public static final String UPDATE = "UPDATE books SET title=?,number_of_pages=?,is_available=?,address=?,language=?," +
            "publication_year=?,publication_office=? WHERE books.id=?";
    public static final String DELETE = "DELETE FROM books WHERE books.id=?";

    public static String searchBooksTitleAndAuthorByParam(String searchParam){
        return  "SELECT DISTINCT * FROM books " +
                "LEFT JOIN books_translate ON books_translate.book_id = books.id " +
                "LEFT JOIN authors ON authors.id = books.author_id " +
                "LEFT JOIN languages ON languages.id = books_translate.language_id " +
                "AND languages.id = authors.language_id WHERE " +
                "(" +
                "(books_translate.title LIKE '%" + searchParam + "%') " +
                "OR (authors.first_name LIKE '%" + searchParam + "%') " +
                "OR (authors.last_name LIKE '%" + searchParam + "%') " +
                ")";
    }

    public static String searchBookAttributesByBookId(String searchParam){
        return "SELECT DISTINCT * FROM books " +
        "LEFT JOIN books_translate ON books_translate.book_id = books.id " +
        "LEFT JOIN authors ON authors.id = books.author_id " +
        "LEFT JOIN books_attributes ON books_attributes.book_id = books.id " +
        "LEFT JOIN attributes ON books_attributes.attribute_id = attributes.id " +
        "LEFT JOIN languages ON languages.id = books_translate.language_id " +
        "AND languages.id = authors.language_id " +
        "AND languages.id = attributes.language_id " +
        "WHERE " +
        "(" +
        "( attributes.key_word LIKE '%" + searchParam + "%')" +
        ")";
    }



}
