package com.bortni.model.dao.implementation;

import com.bortni.model.dao.*;
import com.bortni.model.database.ConnectionPoolHolder;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DaoFactoryImpl extends DaoFactory {

    private DataSource dataSource = ConnectionPoolHolder.getDataSource();

    @Override
    public BookDao createBookDao() {
        return new BookDaoImpl(getConnection());
    }

    @Override
    public AuthorDao createAuthorDao() {
        return new AuthorDaoImpl(getConnection());
    }

    @Override
    public BookAttributeDao createBookAttributeDao() {
        return new BookAttributeDaoImpl(getConnection());
    }

    @Override
    public ReaderDao createReaderDao() {
        return new ReaderDaoImpl(getConnection());
    }

    @Override
    public OrderDao createOrderDao() {
        return new OrderDaoImpl(getConnection());
    }

    private Connection getConnection(){
        try{
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
