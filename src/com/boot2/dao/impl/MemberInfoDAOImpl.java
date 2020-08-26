package com.boot2.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.boot2.dao.MemberInfoDAO;
import com.boot2.servlet.InitServlet;
import com.boot2.vo.MemberInfoVO;

public class MemberInfoDAOImpl implements MemberInfoDAO
{

	@Override
	public int selectTotalCount(MemberInfoVO mi)
	{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select count(*) cnt from member_info";
		try {
			conn = InitServlet.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			InitServlet.close(ps, conn);
		}
		return 0;
	}

	@Override
	public List<MemberInfoVO> selectMemberInfoList(MemberInfoVO mi)
	
	{	
		List<MemberInfoVO> memberList  = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from(\r\n" + 
				"select rownum rnum, mi.* from(\r\n" + 
				"	select * from member_info\r\n" + 
				"	order by mi_num DESC\r\n" + 
				")mi \r\n" + 
				"	where rownum <=?)\r\n" + 
				"	where rnum>=?";
		
		try
		{
			conn = InitServlet.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1,mi.getEndRowNum());
			ps.setInt(2, mi.getStartRowNum());
			rs = ps.executeQuery();
			while(rs.next()) {
				MemberInfoVO mVO = new MemberInfoVO();
				mVO.setRNum(rs.getInt("rnum"));
				mVO.setMiNum(rs.getInt("mi_num"));
				mVO.setMiName(rs.getString("mi_name"));
				mVO.setMiId(rs.getString("mi_id"));
				memberList.add(mVO);
			}
			return memberList;
		} catch (SQLException e)
		{
			e.printStackTrace();
		}finally {
			InitServlet.close(rs,ps,conn);
		}
		return null;
	}

	
	public static void main(String[] args)
	{
		InitServlet is = new InitServlet();
		is.init();
		MemberInfoDAO midao = new MemberInfoDAOImpl();
		MemberInfoVO mi = new MemberInfoVO();
		mi.setEndRowNum(40);
		mi.setStartRowNum(21);
		System.out.println(midao.selectMemberInfoList(mi));
	
		
	}
}
