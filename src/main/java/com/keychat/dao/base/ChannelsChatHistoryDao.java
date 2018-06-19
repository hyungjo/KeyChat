package com.keychat.dao.base;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import com.keychat.controller.util.DBUtil;
import com.keychat.dto.base.ChannelChatHistoryReadModel;
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

	//ChatHistory DB에 등록
	public static boolean createChatHistory(ChannelsChatHistoryModel channelsChatHistoryModel) {
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean success = false;
		System.out.println(channelsChatHistoryModel.toString());
		String query = "insert into channels_chat_history values(CHANNELS_CHAT_HISTORY_ID_SEQ.NEXTVAL, ?, ?, ?, ?)";
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, channelsChatHistoryModel.getEmail());
			pstmt.setString(2, channelsChatHistoryModel.getChannel_name());
			pstmt.setString(3, channelsChatHistoryModel.getContents());
			pstmt.setTimestamp(4, channelsChatHistoryModel.getSent_datetime());
			int insertedRowCount = pstmt.executeUpdate();
			if(insertedRowCount > 0)
				success = true;
		} catch (SQLException s) {
			s.printStackTrace();
		} finally {
			DBUtil.close(pstmt, con);
			return success;
		}
	}
	//CHANNELS_CHAT_HISTORY TABLE에 저장된 내용을 Select문으로 조회해서 단어를 찾는다.
	public static ArrayList<ChannelsChatHistoryModel> readChannelHistories(ChannelsChatHistoryModel channelsChatHistoryModel) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM CHANNELS_CHAT_HISTORY WHERE CHANNEL_NAME=?";
		ArrayList<ChannelsChatHistoryModel> list = new ArrayList<ChannelsChatHistoryModel>();
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, channelsChatHistoryModel.getChannel_name());
			rset = pstmt.executeQuery();
			while (rset.next()) {
				list.add(new ChannelsChatHistoryModel(
														rset.getString(2),
														rset.getString(3),
														rset.getString(4),
														rset.getTimestamp(5)));
			}
		} catch (SQLException s) {
			s.printStackTrace();
		} finally {
			DBUtil.close(pstmt, con);
		}

		return list;
	}

	//CHANNELS_CHAT_HISTORY TABLE에 저장된 내용을 Select문으로 조회해서 단어를 찾는다.
	public static ArrayList<String> selectChannelsName(ChannelsChatHistoryModel user) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select contents from channels_chat_history where content like '%?%' and like '%?' and like '?%'";
		ArrayList<String> list = new ArrayList<String>();
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
		} finally {
			DBUtil.close(pstmt, con);
		}
		return list;
	}
	
	public static String getHistory(ChannelChatHistoryReadModel channelChatHistoryReadModel) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		StringBuilder contentsList = new StringBuilder();

		String query = "select contents, sent_datetime from ( select contents, sent_datetime from channels_chat_history where channel_name = ? order by sent_datetime desc) where rownum <= ?";
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, channelChatHistoryReadModel.getChannelName());
			pstmt.setInt(2, channelChatHistoryReadModel.getCount());
			rset = pstmt.executeQuery();
			while (rset.next()) {
				contentsList.append(rset.getString(1)).append("\t");
				System.out.println(rset.getString(1));
			}
			
		} catch (SQLException s) {
			s.printStackTrace();
		} finally {
			DBUtil.close(pstmt, con);
		}

		return contentsList.toString();
	}
}