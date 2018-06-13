package com.keychat.controller.channel;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.keychat.dao.base.ChannelsDao;
import com.keychat.dao.base.ChannelsJoinJoinChannelsAnonym;
import com.keychat.dao.base.UsersJoinChannelsJoin;
import com.keychat.dto.base.ChannelsJoinJoinChannelsAnonymModel;
import com.keychat.dto.base.UsersJoinChannelsJoinModel;

@WebServlet(urlPatterns = "/channel/attendants")
public class ChannelAttendantsController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	String name = request.getParameter("name");
    	String result;
		try {
			result = ChannelsDao.findLimitAnonym(name);
			String channel_name = name.trim();
		    ArrayList<String> list;
		    System.out.println(result);
			if (result.equals("T")) { // 익명 방이 맞으면
		        String anonym_name = request.getParameter("anonym_name").trim();
		        ChannelsJoinJoinChannelsAnonymModel user = new ChannelsJoinJoinChannelsAnonymModel(channel_name, anonym_name);
		        try {
					list = ChannelsJoinJoinChannelsAnonym.anonymCheck(user);
					request.setAttribute("list", list);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		    if (result.equals("F")) { // 익명 방이 아니면
		    	String email = request.getParameter("email");
		        String nickname = request.getParameter("nickname");
		        UsersJoinChannelsJoinModel user = new UsersJoinChannelsJoinModel(email, channel_name, nickname);
		    	try {
					list = UsersJoinChannelsJoin.anonymCheck2(user);
					request.setAttribute("list", list);
				} catch (SQLException e) {
					e.printStackTrace();
				}
		    }request.getRequestDispatcher("#").forward(request, response);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
    }	
}
