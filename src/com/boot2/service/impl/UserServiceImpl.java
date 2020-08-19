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
		// TODO Auto-generated method stub
		return 0;
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
		if(user!=null) {
			hs.setAttribute("user", user);
			return true;
		}
		
		return false;
	}
	public static void main(String[] args) {
		InitServlet is = new InitServlet();
		is.init();
		UserService ud = new UserServiceImpl();
		UserInfoVO user = new UserInfoVO();
		user.setUi_id("aaa27");
		user.setUi_pwd("1133");
		boolean isLogin = ud.doLogin(user,null);
		System.out.println(isLogin);
	}
}
