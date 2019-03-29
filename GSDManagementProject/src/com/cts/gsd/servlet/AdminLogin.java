package com.cts.gsd.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cts.gsd.bean.AdminRegistrationBean;
import com.cts.gsd.daoClass.AdminRegistrationDao;

/**
 * Servlet implementation class AdminLogin
 */
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String adminid = request.getParameter("admin_id");
		String password = request.getParameter("psw");
		
		AdminRegistrationBean s = new AdminRegistrationBean();
		
		s.setAdmin_ID(adminid);
		s.setPassword(password);
		
		//DaoServiceLogin ds = new DaoServiceLogin();
		
		AdminRegistrationDao ds = new AdminRegistrationDao();
		
		
		if(ds.login_check(s))
		{
			RequestDispatcher r=request.getRequestDispatcher("viewall.html");
			r.forward(request, response);
		}
		else
		{
			RequestDispatcher r= request.getRequestDispatcher("LoginFailed.jsp");
			r.forward(request, response);
		}
	}	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
