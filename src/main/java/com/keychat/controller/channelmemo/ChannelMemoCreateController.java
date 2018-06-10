
package com.keychat.controller.channelmemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.keychat.dao.base.ChannelsMemoDao;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/channelMemo/create")
public class ChannelMemoCreateController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email").trim();
		String contents = request.getParameter("contents").trim();
		try {
			ChannelsMemoDao.insertMemo(email, contents);
			;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("#").forward(request, response);
	}
}
