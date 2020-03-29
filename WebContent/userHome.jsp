<%@page import="com.model.CheckBook"%>
<%@page import="com.persistence.CheckBookDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.model.Account"%>
<%@page import="java.util.List"%>
<%@page import="com.persistence.AccountDao"%>
<%@page import="com.model.User"%> <%@page import="com.persistence.UserDao"%> <%@
page language="java" contentType="text/html; charset=ISO-8859-1"
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
    <style>
      .msg {
        width: 100%;border: 1px solid;padding: 10px;margin: 20px;color: grey;
      }.msg-error {
        // rouge
        border-color: #d32f2f;background-color: #ef5350;color: white;
      }.msg-alert {
        //orange
        border-color: #ef6c00;background-color: #ff9800;color: white;
      }.msg-info {
        border-color: #0288d1;background-color: #29b6f6;color: white;
      }
    </style>
  </head>
  <body>
    <jsp:include page="navbar.jsp"></jsp:include>
    <% String name=(String)session.getAttribute("name"); String
    pwd=(String)session.getAttribute("pwd"); UserDao dao=new UserDao(); User
    user=dao.getUserInfo(name, pwd); 
    session.setAttribute("user", user);
    AccountDao ad=new AccountDao();
    List<Account> list=ad.getAccountInfo(user.getUser_id());
    List<Account> list2=ad.getAccountInfoExcept(user.getUser_id());
    List<Integer> ids=new ArrayList<Integer>();
    List<Integer> toids=new ArrayList<Integer>();
    for(Account a:list){
    	ids.add(a.getAccount_id());
    }
    for(Account a:list2){
    		toids.add(a.getAccount_id());
    }
    %>
    <div class="row">
      <div class="col s3">
        <!-- Grey navigation panel -->
        <ul class="collection with-header">
          <li class="collection-header"><h4>Quick Links</h4></li>
          <li class="collection-item">
            <div>
              Get Statement<a href="#" class="secondary-content"
                ><i class="material-icons">functions</i></a
              >
              <form action="statement.jsp" method="post">
              <label for="acc_id">Select account id</label>
              	<select name="acc_id" class="browser-default">
        		<%
        			for(Integer i:ids){
        				out.println("<option value='"+i+"'>"+i+"</option>");		
        			}
        		%>
    		</select>
              	<input type="text" name="rows" placeholder="Enter the no of transactions you wish to see">
              	<input class="btn" type="submit" value="Get Statement">
              </form>
            </div>
          </li>
          <li class="collection-item">
            <div>
              Get Statement By Date<a href="#" class="secondary-content"
                ><i class="material-icons">functions</i></a
              ><br/>
              <form action="statementByDate.jsp" method="post">

                <label for="dacc_id">Select account id</label>
              	<select name="dacc_id" class="browser-default">
        		<%
        			for(Integer i:ids){
        				out.println("<option value='"+i+"'>"+i+"</option>");		
        			}
        		%>
        </select>
        <label for="sdate">Select start date</label>
                <input type="date" name="sdate" placeholder="Start date here"><br/>
                <label for="edate">Select end date</label>
              	<input type="date" name="edate" placeholder="End Date"><br/>
              	<input class="btn" type="submit" value="Get Statement">
              </form>
            </div>
          </li>
          
        </ul>
      </div>

      <div class="col s7">
      	
        <div class="card blue-grey darken-1 hoverable">
          <div class="card-content white-text">
            <span class="card-title"
              ><b>User Name :</b> <%=user.getUser_name() %></span>
              <p><b>First Name :</b> <%=user.getFirst_name() %></p>
              <p><b>Last Name :</b> <%=user.getLast_name() %></p>
            <p><b>Address :</b> <%=user.getAddress() %></p>
            <p><b>Email Id :</b> <%=user.getEmail() %></p>
            <p><b>Transaction Password :</b> <%=user.getTransaction_password() %></p>
          </div>
          <div class="card-action">
          	<a href="addAccount.jsp">Add account</a>
        </div>
        </div>
        <%
		for(Account a:list){
		
			String t="";
			String p="";
			if(a.getAccount_type().equals("SV")){
				t+="Savings Account";
			}else{
				t+="Salary Account";
			}if(a.getUser_type().equals("N")){
				p+="Normal User Account with max 3 transfers a day";
			}else{
				p+="Premium User Account with max 5 transfers a day";
			}
			String id=String.valueOf(a.getAccount_id());
			CheckBookDao ck=new CheckBookDao();
			CheckBook c=ck.getStatus(a.getAccount_id());
			out.println("<div class='col s6'>"+
			        "<div class='card teal darken-1 hoverable'>"+
	          "<div class='card-content white-text'>"+
	            "<span class='card-title'>"+
	          "<b>Account no : </b>"+id+"</span>"+
	            "<p><b class='black-text'>Amount : $</b>"+a.getAmount()+"</p>"+
	          	"<p><b class='black-text'>Account Type : </b>"+t+"</p>"+
	          	"<p><b class='black-text'>Account Creation date : </b>"+a.getCreation_date()+"</p>"+
	          	"<p><b class='black-text'>Account Priviledge type : </b>"+p+"</p>");
	          	if(c!=null){
	          		out.write("<p class='yellow-text'><b>Check book request already exists with delivery date "+c.getDelivery_date()
	          		+" and with status "+c.getRequest_status()+"</b></p>");
	          	}else{
	          		out.write("<p class='yellow-text'>No checkbook request exists</p>");
	          	}
	          out.write("</div>"+"</div>"+"</div>");
	       }
	%>  
      </div><br/>
      <div class="col s2">
      	<a class="btn" onClick="window.print()">Print </a>
      	<ul class="collection with-header">
      	<li class="collection-header"><h4>Quick Links</h4></li>
        	<li class="collection-item">
            <div>
              Transfer Funds<a href="transferForm.jsp" class="secondary-content"
                ><i class="material-icons">forward</i></a
              >
            </div>
          </li>
          <li class="collection-item">
            <div>
              Width draw<a href="transactionForm.jsp" class="secondary-content"
                ><i class="material-icons">credit_card</i></a
              >
            </div>
          </li>
          <li class="collection-item">
            <div>
              Deposit<a href="transactionForm.jsp" class="secondary-content"
                ><i class="material-icons">create_new_folder</i></a
              >
            </div>
          </li>
          <li class="collection-item">
            <div>
              Request CheckBook<a href="checkBookRequestForm.jsp" class="secondary-content"
                ><i class="material-icons">credit_card</i></a
              >
            </div>
          </li>
          <li class="collection-item">
            <div>
              	Change Address<a href="changeAddressForm.jsp" class="secondary-content"
                ><i class="material-icons">forward</i></a
              >
            </div>
          </li>
      </ul>
      </div>
    	<% session.setAttribute("ids", ids);%>
    	<% session.setAttribute("toids", toids); %>
    </div>
	
    <script type="text/javascript" src="js/materialize.min.js"></script>
    <jsp:include page="footer.jsp"></jsp:include>
  </body>
</html>
