package com.boot2.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.boot2.dao.MemberInfoDAO;
import com.boot2.dao.impl.MemberInfoDAOImpl;
import com.boot2.service.MemberService;

public class MemberServiceImpl implements MemberService
{

	private MemberInfoDAO mdao = new MemberInfoDAOImpl();


	@Override
	public List<Map<String, Object>> selectMemberInfoList(Map<String, Object> member)
	{
		int page = Integer.parseInt(member.get("page").toString());
		int pageSize = Integer.parseInt(member.get("pageSize").toString());
		int startNum = (page-1)*page + 1;
		int endNum = (startNum-1) + pageSize;
		member.put("startNum", startNum);
		member.put("endNum", endNum);
		
		return mdao.selectMemberInfoList(member);
	}

	public static void main(String[] args)
	{
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("page",3);
		param.put("pageSize", 30);
		
		MemberService mList = new MemberServiceImpl();
		
	}
}
