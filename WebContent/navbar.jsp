<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
    <title>Saarthi Bank</title>
    <link
      href="https://fonts.googleapis.com/icon?family=Material+Icons"
      rel="stylesheet"
    />
    <link rel="stylesheet" href="css/materialize.min.css" />
  </head>
  <style>
  	
  </style>
  <body >
    <div class="navbar">
      <nav>
        <div class="nav-wrapper">
          <a href="index.jsp" class="brand-logo"
            ><i class="large material-icons">supervisor_account</i>Saarthi
            Bank</a
          >
          <ul id="nav-mobile" class="right hide-on-med-and-down">
          	<%
            	if(session.getAttribute("name")==null){
            		out.println("<li><a href='index.jsp'>Login</a></li>");
            	}else{
            		out.println("<li><a href='userHome.jsp'>User Home</a></li>");
            	}
            %>
            
            <li><a href="createAccount.jsp">Create New Account</a></li>
            <%
            	if(session.getAttribute("name")!=null){
            		out.println("<li><a href='transactionForm.jsp'>Deposit</a></li>");
            	}
            %><%
            	if(session.getAttribute("name")!=null){
            		out.println("<li><a href='transactionForm.jsp'>Withdraw</a></li>");
            	}
            %>
            <li><a href="faqPage.jsp">FAQ</a>
            <%
            	if(session.getAttribute("name")!=null){
            		out.println("<li><a href='index.jsp'>Log Out</a></li>");
            	}
            %>
          </ul>
        </div>
      </nav>
    </div>
    <script type="text/javascript" src="js/materialize.min.js"></script>
  </body>
</html>
