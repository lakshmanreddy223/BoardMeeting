package com.authentication;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.boardmeetutil.BoardMeetingSql;
import com.boardmeetutil.DBConnection;
import com.serverinit.ConfigListener;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		    
		      String uname= request.getParameter("boarduname");
		      String pass=request.getParameter("boardpass");
		      System.out.println("Uname=="+uname+"==Pass"+pass);
		      RequestDispatcher requestDispatcher=null;
		      if(uname==null || pass ==null) {
		    	  response.sendRedirect("../invalid");
		      }
		      else {
		      SimpleDateFormat dateformate=null;
		        boolean authenticationStatus=false;
		        String memberid="";
		        String memname="";
		        String designation="";
		        String imagepath="";
		        String username="";
		        String phone="";
		        String dob="";
		        
		      //session.setAttribute("Authorization", "");
		         DBConnection con=new DBConnection(BoardMeetingSql.GetAllMembers);
					try {
						ResultSet RSet=con.preparedStatment.executeQuery();
						while(RSet.next()) {						
							username=RSet.getString("email");
							dob=RSet.getString("dob");
							dateformate=new SimpleDateFormat(ConfigListener.getProperty("I_DOBStrToDate"));
							Date dobdate=dateformate.parse(dob);
							dateformate.applyPattern(ConfigListener.getProperty("J_AuthNormalizeDate"));
							dob=dateformate.format(dobdate).replace("-","");
							if(uname.equals(username.trim()) && dob.equals(pass.trim())) {
								memberid=String.valueOf(RSet.getInt("member_id")).trim();
								memname=RSet.getString("member_name");
								designation=RSet.getString("designation");
								imagepath=RSet.getString("image_path");
								phone=RSet.getString("phone_no");
								authenticationStatus=true;
								break;
							}	
						}
						
					}
					catch (SQLException | ParseException e) {
						e.printStackTrace();
					}
					if(authenticationStatus) {
						 String encode= uname+":"+pass; 
				         byte[] byt= Base64.getEncoder().encode(encode.getBytes());
				         String authheader= new String(byt);
				         System.out.println(byt);
				         HttpSession session=request.getSession();
				         //session.setAttribute(name, value);
				         session.setAttribute("Authorization", "Basic "+authheader);
				         session.setAttribute("member_name", memname);
				         session.setAttribute("memberid", memberid);
				         session.setAttribute("email", username);
				         session.setAttribute("designation", designation);
				         session.setAttribute("phone", phone);
				         session.setAttribute("imagepath", imagepath);
				        // response.sendRedirect("www.google.com");
				         requestDispatcher = request
				                    .getRequestDispatcher("/home");
				         System.out.println("dsdsssasadsadsad======");
				         requestDispatcher.forward(request, response);
					}
					else {
						response.sendRedirect("../invalid");
					}
		          }
	           }

	public static void main(String args[]) {
		 String encode= "Nick@gmail.com"+":"+"18051948"; 
         byte[] byt= Base64.getEncoder().encode(encode.getBytes());
          String str= new String(byt);
          System.out.println(str);
	}
	
}
