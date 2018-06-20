package com.keychat.dao.base;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.keychat.controller.util.DBUtil;
import com.keychat.dto.base.ChannelsFileboxModel;


public class ChannelsFileboxDao {
	// CHANNELS_FILEBOX에서 EMAIL을 찾아 회원을 탈퇴 한다.
	public static void dropChannelsFilebox(String email) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "DELETE FROM CHANNELS_FILEBOX WHERE EMAIL=?";
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

	// 업로드시 CHANNELS_FILEBOX TABLE에서 INSERT문 쿼리 발생
	public static boolean insertFile(String email, String file_path, String channel_name) {
		System.out.println(email + " " + file_path + " " + channel_name);
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean success = false;

		String query = "insert into channels_filebox values(channels_filebox_id_seq.nextval, ?, ?, ?)";
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, email);
			pstmt.setString(2, file_path);
			pstmt.setString(3, channel_name);
			pstmt.executeUpdate();
			success = true;
		} catch (SQLException s) {
			s.printStackTrace();
		} finally {
			DBUtil.close(pstmt, con);
		}

		return success;
	}

	// 채널 이름 조회해서 박스에 업로드 된 파일들 보여주기 위해 select문 쿼리 발생
	public static ArrayList<String> selectFile(String channel_name) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select file_path from channels_filebox where channel_name = ?";
		ArrayList<String> list = new ArrayList<>();
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, channel_name);
			System.out.println(channel_name);
			rset =pstmt.executeQuery();
			while (rset.next()) {

				list.add((rset.getString(1)));
			}
		} catch (SQLException s) {
			s.printStackTrace();
			throw s;
		} finally {
			DBUtil.close(pstmt, con);
		}
		return list;
	}

	// where로 파일 경로를 찾은 후 delete문 쿼리 발생
	public static void dropFile(String file_path, String channel_name) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "delete from channels_filebox where file_path = ? and channel_name = ?";
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, file_path);
			pstmt.setString(2, channel_name);
			pstmt.executeUpdate();
		} catch (SQLException s) {
			s.printStackTrace();
			throw s;
		} finally {
			DBUtil.close(pstmt, con);
		}
	}
}