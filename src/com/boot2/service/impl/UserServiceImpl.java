package com.boot2.service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.boot2.dao.UserDAO;
import com.boot2.dao.impl.UserDAOImpl;
import com.boot2.service.UserService;
import com.boot2.servlet.InitServlet;
import com.boot2.vo.UserInfoVO;

public class UserServiceImpl implements UserService {

	private UserDAO udao = new UserDAOImpl();

	@Override
	public int insertUser(UserInfoVO user) {
		if (udao.checkUserId(user) != null) {
			return -1;
		}
		return udao.insertUser(user);
	}

	@Override
	public int deleteUser(UserInfoVO user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateUser(UserInfoVO user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UserInfoVO selectUser(UserInfoVO user) {
		// TODO Auto-generated method stub
		return null;
	}

	public UserInfoVO selectUserForLogin(UserInfoVO user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserInfoVO> selectUserList(UserInfoVO user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean doLogin(UserInfoVO user, HttpSession hs) {
		user = udao.selectUserForLogin(user);
		if (user != null) {
			hs.setAttribute("user", user);
			return true;
		}

		return false;
	}

	@Override
	public boolean doCheckUserId(UserInfoVO user) {
		user = udao.checkUserId(user);
		if (user != null) {
			return false;
		}
		return true;
	}

	@Override
	public boolean doCheckUserNickname(UserInfoVO user) {
		user = udao.checkUserNickname(user);
		if (user != null) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		InitServlet is = new InitServlet();
		is.init();
		UserService ud = new UserServiceImpl();
		UserInfoVO user = new UserInfoVO();
		user.setUi_id("aaa27");
		user.setUi_pwd("1133");
		boolean isLogin = ud.doLogin(user, null);
		System.out.println(isLogin);
	}
}