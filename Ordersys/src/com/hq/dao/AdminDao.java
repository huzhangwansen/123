package com.hq.dao;

import java.sql.SQLException;

import com.hq.pojo.Admin;
import com.hq.pojo.Dishes;
import com.hq.pojo.Waiter;

public interface AdminDao {
	public int AddWaiter(Waiter waiter) throws SQLException;

	public int Adddishes(Dishes dishes) throws SQLException;
    
	public int AddNotice(Admin admin)  throws SQLException;

}
