package com.hq.pojo;//

import java.util.List;

//code_返回前端数据
//msg_信息
//count_总数
//data_数据对象 
public class Vo {

	int code;
	String msg;
	int count;
	List<Object> data;//数据库传数据到前端 集合list形式 用于打印到页面，数据多，用object类
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public List<Object> getData() {
		return data;
	}
	public void setData(List<Object> data) {
		this.data = data;
	}
	
	 
}
