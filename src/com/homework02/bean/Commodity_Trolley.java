package com.homework02.bean;

public class Commodity_Trolley {

	//此实体类用来存放commodity表和trolley表关联查询出来的数据
	
	private int id;         //商品id
	private String name;    //商品名称
	private double oldPrice;//原价
	private double newPrice;//现价
	private String message; //商品信息
	private String img;     //商品图片
	private int trolleyId;//购物车id
	private int number;      //某件商品的数量
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public double getOldPrice() {
		return oldPrice;
	}
	public void setOldPrice(double oldPrice) {
		this.oldPrice = oldPrice;
	}
	
	public double getNewPrice() {
		return newPrice;
	}
	public void setNewPrice(double newPrice) {
		this.newPrice = newPrice;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
	public int getTrolleyId() {
		return trolleyId;
	}
	public void setTrolleyId(int trolleyId) {
		this.trolleyId = trolleyId;
	}
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
}
