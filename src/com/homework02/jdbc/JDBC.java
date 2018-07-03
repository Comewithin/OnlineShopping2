package com.homework02.jdbc;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class JDBC {

	public static final String Driver = "com.mysql.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/homework?characterEncoding=UTF-8";
	public static final String user = "root";
	public static final String pwd = "root";
	public static Connection con = null;
	public static PreparedStatement ps = null;
	public static ResultSet rs = null;	
	
	static{
		try {
			Class.forName(Driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("MySQL驱动加载失败！");
		}
	}

	//获取连接
	public static Connection getConnection(){
		try {
			con=(Connection) DriverManager.getConnection(URL, user, pwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	public static Connection getCon(){
		return con;
	}
	
	public static PreparedStatement getPs(){
		return ps;
	}
	
	public static ResultSet getRs(){
		return rs;
	}
	
	
	
	//查询操作
	public static ResultSet executeQuery(String sql, int[] info) {
		
		try {
			ps = (PreparedStatement) JDBC.getConnection().prepareStatement(sql);
			if(info!=null){
				for(int i = 0; i<info.length; i++)
				ps.setInt(i+1, info[i]);
			}
			rs = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rs;
	}

	//查询操作
	public static ResultSet executeQuery1(String sql, String[] info) {
		
		try {
			ps = (PreparedStatement) JDBC.getConnection().prepareStatement(sql);
			if(info!=null){
				for(int i = 0; i<info.length; i++)
				ps.setString(i+1, info[i]);
			}
			rs = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rs;
	}

	//增删改操作
	public static int executeUpdate(String sql, int[] info) {
		
		int in = 0;
		try {
			ps = (PreparedStatement) JDBC.getConnection().prepareStatement(sql);
			if(info!=null){
				for(int i = 0; i<info.length; i++)
				ps.setInt(i+1, info[i]);
			}
			in = ps.executeUpdate() ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(con, ps, rs);
		}

		return in;
	}

	//增删改操作
	public static int executeUpdate1(String sql, String[] info) {
		
		int in = 0;
		try {
			ps = (PreparedStatement) JDBC.getConnection().prepareStatement(sql);
			if(info!=null){
				for(int i = 0; i<info.length; i++)
				ps.setString(i+1, info[i]);
			}
			in = ps.executeUpdate() ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(con, ps, rs);
		}

		return in;
	}
	
	
	
	
	//关闭操作
	public static void close(Connection con, PreparedStatement ps, ResultSet rs){
		if(con!=null)
		{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			con = null;
		}
		
		if(ps!=null)
		{
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ps = null;
		}
		
		if(rs!=null)
		{
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			rs = null;
		}
		
	}

	
	
}
