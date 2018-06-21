package com.keychat.controller.channel;

import com.google.gson.Gson;
import com.keychat.controller.util.JsonUtil;
import com.keychat.dao.base.ChannelsDao;
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

@WebServlet(urlPatterns = "/channel/list")
public class ChannelListController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        ResponseModel res;

        HttpSession session = request.getSession();
        UsersModel loginUser = (UsersModel) session.getAttribute("loginUser");
        ArrayList<ChannelsModel> channelList = ChannelsDao.getChannelsInfo();

        if (loginUser != null && channelList != null) {
            res = new ResponseModel(200, "success", channelList);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(new Gson().toJson(res));
        } else
            response.sendError(500, new ResponseModel(500, "fail", "Cannot access").toString());

    }
}