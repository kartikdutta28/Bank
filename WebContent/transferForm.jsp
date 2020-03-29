<%@page import="java.util.List"%>
<%@page import="com.model.User"%>
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
	<% User user=(User)session.getAttribute("user");%>
	<div class="row">
      <div class="col s2"></div> 
      <form class="col s6" action="TransferServlet" method="post">
      <div class="row">
      	<div class="card-panel deep-purple  lighten-5 "><b>Fill the form below to transfer funds</b></div>
      </div>
        <div class="row">
          <div class="right-align input-field col s6">
          <%
        	List<Integer> li=(List<Integer>)session.getAttribute("ids");
           %>
            <select name="from_account" class="browser-default">
            	<option value="" disabled selected>Your Account Id/Number</option>
        		<%
        			for(Integer i:li){
        				out.println("<option value='"+i+"'>"+i+"</option>");		
        			}
        		%>
    		</select>
		   </div>
        </div>
        <div class="row">
          <div class="right-align input-field col s6">
            <%
        	List<Integer> li2=(List<Integer>)session.getAttribute("toids");
           %>
            <select name="target_account" class="browser-default">
            	<option value="" disabled selected>Target Account Id/Number</option>
        		<%
        			for(Integer i:li2){
        				out.println("<option value='"+i+"'>"+i+"</option>");		
        			}
        		%>
    		</select>
          </div>
        </div>
        <div class="row">
          <div class="right-align input-field col s6">
            <input
              placeholder="Amount"
              name="amount"
              type="text"
              class="validate"
            />
            <label for="amount">Amount</label>
          </div>
        </div>
        
    	<div class="row">
          <div class="right-align input-field col s6">
            <input
              placeholder="Add comments here"
              name="comments"
              type="text"
              class="validate"
            />
            <label for="comments">Comments</label>
          </div>
        </div>
        <div class="row">
          <button
            class="btn waves-effect waves-light"
            type="submit"
            name="action"
          >
            Transfer
            <i class="material-icons right">send</i>
          </button>
        </div>
      </form>
     </div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>