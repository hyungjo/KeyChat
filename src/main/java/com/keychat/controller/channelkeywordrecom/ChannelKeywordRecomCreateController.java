package com.keychat.controller.channelkeywordrecom;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.keychat.controller.util.JsonUtil;
import com.keychat.dao.base.ChannelsKeywordRecomDao;
import com.keychat.dto.base.ChannelsKeywordRecomModel;
import com.keychat.dto.util.ResponseModel;

@WebServlet(urlPatterns = "/channelKeywordRecom/create")
public class ChannelKeywordRecomCreateController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		ResponseModel res;
		ChannelsKeywordRecomModel channelsKeywordRecomModel = JsonUtil.getModelFromJsonRequest(request, ChannelsKeywordRecomModel.class);
		boolean saveKeyword = ChannelsKeywordRecomDao.saveKeyword(channelsKeywordRecomModel);
			if(saveKeyword)
				res = new ResponseModel(200, "success", channelsKeywordRecomModel);
			else
				res = new ResponseModel(500, "fail", "Cannot create user");
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(new Gson().toJson(res));
    }
}