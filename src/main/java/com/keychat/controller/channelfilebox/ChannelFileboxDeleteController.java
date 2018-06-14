package com.keychat.controller.channelfilebox;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.keychat.dao.base.ChannelsFileboxDao;
import com.keychat.dto.base.UsersModel;
import com.keychat.dto.util.ResponseModel;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/channelfilebox/delete")
public class ChannelFileboxDeleteController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String file_path = request.getParameter("file_path").trim();
		String channel_name = request.getParameter("channel_name").trim();
		ResponseModel res;
		HttpSession session = request.getSession();
		UsersModel loginUser = (UsersModel) session.getAttribute("loginUser");
		if (loginUser != null) {
			res = new ResponseModel(200, "success", loginUser);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(new Gson().toJson(res));
			try {
				ChannelsFileboxDao.dropFile(file_path, channel_name);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.getRequestDispatcher("#").forward(request, response);
		} else {
			response.sendError(500, new ResponseModel(500, "fail", "Cannot get user info").toString());
		}
	}
}