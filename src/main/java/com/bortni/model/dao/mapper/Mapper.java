package com.bortni.model.dao.mapper;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface Mapper<T> {
    T getFromResultSet(ResultSet resultSet) throws SQLException, IOException;
}
