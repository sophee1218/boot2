package com.boot2.dao;

import java.util.List;

import com.boot2.vo.UserInfoVO;

public interface UserDAO {

	int insertUser(UserInfoVO user);
	int deleteUser(UserInfoVO user);
	int updateUser(UserInfoVO user);
	UserInfoVO selectUser(UserInfoVO user);
	UserInfoVO selectUserForLogin(UserInfoVO user);
	List<UserInfoVO> selectUserList(UserInfoVO user);
}
