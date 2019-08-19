package com.bortni.controller.commands;

import com.bortni.controller.utils.Routes;
import com.bortni.controller.utils.UrlPath;
import com.bortni.model.entities.Book;
import com.bortni.model.entities.Order;
import com.bortni.model.entities.Reader;
import com.bortni.service.BookService;
import com.bortni.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OrderBookCommand implements Command {
    private BookService bookService;
    private OrderService orderService;

    public OrderBookCommand(BookService bookService, OrderService orderService) {
        this.bookService = bookService;
        this.orderService = orderService;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int book_id = Integer.parseInt(request.getParameter("book_id"));

        Book book = bookService.getBookById(book_id);
        Reader reader = (Reader) request.getSession().getAttribute("readerSession");

        if(reader == null){
            response.sendRedirect("/library" + UrlPath.SIGN_IN_PAGE);
        }
        else {
            Order order = new Order.OrderBuilder()
                    .setReader(reader)
                    .setBook(book)
                    .build();
            orderService.createOrder(order);

            response.sendRedirect("/library" + request.getParameter("from"));
        }
    }
}
