<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
 
	<!--Stylesheets-->
	<link href="themes/css/globalstyle.css" rel="stylesheet" type="text/css" />
	<link href="themes/css/registerstyle.css" rel="stylesheet" type="text/css" />

	<!--Script references-->
	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
	<script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?sensor=false&amp;libraries=places"></script>
	<script type="text/javascript" src="themes/js/jquery.geocomplete.js"></script>
	<script type="text/javascript" src="themes/js/logger.js"></script>

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
	<form:form name="login-form" class="login-form panel" action="register.do" onsubmit="return validateForm()" method="POST" modelAttribute="myuser">

		<div class="header">
    		<h1>Registration</h1>
    		<span>Please enter your account details and press the submit button. You will receive an e-mail to verify your account.</span>
    	</div>
    
		<div class="content">
			<form:input path="email" type="email" name="email"  class="input" placeholder="E-mail address" spellcheck="false"/>
    		<form:input path="password" type="password" name="password"  class="input" placeholder="Password" spellcheck="false"/>
    		<form:input path="passwordRepeat" type="password" name="password-repeat" class="input" placeholder="Repeat Password" spellcheck="false"/>
    		<form:input path="firstName" type="text" name="first-name"  class="input" placeholder="First Name" spellcheck="false"/>
    		<form:input path="lastName" type="text" name="last-name"  class="input" placeholder="Last Name" spellcheck="false"/>
    		<form:input path="location" type="text" id="geocomplete"  class="input" placeholder="Home Location" spellcheck="false"/>
    	</div>
    
    	<div class="footer">
    		<input type="submit" name="submit" value="Submit" class="button"/>
    	</div>
    	
    	<script>
      	$(function(){
	        $("#geocomplete").geocomplete({
          		types: ["geocode"]});
      	});
    	</script>

	</form:form>
</div>

<div class="gradient"></div>

</body>
</html>