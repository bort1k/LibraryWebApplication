package com.bortni.model.dao.mapper;

import com.bortni.model.entities.Order;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderMapper implements Mapper<Order>{
    @Override
    public Order getFromResultSet(ResultSet resultSet) throws SQLException, IOException {
        return new Order.OrderBuilder()
                .setId(resultSet.getInt("orders.id"))
                .setBook(new BookMapper().getFromResultSet(resultSet))
                .setReader(new ReaderMapper().getFromResultSet(resultSet))
                .setTime(resultSet.getTime("orders.time"))
                .build();
    }
}
