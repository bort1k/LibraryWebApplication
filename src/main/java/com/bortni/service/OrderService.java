package com.bortni.service;

import com.bortni.model.dao.DaoFactory;
import com.bortni.model.dao.OrderDao;
import com.bortni.model.entities.Order;

import java.util.List;

public class OrderService {
    private DaoFactory daoFactory = DaoFactory.getInstance();

    public List<Order> getAllOrders(){
        try(OrderDao orderDao = daoFactory.createOrderDao()){
            return orderDao.getAll();
        }
    }

    public List<Order> getOrdersByReaderId(int readerId){
        try(OrderDao orderDao = daoFactory.createOrderDao()){
            return orderDao.getByReaderId(readerId);
        }
    }
}
