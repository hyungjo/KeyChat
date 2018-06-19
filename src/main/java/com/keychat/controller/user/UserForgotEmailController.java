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

@WebServlet(urlPatterns = "/user/forgotEmail")
public class UserForgotEmailController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	String nickname = request.getParameter("nickname");
    	String phone = request.getParameter("phone");
    	try {
			ArrayList<String> res = UsersDao.findEmail(nickname, phone);
			int size = res.size();
			if(size >= 1) {
				String res1 = res.get(0);
				request.setAttribute("res", res1);
			}else {
				request.setAttribute("res", "존재하지 않는 회원입니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}request.getRequestDispatcher("/jsp/afterEmailFind.jsp").forward(request, response);
    }
}
