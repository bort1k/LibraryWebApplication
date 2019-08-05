package com.bortni.controller.commands;

import com.bortni.controller.utils.Routes;
import com.bortni.model.entities.Book;
import com.bortni.service.BookService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CatalogueCommand implements Command {
    private BookService bookService;

    public CatalogueCommand(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> books = bookService.getAllBooks();
        request.setAttribute("allBooks", books);
        request.getRequestDispatcher(Routes.CATALOGUE).forward(request, response);
    }
}
