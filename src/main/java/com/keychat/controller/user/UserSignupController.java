package com.keychat.controller.user;

import com.google.gson.Gson;
import com.keychat.controller.util.JsonUtil;
import com.keychat.dao.base.ChannelsChatHistoryDao;
import com.keychat.dao.base.ChannelsScheduleDao;
import com.keychat.dao.base.UsersDao;
import com.keychat.dto.base.ChannelsChatHistoryModel;
import com.keychat.dto.base.UsersModel;
import com.keychat.dto.util.ResponseModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;

@WebServlet(urlPatterns = "/jsp/user/signup")
public class UserSignupController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String email = request.getParameter("email").trim();
		String password = request.getParameter("password").trim();
		String nickname = request.getParameter("nickname").trim();
		String job = request.getParameter("job").trim();
		String phone = request.getParameter("phone").trim();
		UsersModel usersModel = new UsersModel(email, password, nickname, job, phone);
		ResponseModel res;
		HttpSession session = request.getSession();
		UsersModel loginUser = (UsersModel) session.getAttribute("loginUser");
		/*System.out.println(11111);
		if (loginUser != null) {
			res = new ResponseModel(200, "success", loginUser);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(new Gson().toJson(res));*/
			try {
				UsersDao.createUser(usersModel);
			} catch (Exception e) {
				e.printStackTrace();
			}
			request.getRequestDispatcher("#").forward(request, response);
		} /*else {
			response.sendError(500, new ResponseModel(500, "fail", "Cannot get user info").toString());
		}
	}*/

	/*
	 * ResponseModel res; UsersModel usersModel =
	 * JsonUtil.getModelFromJsonRequest(request, UsersModel.class);
	 * System.out.println("000000"); boolean isExist =
	 * UsersDao.isExistUser(usersModel) && UsersDao.isExistNickname(usersModel);
	 * 
	 * if(!isExist && UsersDao.createUser(usersModel)) res = new ResponseModel(200,
	 * "success", usersModel); else res = new ResponseModel(500, "fail",
	 * "Cannot create user");
	 * 
	 * response.setContentType("application/json");
	 * response.setCharacterEncoding("UTF-8"); response.getWriter().write(new
	 * Gson().toJson(res));
	 */
}
