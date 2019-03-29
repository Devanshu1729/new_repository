package com.cts.gsd.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cts.gsd.bean.GSDdetailbean;
import com.cts.gsd.daoClass.GSDdetaildao;

/**
 * Servlet implementation class AdminUpdate
 */
public class AdminUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("inside adminupdateServlet");
		String uid=request.getParameter("user_id");
		String gid=request.getParameter("gsd_id");
		String id=request.getParameter("issue_description");
		String st=request.getParameter("status");
		GSDdetailbean gd=new GSDdetailbean();
		gd.setUSER_ID(uid);
		gd.setGSD_ID(gid);
		gd.setIssue_Description(id);
		gd.setStatus(st);
		GSDdetaildao gs = new GSDdetaildao();
		if(gs.update(gd))
		{
			RequestDispatcher r=request.getRequestDispatcher("insertError.jsp");
			r.forward(request, response);
		}
		else
		{
			RequestDispatcher r=request.getRequestDispatcher("insertSuccess.jsp");
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
