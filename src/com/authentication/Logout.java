package com.authentication;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Logout
 */

public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Logout() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
		 System.out.println("logout====="+request.getSession(false));
		 if(request.getSession(false)==null) {
			 response.sendRedirect("../sessionout");
		 }
		 else {
		 response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		 response.addHeader("Cache-Control", "post-check=0, pre-check=0");
		 response.setHeader("Pragma", "no-cache");
		 response.setDateHeader("Expires", 0);
		 HttpSession session = request.getSession(false);
         session.setAttribute("Authorization", null);            
         session.invalidate();
         System.out.println(session);
         //RequestDispatcher reqdispatch=request.getRequestDispatcher("Logout.jsp");
         //reqdispatch.forward(request, response);
         response.sendRedirect("../logout");
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
