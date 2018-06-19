package com.keychat.controller.user;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

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
    	try {
			ArrayList<String> res = UsersDao.findPassword(email, phone);
			int size = res.size();
			if (size >= 1) {
				request.setAttribute("email", email);
				request.getRequestDispatcher("/jsp/rePassword.jsp").forward(request, response);
			}else {
				request.setAttribute("res", "존재하지 않는 회원입니다.");
				request.getRequestDispatcher("/jsp/afterEmailFind.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
}
