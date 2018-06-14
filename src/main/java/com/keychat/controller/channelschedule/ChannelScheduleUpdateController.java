package com.keychat.controller.channelschedule;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.keychat.dao.base.ChannelsMemoDao;
import com.keychat.dao.base.ChannelsScheduleDao;
import com.keychat.dto.base.ChannelsMemoModel;
import com.keychat.dto.base.ChannelsScheduleModel;
import com.keychat.dto.base.UsersModel;
import com.keychat.dto.util.ResponseModel;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/channelschedule/update")
public class ChannelScheduleUpdateController extends HttpServlet {
    @Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPut(req, resp);
		req.setCharacterEncoding("UTF-8");
		String schedule_name = req.getParameter("schedule_name").trim();
		String channel_name = req.getParameter("channel_name").trim();
		String email = req.getParameter("email").trim();
		String start_datetime = req.getParameter("start_datetime").trim();
		String end_datetime = req.getParameter("end_datetime").trim();
		ChannelsScheduleModel user = new ChannelsScheduleModel(0, schedule_name, channel_name, email, null, null);
		ResponseModel res;
		HttpSession session = req.getSession();
		UsersModel loginUser = (UsersModel) session.getAttribute("loginUser");
		if (loginUser != null) {
			res = new ResponseModel(200, "success", loginUser);
			resp.setContentType("application/json");
			resp.setCharacterEncoding("UTF-8");
			resp.getWriter().write(new Gson().toJson(res));
		try {
			ChannelsScheduleDao.updateSchedule(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		req.getRequestDispatcher("#").forward(req, resp);
		} else {
			resp.sendError(500, new ResponseModel(500, "fail", "Cannot get user info").toString());
		}
	}
}