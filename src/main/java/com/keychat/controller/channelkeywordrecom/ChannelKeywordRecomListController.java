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
		String keyword = request.getParameter("keylist").trim();
		String channel_name = request.getParameter("channel_name").trim();
		ChannelsKeywordRecomModel channelsKeywordRecomModel = new ChannelsKeywordRecomModel(0, keyword, channel_name, null);
		String nonkeyword = "분석된 키워드가 존재하지 않습니다.";
		boolean result;
		try {
			result = ChannelsKeywordRecomDao.saveKeyword(channelsKeywordRecomModel);
			if(result) {//키워드리스트 보내기
				ArrayList<String> list = ChannelsKeywordRecomDao.findKeyword(channelsKeywordRecomModel);
				request.setAttribute("list", list);
			}else {//분석된 키워드가 존재하지 않습니다 출력.
				request.setAttribute("nonkeyword", nonkeyword);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			//분석된 키워드가 존재하지 않습니다 출력.
			request.setAttribute("nonkeyword", nonkeyword);
		}
    }
}