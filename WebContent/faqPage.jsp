<%@page import="com.model.FAQ"%>
<%@page import="java.util.List"%>
<%@page import="com.persistence.FaqDao"%>
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
	<%
		FaqDao dao=new FaqDao();
		List<FAQ> li=dao.getAll();
	%>
	<br/><br/>
	<div class="row">
      <div class="col s2"></div> 
      <form class="col s6" action="addFaqQuestion" method="post">
        <div class="row">
          <div class="right-align input-field col s6">
            <input
              placeholder="Your Question goes here...."
              name="question"
              type="text"
              class="validate"
            />
            <label for="question">Question</label>
          </div>
        </div>
        <div class="row">
          <div class="right-align input-field col s6">
            <input
              placeholder="Your user name/login name"
              name="name"
              type="text"
              class="validate"
            />
            <label for="name">User name/Login name</label>
          </div>
        </div>
        <div class="row">
          <button
            class="btn waves-effect waves-light"
            type="submit"
            name="action"
          >
            Submit
            <i class="material-icons right">send</i>
          </button>
        </div>
      </form>
     </div>
     <div class="row">
     	<div class="col s2"></div>
     	<div class="col s6">
     	<div class="card-panel">
    		<span class="blue-text text-darken-2"><b>Frequently asked questions (FAQ)</b></span>
  		</div>
     	<%
		for(FAQ f:li){
			out.println("<div class='card-panel red accent-2 white-text text-darken-2'><b>Question :</b>"+f.getQuestion()+"</div>");
			out.println("<div class='card-panel red accent-1 white-text text-darken-2'><b>Answer :</b>"+f.getAnswer()+"</div><br/>");
			out.println(" <div class='divider'></div>");
		}
     	
	%>
	</div>
     </div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>