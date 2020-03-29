<%@page import="com.model.Transaction"%>
<%@page import="java.util.List"%>
<%@page import="com.persistence.TransactionDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Saarthi Bank</title>
</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	<div class="card-panel teal lighten-2"><b>Transactions between <%=request.getParameter("sdate") %> and
	<%=request.getParameter("edate") %></b>
	</div>
	<table class="centered highlight">
		<thead>
          <tr>
              <th>Account Id</th>
              <th>Amount</th>
              <th>Post Balance</th>
              <th>Transaction Type</th>
              <th>Date</th>
          </tr>
        </thead>
        <tbody>
        	<%
			TransactionDao td=new TransactionDao();
			List<Transaction>li=td.getStatementByDate(Integer.parseInt(request.getParameter("dacc_id")),
					request.getParameter("sdate"), 
					request.getParameter("edate"));
			for(Transaction t:li){
				out.println("<tr>");
				out.println("<td>"+t.getAccount_id()+"</td>");
				out.println("<td>"+t.getAmount()+"</td>");
				out.println("<td>"+t.getPost_balance()+"</td>");
				if(t.getTransaction_type().equals("D")){
					out.println("<td>Credited</td>");	
				}else{
					out.println("<td>Debited</td>");
				}
				
				out.println("<td>"+t.getDate()+"</td>");
				out.println("</tr>");
			}
			%>
        	
        </tbody>
	</table><br/>
	<div class="center-align">
		<a class="btn" onClick="window.print()">Print Statement</a><br/>
	</div><br/><br/><br/>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>