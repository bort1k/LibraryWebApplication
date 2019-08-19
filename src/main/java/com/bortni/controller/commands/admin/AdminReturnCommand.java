package com.bortni.controller.commands.admin;

import com.bortni.controller.commands.Command;
import com.bortni.controller.utils.UrlPath;
import com.bortni.model.entities.Administrator;
import com.bortni.model.entities.Order;
import com.bortni.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminReturnCommand implements Command {
    private OrderService orderService;

    public AdminReturnCommand(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int orderId = Integer.parseInt(request.getParameter("order_id"));

        Order order = orderService.getById(orderId);

        orderService.deleteOrder(order);

        response.sendRedirect("/library" + request.getParameter("from"));
    }
}
