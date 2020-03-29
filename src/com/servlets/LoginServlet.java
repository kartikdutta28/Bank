package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.persistence.ConnectionProvider;
import com.persistence.UserDao;

import oracle.net.aso.d;
import oracle.net.ns.SessionAtts;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static int n=0;
    /**
     * Default constructor. 
     */
	
	
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("first_name");
		String pwd=request.getParameter("password");
		if(name.equalsIgnoreCase("admin")&pwd.equalsIgnoreCase("pwd")){
			request.getRequestDispatcher("answerFaq.jsp").forward(request, response);
		}else{
			UserDao dao=new UserDao();
			PrintWriter out=response.getWriter();
			if(dao.validate(name, pwd)==true){
				HttpSession session=request.getSession();
				session.setAttribute("name", name);
				session.setAttribute("pwd", pwd);
				request.getRequestDispatcher("userHome.jsp").forward(request, response);
			}else{
				n++;
				if(n==3){
					n=0;
					dao.lockUser(name);
					out.write("<div class='msg msg-error z-depth-3 scale-transition'>Your account Has been blocked try after 24 hours</div>");
					request.getRequestDispatcher("index.jsp").include(request, response);
				}
				
				out.write("<div class='msg msg-error z-depth-3 scale-transition'>Invalid username or password  you have "+(3-n)+" attempts left before your account gets locked</div>");
				request.getRequestDispatcher("index.jsp").include(request, response);
			}
		}
		
		doGet(request, response);
	}

}
