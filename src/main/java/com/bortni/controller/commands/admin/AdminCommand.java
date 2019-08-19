package com.bortni.controller.commands.admin;

import com.bortni.controller.commands.Command;
import com.bortni.controller.utils.Routes;
import com.bortni.controller.utils.UrlPath;
import com.bortni.model.entities.Administrator;
import com.bortni.service.AdministratorService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminCommand implements Command {

    private AdministratorService administratorService;

    public AdminCommand(AdministratorService administratorService) {
        this.administratorService = administratorService;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        Administrator administrator = (Administrator) request.getAttribute("adminSession");

        if(administrator != null){
            response.sendRedirect("/library" + UrlPath.ADMIN_SHOW_ALL_BOOKS);
        }
        else {
            if(administratorService.isExist(login, password)){
                administrator = administratorService.getAdministratorByLoginAndPassword(login, password);
                request.getSession().setAttribute("adminSession", administrator);
                response.sendRedirect("/library" + UrlPath.ADMIN_SHOW_ALL_BOOKS);
            }
            else{
                String message = "Wrong email or password";
                request.setAttribute("SignInFailedMessage", message);
                request.getRequestDispatcher(Routes.ADMIN_SIGN_IN).forward(request, response);
            }
        }
    }
}
