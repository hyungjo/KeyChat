package com.keychat.controller.channel;

import com.google.gson.Gson;
import com.keychat.controller.util.JsonUtil;
import com.keychat.dao.base.ChannelsDao;
import com.keychat.dao.base.ChannelsJoinDao;
import com.keychat.dto.base.ChannelsJoinModel;
import com.keychat.dto.base.ChannelsModel;
import com.keychat.dto.util.ResponseModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/channel/me")
public class ChannelMeController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        ResponseModel res;
        ChannelsJoinModel channelsJoinModel = JsonUtil.getModelFromJsonRequest(request, ChannelsJoinModel.class);
        ArrayList<String> existChannelModel = ChannelsJoinDao.getMyChannels(channelsJoinModel);

        if(existChannelModel != null)
            res = new ResponseModel(200, "success", existChannelModel);
        else
            res = new ResponseModel(500, "fail", "Cannot create user");

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(new Gson().toJson(res));
    }
}
