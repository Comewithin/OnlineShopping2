package com.homework02.test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.homework02.bean.Commodity;
import com.homework02.jdbc.JDBC;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String sql = "select * from commodity";
		ResultSet rs = JDBC.executeQuery(sql, null);
		ArrayList<Commodity> list = new ArrayList<Commodity>();
		System.out.println("id"+"\t"+"name"+"\t"+"原价"+"\t"+"现价"+"\t"+"商品信息"+"\t"+"图片信息");
		
		try {
			while(rs.next()){
				//int i = 1;
				//System.out.println(rs.getString(i++)+"\t"+rs.getString(i++)+"\t"+rs.getString(i++)+"\t"+rs.getString(i++)+"\t"+rs.getString(i++)+"\t"+rs.getString(i));
				Commodity com = new Commodity();
				com.setId(rs.getInt("id"));
				com.setName(rs.getString("name"));
				com.setOldPrice(rs.getDouble("oldprice"));
				com.setNewPrice(rs.getDouble("newprice"));
				com.setMessage(rs.getString("message"));
				com.setImg(rs.getString("img"));
				
				list.add(com);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i = 0; i<list.size(); i++){
			System.out.println(list.get(i).getId()+"\t"+list.get(i).getName()+"\t"+list.get(i).getOldPrice()+"\t"+list.get(i).getNewPrice()+"\t"+list.get(i).getMessage()+"\t"+list.get(i).getImg());
		}
	}

}
