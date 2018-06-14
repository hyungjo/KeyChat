package com.keychat.controller.user;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.keychat.dao.base.UsersDao;

@WebServlet(urlPatterns = "/user/updatePassword")
public class UpdatePassword extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	String email = request.getParameter("email");
    	String password = request.getParameter("password");
    	String password2 = request.getParameter("password2");
    	System.out.println(email);
    	System.out.println(password);
    	System.out.println(password2);
    	if (password.equals(password2)) {
	    	try {
				boolean res = UsersDao.rePassword(email, password);
				if (res) {
					request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
    	}
    }
}