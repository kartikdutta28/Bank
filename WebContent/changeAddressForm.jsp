<%@page import="com.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include><br/><br/>
	<% User user=(User)session.getAttribute("user");%>
	<div class="row">
      <div class="col s2"></div> 
      <form class="col s6" action="updateAddress" method="post">
      <div class="row">
          <div class="card-panel deep-purple  lighten-5 ">
            <b>Fill the form below to update address</b>
          </div>
        </div>
        <div class="row">
          <div class="right-align input-field col s3">
            <input
              disabled="disabled"
              name="user_id"
              type="text"
              class="validate"
              <%="value='"+user.getUser_id()+"'" %>
            />
            <label for="question">User Id</label>
          </div>
          <div class="right-align input-field col s3">
            <input
              disabled="disabled"
              name="user_name"
              type="text"
              class="validate"
              <%="value='"+user.getUser_name()+"'" %>
            />
            <label for="question">User Name</label>
        </div>
        </div>
        <div class="row">
          <div class="right-align input-field col s6">
            <input
              placeholder="Your new address goes here"
              name="address"
              type="text"
              class="validate"
            />
       		<input name="id" <%="value='"+user.getUser_id()+"'" %>/>
            <label for="name">Address</label>
          </div>
        </div>
        <div class="row">
          <button
            class="btn waves-effect waves-light"
            type="submit"
            name="action"
          >
            Update
            <i class="material-icons right">send</i>
          </button>
        </div>
       </form>
      </div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>