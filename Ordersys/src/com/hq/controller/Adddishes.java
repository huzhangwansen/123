 package com.hq.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hq.pojo.Dishes;
import com.hq.service.AdminService;
import com.hq.service.AdminServiceImpl;

/**
 * Servlet implementation class AddWaiter
 */
@WebServlet("/Adddishes")
public class Adddishes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private AdminService adminService=new AdminServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Adddishes() {
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
		//doGet(request, response);
		String dishesId=request.getParameter("dishesId");
		String dishesName=request.getParameter("dishesName");
		String dishesDiscript=request.getParameter("dishesDiscript");
		String dishesImg=request.getParameter("dishesImg");
		String dishesTxt=request.getParameter("dishesTxt");
		String recommend=request.getParameter("recommend");
		String dishesPrice=request.getParameter("dishesPrice");
		
		
		Dishes dishes=new Dishes();
		int dishesId1=Integer.parseInt(dishesId); 
		int recommend1=Integer.parseInt(recommend);
		float dishesPrice1=Float.parseFloat(dishesPrice);
		dishes.setDishesId(dishesId1);
		dishes.setDishesName(dishesName);
		dishes.setDishesDiscript(dishesDiscript);
		dishes.setDishesImg(dishesImg);
		dishes.setDishesTxt(dishesTxt);
		dishes.setRecommend(recommend1);
		dishes.setDishesPrice(dishesPrice1);
		
		System.out.println("dishes");
		try {
			if (adminService.Adddishes(dishes) ==1) {
			   response.getWriter().write("success");
			} else {
               response.getWriter().write("fail");				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
