package com.keychat.controller.channelmemo;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.keychat.dao.base.ChannelsMemoDao;
import com.keychat.dto.base.ChannelsMemoModel;
import com.keychat.dto.base.UsersModel;
import com.keychat.dto.util.ResponseModel;

@WebServlet(urlPatterns = "/channelMemo/list")
public class ChannelMemoListController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		 HttpSession session = request.getSession();
	        UsersModel loginUser = (UsersModel)session.getAttribute("loginUser");
	      String email = loginUser.getEmail();
		ChannelsMemoModel user = new ChannelsMemoModel(0, email, null);
		ResponseModel res;
		if (loginUser != null) {
			res = new ResponseModel(200, "success", loginUser);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(new Gson().toJson(res));
			try {
				ArrayList<String> list = ChannelsMemoDao.selectMemo(user);
				request.setAttribute("list", list);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.getRequestDispatcher("#").forward(request, response);
		} else {
			response.sendError(500, new ResponseModel(500, "fail", "Cannot get user info").toString());
		}
	}
}