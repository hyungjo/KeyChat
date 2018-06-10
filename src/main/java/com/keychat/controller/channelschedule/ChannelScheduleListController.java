package com.keychat.controller.channelschedule;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.keychat.dao.base.ChannelsMemoDao;
import com.keychat.dao.base.ChannelsScheduleDao;
import com.keychat.dto.base.ChannelsMemoModel;
import com.keychat.dto.base.ChannelsScheduleModel;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/channelschedule/list")
public class ChannelScheduleListController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String schedule_name = request.getParameter("schedule_name").trim();
		ChannelsScheduleModel user = new ChannelsScheduleModel(0, schedule_name, null, null, null, null);
		try {
			ArrayList<String> list = ChannelsScheduleDao.selectSchedule(user);
			request.setAttribute("list", list);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("#").forward(request, response);
	}
}
