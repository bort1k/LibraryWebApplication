package com.bortni.controller.commands;

import com.bortni.controller.utils.Routes;
import com.bortni.controller.utils.UrlPath;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignInPageCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(Routes.SIGN_IN).forward(request, response);
    }
}
