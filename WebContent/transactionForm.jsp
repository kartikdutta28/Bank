<%@page import="java.util.List"%>
<%@page import="com.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Saarthi Bank</title>
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
      	<div class="card-panel deep-purple  lighten-5 hoverable">Fill the form below to withdraw/deposit amount</div>
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
        <%
        	List<Integer> li=(List<Integer>)session.getAttribute("ids");
        %>
        <div class="row">
        
			<select name="account_id" class="browser-default">
        		<%
        			for(Integer i:li){
        				out.println("<option value='"+i+"'>"+i+"</option>");		
        			}
        		%>
    		</select>
			<label for="name">Your Account Id/Number</label>
            
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
     			<option value="W">Withdraw</option>
     			<option value="D">Deposit</option> 			
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
        <div class="row center-align">
          <button
            class="btn waves-effect waves-light"
            type="submit"
            name="action"
          >
            SUBMIT
            <i class="material-icons right">send</i>
          </button>
        </div>
      </form>
     </div>
     <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>