package com.keychat.controller.channelfilebox;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/jsp/channelfilebox/download")
public class ChannelFileboxDownloadController extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("dddd");
        String fileName = request.getParameter("name").trim();


        String savePath = "Upload";
        ServletContext context = getServletContext();

        String downloadPath = context.getRealPath(savePath);

        System.out.println("다운로드 위치 >> " + downloadPath);

        String sFilePath = downloadPath + "\\" + fileName;

        File oFile = new File(sFilePath);
        byte[] b = new byte[100*1024*1024]; // 100mb 초과 x

        FileInputStream in = new FileInputStream(oFile);

        String sMimeType = getServletContext().getMimeType(sFilePath);
        System.out.println("유형 : " + sMimeType);

        if(sMimeType == null){
            sMimeType = "application.octec-stream";
        }

        response.setContentType(sMimeType);

        String A = new String(fileName.getBytes("euc-kr"),"8859_1");
        String B = "utf-8";
        String sEncoding = URLEncoder.encode(A, B);

        String AA = "Content-Disposition";
        String BB = "attachment; filename=" + sEncoding;
        response.setHeader(AA, BB);

        ServletOutputStream out = response.getOutputStream();

        int numRead = 0;

        while((numRead=in.read(b, 0, b.length))!=-1){
            out.write(b, 0, numRead);
        }

        out.flush();
        out.close();
        in.close();
    }
}
