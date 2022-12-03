package com.hq.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.hq.pojo.Admin;
import com.hq.pojo.Dishes;
import com.hq.pojo.Waiter;
import com.hq.utils.DBUtil;

public class AdminDaoImpl implements AdminDao {

	@Override
	public int AddWaiter(Waiter waiter) throws SQLException {
		// TODO Auto-generated method stub
		int rs;
		DBUtil dbUtil=new DBUtil();
		String sql="insert into userinfo(userId,userAccount,userPass,role,locked,faceimg) value(?,?,?,?,?,?)";
		PreparedStatement ps=dbUtil.getPreparedStatement(sql);
		
		ps.setInt(1, waiter.getUserId());
		ps.setString(2, waiter.getUserAccount());
		ps.setString(3, waiter.getUserPass());
		ps.setInt(4, waiter.getRole());
		ps.setInt(5, waiter.getLocked());
		ps.setString(6, waiter.getFaceimg());
		
		rs=ps.executeUpdate();
		
		if(rs==1) {
			return 1;
		}else {
			return 0;
		}
		

	}

	@Override
	public int Adddishes(Dishes dishes) throws SQLException {
		// TODO Auto-generated method stub
		int dishrs;
		DBUtil dbUtil=new DBUtil();
		String sql="insert into dishesinfo(dishesId,dishesName,dishesDiscript,dishesImg,dishesTxt,recommend,dishesPrice) value(?,?,?,?,?,?,?)";
        PreparedStatement ps=dbUtil.getPreparedStatement(sql);
		
		ps.setInt(1, dishes.getDishesId());
		ps.setString(2, dishes.getDishesName());
		ps.setString(3, dishes.getDishesDiscript());
		ps.setString(4, dishes.getDishesImg());
		ps.setString(5, dishes.getDishesTxt());
		ps.setInt(6, dishes.getRecommend());
		ps.setFloat(7, dishes.getDishesPrice());
		
		dishrs=ps.executeUpdate();
		
		if(dishrs==1) {
			return 1;
		}else {
			return 0;
		}
	
	
	}

	@Override
	public int AddNotice(Admin admin) throws SQLException {
		// TODO Auto-generated method stub
        int nors;
        DBUtil dbUtil=new DBUtil();
        String sql="update admin set notice = ?";
        PreparedStatement ps=dbUtil.getPreparedStatement(sql);
        ps.setString(1, admin.getNotice());
        
        nors=ps.executeUpdate();
        
        if (nors==1) {
			return 1;
		}else {
			return 0;
		}
	}

}
