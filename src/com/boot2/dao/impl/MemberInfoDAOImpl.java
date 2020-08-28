package com.boot2.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.boot2.dao.MemberInfoDAO;
import com.boot2.servlet.InitServlet;
import com.boot2.servlet.MybatisServlet;

public class MemberInfoDAOImpl implements MemberInfoDAO
{
	public List<Map<String, Object>> selectTest(Map<String, Object> member){
		List<Map<String, Object>> mList = new ArrayList<>();
		Connection con = InitServlet.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "select * from member_info";
		
		try
		{
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Map<String,Object> m = new HashMap<>();
				m.put("mi_num",rs.getInt("mi_num"));
				mList.add(m);
				
			}return mList;
		} catch (SQLException e)
		{
			e.printStackTrace();
		}finally {
			InitServlet.close(rs, ps, con);
		}
		
		return null;
	}
	@Override
	public List<Map<String, Object>> selectMemberInfoList(Map<String, Object> member)
	{
		try(SqlSession ss = MybatisServlet.getSession()){
	         return ss.selectList("Member.selectMemberList",member);
	      }

	}
	
	public static void main(String[] args)
	{
//		InitServlet is = new InitServlet();
//		is.init();
		MemberInfoDAO mdao = new MemberInfoDAOImpl();
		Map<String,Object> map = new HashMap<>();
		map.put("startNum","51");
		map.put("endNum","60");
//		System.out.println(mdao.selectMemberInfoList(map));
		
		List<Map<String,Object>> mList = mdao.selectMemberInfoList(map);
		for(Map<String,Object> m:mList) {
			System.out.println(m);
		}
		
	
	}

}
