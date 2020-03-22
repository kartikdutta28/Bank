package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.persistence.UserDao;

import oracle.net.ns.SessionAtts;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		UserDao dao=new UserDao();
		if(dao.validate(name, pwd)==true){
			HttpSession session=request.getSession();
			session.setAttribute("name", name);
			session.setAttribute("pwd", pwd);
			request.getRequestDispatcher("userHome.jsp").forward(request, response);
		}else{
			PrintWriter out=response.getWriter();
			out.write("<div class='msg msg-error z-depth-3 scale-transition'>Invalid username or password</div>");
			request.getRequestDispatcher("index.jsp").include(request, response);
		}
		doGet(request, response);
	}

}
