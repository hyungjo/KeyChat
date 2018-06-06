package com.keychat.dao.base;

import com.keychat.controller.util.DBUtil;
import com.keychat.dto.base.ChannelsJoinModel;
import com.keychat.dto.base.ChannelsModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The interface Channels dao.
 */
public class ChannelsDao {
	// CHANNELS에서 LEADER을 찾아 회원을 탈퇴 한다.
	public static void dropChannels(String email) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "DELETE FROM CHANNELS WHERE LEADER=?";
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

	// CHANNELS테이블에 NAME이 있는지 검색한다.
	public static ArrayList<String> searchChannelsName(ChannelsModel user) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT NAME FROM CHANNELS WHERE NICKNAME=?";
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

	// CHANNELS에 NAME, PASSWORD, LIMIT_CAPACITY, LIMIT_TIME, LIMIT_ANONYM을 추가한다.
	public static void insertChannel(ChannelsModel user) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "INSERT INTO CHANNELS VALUES (? ,? ,? ,?, ?)";
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, user.getName());
			pstmt.setInt(2, user.getPassword());
			pstmt.setInt(3, user.getLimit_capacity());
			pstmt.setInt(4, user.getLimit_time());
			pstmt.setInt(5, user.getLimit_anonym());
			pstmt.executeUpdate();
		} catch (SQLException s) {
			s.printStackTrace();
			throw s;
		} finally {
			DBUtil.close(pstmt, con);
		}
	}

	// LEADER로 검색해서 CHANNELS테이블에서 NAME을 CREATED_DATETIME을 내림차순으로 출력한다.
	public static ArrayList<String> nameCreatedDesc(ChannelsModel user) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT NAME FROM CHANNELS WHERE LEADER=? ORDER BY CREATED_DATETIME DESC";
		ArrayList<String> list = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, user.getLeader());
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

	// where 절에 모든 조건을 만족하면 update문 쿼리 발생 (방장만 수정 가능)
	public static void updateRoom(ChannelsModel user) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "UPDATE CHANNELS SET NAME = ?, PASSWORD = ?, LIMIT_CAPACITY = ? WEHRE NAME = ?";
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, user.getName());
			pstmt.setInt(2, user.getPassword());
			pstmt.setInt(3, user.getLimit_capacity());
			pstmt.setString(4, user.getName());
			pstmt.executeQuery();
		} catch (SQLException s) {
			s.printStackTrace();
			throw s;
		} finally {
			DBUtil.close(pstmt, con);
		}
	}

	// CHANNELS TABLE에 LIMIT_ANONYM 칼람명 값만 조회한다.
	public static ArrayList<ChannelsModel> findLimitAnonym() throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<ChannelsModel> allList = new ArrayList<ChannelsModel>();
		String sql = "select limit_anonym from channels";
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				allList.add(new ChannelsModel(rset.getString(1), rset.getString(2), rset.getInt(3), rset.getInt(4),
						rset.getInt(5), rset.getInt(6), rset.getDate(7)));
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			throw sqle;
		} finally {
			DBUtil.close(rset, pstmt, conn);
		}
		return allList;
	}

	// 최근순 출력
	public static ArrayList<ChannelsModel> descCreated() throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<ChannelsModel> allList = new ArrayList<ChannelsModel>();
		String sql = "select * from channels order by created_datetime";
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				allList.add(new ChannelsModel(rset.getString(1), rset.getString(2), rset.getInt(3), rset.getInt(4),
						rset.getInt(5), rset.getInt(6), rset.getDate(7)));
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			throw sqle;
		} finally {
			DBUtil.close(rset, pstmt, conn);
		}
		return allList;
	}

	// 조회 후 if 조건식으로 T일 경우 익명 테이블 생성 / F일 경우 익명 테이블 거치지 않고 방 생성

	/*
	 * public static void insertAnonym(ChannelsDto user) throws SQLException {
	 * Connection con = null; PreparedStatement pstmt = null; boolean String query =
	 * "insert into channels(limit_anonym) values(?, ?, ?, ?, ?, 'T', ?)"; boolean
	 * String query2 =
	 * "insert into channels(limit_anonym) values(?, ?, ?, ?, ?, 'F', ?)"; try { con
	 * = DBUtil.getConnection(); pstmt = con.prepareStatement(query);
	 * pstmt.setString(1, user.getName()); pstmt.setInt(2, user.getPassword());
	 * pstmt.setInt(3, user.getLimit_capacity()); pstmt.setInt(4,
	 * user.getLimit_time()); pstmt.setInt(5, user.getLimit_anonym());
	 * pstmt.executeUpdate(); } catch (SQLException s) { s.printStackTrace(); throw
	 * s; } finally { DBUtil.close(pstmt, con); } }
	 */
}