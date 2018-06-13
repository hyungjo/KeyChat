package com.keychat.controller.channelhashmap;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.keychat.dao.base.ChannelsHashtagDao;
import com.keychat.dto.base.ChannelsHashtagModel;

@WebServlet(urlPatterns = "/channelHashmap/delete")
public class ChannelHashmapDeleteController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	String channel_name = request.getParameter("channel_name").trim();
        String hashtag = request.getParameter("hashtag").trim();
        ChannelsHashtagModel user = new ChannelsHashtagModel(0, channel_name, hashtag);
        try {
        	ChannelsHashtagDao.deleteHashtag(user);
        } catch (SQLException e) {
        	e.printStackTrace();
        } request.getRequestDispatcher("#").forward(request, response);
    }
}
