package com.hq.pojo;

import lombok.Data;

@Data
public class Admin{
	private int userId;
	private String userAccount;
	private String userPass;
	private int role;
	private int locked;
	private String faceimg;
	private String notice;
	
	public String getNotice() {
		return notice; 
	}                 
	public void setNotice(String notice) {
		this.notice = notice;
	}
	@Override
	public String toString() {
		return "Admin [userAccount=" + userAccount + ", userPass=" + userPass + "]";
	}
}