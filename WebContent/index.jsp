<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link rel="stylesheet" href="css/materialize.min.css">
</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	<br/><br/><br/><br/>
	<div class="row">
	<div class="col s2">
	</div>
    <form class="col s6" action="LoginServlet" method="post">
      <div class="row">
        <div class="right-align input-field col s6">
          <input placeholder="User name" name="first_name" type="text" class="validate">
          <label for="first_name">User Name</label>
        </div>
      </div>
      <div class="row">
		<div class="input-field col s6">
          <input name="password" type="password" class="validate">
          <label for="last_name">Password</label>
        </div>      
      </div>
      <div class="row">
      	<button class="btn waves-effect waves-light" type="submit" name="action">Submit
    	<i class="material-icons right">send</i>
  		</button>
      </div>
    </form>
    <div class="col s4">
      <div class="card blue-grey darken-1">
        <div class="card-content white-text">
          <span class="card-title">Transfer Funds</span>
          <p>You can easily transfer funds to accounts in the same bank for free.</p>
        </div>
        <div class="card-action">
          <a href="#">Transfer Funds $</a>
        </div>
      </div>
    </div>
    <div class="col s4">
      <div class="card blue-grey darken-1">
        <div class="card-content white-text">
          <span class="card-title">Request Check Book</span>
          <p>Running out of checks..?<br/>Don't forget to apply for checkbooks here</p>
        </div>
        <div class="card-action">
          <a href="#">Apply For Cheque Book</a>
        </div>
      </div>
    </div>
  </div>
	<script type="text/javascript" src="js/materialize.min.js"></script>
</body>
</html>