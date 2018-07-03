package com.homework02.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.homework02.bean.Commodity;
import com.homework02.bean.PageModel;
import com.homework02.jdbc.JDBC;

public class Page {

	public static List<Commodity> queryCommodity(PageModel pageModel, String[] type) {
		String sql = "select * from commodity where type=? limit "+pageModel.getStartRowNum()+","+pageModel.getPageSize();
		ResultSet rs = JDBC.executeQuery1(sql, type);
		List<Commodity> list = new ArrayList<Commodity>();

		try {
			while(rs.next()) {
				Commodity com = new Commodity();
				com.setId(rs.getInt("id"));
				com.setType(rs.getString("type"));
				com.setName(rs.getString("name"));
				com.setOldPrice(rs.getDouble("oldPrice"));
				com.setNewPrice(rs.getDouble("newPrice"));
				com.setMessage(rs.getString("message"));
				com.setImg(rs.getString("img"));
				com.setInventory(rs.getInt("inventory"));
				list.add(com);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}
	
	public static int queryCommodityCount(String[] type) {

		StringBuffer sqlBuf = new StringBuffer("select count(*) from commodity where type=?");

		ResultSet rs = JDBC.executeQuery1(sqlBuf.toString(),type);
		try {
			while (rs.next()) {
				int count = rs.getInt(1);
				return count;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
}
