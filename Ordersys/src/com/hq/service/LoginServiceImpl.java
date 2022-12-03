package com.hq.service;

import java.sql.SQLException;

import com.hq.dao.userDao;
import com.hq.dao.userDaoImpl;
import com.hq.pojo.Admin;
import com.hq.pojo.Cooker;
import com.hq.pojo.Dishes;
import com.hq.pojo.Waiter;

public class LoginServiceImpl implements LoginService {
    private userDao userDao=new userDaoImpl();
	@Override
	public Admin selectALlAdmin(String userAccount, String userPass) throws SQLException {
		// TODO Auto-generated method stub
		return userDao.selectALlAdmin(userAccount, userPass);
	}

	@Override
	public Cooker selectALlCooker(String userAccount, String userPass) throws SQLException {
		// TODO Auto-generated method stub
		return userDao.selectALlCooker(userAccount, userPass);
	}

	@Override
	public Waiter selectALlWaiter(String userAccount, String userPass) throws SQLException {
		// TODO Auto-generated method stub
		return userDao.selectALlWaiter(userAccount, userPass);
	}


	@Override
	public int addWaiter(Waiter waiter) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addDishes(Dishes dsDishes) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}


}
