package com.bortni.controller.commands.admin;

import com.bortni.controller.commands.Command;
import com.bortni.model.entities.Administrator;
import com.bortni.model.entities.Book;
import com.bortni.service.BookService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminDeleteBookCommand implements Command {
    private BookService bookService;

    public AdminDeleteBookCommand(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int bookId = Integer.parseInt(request.getParameter("book_id"));

        Book book = bookService.getBookById(bookId);

        bookService.deleteBook(book);

        response.sendRedirect("/library" + request.getParameter("from"));
    }
}
