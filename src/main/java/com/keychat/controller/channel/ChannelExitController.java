package com.keychat.controller.channel;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.keychat.dao.base.ChannelsJoinDao;
import com.keychat.dto.base.UsersModel;

@WebServlet(urlPatterns = "/channelExit")
public class ChannelExitController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
        UsersModel loginUser = (UsersModel)session.getAttribute("loginUser");
		String email = loginUser.getEmail();
		String channel_name = request.getParameter("channel_name");
		//TODO 방장 나가면 채널 삭제

		try {
			boolean res = ChannelsJoinDao.dropChannelsJoin(email, channel_name);
			if (res) {
				request.getRequestDispatcher("/jsp/channels.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
