package com.boot2.service;

import java.util.List;
import java.util.Map;

public interface UserInfoService
{
	int insertUserInfo(Map<String,Object> ui);
	int updatetUserInfo(Map<String,Object> ui);
	int deleteUserInfo(Map<String,Object> ui);
	Map<String,Object> selectUserInfo(Map<String,Object> ui);
	Map<String,Object> selectUserInfoByUiId(Map<String,Object> uiId);
	List<Map<String,Object>> selectUserInfoList(Map<String,Object> ui);
}
