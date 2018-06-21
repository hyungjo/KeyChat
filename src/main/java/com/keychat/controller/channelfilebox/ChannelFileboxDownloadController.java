package com.keychat.controller.channelfilebox;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.keychat.dao.base.ChannelsFileboxDao;
import com.keychat.dto.base.ChannelsFileboxModel;
import com.keychat.dto.base.UsersModel;
import com.keychat.dto.util.ResponseModel;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet(urlPatterns = "/jsp/channelfilebox/download")
public class ChannelFileboxDownloadController extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response)  {

        String fileName = request.getParameter("name");
        System.out.println(fileName);
    }
}
