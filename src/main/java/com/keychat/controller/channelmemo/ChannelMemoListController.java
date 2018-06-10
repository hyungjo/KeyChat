package com.keychat.controller.channelmemo;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.keychat.dao.base.ChannelsMemoDao;
import com.keychat.dto.base.ChannelsMemoModel;

@WebServlet(urlPatterns = "/channelMemo/list")
public class ChannelMemoListController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email").trim();
		ChannelsMemoModel user = new ChannelsMemoModel(0, email, null);
		try {
			ArrayList<String> list = ChannelsMemoDao.selectMemo(user);
			request.setAttribute("list", list);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("#").forward(request, response);
	}
}
