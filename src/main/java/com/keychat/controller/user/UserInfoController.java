package com.keychat.controller.user;

import com.google.gson.Gson;
import com.keychat.dao.base.UsersDao;
import com.keychat.dto.base.UsersModel;
import com.keychat.dto.util.ResponseModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = "/user/info")
public class UserInfoController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResponseModel res = new ResponseModel(200, "success", "welcome");
        Gson gson = new Gson();
        List<UsersModel> users = null;
        try {
            users = UsersDao.getUsers();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(gson.toJson(users));
    }
}
