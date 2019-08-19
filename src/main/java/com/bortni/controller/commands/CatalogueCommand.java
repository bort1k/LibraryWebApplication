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
import java.util.List;

public class CatalogueCommand implements Command {
    private BookService bookService;
    private LanguageService languageService;

    public CatalogueCommand(BookService bookService, LanguageService languageService) {
        this.bookService = bookService;
        this.languageService = languageService;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String locale = (String) request.getSession().getAttribute("locale");
        Language language = languageService.getLanguageByName(locale);
        List<Book> books = bookService.getAllAvailableBooksByLanguage(language);
        request.setAttribute("allBooks", books);
        request.getRequestDispatcher(Routes.CATALOGUE).forward(request, response);
    }
}
