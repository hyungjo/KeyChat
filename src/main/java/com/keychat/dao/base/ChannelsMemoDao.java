package com.keychat.dao.base;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.keychat.controller.util.DBUtil;
import com.keychat.dto.base.ChannelsMemoModel;


public class ChannelsMemoDao {
	//CHANNELS_MEMO에서 EMAIL을 찾아 회원을 탈퇴 한다. 
	public static void dropChannelsMemo(String email) throws SQLException{
    	Connection con = null;
		PreparedStatement pstmt = null;
		String query = "DELETE FROM CHANNELS_MEMO WHERE EMAIL=?";
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
	// 메모를 저장할 때 insert문 쿼리 발생
	public static void insertMemo(String email, String contents) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "insert into channels_memo values(channels_memo_id_seq.nextval, ?, ?)";
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, email);
			pstmt.setString(2, contents);
			pstmt.executeUpdate();
		} catch (SQLException s) {
			s.printStackTrace();
			throw s;
		} finally {
			DBUtil.close(pstmt, con);
		}
	}
	// 다른 방에 가 있어도 사라지지 않기 위해 select문으로 조회
	public static ArrayList<String> selectMemo(ChannelsMemoModel user) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select channels_memo from where email = ?";
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