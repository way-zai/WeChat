package com.jxaucjj.utils;

import java.sql.*;

/**数据库工具类 (封装数据库的一些常用操作)*/
public class JDBCUtil {

	//获取数据库连接对象
	public static Connection getConnection(){
		
		Connection conn=null;
		try {
			//1.加载驱动程序
			Class.forName("com.mysql.jdbc.Driver");
			//2.获取连接
			String url="jdbc:mysql://localhost:3306/tranning?useSSL=false";
			String userName="root";
			String password="";
			
			conn=DriverManager.getConnection(url,userName,password);
		}
		catch(Exception ex) {
			System.out.println("数据库连接出错");
			ex.printStackTrace();
		}
		return conn;
	}
	
	//关闭数据库连接 释放资源
	public static void release(Connection conn,Statement st) {
		
		if(conn!=null) {
			try {
				conn.close();
			} 
			catch (SQLException e) {	
				e.printStackTrace();
			}
		}
		conn=null;
		
		if(st!=null) {
			try {
				st.close();
			}
			catch(SQLException ex) {
				ex.printStackTrace();
			}
			st=null;
		}
	}
	
public static void release(ResultSet rs,Connection conn,Statement st) {
		
		if(rs!=null) {
			try {
				rs.close();
			} 
			catch (SQLException e) {	
				e.printStackTrace();
			}
		}
		rs=null;
		release(conn,st);
	}
}
