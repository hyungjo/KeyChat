package com.keychat.dao.base;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.keychat.controller.util.DBUtil;
import com.keychat.dto.base.ChannelsChatHistoryModel;


public class ChannelsChatHistoryDao {
	//CHANNELS_CHAT_HISTORY 에서 EMAIL을 찾아 회원을 탈퇴 한다. 
		public static void dropHistory(String email) throws SQLException{
	    	Connection con = null;
			PreparedStatement pstmt = null;
			String query = "DELETE FROM CHANNELS_CHAT_HISTORY WHERE EMAIL=?";
			try {
				con = DBUtil.getConnection();
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, email);
				pstmt.executeQuery();
			} catch (SQLException s) {
				s.printStackTrace();
				throw s;
			} finally {
				DBUtil.close(pstmt, con);
			}
		}
		//socket 통신으로 메시지를 띄워올려준 다음 키워드 추천을 위한 insert문 쿼리 전송
		public static void insertUsers(ChannelsChatHistoryModel user) throws SQLException {
			Connection con = null;
			PreparedStatement pstmt = null;
			String query = "insert into channels_chat_history values(?, ?, ?, ?)";
			try {
				con = DBUtil.getConnection();
				pstmt = con.prepareStatement(query);
				pstmt.setInt(1, user.getChannels_chat_history_id());
				pstmt.setString(2, user.getEmail());
				pstmt.setString(3, user.getContents());
				pstmt.setDate(4, user.getSent_datetime());
				pstmt.executeUpdate();
			} catch (SQLException s) {
				s.printStackTrace();
				throw s;
			} finally {
				DBUtil.close(pstmt, con);
			}
		}
		//CHANNELS_CHAT_HISTORY TABLE에 저장된 내용을 Select문으로 조회해서 단어를 찾는다.
		public static ArrayList<String> selectChannelsName(ChannelsChatHistoryModel user) throws SQLException {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			String query = "select contents from channels_chat_history where content like '%?%' and like '%?' and like '?%'";
			ArrayList<String> list = null;
			try {
				con = DBUtil.getConnection();
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, user.getContents());
				pstmt.setString(2, user.getContents());
				pstmt.setString(3, user.getContents());
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
