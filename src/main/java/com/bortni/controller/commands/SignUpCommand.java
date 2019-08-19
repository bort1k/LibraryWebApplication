package com.bortni.controller.commands;

import com.bortni.controller.utils.Routes;
import com.bortni.controller.utils.UrlPath;
import com.bortni.model.entities.Reader;
import com.bortni.service.ReaderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignUpCommand implements Command {

    private ReaderService readerService;

    public SignUpCommand(ReaderService readerService) {
        this.readerService = readerService;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Reader reader = (Reader) request.getSession().getAttribute("readerSession");


        String firstName = request.getParameter("first_name");
        String lastName = request.getParameter("last_name");
        String telephoneNumber = request.getParameter("telephone_number");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if(reader != null){
            response.sendRedirect("/library" + UrlPath.READER_PROFILE);
        }
        else {
            if (readerService.isEmailExist(email)) {
                String message = "Email is already exist!";
                request.setAttribute("SignUpFailedMessage", message);
                request.getRequestDispatcher(Routes.SIGN_UP).forward(request, response);
            } else {
                reader = new Reader.ReaderBuilder()
                        .setFirstName(firstName)
                        .setLastName(lastName)
                        .setTelephoneNumber(telephoneNumber)
                        .setEmail(email)
                        .setPassword(password)
                        .build();
                readerService.create(reader);
                request.getRequestDispatcher(Routes.SUCCESSFUL_REGISTRATION).forward(request, response);
            }
        }
    }
}
