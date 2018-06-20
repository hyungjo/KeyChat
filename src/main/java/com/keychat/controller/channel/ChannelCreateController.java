package com.keychat.controller.channel;

import com.google.gson.Gson;
import com.keychat.controller.util.JsonUtil;
import com.keychat.dao.base.ChannelsDao;
import com.keychat.dao.base.ChannelsHashtagDao;
import com.keychat.dao.base.UsersDao;
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

@WebServlet(urlPatterns = "/channel/create")
public class ChannelCreateController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        ResponseModel res;
        HttpSession session = request.getSession();
        UsersModel loginUser = (UsersModel)session.getAttribute("loginUser");
//DummyUser
//        UsersModel loginUser = new UsersModel(
//                "ggg@naver.com",
//                "1234",
//                "hello",
//                "학생",
//                "010-111-1111"
//        );
        ChannelCreateModel channelCreateModel = JsonUtil.getModelFromJsonRequest(request, ChannelCreateModel.class);
        ChannelsModel channelsModel = new ChannelsModel(
                channelCreateModel.getName(),
                loginUser.getEmail(),
                channelCreateModel.getPassword(),
                channelCreateModel.getLimitCapacity(),
                channelCreateModel.getLimitTime(),
                channelCreateModel.getLimitAnonym(),
                new Timestamp(System.currentTimeMillis())
        );
        boolean isExist = ChannelsDao.isExistChannel(channelsModel);
        boolean isCreatedChannel = ChannelsDao.createChannel(channelsModel);
        boolean isCreatedHashtag = ChannelsHashtagDao.insertHashtag(channelCreateModel);

        if(!isExist && isCreatedChannel && isCreatedHashtag){
            res = new ResponseModel(200, "success", channelsModel);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(new Gson().toJson(res));
        }
        else
            response.sendError(500, new ResponseModel(500, "fail", "Cannot create channel").toString());


    }
}
