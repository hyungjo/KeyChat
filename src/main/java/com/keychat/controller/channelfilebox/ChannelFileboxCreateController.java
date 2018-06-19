package com.keychat.controller.channelfilebox;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.keychat.dto.base.UsersModel;
import com.keychat.dto.util.ResponseModel;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet(urlPatterns = "/jsp/channelfilebox/create")
public class ChannelFileboxCreateController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
//		String email = request.getParameter("email");
//		String channel_name = request.getParameter("channel_name").trim();
		String savePath = request.getServletContext().getRealPath("자유");

		ResponseModel res;
		HttpSession session = request.getSession();
		UsersModel loginUser = (UsersModel) session.getAttribute("loginUser");
		if (loginUser != null) {
			res = new ResponseModel(200, "success", loginUser);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(new Gson().toJson(res));
			if (!new File(savePath).isDirectory()) {
				new File(savePath).mkdirs();
			}

			MultipartRequest mr = null;
			int maxSize = 1024 * 1024 * 100; // 100MB 초과

			try{
				mr = new MultipartRequest(request, savePath, maxSize, "UTF-8", new DefaultFileRenamePolicy());
				String filename = mr.getFilesystemName("input_file");
				String file_path = savePath + "/" + filename;
				//			try {
				//				ChannelsFileboxDao.insertFile(email, file_path, channel_name);
				//			} catch (SQLException e) {
				//				e.printStackTrace();
				//			}
				System.out.println(loginUser.getEmail());
				System.out.println(file_path);

				request.getRequestDispatcher("#").forward(request, response);
			} catch(Exception e){
				System.out.println("100mb 초과 잼");
				request.getRequestDispatcher("#").forward(request, response);
				return;
			}
			// cos.jar 의 MultipartRequest 를 생성하면 동시에 서버에 업로드가 완료된다.

		} else {
			response.sendError(500, new ResponseModel(500, "fail", "Cannot get user info").toString());
		}
	}
}