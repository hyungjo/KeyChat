package com.keychat.controller.channel;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/channel/hashtagLink")
public class ChannelHotHashtagLink extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Object list = request.getAttribute("list");
		System.out.println(list);
		String[] list2 = (String[]) list;
		String one = list2[0];
		System.out.println(one);
		//핫해쉬태그 목록 5개 가져옴! 하나씩 뽑아서 DAO중에 해쉬태그로 채널검색하는거 사용
		//이해 못했으 오늘 설명해주라~
	}
}
