package com.boot2.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.boot2.dao.UserInfoDAO;
import com.boot2.dao.impl.UserInfoDAOImpl;
import com.boot2.service.UserInfoService;

public class UserInfoServiceImpl implements UserInfoService
{
	private UserInfoDAO userInfoDao = new UserInfoDAOImpl();
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
	public Map<String, Object> selectUserInfoByUiId(Map<String, Object> uiId)
	{
		Map<String,Object> rMap = userInfoDao.selectUserInfoByUiId(uiId);
		if(rMap!=null) {
			rMap.put("result", "true");
			rMap.put("msg", "로그인 성공!");
			rMap.put("url", "/");
		}else {
			rMap = new HashMap<>();
			rMap.put("result", "false");
			rMap.put("msg", "로그인 실패!");
			rMap.put("url", "/views/login");
		}
		return rMap;
	}

	@Override
	public List<Map<String, Object>> selectUserInfoList(Map<String, Object> ui)
	{
		// TODO Auto-generated method stub
		return null;
	}

}
