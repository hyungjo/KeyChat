package com.keychat.controller.channelfilebox;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import com.keychat.dao.base.ChannelsFileboxDao;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet(urlPatterns = "/channelfilebox/create")
public class ChannelFileboxCreateController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); 
		String email = request.getParameter("email").trim();
		String channel_name = request.getParameter("channel_name").trim();
        String savePath = request.getServletContext().getRealPath(channel_name);
        if(!new File(savePath).isDirectory()){
            new File(savePath).mkdirs();
        }
        int maxSize = 1024*1024*100;
      //cos.jar 의 MultipartRequest 를 생성하면 동시에 서버에 업로드가 완료된다.
        MultipartRequest mr = new MultipartRequest(request, savePath, maxSize, "UTF-8", new DefaultFileRenamePolicy());
        String filename = mr.getFilesystemName("file");
        String file_path = savePath + "/" + filename;
		try {
			ChannelsFileboxDao.insertFile(email, file_path, channel_name);
		} catch (SQLException e) {
			e.printStackTrace();
		}request.getRequestDispatcher("#").forward(request, response);
   }
}