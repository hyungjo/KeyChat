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
import com.keychat.dao.base.ChannelsFileboxDao;
import com.keychat.dto.base.UsersModel;
import com.keychat.dto.util.ResponseModel;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet(urlPatterns = "/channelfilebox/create")
public class ChannelFileboxCreateController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		UsersModel loginUser = (UsersModel) session.getAttribute("loginUser");

//TODO 채널명 폴더 만들기, 디비에 값 넣기, 디비에서 값 가져오기
		String savePath = request.getServletContext().getRealPath("Upload");

		ResponseModel res;

		if (loginUser != null) {
			if (!new File(savePath).isDirectory()) {
				new File(savePath).mkdirs();
			}

			MultipartRequest mr = null;
			int maxSize = 1024 * 1024 * 100; // 100MB 초과

			try{
				mr = new MultipartRequest(request, savePath, maxSize, "UTF-8", new DefaultFileRenamePolicy());
				String channel_name = mr.getParameter("channelRoom");

				System.out.println(channel_name);
				String filename = mr.getFilesystemName("input_file");
				String file_path = savePath + "/" + filename;

				if(ChannelsFileboxDao.insertFile(loginUser.getEmail(), file_path, channel_name)){
					res = new ResponseModel(200, "success", "success");
					response.setContentType("application/json");
					response.setCharacterEncoding("UTF-8");
					response.getWriter().write(new Gson().toJson(res));
				}

			} catch(Exception e){
				System.out.println("100mb 초과 잼");
				response.sendError(500, new ResponseModel(500, "fail", "Cannot upload file").toString());
			}
			// cos.jar 의 MultipartRequest 를 생성하면 동시에 서버에 업로드가 완료된다.

		} else {
			response.sendError(500, new ResponseModel(500, "fail", "Cannot upload file").toString());
		}
	}
}