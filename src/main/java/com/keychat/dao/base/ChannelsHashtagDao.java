package com.keychat.dao.base;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.keychat.controller.util.DBUtil;
import com.keychat.dto.base.ChannelsHashtagModel;


public class ChannelsHashtagDao {
	//CHANNELS_HASHTAG에 HASHTAG을 추가한다.
	public static void insertHashtag(ChannelsHashtagModel user) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "INSERT INTO CHANNELS_HASHTAG VALUES (?, ?) ";
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, user.getChannel_name());
			pstmt.setString(2, user.getHashtag());
			pstmt.executeUpdate();
		} catch (SQLException s) {
			s.printStackTrace();
			throw s;
		} finally {
			DBUtil.close(pstmt, con);
		}
	}
	// CHANNLES_HASHTAG 테이블에서 _IDCHANNELS_HASHTAG와 일치하는 CHANNEL_NAME를 검색한다. 
	public static ArrayList<String> searchHashtag(ChannelsHashtagModel user) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "SELECT CHANNEL_NAME FROM CHANNELS_HASHTAG WHERE HASHTAG=?";
		ArrayList<String> list = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, user.getHashtag());
			ResultSet rset = null;
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
	//CHANNELS_HASHTAG 테이블에서 CHANNEL_NAME, HASHTAG를 CHANNEL_NAME 로 출력한다. (검색)
	public static ArrayList<String> findName(ChannelsHashtagModel user) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT CHANNEL_NAME, HASHTAG FROM CHANNELS_HASHTAG where CHANNEL_NAME like '%?%'";
		ArrayList<String> list = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, user.getChannel_name());
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
	//CHANNELS_HASHTAG 테이블에서 CHANNEL_NAME, HASHTAG를 HASHTAG 로 출력한다. (검색)
	public static ArrayList<String> findHashtag(ChannelsHashtagModel user) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT CHANNEL_NAME, HASHTAG FROM CHANNELS_HASHTAG where HASHTAG like '%?%'";
		ArrayList<String> list = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, user.getHashtag());//여기에 or연산....?
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
	//where 절에 모든 조건을 만족하면 update문 쿼리 발생 (방장만 수정 가능)
	public static void updateHashtag(ChannelsHashtagModel user) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "UPDATE CHANNELS_HASHTAG SET HASHTAG = ? WEHRE CHANNEL_NAME = ?";
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, user.getHashtag());
			pstmt.setString(2, user.getChannel_name());
			pstmt.executeQuery();
		} catch (SQLException s) {
			s.printStackTrace();
			throw s;
		} finally {
			DBUtil.close(pstmt, con);
		}
	}
}
