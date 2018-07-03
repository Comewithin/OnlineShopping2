package com.homework02.service;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.homework02.bean.Commodity;
import com.homework02.jdbc.JDBC;

public class Commodity_Choose {

	//显示选中商品的信息
	public static ArrayList<Commodity> selectAll(int[] id){
		String sql = "select * from commodity where id=?";
		ResultSet rs = JDBC.executeQuery(sql, id);
		ArrayList<Commodity> list = new ArrayList<Commodity>();
		
		try {
			while(rs.next()){
				Commodity com = new Commodity();
				com.setId(rs.getInt("id"));
				com.setName(rs.getString("name"));
				com.setOldPrice(rs.getDouble("oldprice"));
				com.setNewPrice(rs.getDouble("newprice"));
				com.setMessage(rs.getString("message"));
				String str = rs.getString("img");
				com.setImg(str.replace(".", "(lbig)."));
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
