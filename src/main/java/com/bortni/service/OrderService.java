package com.bortni.service;

import com.bortni.model.dao.Dao;
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

    public void createOrder(Order order){
        try(OrderDao orderDao = daoFactory.createOrderDao()){
            orderDao.create(order);
        }
    }

    public void deleteOrder(Order order){
        try(OrderDao orderDao = daoFactory.createOrderDao()){
            orderDao.delete(order);
        }
    }

    public Order getById(int id){
        try(OrderDao orderDao = daoFactory.createOrderDao()){
            return orderDao.getById(id);
        }
    }

    public void updateStatus(Order order, String newStatus){
        try(OrderDao orderDao = daoFactory.createOrderDao()){
            orderDao.updateStatus(order, newStatus);
        }
    }

    public void updateStatusOrderRefuse(Order order) {
        try(OrderDao orderDao = daoFactory.createOrderDao()){
            orderDao.updateStatusOrderRefuse(order);
        }
    }
}
