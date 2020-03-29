<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
    <title>Saarthi Bank</title>
  </head>
  <body>
    <jsp:include page="navbar.jsp"></jsp:include>
    <br /><br />
    <div class="row">
      <div class="col s2"></div>
      <form class="col s6" action="checkBookServlet" method="post">
      
        <div class="row">
          <div class="card-panel deep-purple  lighten-5 ">
            <b>Fill the form below to request a check Book</b>
          </div>
        </div>
        <div class="row">
          <div class="right-align input-field col s6">
            <input
              placeholder="Your account id"
              name="account_id"
              type="text"
              class="validate"
            />
            <label for="name">Account Id/Number</label>
          </div>
        </div>
        <div class="row">
          <div class="right-align input-field col s6">
            <input
              placeholder="Current address"
              name="address"
              type="text"
              class="validate"
            />
            <label for="address">Current address</label>
          </div>
        </div>
        <div class="row">
          <button
            class="btn waves-effect waves-light"
            type="submit"
            name="action"
          >
            Request
            <i class="material-icons right">send</i>
          </button>
        </div>
      </form>
    </div>
    <br /><br /><br />
    <jsp:include page="footer.jsp"></jsp:include>
  </body>
</html>
