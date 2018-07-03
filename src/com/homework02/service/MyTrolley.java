package com.homework02.service;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.homework02.bean.Commodity_Trolley;
import com.homework02.jdbc.JDBC;

public class MyTrolley {

	public static ArrayList<Commodity_Trolley> myTrolley(){
		String sql = "select a.id, a.name, a.img, a.message, a.oldprice, a.newprice, b.number from commodity a inner join trolley b on a.id = b.id";
		ResultSet rs = JDBC.executeQuery(sql, null);
		ArrayList<Commodity_Trolley> list = new ArrayList<Commodity_Trolley>();
		try {
			while(rs.next()){
				Commodity_Trolley cot = new Commodity_Trolley();
				cot.setId(rs.getInt("id"));
				cot.setName(rs.getString("name"));
				cot.setOldPrice(rs.getDouble("oldprice"));
				cot.setNewPrice(rs.getDouble("newprice"));
				cot.setMessage(rs.getString("message"));
				cot.setImg(rs.getString("img"));
				cot.setNumber(rs.getInt("number"));
				list.add(cot);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
}
