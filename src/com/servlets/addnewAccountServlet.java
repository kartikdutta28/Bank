package com.servlets;

import java.io.IOException;
import java.util.Date;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Account;
import com.model.User;
import com.persistence.AccountDao;

/**
 * Servlet implementation class addnewAccountServlet
 */
public class addnewAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addnewAccountServlet() {
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
		HttpSession session=request.getSession(false);
		User user=(User) session.getAttribute("user");
		AccountDao ad=new AccountDao();
		Random random=new Random();
		int account_id=Integer.parseInt(String.format("%08d", random.nextInt(100000000)));
		int user_id=user.getUser_id();
		Double amount=Double.parseDouble(request.getParameter("amount"));
		String type=request.getParameter("type");
		ad.addAccount(new Account(account_id, user_id, type, amount, new Date()));
		request.getRequestDispatcher("userHome.jsp").forward(request, response);
		doGet(request, response);
	}

}
