<%@page import="com.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
      .msg {
        width: 100%;
        border: 1px solid;
        padding: 10px;
        margin: 20px;
        color: grey;
      }
      .msg-error {
        // rouge
        border-color: #d32f2f;
        background-color: #ef5350;
        color: white;
      }
      .msg-alert {
        //orange
        border-color: #ef6c00;
        background-color: #ff9800;
        color: white;
      }

      .msg-info {
        border-color: #0288d1;
        background-color: #29b6f6;
        color: white;
      }
    </style>
</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include>
	
	<%
	User user=(User)session.getAttribute("user");
	%>
	<div class="row">
      <div class="col s2"></div> 
      <form class="col s6" action="transactionServlet" method="post">
      <div class="row">
      	<div class="card-panel deep-purple  lighten-5 "><b>Fill the form below to withdraw/deposit amount</b></div>
      </div>
        <div class="row">
          <div class="right-align input-field col s6">
            <input 
              name="user_id"
              type="text"
              class="validate"
              <%="value='"+user.getUser_id()+"'" %>
            />
            <label for="user_id">User Id</label>
          </div>
        </div>
        <div class="row">
          <div class="right-align input-field col s6">
            <input
              placeholder="Your account_id"
              name="account_id"
              type="text"
              class="validate"
            />
            <label for="name">Account Id/Number</label>
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
        <div class="input-field col s6">
        	<select name="type" class="browser-default" >
      			<option value="D">Deposit</option>
      			<option value="W">Withdraw</option>
      
    		</select>
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