package com.boot2.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.boot2.vo.UserInfoVO;

public interface UserService
{	
	int insertUser(UserInfoVO user);
	int deleteUser(UserInfoVO user);
	int updateUser(UserInfoVO user);
	UserInfoVO selectUser(UserInfoVO user);
	boolean doLogin(UserInfoVO user,HttpSession hs);
	List<UserInfoVO> selectUserList(UserInfoVO user);
	boolean doCheckUserId(UserInfoVO user);
	boolean doCheckUserNickname(UserInfoVO user);
}
	