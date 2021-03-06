<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<!-----Meta----->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>ArtScout</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
    <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
    <meta name="description" content="ArtScout" />
    <meta name="keywords" content="login form, psd, html, css3, jquery, tutorial" />
    <meta name="author" content="Dzyngiri" />

<!--Scripts-->
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>

<!--Stylesheets-->
<link href="../themes/css/globalstyle.css" rel="stylesheet" type="text/css" />
<link href="../themes/css/loginstyle.css" rel="stylesheet" type="text/css" />

<!--Sliding icons-->
<script type="text/javascript">
$(document).ready(function() {
	$(".username").focus(function() {
		$(".user-icon").css("left","-48px");
	});
	$(".username").blur(function() {
		$(".user-icon").css("left","0px");
	});
	
	$(".password").focus(function() {
		$(".pass-icon").css("left","-48px");
	});
	$(".password").blur(function() {
		$(".pass-icon").css("left","0px");
	});
});
</script>

</head>
<body>

<div class="heading">
   	ArtScout
</div>
    
<div id="wrapper">
    <div class="user-icon"></div>
    <div class="pass-icon"></div>

	<!--Login form-->
	<form:form name="login-form" class="login-form panel" action="add.do" method="POST" modelAttribute="bookerjob">

		<div class="header">
    		<h1>bookerjob</h1>
    		<span>Enter details</span>
    	</div>
    
		<div class="content">
			<form:input path ="Label" name="Label" type="text" class="input Label" placeholder="Label" spellcheck="false"/>
			<form:input path ="Email" name="Email" type="text" class="input Email" placeholder="Email" spellcheck="false"/>
			<form:input path ="Gsm" name="PersonalWebSite" type="Gsm" class="input Gsm" placeholder="Gsm" spellcheck="false"/>
    		<form:input path ="Description" name="Description" type="text" class="input Description" placeholder="Description" spellcheck="false"/>
    		<form:input path ="BookerLocation.Lon" name="longitude" type="text" class="input longitude" placeholder="longitude" spellcheck="false"/>
    		<form:input path ="BookerLocation.Lat" name="latitude" type="text" class="input latitude" placeholder="latitude" spellcheck="false"/>
    		
    	</div>
    
    	<div class="footer">
    		<input type="submit" name="submit" value="savebookerjob" class="button" />
    	</div>
    
	</form:form>
</div>

<div class="gradient"></div>

</body>
</html>