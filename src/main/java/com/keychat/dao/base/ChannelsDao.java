package com.keychat.dao.base;

import java.sql.*;
import java.util.ArrayList;

import com.keychat.controller.util.DBUtil;
import com.keychat.dto.base.ChannelJoinAuthModel;
import com.keychat.dto.base.ChannelsJoinModel;
import com.keychat.dto.base.ChannelsModel;
import com.sun.org.apache.bcel.internal.generic.Type;

/**
 * The interface Channels dao.
 */
public class ChannelsDao {
    // CHANNELS에서 LEADER을 찾아 회원을 탈퇴 한다.

    public static boolean dropChannel(ChannelsModel channelsModel) {
        Connection con = null;
        PreparedStatement pstmt = null;
        String query = "DELETE FROM CHANNELS WHERE NAME=? AND LEADER=?";
        int deleteRowCount = 0;
        boolean success = false;

        try {
            con = DBUtil.getConnection();
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, channelsModel.getName());
            pstmt.setString(2, channelsModel.getLeader());
            deleteRowCount = pstmt.executeUpdate();
            if (deleteRowCount >= 1)
                success = true;
        } catch (SQLException s) {
            s.printStackTrace();
        } finally {
            DBUtil.close(pstmt, con);
        }

        return success;

    }

    // CHANNELS테이블에 NAME이 있는지 검색한다.
    public static ArrayList<ChannelsModel> searchChannelsByName(ChannelsModel channelsModel) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String query = "SELECT * FROM CHANNELS WHERE NAME LIKE ?";
        ArrayList<ChannelsModel> list = new ArrayList<>();
        try {
            con = DBUtil.getConnection();
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, "%" + channelsModel.getName() + "%");
            rset = pstmt.executeQuery();
            while (rset.next()) {
                list.add(new ChannelsModel(
                        rset.getString(1),
                        rset.getString(2),
                        rset.getString(3),
                        rset.getInt(4),
                        rset.getInt(5),
                        rset.getString(6),
                        rset.getTimestamp(7)
                ));
            }
        } catch (SQLException s) {
            s.printStackTrace();
        } finally {
            DBUtil.close(pstmt, con);
        }
        return list;
    }

    public static boolean isChannelAnonym(ChannelJoinAuthModel channelsModel) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        boolean success = false;
        String query = "SELECT LIMIT_ANONYM FROM CHANNELS WHERE NAME=?";
        try {
            con = DBUtil.getConnection();
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, channelsModel.getChannelName());
            rset = pstmt.executeQuery();
            if (rset.next()) {
                if(rset.getString(1).equals("T"))
                    success = true;
            }
        } catch (SQLException s) {
            s.printStackTrace();
        } finally {
            DBUtil.close(pstmt, con);
        }
        return success;
    }

    public static boolean isChannelPassword(ChannelJoinAuthModel channelsModel) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        boolean success = false;
        String query = "SELECT * FROM CHANNELS WHERE NAME=? AND PASSWORD IS NOT NULL";
        try {
            con = DBUtil.getConnection();
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, channelsModel.getChannelName());
            rset = pstmt.executeQuery();
            if (rset.next()) {
                success = true;
            }
        } catch (SQLException s) {
            s.printStackTrace();
        } finally {
            DBUtil.close(pstmt, con);
        }
        return success;
    }

    // CHANNELS에 NAME, PASSWORD, LIMIT_CAPACITY, LIMIT_TIME, LIMIT_ANONYM을 추가한다.
    public static boolean createChannel(ChannelsModel channelsModel) {
        Connection con = null;
        PreparedStatement pstmt = null;
        String query = "INSERT INTO CHANNELS VALUES (?, ?, ?, ?, ?, ?, ?)";
        boolean success = false;
        int createdRow = 0;
        try {
            con = DBUtil.getConnection();
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, channelsModel.getName());
            pstmt.setString(2, channelsModel.getLeader());
            if(channelsModel.getPassword() == null)
                pstmt.setString(3, null);
            else
                pstmt.setString(3, channelsModel.getPassword());
            pstmt.setInt(4, channelsModel.getLimitCapacity());
            pstmt.setInt(5, channelsModel.getLimitTime());
            pstmt.setString(6, channelsModel.getLimitAnonym());
            pstmt.setString(7, channelsModel.getCreatedDatetime().toString());
            createdRow = pstmt.executeUpdate();
            if (createdRow >= 1)
                success = true;
        } catch (SQLException s) {
            s.printStackTrace();
        } finally {
            DBUtil.close(pstmt, con);
        }

        return success;
    }

    public static boolean isExistChannel(ChannelsModel channelsModel) {
        Connection con = null;
        PreparedStatement pstmt = null;
        String query = "SELECT NAME FROM CHANNELS WHERE NAME=?";
        boolean success = false;

        try {
            con = DBUtil.getConnection();
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, channelsModel.getName());
            ResultSet rset = pstmt.executeQuery();
            if (rset.getRow() >= 1)
                success = true;
        } catch (SQLException s) {
            s.printStackTrace();
        } finally {
            DBUtil.close(pstmt, con);
        }

        return success;
    }

    public static ChannelsModel getChannelInfoByName(String channelName) {
        Connection con = null;
        PreparedStatement pstmt = null;
        String query = "SELECT * FROM CHANNELS WHERE NAME=?";
        ChannelsModel channelsModel1 = null;

        try {
            con = DBUtil.getConnection();
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, channelName);
            ResultSet rset = pstmt.executeQuery();
            if (rset.next()) {
                channelsModel1 = new ChannelsModel(rset.getString(1),
                        rset.getString(2),
                        rset.getString(3),
                        rset.getInt(4),
                        rset.getInt(5),
                        rset.getString(6),
                        rset.getTimestamp(7)
                );
            }
        } catch (SQLException s) {
            s.printStackTrace();
        } finally {
            DBUtil.close(pstmt, con);
        }

        return channelsModel1;
    }

    public static ArrayList<ChannelsModel> getChannelsInfo() {
        Connection con = null;
        PreparedStatement pstmt = null;
        String query = "SELECT * FROM CHANNELS";
        ArrayList<ChannelsModel> channelsModel1List = new ArrayList<>();

        try {
            con = DBUtil.getConnection();
            pstmt = con.prepareStatement(query);
            ResultSet rset = pstmt.executeQuery();
            while (rset.next()) {
                channelsModel1List.add(new ChannelsModel(
                        rset.getString(1),
                        rset.getString(2),
                        rset.getString(3),
                        rset.getInt(4),
                        rset.getInt(5),
                        rset.getString(6),
                        rset.getTimestamp(7)
                ));
            }
        } catch (SQLException s) {
            s.printStackTrace();
        } finally {
            DBUtil.close(pstmt, con);
        }

        return channelsModel1List;
    }

    // LEADER로 검색해서 CHANNELS테이블에서 NAME을 CREATED_DATETIME을 내림차순으로 출력한다.
    public static ArrayList<String> nameCreatedDesc(ChannelsModel user) throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String query = "SELECT NAME FROM CHANNELS WHERE LEADER=? ORDER BY CREATED_DATETIME DESC";
        ArrayList<String> list = new ArrayList<String>();
        try {
            con = DBUtil.getConnection();
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, user.getLeader());
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

    // where 절에 모든 조건을 만족하면 update문 쿼리 발생 (방장만 수정 가능)
    public static void updateRoom(ChannelsModel user) throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        String query = "UPDATE CHANNELS SET NAME = ?, PASSWORD = ?, LIMIT_CAPACITY = ? WEHRE NAME = ?";
        try {
            con = DBUtil.getConnection();
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getPassword());
            pstmt.setInt(3, user.getLimitCapacity());
            pstmt.setString(4, user.getName());
            pstmt.executeQuery();
        } catch (SQLException s) {
            s.printStackTrace();
            throw s;
        } finally {
            DBUtil.close(pstmt, con);
        }
    }

    // CHANNELS TABLE에 LIMIT_ANONYM 칼람명 값만 조회한다.
    public static String findLimitAnonym(String name) throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String list = null;
        String query = "SELECT LIMIT_ANONYM FROM CHANNELS WHERE NAME=?";
        try {
            con = DBUtil.getConnection();
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, name);
            rset = pstmt.executeQuery();
            while (rset.next()) {
                list = rset.getString(1);
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            throw sqle;
        } finally {
            DBUtil.close(rset, pstmt, con);
        }
        return list;
    }

    // 최근순 출력
    public static ArrayList<ChannelsModel> descCreated() throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        ArrayList<ChannelsModel> allList = new ArrayList<ChannelsModel>();
        String sql = "select * from channels order by created_datetime";
        try {
            conn = DBUtil.getConnection();
            pstmt = conn.prepareStatement(sql);
            rset = pstmt.executeQuery();
            while (rset.next()) {
                allList.add(new ChannelsModel(rset.getString(1), rset.getString(2), rset.getString(3), rset.getInt(4),
                        rset.getInt(5), rset.getString(6), rset.getTimestamp(7)));
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            throw sqle;
        } finally {
            DBUtil.close(rset, pstmt, conn);
        }
        return allList;
    }

    public static boolean isChannelAuthUser(ChannelJoinAuthModel channelJoinAuthModel) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        boolean success = false;
        System.out.println(channelJoinAuthModel.getChannelName() + " " + channelJoinAuthModel.getPassword());
        String query = "SELECT * FROM CHANNELS WHERE NAME = ? AND PASSWORD = ?";
        try {
            con = DBUtil.getConnection();
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, channelJoinAuthModel.getChannelName());
            pstmt.setString(2, channelJoinAuthModel.getPassword());
            rset = pstmt.executeQuery();
            if(rset.next())
                success = true;
        } catch (SQLException s) {
            s.printStackTrace();
        } finally {
            DBUtil.close(pstmt, con);
        }
        return success;
    }
    // 조회 후 if 조건식으로 T일 경우 익명 테이블 생성 / F일 경우 익명 테이블 거치지 않고 방 생성

    /*
     * public static void insertAnonym(ChannelsDto user) throws SQLException {
     * Connection con = null; PreparedStatement pstmt = null; boolean String query =
     * "insert into channels(limit_anonym) values(?, ?, ?, ?, ?, 'T', ?)"; boolean
     * String query2 =
     * "insert into channels(limit_anonym) values(?, ?, ?, ?, ?, 'F', ?)"; try { con
     * = DBUtil.getConnection(); pstmt = con.prepareStatement(query);
     * pstmt.setString(1, user.getName()); pstmt.setInt(2, user.getPassword());
     * pstmt.setInt(3, user.getLimit_capacity()); pstmt.setInt(4,
     * user.getLimit_time()); pstmt.setInt(5, user.getLimit_anonym());
     * pstmt.executeUpdate(); } catch (SQLException s) { s.printStackTrace(); throw
     * s; } finally { DBUtil.close(pstmt, con); } }
     */
}