package com.jxaucjj.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.jxaucjj.utils.*;

public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 4730804965838548173L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
											throws ServletException, IOException {
		
		
		response.setCharacterEncoding("utf-8");														//设置编码(防止乱码)
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out=response.getWriter();
		
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		String sex=request.getParameter("sex");
		
		System.out.println("Register userName:"+userName+" password:"+password+" sex: "+sex);
		
		if(userName==null||userName.length()==0||UsersDeao.find(userName))
			out.print("No");
		else {
			UsersDeao.insert(userName, password, sex);
			out.print("Yes");
		}
		out.close();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
								throws ServletException, IOException {
		
		doGet(request, response);
	}
}
