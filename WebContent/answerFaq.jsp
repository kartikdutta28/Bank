<%@page import="java.util.List"%>
<%@page import="com.persistence.FaqDao"%>
<%@page import="com.model.FAQ"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	
	<% 
		FaqDao fd=new FaqDao();
		List<FAQ> li=fd.getUnanswered();
		
	%>
	<div class="row">
		<div class="col s2"></div> 
		<form class="col s6" action="answerQuesServ" method="post">
		<%
			for(FAQ f:li){
				out.write("<div class='row'>");
				out.write("<div class='right-align input-field col s6'>");
				out.write("<div class='card-panel red accent-2 white-text text-darken-2'>"+f.getQuestion()+"</div><br/>");
				out.write("<input type='hidden' name='ques_id' value='"+f.getQuestion_id()+"'></input>");
		        out.write("<input placeholder='Your Answer goes here....' name='answer' type='text' class='validate'/>"
		        +"<label for='answer'>Answer</label></div></div>");  
		        out.write("<div class='row'>");
		        out.write("<button class='btn waves-effect waves-light' type='submit' name='action'>"+
		        "Answer<i class='material-icons right'>send</i></button></div>");
			}
		%>
	  </form>
	 </div>
	
	
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>