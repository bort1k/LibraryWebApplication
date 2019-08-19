package com.bortni.controller.commands.admin;

import com.bortni.controller.commands.Command;
import com.bortni.controller.utils.UrlPath;
import com.bortni.model.entities.Administrator;
import com.bortni.model.entities.Order;
import com.bortni.model.entities.Status;
import com.bortni.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminConfirmOrderCommand implements Command {
    private OrderService orderService;

    public AdminConfirmOrderCommand(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int orderId = Integer.parseInt(request.getParameter("order_id"));

        Order order = orderService.getById(orderId);
        String status = String.valueOf(order.getStatus());


        orderService.updateStatus(order, changeStatus(status));

        response.sendRedirect("/library" + request.getParameter("from"));
    }

    private String changeStatus(String status) {
        String newStatus = null;
        switch (status) {
            case "UNCONFIRMED":
                newStatus = "CONFIRMED";
                break;
            case "CONFIRMED":
                newStatus = "TAKEN_BY_READER";
                break;
            case "REFUSED":
                newStatus = "CONFIRMED";
        }
        return newStatus;
    }

}
