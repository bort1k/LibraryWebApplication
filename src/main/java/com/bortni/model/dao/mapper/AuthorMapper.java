package com.bortni.model.dao.mapper;

import com.bortni.model.entities.Author;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AuthorMapper implements Mapper<Author> {

    @Override
    public Author getFromResultSet(ResultSet resultSet) throws SQLException {
        return new Author.AuthorBuilder()
                .setId(resultSet.getInt("authors.id"))
                .setFirstName(resultSet.getString("authors.first_name"))
                .setLastName(resultSet.getString("authors.last_name"))
                .setLanguage(new LanguageMapper().getFromResultSet(resultSet))
                .build();
    }
}
