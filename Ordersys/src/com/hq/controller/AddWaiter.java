package com.hq.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hq.pojo.Waiter;
import com.hq.service.AdminService;
import com.hq.service.AdminServiceImpl;

/**
 * Servlet implementation class AddWaiter
 */
@WebServlet("/AddWaiter")
public class AddWaiter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private AdminService adminService=new AdminServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddWaiter() {
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
		String userId=request.getParameter("userId");
		String userAccount=request.getParameter("userAccount");
		String userPass=request.getParameter("userPass");
		String role=request.getParameter("role");
		String faceimg=request.getParameter("faceimg");
		
		Waiter waiter=new Waiter();
		int userId1=Integer.parseInt(userId);
		int role1=Integer.parseInt(role);
		waiter.setUserId(userId1);
		waiter.setUserAccount(userAccount);
		waiter.setUserPass(userPass);
		waiter.setRole(role1);
		waiter.setFaceimg(faceimg);
		
		System.out.println("waiter");
		try {
			if (adminService.AddWaiter(waiter) ==1) {
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
