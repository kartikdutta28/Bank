package com.servlets;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.User;
import com.persistence.UserDao;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
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
		Random random=new Random();
		int user_id=Integer.parseInt(String.format("%04d", random.nextInt(10000)));
		int account_id=Integer.parseInt(String.format("%08d", random.nextInt(100000000)));
		String first_name=request.getParameter("first_name");
		String last_name =request.getParameter("last_name");
		String address =request.getParameter("address");
		String user_name=request.getParameter("user_name");
		String ph_no=request.getParameter("ph_no");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		Float amount=Float.parseFloat(request.getParameter("amount"));
		UserDao dao=new UserDao();
		dao.addUser(new User(user_id, account_id, first_name, last_name, address, user_name, ph_no, password, email,amount));
		response.sendRedirect("index.jsp");
	}

}
