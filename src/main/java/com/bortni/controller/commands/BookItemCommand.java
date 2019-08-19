package com.bortni.controller.commands;

import com.bortni.controller.utils.Routes;
import com.bortni.model.entities.Book;
import com.bortni.model.entities.Language;
import com.bortni.service.BookService;
import com.bortni.service.LanguageService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BookItemCommand implements Command {
    private BookService bookService;
    private LanguageService languageService;

    public BookItemCommand(BookService bookService, LanguageService languageService) {
        this.bookService = bookService;
        this.languageService = languageService;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String locale = (String) request.getSession().getAttribute("locale");
        Language language = languageService.getLanguageByName(locale);

        int id = Integer.parseInt(request.getParameter("book_id"));

        Book book = bookService.getBookByIdAndLanguage(id, language);

        request.setAttribute("book", book);

        request.getRequestDispatcher(Routes.BOOK_ITEM).forward(request, response);

    }
}
