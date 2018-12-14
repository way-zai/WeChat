package com.jxaucjj.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import com.jxaucjj.utils.*;
import com.alibaba.fastjson.*;
import java.util.*;

@WebServlet("/Friend")
public class FriendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FriendServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
											throws ServletException, IOException {
		
	        response.setCharacterEncoding("utf-8");
	        response.setContentType("text/html; charset=utf-8");
	        
	        String userName=request.getParameter("userName");
	        String content=request.getParameter("contents");
	        
	        if(userName!=null||content!=null) {
	        	System.out.println("userName: "+userName+" contents: "+content);
	        	Friend data=new Friend(String.format("img/%d.jpg",userName.hashCode()%9+1),
	        													userName,content,new String[] {"img/scenery.jpg","img/scenery2.jpg"});
	        	appendData(data);
	        }else {
	        
	        	List<Friend> list=getFriendList();
	        	PrintWriter out = response.getWriter();
	        	out.print(JSON.toJSONString(list));
	        	out.close();
	        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
										throws ServletException, IOException {
		
		doGet(request, response);
	}
	
	private List<Friend> getFriendList(){
		List<Friend> res=new LinkedList<>();
		
		try {
			BufferedReader in
			   = new BufferedReader(new FileReader("D:/HTML/json.txt"));
			String friend=null;
			while((friend=in.readLine())!=null)
				res.add(0,JSON.parseObject(friend, Friend.class));
			in.close();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return res;	
	}
	
	private void appendData(Friend friend) {
		try {
			PrintWriter write=new PrintWriter(new FileWriter("D:/HTML/json.txt",true));
			write.println(JSON.toJSONString(friend));
			write.close();
		}
		catch(Exception ex) {
			System.out.println("追加数据出错");
			ex.printStackTrace();
		}
	}
}
