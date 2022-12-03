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
import com.hq.pojo.Dishes;

/**
 * Servlet implementation class EditDishes
 */
@WebServlet("/EditDishes")
public class EditDishes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditDishes() {
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
		request.setCharacterEncoding ("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String dishesId=request.getParameter("dishesId");
		String dishesName=request.getParameter("dishesName");
		String dishesDiscript=request.getParameter("dishesDiscript");
		String dishesImg=request.getParameter("dishesImg");
		String dishesTxt=request.getParameter("dishesTxt");
		String recommend=request.getParameter("recommend");
		String dishesPrice=request.getParameter("dishesPrice");
		System.out.println(dishesId);
		
		
		int dishesId1=Integer.parseInt(dishesId);
		int recommend1=Integer.parseInt(recommend);
		float dishesPrice1=Float.parseFloat(dishesPrice);
		Dishes dishes=new Dishes();
		dishes.setDishesId(dishesId1);
		dishes.setDishesName(dishesName);
		dishes.setDishesDiscript(dishesDiscript);
		dishes.setDishesImg(dishesImg);
		dishes.setDishesTxt(dishesTxt);
		dishes.setRecommend(recommend1);
		dishes.setDishesPrice(dishesPrice1);
		
		editDao editDao=new editDaoImpl();
		try {
			if (editDao.EditDishes(dishes)==1) {
				response.getWriter().write("success");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
