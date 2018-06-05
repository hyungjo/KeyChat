package com.keychat.dao.base;

import com.keychat.controller.util.DBUtil;
import com.keychat.dto.base.UsersModel;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The interface Users dao.
 */
public interface UsersDao {
	// USERS 테이블에서 NICKNAME과 PHONE으로 EMAIL을 출력한다 insert(CustomerVo cvo).
	public static ArrayList<String> findEmail(UsersModel user) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT EMAIL FROM USERS WHERE NICKNAME=? AND PHONE=?";
		ArrayList<String> list = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, user.getNicname());
			pstmt.setString(2, user.getPhone());
			pstmt.executeQuery();
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
	// USERS 테이블에서 NICKNAME과 PHONE, EMAIL으로 PASSWORD를 업데이트한다.
	public static void updatePassword(UsersModel user) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "UPDATE USERS SET PASSWORD = ? WHERE EMAIL=? and PHONE= ?";
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, user.getPassword());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, user.getPhone());
			pstmt.executeQuery();
		} catch (SQLException s) {
			s.printStackTrace();
			throw s;
		} finally {
			DBUtil.close(pstmt, con);
		}
	}
	// USERS 테이블에서 EMAIL과 PASSWORD으로 로그인을 한다.
	public static ArrayList<String> login(UsersModel user) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT NICKNAME FROM USERS WHERE EMAIL=? AND PASSWORD=?";
		ArrayList<String> list = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, user.getEmail());
			pstmt.setString(2, user.getPassword());
			pstmt.executeQuery();
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
	// USERS테이블에 모든 정보를 출력한다.
	public static ArrayList getUsers() throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList allList = new ArrayList();
		String sql = "SELECT * FROM USERS";
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				allList.add(new UsersModel(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4),rset.getString(5)));
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			throw sqle;
		} finally {
			DBUtil.close(rset, pstmt, conn);
		}
		return allList;
	}

	// USERS테이블에서 현재의 EMAIL을 찾아 PASSWORD를 변경한다.
	public static void changePassword(UsersModel user) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "UPDATE USERS SET PASSWORD=? WHERE EMAIL=?";
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, user.getPassword());
			pstmt.setString(2, user.getEmail());
			pstmt.executeQuery();
		} catch (SQLException s) {
			s.printStackTrace();
			throw s;
		} finally {
			DBUtil.close(pstmt, con);
		}
	}

	// USERS테이블에서 현재의 EMAIL을 찾아서 현재 NICKNAME을 변경하고자 하는임시 NICKNAME으로 변경한다.
	public static void changeNickname(UsersModel user) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "UPDATE USERS SET NICKNAME=? WHERE EMAIL=? AND PASSWORD=?";
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, user.getNicname());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, user.getPassword());
			pstmt.executeQuery();
		} catch (SQLException s) {
			s.printStackTrace();
			throw s;
		} finally {
			DBUtil.close(pstmt, con);
		}
	}
	// USERS테이블에서 현재의 EMAIL을 찾아 JOB을 변경한다.
	public static void changeJob(UsersModel user) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "UPDATE USERS SET JOB=? WHERE EMAIL=?";
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, user.getJob());
			pstmt.setString(2, user.getEmail());
			pstmt.executeQuery();
		} catch (SQLException s) {
			s.printStackTrace();
			throw s;
		} finally {
			DBUtil.close(pstmt, con);
		}
	}
	// USERS테이블에서 현재의 EMAIL을 찾아서 현재 PHONE을 변경하고자 하는임시 PHONE 으로 변경한다.
	public static void changePhone(UsersModel user) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "UPDATE USERS SET PHONE=? WHERE EMAIL=? AND PASSWORD=?";
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, user.getPhone());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, user.getPassword());
			pstmt.executeQuery();
		} catch (SQLException s) {
			s.printStackTrace();
			throw s;
		} finally {
			DBUtil.close(pstmt, con);
		}
	}
	// USERS테이블에서 현재의 EMAIL을 찾아 회원을 탈퇴 한다.
    public static void dropUsers(String em) throws SQLException{
    	Connection con = null;
		PreparedStatement pstmt = null;
		String query = "DELETE FROM USERS WHERE EMAIL=?";
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, em);
			pstmt.executeQuery();
		} catch (SQLException s) {
			s.printStackTrace();
			throw s;
		} finally {
			DBUtil.close(pstmt, con);
		}
	}
	// USERS 테이블에 EMAIL, PASSWORD, NICKNAME, JOB, PHONE을 추가한다. 회원가입
	public static void insertUsers(UsersModel user) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "INSERT INTO USERS VALUES (? ,? ,? ,?, ?)";
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, user.getEmail());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getNicname());
			pstmt.setString(4, user.getJob());
			pstmt.setString(5, user.getPhone());
			pstmt.executeUpdate();
		} catch (SQLException s) {
			s.printStackTrace();
			throw s;
		} finally {
			DBUtil.close(pstmt, con);
		}
	}
}
