package com.keychat.controller.channel;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.keychat.controller.util.JsonUtil;
import com.keychat.dao.base.*;
import com.keychat.dto.base.*;
import com.keychat.dto.util.ResponseModel;

@WebServlet(urlPatterns = "/channel/attendants")
public class ChannelAttendantsController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
		ChannelJoinAuthModel channelJoinAuthModel = JsonUtil.getModelFromJsonRequest(request, ChannelJoinAuthModel.class);
		ResponseModel res = null;

		HttpSession session = request.getSession();
		UsersModel loginUser = (UsersModel)session.getAttribute("loginUser");
//        UsersModel loginUser = new UsersModel(
//                "hyungjo@gmail.com",
//                "1234",
//                "hello",
//                "학생",
//                "010-111-1111"
//        );

		//비밀 채널 체크
		boolean isChannelPassword = false;
		if(channelJoinAuthModel != null)
			isChannelPassword = ChannelsDao.isChannelPassword(channelJoinAuthModel);

		boolean isAnonymChannel = false;
		ChannelsModel channelsModel = ChannelsDao.getChannelInfoByName(channelJoinAuthModel.getChannelName());
//
//		//익명 이름 생성
		if(channelsModel != null && channelsModel.getLimitAnonym().equals("T") && !ChannelsAnonymDao.isExistAnonym(channelJoinAuthModel, loginUser)){
			while(true){
				String anonym = String.valueOf((int) (Math.random() * 1000)) + 1;
				System.out.print(anonym);
				if(!ChannelsAnonymDao.isExistAnonymName(anonym, channelJoinAuthModel)){
					ChannelsAnonymDao.createAnonym(anonym, loginUser, channelJoinAuthModel);
					System.out.println(anonym);
					break;
				}
			}
		}

		if(!ChannelsJoinDao.isExistChannelUser(channelJoinAuthModel, loginUser))
			ChannelsJoinDao.joinChannelUser(channelJoinAuthModel, loginUser);

		if(isChannelPassword)
			res = new ResponseModel(200, "success", "secret");
		else
			res = new ResponseModel(200, "success", "nonesecret");

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(new Gson().toJson(res));
	}
}