package com.keychat.dao.base;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.keychat.controller.util.DBUtil;
import com.keychat.dto.base.ChannelsJoinJoinChannelsAnonymModel;


public class ChannelsJoinJoinChannelsAnonym {
	//익명 방 생성할 때 익명 리스트를 보여주고 익명 방이 아닌 공개 방일 때 공개 리스트를 조회를해서 사용자에게 정보를 제공해준다.
		public static ArrayList<String> anonymCheck(ChannelsJoinJoinChannelsAnonymModel user) throws SQLException {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			String query = "select b.anonym_name from channels_join a join channels_anonym b on a.channel_name = b.channel_name where b.channel_name = ? group by b.anonym_name";
			ArrayList<String> list = new ArrayList<String>();
			try {
				con = DBUtil.getConnection();
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, user.getChannel_name());
				rset = pstmt.executeQuery();
				while(rset.next()) {
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