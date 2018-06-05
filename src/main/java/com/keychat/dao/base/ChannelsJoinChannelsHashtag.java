package com.keychat.dao.base;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.keychat.controller.util.DBUtil;
import com.keychat.dto.base.ChannelsJoinChannelsHashtagModel;


public class ChannelsJoinChannelsHashtag {
	// 채팅 창에 방 정보를 출력하기 위해서는 SELECT문을 쓴다. (join문 포함)
	public static ArrayList<String> roomSelect(ChannelsJoinChannelsHashtagModel user) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT A.NAME, B.HASHTAG, A.LIMIT_CAPACITY, A.LIMIT_TIME, A.LIMIT_ANONYM FROM CHANNELS A JOIN CHANNELS_HASHTAG B ON(A.NAME = B.CHANNEL_NAME) WHERE A.NAME = ?";
		ArrayList<String> list = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, user.getName());
			rset = pstmt.executeQuery();
			while (rset.next()) {
				list.add(rset.getString(1));
			}
		} catch (SQLException s) {
			s.printStackTrace();
			throw s;
		} finally {
			DBUtil.close(pstmt, con);
		}
		return list;
	}
}
