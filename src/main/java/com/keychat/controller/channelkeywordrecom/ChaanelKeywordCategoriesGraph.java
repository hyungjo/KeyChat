package com.keychat.controller.channelkeywordrecom;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.keychat.dao.base.ChannelsKeywordRecomDao;

@WebServlet("/categoriesgraph")
public class ChaanelKeywordCategoriesGraph extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
    	String channel_name = request.getParameter("channel_name").trim();
    	try {
    		ArrayList<String[]> categories = ChannelsKeywordRecomDao.findCategory(channel_name);
	    	String[] categories1 = categories.get(0);
	    	String category1 = categories1[0];
	    	int num1 = Integer.valueOf(categories1[1]);
	    	
	    	String[] categories2 = categories.get(1);
	    	String category2 = categories2[0];
	    	int num2 = Integer.valueOf(categories2[1]);
	    	
	    	String[] categories3 = categories.get(2);
	    	String category3 = categories3[0];
	    	int num3 = Integer.valueOf(categories3[1]);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
