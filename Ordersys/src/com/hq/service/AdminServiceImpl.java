package com.hq.service;

import java.sql.SQLException;

import com.hq.dao.AdminDao;
import com.hq.dao.AdminDaoImpl;
import com.hq.pojo.Admin;
import com.hq.pojo.Dishes;
import com.hq.pojo.Waiter;


public class AdminServiceImpl implements AdminService {

	private AdminDao adminDao=new AdminDaoImpl(); 
		
	@Override
	public int AddWaiter(Waiter waiter) throws SQLException {
		// TODO Auto-generated method stub
	    return adminDao.AddWaiter(waiter);
		}

	@Override
	public int Adddishes(Dishes dishes) throws SQLException {
		// TODO Auto-generated method stub
		return adminDao.Adddishes(dishes);
	}

	@Override
	public int AddNotice(Admin admin) throws SQLException {
		// TODO Auto-generated method stub
		return adminDao.AddNotice(admin);
	}



}
