package com.keychat.controller.channelschedule;

import java.io.IOException;
import java.security.Timestamp;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.keychat.dao.base.ChannelsScheduleDao;
import com.keychat.dto.base.ChannelsScheduleModel;
import com.keychat.dto.base.UsersModel;
import com.keychat.dto.util.ResponseModel;

@WebServlet(urlPatterns = "/channelschedule/create")
public class ChannelScheduleCreateController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String schedule_name = request.getParameter("schedule_name").trim();
		String channel_name = request.getParameter("channel_name").trim();
		String email = request.getParameter("email").trim();
		String start_datetime = request.getParameter("start_datetime").toString();
		String end_datetime = request.getParameter("end_datetime").toString();
		ChannelsScheduleModel channelsScheduleModel = new ChannelsScheduleModel(0, schedule_name, channel_name, email,
				null, null);
		ResponseModel res;
		HttpSession session = request.getSession();
		UsersModel loginUser = (UsersModel) session.getAttribute("loginUser");
		if (loginUser != null) {
			res = new ResponseModel(200, "success", loginUser);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(new Gson().toJson(res));
			try {
				ChannelsScheduleDao.insertSchedule(channelsScheduleModel);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.getRequestDispatcher("#").forward(request, response);
		} else {
			response.sendError(500, new ResponseModel(500, "fail", "Cannot get user info").toString());
		}
	}
}
