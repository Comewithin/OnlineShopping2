package com.homework02.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.homework02.bean.Commodity;
import com.homework02.jdbc.JDBC;

public class Join_Trolley {

	public static ResultSet rs1 = null;//用来接收executeQuery方法返回的结果集
	
	public static int rs2 = 0;//用来接收executeUpdate方法返回的结果集
	
	private static String sql = null;
	
	//private static int num = 0;
	
	//查询trolley表中所有的id
	public static ArrayList<Integer> selectId(){
		sql = "select id from trolley";
		rs1 = JDBC.executeQuery(sql, null);
		ArrayList<Integer> list = new ArrayList<Integer>();
		
        try {
			while(rs1.next())
				list.add(rs1.getInt("id"));//将trolley表中所有的id存到list集合中
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return list;
	}
	
	public static int insert(int[] str){
		sql = "insert into trolley (id,number) values(?,?)";
		rs2 = JDBC.executeUpdate(sql,str);
		return rs2;
	}
	
	public static int update(int[] str){
		sql = "update trolley set number=number+1 where id = ?";
		rs2 = JDBC.executeUpdate(sql,str);
		return rs2;
	}
	
	//判断客户所选商品库存是否为空
	public static boolean isEmpty(int[] str){
		boolean flag = false;
		sql = "select inventory from commodity where id= ? ";
		rs1 = JDBC.executeQuery(sql, str);
		Commodity com = new Commodity();
		try {
			while(rs1.next()){
				com.setInventory(rs1.getInt("inventory"));
			}
				
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	    if(com.getInventory()!=0){
			flag = true;
		}
			
		return flag;
	}
}
