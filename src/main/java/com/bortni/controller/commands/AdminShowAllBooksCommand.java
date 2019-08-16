package com.bortni.controller.commands;

import com.bortni.controller.utils.Routes;
import com.bortni.model.entities.Book;
import com.bortni.model.entities.Order;
import com.bortni.service.BookService;
import com.bortni.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AdminShowAllBooksCommand implements Command {
    private BookService bookService;
    private OrderService orderService;

    public AdminShowAllBooksCommand(BookService bookService, OrderService orderService) {
        this.bookService = bookService;
        this.orderService = orderService;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> books = bookService.getAllAvailableBooks();
        List<Order> orders = orderService.getAllOrders();

        request.setAttribute("books", books);
        request.setAttribute("orders", orders);

        request.getRequestDispatcher(Routes.ADMIN_SHOW_ALL_BOOKS).forward(request, response);
    }
}
