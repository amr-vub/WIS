<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
 
	<!--Stylesheets-->
	<link href="themes/css/globalstyle.css" rel="stylesheet" type="text/css" />
	<link href="themes/css/loginstyle.css" rel="stylesheet" type="text/css" />

	<!--Script references-->
	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>

</head>

<!--Content-->
<body>
<div class="heading">ArtScout</div>
    
<div id="wrapper">
	<form:form name="login-form" class="login-form panel" action="login.do" method="POST" modelAttribute="myuser">
		
		<div class="header">
    		<h1>Welcome</h1>
    		<span>Please login by entering your e-mail address and password.</span>
    	</div>
    
		<div class="content">
			<form:input path="Username" type="text" name="username" class="input" placeholder="Username" spellcheck="false"/>
    		<form:input path="password" type="password" name="password" class="input" placeholder="Password" spellcheck="false"/>
    	</div>
    
    	<div class="footer">
    		<input type="submit" name="login" value="Login" class="button"/>
    		<input type="submit" name="register" value="Register" class="button" href="/register.do"/>
    	</div>

	</form:form>
</div>

<div class="gradient"></div>
</body>

</html>