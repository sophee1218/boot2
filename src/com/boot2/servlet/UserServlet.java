package com.boot2.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.interfaces.RSAKey;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.boot2.service.UserInfoService;
import com.boot2.service.impl.UserInfoServiceImpl;
import com.google.gson.Gson;

@WebServlet("/ajax/user")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Gson gson = new Gson();
	private UserInfoService userinfoservice = new UserInfoServiceImpl();
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String contentType = response.getContentType();
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BufferedReader br = request.getReader();
		PrintWriter pw = response.getWriter();
		String str;
		StringBuffer sb = new StringBuffer();
		while((str=br.readLine())!=null) {
			sb.append(str);
		}
		Map<String,Object> param = gson.fromJson(sb.toString(), Map.class);
	
		if("login".equals(param.get("url"))) {
			Map<String,Object> rMap = userinfoservice.selectUserInfoByUiId(param);
			String jsonStr = gson.toJson(rMap);
			pw.print(jsonStr);
			
			System.out.println(rMap.get("result"));
	
		}	
	
	}

}
