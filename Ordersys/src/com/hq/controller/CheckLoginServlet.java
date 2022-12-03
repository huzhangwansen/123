package com.hq.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hq.pojo.Admin;
import com.hq.pojo.Cooker;
import com.hq.pojo.Waiter;
import com.hq.service.LoginService;
import com.hq.service.LoginServiceImpl;

/**
 * Servlet implementation class CheckLoginServlet
 */
@WebServlet("/CheckLoginServlet")
public class CheckLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private LoginService loginService = new LoginServiceImpl();//实例化对象
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);//doPost方法
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String userAccount=request.getParameter("userAccount");
		String userPass=request.getParameter("userPass");
		String entity=request.getParameter("entity");
		System.out.println(userAccount);
		System.out.println(userPass);
		System.out.println(entity);
		if (entity.equals("管理员")) {
			Admin admin;
			try {
				admin=loginService.selectALlAdmin(userAccount, userPass);//赋值给admin，通过service层进入dao层查询数据找到admin
				if(admin!=null) {
					HttpSession session =request.getSession();
					session.setAttribute("admin", admin);
					response.getWriter().write("success");//login.jsp提示框
				}else {
					response.getWriter().write("fail");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if(entity.equals("后厨")){
			Cooker cooker;
			try {
				cooker=loginService.selectALlCooker(userAccount, userPass);
				if(cooker!=null) {
					HttpSession session =request.getSession();
					session.setAttribute("cooker", cooker);
					response.getWriter().write("success");
				}else {
					response.getWriter().write("fail");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if(entity.equals("服务员")){
			Waiter waiter;
			try {
				waiter=loginService.selectALlWaiter(userAccount, userPass);
				if(waiter!=null) {
					HttpSession session =request.getSession();
					session.setAttribute("waiter", waiter);
					response.getWriter().write("success");
				}else {
					response.getWriter().write("fail");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
