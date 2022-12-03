package com.hq.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hq.pojo.Admin;
import com.hq.service.AdminService;
import com.hq.service.AdminServiceImpl;

/**
 * Servlet implementation class AddNotice
 */
@WebServlet("/AddNotice")
public class AddNotice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private AdminService adminService=new AdminServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNotice() {
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
		String notice=request.getParameter("notice");
		
		Admin admin=new Admin();
		admin.setNotice(notice);
		
		System.out.println("notice");
		try {
			if (adminService.AddNotice(admin) ==1) {
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
