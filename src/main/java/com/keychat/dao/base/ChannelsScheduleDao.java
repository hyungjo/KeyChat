package com.keychat.dao.base;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.keychat.controller.util.DBUtil;
import com.keychat.dto.base.ChannelsMemoModel;
import com.keychat.dto.base.ChannelsScheduleModel;

public class ChannelsScheduleDao {
	//	 메모 삭제시 년도를 비교해서 delete문 쿼리 발생
	public static void dropChannelsSchedule(String channel_name, String schedule_name) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "delete from channels_schedule where channel_name = ? and schedule_name = ?";
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, channel_name);
			pstmt.setString(2, schedule_name);
			pstmt.executeUpdate();
		} catch (SQLException s) {
			s.printStackTrace();
			throw s;
		} finally {
			DBUtil.close(pstmt, con);
		}
	}
	//메모 생성시 insert문 쿼리 발생
	public static void insertSchedule(ChannelsScheduleModel user) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "insert into channels_schedule values(channels_schedule_id_seq.nextval, ?, ?, ?, ?, ?)";
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, user.getSchedule_name());
			pstmt.setString(2, user.getChannel_name());
			pstmt.setString(3, user.getEmail());
			pstmt.setDate(4, user.getStart_datetime());
			pstmt.setDate(5, user.getEnd_datetime());
			pstmt.executeUpdate();
		} catch (SQLException s) {
			s.printStackTrace();
			throw s;
		} finally {
			DBUtil.close(pstmt, con);
		}
	}
	//일정 선택 후 메모 수정시 update문 쿼리 발생
	public static void updateSchedule(ChannelsScheduleModel user) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "update channels_schedule set schedule_name = ?, start_datetime = ?, end_datetime =? where schedule_name = ? and channels_name = ? and email = ?";
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, user.getSchedule_name());
			pstmt.setDate(2, user.getStart_datetime());
			pstmt.setDate(3, user.getEnd_datetime());
			pstmt.setString(4, user.getSchedule_name());
			pstmt.setString(5, user.getChannel_name());
			pstmt.setString(6, user.getEmail());
			pstmt.executeQuery();
		} catch (SQLException s) {
			s.printStackTrace();
			throw s;
		} finally {
			DBUtil.close(pstmt, con);
		}
	}
	//Channels_schedule테이블에서 channels_name을 검색한다.
	public static ArrayList<String> selectSchedule(ChannelsScheduleModel user) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select channels_schedule from where schedule_name = ?";
		ArrayList<String> list = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, user.getSchedule_name());
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