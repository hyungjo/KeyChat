package com.keychat.controller.channel;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.keychat.dao.base.ChannelsHashtagDao;

@WebServlet("/channel/hotHashtag")
public class ChannelHotHashtag extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		ArrayList<String> list = ChannelsHashtagDao.getHotHashtag();
		request.setAttribute("list", list);
		System.out.println(list);
		request.getRequestDispatcher("hashtagLink").forward(request, response);
	}
}
