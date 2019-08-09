package com.bortni.controller.commands;

import com.bortni.controller.utils.Routes;
import com.bortni.model.entities.Book;
import com.bortni.service.BookService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SearchCommand implements Command {
    private BookService bookService;

    public SearchCommand(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchParam = request.getParameter("search_param");
        request.setAttribute("search_param", searchParam);
        List<Book> books = bookService.getBooksSearchByParam(searchParam);
        request.setAttribute("search_size", books.size());
        request.setAttribute("booksSearchByParam", books);
        request.getRequestDispatcher(Routes.SEARCH).forward(request, response);
    }
}
