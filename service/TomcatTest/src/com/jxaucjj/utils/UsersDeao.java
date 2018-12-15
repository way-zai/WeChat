package com.jxaucjj.utils;

import java.sql.*;

public class UsersDeao {
	//插入用户信息
	public static void  insert(String userName,String password,String sex) {
		
		Connection conn=null;
		Statement stmt=null;
		
		try {
			//1.获取数据库的连接
			conn=JDBCUtil.getConnection();
			//2.执行SQL语句
			//注意加单引号
			String sql="INSERT INTO users VALUES('"+userName+"','"+password+"','"+sex+"')";
			stmt=conn.createStatement();
			stmt.executeUpdate(sql);
		}
		catch(Exception ex) {
			System.out.println("数据库插入出错!");
			ex.printStackTrace();
		}
		finally {
			//释放数据库资源
			JDBCUtil.release(conn, stmt);
		}
	}
	//通过用户名查询用户是否存在
	public static boolean  find(String userName){
		
		Connection conn=null;
		Statement stmt=null;
		boolean flag=false;
		
		try {
			//1.获取连接对象
			conn=JDBCUtil.getConnection();
			//2.使用statement对象执行sql查询语句
			String sql="SELECT * FROM USERS WHERE userName='"+userName+"'";
			stmt=conn.createStatement();
			flag=stmt.executeQuery(sql).next();
			
		}
		catch(SQLException ex) {
			System.out.println("数据查询出错");
			ex.printStackTrace();
		}
		JDBCUtil.release(conn, stmt);
		return flag;
	}
	
//通过用户名查询用户和密码存在
	public static boolean  find(String userName,String password){
		
		Connection conn=null;
		Statement stmt=null;
		boolean flag=false;
		
		try {
			//1.获取连接对象
			conn=JDBCUtil.getConnection();
			//2.使用statement对象执行sql查询语句
			String sql="SELECT * FROM USERS WHERE userName='"+userName+"' and passwords='"
									+password+"'";
			stmt=conn.createStatement();
			flag=stmt.executeQuery(sql).next();
			
		}
		catch(SQLException ex) {
			System.out.println("数据查询出错");
			ex.printStackTrace();
		}
		JDBCUtil.release(conn, stmt);
		return flag;
	}
}
