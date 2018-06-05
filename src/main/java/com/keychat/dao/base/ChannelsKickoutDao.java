package com.keychat.dao.base;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.keychat.controller.util.DBUtil;
import com.keychat.dto.base.ChannelsKickoutModel;


public class ChannelsKickoutDao {
	//CHANNELS_KICKOUT에서 EMAIL을 찾아 회원을 탈퇴 한다. 
		public static void dropChannelsKickout(String email) throws SQLException{
	    	Connection con = null;
			PreparedStatement pstmt = null;
			String query = "DELETE FROM CHANNELS_KICKOUT WHERE EMAIL=?";
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
		//	 강퇴 DB에 insert문 쿼리 발생
		public static void insertUsers(ChannelsKickoutModel user) throws SQLException {
			Connection con = null;
			PreparedStatement pstmt = null;
			String query = "insert into channels_kickout values(channels_kickout_id_seq.nextval, ?, ?)";
			try {
				con = DBUtil.getConnection();
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, user.getChannel_name());
				pstmt.setString(2, user.getEmail());
				pstmt.executeUpdate();
			} catch (SQLException s) {
				s.printStackTrace();
				throw s;
			} finally {
				DBUtil.close(pstmt, con);
			}
		}
		// 위에서 강퇴 DB insert문 과정 다음 Delete문 쿼리 발생
		public static void realKick(String channel_name, String email) throws SQLException{
	    	Connection con = null;
			PreparedStatement pstmt = null;
			String query = "delete from channels_join where channel_name = ? and channel_email = ?";
			try {
				con = DBUtil.getConnection();
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, channel_name);
				pstmt.setString(2, email);
				pstmt.executeQuery();
			} catch (SQLException s) {
				s.printStackTrace();
				throw s;
			} finally {
				DBUtil.close(pstmt, con);
			}
		}
		//	 나가기 버튼을 눌렀을 때 delete 쿼리 발생
		public static void channelsKick(String channel_name) throws SQLException{
	    	Connection con = null;
			PreparedStatement pstmt = null;
			String query = "DELETE FROM CHANNELS_KICKOUT WHERE CHANNEL_NAME = ?";
			try {
				con = DBUtil.getConnection();
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, channel_name);
				pstmt.executeQuery();
			} catch (SQLException s) {
				s.printStackTrace();
				throw s;
			} finally {
				DBUtil.close(pstmt, con);
			}
		}
	}
