package com.keychat.controller.channelmemo;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.keychat.dao.base.ChannelsMemoDao;
import com.keychat.dto.base.ChannelsMemoModel;
import com.keychat.dto.base.UsersModel;
import com.keychat.dto.util.ResponseModel;

@WebServlet("/channelmemo")
public class ChannelMemoController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
request.setCharacterEncoding("UTF-8");
		
		System.out.println("00000001111111111111222222222222222");
		
		String command = request.getParameter("command");
		if (command.equals("create")) {
			create(request, response);
		} else if (command.equals("delete")) {
			delete(request, response);
		} else if (command.equals("update")) {
			update(request, response);
		} else if (command.equals("list")) {
			list(request, response);
		}
	}

	public void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UsersModel loginUser = (UsersModel) session.getAttribute("loginUser");
		String email = loginUser.getEmail();
		String contents = request.getParameter("contents").trim();
		ResponseModel res;
		if (loginUser != null) {
			res = new ResponseModel(200, "success", loginUser);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(new Gson().toJson(res));
			try {
				ChannelsMemoDao.insertMemo(email, contents);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else {
			response.sendError(500, new ResponseModel(500, "fail", "Cannot get user info").toString());
		}
	}

	public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UsersModel loginUser = (UsersModel) session.getAttribute("loginUser");
		String email = loginUser.getEmail();
		ResponseModel res;
		if (loginUser != null) {
			res = new ResponseModel(200, "success", loginUser);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(new Gson().toJson(res));
			try {
				ChannelsMemoDao.dropChannelsMemo(email);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.getRequestDispatcher("#").forward(request, response);
		} else {
			response.sendError(500, new ResponseModel(500, "fail", "Cannot get user info").toString());
		}
	}

	public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String email = request.getParameter("email").trim();
		String contents = request.getParameter("contents").trim();
		ChannelsMemoModel user = new ChannelsMemoModel(0, email, contents);
		ResponseModel res;
		HttpSession session = request.getSession();
		UsersModel loginUser = (UsersModel) session.getAttribute("loginUser");
		if (loginUser != null) {
			res = new ResponseModel(200, "success", loginUser);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(new Gson().toJson(res));
			try {
				ChannelsMemoDao.updateMemo(user);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.getRequestDispatcher("#").forward(request, response);
		} else {
			response.sendError(500, new ResponseModel(500, "fail", "Cannot get user info").toString());
		}
	}

	public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		UsersModel loginUser = (UsersModel) session.getAttribute("loginUser");
		String email = loginUser.getEmail();
		ChannelsMemoModel user = new ChannelsMemoModel(0, email, null);
		ResponseModel res;
		if (loginUser != null) {
			res = new ResponseModel(200, "success", loginUser);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(new Gson().toJson(res));
			try {
				ArrayList<String> list = ChannelsMemoDao.selectMemo(user);
				request.setAttribute("list", list);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.getRequestDispatcher("#").forward(request, response);
		}else {
			response.sendError(500, new ResponseModel(500, "fail", "Cannot get user info").toString());
		}
	}

}
