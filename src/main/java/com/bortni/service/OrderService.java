package com.bortni.service;

import com.bortni.model.dao.DaoFactory;
import com.bortni.model.dao.OrderDao;
import com.bortni.model.entities.Order;

import java.util.List;

public class OrderService {
    private DaoFactory daoFactory = DaoFactory.getInstance();

    public List<Order> getAllOrders(){
        List<Order> orders;
        try(OrderDao orderDao = daoFactory.createOrderDao()){
            orders = orderDao.getAll();
        }
        return orders;
    }

    public List<Order> getOrdersByReaderId(int readerId){
        List<Order> orders;
        try(OrderDao orderDao = daoFactory.createOrderDao()){
            orders = orderDao.getByReaderId(readerId);
        }
        return orders;
    }
}
