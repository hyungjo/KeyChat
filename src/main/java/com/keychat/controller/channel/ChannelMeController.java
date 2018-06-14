package com.keychat.controller.channel;

import com.google.gson.Gson;
import com.keychat.controller.util.JsonUtil;
import com.keychat.dao.base.ChannelsDao;
import com.keychat.dao.base.ChannelsJoinDao;
import com.keychat.dto.base.ChannelsJoinModel;
import com.keychat.dto.base.ChannelsModel;
import com.keychat.dto.base.UsersModel;
import com.keychat.dto.util.ResponseModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/channel/me")
public class ChannelMeController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        ResponseModel res = null;

        HttpSession session = request.getSession();
        UsersModel loginUser = (UsersModel)session.getAttribute("loginUser");
//                  Dummy User
//                UsersModel loginUser = new UsersModel(
//                "ggg@naver.com",
//                "1234",
//                "hello",
//                "학생",
//                "010-111-1111"
//        );

        if(loginUser != null) {
            ArrayList<ChannelsModel> joinChannelList = ChannelsJoinDao.getChannelsByUser(loginUser);
            if(joinChannelList != null)
                res = new ResponseModel(200, "success", joinChannelList);
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write(new Gson().toJson(res));
        }else
            response.sendError(500, new ResponseModel(500, "fail", "Cannot access").toString());

    }
}
