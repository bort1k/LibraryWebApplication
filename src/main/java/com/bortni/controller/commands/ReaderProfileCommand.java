package com.bortni.controller.commands;

import com.bortni.controller.utils.Routes;
import com.bortni.model.entities.Book;
import com.bortni.model.entities.Order;
import com.bortni.model.entities.Reader;
import com.bortni.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ReaderProfileCommand implements Command{

    private OrderService orderService;

    public ReaderProfileCommand(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Reader reader = (Reader)request.getSession().getAttribute("readerSession");

        List<Order> orders = orderService.getOrdersByReaderId(reader.getId());
        request.setAttribute("orders", orders);

        request.getRequestDispatcher(Routes.READER_PROFILE).forward(request, response);
    }
}
