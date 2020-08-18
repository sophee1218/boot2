package com.boot2.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.boot2.dao.UserInfoDAO;
import com.boot2.servlet.InitServlet;

public class UserInfoDAOImpl implements UserInfoDAO
{

	@Override
	public int insertUserInfo(Map<String, Object> ui)
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updatetUserInfo(Map<String, Object> ui)
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteUserInfo(Map<String, Object> ui)
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Map<String, Object> selectUserInfo(Map<String, Object> ui)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> selectUserInfoByUiId(Map<String,Object> uiId)
	{
		Connection conn = InitServlet.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "select * from user_info where ui_id = ? and ui_pwd = ? ";
		
		try
		{
			ps = conn.prepareStatement(sql);
			ps.setObject(1, uiId.get("ui_id"));	
			ps.setObject(2, uiId.get("ui_pwd"));
			rs = ps.executeQuery();
			
			Map<String,Object> ui_map = new HashMap<>();
			if(rs.next())
			{
				ui_map.put("ui_num", rs.getObject("ui_num"));
				ui_map.put("ui_name", rs.getObject("ui_name"));
				ui_map.put("ui_age", rs.getObject("ui_age"));
				ui_map.put("ui_birth", rs.getObject("ui_birth"));
				ui_map.put("ui_id", rs.getObject("ui_id"));
				ui_map.put("ui_pwd", rs.getObject("ui_pwd"));
				ui_map.put("ui_phone", rs.getObject("ui_phone"));
				ui_map.put("ui_email", rs.getObject("ui_email"));
				ui_map.put("ui_credat", rs.getObject("ui_credat"));
				ui_map.put("ui_nickname", rs.getObject("ui_nickname"));
				
				return ui_map;
				
			}
			
			
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			InitServlet.close(rs, ps, conn);
		}
		
		return null;
	}

	@Override
	public List<Map<String, Object>> selectUserInfoList(Map<String, Object> ui)
	{
		// TODO Auto-generated method stub
		return null;
	}

}
