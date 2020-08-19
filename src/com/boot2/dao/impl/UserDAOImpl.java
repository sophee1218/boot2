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
		// TODO Auto-generated method stub
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

}
