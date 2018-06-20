package com.keychat.controller.channel;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.keychat.controller.util.JsonUtil;
import com.keychat.dao.base.ChannelsDao;
import com.keychat.dao.base.ChannelsJoinJoinChannelsAnonym;
import com.keychat.dao.base.UsersJoinChannelsJoin;
import com.keychat.dto.base.ChannelCreateModel;
import com.keychat.dto.base.ChannelJoinAuthModel;
import com.keychat.dto.base.ChannelsJoinJoinChannelsAnonymModel;
import com.keychat.dto.base.UsersJoinChannelsJoinModel;
import com.keychat.dto.util.ResponseModel;

@WebServlet(urlPatterns = "/channel/attendants")
public class ChannelAttendantsController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
		ChannelJoinAuthModel channelJoinAuthModel = JsonUtil.getModelFromJsonRequest(request, ChannelJoinAuthModel.class);
		ResponseModel res = null;

		//비밀 채널 체크
		boolean isChannelPassword = false;
		if(channelJoinAuthModel != null)
			isChannelPassword = ChannelsDao.isChannelPassword(channelJoinAuthModel);

		if(isChannelPassword){
			res = new ResponseModel(200, "success", "secret");
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(new Gson().toJson(res));
		}else {
			res = new ResponseModel(200, "success", "nonesecret");
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(new Gson().toJson(res));
		}
	}
}
