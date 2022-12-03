package com.hq.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class DBUtil {
	
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost:3306/ordersys?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT";

   static final String USER = "root";
   static final String PASS = "root";
	
	static {
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstmt;
	
	private void openConnection() {
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//事务回滚
	public void connectionRollback() {
		try {
			conn.rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//提交事务
	public void commit() {
		try {
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//数据库连接对象创建 stat
	public Statement getStatement() {
		openConnection();
		try {
			stat = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stat;
	}
	//
	public PreparedStatement getPreparedStatement(String sql) {
		openConnection();
		try {
			System.out.println(conn==null?"连接为空":"连接不为空");
			pstmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pstmt;
	}
	
	public void closeResource() {
		try {
			if (pstmt != null && !pstmt.isClosed()) {
				pstmt.close();
			}
			
			if (stat != null && !stat.isClosed()) {
				stat.close();
			}
			
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}
