package com.boot2.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.boot2.dao.UserDAO;
import com.boot2.servlet.InitServlet;
import com.boot2.vo.UserInfoVO;

public class UserDAOImpl implements UserDAO {
	
	@Override
	public int insertUser(UserInfoVO user) {
		
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = "insert into user_info(\r\n" + 
				"ui_num, ui_id, ui_name, ui_age, ui_birth, ui_pwd, ui_phone, ui_email, ui_nickname, ui_credat)\r\n" + 
				"values(\r\n" + 
				"sqe_ui_num.nextval,?,?,?,?,?,?,?,?,sysdate)";
		
		
		
		try {
			con = InitServlet.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1,user.getUi_id());
			ps.setString(2,user.getUi_name());
			ps.setInt(3,user.getUi_age());
			ps.setString(4,user.getUi_birth());
			ps.setString(5,user.getUi_pwd());
			ps.setString(6,user.getUi_phone());
			ps.setString(7,user.getUi_email());
			ps.setString(8,user.getUi_nickname());
			int result = ps.executeUpdate();
			con.commit();
			return result;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			InitServlet.close(ps, con);
		}
		
		return 0;
	}

	@Override
	public int deleteUser(UserInfoVO user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateUser(UserInfoVO user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UserInfoVO selectUser(UserInfoVO user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserInfoVO> selectUserList(UserInfoVO user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserInfoVO selectUserForLogin(UserInfoVO user) {
		String sql= "select * from user_info where ui_id=? and ui_pwd=?";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null; 
		
		try {
			con = InitServlet.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getUi_id());
			ps.setString(2, user.getUi_pwd());
			rs = ps.executeQuery();
			
			if(rs.next()) {
				UserInfoVO ui =  new UserInfoVO();
				ui.setUi_num(rs.getInt("ui_num"));
				ui.setUi_id(rs.getString("ui_id"));
				ui.setUi_name(rs.getString("ui_name"));
				ui.setUi_age(rs.getInt("ui_age"));
				ui.setUi_birth(rs.getString("ui_birth"));
				ui.setUi_pwd(rs.getString("ui_pwd"));
				ui.setUi_phone(rs.getString("ui_phone"));
				ui.setUi_email(rs.getString("ui_email"));
				ui.setUi_credat(rs.getString("ui_credat"));
				ui.setUi_nickname(rs.getString("ui_nickname"));
				return ui;
			}
		}catch(SQLException sqle) {
			sqle.printStackTrace();
		}finally {
			InitServlet.close(rs, ps, con);;
		}
		return null;
	}

	@Override
	public UserInfoVO checkUserId(UserInfoVO user) {
		String sql= "select ui_id from user_info where ui_id=?";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null; 
		
		try {
			con = InitServlet.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getUi_id());
			rs = ps.executeQuery();
			
			if(rs.next()) {
				UserInfoVO ui =  new UserInfoVO();
				ui.setUi_id(rs.getString("ui_id"));
				return ui;
			}
		}catch(SQLException sqle) {
			sqle.printStackTrace();
		}finally {
			InitServlet.close(rs, ps, con);;
		}
		return null;
	}
	public UserInfoVO checkUserNickname(UserInfoVO user) {
		String sql= "select ui_nickname from user_info where ui_nickname=?";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null; 
		
		try {
			con = InitServlet.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getUi_nickname());
			rs = ps.executeQuery();
			
			if(rs.next()) {
				UserInfoVO ui =  new UserInfoVO();
				ui.setUi_nickname(rs.getString("ui_nickname"));
				return ui;
			}
		}catch(SQLException sqle) {
			sqle.printStackTrace();
		}finally {
			InitServlet.close(rs, ps, con);;
		}
		return null;
	}
}
