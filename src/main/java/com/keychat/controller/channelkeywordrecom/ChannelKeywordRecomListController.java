package com.keychat.controller.channelkeywordrecom;

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
import com.keychat.dao.base.ChannelsKeywordRecomDao;
import com.keychat.dto.base.ChannelsKeywordRecomModel;
import com.keychat.dto.util.ResponseModel;

@WebServlet(urlPatterns = "/channelKeywordRecom/list")
public class ChannelKeywordRecomListController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
		ResponseModel res;
		ChannelsKeywordRecomModel channelsKeywordRecomModel = JsonUtil.getModelFromJsonRequest(request, ChannelsKeywordRecomModel.class);
		ArrayList<String> saveKeyword = ChannelsKeywordRecomDao.findKeyword(channelsKeywordRecomModel);
		if(saveKeyword != null)
			res = new ResponseModel(200, "success", saveKeyword);
		else
			res = new ResponseModel(500, "fail", "Cannot create user");
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(new Gson().toJson(res));
		
    }
}