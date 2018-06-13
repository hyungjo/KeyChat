package com.keychat.dao.base;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.keychat.controller.util.DBUtil;
import com.keychat.dto.base.ChannelsAnonymModel;
import com.keychat.dto.base.ChannelsModel;
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
	public static void insertAnonym(int n, String email) throws SQLException {
//		Connection con = null;
//		PreparedStatement pstmt = null;
//
//		ChannelsModel list = new ChannelsModel();
//		ArrayList<ChannelsModel> alList = ChannelsDao.findLimitAnonym(); // ChannelsDao 자바에 findLimitAnonum() 호출
//		String result = list.getLimit_anonym(); // 조회 후 ChannelsModel에 있는 list.limit_anonym 값을 result에 저장
//		String query_insert = "insert into channels_anonym values(channels_anonym_id_seq.nextval, ?, ?)"; // 쿼리문 작성
//
//		if (result.equals('T')) { // 익명 방이 맞으면
//			try {
//				con = DBUtil.getConnection();
//				pstmt = con.prepareStatement(query_insert);
//				pstmt.setString(1, "Anonymity" + n); // n -> 랜덤 숫자 (servlet으로 무작위로 뽑은 후 전송)
//				pstmt.setString(2, email);
//				pstmt.executeUpdate();
//			} catch (SQLException s) {
//				s.printStackTrace();
//				throw s;
//			} finally {
//				DBUtil.close(pstmt, con);
//			}
//		}
//
//		if (result.equals('F')) { // 익명 방이 아니면
//			try {
//				con = DBUtil.getConnection();
//				pstmt = con.prepareStatement(query_insert);
//				pstmt.setString(1, "Anonymity" + n); // n -> 랜덤 숫자 (servlet으로 무작위로 뽑은 후 전송)
//				pstmt.setString(2, email);
//				pstmt.executeUpdate();
//			} catch (SQLException s) {
//				s.printStackTrace();
//				throw s;
//			} finally {
//				DBUtil.close(pstmt, con);
//			}
//		}
	}
}
