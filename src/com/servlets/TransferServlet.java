package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Transfer;
import com.persistence.TransactionDao;
import com.persistence.TransferDao;

/**
 * Servlet implementation class TransferServlet
 */
public class TransferServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransferServlet() {
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
		int account_id=Integer.parseInt(request.getParameter("from_account"));
		int target_account=Integer.parseInt(request.getParameter("target_account"));
		Double amount = Double.parseDouble(request.getParameter("amount"));
		String comments = request.getParameter("comments");
		PrintWriter out=response.getWriter();
		Random random=new Random();
		int transaction_id=Integer.parseInt(String.format("%04d", random.nextInt(10000)));
		TransferDao td=new TransferDao();
		TransactionDao tr=new TransactionDao();
		Double fa=tr.getAmount(account_id);
		Double ta=tr.getAmount(target_account);
		boolean f=tr.checkCounter(account_id);
		if(f==false){
			out.write("<div class='msg msg-error z-depth-3 scale-transition'>You cant do more than 3 transactions a day</div>");
			request.getRequestDispatcher("userHome.jsp").include(request, response);
		}else{
			int c=tr.getCounter(account_id);
			tr.updateAccount(fa-amount, account_id,c);
			tr.updateAccountForTrac(ta+amount, target_account);
			//td.fromOperation(account_id, amount,target_account);
			td.addTransfer(new Transfer(transaction_id, account_id, target_account, amount, comments, new Date()));
			out.write("<div class='msg msg-error z-depth-3 scale-transition'>Funds Sucessfully transfered</div>");
			request.getRequestDispatcher("userHome.jsp").include(request, response);
		}
		
		
		
		doGet(request, response);
	}

}
