package com.keychat.controller.user;

import com.google.gson.Gson;
import com.keychat.controller.util.JsonUtil;
import com.keychat.dao.base.ChannelsAnonymDao;
import com.keychat.dao.base.ChannelsDao;
import com.keychat.dto.base.ChannelJoinAuthModel;
import com.keychat.dto.base.ChannelsModel;
import com.keychat.dto.base.UserRepNameModel;
import com.keychat.dto.base.UsersModel;
import com.keychat.dto.util.ResponseModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/user/repname")
public class UserRepNameController extends HttpServlet {
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.setCharacterEncoding("UTF-8");
            ResponseModel res;

//            HttpSession session = request.getSession();
//            UsersModel loginUser = (UsersModel)session.getAttribute("loginUser");
                    UsersModel loginUser = new UsersModel(
                "ggg@naver.com",
                "1234",
                "hello",
                "학생",
                "010-111-1111"
        );
            ChannelJoinAuthModel channelJoinAuthModel = JsonUtil.getModelFromJsonRequest(request, ChannelJoinAuthModel.class);

            ChannelsModel channelModel = ChannelsDao.getChannelInfoByName(channelJoinAuthModel.getChannelName());

            if(loginUser != null) {
                if(channelModel.getLimitAnonym().equals("T") || channelModel.getLimitAnonym().equals("t")){
                    String anonymName = ChannelsAnonymDao.getExistAnonym(channelJoinAuthModel, loginUser);
                    System.out.println(anonymName + "  -----------  ");
                    res = new ResponseModel(200, "success", new UserRepNameModel(anonymName));
                }else{
                    String nickName = loginUser.getNickname();
                    res = new ResponseModel(200, "success", new UserRepNameModel(nickName));
                }
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write(new Gson().toJson(res));
            }
            else {
                response.sendError(500, new ResponseModel(500, "fail", "Cannot get user info").toString());
            }
        }
}
