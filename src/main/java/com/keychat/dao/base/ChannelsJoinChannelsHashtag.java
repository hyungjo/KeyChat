package com.keychat.dao.base;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.keychat.controller.util.DBUtil;
import com.keychat.dto.base.ChannelsJoinChannelsHashtagModel;
import com.keychat.dto.base.ChannelsModel;


public class ChannelsJoinChannelsHashtag {
	// 채팅 창에 방 정보를 출력하기 위해서는 SELECT문을 쓴다. (join문 포함)
	public static ArrayList<ChannelsModel> roomSelect(String name) throws SQLException {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			ArrayList<ChannelsModel> allList = new ArrayList<ChannelsModel>();
			String query = "SELECT * FROM CHANNELS WHERE NAME=?";
			try {
				con = DBUtil.getConnection();
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, name);
				rset = pstmt.executeQuery();
				while (rset.next()) {
					allList.add(new ChannelsModel(rset.getString(1), rset.getString(2), rset.getString(3), rset.getInt(4),
							rset.getInt(5), rset.getString(6), rset.getTimestamp(7)));
				}
			} catch (SQLException sqle) {
				sqle.printStackTrace();
				throw sqle;
			} finally {
				DBUtil.close(rset, pstmt, con);
			}
			return allList;
		}
}
