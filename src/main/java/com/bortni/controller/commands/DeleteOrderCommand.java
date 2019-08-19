package com.bortni.controller.commands;

import com.bortni.controller.utils.Routes;
import com.bortni.controller.utils.UrlPath;
import com.bortni.model.entities.Order;
import com.bortni.model.entities.Reader;
import com.bortni.model.entities.Status;
import com.bortni.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteOrderCommand implements Command {
    private OrderService orderService;

    public DeleteOrderCommand(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int orderId = Integer.parseInt(request.getParameter("order_id"));

        Order order = orderService.getById(orderId);
        Reader reader = (Reader) request.getSession().getAttribute("readerSession");

        if(reader == null){
            response.sendRedirect("/library" + UrlPath.SIGN_IN);
        }
        else {

            if(order.getStatus() != Status.TAKEN_BY_READER) {
                orderService.deleteOrder(order);
                response.sendRedirect("/library" + request.getParameter("from"));
            }
            else {
                response.sendRedirect("/library" + UrlPath.READER_PROFILE);
            }
        }
    }
}
