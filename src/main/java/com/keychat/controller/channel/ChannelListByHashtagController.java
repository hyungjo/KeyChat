package com.keychat.controller.channel;

import com.google.gson.Gson;
import com.keychat.controller.util.JsonUtil;
import com.keychat.dao.base.ChannelsDao;
import com.keychat.dao.base.ChannelsHashtagDao;
import com.keychat.dto.base.ChannelCreateModel;
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
import java.sql.Timestamp;
import java.util.Map;

@WebServlet(urlPatterns = "/channel/list/hashtag")
public class ChannelListByHashtagController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        ResponseModel res;
//        HttpSession session = request.getSession();
//        UsersModel loginUser = (UsersModel)session.getAttribute("loginUser");

        UsersModel loginUser = new UsersModel(
                "hyungjo@gmail.com",
                "1234",
                "hello",
                "학생",
                "010-111-1111"
        );

        Map<String, String> channelListByHashtag = ChannelsDao.getChannelListByHashtag();

        if(channelListByHashtag != null && loginUser != null){
            res = new ResponseModel(200, "success", channelListByHashtag);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(new Gson().toJson(res));
        }
        else
            response.sendError(500, new ResponseModel(500, "fail", "Cannot get channel list").toString());


    }
}
