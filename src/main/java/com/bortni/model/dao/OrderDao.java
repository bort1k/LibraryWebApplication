package com.bortni.model.dao;

import com.bortni.model.entities.Order;

import java.util.List;

public interface OrderDao extends Dao<Order> {
    List<Order> getByReaderId(int readerId);
    void updateStatus(Order order, String newStatus);

    void updateStatusOrderRefuse(Order order);
}
