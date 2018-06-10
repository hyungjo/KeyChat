package com.keychat.controller.channelmemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.keychat.dao.base.ChannelsHashtagDao;
import com.keychat.dao.base.ChannelsMemoDao;
import com.keychat.dto.base.ChannelsHashtagModel;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/channelMemo/delete")
public class ChannelMemoDeleteController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doDelete(req, resp);
		String email = req.getParameter("email").trim();
		try {
			ChannelsMemoDao.dropChannelsMemo(email);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		req.getRequestDispatcher("#").forward(req, resp);
	}
}