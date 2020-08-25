package com.boot2.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.boot2.service.UserService;
import com.boot2.service.impl.UserServiceImpl;
import com.boot2.vo.UserInfoVO;
import com.google.gson.Gson;

@WebServlet("/ajax/user")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Gson gson = new Gson();
	private UserService userService = new UserServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			Map<String, Object> result = new HashMap<>();
			UserInfoVO user = new UserInfoVO();
			
		if ("checkid".equals(request.getParameter("cmd"))) {
			user.setUi_id(request.getParameter("ui_id"));
			result.put("result", userService.doCheckUserId(user));
		} else if ("checknickname".equals(request.getParameter("cmd"))) {
			user.setUi_nickname(request.getParameter("ui_nickname"));
			result.put("result", userService.doCheckUserNickname(user));
		} else if("list".equals(request.getParameter("cmd"))) {
			result.put("list",userService.selectUserList(null));
		}
		
		String json = gson.toJson(result);
		PrintWriter pw = response.getWriter();
		pw.println(json);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BufferedReader br = request.getReader();
		String str;
		StringBuffer sb = new StringBuffer();
		while ((str = br.readLine()) != null) {
			sb.append(str);
		}
		UserInfoVO user = gson.fromJson(sb.toString(), UserInfoVO.class);
		System.out.println(user);
		Map<String, Object> result = new HashMap<>();

		if ("login".equals(user.getCmd())) {
			result.put("result", userService.doLogin(user, request.getSession()));
		} else if ("signup".equals(user.getCmd())) {
			result.put("result", userService.insertUser(user));
		} else if ("logout".equals(user.getCmd())) {
			request.getSession().invalidate();
			result.put("result", true);
		} else if ("modify".equals(user.getCmd())) {
			result.put("result", userService.updateUser(user, request.getSession()));
		} else if ("delete".equals(user.getCmd())) {
			result.put("result", userService.deleteUser(user, request.getSession()));
		} else if("deleteUsers".equals(user.getCmd())) {
			result.put("result", userService.deleteUsers(user.getUiNums()));
		}

		String json = gson.toJson(result);
		PrintWriter pw = response.getWriter();
		pw.println(json);

	}

}
