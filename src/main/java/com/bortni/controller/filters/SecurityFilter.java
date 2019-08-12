package com.bortni.controller.filters;

import com.bortni.controller.security.Role;
import com.bortni.controller.security.SecurityUtils;
import com.bortni.controller.utils.UrlPath;
import com.bortni.model.entities.Administrator;
import com.bortni.model.entities.Reader;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SecurityFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String path = request.getPathInfo();
        Reader signedInReader = (Reader) request.getSession().getAttribute("readerSession");
        Administrator administrator = (Administrator) request.getSession().getAttribute("adminSession");

        if(UrlPath.SIGN_IN.equals(path) && signedInReader != null){
            response.sendRedirect("/library" + UrlPath.READER_PROFILE);
            return;
        }
        if (UrlPath.SIGN_IN_ADMIN.equals(path) && signedInReader != null){
            response.sendRedirect("/library" + UrlPath.ADMIN_SHOW_ALL_BOOKS);
            return;
        }

        if(SecurityUtils.isSecurityPage(request)){
            if((signedInReader != null && SecurityUtils.hasPermission(request, Role.READER)) ||
                    (administrator != null && SecurityUtils.hasPermission(request, Role.ADMINISTRATOR))){
                filterChain.doFilter(request, response);
            }
            else{
                response.sendRedirect("/library" + UrlPath.SIGN_IN);
            }
        }
        else {
            filterChain.doFilter(request, response);
        }



    }

    private void userFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain,
                            Object signedInUser, String path, String page, String signIn, Role role) throws IOException, ServletException {

        if(signIn.equals(path) && signedInUser != null){
            response.sendRedirect("/library" + page);
            return;
        }

        if(SecurityUtils.isSecurityPage(request)){
            if(signedInUser != null && SecurityUtils.hasPermission(request, role)){
                filterChain.doFilter(request, response);
            }
            else{
                response.sendRedirect("/library" + signIn);
            }
        }
        else {
            filterChain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
