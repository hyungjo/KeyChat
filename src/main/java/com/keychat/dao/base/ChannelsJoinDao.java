package com.keychat.dao.base;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.keychat.controller.util.DBUtil;
import com.keychat.dto.base.ChannelsJoinModel;


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
	
	public static void descChannelName(ChannelsJoinModel user) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "select channel_name, count(*) from channels_join group by channel_name order by count(*) desc";
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.executeQuery();
		} catch (SQLException s) {
			s.printStackTrace();
			throw s;
		} finally {
			DBUtil.close(pstmt, con);
		}
	}
	//최근순 출력
	public static ArrayList<String> descCreated(ChannelsJoinModel user) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select name, created_datetime from channels order by CREATED_DATETIME";
		ArrayList<String> list = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(query);
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
}
