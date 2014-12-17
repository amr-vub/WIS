<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
 
	<!--Stylesheets-->
	<link href="themes/css/globalstyle.css" rel="stylesheet" type="text/css" />
	<link href="themes/css/registerstyle.css" rel="stylesheet" type="text/css" />

	<!--Form validation-->
	<script>
	function validateForm() {
    	var pass1 = document.forms["login-form"]["password"].value;
    	var pass2 = document.forms["login-form"]["password-repeat"].value;
    	if (pass1 != pass2) {
        	alert("Password does not match repeated password");
        	return false;
    	}
	}
	</script>

</head>

<!--Content-->
<body>

<div class="heading">ArtScout</div>
    
<div id="wrapper">
	<form:form name="login-form" class="login-form panel" action="register.do" onsubmit="return validateForm()" method="POST" modelAttribute="user">

		<div class="header">
    		<h1>Registration</h1>
    		<span>Please enter your account details and press the submit button. You will receive an e-mail to verify your account.</span>
    	</div>
    
		<div class="content">
			<form:input path="Email" type="email" name="email"  class="input" placeholder="E-mail address" spellcheck="false"/>
			<form:input path ="fname" name="first-name" type="text" class="input" placeholder="First Name" spellcheck="false"/>
    		<form:input path="lname" type="text" name="last-name"  class="input" placeholder="Last Name" spellcheck="false"/>
    		<form:input path ="UserAuthentication.Username" name="Username" type="text" class="input" placeholder="Username" spellcheck="false"/>
    		<form:input path="UserAuthentication.password" type="password" name="password"  class="input" placeholder="Password" spellcheck="false"/>
     	</div>
    
    	<div class="footer">
    		<input type="submit" name="submit" value="Submit" class="button"/>
    	</div>

	</form:form>
</div>

<div class="gradient"></div>

</body>
</html>