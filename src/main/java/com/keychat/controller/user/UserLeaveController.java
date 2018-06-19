package com.keychat.controller.user;

import com.google.gson.Gson;
import com.keychat.controller.util.JsonUtil;
import com.keychat.dao.base.ChannelsMemoDao;
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
import java.sql.SQLException;

@WebServlet(urlPatterns = "/user/leave")
public class UserLeaveController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
		 HttpSession session = request.getSession();
	        UsersModel loginUser = (UsersModel)session.getAttribute("loginUser");
		ResponseModel res;
		if (loginUser != null) {
			res = new ResponseModel(200, "success", loginUser);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(new Gson().toJson(res));
			try {
				UsersDao.dropUser(loginUser);
			} catch (Exception e) {
				e.printStackTrace();
			}
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		} else {
			response.sendError(500, new ResponseModel(500, "fail", "Cannot get user info").toString());
		}
        /*ResponseModel res;
        UsersModel usersModel = JsonUtil.getModelFromJsonRequest(request, UsersModel.class);
        SignModel signModel = new SignModel(usersModel.getEmail(), usersModel.getPassword());
        boolean isExist = UsersDao.isExactPassword(signModel);
        boolean isUpdated = UsersDao.dropUser(usersModel);

        if(isExist && isUpdated)
            res = new ResponseModel(200, "success", usersModel);
        else
            res = new ResponseModel(500, "fail", "Cannot create user");

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(new Gson().toJson(res));*/
    }
}
