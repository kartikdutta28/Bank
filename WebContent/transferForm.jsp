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
            <input
              placeholder="Your account Id"
              name="from_account"
              type="text"
              class="validate"
            />
            <label for="name">Your Account Id/Number</label>
          </div>
        </div>
        <div class="row">
          <div class="right-align input-field col s6">
            <input
              placeholder="Target account Id"
              name="target_account"
              type="text"
              class="validate"
            />
            <label for="name">Target Account Id/Number</label>
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