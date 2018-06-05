package com.keychat.dao.base;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.keychat.controller.util.DBUtil;
import com.keychat.dto.base.UsersJoinChannelsJoinModel;


public class UsersJoinChannelsJoin {
////select a.nickname from users a join channels_join b on ( a.email = b.email ) where b.channel_name = ? group by a.nickname;
	public static ArrayList<String> anonymCheck2(UsersJoinChannelsJoinModel user) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select a.nickname from users a join channels_join b on ( a.email = b.email ) where b.channel_name = ? group by a.nickname'";
		ArrayList<String> list = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, user.getChannel_name());
			rset = pstmt.executeQuery();
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
