package com.keychat.controller.user;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.keychat.dao.base.UsersDao;

@WebServlet(urlPatterns = "/user/forgotPassword")
public class UserForgotPasswordController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	String email = request.getParameter("email");
    	String phone = request.getParameter("phone");
    	System.out.println("0000000000");
    	try {
			String res = UsersDao.findPassword(email, phone).toString();
			if (res != null) {
				request.getRequestDispatcher("/jsp/rePassword.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
}
