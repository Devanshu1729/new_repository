package com.cts.gsd.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cts.gsd.bean.UserTicketRaisebean;
import com.cts.gsd.daoClass.UserTicketRaisedao;

/**
 * Servlet implementation class UTRdisplay
 */
public class UTRdisplay extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UTRdisplay() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 UserTicketRaisedao sd=new UserTicketRaisedao();
         ArrayList<UserTicketRaisebean> a1=sd.displayAll();
         request.setAttribute("dis", a1);
         RequestDispatcher rd=request.getRequestDispatcher("DisplayGSD.jsp");
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
