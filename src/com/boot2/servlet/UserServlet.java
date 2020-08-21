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
		
		if("checkid".equals(request.getParameter("cmd")))
		{
			UserInfoVO user = new UserInfoVO();
			user.setUi_id(request.getParameter("ui_id"));
			Map<String, Object> result = new HashMap<>();
			result.put("result",userService.doCheckUserId(user));
			String json = gson.toJson(result);
			PrintWriter pw = response.getWriter();
			pw.println(json);
		}
		if("checknickname".equals(request.getParameter("cmd")))
		{
			UserInfoVO user = new UserInfoVO();
			user.setUi_nickname(request.getParameter("ui_nickname"));
			Map<String, Object> result = new HashMap<>();
			result.put("result",userService.doCheckUserNickname(user));
			String json = gson.toJson(result);
			PrintWriter pw = response.getWriter();
			pw.println(json);
		}
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
		Map<String, Object> result = new HashMap<>();
		
		if("login".equals(user.getCmd())) {
		result.put("result", userService.doLogin(user, request.getSession()));
		}else if("signup".equals(user.getCmd())) {
			result.put("result",userService.insertUser(user));
		}else if("logout".equals(user.getCmd())) {
			request.getSession().invalidate();
			result.put("result", true);
		}else if("modify".equals(user.getCmd())) {
			result.put("result",userService.updateUser(user,request.getSession()));
		}else if("delete".equals(user.getCmd())) {
			result.put("result",userService.deleteUser(user,request.getSession()));
		}
			
			
		
		String json = gson.toJson(result);
		PrintWriter pw = response.getWriter();
		pw.println(json);

	}

}
