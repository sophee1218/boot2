package com.boot2.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.boot2.vo.UserInfoVO;

public interface UserService
{	
	int insertUser(UserInfoVO user);
	int deleteUser(UserInfoVO user,HttpSession hs);
	int updateUser(UserInfoVO user,HttpSession hs);
	UserInfoVO selectUser(UserInfoVO user);
	boolean doLogin(UserInfoVO user,HttpSession hs);
	List<UserInfoVO> selectUserList(UserInfoVO user);
	boolean doCheckUserId(UserInfoVO user);
	boolean doCheckUserNickname(UserInfoVO user);
	
	int deleteUsers(int[] uiNums);
}
	