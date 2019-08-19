package com.bortni.model.dao.implementation;

import com.bortni.model.dao.LanguageDao;
import com.bortni.model.dao.mapper.LanguageMapper;
import com.bortni.model.dao.sql_queries.LanguageSqlQueries;
import com.bortni.model.entities.Language;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class LanguageDaoImpl implements LanguageDao {
    private Connection connection;
    private LanguageMapper mapper = new LanguageMapper();

    public LanguageDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Language getLanguageByLanguageName(String languageName) {
        String sql = LanguageSqlQueries.SELECT_LANGUAGE_BY_NAME;
        final ResultSet resultSet;
        Language language = new Language.LanguageBuilder().build();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, languageName);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
                language = mapper.getFromResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }

        return language;
    }

    @Override
    public void create(Language object) {

    }

    @Override
    public Language getById(int id) {
        return null;
    }

    @Override
    public List<Language> getAll() {
        return null;
    }

    @Override
    public void update(Language object) {

    }

    @Override
    public void delete(Language object) {

    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}
