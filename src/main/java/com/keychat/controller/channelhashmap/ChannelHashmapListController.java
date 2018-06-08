package com.keychat.controller.channelhashmap;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.keychat.dao.base.ChannelsHashtagDao;

@WebServlet(urlPatterns = "/channelHashmap/list")
public class ChannelHashmapListController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String channel_name = request.getParameter("channel_name").trim();
	       try {
	    	   ArrayList<String> list = ChannelsHashtagDao.findHashes(channel_name);
	    	   request.setAttribute("list", list);
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	       request.getRequestDispatcher("#").forward(request, response);
    }
}	
    

