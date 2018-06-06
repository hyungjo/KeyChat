package com.keychat.dao.base;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.keychat.controller.util.DBUtil;
import com.keychat.dto.base.ChannelsAnonymModel;
import com.keychat.dto.base.UsersModel;

public class ChannelsAnonymDao {
	// CHANNELS_ANONYM에서 EMAIL을 찾아 회원을 탈퇴 한다.
	public static void dropChannelsAnonym(String email) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "DELETE FROM CHANNELS_ANONYM WHERE EMAIL=?";
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

	// 조회 후 if 조건식으로 T일 경우 익명 테이블 생성 / F일 경우 익명 테이블 거치지 않고 방 생성
	public static void insertAnonym(ChannelsAnonymModel user) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "insert into channels_anonym values(?, ?, ?)";
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, user.getChannels_anonym_id());
			pstmt.setString(2, user.getAnonym_name()/* +Math.random()*(1~n) */);
			pstmt.setString(3, user.getEmail());
			pstmt.executeUpdate();
		} catch (SQLException s) {
			s.printStackTrace();
			throw s;
		} finally {
			DBUtil.close(pstmt, con);
		}
	}
}
