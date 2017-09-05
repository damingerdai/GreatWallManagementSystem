package org.aming.gwms.servlet;

import org.aming.gwms.domain.User;
import org.aming.gwms.service.LoginService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author daming
 * @version 2017/6/27.
 * 登陆Servlet
 */
public class LoginServlet extends HttpServlet {

    private LoginService loginService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String methodName = request.getParameter("method");
		try {
			Method method = getClass().getDeclaredMethod(methodName,
					HttpServletRequest.class, HttpServletResponse.class);
			method.setAccessible(true);
			method.invoke(this, request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    private void verify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String empid = request.getParameter("empid");
		String password = request.getParameter("password");
		User user = new User(empid, password);
    }
}
