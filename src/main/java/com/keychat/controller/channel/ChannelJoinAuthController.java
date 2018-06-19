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

//		HttpSession session = request.getSession();
//		UsersModel loginUser = (UsersModel)session.getAttribute("loginUser");
		        UsersModel loginUser = new UsersModel(
                "ggg@naver.com",
                "1234",
                "hello",
                "학생",
                "010-111-1111"
        );
		ChannelJoinAuthModel channelJoinAuthModel = JsonUtil.getModelFromJsonRequest(request, ChannelJoinAuthModel.class);
		boolean isAuth = ChannelsDao.isChannelAuthUser(channelJoinAuthModel);

		//참여하지 않은 방이였다면 참여 내역에 추가
		boolean isExistChannelUser = ChannelsJoinDao.isExistChannelUser(channelJoinAuthModel, loginUser);
		boolean isJoinChannel = false;
		if(!isExistChannelUser){
			isJoinChannel = ChannelsJoinDao.joinChannelUser(channelJoinAuthModel, loginUser);
		}

		//참여자가 익명 이름이 없으면 익명 이름 추가
//		TODO 참여자 익명이 존재하는지 체크
		boolean isExistAnonym = ChannelsJoinDao.isExistAnonym(channelJoinAuthModel, loginUser);
		if(!isExistAnonym){
			while(true){
                String tempAnonym = "Anonimity" + ((int) (Math.random() * (1000 - 1 + 1)) + 1);
                System.out.println(tempAnonym);
                if(ChannelsAnonymDao.isExistAnonymName(tempAnonym, channelJoinAuthModel) == null){
                    ChannelsAnonymDao.createAnonym(tempAnonym, loginUser, channelJoinAuthModel);
                    System.out.println(tempAnonym);
                    break;
                }
            }
		}

		System.out.println(isAuth + " " + isExistChannelUser + " " + isJoinChannel + " " + isExistAnonym);

		if(loginUser != null && isAuth && (isExistChannelUser || isJoinChannel)) {
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
