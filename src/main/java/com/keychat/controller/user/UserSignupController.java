package com.keychat.controller.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.keychat.dao.base.UsersDao;
import com.keychat.dto.base.UsersModel;
import com.keychat.dto.util.ResponseModel;

@WebServlet(urlPatterns = "/user/signup")
public class UserSignupController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String reqCommand = request.getParameter("command");
		String email = request.getParameter("email").trim();
		System.out.println(reqCommand);
		if(reqCommand == null) {
			String password = request.getParameter("password").trim();
			String nickname = request.getParameter("nickname").trim();
			String job = request.getParameter("job").trim();
			String phone = request.getParameter("phone").trim();
			UsersModel usersModel = new UsersModel(email, password, nickname, job, phone);
			try {
				UsersDao.createUser(usersModel);
			} catch (Exception e) {
				e.printStackTrace();
			}
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}else if(reqCommand.equals("emailCheck")) {
			String checkResult = UsersDao.isExistUser(email);
			if(checkResult != null) {				
				//이미 존재하는 email 따라서 재 입력 유도
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("*이미 존재하는 이메일입니다*");
				return;
			}
		}
	}
}
