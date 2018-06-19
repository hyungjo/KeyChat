package com.keychat.controller.chat;

import com.google.gson.Gson;
import com.keychat.controller.util.JsonUtil;
import com.keychat.dao.base.ChannelsChatHistoryDao;
import com.keychat.dto.base.ChannelChatHistoryCreateModel;
import com.keychat.dto.base.ChannelsChatHistoryModel;
import com.keychat.dto.util.ResponseModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;

@WebServlet(urlPatterns = "/chathistory/create")
public class ChatHistoryCreateController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        ResponseModel res;
        ChannelChatHistoryCreateModel channelsChatHistoryCreateModel = JsonUtil.getModelFromJsonRequest(request, ChannelChatHistoryCreateModel.class);
        ChannelsChatHistoryModel channelsChatHistoryModel = new ChannelsChatHistoryModel(
                channelsChatHistoryCreateModel.getEmail(),
                channelsChatHistoryCreateModel.getChannel_name(),
                channelsChatHistoryCreateModel.getContents(),
                new Timestamp(System.currentTimeMillis())
        );

        if(ChannelsChatHistoryDao.createChatHistory(channelsChatHistoryModel)) {
            res = new ResponseModel(200, "success", channelsChatHistoryModel.toString());
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(new Gson().toJson(res));
        }else
          response.sendError(500, new ResponseModel(500, "fail", "Cannot create chat history").toString());

    }
}

