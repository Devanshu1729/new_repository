package com.cts.gsd.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cts.gsd.bean.UserRegistrationBean;
import com.cts.gsd.daoClass.UserRegistrationDao;

/**
 * Servlet implementation class DisplayUserDetails
 */
public class DisplayUserDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayUserDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserRegistrationDao sd=new UserRegistrationDao();
        ArrayList<UserRegistrationBean> a1=sd.displayAll();
        request.setAttribute("display", a1);
        RequestDispatcher rd=request.getRequestDispatcher("DisplayUserDetails.jsp");
        rd.forward(request,response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
