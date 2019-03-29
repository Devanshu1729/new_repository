package com.cts.gsd.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cts.gsd.bean.GSDdetailbean;
import com.cts.gsd.daoClass.GSDdetaildao;

/**
 * Servlet implementation class Viewhistory
 */
public class Viewhistory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Viewhistory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GSDdetaildao sa=new GSDdetaildao();
		String user_id = request.getParameter("user_id");
        ArrayList<GSDdetailbean> a2=sa.display(user_id);
        request.setAttribute("display", a2);
        RequestDispatcher rd=request.getRequestDispatcher("Viewhistory.jsp");
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
