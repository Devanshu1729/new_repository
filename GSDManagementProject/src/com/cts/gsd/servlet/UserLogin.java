package com.cts.gsd.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cts.gsd.bean.UserRegistrationBean;
import com.cts.gsd.daoClass.UserRegistrationDao;

/**
 * Servlet implementation class UserLogin
 */
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid =request.getParameter("user_id");
		String password = request.getParameter("psw");
		
		UserRegistrationBean sb = new UserRegistrationBean();
		
		sb.setUser_ID(userid);
		sb.setPassword(password);
		System.out.println(userid+" "+password);
		//DaoServiceLogin ds = new DaoServiceLogin();
		
		UserRegistrationDao ds = new UserRegistrationDao();
		System.out.println("befor if");
		if(ds.login_check(sb))
		{
			RequestDispatcher r=request.getRequestDispatcher("Search.html");
			r.forward(request, response);
		}
		else
		{
			RequestDispatcher r= request.getRequestDispatcher("LoginFailedU.jsp");
			r.forward(request, response);
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
