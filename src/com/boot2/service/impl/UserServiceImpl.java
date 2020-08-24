package com.boot2.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.boot2.dao.UserDAO;
import com.boot2.dao.impl.UserDAOImpl;
import com.boot2.listener.SessionListener;
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
	public int deleteUser(UserInfoVO user,HttpSession hs) {
		int cnt = udao.deleteUser(user);
		if(cnt==1) {
			hs.invalidate();
			return cnt;
		}
		
		return 0;
	}

	@Override
	public int updateUser(UserInfoVO user,HttpSession hs) {
		int cnt = udao.updateUser(user);
		if(cnt==1) {
			hs.setAttribute("user", udao.selectUser(user));
		}
		return cnt;
	}

	@Override
	public UserInfoVO selectUser(UserInfoVO user) {
		return udao.selectUser(user);
	}

	public UserInfoVO selectUserForLogin(UserInfoVO user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserInfoVO> selectUserList(UserInfoVO user) {

		
		return udao.selectUserList(user);
	}

	@Override
	public boolean doLogin(UserInfoVO user, HttpSession hs) {
		user = udao.selectUserForLogin(user);
		if (user != null) {
			SessionListener.checkUserId(user.getUi_id());
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
		
		UserService userService = new UserServiceImpl();
		List<UserInfoVO> userList = new ArrayList<UserInfoVO>();
		
		userList = userService.selectUserList(null);
		System.out.println(userList);
	}
}