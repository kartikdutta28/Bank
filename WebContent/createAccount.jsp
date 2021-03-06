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
  <body>
    <jsp:include page="navbar.jsp"></jsp:include>
    <div class="row">
      <div class="col s2"></div>
      <form class="col s8 card blue-grey darken-1 hoverable" action="RegisterServlet" method="post">
        <div class="row">
          <div class="card-panel">
            <b>Fill the form below to open account</b>
          </div>
        </div>
        <div class="row">
          <div class="input-field col s6">
            <i class="material-icons prefix">account_circle</i>
            <input
              placeholder="First Name"
              name="first_name"
              type="text"
              class="validate"
            />
            <label class="black-text" for="first_name">First Name</label>
          </div>
          <div class="input-field col s6">
            <input name="last_name" type="text" class="validate" placeholder="Last Name"/>
            <label class="black-text" for="last_name">Last Name</label>
          </div>
        </div>
        <div class="row">
          <div class="input-field col s12">
            <input
              placeholder="Current address only"
              name="address"
              type="text"
              class="validate"
            />
            <label class="black-text" for="address">Address</label>
          </div>
        </div>
        <div class="row">
          <div class="input-field col s12">
            <input
              placeholder="User name/Log in Name"
              name="user_name"
              type="text"
              class="validate"
            />
            <label class="black-text" for="user_name">User Name</label>
          </div>
        </div>
        <div class="row">
          <div class="input-field col s12">
            <i class="material-icons prefix">phone</i>
            <input
              placeholder="Phone Number(+91)"
              name="ph_no"
              type="text"
              class="validate"
            />
            <label class="black-text" for="ph_no">Phone Number</label>
          </div>
        </div>
        <div class="row">
          <div class="input-field col s6">
            <input
             placeholder="Password goes here"
              name="password"
              type="password"
              class="validate"
              pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
              required
            />
            <label class="black-text" for="password">Password</label>
            <span
              class="helper-text"
              data-error="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters"
              data-success="Valid"
              >Ex John@1234
            </span>
          </div>
        </div>
        <div class="row">
          <div class="input-field col s6">
            <input placeholder="Ex- john@gmail.com" name="email" type="email" class="validate" />
            <label class="black-text" for="email">Email</label>
          </div>
          <div class="input-field col s6">
            <select name="type" class="browser-default">
              <option value="" disabled selected>Choose type of account</option>
              <option value="SA">Salary Account</option>
              <option value="SV">Savings Account</option>
            </select>
          </div>
        </div>
        <div class="row">
          <div class="input-field col s4">
            <select name="utype" class="browser-default">
              <option value="" disabled selected>Select Account user type</option>
              <option value="P">Premium User</option>
              <option value="N">Normal User</option>
            </select>
          </div>
          <div class="col s4 card-panel deep-purple  lighten-5">
   
      			<p>A normal user can do maximum 3 transfers in 24 hours and a premium user can do 5 transfers in 24 hours</p>
    	</div>
    	</div>
    			
        <div class="row">
          <div class="input-field col s12">
            <input placeholder="Initial Balance in $"name="amount" type="text" class="validate" />
            <label class="black-text" for="amount">Enter Initial Amount</label>
          </div>
        </div>
        <div class="row center-align">
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
    <script src="jquery/jquery.min.js"></script>
    <script type="text/javascript" src="js/materialize.min.js"></script>
    <jsp:include page="footer.jsp"></jsp:include>
  </body>
</html>
