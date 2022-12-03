package com.hq.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.hq.dao.userDao;
import com.hq.dao.userDaoImpl;
import com.hq.pojo.Vo;

/**
 * Servlet implementation class SelectAllTeacher
 */
@WebServlet("/SelectAllWaiter")
public class SelectAllWaiter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectAllWaiter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String pageStr=request.getParameter("page");
		String limitStr=request.getParameter("limit");
		//System.out.println(pageStr);
		//System.out.println(limitStr);
		userDao userDao=new userDaoImpl();
		try {
			/* List<Object> list=userDao.selectTeacherList(); */
			 List<Object> list=userDao.selectWaiterList(pageStr,limitStr);
			//System.out.println(list);
			response.setContentType("text/html;charset=utf-8");
			Vo vo=new Vo();
			vo.setCode(0);
			vo.setMsg("success");
			vo.setCount(userDao.countWaiter());
			vo.setData(list);
			response.getWriter().write(JSONObject.toJSON(vo).toString());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
