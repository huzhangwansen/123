package com.hq.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hq.pojo.Admin;
import com.hq.pojo.Cooker;
import com.hq.pojo.Dishes;
import com.hq.pojo.Mon;
import com.hq.pojo.Waiter;
import com.hq.utils.DBUtil;

public class userDaoImpl implements userDao {

	@Override
	public Admin selectALlAdmin(String userAccount, String userPass) throws SQLException {
		// TODO Auto-generated method stub
		DBUtil dbUtil = new DBUtil();
		String sql = "select * from admin where userAccount=? and userPass=? ";
		PreparedStatement ps = dbUtil.getPreparedStatement(sql);
		ps.setString(1, userAccount);
		ps.setString(2, userPass);
		ResultSet rs = ps.executeQuery();
		Admin admin = new Admin();
		while (rs.next()) {
			admin.setUserAccount(rs.getString("userAccount"));
			admin.setUserPass(rs.getString("userPass"));
			admin.setNotice(rs.getString("notice"));
			return admin;
		}
		return null;
	}

	@Override
	public Cooker selectALlCooker(String userAccount, String userPass) throws SQLException {
		// TODO Auto-generated method stub
		DBUtil dbUtil = new DBUtil();
		String sql = "select * from cooker where userAccount=? and userPass=?";
		PreparedStatement ps = dbUtil.getPreparedStatement(sql);
		ps.setString(1, userAccount);
		ps.setString(2, userPass);
		ResultSet rs = ps.executeQuery();
		Cooker cooker = new Cooker();

		while (rs.next()) {
			cooker.setUserAccount("userAccount");
			cooker.setUserPass("userPass");
			return cooker;
		}
		return null;
	}

	@Override
	public Waiter selectALlWaiter(String userAccount, String userPass) throws SQLException {
		// TODO Auto-generated method stub
		DBUtil dbUtil = new DBUtil();
		String sql = "select * from waiter where userAccount=? and userPass=?";
		PreparedStatement ps = (PreparedStatement) dbUtil.getPreparedStatement(sql);
		ps.setString(1, userAccount);
		ps.setString(2, userPass);
		ResultSet rs = ps.executeQuery();
		Waiter waiter = new Waiter();
		while (rs.next()) {
			waiter.setUserAccount(rs.getString("userAccount"));
			waiter.setUserPass(rs.getString("userPass"));
			System.out.println("dao" + waiter);
			return waiter;
		}
		return null;
	}

	@Override
	public List<Object> selectWaiterList() throws SQLException {
		// TODOAuto-generated method stub
		DBUtil dbUtil = new DBUtil();
		String sql = "select * from userinfo";
		Statement st = (Statement) dbUtil.getStatement();
		ResultSet rs = st.executeQuery(sql);
		List<Object> list = new ArrayList<Object>();
		while (rs.next()) {
			Waiter waiter = new Waiter();
			waiter.setUserId(rs.getInt("userId"));
			waiter.setUserAccount(rs.getString("userAccount"));
			waiter.setUserPass(rs.getString("userPass"));
			waiter.setRole(rs.getInt("role"));
			waiter.setLocked(rs.getInt("locked"));
			waiter.setFaceimg(rs.getString("faceimg"));
			list.add(waiter);
		}

		return list;
	}

	@Override
	public List<Object> selectWaiterList(String page, String limit) throws SQLException {
		// TODO Auto-generated method stub
		DBUtil dbUtil = new DBUtil();
		String sql = "select * from userinfo limit ?,?";
		PreparedStatement ps = (PreparedStatement) dbUtil.getPreparedStatement(sql);
		int page1 = Integer.parseInt(page);
		int limit1 = Integer.parseInt(limit);
		ps.setInt(1, (page1 - 1) * limit1);
		ps.setInt(2, limit1);
		ResultSet rs = ps.executeQuery();
		List<Object> list = new ArrayList<Object>();
		while (rs.next()) {
			Waiter waiter = new Waiter();
			waiter.setUserId(rs.getInt("userId"));
			waiter.setUserAccount(rs.getString("userAccount"));
			waiter.setUserPass(rs.getString("userPass"));
			waiter.setRole(rs.getInt("role"));
			waiter.setLocked(rs.getInt("locked"));
			waiter.setFaceimg(rs.getString("faceimg"));
			list.add(waiter);
		}
		return list;
	}

	@Override
	public int countWaiter() throws SQLException {
		// TODO Auto-generated method stub
		DBUtil dbUtil = new DBUtil();
		String sql = "select count(*) as sum from userinfo";
		Statement st = (Statement) dbUtil.getStatement();
		ResultSet rs = st.executeQuery(sql);
		while (rs.next()) {
			return rs.getInt("sum");
		}
		return 0;
	}

	@Override
	public int countDishes() throws SQLException {
		// TODO Auto-generated method stub
		DBUtil dbUtil = new DBUtil();
		String sql = "select count(*) as sum from dishesinfo";
		Statement st = (Statement) dbUtil.getStatement();
		ResultSet dishrs = st.executeQuery(sql);
		while (dishrs.next()) {
			return dishrs.getInt("sum");
		}
		return 0;
	}

	@Override
	public List<Object> selectDishesList() throws SQLException {
		// TODO Auto-generated method stub
		DBUtil dbUtil = new DBUtil();
		String sql = "select * from dishesinfo";
		Statement st = (Statement) dbUtil.getStatement();
		ResultSet rs = st.executeQuery(sql);
		List<Object> list = new ArrayList<Object>();
		Dishes s;
		while (rs.next()) {

			s = new Dishes();

			s.setDishesId(rs.getInt("dishesId"));
			s.setDishesName(rs.getString("dishesName"));
			s.setDishesDiscript(rs.getString("dishesDiscript"));
			s.setDishesImg(rs.getString("dishesImg"));
			s.setDishesTxt(rs.getString("dishesTxt"));
			s.setRecommend(rs.getInt("recommend"));
			s.setDishesPrice(rs.getFloat("dishesPrice"));

			list.add(s);

		}
		return list;
	}

	@Override
	public int delwaiter(String userId) throws SQLException {
		// TODO Auto-generated method stub
		DBUtil dbUtil = new DBUtil();

		String sql = "delete from userinfo where userId=?";
		PreparedStatement ps = (PreparedStatement) dbUtil.getPreparedStatement(sql);

		ps.setString(1, userId);
		int rs = ps.executeUpdate();
		if (rs == 1) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public int deldishes(String dishesId) throws SQLException {
		// TODO Auto-generated method stub
		DBUtil dbUtil = new DBUtil();

		String sql = "delete from dishesinfo where dishesId=?";
		PreparedStatement ps = (PreparedStatement) dbUtil.getPreparedStatement(sql);

		ps.setString(1, dishesId);
		int rs = ps.executeUpdate();
		if (rs == 1) {
			return 1;

		} else {
			return 0;
		}
	}


	@Override
	public Dishes selectDishes(String dishesId) throws SQLException {
		// TODO Auto-generated method stub

		return null;
	}

	@Override
	public List<Object> selectMonList() throws SQLException {
		// TODO Auto-generated method stub
		DBUtil dbUtil = new DBUtil();
		String sql = "select * from orderinfo";
		Statement st = (Statement) dbUtil.getStatement();
		ResultSet rs = st.executeQuery(sql);
		List<Object> list = new ArrayList<Object>();
		while (rs.next()) {
			Mon mon = new Mon();
			mon.setOrderId(rs.getInt("orderId"));
			mon.setTableId(rs.getInt("tableId"));
			mon.setDishesName(rs.getString("dishesName"));
			mon.setOrderBeginDate(rs.getString("orderBeginDate"));
			mon.setOrderEndDate(rs.getString("orderEndDate"));
			mon.setWaiterId(rs.getInt("waiterId"));
			list.add(mon);
		}

		return list;
	}

	@Override
	public int delmon(int orderId) throws SQLException {
		// TODO Auto-generated method stub
		DBUtil dbUtil = new DBUtil();

		String sql = "delete from orderinfo where orderId=?";
		PreparedStatement ps = (PreparedStatement) dbUtil.getPreparedStatement(sql);
		ps.setInt(1, orderId);
		int rs = ps.executeUpdate();
		if (rs == 1) {
			return 1;
		} else {
			return 0;
		}
	}

	
	/*
	 * @Override public List<Object> selectMonList(String page, String limit) throws
	 * SQLException { // TODO Auto-generated method stub DBUtil dbUtil=new DBUtil();
	 * String sql="select * from orderInfo limit ?,?"; PreparedStatement ps
	 * =(PreparedStatement) dbUtil.getPreparedStatement(sql); int
	 * page1=Integer.parseInt(page); int limit1=Integer.parseInt(limit);
	 * ps.setInt(1, (page1-1)*limit1); ps.setInt(2, limit1); ResultSet rs
	 * =ps.executeQuery(); List<Object> list=new ArrayList<Object>();
	 * while(rs.next()) { Mon mon=new Mon(); mon.setOrderId(rs.getInt("orderId"));
	 * mon.setTableId(rs.getInt("tableId"));
	 * mon.setDishesName(rs.getString("dishesName"));
	 * mon.setOrderBeginDate(rs.getString("orderBeginDate"));
	 * mon.setOrderEndDate(rs.getString("orderEndDate"));
	 * mon.setWaiterId(rs.getInt("waiterId")); } return list; }
	 */

	@Override
	public int countMon() throws SQLException {
		// TODO Auto-generated method stub
		DBUtil dbUtil = new DBUtil();
		String sql = "select count(*) as sum from orderinfo";
		Statement st = (Statement) dbUtil.getStatement();
		ResultSet rs = st.executeQuery(sql);
		while (rs.next()) {
			return rs.getInt("sum");
		}
		return 0;
	}
	 

}
