<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>

	<!--Stylesheets-->
	<link href="themes/css/globalstyle.css" rel="stylesheet" type="text/css" />
	<link href="themes/css/registersuccesstyle.css" rel="stylesheet" type="text/css" />


</head>

<!--Content-->
<body>

<div class="heading">ArtScout</div>
    
<div id="wrapper">
	<form:form class="login-form panel" action="login.do" method="GET">
		<div class="header">
    		<h1>Succes</h1>
    		<span>Your application has been received, your ArtScout account is ready for use. Press "Ok" to return to the login page.</span>
    	</div>
    
    	<div class="footer">
    		<input type="submit" name="submit" value="Ok" class="button" />
    	</div>
    	
	</form:form>
</div>

<div class="gradient"></div>

</body>
</html>