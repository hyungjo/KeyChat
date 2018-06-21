package com.keychat.controller.channel;

import com.google.gson.Gson;
import com.keychat.controller.util.JsonUtil;
import com.keychat.dao.base.ChannelsDao;
import com.keychat.dao.base.ChannelsHashtagDao;
import com.keychat.dto.base.ChannelInfoModel;
import com.keychat.dto.base.ChannelJoinAuthModel;
import com.keychat.dto.base.ChannelsModel;
import com.keychat.dto.util.ResponseModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/channel/info")
public class ChannelInfoController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        ResponseModel res;
        ChannelJoinAuthModel channelJoinAuthModel = JsonUtil.getModelFromJsonRequest(request, ChannelJoinAuthModel.class);

        ChannelsModel existChannelModel = ChannelsDao.getChannelInfoByName(channelJoinAuthModel.getChannelName());
        ArrayList<String> channelHashtag = ChannelsHashtagDao.findHashes(channelJoinAuthModel.getChannelName());
        ChannelInfoModel channelInfoModel = new ChannelInfoModel(existChannelModel, channelHashtag);

        if(existChannelModel != null) {
            res = new ResponseModel(200, "success", channelInfoModel);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(new Gson().toJson(res));
        } else {
            response.sendError(500, new ResponseModel(500, "fail", "Cannot get channel info").toString());
        }
    }

}