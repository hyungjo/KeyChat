package com.keychat.controller.chat;

import com.google.gson.Gson;
import com.keychat.controller.util.JsonUtil;
import com.keychat.dao.base.ChannelsChatHistoryDao;
import com.keychat.dto.base.ChannelsChatHistoryModel;
import com.keychat.dto.util.ResponseModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


@WebServlet(urlPatterns = "/chat/read")
public class ChatHistoryReadController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        ResponseModel res;

        ChannelsChatHistoryModel channelsChatHistoryModel = JsonUtil.getModelFromJsonRequest(request, ChannelsChatHistoryModel.class);
        ArrayList<ChannelsChatHistoryModel> list = ChannelsChatHistoryDao.readChannelHistories(channelsChatHistoryModel);

        if(list.size() >= 1)
            res = new ResponseModel(200, "success", list);
        else if(list.size() == 0)
            res = new ResponseModel(200, "success", "No result");
        else
            res = new ResponseModel(500, "fail", "Cannot read chat history");

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(new Gson().toJson(res));
    }
}

