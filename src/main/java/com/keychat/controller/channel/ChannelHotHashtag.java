package com.keychat.controller.channel;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.keychat.dao.base.ChannelsHashtagDao;
import com.keychat.dto.base.UsersModel;
import com.keychat.dto.util.ResponseModel;

@WebServlet("/channel/hotHashtag")
public class ChannelHotHashtag extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		ResponseModel res;
		ArrayList<String> hotHashtaglist = ChannelsHashtagDao.getHotHashtag();

//		HttpSession session = request.getSession();
//		UsersModel loginUser = (UsersModel)session.getAttribute("loginUser");

		if(hotHashtaglist != null){
			res = new ResponseModel(200, "success", hotHashtaglist);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(new Gson().toJson(res));
		}
		else
			response.sendError(500, new ResponseModel(500, "fail", "Cannot create channel").toString());

//		request.setAttribute("list", list);
//		System.out.println(list);
//		request.getRequestDispatcher("hashtagLink").forward(request, response);
	}
}
