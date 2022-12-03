package com.hq.service;

import java.sql.SQLException;

import com.hq.pojo.Admin;
import com.hq.pojo.Cooker;
import com.hq.pojo.Dishes;
import com.hq.pojo.Waiter;

public interface LoginService {
	public Admin selectALlAdmin(String userAccount,String userPass)  throws SQLException;
	public Cooker selectALlCooker(String userAccount,String userPass) throws SQLException;
	public Waiter selectALlWaiter(String userAccount,String userPass) throws SQLException;

	public int addWaiter(Waiter waiter) throws SQLException;
	public int addDishes(Dishes dsDishes) throws SQLException;
}
