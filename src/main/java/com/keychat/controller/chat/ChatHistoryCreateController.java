package com.keychat.controller.chat;

import com.google.gson.*;
import com.keychat.dao.base.ChannelsChatHistoryDao;
import com.keychat.dao.base.UsersDao;
import com.keychat.dto.base.ChannelsChatHistoryModel;
import com.keychat.dto.base.UsersModel;
import com.keychat.dto.util.ResponseModel;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = "/chatc/create")
public class ChatHistoryCreateController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        BufferedReader input = new BufferedReader(new InputStreamReader(request.getInputStream()));
        StringBuilder builder = new StringBuilder();
        String buffer;
        while ((buffer = input.readLine()) != null) {
            if (builder.length() > 0) {
                builder.append("\n");
            }
            builder.append(buffer);
        }
        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(builder.toString());
        String name = element.getAsJsonObject().get("chatMsg").getAsJsonObject().toString();
        System.out.println(name);
        boolean success = false;
        ResponseModel res;

        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        ChannelsChatHistoryModel chatHistory = gson.fromJson(name, ChannelsChatHistoryModel.class);
        try {
            success = ChannelsChatHistoryDao.createChatHistory(chatHistory);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(success)
            res = new ResponseModel(200, "success", chatHistory.toString());
        else
            res = new ResponseModel(500, "fail", "Cannot create chat history");

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(gson.toJson(res));
    }
}

