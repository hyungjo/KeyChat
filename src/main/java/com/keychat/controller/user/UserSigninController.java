package com.keychat.controller.user;

import com.google.gson.Gson;
import com.keychat.controller.util.JsonUtil;
import com.keychat.dao.base.UsersDao;
import com.keychat.dto.base.SignModel;
import com.keychat.dto.base.UsersModel;
import com.keychat.dto.util.ResponseModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/user/signin")
public class UserSigninController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        ResponseModel res;
        SignModel usersModel = JsonUtil.getModelFromJsonRequest(request, SignModel.class);
        boolean isExist = UsersDao.isExactPassword(usersModel);
        UsersModel user = UsersDao.getUser(usersModel);
        if(isExist && user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("loginUser", user);
            res = new ResponseModel(200, "success", user);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(new Gson().toJson(res));
        }
        else {
            response.sendError(500, new ResponseModel(500, "fail", "Cannot signin user").toString());
        }
    }
}