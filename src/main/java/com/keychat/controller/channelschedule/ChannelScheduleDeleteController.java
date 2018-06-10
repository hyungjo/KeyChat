package com.keychat.controller.channelschedule;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.keychat.dao.base.ChannelsMemoDao;
import com.keychat.dao.base.ChannelsScheduleDao;
import com.keychat.dto.base.ChannelsHashtagModel;
import com.keychat.dto.base.ChannelsScheduleModel;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/channelschedule/delete")
public class ChannelScheduleDeleteController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doDelete(req, resp);
		String channel_name = req.getParameter("channel_name").trim();
		String schedule_name = req.getParameter("schedule_name").trim();
		try {
			ChannelsScheduleDao.dropChannelsSchedule(channel_name, schedule_name);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		req.getRequestDispatcher("#").forward(req, resp);
	}
}