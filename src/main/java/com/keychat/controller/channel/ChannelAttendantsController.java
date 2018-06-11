package com.keychat.controller.channel;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.keychat.dao.base.ChannelsJoinJoinChannelsAnonym;
import com.keychat.dao.base.UsersJoinChannelsJoin;
import com.keychat.dto.base.ChannelsJoinJoinChannelsAnonymModel;
import com.keychat.dto.base.ChannelsModel;
import com.keychat.dto.base.UsersJoinChannelsJoinModel;

@WebServlet(urlPatterns = "/channel/attendants")
public class ChannelAttendantsController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    	ChannelsModel list = new ChannelsModel();
//    	String result = list.getLimit_anonym();
//    	if (result.equals('T')) { // 익명 방이 맞으면
//    		String channel_name = request.getParameter("channel_name").trim();
//        	String anonym_name = request.getParameter("anonym_name").trim();
//            ChannelsJoinJoinChannelsAnonymModel user = new ChannelsJoinJoinChannelsAnonymModel(channel_name, anonym_name);
//    		try {
//				ChannelsJoinJoinChannelsAnonym.anonymCheck(user);
//				request.setAttribute("list", list);
//				System.out.println("ooooooooooooo");
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//    	if (result.equals('F')) { // 익명 방이 아니면
//    		String email = request.getParameter("email");
//            String nicname = request.getParameter("nicname");
//            String channel_name = request.getParameter("channel_name").trim();
//            UsersJoinChannelsJoinModel user = new UsersJoinChannelsJoinModel(email, channel_name, nicname);
//    		try {
//				UsersJoinChannelsJoin.anonymCheck2(user);
//				request.setAttribute("list", list);
//				System.out.println("ooooooooooooo");
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//    	}request.getRequestDispatcher("#").forward(request, response);
    }
}
