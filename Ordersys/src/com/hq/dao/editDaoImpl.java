package com.hq.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.hq.pojo.Dishes;
import com.hq.pojo.Mon;
import com.hq.pojo.Waiter;
import com.hq.utils.DBUtil;

public class editDaoImpl implements editDao {

	@Override
	public int EditWaiter(Waiter waiter) throws SQLException {
		// TODO Auto-generated method stub
		DBUtil dbUtil = new DBUtil();
		String sql = "update userinfo set userAccount=?,userPass=?,role=?,locked=?,faceimg=?  where userId=?";
		PreparedStatement ps = (PreparedStatement) dbUtil.getPreparedStatement(sql);
		ps.setInt(1, waiter.getUserId());
		ps.setString(2, waiter.getUserAccount());
		ps.setString(3, waiter.getUserPass());
		ps.setInt(4, waiter.getRole());
		ps.setInt(5, waiter.getLocked());
		ps.setString(6, waiter.getFaceimg());
		int rs=ps.executeUpdate();
		while(rs==1) {
			
			return 1;
		}
		
		return 0;
	}

	@Override
	public int EditDishes(Dishes dishes) throws SQLException {
		// TODO Auto-generated method stub
		DBUtil dbUtil = new DBUtil();
		String sql = "update dishesinfo set dishesName=?,dishesDiscript=?,dishesImg=?,dishesTxt=?,recommend=?,dishesPrice=?  where dishesId=?";
		PreparedStatement ps = (PreparedStatement) dbUtil.getPreparedStatement(sql);
		ps.setInt(1, dishes.getDishesId());
		ps.setString(2, dishes.getDishesName());
		ps.setString(3, dishes.getDishesDiscript());
		ps.setString(4, dishes.getDishesImg());
		ps.setString(5, dishes.getDishesTxt());
		ps.setInt(6, dishes.getRecommend());
		ps.setFloat(7, dishes.getDishesPrice());
		
		int rs=ps.executeUpdate();
		while(rs==1) {
			
			return 1;
		}
		return 0;
	}

	@Override
	public int EditMon(Mon mon) throws SQLException {
		// TODO Auto-generated method stub
		DBUtil dbUtil=new DBUtil();
		String sql="update dishesinfo set tableId=?,dishesName=?,orderBeginDate=?,orderEndDate=?,waiterId=?  where orderId=?";
		PreparedStatement ps = (PreparedStatement) dbUtil.getPreparedStatement(sql);
		ps.setInt(1, mon.getOrderId());
		ps.setInt(2, mon.getTableId());
		ps.setString(3, mon.getDishesName());
		ps.setString(4, mon.getOrderBeginDate());
		ps.setString(5, mon.getOrderEndDate());
		ps.setInt(6, mon.getWaiterId());
		
		int rs=ps.executeUpdate();
		while (rs==1) {
			return 1;
		}
		return 0;
	}


}
