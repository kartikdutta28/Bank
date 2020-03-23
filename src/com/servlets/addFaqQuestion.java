package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.FAQ;
import com.persistence.FaqDao;

/**
 * Servlet implementation class addFaqQuestion
 */
public class addFaqQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addFaqQuestion() {
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
		String question=request.getParameter("question");
		Random random=new Random();
		int question_id=Integer.parseInt(String.format("%04d", random.nextInt(10000)));
		String name=request.getParameter("name");
		PrintWriter out=response.getWriter();
		FaqDao fd=new FaqDao();
		fd.addAccount(new FAQ(question_id, question, null, name));
		out.println("<div class='msg msg-alert z-depth-3'>Question added sucessfully</div>");
		request.getRequestDispatcher("index.jsp").include(request, response);
		doGet(request, response);
	}

}
