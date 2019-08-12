package com.bortni.controller;

import com.bortni.controller.commands.*;
import com.bortni.controller.utils.UrlPath;
import com.bortni.service.BookService;
import com.bortni.service.ReaderService;

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

        commands.put("/", new HomeCommand(bookService));
        commands.put(UrlPath.HOME, new HomeCommand(bookService));
        commands.put(UrlPath.CATALOGUE, new CatalogueCommand(bookService));
        commands.put(UrlPath.SEARCH, new SearchCommand(bookService));
        commands.put(UrlPath.SIGN_IN_PAGE, new SignInPageCommand());
        commands.put(UrlPath.SIGN_UP_PAGE, new SignUpPageCommand());
        commands.put(UrlPath.SIGN_IN, new SignInCommand(readerService));
        commands.put(UrlPath.SIGN_UP, new SignUpCommand(readerService));
        commands.put(UrlPath.READER_PROFILE, new ReaderProfileCommand());
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
