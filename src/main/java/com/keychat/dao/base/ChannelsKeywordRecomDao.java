package com.keychat.dao.base;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.keychat.controller.util.DBUtil;
import com.keychat.dto.base.ChannelsKeywordRecomModel;

public class ChannelsKeywordRecomDao {
	// 채널 참여자가 보낸 메시지를 가지고 분석해서 가장 많은 분포도를 group by로 묶고 count(*)으로 인기 순위를 나타낸다.
	public static ArrayList<String> findKeyword(ChannelsKeywordRecomModel user) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select keyword, count(*) as from channels_keyword_recom where CHANNEL_NAME = ? group by keyword order by count(*) desc;";
		ArrayList<String> list = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, user.getChannel_name());
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