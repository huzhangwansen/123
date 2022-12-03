package com.hq.dao;

import java.sql.SQLException;
import java.util.List;

import com.hq.pojo.Admin;
import com.hq.pojo.Cooker;
import com.hq.pojo.Dishes;
import com.hq.pojo.Waiter;

public interface userDao {
	public Admin selectALlAdmin(String userAccount,String userPass)  throws SQLException;
	public Cooker selectALlCooker(String userAccount,String userPass) throws SQLException;
	public Waiter selectALlWaiter(String userAccount,String userPass) throws SQLException;
	public List<Object> selectWaiterList() throws SQLException;
	public List<Object> selectWaiterList(String page,String limit) throws SQLException;
	public List<Object> selectDishesList() throws SQLException;
	public List<Object> selectMonList() throws SQLException;

	public int countWaiter() throws SQLException;
	public int countDishes() throws SQLException;
	public int countMon() throws SQLException;
	public int delwaiter(String userId) throws SQLException;
	public int deldishes(String dishesId) throws SQLException;
	public int delmon(int orderId) throws SQLException;
	Dishes selectDishes(String dishesId) throws SQLException;

	

}
