package com.keychat.controller.chat;

import com.google.gson.Gson;
import com.keychat.controller.util.JsonUtil;
import com.keychat.dao.base.ChannelsChatHistoryDao;
import com.keychat.dto.base.ChannelsChatHistoryModel;
import com.keychat.dto.util.ResponseModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;
import java.io.IOException;
import java.sql.Timestamp;

@WebServlet(urlPatterns = "/chatview")
public class ChatController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String channel = request.getParameter("channel");
        request.setAttribute("channelName", channel);
        response.setCharacterEncoding("UTF-8");
        RequestDispatcher rd = request.getRequestDispatcher("/jsp/chatroom.jsp");
        rd.forward(request,response);

    }
}

