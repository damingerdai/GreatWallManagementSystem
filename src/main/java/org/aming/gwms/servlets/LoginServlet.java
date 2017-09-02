package org.aming.gwms.servlets;

import org.aming.gwms.service.LoginService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author daming
 * @version 2017/6/27.
 * 登陆Servlet
 */
public class LoginServlet extends HttpServlet {

    private LoginService loginService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    private void verify(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
