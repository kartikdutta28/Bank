package com.servlets;

import java.io.IOException;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.CheckBook;
import com.persistence.CheckBookDao;

/**
 * Servlet implementation class checkBookServlet
 */
public class checkBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public checkBookServlet() {
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
		CheckBookDao cd=new CheckBookDao();
		Random random=new Random();
		int acc_id=Integer.parseInt(request.getParameter("account_id"));
		String address=request.getParameter("address");
		int req_id=Integer.parseInt(String.format("%04d", random.nextInt(10000)));
		Date req_date=new Date();
		Date del_date=new Date(req_date.getTime() + TimeUnit.DAYS.toMillis( 10 ));
		String status="Accepted";
		if(cd.addCheckBookRequest(new CheckBook(req_id, acc_id, req_date, del_date, address, status))==true){
			response.getWriter().write("<div class='msg msg-info z-depth-3'>Check Book request accepted with delivery date "
					+del_date+ "</div>");
			request.getRequestDispatcher("userHome.jsp").include(request, response);
		}else{
			response.getWriter().write("<div class='msg msg-error z-depth-3 scale-transition'>Check Book request Already Exists with delivery date "
					+del_date+ "</div>");
			request.getRequestDispatcher("userHome.jsp").include(request, response);
		}
		
		doGet(request, response);
	}

}
