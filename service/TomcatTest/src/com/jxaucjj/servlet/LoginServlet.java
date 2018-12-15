package com.jxaucjj.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.jxaucjj.utils.*;

public class LoginServlet extends HttpServlet {       
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
														throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");														//设置编码(防止乱码)
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out=response.getWriter();
		
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		
		System.out.println("Login userName:"+userName+" password:"+password);
		
		if(UsersDeao.find(userName, password))
			out.print("Yes");
		else
			out.print("No");
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
																		throws ServletException, IOException {
	
		doGet(request, response);
	}
}
