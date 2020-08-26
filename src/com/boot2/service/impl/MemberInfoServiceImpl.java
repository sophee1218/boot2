package com.boot2.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.boot2.dao.MemberInfoDAO;
import com.boot2.dao.impl.MemberInfoDAOImpl;
import com.boot2.service.MemberInfoService;
import com.boot2.servlet.InitServlet;
import com.boot2.vo.MemberInfoVO;

public class MemberInfoServiceImpl implements MemberInfoService
{
	private MemberInfoDAO midao = new MemberInfoDAOImpl();
	@Override
	public Map<String,Object> selectMemberInfoList(MemberInfoVO mi)
	{
		int page = mi.getPage();
		int startRowNum = (page-1)*10+1;
		int endRowNum = startRowNum + (10-1);
		mi.setStartRowNum(startRowNum);
		mi.setEndRowNum(endRowNum);
		List<MemberInfoVO> miList = midao.selectMemberInfoList(mi);
		int totalCount = midao.selectTotalCount(mi);
		Map<String,Object> rMap = new HashMap<>();
		rMap.put("list", miList);
		rMap.put("totalCnt", totalCount);
		return rMap;
	}
	
	public static void main(String[] args)
	{
		InitServlet is = new InitServlet();
		is.init();
		MemberInfoService mis = new MemberInfoServiceImpl();
		MemberInfoVO mi = new MemberInfoVO();
		mi.setPage(3);
		System.out.print(mis.selectMemberInfoList(mi));
	}

}
