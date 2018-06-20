package com.keychat.controller.channel;

import com.google.gson.Gson;
import com.keychat.controller.util.JsonUtil;
import com.keychat.dao.base.*;
import com.keychat.dto.base.*;
import com.keychat.dto.util.ResponseModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/channel/auth")
public class ChannelJoinAuthController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
		ResponseModel res = null;

		HttpSession session = request.getSession();
		UsersModel loginUser = (UsersModel)session.getAttribute("loginUser");

		ChannelJoinAuthModel channelJoinAuthModel = JsonUtil.getModelFromJsonRequest(request, ChannelJoinAuthModel.class);
		boolean isAuth = ChannelsDao.isChannelAuthUser(channelJoinAuthModel);

		System.out.println(isAuth);

		if(loginUser != null && isAuth) {
				res = new ResponseModel(200, "success", loginUser);
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(new Gson().toJson(res));
		}
		else {
			response.sendError(500, new Gson().toJson(new ResponseModel(500, "fail", "Cannot join channel").toString()));
		}
    }	
}
