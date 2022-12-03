package com.hq.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hq.dao.editDao;
import com.hq.dao.editDaoImpl;
import com.hq.pojo.Mon;

/**
 * Servlet implementation class EditMon
 */
@WebServlet("/EditMon")
public class EditMon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditMon() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String orderId=request.getParameter("orderId");
		String tableId=request.getParameter("tableId");
		String dishesName=request.getParameter("dishesName");
		String orderBeginDate=request.getParameter("orderBeginDate");
		String orderEndDate=request.getParameter("orderEndDate");
		String waiterId=request.getParameter("waiterId");
		System.out.println(orderId);
		
		int orderId1=Integer.parseInt(orderId);
		int tableId1=Integer.parseInt(tableId);
		int waiterId1=Integer.parseInt(waiterId);
		Mon mon=new Mon();
		mon.setOrderId(orderId1);
		mon.setTableId(tableId1);
		mon.setDishesName(dishesName);
		mon.setOrderBeginDate(orderBeginDate);
		mon.setOrderEndDate(orderEndDate);
		mon.setWaiterId(waiterId1);
		
		editDao editDao=new editDaoImpl();
		try {
			if (editDao.EditMon(mon)==1) {
				response.getWriter().write("success");
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
