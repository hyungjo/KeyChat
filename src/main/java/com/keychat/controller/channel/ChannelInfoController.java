package com.keychat.controller.channel;

import com.google.gson.Gson;
import com.keychat.controller.util.JsonUtil;
import com.keychat.dao.base.ChannelsDao;
import com.keychat.dto.base.ChannelsModel;
import com.keychat.dto.util.ResponseModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/channel/info")
public class ChannelInfoController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        ResponseModel res;
        String channelName = request.getParameter("channelName");
        ChannelsModel existChannelModel = ChannelsDao.getChannelInfoByName(channelName);

        if(existChannelModel != null) {
            res = new ResponseModel(200, "success", existChannelModel);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(new Gson().toJson(res));
        } else
            res = new ResponseModel(500, "fail", "Cannot get channel info");

    }

}
