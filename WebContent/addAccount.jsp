<%@page import="com.model.User"%> <%@ page language="java"
contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
    <title>Saarthi Bank</title>
  </head>
  <body>
    <jsp:include page="navbar.jsp"></jsp:include>
    <% User user=(User)session.getAttribute("user"); %>
    <div class="row">
      <div class="col s2"></div>
      <form class="col s8" action="addnewAccountServlet" method="post">
        <div class="row">
          <div class="card-panel deep-purple  lighten-5 ">
            <b>Fill the form below to open another account</b>
          </div>
        </div>
        <div class="row">
          <div class="input-field col s6">
            <input disabled placeholder="Placeholder" name="first_name"
            <%="value='"+user.getFirst_name()+"'" %> type="text"
            class="validate" />
            <label for="first_name">First Name</label>
          </div>
          <div class="input-field col s6">
            <input disabled name="last_name" type="text" class="validate"
            <%="value='"+user.getLast_name()+"'" %>/>
            <label for="last_name">Last Name</label>
          </div>
        </div>
        <div class="row">
          <div class="input-field col s12">
            <input disabled placeholder="Current address only" name="address"
            type="text" class="validate" <%="value='"+user.getAddress()+"'" %>
            />
            <label for="disabled">Address</label>
          </div>
        </div>
        <div class="row">
          <div class="input-field col s12">
            <input disabled placeholder="User name/Log in Name" name="user_name"
            type="text" class="validate" <%="value='"+user.getUser_name()+"'" %>
            />
            <label for="user_name">User Name</label>
          </div>
        </div>
        <div class="row">
          <div class="input-field col s12">
            <input disabled placeholder="Phone Number(+91)" name="ph_no"
            type="text" class="validate" <%="value='"+user.getPhone_number()+"'"
            %> />
            <label for="ph_no">Phone Number</label>
          </div>
        </div>
        <div class="row">
          <div class="input-field col s6">
            <input disabled name="password" type="password" class="validate"
            <%="value='"+user.getPassword()+"'" %> />
            <label for="password">Password</label>
          </div>
          <div class="input-field col s6">
            <input name="re-password" type="password" class="validate"
            <%="value='"+user.getPassword()+"'" %>/>
            <label for="re-password">Re-enter Password</label>
          </div>
        </div>
        <div class="row">
          <div class="input-field col s6">
            <input name="email" type="email" class="validate"
            <%="value='"+user.getEmail()+"'" %>/>
            <label for="email">Email</label>
          </div>
          <div class="input-field col s6">
            <select name="type" class="browser-default">
              <option value="SA">Salary Account</option>
              <option value="SV">Savings Account</option>
            </select>
          </div>
        </div>
        <div class="row">
          <div class="input-field col s12">
            <input name="amount" type="text" class="validate" />
            <label for="amount">Enter Initial Amount</label>
          </div>
        </div>
        <div class="row">
          <button
            class="btn waves-effect waves-light pulse"
            type="submit"
            name="action"
          >
            Submit
            <i class="material-icons right">send</i>
          </button>
        </div>
        <div class="col s2"></div>
      </form>
    </div>
  </body>
</html>
