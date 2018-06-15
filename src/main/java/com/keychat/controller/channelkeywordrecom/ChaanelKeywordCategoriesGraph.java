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
	    	
	    	double per1 = Math.floor(num1/(num1+num2+num3));
	    	double per2 = Math.floor(num2/(num1+num2+num3));
	    	double per3 = Math.floor(num3/(num1+num2+num3));
	    	
	    	request.setAttribute("category1", category1);
	    	request.setAttribute("category2", category2);
	    	request.setAttribute("category3", category3);
	    	
	    	request.setAttribute("per1", per1);
	    	request.setAttribute("per2", per2);
	    	request.setAttribute("per3", per3);
		} catch (SQLException e) {
			e.printStackTrace();
		}request.getRequestDispatcher("/jsp/CategoriesGraph.jsp").forward(request, response);
	}
}
