package com.keychat.dao.base;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.keychat.controller.util.DBUtil;
import com.keychat.dto.base.ChannelsAnonymModel;


public class ChannelsAnonymDao {
	// CHANNELS_ANONYM에서 EMAIL을 찾아 회원을 탈퇴 한다.1
		public static void dropChannelsAnonym(String email) throws SQLException{
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
		
	}
