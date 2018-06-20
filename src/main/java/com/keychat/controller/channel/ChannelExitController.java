package com.keychat.controller.channel;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.keychat.controller.util.JsonUtil;
import com.keychat.dao.base.ChannelsDao;
import com.keychat.dao.base.ChannelsJoinDao;
import com.keychat.dto.base.ChannelsModel;
import com.keychat.dto.base.UsersModel;
import com.keychat.dto.util.ResponseModel;

@WebServlet(urlPatterns = "/channelExit")
public class ChannelExitController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
        UsersModel loginUser = (UsersModel)session.getAttribute("loginUser");
		String email = loginUser.getEmail();
		String channel_name = request.getParameter("channel_name");
		String leader = ChannelsJoinDao.getLeader(channel_name);
		try {
			if(email.equals(leader)) {
				ChannelsModel channelsModel = new ChannelsModel(channel_name, leader, null, 0, 0, null, null);
				boolean isDeleteChannel = ChannelsDao.dropChannel(channelsModel);
				if(isDeleteChannel) {
					request.getRequestDispatcher("/jsp/channels.jsp").forward(request, response);
				}
			}else {
				boolean res = ChannelsJoinDao.dropChannelsJoin(email, channel_name);
				if (res) {
					request.getRequestDispatcher("/jsp/channels.jsp").forward(request, response);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
