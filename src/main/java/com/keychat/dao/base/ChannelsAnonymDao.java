package com.keychat.dao.base;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.keychat.controller.util.DBUtil;
import com.keychat.dto.base.ChannelsAnonymModel;


public class ChannelsAnonymDao {
	// CHANNELS_ANONYM에서 EMAIL을 찾아 회원을 탈퇴 한다.
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
		//이거어제 너가만든건디 햇갈린다 ㅋㅋㅋㅋㅋㅋ 이건 좀있다가해야겟다 급해서
		public static boolean findLimitAnonym() throws SQLException {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			ArrayList<ChannelsAnonymModel> allList = new ArrayList<ChannelsAnonymModel>();
			int reuslt;
			boolean r = false; // 비활성화
			String sql = "select * from channels";
			try {
				conn = DBUtil.getConnection();
				pstmt = conn.prepareStatement(sql);
				rset = pstmt.executeQuery();
				while (rset.next()) {
					allList.add(new ChannelsAnonymModel(rset.getString(1), rset.getString(2), rset.getInt(3), rset.getInt(4),rset.getInt(5),rset.getInt(6),rset.getDate(7)));
					reuslt = rset.getInt(6);
					if(reuslt == 1) { //  익명 활성화
						r = true;
					}
				}
			} catch (SQLException sqle) {
				sqle.printStackTrace();
				throw sqle;
			} finally {
				DBUtil.close(rset, pstmt, conn);
			}
			return r;
		}
	}
