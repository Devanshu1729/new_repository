package com.cts.gsd.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cts.gsd.bean.AdminRegistrationBean;
import com.cts.gsd.daoClass.AdminRegistrationDao;

/**
 * Servlet implementation class AdminRegistration
 */
public class AdminRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminRegistration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String fname = request.getParameter("admin_fname");
		String lname = request.getParameter("admin_lname");
		String age = request.getParameter("age");
		String gender = request.getParameter("gender");
		String c_no = request.getParameter("contact_number");
		String adminid = request.getParameter("admin_id");
		String password = request.getParameter("pwd");


		AdminRegistrationBean rg = new  AdminRegistrationBean();
		
		rg.setAdmin_First_Name(fname);
		rg.setAdmin_Last_Name(lname);
		rg.setAge(age);
		rg.setGender(gender);
		rg.setContact_Number(c_no);
		rg.setAdmin_ID(adminid);
		rg.setPassword(password);

		AdminRegistrationDao ds = new AdminRegistrationDao();
		
		String adminid1 = ds.insert(rg);
		request.setAttribute("adminid1", adminid1);
		
		if(adminid1!=null) {

			RequestDispatcher r=request.getRequestDispatcher("AdminRegSuccess.jsp");
		    r.forward(request, response);
			//RequestDispatcher rd = request.getRequestDispatcher("insertSuccess.jsp");
			//rd.forward(request, response);
		}
		else {

			out.println("Sorry!!");
			//RequestDispatcher rd = request.getRequestDispatcher("insertError.jsp");
			// rd.forward(request, response);
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
