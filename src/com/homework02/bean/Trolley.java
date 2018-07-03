package com.homework02.bean;

public class Trolley {

	private int trolleyId;//购物车id
	//private int userId;   //用户id
	private int id;       //商品id
	private int num;      //某件商品的数量
	
	public int getTrolleyId() {
		return trolleyId;
	}
	public void setTrolleyId(int trolleyId) {
		this.trolleyId = trolleyId;
	}
	
//	public int getUserId() {
//		return userId;
//	}
//	public void setUserId(int userId) {
//		this.userId = userId;
//	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
}
