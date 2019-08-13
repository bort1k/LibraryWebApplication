package com.bortni.model.dao.implementation;

import com.bortni.model.dao.OrderDao;
import com.bortni.model.dao.mapper.OrderMapper;
import com.bortni.model.dao.sql_queries.OrderSqlQueries;
import com.bortni.model.entities.Order;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl implements OrderDao {

    private Connection connection;
    private OrderMapper mapper = new OrderMapper();

    public OrderDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Order> getByReaderId(int readerId) {
        List<Order> orders = new ArrayList<>();
        final ResultSet resultSet;
        String sql = OrderSqlQueries.SELECT_BY_READER_ID;

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, readerId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                orders.add(mapper.getFromResultSet(resultSet));
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        return orders;
    }

    @Override
    public void create(Order object) {

    }

    @Override
    public Order getById(int id) {
        return null;
    }

    @Override
    public List<Order> getAll() {
        List<Order> orders = new ArrayList<>();
        String sql = OrderSqlQueries.SELECT_ALL;
        final ResultSet resultSet;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                orders.add(mapper.getFromResultSet(resultSet));
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        return orders;
    }

    @Override
    public void update(Order object) {

    }

    @Override
    public void delete(Order object) {

    }

    @Override
    public void close() {

    }
}
