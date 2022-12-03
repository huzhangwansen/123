package com.hq.dao;

import java.sql.SQLException;

import com.hq.pojo.Dishes;
import com.hq.pojo.Mon;
import com.hq.pojo.Waiter;

public interface editDao {
	public int EditWaiter(Waiter waiter) throws SQLException;
	
	public int EditDishes(Dishes dishes) throws SQLException;

	public int EditMon(Mon mon) throws SQLException;

}
