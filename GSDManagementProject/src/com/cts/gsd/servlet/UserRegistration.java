package com.cts.gsd.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cts.gsd.bean.UserRegistrationBean;
import com.cts.gsd.daoClass.UserRegistrationDao;

/**
 * Servlet implementation class UserRegistration
 */
public class UserRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserRegistration() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String fname = request.getParameter("user_fname");
		String lname = request.getParameter("user_lname");
		String age = request.getParameter("age");
		String gender = request.getParameter("gender");
		String c_no = request.getParameter("contact_number");
		String city = request.getParameter("city");
		String zipcode = request.getParameter("zip_code");
		String userid = request.getParameter("user_Id");
		String password = request.getParameter("pwd");


		UserRegistrationBean sb = new  UserRegistrationBean();
		sb.setUser_First_Name(fname);
		sb.setUser_Last_Name(lname);
		sb.setAge(age);
		sb.setGender(gender);
		sb.setContact_Number(c_no);
		sb.setCity(city);
		sb.setZip_Code(zipcode);
		sb.setUser_ID(userid);
		sb.setPassword(password);

		UserRegistrationDao sd = new UserRegistrationDao();
		String st = sd.insert(sb);
		request.setAttribute("st", st);
		if(st != null) {

			RequestDispatcher r=request.getRequestDispatcher("Success.jsp");
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
