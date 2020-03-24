package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Transaction;
import com.persistence.TransactionDao;

/**
 * Servlet implementation class transactionServlet
 */
public class transactionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public transactionServlet() {
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
		TransactionDao td=new TransactionDao();
		int transaction_id=Integer.parseInt(String.format("%04d", random.nextInt(10000)));
		int user_id=Integer.parseInt(request.getParameter("user_id"));
		int account_id=Integer.parseInt(request.getParameter("account_id"));
		Double  amount=Double.parseDouble(request.getParameter("amount"));
		String type=request.getParameter("type");
		String comments=request.getParameter("comments");
		Double curr_amount=td.getAmount(account_id);
		Double post_amt=0.0;
		PrintWriter out=response.getWriter();
		if(type.equalsIgnoreCase("D")){
			post_amt=curr_amount+amount;
		}else{
			post_amt=curr_amount-amount;
		}
		td.addTransaction(new Transaction(transaction_id, user_id, account_id, amount, post_amt, type, comments,new Date()));
		td.updateAccount(post_amt, account_id);
		if(type.equals("D")){
			out.write("<div class='msg msg-error z-depth-3 scale-transition'>Amount sucessfully deposited</div>");
			request.getRequestDispatcher("userHome.jsp").include(request, response);
		}else{
			out.write("<div class='msg msg-error z-depth-3 scale-transition'>Amount sucessfully withdrawn</div>");
			request.getRequestDispatcher("userHome.jsp").include(request, response);
		}
		doGet(request, response);
	}

}
