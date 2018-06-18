package com.keychat.dao.base;

import java.sql.*;
import java.util.ArrayList;

import com.keychat.controller.util.DBUtil;
import com.keychat.dto.base.ChannelJoinAuthModel;
import com.keychat.dto.base.ChannelsJoinModel;
import com.keychat.dto.base.ChannelsModel;
import com.keychat.dto.base.UsersModel;

public class ChannelsJoinDao  {
	//CHANNELS_JOIN에서 EMAIL을 찾아 회원을 탈퇴 한다. 
	public static void dropChannelsJoin(String email) throws SQLException{
    	Connection con = null;
		PreparedStatement pstmt = null;
		String query = "DELETE FROM CHANNELS_JOIN WHERE EMAIL=?";
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
	//시청인원순 출력
	public static ArrayList<ChannelsJoinModel> descChannelName() throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<ChannelsJoinModel> allList = new ArrayList<ChannelsJoinModel>();
		String sql = "select * from channels_join order by count(*) desc";
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				allList.add(new ChannelsJoinModel(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getTimestamp(4)));
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			throw sqle;
		} finally {
			DBUtil.close(rset, pstmt, conn);
		}
		return allList;
	}



	public static ArrayList<String> getMyChannels(ChannelsJoinModel channelsJoinModel) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "SELECT * FROM CHANNELS_JOIN WHERE EMAIL = ?";
		ArrayList<String> list = new ArrayList<String>();

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, channelsJoinModel.getEmail());
			ResultSet rset = pstmt.executeQuery();
			while(rset.next()){
				list.add(rset.getString(1));
			}
		} catch (SQLException s) {
			s.printStackTrace();
		} finally {
			DBUtil.close(pstmt, con);
		}
		return list;
	}

	//	EMAIL로 검색해서 CHANNELS_JOIN테이블에서  CHANNEL_NAME을 JOINED_DATETIME을 내림차순으로 출력한다.
	public static ArrayList<String> nameJoinedDesc(ChannelsJoinModel user) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT CHANNEL_NAME FROM CHANNELS_JOIN WHERE EMAIL=? ORDER BY JOINED_DATETIME DESC";
		ArrayList<String> list = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, user.getEmail());
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

	public static boolean joinChannelUser(ChannelJoinAuthModel channelJoinAuthModel, UsersModel usersModel) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "INSERT INTO CHANNELS_JOIN VALUES(CHANNELS_JOIN_ID_SEQ.nextval, ?, ?, systimestamp)";
		boolean success = false;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, channelJoinAuthModel.getChannelName());
			pstmt.setString(2, usersModel.getEmail());
			pstmt.executeUpdate();
			success = true;
		} catch (SQLException s) {
			s.printStackTrace();
		} finally {
			DBUtil.close(pstmt, con);
		}
		return success;
	}

	public static ArrayList<ChannelsModel> getChannelsByUser(UsersModel usersModel) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select channels.name, channels.leader, channels.password, channels.limit_capacity, channels.limit_time, channels.limit_anonym, channels.created_datetime " +
				"from channels, channels_join " +
				"where channels_join.email=? and channels_join.channel_name = channels.name ";

		ArrayList<ChannelsModel> list = new ArrayList<>();

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, usersModel.getEmail());
			rset = pstmt.executeQuery();
			while (rset.next()) {
				list.add(new ChannelsModel(
						rset.getString(1),
						rset.getString(2),
						rset.getString(3),
						rset.getInt(4),
						rset.getInt(5),
						rset.getString(6),
						rset.getTimestamp(7)
				));
			}
		} catch (SQLException s) {
			s.printStackTrace();
		} finally {
			DBUtil.close(pstmt, con);
		}

		return list;
	}

	public static ArrayList<ChannelsModel> getChannelsByLeaderUser(UsersModel usersModel) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from channels where leader = ?";

		ArrayList<ChannelsModel> list = new ArrayList<>();

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, usersModel.getEmail());
			rset = pstmt.executeQuery();
			while (rset.next()) {
				list.add(new ChannelsModel(
						rset.getString(1),
						rset.getString(2),
						rset.getString(3),
						rset.getInt(4),
						rset.getInt(5),
						rset.getString(6),
						rset.getTimestamp(7)
				));
			}
		} catch (SQLException s) {
			s.printStackTrace();
		} finally {
			DBUtil.close(pstmt, con);
		}

		return list;
	}

	public static boolean isExistChannelUser(ChannelJoinAuthModel channelJoinAuthModel, UsersModel usersModel) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "SELECT * FROM CHANNELS_JOIN WHERE CHANNEL_NAME = ? AND EMAIL = ?";
		boolean success = false;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, channelJoinAuthModel.getChannelName());
			pstmt.setString(2, usersModel.getEmail());
			ResultSet rset = pstmt.executeQuery();
			if(rset.next())
				success = true;
		} catch (SQLException s) {
			s.printStackTrace();
		} finally {
			DBUtil.close(pstmt, con);
		}
		return success;
	}
}
