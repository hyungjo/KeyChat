package com.keychat.dao.base;

import com.keychat.controller.util.DBUtil;
import com.keychat.dto.base.UsersModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersDao {
	// USERS 테이블에서 NICKNAME과 PHONE으로 EMAIL을 출력한다 insert(CustomerVo cvo).
	public static ArrayList<String> findEmail(UsersModel user) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT EMAIL FROM USERS WHERE NICKNAME=? AND PHONE=?";
		ArrayList<String> list = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, user.getNickname());
			pstmt.setString(2, user.getPhone());
			pstmt.executeQuery();
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
	// USERS 테이블에서 NICKNAME과 PHONE, EMAIL으로 PASSWORD를 업데이트한다.
	public static void updatePassword(UsersModel user) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "UPDATE USERS SET PASSWORD = ? WHERE EMAIL=? and PHONE= ?";
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, user.getPassword());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, user.getPhone());
			pstmt.executeQuery();
		} catch (SQLException s) {
			s.printStackTrace();
			throw s;
		} finally {
			DBUtil.close(pstmt, con);
		}
	}
	// USERS 테이블에서 EMAIL과 PASSWORD으로 로그인을 한다.
	public static ArrayList<String> login(UsersModel user) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT NICKNAME FROM USERS WHERE EMAIL=? AND PASSWORD=?";
		ArrayList<String> list = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, user.getEmail());
			pstmt.setString(2, user.getPassword());
			pstmt.executeQuery();
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
	// USERS테이블에 모든 정보를 출력한다.
	public static ArrayList getUsers() throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList allList = new ArrayList();
		String sql = "SELECT * FROM USERS";
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				allList.add(new UsersModel(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4),rset.getString(5)));
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			throw sqle;
		} finally {
			DBUtil.close(rset, pstmt, conn);
		}
		return allList;
	}

	// USERS테이블에서 현재의 EMAIL을 찾아 PASSWORD를 변경한다.
	public static void changePassword(UsersModel user) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "UPDATE USERS SET PASSWORD=? WHERE EMAIL=?";
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, user.getPassword());
			pstmt.setString(2, user.getEmail());
			pstmt.executeQuery();
		} catch (SQLException s) {
			s.printStackTrace();
			throw s;
		} finally {
			DBUtil.close(pstmt, con);
		}
	}

	// USERS테이블에서 현재의 EMAIL을 찾아서 현재 NICKNAME을 변경하고자 하는임시 NICKNAME으로 변경한다.
	public static void changeNickname(UsersModel user) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "UPDATE USERS SET NICKNAME=? WHERE EMAIL=? AND PASSWORD=?";
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, user.getNickname());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, user.getPassword());
			pstmt.executeQuery();
		} catch (SQLException s) {
			s.printStackTrace();
			throw s;
		} finally {
			DBUtil.close(pstmt, con);
		}
	}
	// USERS테이블에서 현재의 EMAIL을 찾아 JOB을 변경한다.
	public static void changeJob(UsersModel user) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "UPDATE USERS SET JOB=? WHERE EMAIL=?";
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, user.getJob());
			pstmt.setString(2, user.getEmail());
			pstmt.executeQuery();
		} catch (SQLException s) {
			s.printStackTrace();
			throw s;
		} finally {
			DBUtil.close(pstmt, con);
		}
	}
	// USERS테이블에서 현재의 EMAIL을 찾아서 현재 PHONE을 변경하고자 하는임시 PHONE 으로 변경한다.
	public static void changePhone(UsersModel user) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "UPDATE USERS SET PHONE=? WHERE EMAIL=? AND PASSWORD=?";
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, user.getPhone());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, user.getPassword());
			pstmt.executeQuery();
		} catch (SQLException s) {
			s.printStackTrace();
			throw s;
		} finally {
			DBUtil.close(pstmt, con);
		}
	}
	// USERS테이블에서 현재의 EMAIL을 찾아 회원을 탈퇴 한다.
    public static boolean dropUser(UsersModel usersModel){
    	Connection con = null;
		PreparedStatement pstmt = null;
		String query = "DELETE FROM USERS WHERE EMAIL=?";
		boolean success = false;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, usersModel.getEmail());
			pstmt.executeUpdate();
			success = true;
		} catch (SQLException s) {
			s.printStackTrace();
		} finally {
			DBUtil.close(pstmt, con);
		}

		return success;
	}

	// USERS 테이블에 EMAIL, PASSWORD, NICKNAME, JOB, PHONE을 추가한다. 회원가입
	public static boolean createUser(UsersModel usersModel) {
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean success = false;
		String query = "INSERT INTO USERS VALUES (? ,? ,? ,?, ?)";
		System.out.println(usersModel);
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, usersModel.getEmail());
			pstmt.setString(2, usersModel.getPassword());
			pstmt.setString(3, usersModel.getNickname());
			pstmt.setString(4, usersModel.getJob());
			pstmt.setString(5, usersModel.getPhone());
			pstmt.executeUpdate();
			success = true;
		} catch (SQLException s) {
			s.printStackTrace();
		} finally {
			DBUtil.close(pstmt, con);
		}

		return success;
	}

	public static boolean isExistUser(UsersModel usersModel) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "SELECT EMAIL FROM USERS WHERE EMAIL=?";
		boolean success = false;
		int rowCount = 0;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, usersModel.getEmail());
			ResultSet rset = pstmt.executeQuery();
			if(rset.next()){
				String existUser = rset.getString(1);
				if(existUser != null || !existUser.equals(""))
					success = true;
			}
		} catch (SQLException s) {
			s.printStackTrace();
		} finally {
			DBUtil.close(pstmt, con);
		}

		return success;
	}

    public static boolean isExistNickname(UsersModel usersModel) {
        Connection con = null;
        PreparedStatement pstmt = null;
        String query = "SELECT NICKNAME FROM USERS WHERE NICKNAME=?";
        boolean success = false;
        int rowCount = 0;

        try {
            con = DBUtil.getConnection();
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, usersModel.getNickname());
            ResultSet rset = pstmt.executeQuery();
            if(rset.next()){
                String existUser = rset.getString(1);
                if(existUser != null || !existUser.equals(""))
                    success = true;
            }
        } catch (SQLException s) {
            s.printStackTrace();
        } finally {
            DBUtil.close(pstmt, con);
        }

        return success;
    }

	public static boolean isExactPassword(UsersModel usersModel) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "SELECT PASSWORD FROM USERS WHERE EMAIL=? AND PASSWORD=?";
		boolean success = false;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, usersModel.getEmail());
			pstmt.setString(2, usersModel.getPassword());
			ResultSet rset = pstmt.executeQuery();
			if(rset.next()){
				String existUser = rset.getString(1);
				if(existUser != null)
					success = true;
			}
		} catch (SQLException s) {
			s.printStackTrace();
		} finally {
			DBUtil.close(pstmt, con);
		}

		return success;
	}

	public static boolean updateUser(UsersModel user) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "UPDATE USERS SET PASSWORD = ?, PHONE = ?, JOB = ? WHERE EMAIL = ?";
		boolean success = false;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, user.getPassword());
			pstmt.setString(2, user.getPhone());
			pstmt.setString(3, user.getJob());
			pstmt.setString(4, user.getEmail());
			int updateRowCount = pstmt.executeUpdate();
			if(updateRowCount >= 1) {
				success = true;
				System.out.println("Updated User.");
			}
		} catch (SQLException s) {
			s.printStackTrace();
		} finally {
			DBUtil.close(pstmt, con);
		}

		return success;
	}

	public static UsersModel getUser(UsersModel usersModel) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "SELECT * FROM USERS WHERE EMAIL = ?";
		UsersModel existUser = null;
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, usersModel.getEmail());
			rset = pstmt.executeQuery();
			if (rset.next()) {
				existUser = new UsersModel(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4),rset.getString(5));
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			DBUtil.close(rset, pstmt, conn);
		}
		return existUser;
	}
}
