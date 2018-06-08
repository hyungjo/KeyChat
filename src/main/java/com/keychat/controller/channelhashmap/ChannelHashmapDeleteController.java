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
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
        String channel_name = req.getParameter("channel_name").trim();
        String hashtag = req.getParameter("hashtag").trim();
        ChannelsHashtagModel user = new ChannelsHashtagModel(0, channel_name, hashtag);
	       try {
	    	   ChannelsHashtagDao.deleteHashtag(user);
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	       req.getRequestDispatcher("#").forward(req, resp);
    }
}
