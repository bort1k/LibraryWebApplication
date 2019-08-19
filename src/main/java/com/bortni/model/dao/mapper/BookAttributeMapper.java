package com.bortni.model.dao.mapper;

import com.bortni.model.entities.BookAttribute;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookAttributeMapper implements Mapper<BookAttribute> {
    @Override
    public BookAttribute getFromResultSet(ResultSet resultSet) throws SQLException {
        return new BookAttribute.BookAttributeBuilder()
                .setId(resultSet.getInt("attributes.id"))
                .setKeyWord(resultSet.getString("key_word"))
                .setLanguage(new LanguageMapper().getFromResultSet(resultSet))
                .build();
    }
}
