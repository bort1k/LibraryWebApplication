package com.bortni.controller.commands;

import com.bortni.controller.utils.Routes;
import com.bortni.controller.utils.UrlPath;
import com.bortni.model.entities.Reader;
import com.bortni.service.ReaderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignInCommand implements Command {

    private ReaderService readerService;

    public SignInCommand(ReaderService readerService) {
        this.readerService = readerService;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Reader reader = (Reader) request.getSession().getAttribute("readerSession");

        if(reader != null){
            response.sendRedirect(UrlPath.READER_PROFILE);
        }
        else {
            if(readerService.isReaderExist(email, password)){
                reader = readerService.getReaderByEmailAndPassword(email, password);
                request.getSession().setAttribute("readerSession", reader);
                response.sendRedirect("/library" + UrlPath.READER_PROFILE);
            }
            else{
                String message = "Wrong email or password";
                request.setAttribute("SignInMessage", message);
            }
        }
    }
}
