package com.keychat.dao.base;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.keychat.controller.util.DBUtil;
import com.keychat.dto.base.ChannelsKeywordRecomModel;

public class ChannelsKeywordRecomDao {
	//키워드값을 받아와서 키워드테이블에 저장한다
	public static boolean saveKeyword(ChannelsKeywordRecomModel channelsKeywordRecomModel) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "INSERT INTO CHANNELS_KEYWORD_RECOM VALUES (CHANNELS_JOIN_ID_SEQ.nextval, ?, ?, ?)";
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, channelsKeywordRecomModel.getKeyword());
			pstmt.setString(2, channelsKeywordRecomModel.getChannel_name());
			pstmt.setString(3, channelsKeywordRecomModel.getCreated_datetime().toString());
			pstmt.executeUpdate();
		} catch (SQLException s) {
			s.printStackTrace();
			throw s;
		} finally {
			DBUtil.close(pstmt, con);
		}
		return true;
	}
	
	// 채널 참여자가 보낸 메시지를 가지고 분석해서 가장 많은 분포도를 group by로 묶고 count(*)으로 인기 순위를 나타낸다.
		public static ArrayList<String> findKeyword(ChannelsKeywordRecomModel channelsKeywordRecomModel) throws SQLException {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			String query = "select KEYWORD, count(*) from CHANNELS_KEYWORD_RECOM where CHANNEL_NAME = ? group by KEYWORD order by count(*) desc";
			ArrayList<String> list = new ArrayList<String>();
			try {
				con = DBUtil.getConnection();
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, channelsKeywordRecomModel.getChannel_name());
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