package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.CheckBook;
import com.persistence.CheckBookDao;
import com.persistence.UserDao;

/**
 * Servlet implementation class updateAddress
 */
public class updateAddress extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateAddress() {
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
		int id=Integer.parseInt(request.getParameter("user_id"));
		String address=request.getParameter("address");
		UserDao ud=new UserDao();
		CheckBookDao cd=new CheckBookDao();
		CheckBook ck=cd.getStatus(id);
		if(ck!=null){
			cd.updateAddress(id, address);
		}
		ud.updateAdd(id, address);
		response.getWriter().write("<div class='msg msg-info z-depth-3'>Address updated sucessfully</div>");
		request.getRequestDispatcher("userHome.jsp").include(request, response);
		doGet(request, response);
	}

}
