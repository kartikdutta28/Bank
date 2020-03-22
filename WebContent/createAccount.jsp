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
	<div class="row">
	<div class="col s2"></div>
    <form class="col s8" action="RegisterServlet" method="post">
      <div class="row">
        <div class="input-field col s6">
          <input placeholder="Placeholder" name="first_name" type="text" class="validate">
          <label for="first_name">First Name</label>
        </div>
        <div class="input-field col s6">
          <input name="last_name" type="text" class="validate">
          <label for="last_name">Last Name</label>
        </div>
      </div>
      <div class="row">
        <div class="input-field col s12">
          <input placeholder="Current address only" name="address" type="text" class="validate">
          <label for="disabled">Address</label>
        </div>
      </div>
      <div class="row">
      	<div class="input-field col s12">
      	<input placeholder="User name/Log in Name" name="user_name" type="text" class="validate">
          <label for="user_name">User Name</label>
          </div>
      </div>
      <div class="row">
      	<div class="input-field col s12">
      	<input placeholder="Phone Number(+91)" name="ph_no" type="text" class="validate">
          <label for="ph_no">Phone Number</label>
          </div>
      </div>
      <div class="row">
        <div class="input-field col s6">
          <input name="password" type="password" class="validate">
          <label for="password">Password</label>
        </div>
        <div class="input-field col s6">
          <input name="re-password" type="password" class="validate">
          <label for="re-password">Re-enter Password</label>
        </div>
      </div>
      <div class="row">
        <div class="input-field col s12">
          <input name="email" type="email" class="validate">
          <label for="email">Email</label>
        </div>
      </div>
      <div class="row">
      	<button class="btn waves-effect waves-light" type="submit" name="action">Submit
    	<i class="material-icons right">send</i>
  		</button>
      </div>
      <div class="col s2"></div>
    </form>
    </div>
    <script type="text/javascript" src="js/materialize.min.js"></script>
</body>
</html>