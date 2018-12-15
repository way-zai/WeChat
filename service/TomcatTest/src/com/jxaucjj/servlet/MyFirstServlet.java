package com.jxaucjj.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MyFirstServlet extends HttpServlet{
	
	private static final long serialVersionUID = -2754525182518494189L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
				throws ServletException, IOException {
		
		resp.setCharacterEncoding("utf-8");														//设置编码(防止乱码)
		resp.setContentType("text/html; charset=utf-8");
		
		String userName=req.getParameter("userName");
		String password=req.getParameter("password");
		
		System.out.println("用户名: "+userName+" 密码:"+password);
		
		PrintWriter out=resp.getWriter();
		
		if(userName!=null&&password!=null&&userName.equals("admin")&&password.equals("123456")) {
			out.print("登录成功");
		}
		else {
			out.print("用户名或密码错误");
		}
		out.flush();
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
