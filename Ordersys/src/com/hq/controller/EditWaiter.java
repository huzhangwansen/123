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
import com.hq.pojo.Waiter;

/**
 * Servlet implementation class EditWaiter
 */
@WebServlet("/EditWaiter")
public class EditWaiter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditWaiter() {
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
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String userId=request.getParameter("userId");
		String userAccount=request.getParameter("userAccount");
		String userPass=request.getParameter("userPass");
		String role=request.getParameter("role");
		String locked=request.getParameter("locked");
		String faceimg=request.getParameter("faceimg");
		System.out.println(userId);
		
		int userId1=Integer.parseInt(userId);
		int role1=Integer.parseInt(role);
		int locked1=Integer.parseInt(locked);
		Waiter waiter=new Waiter();
		waiter.setUserId(userId1);
		waiter.setUserAccount(userAccount);
		waiter.setUserPass(userPass);
		waiter.setRole(role1);
		waiter.setLocked(locked1);
		waiter.setFaceimg(faceimg);
		
		editDao editDao=new editDaoImpl();
		  try {
			if(editDao.EditWaiter(waiter)==1) {
				  response.getWriter().write("success");
			  }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}

}
