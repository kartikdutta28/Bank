<%@page import="com.model.User"%>
<%@page import="com.persistence.UserDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Saarthi Bank</title>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link rel="stylesheet" href="css/materialize.min.css">
</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	<%
		String name=(String)session.getAttribute("name");
		String pwd=(String)session.getAttribute("pwd");
		UserDao dao=new UserDao();
		User user=dao.getUserInfo(name, pwd);
	%>
	<div class="row">

      <div class="col s3">
        <!-- Grey navigation panel -->
        <ul class="collection with-header">
        <li class="collection-header"><h4>Quick Links</h4></li>
        <li class="collection-item"><div>Request CheckBook<a href="#!" class="secondary-content"><i class="material-icons">book</i></a></div></li>
        <li class="collection-item"><div>Check Balance<a href="#!" class="secondary-content"><i class="material-icons">functions</i></a></div></li>
        <li class="collection-item"><div>Transfer Funds<a href="#!" class="secondary-content"><i class="material-icons">forward</i></a></div></li>
        <li class="collection-item"><div>Width draw<a href="#!" class="secondary-content"><i class="material-icons">credit_card</i></a></div></li>
        <li class="collection-item"><div>Deposit<a href="#!" class="secondary-content"><i class="material-icons">create_new_folder</i></a></div></li>
      </ul>
      </div>

      <div class="col s6">
         
      <div class="card blue-grey darken-1">
        <div class="card-content white-text">
          <span class="card-title"><b>User Name :</b> <%=user.getUser_name() %></span>
          <span class="card-title"><b>Account Number :</b> <%=user.getAccount_id() %></span>
          <span class="card-title"><b>First Name :</b> <%=user.getFirst_name() %></span>
          <span class="card-title"><b>Last Number :</b> <%=user.getLast_name() %></span>
          <span class="card-title"><b>User Id :</b> <%=user.getUser_id() %></span>
          <span class="card-title"><b>Phone Number :</b> <%= "+91"+user.getPhone_number() %></span>
          <p><b>Address :</b> <%=user.getAddress() %></p>
        </div>
        <div class="card-action">
          <a href="#">View monthly statement</a>
          <a href="#">View Annual statement</a>
        </div>
      
  </div>
      </div>

    </div>
    
    <script type="text/javascript" src="js/materialize.min.js"></script>
    <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>