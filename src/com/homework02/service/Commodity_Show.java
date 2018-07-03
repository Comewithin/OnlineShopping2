package com.homework02.service;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.homework02.bean.Commodity;
import com.homework02.jdbc.JDBC;

public class Commodity_Show {
	
	//显示所有商品的信息
	public static ArrayList<Commodity> selectAll(){
		String sql = "select * from commodity";
		ResultSet rs = JDBC.executeQuery(sql, null);
		ArrayList<Commodity> list = new ArrayList<Commodity>();
		
		try {
			while(rs.next()){
				Commodity com = new Commodity();
				com.setId(rs.getInt("id"));
				com.setName(rs.getString("name"));
				com.setOldPrice(rs.getDouble("oldprice"));
				com.setNewPrice(rs.getDouble("newprice"));
				com.setMessage(rs.getString("message"));
				com.setImg(rs.getString("img"));
				com.setInventory(rs.getInt("inventory"));
				list.add(com);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

}
