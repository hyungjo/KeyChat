package com.keychat.controller.channelfilebox;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.keychat.dao.base.ChannelsFileboxDao;
import com.keychat.dao.base.ChannelsMemoDao;
import com.keychat.dto.base.ChannelsFileboxModel;
import com.keychat.dto.base.ChannelsMemoModel;
import com.keychat.dto.base.ChannelsModel;
import com.keychat.dto.base.UsersModel;
import com.keychat.dto.util.ResponseModel;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/channelfilebox/list")
public class ChannelFileboxListController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
//		String channel_name = request.getParameter("channel_name").trim();
		ResponseModel res;
		HttpSession session = request.getSession();
		UsersModel loginUser = (UsersModel) session.getAttribute("loginUser");

		ArrayList<ChannelsFileboxModel> list = null;
		try {
			list = ChannelsFileboxDao.selectFile("자유");
			if (loginUser != null && list != null){
				request.setAttribute("list", list);

				res = new ResponseModel(200, "success", list);
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(new Gson().toJson(res));
			} else {
				response.sendError(500, new ResponseModel(500, "fail", "Cannot get user info").toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("#").forward(request, response);
	}
}