package com.hq.pojo;

public class Dishes {
	private int dishesId;
	private String dishesName;
	private String dishesDiscript;
	private String dishesImg;
	private String dishesTxt;
	private int recommend;
	private float dishesPrice;
	private int orderId;
	private int tableId;
	private int waiterId;
	private int orderState;
	private String orderBeginDate;
	private String orderEndDate;
	
	public int getOrderState() {
		return orderState;
	}
	public void setOrderState(int orderState) {
		this.orderState = orderState;
	}
	public int getDishesId() {
		return dishesId;
	}
	public void setDishesId(int dishesId) {
		this.dishesId = dishesId;
	}
	public String getDishesName() {
		return dishesName;
	}
	public void setDishesName(String dishesName) {
		this.dishesName = dishesName;
	}
	public String getDishesDiscript() {
		return dishesDiscript;
	}
	public void setDishesDiscript(String dishesDiscript) {
		this.dishesDiscript = dishesDiscript;
	}
	public String getDishesImg() {
		return dishesImg;
	}
	public void setDishesImg(String dishesImg) {
		this.dishesImg = dishesImg;
	}
	public String getDishesTxt() {
		return dishesTxt;
	}
	public void setDishesTxt(String dishesTxt) {
		this.dishesTxt = dishesTxt;
	}
	public int getRecommend() {
		return recommend;
	}
	public void setRecommend(int recommend) {
		this.recommend = recommend;
	}
	public float getDishesPrice() {
		return dishesPrice;
	}
	public void setDishesPrice(float dishesPrice) {
		this.dishesPrice = dishesPrice;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getTableId() {
		return tableId;
	}
	public void setTableId(int tableId) {
		this.tableId = tableId;
	}
	public int getWaiterId() {
		return waiterId;
	}
	public void setWaiterId(int waiterId) {
		this.waiterId = waiterId;
	}
	public String getOrderBeginDate() {
		return orderBeginDate;
	}
	public void setOrderBeginDate(String orderBeginDate) {
		this.orderBeginDate = orderBeginDate;
	}
	public String getOrderEndDate() {
		return orderEndDate;
	}
	public void setOrderEndDate(String orderEndDate) {
		this.orderEndDate = orderEndDate;
	}
	
}
