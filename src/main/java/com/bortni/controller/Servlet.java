package com.bortni.controller;

import com.bortni.controller.commands.CatalogueCommand;
import com.bortni.controller.commands.Command;
import com.bortni.controller.commands.HomeCommand;
import com.bortni.controller.utils.UrlPath;
import com.bortni.service.BookService;

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

        commands.put("/", new HomeCommand(bookService));
        commands.put(UrlPath.HOME, new HomeCommand(bookService));
        commands.put(UrlPath.CATALOGUE, new CatalogueCommand(bookService));
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
