package com.keychat.controller.user;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.keychat.dao.base.UsersDao;
import com.keychat.dto.base.UsersModel;
import com.keychat.dto.util.ResponseModel;

@WebServlet(urlPatterns = "/user/allUser")
public class allUserController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        ResponseModel res;
        ArrayList<UsersModel> list = UsersDao.getUserList();
        res = new ResponseModel(200, "success", list);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(new Gson().toJson(res));
	}

}
