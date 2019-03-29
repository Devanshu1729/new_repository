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
 * Servlet implementation class CloseTicket
 */
public class CloseTicket extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CloseTicket() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GSDdetaildao sa=new GSDdetaildao();
		String gsd_id = request.getParameter("gsd_id");
        ArrayList<GSDdetailbean> a2=sa.displayclose(gsd_id);
        request.setAttribute("display", a2);
        RequestDispatcher rd=request.getRequestDispatcher("closeticket.jsp");
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
