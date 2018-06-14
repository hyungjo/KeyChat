package com.keychat.controller.channelschedule;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.keychat.dao.base.ChannelsScheduleDao;
import com.keychat.dto.base.UsersModel;
import com.keychat.dto.util.ResponseModel;

@WebServlet(urlPatterns = "/channelschedule/delete")
public class ChannelScheduleDeleteController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doDelete(req, resp);
		String channel_name = req.getParameter("channel_name").trim();
		String schedule_name = req.getParameter("schedule_name").trim();
		ResponseModel res;
		HttpSession session = req.getSession();
		UsersModel loginUser = (UsersModel) session.getAttribute("loginUser");
		if (loginUser != null) {
			res = new ResponseModel(200, "success", loginUser);
			resp.setContentType("application/json");
			resp.setCharacterEncoding("UTF-8");
			resp.getWriter().write(new Gson().toJson(res));
			try {
				ChannelsScheduleDao.dropChannelsSchedule(channel_name, schedule_name);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			req.getRequestDispatcher("#").forward(req, resp);
		} else {
			resp.sendError(500, new ResponseModel(500, "fail", "Cannot get user info").toString());
		}
	}
}
