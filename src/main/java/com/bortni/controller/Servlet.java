package com.bortni.controller;

import com.bortni.controller.commands.*;
import com.bortni.controller.commands.admin.*;
import com.bortni.controller.utils.UrlPath;
import com.bortni.model.dao.sql_queries.AuthorSqlQueries;
import com.bortni.model.entities.Author;
import com.bortni.service.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Servlet extends HttpServlet {
    private Map<String, Command> commands;

    @Override
    public void init() {
        commands = new HashMap<>();

        BookService bookService = new BookService();
        ReaderService readerService = new ReaderService();
        OrderService orderService = new OrderService();
        AdministratorService administratorService = new AdministratorService();
        LanguageService languageService = new LanguageService();
        AuthorService authorService = new AuthorService();
        BookAttributeService bookAttributeService = new BookAttributeService();

        commands.put("/", new HomeCommand(bookService, languageService));
        commands.put(UrlPath.HOME, new HomeCommand(bookService, languageService));
        commands.put(UrlPath.CATALOGUE, new CatalogueCommand(bookService, languageService));
        commands.put(UrlPath.SEARCH, new SearchCommand(bookService));
        commands.put(UrlPath.SIGN_IN_PAGE, new SignInPageCommand());
        commands.put(UrlPath.SIGN_UP_PAGE, new SignUpPageCommand());
        commands.put(UrlPath.SIGN_IN, new SignInCommand(readerService));
        commands.put(UrlPath.SIGN_UP, new SignUpCommand(readerService));
        commands.put(UrlPath.READER_PROFILE, new ReaderProfileCommand(orderService));
        commands.put(UrlPath.LOG_OUT, new LogOutCommand());
        commands.put(UrlPath.ADMIN, new AdminCommand(administratorService));
        commands.put(UrlPath.ADMIN_SHOW_ALL_BOOKS, new AdminShowAllBooksCommand(bookService, orderService));
        commands.put(UrlPath.ERROR_403, new Error403Command());
        commands.put(UrlPath.BOOK_ITEM, new BookItemCommand(bookService, languageService));
        commands.put(UrlPath.ORDER_BOOK, new OrderBookCommand(bookService, orderService));
        commands.put(UrlPath.DELETE_ORDER, new DeleteOrderCommand(orderService));
        commands.put(UrlPath.ADMIN_REFUSE_ORDER, new AdminRefuseOrderCommand(orderService));
        commands.put(UrlPath.ADMIN_CONFIRM_ORDER, new AdminConfirmOrderCommand(orderService));
        commands.put(UrlPath.ADMIN_RETURN_ORDER, new AdminReturnCommand(orderService));
        commands.put(UrlPath.ADMIN_DELETE_BOOK, new AdminDeleteBookCommand(bookService));
        commands.put(UrlPath.ADMIN_ADD_BOOK, new AdminAddBookCommand(bookService, languageService, authorService, bookAttributeService));
        commands.put(UrlPath.ADMIN_ADD_BOOK_PAGE, new AdminAddBookPageCommand());
        commands.put(UrlPath.ABOUT, new AboutCommand());

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doProcess(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doProcess(req, resp);
    }

    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String uriPath = request.getPathInfo();
        Command command = commands.get(uriPath);
        if(command == null){
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
        else {
            command.execute(request, response);
        }
    }
}
